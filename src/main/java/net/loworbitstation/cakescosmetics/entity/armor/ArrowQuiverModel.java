package net.loworbitstation.cakescosmetics.entity.armor;

import net.loworbitstation.cakescosmetics.CakesCosmetics;
import net.loworbitstation.cakescosmetics.item.ArrowQuiverItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class ArrowQuiverModel extends GeoModel<ArrowQuiverItem> {
    @Override
    public ResourceLocation getModelResource(ArrowQuiverItem object) {
        return new ResourceLocation(CakesCosmetics.MOD_ID, "geo/arrow_quiver.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(ArrowQuiverItem object) {
        return new ResourceLocation(CakesCosmetics.MOD_ID, "textures/models/armor/arrow_quiver_texture.png");
    }

    @Override
    public ResourceLocation getAnimationResource(ArrowQuiverItem animatable) {
        return new ResourceLocation(CakesCosmetics.MOD_ID, "animations/armor_animation.json");
    }
}
