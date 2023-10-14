package net.loworbitstation.cakescosmetics.entity.armor;

import net.loworbitstation.cakescosmetics.CakesCosmetics;
import net.loworbitstation.cakescosmetics.item.BandolierItem;
import net.loworbitstation.cakescosmetics.item.HolsteredBeltItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class HolsteredBeltModel  extends AnimatedGeoModel<HolsteredBeltItem> {
    @Override
    public ResourceLocation getModelResource(HolsteredBeltItem object) {
        return new ResourceLocation(CakesCosmetics.MOD_ID, "geo/holstered_belt.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(HolsteredBeltItem object) {
        return new ResourceLocation(CakesCosmetics.MOD_ID, "textures/models/armor/holstered_belt_texture.png");
    }

    @Override
    public ResourceLocation getAnimationResource(HolsteredBeltItem animatable) {
        return new ResourceLocation(CakesCosmetics.MOD_ID, "animations/armor_animation.json");
    }
}
