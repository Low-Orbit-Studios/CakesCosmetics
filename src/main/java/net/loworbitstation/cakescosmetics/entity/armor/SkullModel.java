package net.loworbitstation.cakescosmetics.entity.armor;

import net.loworbitstation.cakescosmetics.CakesCosmetics;
import net.loworbitstation.cakescosmetics.item.SkullItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class SkullModel extends AnimatedGeoModel<SkullItem> {
    @Override
    public ResourceLocation getModelResource(SkullItem object) {
        return new ResourceLocation(CakesCosmetics.MOD_ID, "geo/skull.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(SkullItem object) {
        return new ResourceLocation(CakesCosmetics.MOD_ID, "textures/models/armor/skull_texture.png");
    }

    @Override
    public ResourceLocation getAnimationResource(SkullItem animatable) {
        return new ResourceLocation(CakesCosmetics.MOD_ID, "animations/armor_animation.json");
    }
}
