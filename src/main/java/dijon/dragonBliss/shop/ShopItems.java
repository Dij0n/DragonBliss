package dijon.dragonBliss.shop;

import dijon.dragonBliss.DragonBliss;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.block.ShulkerBox;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BlockStateMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.potion.PotionType;

public enum ShopItems {

    BLACK,
    TOTEM,
    TWOHEARTS,
    EGAP,
    RESTOCK,
    TURTLE,
    WEBS,
    TRADERS,
    GAPS,
    XP,
    TRACKER,
    STPOTION,
    SPPOTION,
    FIPOTION,
    TURTLEITEM,
    STPOTIONITEM,
    SPPOTIONITEM,
    FIPOTIONITEM,
    TRACKERITEM,
    BLOODTRACKER,
    RESTOCKITEM,
    TWOHEARTSITEM;


    public ItemStack itemStack;

    public void setItem(ItemStack itemStack){
        this.itemStack = itemStack;
    }

    public ItemStack get(){
        return itemStack;
    }

    public static void initialize(){
        ItemStack item = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
        ItemMeta meta = item.getItemMeta();
        meta.displayName(Component.text(""));
        item.setItemMeta(meta);
        BLACK.setItem(item);

        item = new ItemStack(Material.TOTEM_OF_UNDYING);
        meta = item.getItemMeta();
        meta.displayName(Component.text("$75 | Totem Of Undying").color(TextColor.color(0xFF2621)).decoration(TextDecoration.ITALIC, false));
        meta.getPersistentDataContainer().set(new NamespacedKey(DragonBliss.instance, "ShopItem"), PersistentDataType.STRING, "Totem");
        meta.getPersistentDataContainer().set(new NamespacedKey(DragonBliss.instance, "Price"), PersistentDataType.INTEGER, 75);
        item.setItemMeta(meta);
        TOTEM.setItem(item);

        item = new ItemStack(Material.HEART_OF_THE_SEA);
        meta = item.getItemMeta();
        meta.displayName(Component.text("$75 | +2 Hearts").color(TextColor.color(0xFF2621)).decoration(TextDecoration.ITALIC, false));
        meta.getPersistentDataContainer().set(new NamespacedKey(DragonBliss.instance, "ShopItem"), PersistentDataType.STRING, "Heart");
        meta.getPersistentDataContainer().set(new NamespacedKey(DragonBliss.instance, "Price"), PersistentDataType.INTEGER, 75);
        item.setItemMeta(meta);
        TWOHEARTS.setItem(item);

        item = new ItemStack(Material.ENCHANTED_GOLDEN_APPLE);
        meta = item.getItemMeta();
        meta.displayName(Component.text("$75 | Enchanted Golden Apple").color(TextColor.color(0xFF2621)).decoration(TextDecoration.ITALIC, false));
        meta.getPersistentDataContainer().set(new NamespacedKey(DragonBliss.instance, "ShopItem"), PersistentDataType.STRING, "EGApples");
        meta.getPersistentDataContainer().set(new NamespacedKey(DragonBliss.instance, "Price"), PersistentDataType.INTEGER, 75);
        item.setItemMeta(meta);
        EGAP.setItem(item);

        item = new ItemStack(Material.SHULKER_BOX);
        meta = item.getItemMeta();
        meta.displayName(Component.text("$75 | Restock Shulker Box").color(TextColor.color(0xFF2621)).decoration(TextDecoration.ITALIC, false));
        meta.getPersistentDataContainer().set(new NamespacedKey(DragonBliss.instance, "ShopItem"), PersistentDataType.STRING, "Restock");
        meta.getPersistentDataContainer().set(new NamespacedKey(DragonBliss.instance, "Price"), PersistentDataType.INTEGER, 75);
        item.setItemMeta(meta);
        RESTOCK.setItem(item);

        item = new ItemStack(Material.POTION);
        PotionMeta pmeta = (PotionMeta) item.getItemMeta();
        pmeta.displayName(Component.text("$50 | Turtle Master").color(TextColor.color(0xFFF32C)).decoration(TextDecoration.ITALIC, false));
        pmeta.setBasePotionType(PotionType.TURTLE_MASTER);
        pmeta.getPersistentDataContainer().set(new NamespacedKey(DragonBliss.instance, "ShopItem"), PersistentDataType.STRING, "Turtle");
        pmeta.getPersistentDataContainer().set(new NamespacedKey(DragonBliss.instance, "Price"), PersistentDataType.INTEGER, 50);
        item.setItemMeta(pmeta);
        TURTLE.setItem(item);

        item = new ItemStack(Material.COBWEB);
        meta = item.getItemMeta();
        meta.displayName(Component.text("$30 | 32 Cobwebs").color(TextColor.color(0x1DFF24)).decoration(TextDecoration.ITALIC, false));
        meta.getPersistentDataContainer().set(new NamespacedKey(DragonBliss.instance, "ShopItem"), PersistentDataType.STRING, "Webs");
        meta.getPersistentDataContainer().set(new NamespacedKey(DragonBliss.instance, "Price"), PersistentDataType.INTEGER, 30);
        item.setItemMeta(meta);
        WEBS.setItem(item);

        item = new ItemStack(Material.IRON_INGOT);
        meta = item.getItemMeta();
        meta.displayName(Component.text("$30 | 2 Traders").color(TextColor.color(0x1DFF24)).decoration(TextDecoration.ITALIC, false));
        meta.getPersistentDataContainer().set(new NamespacedKey(DragonBliss.instance, "ShopItem"), PersistentDataType.STRING, "Traders");
        meta.getPersistentDataContainer().set(new NamespacedKey(DragonBliss.instance, "Price"), PersistentDataType.INTEGER, 30);
        item.setItemMeta(meta);
        TRADERS.setItem(item);

        item = new ItemStack(Material.GOLDEN_APPLE);
        meta = item.getItemMeta();
        meta.displayName(Component.text("$15 | 64 Golden Apples").color(TextColor.color(0x1FFFBC)).decoration(TextDecoration.ITALIC, false));
        meta.getPersistentDataContainer().set(new NamespacedKey(DragonBliss.instance, "ShopItem"), PersistentDataType.STRING, "Gapples");
        meta.getPersistentDataContainer().set(new NamespacedKey(DragonBliss.instance, "Price"), PersistentDataType.INTEGER, 15);
        item.setItemMeta(meta);
        GAPS.setItem(item);

        item = new ItemStack(Material.EXPERIENCE_BOTTLE);
        meta = item.getItemMeta();
        meta.displayName(Component.text("$15 | 64 XP Bottles").color(TextColor.color(0x1FFFBC)).decoration(TextDecoration.ITALIC, false));
        meta.getPersistentDataContainer().set(new NamespacedKey(DragonBliss.instance, "ShopItem"), PersistentDataType.STRING, "XP");
        meta.getPersistentDataContainer().set(new NamespacedKey(DragonBliss.instance, "Price"), PersistentDataType.INTEGER, 15);
        item.setItemMeta(meta);
        XP.setItem(item);

        item = new ItemStack(Material.COMPASS);
        meta = item.getItemMeta();
        meta.displayName(Component.text("$15 | Player Tracker").color(TextColor.color(0x1FFFBC)).decoration(TextDecoration.ITALIC, false));
        meta.getPersistentDataContainer().set(new NamespacedKey(DragonBliss.instance, "ShopItem"), PersistentDataType.STRING, "Compass");
        meta.getPersistentDataContainer().set(new NamespacedKey(DragonBliss.instance, "Price"), PersistentDataType.INTEGER, 15);
        item.setItemMeta(meta);
        TRACKER.setItem(item);

        item = new ItemStack(Material.POTION);
        pmeta = (PotionMeta) item.getItemMeta();
        pmeta.displayName(Component.text("$5 | Strength Potion").color(TextColor.color(0x80402C)).decoration(TextDecoration.ITALIC, false));
        pmeta.setBasePotionType(PotionType.STRENGTH);
        pmeta.getPersistentDataContainer().set(new NamespacedKey(DragonBliss.instance, "ShopItem"), PersistentDataType.STRING, "Strength");
        pmeta.getPersistentDataContainer().set(new NamespacedKey(DragonBliss.instance, "Price"), PersistentDataType.INTEGER, 5);
        item.setItemMeta(pmeta);
        STPOTION.setItem(item);

        item = new ItemStack(Material.POTION);
        pmeta = (PotionMeta) item.getItemMeta();
        pmeta.displayName(Component.text("$5 | Speed Potion").color(TextColor.color(0x80402C)).decoration(TextDecoration.ITALIC, false));
        pmeta.setBasePotionType(PotionType.SPEED);
        pmeta.getPersistentDataContainer().set(new NamespacedKey(DragonBliss.instance, "ShopItem"), PersistentDataType.STRING, "Speed");
        pmeta.getPersistentDataContainer().set(new NamespacedKey(DragonBliss.instance, "Price"), PersistentDataType.INTEGER, 5);
        item.setItemMeta(pmeta);
        SPPOTION.setItem(item);

        item = new ItemStack(Material.POTION);
        pmeta = (PotionMeta) item.getItemMeta();
        pmeta.displayName(Component.text("$5 | Fire Resistance Potion").color(TextColor.color(0x80402C)).decoration(TextDecoration.ITALIC, false));
        pmeta.setBasePotionType(PotionType.FIRE_RESISTANCE);
        pmeta.getPersistentDataContainer().set(new NamespacedKey(DragonBliss.instance, "ShopItem"), PersistentDataType.STRING, "Fire");
        pmeta.getPersistentDataContainer().set(new NamespacedKey(DragonBliss.instance, "Price"), PersistentDataType.INTEGER, 5);
        item.setItemMeta(pmeta);
        FIPOTION.setItem(item);

        item = new ItemStack(Material.POTION);
        pmeta = (PotionMeta) item.getItemMeta();
        pmeta.setBasePotionType(PotionType.TURTLE_MASTER);
        item.setItemMeta(pmeta);
        TURTLEITEM.setItem(item);

        item = new ItemStack(Material.POTION);
        pmeta = (PotionMeta) item.getItemMeta();
        pmeta.setBasePotionType(PotionType.STRENGTH);
        item.setItemMeta(pmeta);
        STPOTIONITEM.setItem(item);

        item = new ItemStack(Material.POTION);
        pmeta = (PotionMeta) item.getItemMeta();
        pmeta.setBasePotionType(PotionType.SPEED);
        item.setItemMeta(pmeta);
        SPPOTIONITEM.setItem(item);

        item = new ItemStack(Material.POTION);
        pmeta = (PotionMeta) item.getItemMeta();
        pmeta.setBasePotionType(PotionType.FIRE_RESISTANCE);
        item.setItemMeta(pmeta);
        FIPOTIONITEM.setItem(item);

        item = new ItemStack(Material.COMPASS);
        meta = item.getItemMeta();
        meta.displayName(Component.text("Player Tracker").color(TextColor.color(0x1FFFBC)).decoration(TextDecoration.ITALIC, false));
        meta.getPersistentDataContainer().set(new NamespacedKey(DragonBliss.instance, "Compass"), PersistentDataType.BOOLEAN, true);
        meta.getPersistentDataContainer().set(new NamespacedKey(DragonBliss.instance, "Used"), PersistentDataType.BOOLEAN, false);
        meta.getPersistentDataContainer().set(new NamespacedKey(DragonBliss.instance, "Player"), PersistentDataType.STRING, "None");
        meta.getPersistentDataContainer().set(new NamespacedKey(DragonBliss.instance, "Time"), PersistentDataType.LONG, 0L);
        item.setItemMeta(meta);
        TRACKERITEM.setItem(item);

        item = new ItemStack(Material.COMPASS);
        meta = item.getItemMeta();
        meta.displayName(Component.text("Blood Moon Tracker").color(TextColor.color(0x1FFFBC)).decoration(TextDecoration.ITALIC, false));
        meta.getPersistentDataContainer().set(new NamespacedKey(DragonBliss.instance, "BloodCompass"), PersistentDataType.BOOLEAN, true);
        meta.getPersistentDataContainer().set(new NamespacedKey(DragonBliss.instance, "Time"), PersistentDataType.LONG, 0L);
        item.setItemMeta(meta);
        BLOODTRACKER.setItem(item);


        RESTOCKITEM.setItem(getRestockShulker());

        item = new ItemStack(Material.HEART_OF_THE_SEA);
        meta = item.getItemMeta();
        meta.displayName(Component.text("+2 Hearts").color(TextColor.color(0xFF2621)).decoration(TextDecoration.ITALIC, false));
        meta.getPersistentDataContainer().set(new NamespacedKey(DragonBliss.instance, "ShopItem"), PersistentDataType.STRING, "HeartItem");
        item.setItemMeta(meta);
        TWOHEARTSITEM.setItem(item);




    }


    private static ItemStack getRestockShulker(){
        ItemStack shulkerBox = new ItemStack(Material.SHULKER_BOX);
        BlockStateMeta meta = (BlockStateMeta) shulkerBox.getItemMeta();
        ShulkerBox box = (ShulkerBox) meta.getBlockState();
        Inventory inv = Bukkit.createInventory(null, 27, "Restock");

        inv.addItem(
                createEnchantedItem(Material.DIAMOND_HELMET,
                        new Enchantment[]{
                                Enchantment.PROTECTION_ENVIRONMENTAL,
                                Enchantment.DURABILITY,
                                Enchantment.MENDING,
                                Enchantment.WATER_WORKER,
                                Enchantment.OXYGEN,
                        },
                        new int[]{3, 3, 1, 1, 3}
                ),
                createEnchantedItem(Material.DIAMOND_CHESTPLATE,
                        new Enchantment[]{
                                Enchantment.PROTECTION_ENVIRONMENTAL,
                                Enchantment.DURABILITY,
                                Enchantment.MENDING
                        },
                        new int[]{3, 3, 1}
                ),
                createEnchantedItem(Material.DIAMOND_LEGGINGS,
                        new Enchantment[]{
                                Enchantment.PROTECTION_ENVIRONMENTAL,
                                Enchantment.DURABILITY,
                                Enchantment.MENDING,
                                Enchantment.SWIFT_SNEAK
                        },
                        new int[]{3, 3, 1, 3}
                ),
                createEnchantedItem(Material.DIAMOND_BOOTS,
                        new Enchantment[]{
                                Enchantment.PROTECTION_ENVIRONMENTAL,
                                Enchantment.DURABILITY,
                                Enchantment.MENDING,
                                Enchantment.WATER_WORKER,
                                Enchantment.PROTECTION_FALL
                        },
                        new int[]{3, 3, 1, 3, 3}
                ),
                createEnchantedItem(Material.DIAMOND_AXE,
                        new Enchantment[]{
                                Enchantment.DAMAGE_ALL,
                                Enchantment.DIG_SPEED,
                                Enchantment.DURABILITY,
                                Enchantment.MENDING
                        },
                        new int[]{5, 5, 3, 3}
                ),
                createEnchantedItem(Material.DIAMOND_SWORD,
                        new Enchantment[]{
                                Enchantment.DAMAGE_ALL,
                                Enchantment.SWEEPING_EDGE,
                                Enchantment.LOOT_BONUS_MOBS,
                                Enchantment.DURABILITY,
                                Enchantment.MENDING
                        },
                        new int[]{5, 3, 3, 3, 1}
                ),
                createEnchantedItem(Material.DIAMOND_PICKAXE,
                        new Enchantment[]{
                                Enchantment.DIG_SPEED,
                                Enchantment.SILK_TOUCH,
                                Enchantment.DURABILITY,
                                Enchantment.MENDING
                        },
                        new int[]{5, 1, 3, 3}
                ),
                createEnchantedItem(Material.BOW,
                        new Enchantment[]{
                                Enchantment.ARROW_DAMAGE,
                                Enchantment.DURABILITY,
                                Enchantment.MENDING
                        },
                        new int[]{3, 3, 1}
                ),
                new ItemStack(Material.EXPERIENCE_BOTTLE, 64),
                new ItemStack(Material.GOLDEN_APPLE, 64),
                new ItemStack(Material.GOLDEN_CARROT, 64),
                new ItemStack(Material.CHORUS_FRUIT, 8),
                new ItemStack(Material.COBWEB, 64),
                new ItemStack(Material.GOLDEN_CARROT, 64),
                new ItemStack(Material.WATER_BUCKET, 1),
                new ItemStack(Material.WATER_BUCKET, 1),
                new ItemStack(Material.ARROW, 64),
                new ItemStack(Material.EXPERIENCE_BOTTLE, 64),
                createPotion(PotionType.LONG_FIRE_RESISTANCE),
                createPotion(PotionType.LONG_FIRE_RESISTANCE),
                createPotion(PotionType.LONG_FIRE_RESISTANCE),
                createPotion(PotionType.LONG_SWIFTNESS),
                createPotion(PotionType.LONG_SWIFTNESS),
                createPotion(PotionType.LONG_SWIFTNESS),
                createPotion(PotionType.LONG_STRENGTH),
                createPotion(PotionType.LONG_STRENGTH),
                createPotion(PotionType.LONG_STRENGTH)
        );

        box.getInventory().setContents(inv.getContents());
        meta.setBlockState(box);
        shulkerBox.setItemMeta(meta);

        return shulkerBox;
    }

    private static ItemStack createEnchantedItem(Material material, Enchantment[] enchants, int[] values) {
        ItemStack item = new ItemStack(material);
        for(int i=0;i<enchants.length;i++){
            item.addUnsafeEnchantment(enchants[i], values[i]);
        }
        return item;
    }
    private static ItemStack createPotion(PotionType potionType) {
        ItemStack item = new ItemStack(Material.POTION);
        PotionMeta meta = (PotionMeta) item.getItemMeta();
        meta.setBasePotionType(potionType);
        return item;
    }

}
