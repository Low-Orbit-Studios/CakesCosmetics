package net.loworbitstation.cakescosmetics.entity.armor;

import net.loworbitstation.cakescosmetics.CakesCosmetics;
import net.loworbitstation.cakescosmetics.item.WizardsHatItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class WizardsHatModel extends AnimatedGeoModel<WizardsHatItem> {
    @Override
    public ResourceLocation getModelResource(WizardsHatItem object) {
        return new ResourceLocation(CakesCosmetics.MOD_ID, "geo/wizards_hat.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(WizardsHatItem object) {
        return new ResourceLocation(CakesCosmetics.MOD_ID, "textures/models/armor/wizards_hat_texture.png");
    }

    @Override
    public ResourceLocation getAnimationResource(WizardsHatItem animatable) {
        return new ResourceLocation(CakesCosmetics.MOD_ID, "animations/armor_animation.json");
    }
}
