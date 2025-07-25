package net.loworbitstation.cakescosmetics.block.entity;

import net.loworbitstation.cakescosmetics.CakesCosmetics;
import net.loworbitstation.cakescosmetics.block.ModBlocks;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, CakesCosmetics.MOD_ID);

    public static final Supplier<BlockEntityType<SewingTableBlockEntity>> SEWING_TABLE_BE =
            BLOCK_ENTITIES.register("sewing_table_be", () -> BlockEntityType.Builder.of(
                    SewingTableBlockEntity::new, ModBlocks.SEWING_TABLE.get()).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }


}
