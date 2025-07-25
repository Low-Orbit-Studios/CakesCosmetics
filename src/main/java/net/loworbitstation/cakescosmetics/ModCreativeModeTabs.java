package net.loworbitstation.cakescosmetics;

import net.loworbitstation.cakescosmetics.block.ModBlocks;
import net.loworbitstation.cakescosmetics.item.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CakesCosmetics.MOD_ID);

    public static final Supplier<CreativeModeTab> CAKES_COSMETICS_TAB = CREATIVE_MODE_TAB.register("cakes_cosmetics_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.CAKEMAN_PLUSHIE.get()))
                    .title(Component.translatable("creativetab.cakes_cosmetics_tab"))
                    .displayItems((itemDisplayParameters, output) -> {

                        var blocks = ModBlocks.BLOCKS.getEntries();
                        for(var block : blocks){
                            output.accept(block.get());
                        }
                        var items = ModItems.ITEMS.getEntries();
                        for(var item : items){
                            output.accept(item.get());
                        }

                    }).build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
