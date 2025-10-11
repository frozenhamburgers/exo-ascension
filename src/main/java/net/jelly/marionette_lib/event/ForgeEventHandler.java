package net.jelly.marionette_lib.event;

import net.jelly.marionette_lib.MarionetteMod;
import net.jelly.marionette_lib.global.RedstoneIndexData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = MarionetteMod.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ForgeEventHandler {
    // COMMANDS
    // RegisterCommands is for server commands, RegisterClientCommands for client commands
    @SubscribeEvent
    public static void RegisterCommands(RegisterCommandsEvent event) {

    }

    @SubscribeEvent
    public static void levelTick(TickEvent.PlayerTickEvent event) {
        if (event.player.level() instanceof ServerLevel serverLevel) {
            RedstoneIndexData indexData = RedstoneIndexData.get(serverLevel.getServer().getLevel(Level.OVERWORLD));
            int index = indexData.get();
//            System.out.println(index);
//            indexData.add(1);
        }
    }


    @SubscribeEvent
    public static void blockPlaced(BlockEvent.EntityPlaceEvent event) {
        RedstoneIndexData indexData = RedstoneIndexData.get(event.getLevel().getServer().getLevel(Level.OVERWORLD));
        int index = indexData.get();
        System.out.println(event.getPlacedBlock().getBlock() + " is " + RedstoneIndexData.isTechBlock(event.getPlacedBlock().getBlock()));
        if(RedstoneIndexData.isTechBlock(event.getPlacedBlock().getBlock()))
            RedstoneIndexData.get(event.getLevel().getServer().getLevel(Level.OVERWORLD)).add(1);
        else if (event.getPlacedBlock().is(Blocks.SLIME_BLOCK))
            RedstoneIndexData.get(event.getLevel().getServer().getLevel(Level.OVERWORLD)).set(0);
        System.out.println(indexData.get());
    }

}

