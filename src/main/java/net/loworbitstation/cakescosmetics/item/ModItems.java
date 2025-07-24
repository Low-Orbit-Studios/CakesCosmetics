package net.loworbitstation.cakescosmetics.item;

import net.loworbitstation.cakescosmetics.CakesCosmetics;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(CakesCosmetics.MOD_ID);

    // MISC
    public static final DeferredItem<Item> SEWING_KIT = ITEMS.register("sewing_kit",
            () -> new Item(new Item.Properties()));

    // HEAD
    public static final DeferredItem<VanityArmorItem> COWBOY_HAT = ITEMS.register("cowboy_hat",
            () -> new CowboyHatItem(ModArmorMaterials.VANITY_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
                    new Item.Properties().stacksTo(1).setNoRepair()));

    public static final DeferredItem<VanityArmorItem> CAKEMAN_PLUSHIE = ITEMS.register("cakeman_plushie",
            () -> new CakemanPlushieItem(ModArmorMaterials.VANITY_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
                    new Item.Properties().stacksTo(1).setNoRepair()));

    public static final DeferredItem<VanityArmorItem> CAPTAIN_HAT = ITEMS.register("captain_hat",
            () -> new CaptainHatItem(ModArmorMaterials.VANITY_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
                    new Item.Properties().stacksTo(1).setNoRepair()));

    public static final DeferredItem<VanityArmorItem> CHRISTMAS_HAT = ITEMS.register("christmas_hat",
            () -> new ChristmasHatItem(ModArmorMaterials.VANITY_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
                    new Item.Properties().stacksTo(1).setNoRepair()));

    public static final DeferredItem<VanityArmorItem> CROWN = ITEMS.register("crown",
            () -> new CrownItem(ModArmorMaterials.VANITY_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
                    new Item.Properties().stacksTo(1).setNoRepair()));

    public static final DeferredItem<VanityArmorItem> DRAGON_SKULL = ITEMS.register("dragon_skull",
            () -> new DragonSkullItem(ModArmorMaterials.VANITY_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
                    new Item.Properties().stacksTo(1).setNoRepair()));

    public static final DeferredItem<VanityArmorItem> HORNS = ITEMS.register("horns",
            () -> new HornsItem(ModArmorMaterials.VANITY_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
                    new Item.Properties().stacksTo(1).setNoRepair()));

    public static final DeferredItem<VanityArmorItem> KASA_HAT = ITEMS.register("kasa_hat",
            () -> new KasaHatItem(ModArmorMaterials.VANITY_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
                    new Item.Properties().stacksTo(1).setNoRepair()));

    public static final DeferredItem<VanityArmorItem> PICKELHAUBE = ITEMS.register("pickelhaube",
            () -> new PickelhaubeItem(ModArmorMaterials.VANITY_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
                    new Item.Properties().stacksTo(1).setNoRepair()));

    public static final DeferredItem<VanityArmorItem> PIRATE_HAT = ITEMS.register("pirate_hat",
            () -> new PirateHatItem(ModArmorMaterials.VANITY_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
                    new Item.Properties().stacksTo(1).setNoRepair()));

    public static final DeferredItem<VanityArmorItem> PUMPKIN_HAT = ITEMS.register("pumpkin_hat",
            () -> new PumpkinHatItem(ModArmorMaterials.VANITY_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
                    new Item.Properties().stacksTo(1).setNoRepair()));

    public static final DeferredItem<VanityArmorItem> SKULL = ITEMS.register("skull",
            () -> new SkullItem(ModArmorMaterials.VANITY_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
                    new Item.Properties().stacksTo(1).setNoRepair()));

    public static final DeferredItem<VanityArmorItem> SOMBRERO = ITEMS.register("sombrero",
            () -> new SombreroItem(ModArmorMaterials.VANITY_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
                    new Item.Properties().stacksTo(1).setNoRepair()));

    public static final DeferredItem<VanityArmorItem> STRAW_HAT = ITEMS.register("straw_hat",
            () -> new StrawHatItem(ModArmorMaterials.VANITY_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
                    new Item.Properties().stacksTo(1).setNoRepair()));

    public static final DeferredItem<VanityArmorItem> TOP_HAT = ITEMS.register("top_hat",
            () -> new TopHatItem(ModArmorMaterials.VANITY_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
                    new Item.Properties().stacksTo(1).setNoRepair()));

    public static final DeferredItem<VanityArmorItem> TOP_HAT_HAT = ITEMS.register("top_hat_hat",
            () -> new TopHatHatItem(ModArmorMaterials.VANITY_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
                    new Item.Properties().stacksTo(1).setNoRepair()));

    public static final DeferredItem<VanityArmorItem> WIZARDS_HAT = ITEMS.register("wizards_hat",
            () -> new WizardsHatItem(ModArmorMaterials.VANITY_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
                    new Item.Properties().stacksTo(1).setNoRepair()));


    // CHEST
    public static final DeferredItem<VanityArmorItem> ARROW_QUIVER = ITEMS.register("arrow_quiver",
            () -> new ArrowQuiverItem(ModArmorMaterials.VANITY_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().stacksTo(1).setNoRepair()));

    public static final DeferredItem<VanityArmorItem> BANDOLIER = ITEMS.register("bandolier",
            () -> new BandolierItem(ModArmorMaterials.VANITY_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().stacksTo(1).setNoRepair()));

    public static final DeferredItem<VanityArmorItem> HOLSTERED_BELT = ITEMS.register("holstered_belt",
            () -> new HolsteredBeltItem(ModArmorMaterials.VANITY_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().stacksTo(1).setNoRepair()));

    public static final DeferredItem<VanityArmorItem> SHEATHED_KATANA = ITEMS.register("sheathed_katana",
            () -> new SheathedKatanaItem(ModArmorMaterials.VANITY_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().stacksTo(1).setNoRepair()));

    public static final DeferredItem<VanityArmorItem> WINGS = ITEMS.register("wings",
            () -> new WingsItem(ModArmorMaterials.VANITY_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().stacksTo(1).setNoRepair()));

    // FEET
    public static final DeferredItem<VanityArmorItem> HERMES_BOOTS = ITEMS.register("hermes_boots",
            () -> new HermesBootsItem(ModArmorMaterials.VANITY_ARMOR_MATERIAL, ArmorItem.Type.BOOTS,
                    new Item.Properties().stacksTo(1).setNoRepair()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
