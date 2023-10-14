package net.loworbitstation.cakescosmetics.entity.armor;

import net.loworbitstation.cakescosmetics.item.BandolierItem;
import net.loworbitstation.cakescosmetics.item.HornsItem;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class HornsRenderer extends ModGeoArmorDefaultRenderer<HornsItem> {
    public HornsRenderer() {
        super(new HornsModel());
    }
}
