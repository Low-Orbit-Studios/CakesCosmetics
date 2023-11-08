package net.loworbitstation.cakescosmetics.item;

import net.loworbitstation.cakescosmetics.entity.armor.TopHatModel;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.StonecutterBlock;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.loworbitstation.cakescosmetics.CakesCosmetics;
import net.loworbitstation.cakescosmetics.ModArmorMaterials;

public class ModItems {

    public static DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, CakesCosmetics.MOD_ID);

    //MISC
    public static final RegistryObject<Item> COSMETICS_TEMPLATE = ITEMS.register("cosmetics_template",
            () -> new Item(
                    new Item.Properties().tab(ModCreativeModeTab.CAKES_COSMETICS_TAB)
            )
    );

    //HEAD
    public static final RegistryObject<VanityArmorItem> CAPTAINS_HAT = ITEMS.register("captain_hat",
            () -> new CaptainHatItem(
                    ModArmorMaterials.VANITY_MATERIAL,
                    EquipmentSlot.HEAD,
                    new Item.Properties().tab(ModCreativeModeTab.CAKES_COSMETICS_TAB)
            )
    );
    public static final RegistryObject<VanityArmorItem> COWBOY_HAT = ITEMS.register("cowboy_hat",
            () -> new CowboyHatItem(
                    ModArmorMaterials.VANITY_MATERIAL,
                    EquipmentSlot.HEAD,
                    new Item.Properties().tab(ModCreativeModeTab.CAKES_COSMETICS_TAB)
            )
    );
    public static final RegistryObject<VanityArmorItem> HORNS = ITEMS.register("horns",
            () -> new HornsItem(
                    ModArmorMaterials.VANITY_MATERIAL,
                    EquipmentSlot.HEAD,
                    new Item.Properties().tab(ModCreativeModeTab.CAKES_COSMETICS_TAB)
            )
    );
    public static final RegistryObject<VanityArmorItem> SOMBRERO = ITEMS.register("sombrero",
            () -> new SombreroItem(
                    ModArmorMaterials.VANITY_MATERIAL,
                    EquipmentSlot.HEAD,
                    new Item.Properties().tab(ModCreativeModeTab.CAKES_COSMETICS_TAB)
            )
    );
    public static final RegistryObject<VanityArmorItem> TOP_HAT = ITEMS.register("top_hat",
            () -> new TopHatItem(
                    ModArmorMaterials.VANITY_MATERIAL,
                    EquipmentSlot.HEAD,
                    new Item.Properties().tab(ModCreativeModeTab.CAKES_COSMETICS_TAB)
            )
    );
    public static final RegistryObject<VanityArmorItem> STRAW_HAT = ITEMS.register("straw_hat",
            () -> new StrawHatItem(
                    ModArmorMaterials.VANITY_MATERIAL,
                    EquipmentSlot.HEAD,
                    new Item.Properties().tab(ModCreativeModeTab.CAKES_COSMETICS_TAB)
            )
    );
    public static final RegistryObject<VanityArmorItem> WIZARDS_HAT = ITEMS.register("wizards_hat",
            () -> new WizardsHatItem(
                    ModArmorMaterials.VANITY_MATERIAL,
                    EquipmentSlot.HEAD,
                    new Item.Properties().tab(ModCreativeModeTab.CAKES_COSMETICS_TAB)
            )
    );

    //CHEST
    public static final RegistryObject<VanityArmorItem> BANDOLIER = ITEMS.register("bandolier",
            () -> new BandolierItem(
                ModArmorMaterials.VANITY_MATERIAL,
                EquipmentSlot.CHEST,
                new Item.Properties().tab(ModCreativeModeTab.CAKES_COSMETICS_TAB)
            )
        );
    public static final RegistryObject<VanityArmorItem> HOLSTERED_BELT = ITEMS.register("holstered_belt",
            () -> new HolsteredBeltItem(
                    ModArmorMaterials.VANITY_MATERIAL,
                    EquipmentSlot.LEGS,
                    new Item.Properties().tab(ModCreativeModeTab.CAKES_COSMETICS_TAB)
            )
    );


    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
