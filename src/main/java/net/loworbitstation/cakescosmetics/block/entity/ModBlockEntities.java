package net.loworbitstation.cakescosmetics.block.entity;

import net.loworbitstation.cakescosmetics.CakesCosmetics;
import net.loworbitstation.cakescosmetics.block.ModBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, CakesCosmetics.MOD_ID);

    public static final RegistryObject<BlockEntityType<SewingStationBlockEntity>> SEWING_STATION =
            BLOCK_ENTITIES.register("sewing_station", () ->
                    BlockEntityType.Builder.of(SewingStationBlockEntity::new,
                            ModBlocks.SEWING_STATION.get()).build(null));
    public static void register(IEventBus eventBus){
        BLOCK_ENTITIES.register(eventBus);
    }
}
