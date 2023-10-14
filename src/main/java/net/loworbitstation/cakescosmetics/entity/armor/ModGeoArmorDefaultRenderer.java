package net.loworbitstation.cakescosmetics.entity.armor;

import net.loworbitstation.cakescosmetics.item.BandolierItem;
import net.minecraft.world.item.ArmorItem;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

public class ModGeoArmorDefaultRenderer<T extends ArmorItem & IAnimatable> extends GeoArmorRenderer<T> {
    public ModGeoArmorDefaultRenderer(AnimatedGeoModel<T> modelProvider) {
        super(modelProvider);

        this.headBone = "armorHead";
        this.bodyBone = "armorBody";
        this.rightArmBone = "armorRightArm";
        this.leftArmBone = "armorLeftArm";
        this.rightLegBone = "armorRightLeg";
        this.leftLegBone = "armorLeftLeg";
        this.rightBootBone = "armorRightBoot";
        this.leftBootBone = "armorLeftBoot";
    }
}
