package dijon.dragonBliss.shop;

import dijon.dragonBliss.DragonBliss;
import dijon.dragonBliss.data.players.PlayerDataManager;
import dijon.dragonBliss.data.teams.TeamManager;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;

import javax.print.DocFlavor;
import java.util.Arrays;
import java.util.UUID;

public class ShopListener implements Listener {

    public ShopListener() {
        Bukkit.getPluginManager().registerEvents(this, DragonBliss.instance);
    }

    @EventHandler
    public void inventoryClick(InventoryClickEvent e){
        if(!e.getInventory().equals(ShopManager.mainShopMenu)) return;

        e.setCancelled(true);

        Player player = (Player) e.getWhoClicked();

        ItemStack item = e.getCurrentItem();
        if(item == null) return;
        if(!item.getItemMeta().getPersistentDataContainer().has(new NamespacedKey(DragonBliss.instance, "ShopItem"))) return;

        String name = item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(DragonBliss.instance, "ShopItem"), PersistentDataType.STRING);
        int price = item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(DragonBliss.instance, "Price"), PersistentDataType.INTEGER);

        if(PlayerDataManager.getBalance(player.getUniqueId()) < price){
            player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_DIDGERIDOO, 0.75F, 1);
            return;
        }

        ItemStack newItem = giveItem(name);

        player.getInventory().addItem(newItem);

        TeamManager.addBalanceEvenlyAcrossTeam(TeamManager.getTeamOfPlayer(player), -price);

        Component c1 = Component.text(player.getName()).color(TextColor.color(0xffff00));
        Component c2 = Component.text(" just spent ").color(TextColor.color(0xFF4033));
        Component c3 = Component.text("$" + price).color(TextColor.color(0xffff00));
        Component c4 = Component.text(" at the shop! Your team's remaining balance is ").color(TextColor.color(0xFF4033));
        Component c5 = Component.text("$" + TeamManager.getTotalTeamValue(TeamManager.getTeamOfPlayer(player))).color(TextColor.color(0xffff00));

        TeamManager.sendMessageToTeam(TeamManager.getTeamOfPlayer(player), c1.append(c2.append(c3.append(c4.append(c5)))));

        player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_BIT, 1, 1);
    }

    private ItemStack giveItem(String name){
        return switch (name){
            case "Totem" -> new ItemStack(Material.TOTEM_OF_UNDYING);
            case "Heart" -> new ItemStack(Material.HEART_OF_THE_SEA);
            case "EGApples" -> new ItemStack(Material.ENCHANTED_GOLDEN_APPLE);
            case "Restock" -> new ItemStack(Material.SHULKER_BOX);
            case "Turtle" -> ShopItems.TURTLEITEM.get();
            case "Webs" -> new ItemStack(Material.COBWEB, 32);
            case "Traders" -> new ItemStack(Material.IRON_INGOT, 2);
            case "Gapples" -> new ItemStack(Material.GOLDEN_APPLE, 64);
            case "XP" -> new ItemStack(Material.EXPERIENCE_BOTTLE, 64);
            case "Compass" -> ShopItems.TRACKERITEM.get();
            case "Strength" -> ShopItems.STPOTIONITEM.get();
            case "Speed" -> ShopItems.SPPOTIONITEM.get();
            case "Fire" -> ShopItems.FIPOTIONITEM.get();
            default -> ShopItems.SPPOTION.get();
        };
    }

    private static int[] divideEvenly(int number, int parts) { //Copied code because I am so so so very lazy look at me woooow hi pro wsg
        int baseValue = number / parts;
        int remainder = number % parts;
        int[] result = new int[parts];

        Arrays.fill(result, baseValue);

        for (int i = 0; i < remainder; i++) {
            result[i] += 1;
        }

        return result;
    }

}
