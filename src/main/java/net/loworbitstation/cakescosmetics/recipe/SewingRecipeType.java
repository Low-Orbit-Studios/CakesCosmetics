package net.loworbitstation.cakescosmetics.recipe;

import net.minecraft.world.item.crafting.RecipeType;

import static net.loworbitstation.cakescosmetics.data.constants.Constants.SEWING_SERIALIZER_PATH;

public class SewingRecipeType implements RecipeType<SewingStationRecipe> {
    //private SewingRecipeType() {};
    public static final SewingRecipeType INSTANCE = new SewingRecipeType();
    public static final String ID = SEWING_SERIALIZER_PATH;

    //public static final RecipeType<SewingStationRecipe> SEWING = RecipeType.register(ID);
}
