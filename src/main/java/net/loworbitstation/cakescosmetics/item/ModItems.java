package net.loworbitstation.cakescosmetics.item;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorItem.Type;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.loworbitstation.cakescosmetics.CakesCosmetics;
import net.loworbitstation.cakescosmetics.ModArmorMaterials;

public class ModItems {

    public static DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, CakesCosmetics.MOD_ID);

    //MISC
    public static final RegistryObject<Item> SEWING_KIT = ITEMS.register("sewing_kit",
            () -> new Item(
                    new Item.Properties()
            )
    );

    //HEAD
    public static final RegistryObject<ArmorItem> CAPTAINS_HAT = ITEMS.register("captain_hat",
            () -> new CaptainHatItem(
                    ModArmorMaterials.VANITY_MATERIAL,
                    Type.HELMET,
                    new Item.Properties()
            )
    );
    public static final RegistryObject<ArmorItem> CHRISTMAS_HAT = ITEMS.register("christmas_hat",
            () -> new ChristmasHatItem(
                    ModArmorMaterials.VANITY_MATERIAL,
                    Type.HELMET,
                    new Item.Properties()
            )
    );
    public static final RegistryObject<ArmorItem> COWBOY_HAT = ITEMS.register("cowboy_hat",
            () -> new CowboyHatItem(
                    ModArmorMaterials.VANITY_MATERIAL,
                    Type.HELMET,
                    new Item.Properties()
            )
    );
    public static final RegistryObject<VanityArmorItem> DRAGON_SKULL = ITEMS.register("dragon_skull",
            () -> new DragonSkullItem(
                    ModArmorMaterials.VANITY_MATERIAL,
                    Type.HELMET,
                    new Item.Properties()
            )
    );
    public static final RegistryObject<VanityArmorItem> HORNS = ITEMS.register("horns",
            () -> new HornsItem(
                    ModArmorMaterials.VANITY_MATERIAL,
                    Type.HELMET,
                    new Item.Properties()
            )
    );
    public static final RegistryObject<VanityArmorItem> PIRATE_HAT = ITEMS.register("pirate_hat",
            () -> new PirateHatItem(
                    ModArmorMaterials.VANITY_MATERIAL,
                    Type.HELMET,
                    new Item.Properties()
            )
    );
    public static final RegistryObject<VanityArmorItem> SKULL = ITEMS.register("skull",
            () -> new SkullItem(
                    ModArmorMaterials.VANITY_MATERIAL,
                    Type.HELMET,
                    new Item.Properties()
            )
    );
    public static final RegistryObject<VanityArmorItem> SOMBRERO = ITEMS.register("sombrero",
            () -> new SombreroItem(
                    ModArmorMaterials.VANITY_MATERIAL,
                    Type.HELMET,
                    new Item.Properties()
            )
    );
    public static final RegistryObject<VanityArmorItem> TOP_HAT = ITEMS.register("top_hat",
            () -> new TopHatItem(
                    ModArmorMaterials.VANITY_MATERIAL,
                    Type.HELMET,
                    new Item.Properties()
            )
    );
    public static final RegistryObject<VanityArmorItem> STRAW_HAT = ITEMS.register("straw_hat",
            () -> new StrawHatItem(
                    ModArmorMaterials.VANITY_MATERIAL,
                    Type.HELMET,
                    new Item.Properties()
            )
    );

    public static final RegistryObject<VanityArmorItem> WIZARDS_HAT = ITEMS.register("wizards_hat",
            () -> new WizardsHatItem(
                    ModArmorMaterials.VANITY_MATERIAL,
                    Type.HELMET,
                    new Item.Properties()
            )
    );

    //CHEST
    public static final RegistryObject<VanityArmorItem> ARROW_QUIVER = ITEMS.register("arrow_quiver",
            () -> new ArrowQuiverItem(
                    ModArmorMaterials.VANITY_MATERIAL,
                    Type.CHESTPLATE,
                    new Item.Properties()
            )
    );
    public static final RegistryObject<VanityArmorItem> BANDOLIER = ITEMS.register("bandolier",
            () -> new BandolierItem(
                ModArmorMaterials.VANITY_MATERIAL,
                Type.CHESTPLATE,
                new Item.Properties()
            )
        );
    public static final RegistryObject<VanityArmorItem> HOLSTERED_BELT = ITEMS.register("holstered_belt",
            () -> new HolsteredBeltItem(
                    ModArmorMaterials.VANITY_MATERIAL,
                    Type.CHESTPLATE,
                    new Item.Properties()
            )
    );
    public static final RegistryObject<VanityArmorItem> WINGS = ITEMS.register("wings",
            () -> new WingsItem(
                    ModArmorMaterials.VANITY_MATERIAL,
                    Type.CHESTPLATE,
                    new Item.Properties()
            )
    );


    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
