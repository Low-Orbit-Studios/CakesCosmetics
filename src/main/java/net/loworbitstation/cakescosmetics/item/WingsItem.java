package net.loworbitstation.cakescosmetics.item;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.manager.AnimationData;

import static net.loworbitstation.cakescosmetics.data.constants.Constants.ANIM_CONTROLLER_TRANSITION_LENGTH_TICKS;

public class WingsItem extends VanityArmorItem {
    public WingsItem(ArmorMaterial pMaterial, EquipmentSlot pSlot, Properties pProperties) {
        super(pMaterial, pSlot, pProperties);
    }

    @Override
    public void registerControllers(AnimationData data) {
        data.addAnimationController(new AnimationController<WingsItem>(this, "controller",
                ANIM_CONTROLLER_TRANSITION_LENGTH_TICKS, this::predicate));
    }

}
