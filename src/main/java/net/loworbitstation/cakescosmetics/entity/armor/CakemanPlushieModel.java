package net.loworbitstation.cakescosmetics.entity.armor;

import net.loworbitstation.cakescosmetics.CakesCosmetics;
import net.loworbitstation.cakescosmetics.item.CakemanPlushieItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;


public class CakemanPlushieModel extends GeoModel<CakemanPlushieItem> {

    @Override
    public ResourceLocation getModelResource(CakemanPlushieItem object) {
        return ResourceLocation.fromNamespaceAndPath(CakesCosmetics.MOD_ID, "geo/cakeman_plushie.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(CakemanPlushieItem object) {
        return ResourceLocation.fromNamespaceAndPath(CakesCosmetics.MOD_ID, "textures/models/armor/cakeman_plushie.png");
    }

    @Override
    public ResourceLocation getAnimationResource(CakemanPlushieItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(CakesCosmetics.MOD_ID, "animations/armor_animation.json");
    }
}
