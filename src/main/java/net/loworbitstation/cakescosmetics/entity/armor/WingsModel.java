package net.loworbitstation.cakescosmetics.entity.armor;

import net.loworbitstation.cakescosmetics.CakesCosmetics;
import net.loworbitstation.cakescosmetics.item.WingsItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class WingsModel extends GeoModel<WingsItem> {
    @Override
    public ResourceLocation getModelResource(WingsItem object) {
        return new ResourceLocation(CakesCosmetics.MOD_ID, "geo/wings.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(WingsItem object) {
        return new ResourceLocation(CakesCosmetics.MOD_ID, "textures/models/armor/wings_texture.png");
    }

    @Override
    public ResourceLocation getAnimationResource(WingsItem animatable) {
        return new ResourceLocation(CakesCosmetics.MOD_ID, "animations/armor_animation.json");
    }
}
