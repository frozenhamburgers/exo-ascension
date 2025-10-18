package net.jelly.exo_ascension.global.invasion;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.CustomSpawner;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.phys.Vec3;
import org.joml.Vector3f;

import java.util.List;

public class InvasionSpawner implements CustomSpawner {

    // ticks until next wave
    private int nextSpawnTime = 0;
    private int lastStageId = -1; // reset timer when stage changes

    @Override
    public int tick(ServerLevel level, boolean spawnHostiles, boolean spawnPassives) {
        if (!spawnHostiles) return 0;

        InvasionData data = InvasionData.get(level);
        int stageIndex = data.getStage();
        if (stageIndex < 0 || stageIndex >= InvasionData.STAGES.size()) return 0;
        InvasionStage stage = InvasionData.STAGES.get(stageIndex);
        if (stage == null) return 0;
        if (data.restStage) return 0;

        // if stage changed
        if (lastStageId != stage.getStageId()) {
            lastStageId = stage.getStageId();
            nextSpawnTime = 0; // spawn immediately
        }

        if (nextSpawnTime > 0) {
            nextSpawnTime--;
            return 0;
        }

        nextSpawnTime = Math.max(1, stage.spawnTime);

        int spawnedTotal = 0;
        RandomSource rand = level.getRandom();

        // spawn for each non-spectator player
        List<ServerPlayer> players = level.players();
        for (ServerPlayer player : players) {
            if (player.isSpectator()) continue;

            List<EntityType<?>> wave = stage.buildWave(rand);

            for (EntityType<?> type : wave) {
                BlockPos spawnPos = getRandomSpawnPos(level, player, rand, stage.minDist, stage.maxDist);
                if (spawnPos == null) continue;

                try {
                    type.spawn(level, spawnPos, MobSpawnType.EVENT);
                    spawnedTotal++;
//                    Vector3f spawnVec = spawnPos.getCenter().toVector3f();
//                    Entity entity = type.create(level);
//                    if (entity instanceof Mob mob) {
//                        mob.moveTo(spawnVec.x, spawnVec.y, spawnVec.z, rand.nextFloat() * 360.0F, 0.0F);
//                        mob.finalizeSpawn(level, level.getCurrentDifficultyAt(spawnPos), MobSpawnType.EVENT, null, null);
//                        level.addFreshEntity(mob);
//                        spawnedTotal++;
//                    } else if (entity != null) {
//                        // fallback for non-mob entity types
//                        entity.moveTo(spawnVec.x, spawnVec.y, spawnVec.z, rand.nextFloat() * 360.0F, 0.0F);
//                        level.addFreshEntity(entity);
//                        spawnedTotal++;
//                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }

        System.out.println("SStage: " + stageIndex + ", Spawned: " + spawnedTotal);
        return spawnedTotal;
    }

    /**
     * Attempts up to 10 times to find a valid spawn position between minDist and maxDist from the player.
     * Returns the bottom-center null if none found.
     */
    private BlockPos getRandomSpawnPos(ServerLevel level, Player targetPlayer, RandomSource rand, double minDist, double maxDist) {
        BlockPos candidate = null;
        for (int attempt = 0; attempt < 20; attempt++) {
            // pick random angle and distance
            double angle = rand.nextDouble() * Math.PI * 2.0;
            double distance = minDist + rand.nextDouble() * (maxDist - minDist);
            double x = targetPlayer.getX() + Math.cos(angle) * distance;
            double z = targetPlayer.getZ() + Math.sin(angle) * distance;

            int y = level.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) Math.floor(x), (int) Math.floor(z));
            BlockPos pos = new BlockPos((int) Math.floor(x), y, (int) Math.floor(z));

            // must not be too close to any player
            boolean tooClose = false;
            for (Player p : level.players()) {
                if (p.isSpectator()) continue;
                double distSq = p.distanceToSqr(pos.getX() + 0.5, pos.getY(), pos.getZ() + 0.5);
                if (distSq < (minDist * minDist)) {
                    tooClose = true;
                    break;
                }
            }
            if (tooClose) continue;
            candidate = pos;
            break;
        }
        return candidate;
    }

}

