package net.loworbitstation.cakescosmetics.entity.armor;

import net.loworbitstation.cakescosmetics.CakesCosmetics;
import net.loworbitstation.cakescosmetics.item.HolsteredBeltItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class HolsteredBeltModel  extends GeoModel<HolsteredBeltItem> {
    @Override
    public ResourceLocation getModelResource(HolsteredBeltItem object) {
        return ResourceLocation.fromNamespaceAndPath(CakesCosmetics.MOD_ID, "geo/holstered_belt.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(HolsteredBeltItem object) {
        return ResourceLocation.fromNamespaceAndPath(CakesCosmetics.MOD_ID, "textures/models/armor/holstered_belt.png");
    }

    @Override
    public ResourceLocation getAnimationResource(HolsteredBeltItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(CakesCosmetics.MOD_ID, "animations/armor_animation.json");
    }
}
