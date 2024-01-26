package net.loworbitstation.cakescosmetics.entity.armor;

import net.loworbitstation.cakescosmetics.CakesCosmetics;
import net.loworbitstation.cakescosmetics.item.PirateHatItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class PirateHatModel extends AnimatedGeoModel<PirateHatItem> {
    @Override
    public ResourceLocation getModelResource(PirateHatItem object) {
        return new ResourceLocation(CakesCosmetics.MOD_ID, "geo/pirate_hat.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(PirateHatItem object) {
        return new ResourceLocation(CakesCosmetics.MOD_ID, "textures/models/armor/pirate_hat_texture.png");
    }

    @Override
    public ResourceLocation getAnimationResource(PirateHatItem animatable) {
        return new ResourceLocation(CakesCosmetics.MOD_ID, "animations/armor_animation.json");
    }
}
