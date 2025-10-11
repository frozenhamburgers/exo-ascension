package net.jelly.marionette_lib.entity;

import net.jelly.marionette_lib.MarionetteMod;
import net.jelly.marionette_lib.entity.examples.octopus.OctopusEntity;
import net.jelly.marionette_lib.entity.examples.octopus.OctopusModel;
import net.jelly.marionette_lib.entity.examples.octopus.OctopusRenderer;
import net.jelly.marionette_lib.entity.examples.worm.WormEntity;
import net.jelly.marionette_lib.entity.examples.worm.WormModel;
import net.jelly.marionette_lib.entity.examples.worm.WormRenderer;
import net.jelly.marionette_lib.entity.examples.wyvern.WyvernEntity;
import net.jelly.marionette_lib.entity.examples.wyvern.WyvernModel;
import net.jelly.marionette_lib.entity.examples.wyvern.WyvernRenderer;
import net.jelly.marionette_lib.entity.invasion.drone.DroneEntity;
import net.jelly.marionette_lib.entity.invasion.drone.DroneModel;
import net.jelly.marionette_lib.entity.invasion.drone.DroneRenderer;
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

    public static final RegistryObject<EntityType<WyvernEntity>> WYVERN = ENTITY_TYPES.register("wyvern", () ->
            EntityType.Builder.of(WyvernEntity::new, MobCategory.MISC)
                    .sized(1.0f,1.0f)
                    .build("wyvern")
    );

    public static final RegistryObject<EntityType<DroneEntity>> DRONE = ENTITY_TYPES.register("drone", () ->
            EntityType.Builder.of(DroneEntity::new, MobCategory.MISC)
                    .sized(1.0f,1.0f)
                    .build("drone")
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
            EntityRenderers.register(ModEntities.WYVERN.get(), WyvernRenderer::new);
            EntityRenderers.register(ModEntities.DRONE.get(), DroneRenderer::new);
        }
        @SubscribeEvent
        public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event) {
            event.registerLayerDefinition(WormRenderer.WORM_LAYER, WormModel::createBodyLayer);
            event.registerLayerDefinition(OctopusRenderer.OCTOPUS_LAYER, OctopusModel::createBodyLayer);
            event.registerLayerDefinition(WyvernRenderer.WYVERN_LAYER, WyvernModel::createBodyLayer);
            event.registerLayerDefinition(DroneRenderer.DRONE_LAYER, DroneModel::createBodyLayer);
        }
    }

    @Mod.EventBusSubscriber(modid= MarionetteMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public class ModEventBusEvents {
        @SubscribeEvent
        public static void registerAttributes(EntityAttributeCreationEvent event) {
            event.put(ModEntities.WORM.get(), WormEntity.createAttributes().build());
            event.put(ModEntities.OCTOPUS.get(), OctopusEntity.createAttributes().build());
            event.put(ModEntities.WYVERN.get(), WyvernEntity.createAttributes().build());
            event.put(ModEntities.DRONE.get(), DroneEntity.createAttributes().build());
        }

    }
}
