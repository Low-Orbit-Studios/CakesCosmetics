package net.loworbitstation.cakescosmetics.entity.armor;

import net.loworbitstation.cakescosmetics.CakesCosmetics;
import net.loworbitstation.cakescosmetics.item.HermesBootsItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class HermesBootsModel extends GeoModel<HermesBootsItem> {
    @Override
    public ResourceLocation getModelResource(HermesBootsItem object) {
        return ResourceLocation.fromNamespaceAndPath(CakesCosmetics.MOD_ID, "geo/hermes_boots.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(HermesBootsItem object) {
        return ResourceLocation.fromNamespaceAndPath(CakesCosmetics.MOD_ID, "textures/models/armor/hermes_boots.png");
    }

    @Override
    public ResourceLocation getAnimationResource(HermesBootsItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(CakesCosmetics.MOD_ID, "animations/armor_animation.json");
    }
}
