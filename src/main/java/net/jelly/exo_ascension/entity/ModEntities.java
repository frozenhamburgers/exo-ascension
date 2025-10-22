package net.jelly.exo_ascension.entity;

import net.jelly.exo_ascension.ExoAscensionMod;
import net.jelly.exo_ascension.entity.invasion.aetherion.AetherionBoss;
import net.jelly.exo_ascension.entity.invasion.aetherion.AetherionModel;
import net.jelly.exo_ascension.entity.invasion.aetherion.AetherionRenderer;
import net.jelly.exo_ascension.entity.invasion.aetherion.beam.AetherionBeamEntity;
import net.jelly.exo_ascension.entity.invasion.aetherion.beam.AetherionBeamRenderer;
import net.jelly.exo_ascension.entity.invasion.aetherion.laser.AetherionLaserEntity;
import net.jelly.exo_ascension.entity.invasion.aetherion.laser.AetherionLaserRenderer;
import net.jelly.exo_ascension.entity.invasion.aetherion.laser.BlockShardEntity;
import net.jelly.exo_ascension.entity.invasion.gorgon.GorgonEntity;
import net.jelly.exo_ascension.entity.invasion.gorgon.GorgonModel;
import net.jelly.exo_ascension.entity.invasion.gorgon.GorgonRenderer;
import net.jelly.exo_ascension.entity.invasion.grappler.GrapplerEntity;
import net.jelly.exo_ascension.entity.invasion.grappler.GrapplerModel;
import net.jelly.exo_ascension.entity.invasion.grappler.GrapplerRenderer;
import net.jelly.exo_ascension.entity.invasion.leech.LeechEntity;
import net.jelly.exo_ascension.entity.invasion.leech.LeechModel;
import net.jelly.exo_ascension.entity.invasion.leech.LeechRenderer;
import net.jelly.exo_ascension.entity.invasion.drone.DroneEntity;
import net.jelly.exo_ascension.entity.invasion.drone.DroneModel;
import net.jelly.exo_ascension.entity.invasion.drone.DroneRenderer;
import net.jelly.exo_ascension.entity.invasion.spider.SpiderEntity;
import net.jelly.exo_ascension.entity.invasion.spider.SpiderModel;
import net.jelly.exo_ascension.entity.invasion.spider.SpiderRenderer;
import net.minecraft.client.renderer.entity.DisplayRenderer;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, ExoAscensionMod.MODID);

    public static final RegistryObject<EntityType<DroneEntity>> DRONE = ENTITY_TYPES.register("drone", () ->
            EntityType.Builder.of(DroneEntity::new, MobCategory.MISC)
                    .sized(1.0f,1.0f)
                    .build("drone")
    );

    public static final RegistryObject<EntityType<LeechEntity>> LEECH = ENTITY_TYPES.register("leech", () ->
            EntityType.Builder.of(LeechEntity::new, MobCategory.MISC)
                    .sized(1.0f,1.0f)
                    .build("leech")
    );

    public static final RegistryObject<EntityType<GrapplerEntity>> GRAPPLER = ENTITY_TYPES.register("grappler", () ->
            EntityType.Builder.of(GrapplerEntity::new, MobCategory.MISC)
                    .sized(1.0f,2.0f)
                    .build("grappler")
    );

    public static final RegistryObject<EntityType<SpiderEntity>> SPIDER = ENTITY_TYPES.register("spider", () ->
            EntityType.Builder.of(SpiderEntity::new, MobCategory.MISC)
                    .sized(1.0f,1.0f)
                    .build("spider")
    );

    public static final RegistryObject<EntityType<GorgonEntity>> GORGON = ENTITY_TYPES.register("gorgon", () ->
            EntityType.Builder.of(GorgonEntity::new, MobCategory.MISC)
                    .sized(2.0f,2.0f)
                    .build("gorgon")
    );

    public static final RegistryObject<EntityType<AetherionBoss>> AETHERION = ENTITY_TYPES.register("aetherion", () ->
            EntityType.Builder.of(AetherionBoss::new, MobCategory.MISC)
                    .sized(37.5f/16f * AetherionRenderer.MODEL_SCALE,60f/16f * AetherionRenderer.MODEL_SCALE)
                    .build("aetherion")
    );

    public static final RegistryObject<EntityType<AetherionLaserEntity>> AETHERION_LASER = ENTITY_TYPES.register("aetherion_laser", () ->
            EntityType.Builder.of(AetherionLaserEntity::new, MobCategory.MISC)
                    .sized(0.5f, 0.5f)
                    .build("aetherion_laser")
    );

    public static final RegistryObject<EntityType<AetherionBeamEntity>> AETHERION_BEAM = ENTITY_TYPES.register("aetherion_beam", () ->
            EntityType.Builder.of(AetherionBeamEntity::new, MobCategory.MISC)
                    .sized(0.5f, 0.5f)
                    .build("aetherion_beam")
    );

    public static final RegistryObject<EntityType<BlockShardEntity>> BLOCK_SHARD = ENTITY_TYPES.register("block_shard", () ->
            EntityType.Builder.of(BlockShardEntity::new, MobCategory.MISC)
                    .sized(1f, 1f)
                    .build("block_shard")
    );

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }

    @Mod.EventBusSubscriber(modid = ExoAscensionMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class RegisterEntitiesClient
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            // register entity renderers
            EntityRenderers.register(ModEntities.DRONE.get(), DroneRenderer::new);
            EntityRenderers.register(ModEntities.LEECH.get(), LeechRenderer::new);
            EntityRenderers.register(ModEntities.GRAPPLER.get(), GrapplerRenderer::new);
            EntityRenderers.register(ModEntities.SPIDER.get(), SpiderRenderer::new);
            EntityRenderers.register(ModEntities.GORGON.get(), GorgonRenderer::new);
            EntityRenderers.register(ModEntities.AETHERION.get(), AetherionRenderer::new);
            EntityRenderers.register(ModEntities.AETHERION_LASER.get(), AetherionLaserRenderer::new);
            EntityRenderers.register(ModEntities.AETHERION_BEAM.get(), AetherionBeamRenderer::new);
            EntityRenderers.register(ModEntities.BLOCK_SHARD.get(), DisplayRenderer.BlockDisplayRenderer::new);
        }
        @SubscribeEvent
        public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event) {
            event.registerLayerDefinition(DroneRenderer.DRONE_LAYER, DroneModel::createBodyLayer);
            event.registerLayerDefinition(LeechRenderer.LEECH_LAYER, LeechModel::createBodyLayer);
            event.registerLayerDefinition(GrapplerRenderer.GRAPPLER_LAYER, GrapplerModel::createBodyLayer);
            event.registerLayerDefinition(SpiderRenderer.SPIDER_LAYER, SpiderModel::createBodyLayer);
            event.registerLayerDefinition(GorgonRenderer.GORGON_LAYER, GorgonModel::createBodyLayer);

            event.registerLayerDefinition(AetherionRenderer.AETHERION_LAYER, AetherionModel::createBodyLayer);
        }
    }

    @Mod.EventBusSubscriber(modid= ExoAscensionMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public class ModEventBusEvents {
        @SubscribeEvent
        public static void registerAttributes(EntityAttributeCreationEvent event) {
            event.put(ModEntities.DRONE.get(), DroneEntity.createAttributes().build());
            event.put(ModEntities.LEECH.get(), LeechEntity.createAttributes().build());
            event.put(ModEntities.GRAPPLER.get(), GrapplerEntity.createAttributes().build());
            event.put(ModEntities.SPIDER.get(), SpiderEntity.createAttributes().build());
            event.put(ModEntities.GORGON.get(), GorgonEntity.createAttributes().build());

            event.put(ModEntities.AETHERION.get(), AetherionBoss.createAttributes().build());
        }

    }
}
