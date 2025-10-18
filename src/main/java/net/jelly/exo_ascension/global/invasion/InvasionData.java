package net.jelly.exo_ascension.global.invasion;

import net.jelly.exo_ascension.ExoAscensionMod;
import net.jelly.exo_ascension.entity.ModEntities;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerBossEvent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.BossEvent;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.saveddata.SavedData;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

public class InvasionData extends SavedData {
    private int stage = 0; // stage -1 = invasion not active
    private int progress = 0;
    protected final ServerBossEvent progressBar = new ServerBossEvent(Component.literal("test"),
            BossEvent.BossBarColor.BLUE, BossEvent.BossBarOverlay.PROGRESS);

    // list of stages
    public static final List<InvasionStage> STAGES = List.of(
            new InvasionStage(0, 300, 18, 26.0, 2, 40)
                    .addEnemy(ModEntities.DRONE.get(), 1),

            new InvasionStage(1, 30, 10, 32.0, 2, 100)
                    .addEnemy(EntityType.HUSK, 4)
                    .addEnemy(EntityType.WITHER_SKELETON, 2)
    );

    public static InvasionData get(ServerLevel level) {
        return level.getDataStorage().computeIfAbsent(
                InvasionData::load,
                InvasionData::new,
                "invasion_data"
        );
    }

    public void tick() {
//        if (stage > 0) {
//            progress++;
//            setDirty();
//        }
    }

    public int getStage() {
        return stage;
    }

    public void setStage(int newStage) {
        if (this.stage != newStage) {
            this.stage = newStage;
            this.progress = 0;
            setDirty();
        }
    }

    public int getProgress() {
        return progress;
    }
    public void addProgress(int p) {
        progress = Math.min(progress+p, STAGES.get(stage).requiredProgress);
    }

    @Mod.EventBusSubscriber(modid = ExoAscensionMod.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
    public class BossBarEvents {
        @SubscribeEvent
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
            int progress = data.getProgress();
            int maxProgress = STAGES.get(data.getStage()).requiredProgress;
            data.progressBar.setProgress(1 - ((float)progress / maxProgress));
        }

    }

    public static InvasionData load(CompoundTag nbt) {
        InvasionData data = new InvasionData();
        data.stage = nbt.getInt("stage");
        data.progress = nbt.getInt("progress");
        return data;
    }

    @Override
    public CompoundTag save(CompoundTag nbt) {
        nbt.putInt("stage", stage);
        nbt.putInt("progress", progress);
        return nbt;
    }
}

