package net.loworbitstation.cakescosmetics.block.entity;

import com.mojang.datafixers.types.Type;
import net.loworbitstation.cakescosmetics.CakesCosmetics;
import net.loworbitstation.cakescosmetics.block.ModBlocks;
import net.minecraft.Util;
import net.minecraft.util.datafix.fixes.References;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static net.loworbitstation.cakescosmetics.data.constants.Constants.SEWING_STATION_PATH;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, CakesCosmetics.MOD_ID);

    public static final RegistryObject<BlockEntityType<SewingStationBlockEntity>> SEWING_STATION =
            BLOCK_ENTITIES.register(SEWING_STATION_PATH, () -> BlockEntityType.Builder.of(SewingStationBlockEntity::new,
                        ModBlocks.SEWING_STATION.get()).build(null));
    public static void register(IEventBus eventBus){
        BLOCK_ENTITIES.register(eventBus);
    }
}
