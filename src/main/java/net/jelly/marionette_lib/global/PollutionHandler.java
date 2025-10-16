package net.jelly.marionette_lib.global;

import net.jelly.marionette_lib.MarionetteMod;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.event.level.PistonEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.*;

@Mod.EventBusSubscriber(modid = MarionetteMod.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class PollutionHandler {
    public static final int MAX_POLLUTION = 10000;
    private static ChunkPollutionTracker POLLUTION_TRACKER = new ChunkPollutionTracker();

    @SubscribeEvent
    public static void blockPlaced(BlockEvent.EntityPlaceEvent event) {
        RedstoneIndexData indexData = RedstoneIndexData.get(event.getLevel().getServer().getLevel(Level.OVERWORLD));
//        if(RedstoneIndexData.isTechBlock(event.getPlacedBlock().getBlock()))
//            RedstoneIndexData.get(event.getLevel().getServer().getLevel(Level.OVERWORLD)).add(1);
        if (event.getPlacedBlock().is(Blocks.SLIME_BLOCK))
            RedstoneIndexData.get(event.getLevel().getServer().getLevel(Level.OVERWORLD)).set(0);
        System.out.println(indexData.get());
    }

    @SubscribeEvent
    public static void blockMined(BlockEvent.BreakEvent event) {
        RedstoneIndexData indexData = RedstoneIndexData.get(event.getLevel().getServer().getLevel(Level.OVERWORLD));
//        System.out.println(event.getState().getBlock() + " is " + RedstoneIndexData.isTechBlock(event.getState().getBlock()));
//        if(RedstoneIndexData.isTechBlock(event.getState().getBlock()))
//            RedstoneIndexData.get(event.getLevel().getServer().getLevel(Level.OVERWORLD)).subtract(1);
        if (event.getState().is(Blocks.SLIME_BLOCK))
            RedstoneIndexData.get(event.getLevel().getServer().getLevel(Level.OVERWORLD)).set(MAX_POLLUTION);
        System.out.println(indexData.get());
    }

    // adds pollution based on redstone updates
    @Mod.EventBusSubscriber
    public class RedstoneActivityListener {

        private static final Set<BlockPos> RECENTLY_UPDATED = Collections.newSetFromMap(new WeakHashMap<>());
        private static final int CACHE_TTL_TICKS = 2; // keep entries for 2 ticks
        private static long lastCleanupTick = 0;

        @SubscribeEvent
        public static void onRedstoneChange(BlockEvent.NeighborNotifyEvent event) {
            if (event.getLevel().isClientSide()) return;
            ServerLevel level = (ServerLevel) event.getLevel();
            long tick = level.getGameTime();

            // cleanup
            if (tick - lastCleanupTick > CACHE_TTL_TICKS) {
                RECENTLY_UPDATED.clear();
                lastCleanupTick = tick;
            }

            BlockPos pos = event.getPos();
            BlockState state = event.getState();

            // only consider signal sources
            if (!state.isSignalSource()) return;

            // prevent multiple updates in the same 2 ticks
            if (RECENTLY_UPDATED.contains(pos)) return;
            RECENTLY_UPDATED.add(pos);
            long chunkKey = level.getChunk(pos).getPos().toLong();

            POLLUTION_TRACKER.record(chunkKey, 1);
        }

        public static final float PISTON_POLLUTION = 1f; // # of block updates worth of pollution for a piston extension/retraction
        @SubscribeEvent
        public static void onPistonActivated(PistonEvent.Pre event) {
            if (event.getLevel().isClientSide()) return;
            Level level = (Level) event.getLevel();
            RedstoneIndexData indexData = RedstoneIndexData.get(level.getServer().getLevel(Level.OVERWORLD));
            long chunkKey = level.getChunk(event.getPos()).getPos().toLong();
            POLLUTION_TRACKER.record(chunkKey, 10);
        }

        @SubscribeEvent
        public static void serverTick(TickEvent.ServerTickEvent event) {
            // flush chunk pollution into global pollution
            POLLUTION_TRACKER.applyPollution(event.getServer().getLevel(Level.OVERWORLD));
        }
    }




}

