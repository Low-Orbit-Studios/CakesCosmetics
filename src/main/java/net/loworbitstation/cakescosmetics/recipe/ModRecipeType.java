package net.loworbitstation.cakescosmetics.recipe;

import net.loworbitstation.cakescosmetics.recipe.SewingStationRecipe;
import net.minecraft.world.item.crafting.RecipeType;

public class ModRecipeType implements RecipeType<SewingStationRecipe> {
    private ModRecipeType() {};
    public static final ModRecipeType INSTANCE = new ModRecipeType();
    public static final String ID = "sewing";

    public static final RecipeType<SewingStationRecipe> SEWING = RecipeType.register(ID);
}
