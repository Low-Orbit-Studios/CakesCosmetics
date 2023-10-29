package net.loworbitstation.cakescosmetics.recipe;

import net.loworbitstation.cakescosmetics.data.constants.Constants;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.SingleItemRecipe;
import net.minecraft.world.level.Level;

import static net.loworbitstation.cakescosmetics.recipe.ModRecipes.*;

public class SewingStationRecipe extends SingleItemRecipe {
    public SewingStationRecipe(ResourceLocation pId, String pGroup, Ingredient pIngredient, ItemStack pResult) {
        super(SEWING_RECIPE_TYPE.get(), SewingRecipeSerializer.INSTANCE, pId, pGroup, pIngredient, pResult);
    }

    @Override
    public boolean matches(Container pContainer, Level pLevel) {
        if (pLevel.isClientSide()) {
            return false;
        }

        return this.ingredient.test(pContainer.getItem(Constants.SEWING_STATION_INPUT_SLOT_INDEX));
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return SEWING_SERIALIZER.get();
    }

    @Override
    public RecipeType<?> getType() {
        return SEWING_RECIPE_TYPE.get();
    }
}
