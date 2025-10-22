package net.jelly.exo_ascension.entity.invasion.aetherion.beam;

import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

public class AetherionBeamRenderer extends EntityRenderer<AetherionBeamEntity> {
    public AetherionBeamRenderer(EntityRendererProvider.Context pContext) {
        super(pContext);
    }

    @Override
    public ResourceLocation getTextureLocation(AetherionBeamEntity pEntity) {
        return null;
    }
}
