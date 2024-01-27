package net.loworbitstation.cakescosmetics.entity.armor;

import net.loworbitstation.cakescosmetics.CakesCosmetics;
import net.loworbitstation.cakescosmetics.item.ChristmasHatItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class ChristmasHatModel extends GeoModel<ChristmasHatItem> {
    @Override
    public ResourceLocation getModelResource(ChristmasHatItem object) {
        return new ResourceLocation(CakesCosmetics.MOD_ID, "geo/christmas_hat.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(ChristmasHatItem object) {
        return new ResourceLocation(CakesCosmetics.MOD_ID, "textures/models/armor/christmas_hat_texture.png");
    }

    @Override
    public ResourceLocation getAnimationResource(ChristmasHatItem animatable) {
        return new ResourceLocation(CakesCosmetics.MOD_ID, "animations/armor_animation.json");
    }
}
