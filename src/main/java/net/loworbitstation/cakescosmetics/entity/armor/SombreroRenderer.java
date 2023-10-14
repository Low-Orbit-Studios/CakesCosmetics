package net.loworbitstation.cakescosmetics.entity.armor;

import net.loworbitstation.cakescosmetics.item.BandolierItem;
import net.loworbitstation.cakescosmetics.item.SombreroItem;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class SombreroRenderer extends ModGeoArmorDefaultRenderer<SombreroItem> {
    public SombreroRenderer() {
        super(new SombreroModel());
    }
}
