package net.loworbitstation.cakescosmetics.item;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.manager.AnimationData;

import static net.loworbitstation.cakescosmetics.data.constants.Constants.ANIM_CONTROLLER_TRANSITION_LENGTH_TICKS;

public class CaptainHatItem extends VanityArmorItem {
    public CaptainHatItem(ArmorMaterial pMaterial, EquipmentSlot pSlot, Properties pProperties) {
        super(pMaterial, pSlot, pProperties);
    }

    @Override
    public void registerControllers(AnimationData data) {
        data.addAnimationController(new AnimationController<CaptainHatItem>(this, "controller",
                ANIM_CONTROLLER_TRANSITION_LENGTH_TICKS, this::predicate));
    }
}
