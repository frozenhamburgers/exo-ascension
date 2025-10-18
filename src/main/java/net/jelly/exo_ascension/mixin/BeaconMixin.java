package net.jelly.exo_ascension.mixin;

import net.jelly.exo_ascension.global.pollution.PollutionHandler;
import net.jelly.exo_ascension.global.pollution.RedstoneIndexData;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BeaconBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BeaconBlockEntity.class)
public abstract class BeaconMixin {

    @Inject(method = "tick", at = @At("HEAD"))
    private static void onBeaconTick(Level level, BlockPos pos, BlockState state, BeaconBlockEntity beacon, CallbackInfo ci) {
        if (level.isClientSide()) return;

        // only pollute if the beacon is active
        if (!beacon.getBeamSections().isEmpty()) {
            RedstoneIndexData.get(level.getServer().getLevel(Level.OVERWORLD)).add(PollutionHandler.BEACON_POLLUTION);
        }
    }

}