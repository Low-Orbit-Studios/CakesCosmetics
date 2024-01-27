package net.loworbitstation.cakescosmetics.events;

import net.loworbitstation.cakescosmetics.CakesCosmetics;
import net.loworbitstation.cakescosmetics.entity.armor.*;
import net.loworbitstation.cakescosmetics.item.*;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
//import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

@Mod.EventBusSubscriber(modid = CakesCosmetics.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModEventClientArmorRenderers {
//    @SubscribeEvent
//    public static void registerArmorRenderers(final EntityRenderersEvent.AddLayers event) {
//        GeoArmorRenderer.registerArmorRenderer(ArrowQuiverItem.class, () -> new ArrowQuiverRenderer());
//        GeoArmorRenderer.registerArmorRenderer(BandolierItem.class, () -> new BandolierRenderer());
//        GeoArmorRenderer.registerArmorRenderer(CaptainHatItem.class, () -> new CaptainHatRenderer());
//        GeoArmorRenderer.registerArmorRenderer(ChristmasHatItem.class, () -> new ChristmasHatRenderer());
//        GeoArmorRenderer.registerArmorRenderer(CowboyHatItem.class, () -> new CowboyHatRenderer());
//        GeoArmorRenderer.registerArmorRenderer(DragonSkullItem.class, () -> new DragonSkullRenderer());
//        GeoArmorRenderer.registerArmorRenderer(HolsteredBeltItem.class, () -> new HolsteredBeltRenderer());
//        GeoArmorRenderer.registerArmorRenderer(HornsItem.class, () -> new HornsRenderer());
//        GeoArmorRenderer.registerArmorRenderer(PirateHatItem.class, () -> new PirateHatRenderer());
//        GeoArmorRenderer.registerArmorRenderer(SkullItem.class, () -> new SkullRenderer());
//        GeoArmorRenderer.registerArmorRenderer(SombreroItem.class, () -> new SombreroRenderer());
//        GeoArmorRenderer.registerArmorRenderer(TopHatItem.class, () -> new TopHatRenderer());
//        GeoArmorRenderer.registerArmorRenderer(StrawHatItem.class, () -> new StrawHatRenderer());
//        GeoArmorRenderer.registerArmorRenderer(WingsItem.class, () -> new WingsRenderer());
//        GeoArmorRenderer.registerArmorRenderer(WizardsHatItem.class, () -> new WizardsHatRenderer());
//    }
}
