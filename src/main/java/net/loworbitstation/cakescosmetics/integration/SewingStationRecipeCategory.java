package net.loworbitstation.cakescosmetics.integration;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.loworbitstation.cakescosmetics.CakesCosmetics;
import net.loworbitstation.cakescosmetics.block.ModBlocks;
import net.loworbitstation.cakescosmetics.data.constants.Constants;
import net.loworbitstation.cakescosmetics.recipe.SewingStationRecipe;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

import static net.loworbitstation.cakescosmetics.data.constants.Constants.SEWING_STATION_GUI_RES_LOCATION;
import static net.loworbitstation.cakescosmetics.data.constants.Constants.SEWING_STATION_PATH;
import static net.loworbitstation.cakescosmetics.integration.JEICakesCosmeticsPlugin.SEWING_TYPE;

public class SewingStationRecipeCategory implements IRecipeCategory<SewingStationRecipe> {
    public static final int width = 82;
    public static final int height = 34;
    public final static ResourceLocation UID = new ResourceLocation(CakesCosmetics.MOD_ID, "sewing");

    private final IDrawable background;
    private final IDrawable icon;
    public SewingStationRecipeCategory(IGuiHelper helper){
        ResourceLocation location = Constants.RECIPE_GUI_VANILLA_FROM_JEI;
        this.background = helper.createDrawable(location, 0, 220, width, height);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.SEWING_STATION.get()));
    }

    @Override
    public RecipeType<SewingStationRecipe> getRecipeType() {
        return SEWING_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.translatable("block." + CakesCosmetics.MOD_ID + "." + SEWING_STATION_PATH);
    }

    @Override
    public IDrawable getBackground() {
        return background;
    }

    @Override
    public IDrawable getIcon() {
        return this.icon;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, SewingStationRecipe recipe, IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT
                , Constants.SEWING_STATION_INPUT_SLOT_JEI_X
                , Constants.SEWING_STATION_INPUT_SLOT_JEI_Y
        ).addIngredients(recipe.getIngredients().get(0));

        builder.addSlot(RecipeIngredientRole.OUTPUT
                , Constants.SEWING_STATION_OUTPUT_SLOT_JEI_X
                , Constants.SEWING_STATION_OUTPUT_SLOT_JEI_Y
        ).addItemStack(recipe.getResultItem(null));
    }
}
