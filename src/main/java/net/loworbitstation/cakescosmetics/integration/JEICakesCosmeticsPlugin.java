package net.loworbitstation.cakescosmetics.integration;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.loworbitstation.cakescosmetics.CakesCosmetics;
import net.loworbitstation.cakescosmetics.recipe.SewingRecipeType;
import net.loworbitstation.cakescosmetics.recipe.SewingStationRecipe;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;

import java.util.Objects;

import static net.loworbitstation.cakescosmetics.recipe.ModRecipes.SEWING_RECIPE_TYPE;

@JeiPlugin
public class JEICakesCosmeticsPlugin implements IModPlugin {
    public static RecipeType<SewingStationRecipe> SEWING_TYPE =
            new RecipeType<>(SewingStationRecipeCategory.UID, SewingStationRecipe.class);



    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(CakesCosmetics.MOD_ID, "jei_plugin");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new
                SewingStationRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        var rm = Objects.requireNonNull(Minecraft.getInstance().level).getRecipeManager();

        var recipesInfusing = rm.getAllRecipesFor(SEWING_RECIPE_TYPE.get());
        registration.addRecipes(SEWING_TYPE, recipesInfusing);
    }
}
