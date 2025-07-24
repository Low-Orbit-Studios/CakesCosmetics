package net.loworbitstation.cakescosmetics.entity.armor;

import net.loworbitstation.cakescosmetics.CakesCosmetics;
import net.loworbitstation.cakescosmetics.item.SombreroItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class SombreroModel extends GeoModel<SombreroItem> {
    @Override
    public ResourceLocation getModelResource(SombreroItem object) {
        return ResourceLocation.fromNamespaceAndPath(CakesCosmetics.MOD_ID, "geo/sombrero.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(SombreroItem object) {
        return ResourceLocation.fromNamespaceAndPath(CakesCosmetics.MOD_ID, "textures/models/armor/sombrero.png");
    }

    @Override
    public ResourceLocation getAnimationResource(SombreroItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(CakesCosmetics.MOD_ID, "animations/armor_animation.json");
    }
}
