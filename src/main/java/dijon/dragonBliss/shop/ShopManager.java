package dijon.dragonBliss.shop;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;

public class ShopManager {

    public static final Inventory mainShopMenu = Bukkit.createInventory(null, 54, "Shop");

    public static void initialize(){
        createMenu();
    }

    public static void openMainShopMenu(Player player){
        player.openInventory(mainShopMenu);
    }

    private static void createMenu(){
        for(int i=0;i<54;i++){
            mainShopMenu.setItem(i, ShopItems.BLACK.get());
        }

        mainShopMenu.setItem(11, ShopItems.TOTEM.get());
        mainShopMenu.setItem(20, ShopItems.TWOHEARTS.get());
        mainShopMenu.setItem(29, ShopItems.EGAP.get());
        mainShopMenu.setItem(38, ShopItems.RESTOCK.get());

        mainShopMenu.setItem(12, ShopItems.TURTLE.get());

        mainShopMenu.setItem(13, ShopItems.WEBS.get());
        mainShopMenu.setItem(22, ShopItems.TRADERS.get());

        mainShopMenu.setItem(14, ShopItems.GAPS.get());
        mainShopMenu.setItem(23, ShopItems.XP.get());
        mainShopMenu.setItem(32, ShopItems.TRACKER.get());

        mainShopMenu.setItem(15, ShopItems.STPOTION.get());
        mainShopMenu.setItem(24, ShopItems.SPPOTION.get());
        mainShopMenu.setItem(33, ShopItems.FIPOTION.get());

    }


}
