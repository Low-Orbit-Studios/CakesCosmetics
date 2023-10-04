package net.twomoonsstudios.moonscosmetics.item;

import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.twomoonsstudios.moonscosmetics.MoonsCosmetics;

public class ModItems {

    public static DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MoonsCosmetics.MOD_ID);

    //public static final Item BANDOLIER = ITEMS.register("bandolier", () -> new ArmorItem(new Item.Properties().tab(MoonsCosmetics.COSMETICS_TAB)));
    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
