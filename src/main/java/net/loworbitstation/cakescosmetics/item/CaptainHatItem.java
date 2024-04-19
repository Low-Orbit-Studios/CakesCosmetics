package net.loworbitstation.cakescosmetics.item;

import net.loworbitstation.cakescosmetics.entity.armor.CaptainHatRenderer;
import net.loworbitstation.cakescosmetics.entity.armor.ModGeoArmorDefaultRenderer;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.util.GeckoLibUtil;


public class CaptainHatItem extends VanityArmorItem {
    protected AnimatableInstanceCache _animatableInstanceCache = GeckoLibUtil.createInstanceCache(this);
    public CaptainHatItem(ArmorMaterial pMaterial, Type type, Properties pProperties) {
        super(pMaterial, type, pProperties);
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    protected ModGeoArmorDefaultRenderer<?> getRenderer() {
        return new CaptainHatRenderer();
    }
    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return _animatableInstanceCache;
    }
}
