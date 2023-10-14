package net.loworbitstation.cakescosmetics.entity.armor;

import net.loworbitstation.cakescosmetics.item.BandolierItem;
import net.loworbitstation.cakescosmetics.item.CowboyHatItem;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class CowboyHatRenderer  extends ModGeoArmorDefaultRenderer<CowboyHatItem>{
    public CowboyHatRenderer() {
        super(new CowboyHatModel());
    }
}
