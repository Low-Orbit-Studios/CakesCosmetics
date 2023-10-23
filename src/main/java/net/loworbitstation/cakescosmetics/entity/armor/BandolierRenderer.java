package net.loworbitstation.cakescosmetics.entity.armor;

import net.loworbitstation.cakescosmetics.item.BandolierItem;
import net.minecraft.world.level.block.StonecutterBlock;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

public class BandolierRenderer extends ModGeoArmorDefaultRenderer<BandolierItem> {
    public BandolierRenderer() {
        super(new BandolierModel());
    }
}
