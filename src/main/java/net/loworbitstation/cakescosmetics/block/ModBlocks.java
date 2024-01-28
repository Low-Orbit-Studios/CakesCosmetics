package net.loworbitstation.cakescosmetics.block;

import net.loworbitstation.cakescosmetics.CakesCosmetics;
import net.loworbitstation.cakescosmetics.block.custom.SewingStationBlock;
import net.loworbitstation.cakescosmetics.item.ModCreativeModeTabs;
import net.loworbitstation.cakescosmetics.item.ModItems;
import net.minecraft.client.resources.model.Material;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

import static net.loworbitstation.cakescosmetics.data.constants.Constants.SEWING_STATION_PATH;

public class ModBlocks {
    public final static DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, CakesCosmetics.MOD_ID);

    public static final RegistryObject<Block> SEWING_STATION = registerBlock(SEWING_STATION_PATH,
            () -> new SewingStationBlock(BlockBehaviour.Properties.of().sound(SoundType.WOOD)
                    .strength(6f).requiresCorrectToolForDrops().noOcclusion()));
            ;

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
