package net.loworbitstation.cakescosmetics.entity.armor;

import net.loworbitstation.cakescosmetics.item.BandolierItem;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

public class BandolierRenderer extends ModGeoArmorDefaultRenderer<BandolierItem> {
    public BandolierRenderer() {
        super(new BandolierModel());
    }
}
