package net.loworbitstation.cakescosmetics.screen;

import com.mojang.blaze3d.vertex.PoseStack;
import net.loworbitstation.cakescosmetics.CakesCosmetics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.screens.inventory.StonecutterScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;

public class SewingStationScreen extends AbstractContainerScreen<SewingStationMenu> {
    private static final ResourceLocation TEXTURE =
            new ResourceLocation(CakesCosmetics.MOD_ID,"textures/gui/container/sewing_station_gui.png");
    public SewingStationScreen(SewingStationMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);

    }



    @Override
    protected void renderBg(PoseStack pPoseStack, float pPartialTick, int pMouseX, int pMouseY) {

    }

    @Override
    public void render(PoseStack pPoseStack, int pMouseX, int pMouseY, float pPartialTick) {
        renderBackground(pPoseStack);
        super.render(pPoseStack, pMouseX, pMouseY, pPartialTick);
        renderTooltip(pPoseStack, pMouseX, pMouseY);
    }
}
