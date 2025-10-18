package net.jelly.exo_ascension.global.invasion;

import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EntityType;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class InvasionStage {
    private final List<EnemyEntry> enemies = new ArrayList<>();
    public final int spawnTime;    // ticks between waves
    public final double minDist;   // minimum distance from player
    public final double maxDist;   // maximum distance from player
    public final int spawnCount;   // number of enemies to spawn per player per wave
    public final int stageId;
    public final int requiredProgress;
    public final int restTime;

    public InvasionStage(int stageId, int spawnTime, double minDist, double maxDist, int spawnCount, int requiredProgress, int restTime) {
        this.stageId = stageId;
        this.spawnTime = spawnTime;
        this.minDist = minDist;
        this.maxDist = maxDist;
        this.spawnCount = spawnCount;
        this.requiredProgress = requiredProgress;
        this.restTime = restTime;
    }

    public InvasionStage addEnemy(EntityType<?> type, int weight) {
        enemies.add(new EnemyEntry(type, weight));
        return this;
    }

    /**
     * Weighted random pick of a single enemy type.
     */
    public EntityType<?> pickRandomEnemy(RandomSource rand) {
        if (enemies.isEmpty()) return null;
        int total = 0;
        for (EnemyEntry e : enemies) total += e.weight;
        int roll = rand.nextInt(total);
        for (EnemyEntry e : enemies) {
            roll -= e.weight;
            if (roll < 0) return e.type;
        }
        return enemies.get(enemies.size()-1).type;
    }

    /**
     * Build a list of EntityType to spawn for a single wave (size = spawnCount).
     */
    public List<EntityType<?>> buildWave(RandomSource rand) {
        List<EntityType<?>> list = new ArrayList<>(spawnCount);
        for (int i = 0; i < spawnCount; i++) {
            EntityType<?> type = pickRandomEnemy(rand);
            if (type != null) list.add(type);
        }
        return list;
    }

    public int getStageId() { return stageId; }

    /** Simple nested struct for weighted enemy entry */
    public static class EnemyEntry {
        public final EntityType<?> type;
        public final int weight;

        public EnemyEntry(EntityType<?> type, int weight) {
            this.type = type;
            this.weight = Math.max(1, weight);
        }
    }
}


