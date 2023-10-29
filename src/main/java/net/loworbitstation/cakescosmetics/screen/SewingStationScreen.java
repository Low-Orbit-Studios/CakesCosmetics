package net.loworbitstation.cakescosmetics.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.loworbitstation.cakescosmetics.CakesCosmetics;
import net.loworbitstation.cakescosmetics.recipe.SewingStationRecipe;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.crafting.StonecutterRecipe;

import java.util.List;

public class SewingStationScreen extends AbstractContainerScreen<SewingStationMenu> {
    private static final ResourceLocation TEXTURE =
            new ResourceLocation(CakesCosmetics.MOD_ID,"textures/gui/container/sewing_station_gui.png");

    //From StonecutterScreen.java
    private boolean displayRecipes;
    private float scrollOffset;
    /**
     * The index of the first recipe to display.
     * The number of recipes displayed at any time is 12 (4 recipes per row, and 3 rows). If the player scrolled down one
     * row, this value would be 4 (representing the index of the first slot on the second row).
     */
    private int startIndex;
    //
    public SewingStationScreen(SewingStationMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);

    }

    @Override
    protected void init() {
        super.init();
    }

    //From StonecutterScreen.java
    @Override
    protected void renderBg(PoseStack pPoseStack, float pPartialTick, int pMouseX, int pMouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        this.blit(pPoseStack, x, y, 0,0,imageWidth, imageHeight);

        int k = (int)(41.0F * this.scrollOffset);
        this.blit(pPoseStack, x + 119, y + 15 + k, 176 + (this.isScrollBarActive() ? 0 : 12), 0, 12, 15);
        int l = this.leftPos + 52;
        int i1 = this.topPos + 14;
        int j1 = this.startIndex + 12;
        this.renderButtons(pPoseStack, pMouseX, pMouseY, l, i1, j1);
        this.renderRecipes(l, i1, j1);
    }
    //From StonecutterScreen.java
    private void renderButtons(PoseStack pPoseStack, int pMouseX, int pMouseY, int pX, int pY, int pLastVisibleElementIndex) {
        for(int i = this.startIndex; i < pLastVisibleElementIndex && i < this.menu.getNumRecipes(); ++i) {
            int j = i - this.startIndex;
            int k = pX + j % 4 * 16;
            int l = j / 4;
            int i1 = pY + l * 18 + 2;
            int j1 = this.imageHeight;
            if (i == this.menu.getSelectedRecipeIndex()) {
                j1 += 18;
            } else if (pMouseX >= k && pMouseY >= i1 && pMouseX < k + 16 && pMouseY < i1 + 18) {
                j1 += 36;
            }

            this.blit(pPoseStack, k, i1 - 1, 0, j1, 16, 18);
        }

    }
    //From StonecutterScreen.java
    private void renderRecipes(int pLeft, int pTop, int pRecipeIndexOffsetMax) {
        List<SewingStationRecipe> list = this.menu.getRecipes();

        for(int i = this.startIndex; i < pRecipeIndexOffsetMax && i < this.menu.getNumRecipes(); ++i) {
            int j = i - this.startIndex;
            int k = pLeft + j % 4 * 16;
            int l = j / 4;
            int i1 = pTop + l * 18 + 2;
            this.minecraft.getItemRenderer().renderAndDecorateItem(list.get(i).getResultItem(), k, i1);
        }

    }
    //From StonecutterScreen.java
    private boolean isScrollBarActive() {
        return this.displayRecipes && this.menu.getNumRecipes() > 12;
    }

    @Override
    public void render(PoseStack pPoseStack, int pMouseX, int pMouseY, float pPartialTick) {
        renderBackground(pPoseStack);
        super.render(pPoseStack, pMouseX, pMouseY, pPartialTick);
        renderTooltip(pPoseStack, pMouseX, pMouseY);
    }
}
