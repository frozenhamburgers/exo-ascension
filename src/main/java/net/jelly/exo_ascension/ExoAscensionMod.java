package net.jelly.exo_ascension;

import com.mojang.logging.LogUtils;
import net.jelly.exo_ascension.entity.ModEntities;
import net.jelly.exo_ascension.item.ModItems;
import net.jelly.exo_ascension.networking.ModMessages;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

import static net.minecraftforge.common.brewing.BrewingRecipeRegistry.addRecipe;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(ExoAscensionMod.MODID)
public class ExoAscensionMod
{
    // Define mod id i n a common place for everything to reference
    public static final String MODID = "exo_ascension";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public ExoAscensionMod()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // register
        ModItems.register(modEventBus);

        //registers mobs
        ModEntities.register(modEventBus);

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        // register sounds
//        ModSounds.register(modEventBus);

        // register particles
//        ParticleRegistry.register(modEventBus);

        // Register our mod's ForgeConfigSpec so that Forge can create and load the config file for us
//        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, CommonConfigs.SPEC, "sandwormmod-common.toml");

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    // common setup
    private void commonSetup(final FMLCommonSetupEvent event)
    {
        event.enqueueWork(() -> {
            ModMessages.register(); // networking: HAS TO BE FIRST LINE HERE
//            AdvancementTriggerRegistry.init();
        });
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
    }
}
