package dijon.dragonBliss.bloodmoon;

import dijon.dragonBliss.DragonBliss;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.CompassMeta;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.UUID;

public class BloodCompassRunnable extends BukkitRunnable {

    long totalTime = 10000;

    @Override
    public void run() {
        for(Player player : Bukkit.getOnlinePlayers()){

            ArrayList<ItemStack> compasses = getCompassFromInventory(player);

            for(ItemStack item : compasses){
                if(!item.hasItemMeta()) continue;
                if(!item.getItemMeta().getPersistentDataContainer().has(new NamespacedKey(DragonBliss.instance, "BloodCompass"))) continue;

                long time = item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(DragonBliss.instance, "Time"), PersistentDataType.LONG);
                CompassMeta meta = (CompassMeta) item.getItemMeta();

                Player tracked = getClosestPlayer(player);

                meta.setLodestoneTracked(false);
                meta.setLodestone(tracked.getLocation());

                ArrayList<Component> lore = new ArrayList<>();
                lore.add(Component.text(" "));
                lore.add(Component.text("Time remaining: " + convertMilliseconds(totalTime - (System.currentTimeMillis() - time))).color(TextColor.color(0x4E4E4E)));
                lore.add(Component.text(" "));
                meta.lore(lore);

                meta.displayName(Component.text("Tracking | " + tracked.getName()).color(TextColor.color(0x1FFFBC)));

                if(System.currentTimeMillis() - time  > totalTime){
                    meta.getPersistentDataContainer().remove(new NamespacedKey(DragonBliss.instance, "BloodCompass"));
                    meta.displayName(Component.text("Expired Blood Compass").color(TextColor.color(0xff0000)));
                    meta.setLodestone(meta.getLodestone().subtract(meta.getLodestone()));
                }

                item.setItemMeta(meta);
            }
        }
    }

    public static String convertMilliseconds(long milliseconds) {
        long totalSeconds = milliseconds / 1000;
        if(totalSeconds < 0) totalSeconds = 0;

        long minutesL = totalSeconds / 60;
        long secondsL = totalSeconds % 60;

        String minutes;
        String seconds;
        if(minutesL < 10){minutes = "0" + minutesL;}else{minutes = String.valueOf(minutesL);} //Evil scary if statement for strings

        if(secondsL < 10){seconds = "0" + secondsL;}else{seconds = String.valueOf(secondsL);} //Evil scary if statement for strings 2

        return (minutes + ":" + seconds);
    }

    private static Player getClosestPlayer(Player player){

        double distance = 10000000;
        Player current = null;

        for(Player target : Bukkit.getOnlinePlayers()){

            if(!player.getWorld().equals(target.getWorld())) continue;
            if(player.getLocation().distance(target.getLocation()) < distance){
                distance = player.getLocation().distance(target.getLocation());
                current = target;
            }
        }
        return current;
    }

    public ArrayList<ItemStack> getCompassFromInventory(Player player){

        ArrayList<ItemStack> compasses = new ArrayList<>();

        for(ItemStack item : player.getInventory().getContents()){
            if(item == null) continue;
            if(item.getType().equals(Material.COMPASS)){
                if(item.hasItemMeta()){
                    if(item.getItemMeta().getPersistentDataContainer().has(new NamespacedKey(DragonBliss.instance, "BloodCompass"))){
                        compasses.add(item);
                    }
                }
            }
        }
        return compasses;
    }
}
