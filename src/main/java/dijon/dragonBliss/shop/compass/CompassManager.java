package dijon.dragonBliss.shop.compass;

import dijon.dragonBliss.DragonBliss;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.NamespacedKey;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

import java.util.HashMap;
import java.util.UUID;

public class CompassManager {

    public static void addCompass(Player player, ItemStack itemStack, Player tracked){

        if(!itemStack.hasItemMeta()){
            player.sendMessage(Component.text("This command can only be used on a fresh tracker compass!").color(TextColor.color(0xff0000)));
            player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_DIDGERIDOO, 1, 2);
            return;
        }

        if(!itemStack.getItemMeta().getPersistentDataContainer().has(new NamespacedKey(DragonBliss.instance, "Compass"))){
            player.sendMessage(Component.text("This command can only be used on a fresh tracker compass!").color(TextColor.color(0xff0000)));
            player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_DIDGERIDOO, 1, 2);
            return;
        }

        if(itemStack.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(DragonBliss.instance, "Used"), PersistentDataType.BOOLEAN)){
            player.sendMessage(Component.text("This command can only be used on a fresh tracker compass!").color(TextColor.color(0xff0000)));
            player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_DIDGERIDOO, 1, 2);
            return;
        }

        ItemMeta meta = itemStack.getItemMeta();
        meta.getPersistentDataContainer().set(new NamespacedKey(DragonBliss.instance, "Used"), PersistentDataType.BOOLEAN, true);
        meta.getPersistentDataContainer().set(new NamespacedKey(DragonBliss.instance, "Player"), PersistentDataType.STRING, tracked.getUniqueId().toString());
        meta.getPersistentDataContainer().set(new NamespacedKey(DragonBliss.instance, "Time"), PersistentDataType.LONG, System.currentTimeMillis());
        meta.displayName(Component.text("Tracking | " + tracked.getName()).decoration(TextDecoration.ITALIC, false).color(TextColor.color(0x1FFFBC)));
        meta.setCustomModelData((int) (Math.random() * 10000));
        itemStack.setItemMeta(meta);


    }
}
