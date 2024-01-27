package net.loworbitstation.cakescosmetics.entity.armor;

import net.loworbitstation.cakescosmetics.item.BandolierItem;
import net.minecraft.world.level.block.StonecutterBlock;

public class BandolierRenderer extends ModGeoArmorDefaultRenderer<BandolierItem> {
    public BandolierRenderer() {
        super(new BandolierModel());
    }
}
