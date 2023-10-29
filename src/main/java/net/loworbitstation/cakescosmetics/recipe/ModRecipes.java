package net.loworbitstation.cakescosmetics.recipe;

import net.loworbitstation.cakescosmetics.CakesCosmetics;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static net.loworbitstation.cakescosmetics.data.constants.Constants.SEWING_SERIALIZER_PATH;

public class ModRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS
            = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, CakesCosmetics.MOD_ID);

    public static final RegistryObject<RecipeSerializer<SewingStationRecipe>> SEWING_SERIALIZER
            = SERIALIZERS.register(SEWING_SERIALIZER_PATH, () -> SewingRecipeSerializer.INSTANCE);



    public static final DeferredRegister<RecipeType<?>> RECIPE_TYPES
            = DeferredRegister.create(ForgeRegistries.RECIPE_TYPES, CakesCosmetics.MOD_ID);

    public static final RegistryObject<RecipeType<SewingStationRecipe>> SEWING_RECIPE_TYPE
            = RECIPE_TYPES.register(SEWING_SERIALIZER_PATH, () -> SewingRecipeType.INSTANCE);

    public static void registerForSerializers(IEventBus eventBus){
        SERIALIZERS.register(eventBus);
    }
    public static void registerForRecipeTypes(IEventBus eventBus) { RECIPE_TYPES.register(eventBus); }
}
