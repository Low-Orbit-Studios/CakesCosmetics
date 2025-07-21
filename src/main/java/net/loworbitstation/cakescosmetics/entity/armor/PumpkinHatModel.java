package net.loworbitstation.cakescosmetics.entity.armor;

import net.loworbitstation.cakescosmetics.CakesCosmetics;
import net.loworbitstation.cakescosmetics.item.PumpkinHatItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class PumpkinHatModel extends GeoModel<PumpkinHatItem> {
    @Override
    public ResourceLocation getModelResource(PumpkinHatItem object) {
        return new ResourceLocation(CakesCosmetics.MOD_ID, "geo/pumpkin_hat.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(PumpkinHatItem object) {
        return new ResourceLocation(CakesCosmetics.MOD_ID, "textures/models/armor/pumpkin_hat.png");
    }

    @Override
    public ResourceLocation getAnimationResource(PumpkinHatItem animatable) {
        return new ResourceLocation(CakesCosmetics.MOD_ID, "animations/armor_animation.json");
    }
}
