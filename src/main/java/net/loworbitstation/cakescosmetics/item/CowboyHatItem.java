package net.loworbitstation.cakescosmetics.item;

import net.loworbitstation.cakescosmetics.entity.armor.BandolierRenderer;
import net.loworbitstation.cakescosmetics.entity.armor.CowboyHatRenderer;
import net.loworbitstation.cakescosmetics.entity.armor.ModGeoArmorDefaultRenderer;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.util.GeckoLibUtil;


import static net.loworbitstation.cakescosmetics.data.constants.Constants.ANIM_CONTROLLER_TRANSITION_LENGTH_TICKS;

public class CowboyHatItem  extends VanityArmorItem {
    protected AnimatableInstanceCache _animatableInstanceCache = GeckoLibUtil.createInstanceCache(this);
    public CowboyHatItem(ArmorMaterial pMaterial, Type type, Properties pProperties) {
        super(pMaterial, type, pProperties);
    }
    @OnlyIn(Dist.CLIENT)
    @Override
    protected ModGeoArmorDefaultRenderer<?> getRenderer() {
        return new CowboyHatRenderer();
    }
    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return _animatableInstanceCache;
    }
}
