package net.loworbitstation.cakescosmetics.entity.armor;

import net.loworbitstation.cakescosmetics.CakesCosmetics;
import net.loworbitstation.cakescosmetics.item.PirateHatItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class PirateHatModel extends GeoModel<PirateHatItem> {
    @Override
    public ResourceLocation getModelResource(PirateHatItem object) {
        return ResourceLocation.fromNamespaceAndPath(CakesCosmetics.MOD_ID, "geo/pirate_hat.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(PirateHatItem object) {
        return ResourceLocation.fromNamespaceAndPath(CakesCosmetics.MOD_ID, "textures/models/armor/pirate_hat.png");
    }

    @Override
    public ResourceLocation getAnimationResource(PirateHatItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(CakesCosmetics.MOD_ID, "animations/armor_animation.json");
    }
}
