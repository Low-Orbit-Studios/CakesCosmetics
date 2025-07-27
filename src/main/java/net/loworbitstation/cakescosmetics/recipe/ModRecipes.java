package net.loworbitstation.cakescosmetics.recipe;

import net.loworbitstation.cakescosmetics.CakesCosmetics;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(Registries.RECIPE_SERIALIZER, CakesCosmetics.MOD_ID);
    public static final DeferredRegister<RecipeType<?>> TYPES =
            DeferredRegister.create(Registries.RECIPE_TYPE, CakesCosmetics.MOD_ID);

    public static final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<SewingTableRecipe>> SEWING_TABLE_SERIALIZER =
            SERIALIZERS.register("sewing", SewingTableRecipe.Serializer::new);

    public static final DeferredHolder<RecipeType<?>, RecipeType<SewingTableRecipe>> SEWING_TABLE_TYPE =
            TYPES.register("sewing", () -> new RecipeType<>() {
                @Override
                public String toString() {
                    return "sewing";
                }
            });


    public static void register(IEventBus eventBus) {
        SERIALIZERS.register(eventBus);
        TYPES.register(eventBus);
    }
}
