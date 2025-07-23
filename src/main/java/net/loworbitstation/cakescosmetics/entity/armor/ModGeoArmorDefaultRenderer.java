package net.loworbitstation.cakescosmetics.entity.armor;

import net.minecraft.world.item.ArmorItem;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public abstract class ModGeoArmorDefaultRenderer<T extends ArmorItem & GeoItem> extends GeoArmorRenderer<T> {
    public ModGeoArmorDefaultRenderer(GeoModel<T> modelProvider) {
        super(modelProvider);
    }
}
