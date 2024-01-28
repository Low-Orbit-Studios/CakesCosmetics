package net.loworbitstation.cakescosmetics.item;

import net.loworbitstation.cakescosmetics.CakesCosmetics;
import net.loworbitstation.cakescosmetics.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final String CAKES_COSMETICS_TAB_ID = "cakes_cosmetics_tab";
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CakesCosmetics.MOD_ID);
    public static final RegistryObject<CreativeModeTab> CAKES_COSMETICS_TAB = CREATIVE_MODE_TABS.register(CAKES_COSMETICS_TAB_ID,
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.BANDOLIER.get()))
                    .title(Component.translatable("creativetab." + CAKES_COSMETICS_TAB_ID))
                    .displayItems((pParameters, pOutput) -> {
                        var blocks = ModBlocks.BLOCKS.getEntries();
                        for(var block : blocks){
                            pOutput.accept(block.get());
                        }

                        var items = ModItems.ITEMS.getEntries();
                        for(var item : items){
                            pOutput.accept(item.get());
                        }
                    })
                    .build());

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
