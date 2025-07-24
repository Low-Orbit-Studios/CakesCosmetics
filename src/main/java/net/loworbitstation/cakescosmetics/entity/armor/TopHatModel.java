package net.loworbitstation.cakescosmetics.entity.armor;

import net.loworbitstation.cakescosmetics.CakesCosmetics;
import net.loworbitstation.cakescosmetics.item.TopHatItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class TopHatModel extends GeoModel<TopHatItem> {
    @Override
    public ResourceLocation getModelResource(TopHatItem object) {
        return ResourceLocation.fromNamespaceAndPath(CakesCosmetics.MOD_ID, "geo/top_hat.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(TopHatItem object) {
        return ResourceLocation.fromNamespaceAndPath(CakesCosmetics.MOD_ID, "textures/models/armor/top_hat.png");
    }

    @Override
    public ResourceLocation getAnimationResource(TopHatItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(CakesCosmetics.MOD_ID, "animations/armor_animation.json");
    }
}
