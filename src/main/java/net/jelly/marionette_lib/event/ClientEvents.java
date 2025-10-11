package net.jelly.marionette_lib.event;

import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.shaders.AbstractUniform;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.*;
import net.jelly.marionette_lib.MarionetteMod;
import net.jelly.marionette_lib.entity.examples.octopus.OctopusModel;
import net.jelly.marionette_lib.entity.examples.octopus.OctopusRenderer;
import net.jelly.marionette_lib.entity.examples.worm.WormModel;
import net.jelly.marionette_lib.entity.examples.worm.WormRenderer;
import net.jelly.marionette_lib.entity.examples.wyvern.WyvernModel;
import net.jelly.marionette_lib.entity.examples.wyvern.WyvernRenderer;
import net.jelly.marionette_lib.global.RedstoneIndexData;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ShaderInstance;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.RegisterShadersEvent;
import net.minecraftforge.client.event.RenderLevelStageEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import org.joml.Vector3f;

import java.io.IOException;


public class ClientEvents {
    public static ShaderInstance CUSTOM_SKY_SHADER;
    public static ShaderInstance METEORS_SHADER;

    // FORGE CLIENT EVENTS
    @Mod.EventBusSubscriber(modid = MarionetteMod.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
    public static class ForgeClientEvents {
        static int clientRedstoneIndex = 0;

        @SubscribeEvent
        public static void onRenderLevelStage(RenderLevelStageEvent event) {
            if (event.getStage() != RenderLevelStageEvent.Stage.AFTER_SKY) return;
            if (CUSTOM_SKY_SHADER == null) return;

            Minecraft mc = Minecraft.getInstance();
            if (mc.level == null) return;

            // continuous seconds (ticks/20.0) including partial tick for smoothness
            float totalSeconds = (mc.level.getGameTime() + event.getPartialTick()) / 20.0f;

            // example intensity (compute this from your game logic)
            float redHourIntensity = clientRedstoneIndex / 100f;

            // bind shader and set uniforms
            RenderSystem.setShader(() -> CUSTOM_SKY_SHADER);
            CUSTOM_SKY_SHADER.safeGetUniform("TotalTime").set(totalSeconds);
            CUSTOM_SKY_SHADER.safeGetUniform("RedHourIntensity").set(redHourIntensity);
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
            AbstractUniform u;
            if ((u = METEORS_SHADER.safeGetUniform("TotalTime")) != null) u.set(totalSeconds);
            if ((u = METEORS_SHADER.safeGetUniform("MeteorDensity")) != null) u.set(20000.0f);
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
        }


        @SubscribeEvent
        public static void onRenderTick(TickEvent.RenderTickEvent event) {
        }

        @SubscribeEvent
        public static void onLevelTIck(TickEvent.LevelTickEvent event) {
            if(event.side == LogicalSide.SERVER) {
                RedstoneIndexData indexData = RedstoneIndexData.get(event.level.getServer().getLevel(Level.OVERWORLD));
                clientRedstoneIndex = indexData.get();
                System.out.println(indexData.get());
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
            // register shaders
        }

        @SubscribeEvent
        public static void registerRenderers(FMLClientSetupEvent event) {
        }

        @SubscribeEvent
        public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event) {
            event.registerLayerDefinition(WormRenderer.WORM_LAYER, WormModel::createBodyLayer);
            event.registerLayerDefinition(OctopusRenderer.OCTOPUS_LAYER, OctopusModel::createBodyLayer);
            event.registerLayerDefinition(WyvernRenderer.WYVERN_LAYER, WyvernModel::createBodyLayer);
        }

    }
}

