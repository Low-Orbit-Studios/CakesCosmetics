package net.loworbitstation.cakescosmetics.entity.armor;

import net.loworbitstation.cakescosmetics.CakesCosmetics;
import net.loworbitstation.cakescosmetics.item.SheathedKatanaItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class SheathedKatanaModel extends GeoModel<SheathedKatanaItem> {
    @Override
    public ResourceLocation getModelResource(SheathedKatanaItem object) {
        return new ResourceLocation(CakesCosmetics.MOD_ID, "geo/sheathed_katana.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(SheathedKatanaItem object) {
        return new ResourceLocation(CakesCosmetics.MOD_ID, "textures/models/armor/sheathed_katana.png");
    }

    @Override
    public ResourceLocation getAnimationResource(SheathedKatanaItem animatable) {
        return new ResourceLocation(CakesCosmetics.MOD_ID, "animations/armor_animation.json");
    }
}
