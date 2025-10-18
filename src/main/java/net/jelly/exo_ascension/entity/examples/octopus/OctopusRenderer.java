package net.jelly.exo_ascension.entity.examples.octopus;

import net.jelly.exo_ascension.ExoAscensionMod;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class OctopusRenderer extends MobRenderer<OctopusEntity, OctopusModel> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(ExoAscensionMod.MODID, "textures/entity/worm.png");
    public static final ModelLayerLocation OCTOPUS_LAYER = new ModelLayerLocation(
            new ResourceLocation(ExoAscensionMod.MODID, "octopus_layer"), "main");

    public OctopusRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new OctopusModel(pContext.bakeLayer(OCTOPUS_LAYER)), 1.0f);
    }

//    public boolean shouldRender(WormEntity entity, Frustum camera, double x, double y, double z) {
//        if (super.shouldRender(entity, camera, x, y, z)) {
//            return true;
//        } else {
//            for (PartEntity part : entity.getParts()) {
//                if (camera.isVisible(part.getBoundingBoxForCulling())) {
//                    return true;
//                }
//            }
//            return false;
//        }
//    }

    @Override
    public ResourceLocation getTextureLocation(OctopusEntity pEntity) {
        return TEXTURE;
    }
}
