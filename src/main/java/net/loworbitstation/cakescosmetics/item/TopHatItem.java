package net.loworbitstation.cakescosmetics.item;

import net.loworbitstation.cakescosmetics.entity.armor.BandolierRenderer;
import net.loworbitstation.cakescosmetics.entity.armor.ModGeoArmorDefaultRenderer;
import net.loworbitstation.cakescosmetics.entity.armor.TopHatRenderer;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;


import static net.loworbitstation.cakescosmetics.data.constants.Constants.ANIM_CONTROLLER_TRANSITION_LENGTH_TICKS;

public class TopHatItem extends VanityArmorItem{
    public TopHatItem(ArmorMaterial pMaterial, Type type, Properties pProperties) {
        super(pMaterial, type, pProperties);
    }
    @OnlyIn(Dist.CLIENT)
    @Override
    protected ModGeoArmorDefaultRenderer<?> getRenderer() {
        return new TopHatRenderer();
    }
}
