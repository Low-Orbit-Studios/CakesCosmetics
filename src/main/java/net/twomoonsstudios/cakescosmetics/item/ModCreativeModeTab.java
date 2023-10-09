package net.twomoonsstudios.cakescosmetics.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {
    public static final CreativeModeTab CAKES_COSMETICS_TAB = new CreativeModeTab("cakes_cosmetics_tab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.BANDOLIER.get());
        }
    };
}
