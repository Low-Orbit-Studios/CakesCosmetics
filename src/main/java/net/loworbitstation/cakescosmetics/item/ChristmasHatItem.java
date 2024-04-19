package net.loworbitstation.cakescosmetics.item;


import net.loworbitstation.cakescosmetics.entity.armor.ChristmasHatRenderer;
import net.loworbitstation.cakescosmetics.entity.armor.ModGeoArmorDefaultRenderer;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.util.GeckoLibUtil;

public class ChristmasHatItem extends VanityArmorItem {
    protected AnimatableInstanceCache _animatableInstanceCache = GeckoLibUtil.createInstanceCache(this);
    public ChristmasHatItem(ArmorMaterial pMaterial, Type type, Properties pProperties) {
        super(pMaterial, type, pProperties);
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    protected ModGeoArmorDefaultRenderer<?> getRenderer() {
        return new ChristmasHatRenderer();
    }
    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return _animatableInstanceCache;
    }
}
