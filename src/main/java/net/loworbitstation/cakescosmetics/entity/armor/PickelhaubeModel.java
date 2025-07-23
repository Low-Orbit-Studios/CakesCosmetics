package net.loworbitstation.cakescosmetics.entity.armor;

import net.loworbitstation.cakescosmetics.CakesCosmetics;
import net.loworbitstation.cakescosmetics.item.PickelhaubeItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class PickelhaubeModel extends GeoModel<PickelhaubeItem> {
    @Override
    public ResourceLocation getModelResource(PickelhaubeItem object) {
        return new ResourceLocation(CakesCosmetics.MOD_ID, "geo/pickelhaube.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(PickelhaubeItem object) {
        return new ResourceLocation(CakesCosmetics.MOD_ID, "textures/models/armor/pickelhaube.png");
    }

    @Override
    public ResourceLocation getAnimationResource(PickelhaubeItem animatable) {
        return new ResourceLocation(CakesCosmetics.MOD_ID, "animations/armor_animation.json");
    }
}
