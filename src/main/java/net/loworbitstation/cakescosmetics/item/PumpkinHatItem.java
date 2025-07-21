package net.loworbitstation.cakescosmetics.item;

import net.loworbitstation.cakescosmetics.entity.armor.PumpkinHatRenderer;
import net.loworbitstation.cakescosmetics.entity.armor.ModGeoArmorDefaultRenderer;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class PumpkinHatItem extends VanityArmorItem{
    public PumpkinHatItem(ArmorMaterial pMaterial, Type type, Properties pProperties) {
        super(pMaterial, type, pProperties);
    }
    @OnlyIn(Dist.CLIENT)
    @Override
    protected ModGeoArmorDefaultRenderer<?> getRenderer() {
        return new PumpkinHatRenderer();
    }
}
