package net.loworbitstation.cakescosmetics.item;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.loworbitstation.cakescosmetics.CakesCosmetics;
import net.loworbitstation.cakescosmetics.ModArmorMaterials;

public class ModItems {

    public static DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, CakesCosmetics.MOD_ID);

    //HEAD
    public static final RegistryObject<Item> CAPTAINS_HAT = ITEMS.register("captains_hat",
            () -> new ArmorItem(
                    ModArmorMaterials.VANITY_MATERIAL,
                    EquipmentSlot.HEAD,
                    new Item.Properties().tab(ModCreativeModeTab.CAKES_COSMETICS_TAB)
            )
    );
    public static final RegistryObject<Item> COWBOY_HAT = ITEMS.register("cowboy_hat",
            () -> new ArmorItem(
                    ModArmorMaterials.VANITY_MATERIAL,
                    EquipmentSlot.HEAD,
                    new Item.Properties().tab(ModCreativeModeTab.CAKES_COSMETICS_TAB)
            )
    );
    public static final RegistryObject<Item> HORNS = ITEMS.register("horns",
            () -> new ArmorItem(
                    ModArmorMaterials.VANITY_MATERIAL,
                    EquipmentSlot.HEAD,
                    new Item.Properties().tab(ModCreativeModeTab.CAKES_COSMETICS_TAB)
            )
    );
    public static final RegistryObject<Item> SOMBRERO = ITEMS.register("sombrero",
            () -> new ArmorItem(
                    ModArmorMaterials.VANITY_MATERIAL,
                    EquipmentSlot.HEAD,
                    new Item.Properties().tab(ModCreativeModeTab.CAKES_COSMETICS_TAB)
            )
    );
    public static final RegistryObject<Item> TOP_HAT = ITEMS.register("top_hat",
            () -> new ArmorItem(
                    ModArmorMaterials.VANITY_MATERIAL,
                    EquipmentSlot.HEAD,
                    new Item.Properties().tab(ModCreativeModeTab.CAKES_COSMETICS_TAB)
            )
    );

    //CHEST
    public static final RegistryObject<Item> BANDOLIER = ITEMS.register("bandolier",
            () -> new VanityArmorItem(
                ModArmorMaterials.VANITY_MATERIAL,
                EquipmentSlot.CHEST,
                new Item.Properties().tab(ModCreativeModeTab.CAKES_COSMETICS_TAB)
            )
        );
    public static final RegistryObject<Item> HOLSTERED_BELT = ITEMS.register("holstered_belt",
            () -> new ArmorItem(
                    ModArmorMaterials.VANITY_MATERIAL,
                    EquipmentSlot.CHEST,
                    new Item.Properties().tab(ModCreativeModeTab.CAKES_COSMETICS_TAB)
            )
    );

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
