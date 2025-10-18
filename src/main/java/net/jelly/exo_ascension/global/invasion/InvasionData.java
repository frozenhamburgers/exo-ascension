package net.jelly.exo_ascension.global.invasion;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.saveddata.SavedData;

import java.util.List;

public class InvasionData extends SavedData {
    private int stage = 0; // stage -1 = invasion not active
    private int progress = 0;

    // list of stages
    public static final List<InvasionStage> STAGES = List.of(
            new InvasionStage(0, 60, 18, 32.0, 2)
                    .addEnemy(EntityType.ZOMBIE, 5)
                    .addEnemy(EntityType.SKELETON, 3)
                    .addEnemy(EntityType.CREEPER, 1),

            new InvasionStage(1, 30, 10, 32.0, 2)
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

