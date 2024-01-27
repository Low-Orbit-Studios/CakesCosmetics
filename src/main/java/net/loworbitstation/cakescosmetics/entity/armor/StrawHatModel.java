package net.loworbitstation.cakescosmetics.entity.armor;

import net.loworbitstation.cakescosmetics.CakesCosmetics;
import net.loworbitstation.cakescosmetics.item.StrawHatItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class StrawHatModel extends GeoModel<StrawHatItem> {
    @Override
    public ResourceLocation getModelResource(StrawHatItem object) {
        return new ResourceLocation(CakesCosmetics.MOD_ID, "geo/straw_hat.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(StrawHatItem object) {
        return new ResourceLocation(CakesCosmetics.MOD_ID, "textures/models/armor/straw_hat_texture.png");
    }

    @Override
    public ResourceLocation getAnimationResource(StrawHatItem animatable) {
        return new ResourceLocation(CakesCosmetics.MOD_ID, "animations/armor_animation.json");
    }
}
