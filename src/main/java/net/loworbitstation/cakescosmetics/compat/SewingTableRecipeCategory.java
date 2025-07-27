package net.loworbitstation.cakescosmetics.compat;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.loworbitstation.cakescosmetics.CakesCosmetics;
import net.loworbitstation.cakescosmetics.block.ModBlocks;
import net.loworbitstation.cakescosmetics.recipe.SewingTableRecipe;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;


public class SewingTableRecipeCategory implements IRecipeCategory<SewingTableRecipe> {
    public static final ResourceLocation UID = ResourceLocation.fromNamespaceAndPath(CakesCosmetics.MOD_ID,"sewing");
    public static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(CakesCosmetics.MOD_ID,
            "textures/gui/container/sewing_table_jei.png");

    public static final RecipeType<SewingTableRecipe> SEWING_TABLE_RECIPE_RECIPE_TYPE =
            new RecipeType<>(UID, SewingTableRecipe.class);

    private final IDrawable background;
    private final IDrawable icon;

    public SewingTableRecipeCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE,0, 0, 88, 35);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.SEWING_TABLE));
    }

    @Override
    public RecipeType<SewingTableRecipe> getRecipeType() {
        return SEWING_TABLE_RECIPE_RECIPE_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.translatable("jei.cakescosmetics.sewing");
    }

    @Override
    public @Nullable IDrawable getIcon() {
        return icon;
    }

    @Override
    public @Nullable IDrawable getBackground() {
        return background;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, SewingTableRecipe recipe, IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, 10, 10).addIngredients(recipe.getIngredients().get(0));

        builder.addSlot(RecipeIngredientRole.OUTPUT, 60, 10).addItemStack(recipe.getResultItem(null));
    }

    @Override
    public void draw(SewingTableRecipe recipe, IRecipeSlotsView recipeSlotsView,
                     GuiGraphics guiGraphics, double mouseX, double mouseY) {
        IRecipeCategory.super.draw(recipe, recipeSlotsView, guiGraphics, mouseX, mouseY);
        background.draw(guiGraphics);
    }
}
