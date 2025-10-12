package net.jelly.marionette_lib.event;

import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.shaders.AbstractUniform;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.*;
import net.jelly.marionette_lib.MarionetteMod;

import net.jelly.marionette_lib.global.RedstoneIndexData;
import net.jelly.marionette_lib.post_processing.RedTintFx;
import net.jelly.marionette_lib.post_processing.RedTintProcessor;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ShaderInstance;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterShadersEvent;
import net.minecraftforge.client.event.RenderLevelStageEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import org.joml.Vector3f;
import team.lodestar.lodestone.systems.postprocess.PostProcessHandler;

import java.io.IOException;


public class ClientEvents {
    public static ShaderInstance CUSTOM_SKY_SHADER;
    public static ShaderInstance METEORS_SHADER;

    // FORGE CLIENT EVENTS
    @Mod.EventBusSubscriber(modid = MarionetteMod.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
    public static class ForgeClientEvents {
        static int clientRedstoneIndex = 0;
        static RedTintFx redTint;

        @SubscribeEvent
        public static void renderSkyEffects(RenderLevelStageEvent event) {
            if (event.getStage() != RenderLevelStageEvent.Stage.AFTER_SKY) return;
            if (CUSTOM_SKY_SHADER == null) return;

            Minecraft mc = Minecraft.getInstance();
            if (mc.level == null) return;

            // continuous seconds (ticks/20.0) including partial tick for smoothness
            float totalSeconds = (mc.level.getGameTime() + event.getPartialTick()) / 20.0f;

            // bind shader and set uniforms
            AbstractUniform u;

            // CORE SHADERS
            float redHourIntensity = clientRedstoneIndex / 100f;
            RenderSystem.setShader(() -> CUSTOM_SKY_SHADER);
            if ((u = CUSTOM_SKY_SHADER.safeGetUniform("TotalTime")) != null) u.set(totalSeconds);
            if ((u = CUSTOM_SKY_SHADER.safeGetUniform("RedHourIntensity")) != null) u.set(redHourIntensity);
            RenderSystem.enableBlend();
            RenderSystem.defaultBlendFunc();
//            RenderSystem.blendFunc(GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ONE);

            // draw fullscreen quad
            Tesselator tess = Tesselator.getInstance();
            BufferBuilder buf = tess.getBuilder();
            buf.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION);
            buf.vertex(-1.0, -1.0, 0.0).endVertex();
            buf.vertex( 1.0, -1.0, 0.0).endVertex();
            buf.vertex( 1.0,  1.0, 0.0).endVertex();
            buf.vertex(-1.0,  1.0, 0.0).endVertex();
            BufferUploader.drawWithShader(buf.end());

            // bind shader and set uniforms
            RenderSystem.setShader(() -> METEORS_SHADER);
            if ((u = METEORS_SHADER.safeGetUniform("TotalTime")) != null) u.set(totalSeconds);
            if ((u = METEORS_SHADER.safeGetUniform("MeteorDensity")) != null) u.set(redHourIntensity);
            if ((u = METEORS_SHADER.safeGetUniform("MeteorBrightness")) != null) u.set(1.0f);
            if ((u = METEORS_SHADER.safeGetUniform("MeteorLength")) != null) u.set(1.0f);
            if ((u = METEORS_SHADER.safeGetUniform("MeteorSpeed")) != null) u.set(0.6f);
            if ((u = METEORS_SHADER.safeGetUniform("MeteorColor")) != null) u.set(new Vector3f(1.0f, 0.8f, 0.6f));
//            RenderSystem.defaultBlendFunc();
            RenderSystem.blendFunc(GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ONE);

            // draw fullscreen quad
            buf.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION);
            buf.vertex(-1.0, -1.0, 0.0).endVertex();
            buf.vertex( 1.0, -1.0, 0.0).endVertex();
            buf.vertex( 1.0,  1.0, 0.0).endVertex();
            buf.vertex(-1.0,  1.0, 0.0).endVertex();
            BufferUploader.drawWithShader(buf.end());
            RenderSystem.disableBlend();

            // POST SHADERS
            redTint.intensity = redHourIntensity/2;
        }

        @SubscribeEvent
        public static void onRenderTick(TickEvent.RenderTickEvent event) {
        }

        @SubscribeEvent
        public static void onLevelTIck(TickEvent.LevelTickEvent event) {
            // initialize post processing shaders
            if(redTint == null) {
                redTint = new RedTintFx(0f, new Vector3f(1.0f, 0.2f, 0.2f));
                RedTintProcessor.INSTANCE.addFxInstance(redTint);
            }

            if(event.side == LogicalSide.SERVER) {
                // update redstone index on client
                RedstoneIndexData indexData = RedstoneIndexData.get(event.level.getServer().getLevel(Level.OVERWORLD));
                clientRedstoneIndex = indexData.get();
            }

        }

    }


    // MOD CLIENT EVENTS
    @Mod.EventBusSubscriber(modid = MarionetteMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ModClientEvents {
        // events that implement IModBusEvent are mod bus events

        // shaders
        @SubscribeEvent
        public static void onRegisterShaders(RegisterShadersEvent event) {
            try {
                event.registerShader(
                        new ShaderInstance(
                                Minecraft.getInstance().getResourceManager(),
                                new ResourceLocation(MarionetteMod.MODID, "red_hour"), // matches JSON file
                                DefaultVertexFormat.BLIT_SCREEN
                        ),
                        shader -> CUSTOM_SKY_SHADER = shader
                );
                event.registerShader(
                        new ShaderInstance(
                                Minecraft.getInstance().getResourceManager(),
                                new ResourceLocation(MarionetteMod.MODID, "meteors"), // matches JSON file
                                DefaultVertexFormat.BLIT_SCREEN
                        ),
                        shader -> METEORS_SHADER = shader
                );
            } catch (IOException e) {
                throw new RuntimeException("Failed to load shader", e);
            }
        }


        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            // register lodestone post shaders
            PostProcessHandler.addInstance(RedTintProcessor.INSTANCE);
        }
    }
}

