package net.jelly.marionette_lib.entity;

import net.jelly.marionette_lib.MarionetteMod;
import net.jelly.marionette_lib.entity.examples.octopus.OctopusEntity;
import net.jelly.marionette_lib.entity.examples.octopus.OctopusModel;
import net.jelly.marionette_lib.entity.examples.octopus.OctopusRenderer;
import net.jelly.marionette_lib.entity.examples.worm.WormEntity;
import net.jelly.marionette_lib.entity.examples.worm.WormModel;
import net.jelly.marionette_lib.entity.examples.worm.WormRenderer;
import net.jelly.marionette_lib.entity.invasion.gorgon.GorgonEntity;
import net.jelly.marionette_lib.entity.invasion.gorgon.GorgonModel;
import net.jelly.marionette_lib.entity.invasion.gorgon.GorgonRenderer;
import net.jelly.marionette_lib.entity.invasion.grappler.GrapplerEntity;
import net.jelly.marionette_lib.entity.invasion.grappler.GrapplerModel;
import net.jelly.marionette_lib.entity.invasion.grappler.GrapplerRenderer;
import net.jelly.marionette_lib.entity.invasion.leech.LeechEntity;
import net.jelly.marionette_lib.entity.invasion.leech.LeechModel;
import net.jelly.marionette_lib.entity.invasion.leech.LeechRenderer;
import net.jelly.marionette_lib.entity.invasion.drone.DroneEntity;
import net.jelly.marionette_lib.entity.invasion.drone.DroneModel;
import net.jelly.marionette_lib.entity.invasion.drone.DroneRenderer;
import net.jelly.marionette_lib.entity.invasion.spider.SpiderEntity;
import net.jelly.marionette_lib.entity.invasion.spider.SpiderModel;
import net.jelly.marionette_lib.entity.invasion.spider.SpiderRenderer;
import net.minecraft.client.renderer.entity.EntityRenderers;
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
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, MarionetteMod.MODID);

    public static final RegistryObject<EntityType<WormEntity>> WORM = ENTITY_TYPES.register("worm", () ->
            EntityType.Builder.of(WormEntity::new, MobCategory.MISC)
                    .sized(1.0f,1.0f)
                    .build("worm")
    );

    public static final RegistryObject<EntityType<OctopusEntity>> OCTOPUS = ENTITY_TYPES.register("octopus", () ->
            EntityType.Builder.of(OctopusEntity::new, MobCategory.MISC)
                    .sized(1.0f,1.0f)
                    .build("octopus")
    );

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

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }

    @Mod.EventBusSubscriber(modid = MarionetteMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class RegisterEntitiesClient
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            // register entity renderers
            EntityRenderers.register(ModEntities.WORM.get(), WormRenderer::new);
            EntityRenderers.register(ModEntities.OCTOPUS.get(), OctopusRenderer::new);

            EntityRenderers.register(ModEntities.DRONE.get(), DroneRenderer::new);
            EntityRenderers.register(ModEntities.LEECH.get(), LeechRenderer::new);
            EntityRenderers.register(ModEntities.GRAPPLER.get(), GrapplerRenderer::new);
            EntityRenderers.register(ModEntities.SPIDER.get(), SpiderRenderer::new);
            EntityRenderers.register(ModEntities.GORGON.get(), GorgonRenderer::new);
        }
        @SubscribeEvent
        public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event) {
            event.registerLayerDefinition(WormRenderer.WORM_LAYER, WormModel::createBodyLayer);
            event.registerLayerDefinition(OctopusRenderer.OCTOPUS_LAYER, OctopusModel::createBodyLayer);

            event.registerLayerDefinition(DroneRenderer.DRONE_LAYER, DroneModel::createBodyLayer);
            event.registerLayerDefinition(LeechRenderer.LEECH_LAYER, LeechModel::createBodyLayer);
            event.registerLayerDefinition(GrapplerRenderer.GRAPPLER_LAYER, GrapplerModel::createBodyLayer);
            event.registerLayerDefinition(SpiderRenderer.SPIDER_LAYER, SpiderModel::createBodyLayer);
            event.registerLayerDefinition(GorgonRenderer.GORGON_LAYER, GorgonModel::createBodyLayer);
        }
    }

    @Mod.EventBusSubscriber(modid= MarionetteMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public class ModEventBusEvents {
        @SubscribeEvent
        public static void registerAttributes(EntityAttributeCreationEvent event) {
            event.put(ModEntities.WORM.get(), WormEntity.createAttributes().build());
            event.put(ModEntities.OCTOPUS.get(), OctopusEntity.createAttributes().build());

            event.put(ModEntities.DRONE.get(), DroneEntity.createAttributes().build());
            event.put(ModEntities.LEECH.get(), LeechEntity.createAttributes().build());
            event.put(ModEntities.GRAPPLER.get(), GrapplerEntity.createAttributes().build());
            event.put(ModEntities.SPIDER.get(), SpiderEntity.createAttributes().build());
            event.put(ModEntities.GORGON.get(), GorgonEntity.createAttributes().build());
        }

    }
}
