package net.loworbitstation.cakescosmetics.entity.armor;

import net.loworbitstation.cakescosmetics.item.BandolierItem;
import net.minecraft.resources.ResourceLocation;
import net.loworbitstation.cakescosmetics.CakesCosmetics;
import software.bernie.geckolib.model.GeoModel;

public class BandolierModel extends GeoModel<BandolierItem> {
    @Override
    public ResourceLocation getModelResource(BandolierItem object) {
        return new ResourceLocation(CakesCosmetics.MOD_ID, "geo/bandolier.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(BandolierItem object) {
        return new ResourceLocation(CakesCosmetics.MOD_ID, "textures/models/armor/bandolier_texture.png");
    }

    @Override
    public ResourceLocation getAnimationResource(BandolierItem animatable) {
        return new ResourceLocation(CakesCosmetics.MOD_ID, "animations/armor_animation.json");
    }
}
