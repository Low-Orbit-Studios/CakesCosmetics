package net.loworbitstation.cakescosmetics.entity.armor;

import net.loworbitstation.cakescosmetics.item.TopHatItem;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class TopHatRenderer extends ModGeoArmorDefaultRenderer<TopHatItem> {
    public TopHatRenderer() {
        super(new TopHatModel());
    }
}
