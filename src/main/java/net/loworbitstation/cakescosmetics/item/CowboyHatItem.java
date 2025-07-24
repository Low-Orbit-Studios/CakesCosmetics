package net.loworbitstation.cakescosmetics.item;

import net.loworbitstation.cakescosmetics.entity.armor.CowboyHatRenderer;
import net.loworbitstation.cakescosmetics.entity.armor.ModGeoArmorDefaultRenderer;
import net.minecraft.core.Holder;
import net.minecraft.world.item.ArmorMaterial;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.util.GeckoLibUtil;

public class CowboyHatItem extends VanityArmorItem {
    protected AnimatableInstanceCache _animatableInstanceCache = GeckoLibUtil.createInstanceCache(this);
    public CowboyHatItem(Holder<ArmorMaterial> pMaterial, Type type, Properties pProperties) {
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
