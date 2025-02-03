package dijon.dragonBliss.bloodmoon;

import dijon.dragonBliss.DragonBliss;
import dijon.dragonBliss.data.teams.BlissTeam;
import dijon.dragonBliss.data.teams.TeamManager;
import dijon.dragonBliss.shop.ShopItems;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.UUID;

public class BloodMoonHandler implements Listener {

    public static boolean bloodMoonActive = false;

    public BloodMoonHandler() {
        Bukkit.getPluginManager().registerEvents(this, DragonBliss.instance);
    }

    @EventHandler
    public void onSpawn(CreatureSpawnEvent e){

        if(!bloodMoonActive) return;
        LivingEntity livingEntity = e.getEntity();

        if(livingEntity instanceof Creeper c){
            c.setPowered(true);
        }
        if (livingEntity instanceof Zombie zombie) {
            ItemStack sword = new ItemStack(Material.DIAMOND_SWORD);
            sword.addEnchantment(Enchantment.DAMAGE_ALL, 5);
            sword.addEnchantment(Enchantment.FIRE_ASPECT, 2);

            zombie.getEquipment().setItemInMainHand(sword);
            zombie.getEquipment().setItemInMainHandDropChance(0.1f);

            zombie.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, Integer.MAX_VALUE, 1));
        }

        if (livingEntity instanceof Skeleton skeleton) {
            ItemStack bow = new ItemStack(Material.BOW);
            bow.addEnchantment(Enchantment.ARROW_DAMAGE, 5);
            bow.addEnchantment(Enchantment.ARROW_FIRE, 1);

            skeleton.getEquipment().setItemInMainHand(bow);
            skeleton.getEquipment().setItemInMainHandDropChance(0.1f); // 10% drop chance
        }

        if (livingEntity instanceof Spider spider) {
            spider.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, Integer.MAX_VALUE, 0));
            spider.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, Integer.MAX_VALUE, 0));
            spider.setCustomNameVisible(true);
        }


    }


    public static void activateBloodMoon(){
        for(BlissTeam team : TeamManager.getTeamList().values()){
            Set<UUID> players = TeamManager.getActiveOnlinePlayersOnTeam(team);
            if(players.isEmpty()) continue;
            Player choice = Bukkit.getPlayer(getRandomPlayer(players));

            ItemStack tracker = ShopItems.BLOODTRACKER.get();
            ItemMeta meta = tracker.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(DragonBliss.instance, "Time"), PersistentDataType.LONG, System.currentTimeMillis());
            meta.setCustomModelData((int) (Math.random() * 10000));
            tracker.setItemMeta(meta);

            choice.getInventory().addItem(ShopItems.BLOODTRACKER.get());
        }
    }

    private static UUID getRandomPlayer(Set<UUID> set) {
        int randomIndex = new Random().nextInt(set.size());
        Iterator<UUID> iterator = set.iterator();

        for (int i = 0; i < randomIndex; i++) {
            iterator.next();
        }

        return iterator.next();
    }

}
