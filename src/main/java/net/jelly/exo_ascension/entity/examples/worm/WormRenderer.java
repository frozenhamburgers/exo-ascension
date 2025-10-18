package net.jelly.exo_ascension.entity.examples.worm;

import net.jelly.exo_ascension.ExoAscensionMod;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class WormRenderer extends MobRenderer<WormEntity, WormModel> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(ExoAscensionMod.MODID, "textures/entity/worm.png");
    public static final ModelLayerLocation WORM_LAYER = new ModelLayerLocation(
            new ResourceLocation(ExoAscensionMod.MODID, "worm_layer"), "main");

    public WormRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new WormModel(pContext.bakeLayer(WORM_LAYER)), 1.0f);
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
    public ResourceLocation getTextureLocation(WormEntity pEntity) {
        return TEXTURE;
    }
}
