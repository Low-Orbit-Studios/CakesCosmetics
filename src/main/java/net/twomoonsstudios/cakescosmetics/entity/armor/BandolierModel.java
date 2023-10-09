package net.twomoonsstudios.cakescosmetics.entity.armor;

import net.minecraft.resources.ResourceLocation;
import net.twomoonsstudios.cakescosmetics.CakesCosmetics;
import net.twomoonsstudios.cakescosmetics.item.VanityArmorItem;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class BandolierModel extends AnimatedGeoModel<VanityArmorItem> {
    @Override
    public ResourceLocation getModelResource(VanityArmorItem object) {
        return new ResourceLocation(CakesCosmetics.MOD_ID, "geo/bandolier.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(VanityArmorItem object) {
        return new ResourceLocation(CakesCosmetics.MOD_ID, "textures/models/bandolier_texture.png");
    }

    @Override
    public ResourceLocation getAnimationResource(VanityArmorItem animatable) {
        return new ResourceLocation(CakesCosmetics.MOD_ID, "animations/armor_animation.json");
    }
}
