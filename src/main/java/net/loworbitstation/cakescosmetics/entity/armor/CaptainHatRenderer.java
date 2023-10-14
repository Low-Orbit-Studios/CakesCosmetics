package net.loworbitstation.cakescosmetics.entity.armor;

import net.loworbitstation.cakescosmetics.item.BandolierItem;
import net.loworbitstation.cakescosmetics.item.CaptainHatItem;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class CaptainHatRenderer extends ModGeoArmorDefaultRenderer<CaptainHatItem>{
    public CaptainHatRenderer() {
        super(new CaptainHatModel());
    }
}
