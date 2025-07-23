package net.loworbitstation.cakescosmetics.item;

import net.loworbitstation.cakescosmetics.entity.armor.ModGeoArmorDefaultRenderer;
import net.loworbitstation.cakescosmetics.entity.armor.CrownRenderer;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class CrownItem extends VanityArmorItem{
    public CrownItem(ArmorMaterial pMaterial, Type type, Properties pProperties) {
        super(pMaterial, type, pProperties);
    }
    @OnlyIn(Dist.CLIENT)
    @Override
    protected ModGeoArmorDefaultRenderer<?> getRenderer() {
        return new CrownRenderer();
    }
}
