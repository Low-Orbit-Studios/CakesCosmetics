package net.loworbitstation.cakescosmetics.entity.armor;

import net.loworbitstation.cakescosmetics.CakesCosmetics;
import net.loworbitstation.cakescosmetics.item.BandolierItem;
import net.loworbitstation.cakescosmetics.item.HornsItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class HornsModel extends AnimatedGeoModel<HornsItem> {
    @Override
    public ResourceLocation getModelResource(HornsItem object) {
        return new ResourceLocation(CakesCosmetics.MOD_ID, "geo/horns.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(HornsItem object) {
        return new ResourceLocation(CakesCosmetics.MOD_ID, "textures/models/armor/horns_texture.png");
    }

    @Override
    public ResourceLocation getAnimationResource(HornsItem animatable) {
        return new ResourceLocation(CakesCosmetics.MOD_ID, "animations/armor_animation.json");
    }
}
