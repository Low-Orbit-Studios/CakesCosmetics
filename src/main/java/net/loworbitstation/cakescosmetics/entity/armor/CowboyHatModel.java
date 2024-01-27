package net.loworbitstation.cakescosmetics.entity.armor;

import net.loworbitstation.cakescosmetics.CakesCosmetics;
import net.loworbitstation.cakescosmetics.item.BandolierItem;
import net.loworbitstation.cakescosmetics.item.CowboyHatItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class CowboyHatModel extends GeoModel<CowboyHatItem> {
    @Override
    public ResourceLocation getModelResource(CowboyHatItem object) {
        return new ResourceLocation(CakesCosmetics.MOD_ID, "geo/cowboy_hat.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(CowboyHatItem object) {
        return new ResourceLocation(CakesCosmetics.MOD_ID, "textures/models/armor/cowboy_hat_texture.png");
    }

    @Override
    public ResourceLocation getAnimationResource(CowboyHatItem animatable) {
        return new ResourceLocation(CakesCosmetics.MOD_ID, "animations/armor_animation.json");
    }
}
