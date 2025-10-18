package net.jelly.exo_ascension.global.pollution;

import net.minecraft.server.level.ServerLevel;

import java.util.HashMap;
import java.util.Map;

public class ChunkPollutionTracker {
    public static final int CHUNK_POLLUTION_CAP = 40; // maximum amount of pollution a chunk can produce in a tick
    public static final float CHUNK_POLLUTION_EXP_DAMP = 0.04f; // exponential dampening for chunk pollution. Higher this value, the less redstone updates per chunk will be needed to reach the chunk pollution cap.
    public static final float REDSTONE_POLLUTION_MULTIPLIER = 1f; // overall multiplier for redstone pollution
    private static final Map<Long, Integer> chunkPollutionMap = new HashMap<>();

    // record # of redstone block updates caused by a chunk
    public static void record(long chunkKey, int amount) {
        chunkPollutionMap.merge(chunkKey, amount, (oldVal, newVal) -> (oldVal + newVal));
    }

    //
    public static void applyPollution(ServerLevel level) {
        if (chunkPollutionMap.isEmpty()) return;

        RedstoneIndexData indexData = RedstoneIndexData.get(level.getServer().getLevel(ServerLevel.OVERWORLD));
        int total = 0;
        int totalRaw = 0;
        for (int rawIncrement : chunkPollutionMap.values()) {
            totalRaw += rawIncrement;
        }
        double effective = CHUNK_POLLUTION_CAP * (1 - Math.exp(-CHUNK_POLLUTION_EXP_DAMP * totalRaw));
        total += (int) effective;

        System.out.println("raw pollution + " + totalRaw);
        System.out.println("pollution + " + (int)(total * REDSTONE_POLLUTION_MULTIPLIER));
        indexData.add((int)(total * REDSTONE_POLLUTION_MULTIPLIER)); // global scaling
        chunkPollutionMap.clear();
    }
}
