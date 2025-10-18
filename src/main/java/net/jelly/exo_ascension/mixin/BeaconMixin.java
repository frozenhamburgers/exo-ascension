package net.jelly.exo_ascension.mixin;

import com.mojang.blaze3d.pipeline.RenderTarget;
import com.mojang.blaze3d.platform.GlConst;
import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import net.jelly.exo_ascension.global.PollutionHandler;
import net.jelly.exo_ascension.global.RedstoneIndexData;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BeaconBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.nio.IntBuffer;

import static org.lwjgl.opengl.GL30C.GL_RGBA16F;

@Mixin(BeaconBlockEntity.class)
public abstract class BeaconMixin {

    @Inject(method = "tick", at = @At("HEAD"))
    private static void onBeaconTick(Level level, BlockPos pos, BlockState state, BeaconBlockEntity beacon, CallbackInfo ci) {
        if (level.isClientSide()) return;
        System.out.println("beacon tick");
        // only pollute if the beacon is active
        if (!beacon.getBeamSections().isEmpty()) {
            System.out.println("POLLUTE");
            RedstoneIndexData.get(level.getServer().getLevel(Level.OVERWORLD)).add(PollutionHandler.BEACON_POLLUTION);
        }
    }

}