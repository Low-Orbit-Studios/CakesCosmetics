package net.loworbitstation.cakescosmetics.item;

import net.loworbitstation.cakescosmetics.entity.armor.BandolierRenderer;
import net.loworbitstation.cakescosmetics.entity.armor.ModGeoArmorDefaultRenderer;
import net.loworbitstation.cakescosmetics.entity.armor.SkullRenderer;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;


import static net.loworbitstation.cakescosmetics.data.constants.Constants.ANIM_CONTROLLER_TRANSITION_LENGTH_TICKS;

public class SkullItem extends VanityArmorItem {
    public SkullItem(ArmorMaterial pMaterial, Type type, Properties pProperties) {
        super(pMaterial, type, pProperties);
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    protected ModGeoArmorDefaultRenderer<?> getRenderer() {
        return new SkullRenderer();
    }

}
