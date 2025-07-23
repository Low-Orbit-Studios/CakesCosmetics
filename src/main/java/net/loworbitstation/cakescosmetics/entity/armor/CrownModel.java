package net.loworbitstation.cakescosmetics.entity.armor;

import net.loworbitstation.cakescosmetics.CakesCosmetics;
import net.loworbitstation.cakescosmetics.item.CrownItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class CrownModel extends GeoModel<CrownItem> {
    @Override
    public ResourceLocation getModelResource(CrownItem object) {
        return new ResourceLocation(CakesCosmetics.MOD_ID, "geo/crown.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(CrownItem object) {
        return new ResourceLocation(CakesCosmetics.MOD_ID, "textures/models/armor/crown.png");
    }

    @Override
    public ResourceLocation getAnimationResource(CrownItem animatable) {
        return new ResourceLocation(CakesCosmetics.MOD_ID, "animations/armor_animation.json");
    }
}
