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

    // CHEST
    public static final DeferredItem<VanityArmorItem> ARROW_QUIVER = ITEMS.register("arrow_quiver",
            () -> new ArrowQuiverItem(ModArmorMaterials.VANITY_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().stacksTo(1).setNoRepair()));

    public static final DeferredItem<VanityArmorItem> BANDOLIER = ITEMS.register("bandolier",
            () -> new BandolierItem(ModArmorMaterials.VANITY_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().stacksTo(1).setNoRepair()));

    // FEET

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
