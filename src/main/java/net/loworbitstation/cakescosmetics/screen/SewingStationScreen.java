package net.loworbitstation.cakescosmetics.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.loworbitstation.cakescosmetics.CakesCosmetics;
import net.loworbitstation.cakescosmetics.recipe.SewingStationRecipe;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
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
    //From StonecutterScreen.java
    /** Is {@code true} if the player clicked on the scroll wheel in the GUI. */
    private boolean scrolling;
    //From StonecutterScreen.java
    private float scrollOffs;
    //
    public SewingStationScreen(SewingStationMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
        pMenu.registerUpdateListener(this::containerChanged);
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
    public boolean mouseClicked(double pMouseX, double pMouseY, int pButton) {
        this.scrolling = false;
        if (this.displayRecipes) {
            int i = this.leftPos + 52;
            int j = this.topPos + 14;
            int k = this.startIndex + 12;

            for(int l = this.startIndex; l < k; ++l) {
                int i1 = l - this.startIndex;
                double d0 = pMouseX - (double)(i + i1 % 4 * 16);
                double d1 = pMouseY - (double)(j + i1 / 4 * 18);
                if (d0 >= 0.0D && d1 >= 0.0D && d0 < 16.0D && d1 < 18.0D && this.menu.clickMenuButton(this.minecraft.player, l)) {
                    Minecraft.getInstance().getSoundManager().play(SimpleSoundInstance.forUI(SoundEvents.UI_STONECUTTER_SELECT_RECIPE, 1.0F));
                    this.minecraft.gameMode.handleInventoryButtonClick((this.menu).containerId, l);
                    return true;
                }
            }

            i = this.leftPos + 119;
            j = this.topPos + 9;
            if (pMouseX >= (double)i && pMouseX < (double)(i + 12) && pMouseY >= (double)j && pMouseY < (double)(j + 54)) {
                this.scrolling = true;
            }
        }

        return super.mouseClicked(pMouseX, pMouseY, pButton);
    }
    //From StonecutterScreen.java
    public boolean mouseDragged(double pMouseX, double pMouseY, int pButton, double pDragX, double pDragY) {
        if (this.scrolling && this.isScrollBarActive()) {
            int i = this.topPos + 14;
            int j = i + 54;
            this.scrollOffs = ((float)pMouseY - (float)i - 7.5F) / ((float)(j - i) - 15.0F);
            this.scrollOffs = Mth.clamp(this.scrollOffs, 0.0F, 1.0F);
            this.startIndex = (int)((double)(this.scrollOffs * (float)this.getOffscreenRows()) + 0.5D) * 4;
            return true;
        } else {
            return super.mouseDragged(pMouseX, pMouseY, pButton, pDragX, pDragY);
        }
    }

    //From StonecutterScreen.java
    public boolean mouseScrolled(double pMouseX, double pMouseY, double pDelta) {
        if (this.isScrollBarActive()) {
            int i = this.getOffscreenRows();
            float f = (float)pDelta / (float)i;
            this.scrollOffs = Mth.clamp(this.scrollOffs - f, 0.0F, 1.0F);
            this.startIndex = (int)((double)(this.scrollOffs * (float)i) + 0.5D) * 4;
        }

        return true;
    }
    //From StonecutterScreen.java
    protected int getOffscreenRows() {
        return (this.menu.getNumRecipes() + 4 - 1) / 4 - 3;
    }
    //From StonecutterScreen.java
    private boolean isScrollBarActive() {
        return this.displayRecipes && this.menu.getNumRecipes() > 12;
    }
    //From StonecutterScreen.java
    /**
     * Called every time this screen's container is changed (is marked as dirty).
     */
    private void containerChanged() {
        this.displayRecipes = this.menu.hasInputItem();
        if (!this.displayRecipes) {
            this.scrollOffs = 0.0F;
            this.startIndex = 0;
        }

    }
    @Override
    public void render(PoseStack pPoseStack, int pMouseX, int pMouseY, float pPartialTick) {
        renderBackground(pPoseStack);
        super.render(pPoseStack, pMouseX, pMouseY, pPartialTick);
        renderTooltip(pPoseStack, pMouseX, pMouseY);
    }
}
