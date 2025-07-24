package net.loworbitstation.cakescosmetics.entity.armor;

import net.loworbitstation.cakescosmetics.CakesCosmetics;
import net.loworbitstation.cakescosmetics.item.CaptainHatItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;


public class CaptainHatModel extends GeoModel<CaptainHatItem> {

    @Override
    public ResourceLocation getModelResource(CaptainHatItem object) {
        return ResourceLocation.fromNamespaceAndPath(CakesCosmetics.MOD_ID, "geo/captain_hat.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(CaptainHatItem object) {
        return ResourceLocation.fromNamespaceAndPath(CakesCosmetics.MOD_ID, "textures/models/armor/captain_hat.png");
    }

    @Override
    public ResourceLocation getAnimationResource(CaptainHatItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(CakesCosmetics.MOD_ID, "animations/armor_animation.json");
    }
}
