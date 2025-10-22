package net.jelly.exo_ascension.global.invasion;

import net.jelly.exo_ascension.ExoAscensionMod;
import net.jelly.exo_ascension.entity.ModEntities;
import net.jelly.exo_ascension.entity.invasion.aetherion.AetherionBoss;
import net.jelly.exo_ascension.entity.invasion.aetherion.AetherionPartEntity;
import net.jelly.exo_ascension.entity.invasion.drone.DroneEntity;
import net.jelly.exo_ascension.entity.invasion.gorgon.GorgonEntity;
import net.jelly.exo_ascension.entity.invasion.gorgon.GorgonPartEntity;
import net.jelly.exo_ascension.entity.invasion.grappler.GrapplerEntity;
import net.jelly.exo_ascension.entity.invasion.grappler.GrapplerPartEntity;
import net.jelly.exo_ascension.entity.invasion.leech.LeechEntity;
import net.jelly.exo_ascension.entity.invasion.leech.LeechPartEntity;
import net.jelly.exo_ascension.entity.invasion.spider.SpiderEntity;
import net.jelly.exo_ascension.entity.invasion.spider.SpiderPartEntity;
import net.jelly.exo_ascension.global.pollution.PollutionHandler;
import net.jelly.exo_ascension.global.pollution.RedstoneIndexData;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerBossEvent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.BossEvent;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.saveddata.SavedData;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

import static net.jelly.exo_ascension.global.invasion.InvasionSpawner.getRandomSpawnPos;

public class InvasionData extends SavedData {
    private int stage = -1; // stage -1 = invasion not active
    private float progress = 0;
    protected final ServerBossEvent progressBar = new ServerBossEvent(Component.literal("Stage"),
            BossEvent.BossBarColor.BLUE, BossEvent.BossBarOverlay.PROGRESS);
    public boolean stagePrelude = true;
    private int preludeTime = 0;
    private boolean bossSpawned = false;

    // list of stages
    public static final List<InvasionStage> STAGES = List.of(
            // stage 1: just drones
            new InvasionStage(0, 100, 18, 26.0, 2, 10, 1000)
                    .addEnemy(ModEntities.DRONE.get(), 1),
            // stage 2: drones and leeches
            new InvasionStage(1, 150, 10, 32.0, 3, 40, 300)
                    .addEnemy(ModEntities.DRONE.get(), 4)
                    .addEnemy(ModEntities.LEECH.get(), 1),
            // stage 3: drones and grapplers
            new InvasionStage(2, 150, 10, 32.0, 3, 40, 900)
                    .addEnemy(ModEntities.DRONE.get(), 4)
                    .addEnemy(ModEntities.GRAPPLER.get(), 1),
            // stage 4: all three low class enemies
            new InvasionStage(3, 200, 15, 40.0, 4, 100, 600)
                    .addEnemy(ModEntities.DRONE.get(), 3)
                    .addEnemy(ModEntities.GRAPPLER.get(), 1)
                    .addEnemy(ModEntities.LEECH.get(), 1),
            // stage 5: introduce the spider
            new InvasionStage(4, 225, 10, 32.0, 3, 100, 300)
                    .addEnemy(ModEntities.LEECH.get(), 2)
                    .addEnemy(ModEntities.SPIDER.get(), 2),
            // stage 6: introduce the gorgon
            new InvasionStage(5, 255, 10, 32.0, 3, 100, 300)
                    .addEnemy(ModEntities.DRONE.get(), 3)
                    .addEnemy(ModEntities.GORGON.get(), 2),
            // stage 7: final stage
            new InvasionStage(6, 250, 20, 50.0, 5, 200, 600)
                    .addEnemy(ModEntities.DRONE.get(), 5)
                    .addEnemy(ModEntities.GRAPPLER.get(), 1)
                    .addEnemy(ModEntities.LEECH.get(), 2)
                    .addEnemy(ModEntities.SPIDER.get(), 2)
                    .addEnemy(ModEntities.GORGON.get(), 2),
            // stage 8: Aetherion
            new BossStage(7, 200, 900)

    );

    public static InvasionData get(ServerLevel level) {
        return level.getDataStorage().computeIfAbsent(
                InvasionData::load,
                InvasionData::new,
                "invasion_data"
        );
    }

    public void tick() {

    }

    public int getStage() {
        return stage;
    }

    public void setStage(int newStage) {
        if (this.stage != newStage) {
            this.stagePrelude = true;
            this.preludeTime = 0;
            this.stage = newStage;
            this.progress = 0;
            this.bossSpawned = false;
            setDirty();
        }
    }

    public float getProgress() {
        return progress;
    }
    public void addProgress(float p) {
        if(this.stagePrelude || stage < 0) return;
        progress = Math.min(progress+p, STAGES.get(stage).requiredProgress);
    }

    public void setProgress(float p) {
        if(this.stagePrelude || stage < 0) return;
        progress = Math.min(p, STAGES.get(stage).requiredProgress);
    }

    @Mod.EventBusSubscriber(modid = ExoAscensionMod.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
    public class InvasionForgeEvents {
        @SubscribeEvent // show boss bar to players in overworld
        public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
            if(event.player instanceof ServerPlayer) {
                InvasionData data = InvasionData.get(event.player.getServer().getLevel(Level.OVERWORLD));
                if(data.stage < 0) {
                    data.progressBar.removePlayer((ServerPlayer)(event.player));
                    return;
                }
                if(event.player.level().dimension() == Level.OVERWORLD) data.progressBar.addPlayer((ServerPlayer)(event.player));
                else data.progressBar.removePlayer((ServerPlayer)(event.player));
            }
        }

        @SubscribeEvent
        public static void onServerTick(TickEvent.ServerTickEvent event) {
            InvasionData data = InvasionData.get(event.getServer().getLevel(Level.OVERWORLD));
            RedstoneIndexData indexData = RedstoneIndexData.get(event.getServer().getLevel(Level.OVERWORLD));
            float progress = data.getProgress();
            int stageIndex = data.getStage();
            if(stageIndex < 0) {
                if(indexData.get() >= PollutionHandler.MAX_POLLUTION) data.setStage(0); // begin invasion
                return;
            }
            else if(stageIndex >= InvasionData.STAGES.size()) {
                data.setStage(-1);
                indexData.set(0); // reset pollution
                return;
            }
            int maxProgress = STAGES.get(stageIndex).requiredProgress;
            int restTime = STAGES.get(stageIndex).preludeTime;
            // update boss bar
            if(!data.stagePrelude) data.progressBar.setProgress(1 - ((float)progress / maxProgress));
            data.progressBar.setName(Component.literal("Stage " + stageIndex));

            // manage stages
            if(progress >= maxProgress) {
                int nextStage = -1;
                if(stageIndex + 1 < InvasionData.STAGES.size()) nextStage = stageIndex+1;
                if(nextStage == -1) indexData.set(0); // reset pollution
                data.setStage(nextStage);
            }
            if(data.stagePrelude) {
                data.preludeTime++;
                data.progressBar.setProgress((float)data.preludeTime / restTime);
                if(data.preludeTime >= restTime) {
                    data.stagePrelude = false;
                    data.preludeTime = 0;
                }
            }

            // handle boss spawning
            if(stageIndex == 7 && !data.stagePrelude && !data.bossSpawned) {
                ServerLevel level = event.getServer().getLevel(Level.OVERWORLD);
                ServerPlayer player = level.getRandomPlayer();
                BlockPos spawnPos = getRandomSpawnPos(level, player, level.getRandom(), 20, 40);
                if(spawnPos != null) {
                    ModEntities.AETHERION.get().spawn(level, spawnPos, MobSpawnType.MOB_SUMMONED);
                    data.bossSpawned = true;
                }
            }
        }

        // DEBUG
//        @SubscribeEvent
//        public static void blockPlaced(BlockEvent.EntityPlaceEvent event) {
//            InvasionData data = InvasionData.get(event.getLevel().getServer().getLevel(Level.OVERWORLD));
//            if (event.getPlacedBlock().is(Blocks.AMETHYST_BLOCK))
//                data.setStage(data.getStage()+1);
//            data.bossSpawned = false;
//        }

    }

    public static InvasionData load(CompoundTag nbt) {
        InvasionData data = new InvasionData();
        data.stage = nbt.getInt("stage");
        data.progress = nbt.getFloat("progress");
        data.bossSpawned = nbt.getBoolean("bossSpawned");
        return data;
    }

    @Override
    public CompoundTag save(CompoundTag nbt) {
        nbt.putInt("stage", stage);
        nbt.putFloat("progress", progress);
        nbt.putBoolean("bossSpawned", bossSpawned);
        return nbt;
    }

    public static boolean isInvasionMob(Entity mob) {
        return (mob instanceof DroneEntity ||
                mob instanceof LeechEntity ||
                mob instanceof LeechPartEntity ||
                mob instanceof GrapplerEntity ||
                mob instanceof GrapplerPartEntity ||
                mob instanceof SpiderEntity ||
                mob instanceof SpiderPartEntity ||
                mob instanceof GorgonEntity ||
                mob instanceof GorgonPartEntity) ||
                mob instanceof AetherionBoss ||
                mob instanceof AetherionPartEntity;

    }
}

