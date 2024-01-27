package net.loworbitstation.cakescosmetics.entity.armor;

import net.loworbitstation.cakescosmetics.CakesCosmetics;
import net.loworbitstation.cakescosmetics.item.DragonSkullItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class DragonSkullModel extends GeoModel<DragonSkullItem> {
    @Override
    public ResourceLocation getModelResource(DragonSkullItem object) {
        return new ResourceLocation(CakesCosmetics.MOD_ID, "geo/dragon_skull.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(DragonSkullItem object) {
        return new ResourceLocation(CakesCosmetics.MOD_ID, "textures/models/armor/dragon_skull_texture.png");
    }

    @Override
    public ResourceLocation getAnimationResource(DragonSkullItem animatable) {
        return new ResourceLocation(CakesCosmetics.MOD_ID, "animations/armor_animation.json");
    }
}
