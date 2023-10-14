package net.loworbitstation.cakescosmetics.entity.armor;

import net.loworbitstation.cakescosmetics.CakesCosmetics;
import net.loworbitstation.cakescosmetics.item.BandolierItem;
import net.loworbitstation.cakescosmetics.item.CaptainHatItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class CaptainHatModel extends AnimatedGeoModel<CaptainHatItem> {
    @Override
    public ResourceLocation getModelResource(CaptainHatItem object) {
        return new ResourceLocation(CakesCosmetics.MOD_ID, "geo/captain_hat.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(CaptainHatItem object) {
        return new ResourceLocation(CakesCosmetics.MOD_ID, "textures/models/armor/captain_hat_texture.png");
    }

    @Override
    public ResourceLocation getAnimationResource(CaptainHatItem animatable) {
        return new ResourceLocation(CakesCosmetics.MOD_ID, "animations/armor_animation.json");
    }
}
