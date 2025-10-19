package net.jelly.exo_ascension.entity.invasion.aetherion;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.jelly.exo_ascension.ExoAscensionMod;
import net.jelly.exo_ascension.render.GorgonEyeLayer;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class SpiderRenderer extends MobRenderer<SpiderEntity, SpiderModel> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(ExoAscensionMod.MODID, "textures/entity/spider.png");
    public static final ModelLayerLocation SPIDER_LAYER = new ModelLayerLocation(
            new ResourceLocation(ExoAscensionMod.MODID, "spider_layer"), "main");

    public SpiderRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new SpiderModel(pContext.bakeLayer(SPIDER_LAYER)), 1.0f);
        this.addLayer(new GorgonEyeLayer<>(this));
    }

    @Override
    protected void setupRotations(SpiderEntity pEntityLiving, PoseStack pPoseStack, float pAgeInTicks, float pRotationYaw, float pPartialTicks) {
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
    public ResourceLocation getTextureLocation(SpiderEntity pEntity) {
        return TEXTURE;
    }
}
