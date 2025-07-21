package net.loworbitstation.cakescosmetics.entity.armor;

import net.loworbitstation.cakescosmetics.CakesCosmetics;
import net.loworbitstation.cakescosmetics.item.TopHatHatItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class TopHatHatModel extends GeoModel<TopHatHatItem> {
    @Override
    public ResourceLocation getModelResource(TopHatHatItem object) {
        return new ResourceLocation(CakesCosmetics.MOD_ID, "geo/top_hat_hat.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(TopHatHatItem object) {
        return new ResourceLocation(CakesCosmetics.MOD_ID, "textures/models/armor/top_hat.png");
    }

    @Override
    public ResourceLocation getAnimationResource(TopHatHatItem animatable) {
        return new ResourceLocation(CakesCosmetics.MOD_ID, "animations/armor_animation.json");
    }
}
