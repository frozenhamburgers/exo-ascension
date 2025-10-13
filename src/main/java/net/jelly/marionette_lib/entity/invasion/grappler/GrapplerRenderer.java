package net.jelly.marionette_lib.entity.invasion.grappler;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.jelly.marionette_lib.MarionetteMod;
import net.jelly.marionette_lib.entity.invasion.leech.LeechEntity;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class GrapplerRenderer extends MobRenderer<GrapplerEntity, GrapplerModel> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(MarionetteMod.MODID, "textures/entity/grappler.png");
    public static final ModelLayerLocation GRAPPLER_LAYER = new ModelLayerLocation(
            new ResourceLocation(MarionetteMod.MODID, "grappler_layer"), "main");

    public GrapplerRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new GrapplerModel(pContext.bakeLayer(GRAPPLER_LAYER)), 1.0f);
    }

    @Override
    protected void setupRotations(GrapplerEntity pEntityLiving, PoseStack pPoseStack, float pAgeInTicks, float pRotationYaw, float pPartialTicks) {
        pPoseStack.mulPose(Axis.YP.rotationDegrees(180));
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
    public ResourceLocation getTextureLocation(GrapplerEntity pEntity) {
        return TEXTURE;
    }
}
