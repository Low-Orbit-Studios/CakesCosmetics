package net.loworbitstation.cakescosmetics.item;

import net.loworbitstation.cakescosmetics.entity.armor.ModGeoArmorDefaultRenderer;
import net.loworbitstation.cakescosmetics.entity.armor.TopHatHatRenderer;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class TopHatHatItem extends VanityArmorItem{
    public TopHatHatItem(ArmorMaterial pMaterial, Type type, Properties pProperties) {
        super(pMaterial, type, pProperties);
    }
    @OnlyIn(Dist.CLIENT)
    @Override
    protected ModGeoArmorDefaultRenderer<?> getRenderer() {
        return new TopHatHatRenderer();
    }
}
