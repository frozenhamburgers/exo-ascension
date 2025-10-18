package net.jelly.exo_ascension.post_processing;

import com.mojang.blaze3d.vertex.PoseStack;
import net.jelly.exo_ascension.ExoAscensionMod;
import net.minecraft.client.renderer.EffectInstance;
import net.minecraft.resources.ResourceLocation;
import team.lodestar.lodestone.systems.postprocess.MultiInstancePostProcessor;

public class RedTintProcessor extends MultiInstancePostProcessor<RedTintFx> {
    public static final RedTintProcessor INSTANCE = new RedTintProcessor();
    private EffectInstance effect;

    @Override
    public ResourceLocation getPostChainLocation() {
        return new ResourceLocation(ExoAscensionMod.MODID, "red_tint_post");
    }

    @Override
    protected int getMaxInstances() {
        return 1;
    }

    @Override
    protected int getDataSizePerInstance() {
        return 4; // must match writeDataToBuffer() or it will crash
    }

    @Override
    public void init() {
        super.init();
        if (postChain != null) {
            effect = effects[0];
        }
    }

    @Override
    public void beforeProcess(PoseStack viewModelStack) {
        super.beforeProcess(viewModelStack);
        setDataBufferUniform(effect, "DataBuffer", "InstanceCount");
    }

    @Override
    public void afterProcess() {

    }
}
