package net.loworbitstation.cakescosmetics.entity.armor;

import net.loworbitstation.cakescosmetics.CakesCosmetics;
import net.loworbitstation.cakescosmetics.item.BandolierItem;
import net.loworbitstation.cakescosmetics.item.TopHatItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class TopHatModel extends GeoModel<TopHatItem> {
    @Override
    public ResourceLocation getModelResource(TopHatItem object) {
        return new ResourceLocation(CakesCosmetics.MOD_ID, "geo/top_hat.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(TopHatItem object) {
        return new ResourceLocation(CakesCosmetics.MOD_ID, "textures/models/armor/top_hat_texture.png");
    }

    @Override
    public ResourceLocation getAnimationResource(TopHatItem animatable) {
        return new ResourceLocation(CakesCosmetics.MOD_ID, "animations/armor_animation.json");
    }
}
