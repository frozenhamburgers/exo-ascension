package net.jelly.exo_ascension.mixin;

import net.jelly.exo_ascension.global.invasion.InvasionSpawner;
import net.jelly.exo_ascension.global.pollution.PollutionHandler;
import net.jelly.exo_ascension.global.pollution.RedstoneIndexData;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.progress.ChunkProgressListener;
import net.minecraft.world.RandomSequences;
import net.minecraft.world.level.CustomSpawner;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BeaconBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.dimension.LevelStem;
import net.minecraft.world.level.storage.LevelStorageSource;
import net.minecraft.world.level.storage.ServerLevelData;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

@Mixin(ServerLevel.class)
public abstract class ServerLevelMixin {
    @Shadow
    @Final
    private List<CustomSpawner> customSpawners;

    @Inject(method = "<init>", at = @At("TAIL"))
    private void exoascension$addCustomSpawner(MinecraftServer server,
                                               Executor executor,
                                               LevelStorageSource.LevelStorageAccess storage,
                                               ServerLevelData levelData,
                                               ResourceKey<Level> dimension,
                                               LevelStem stem,
                                               ChunkProgressListener listener,
                                               boolean isDebug,
                                               long seed,
                                               List<CustomSpawner> spawners,
                                               boolean tickTime,
                                               RandomSequences randomSequences,
                                               CallbackInfo ci) {
        if (dimension != Level.OVERWORLD) return;
        List<CustomSpawner> mutableList = new ArrayList<>(this.customSpawners);
        mutableList.add(new InvasionSpawner());

        try {
            Field field = ServerLevel.class.getDeclaredField("customSpawners");
            field.setAccessible(true);
            field.set(this, mutableList);
            System.out.println("[AnabasisExoAscension] Added InvasionSpawner to " + dimension.location());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
