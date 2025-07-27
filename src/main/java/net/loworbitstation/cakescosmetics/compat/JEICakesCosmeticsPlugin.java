package net.loworbitstation.cakescosmetics.compat;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.loworbitstation.cakescosmetics.CakesCosmetics;
import net.loworbitstation.cakescosmetics.block.ModBlocks;
import net.loworbitstation.cakescosmetics.recipe.ModRecipes;
import net.loworbitstation.cakescosmetics.recipe.SewingTableRecipe;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeManager;

import java.util.List;

@SuppressWarnings("unused")
@MethodsReturnNonnullByDefault

@JeiPlugin
public class JEICakesCosmeticsPlugin implements IModPlugin {
    @Override
    public ResourceLocation getPluginUid() {
        return ResourceLocation.fromNamespaceAndPath(CakesCosmetics.MOD_ID,"jei_plugin");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new SewingTableRecipeCategory(
                registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        assert Minecraft.getInstance().level != null;
        RecipeManager recipeManager = Minecraft.getInstance().level.getRecipeManager();

        List<SewingTableRecipe> sewingTableRecipes = recipeManager
                .getAllRecipesFor(ModRecipes.SEWING_TABLE_TYPE.get()).stream().map(RecipeHolder::value).toList();
        registration.addRecipes(SewingTableRecipeCategory.SEWING_TABLE_RECIPE_RECIPE_TYPE, sewingTableRecipes);
    }

//    @Override
//    public void registerGuiHandlers(IGuiHandlerRegistration registration) {
//        registration.addRecipeClickArea(SewingTableScreen.class, 74, 30, 22, 20,
//                SewingTableRecipeCategory.SEWING_TABLE_RECIPE_RECIPE_TYPE);
//    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
        registration.addRecipeCatalyst(new ItemStack(ModBlocks.SEWING_TABLE.get()),
                SewingTableRecipeCategory.SEWING_TABLE_RECIPE_RECIPE_TYPE);
    }

}
