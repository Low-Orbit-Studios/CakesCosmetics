package net.loworbitstation.cakescosmetics.entity.armor;

import net.loworbitstation.cakescosmetics.CakesCosmetics;
import net.loworbitstation.cakescosmetics.item.BandolierItem;
import net.loworbitstation.cakescosmetics.item.SombreroItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class SombreroModel extends AnimatedGeoModel<SombreroItem> {
    @Override
    public ResourceLocation getModelResource(SombreroItem object) {
        return new ResourceLocation(CakesCosmetics.MOD_ID, "geo/sombrero.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(SombreroItem object) {
        return new ResourceLocation(CakesCosmetics.MOD_ID, "textures/models/armor/sombrero_texture.png");
    }

    @Override
    public ResourceLocation getAnimationResource(SombreroItem animatable) {
        return new ResourceLocation(CakesCosmetics.MOD_ID, "animations/armor_animation.json");
    }
}
