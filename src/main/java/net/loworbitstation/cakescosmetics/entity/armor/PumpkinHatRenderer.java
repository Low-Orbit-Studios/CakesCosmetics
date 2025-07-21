package net.loworbitstation.cakescosmetics.entity.armor;

import net.loworbitstation.cakescosmetics.item.PumpkinHatItem;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;

public class PumpkinHatRenderer extends ModGeoArmorDefaultRenderer<PumpkinHatItem> {
    public PumpkinHatRenderer() {
        super(new PumpkinHatModel());
    }

}
