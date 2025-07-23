package net.loworbitstation.cakescosmetics.item;

import net.loworbitstation.cakescosmetics.CakesCosmetics;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.awt.event.InputEvent;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(CakesCosmetics.MOD_ID);

    // MISC
    public static final DeferredItem<Item> SEWING_KIT = ITEMS.register("sewing_kit",
            () -> new Item(new Item.Properties()));

    // HEAD

    // CHEST

    // FEET

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
