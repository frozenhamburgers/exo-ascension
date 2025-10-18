package net.jelly.exo_ascension.global.invasion;

import net.jelly.exo_ascension.ExoAscensionMod;
import net.jelly.exo_ascension.global.pollution.RedstoneIndexData;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ExoAscensionMod.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class InvasionHandler {

    @SubscribeEvent
    public static void serverTick(TickEvent.ServerTickEvent event) {
        InvasionData.get(event.getServer().getLevel(Level.OVERWORLD)).tick();
    }
}
