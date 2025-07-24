package net.loworbitstation.cakescosmetics.entity.armor;

import net.loworbitstation.cakescosmetics.CakesCosmetics;
import net.loworbitstation.cakescosmetics.item.KasaHatItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class KasaHatModel extends GeoModel<KasaHatItem> {
    @Override
    public ResourceLocation getModelResource(KasaHatItem object) {
        return ResourceLocation.fromNamespaceAndPath(CakesCosmetics.MOD_ID, "geo/kasa_hat.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(KasaHatItem object) {
        return ResourceLocation.fromNamespaceAndPath(CakesCosmetics.MOD_ID, "textures/models/armor/kasa_hat.png");
    }

    @Override
    public ResourceLocation getAnimationResource(KasaHatItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(CakesCosmetics.MOD_ID, "animations/armor_animation.json");
    }
}
