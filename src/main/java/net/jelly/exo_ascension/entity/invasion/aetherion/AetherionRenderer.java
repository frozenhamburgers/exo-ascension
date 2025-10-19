package net.jelly.exo_ascension.entity.invasion.aetherion;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.jelly.exo_ascension.ExoAscensionMod;
import net.jelly.exo_ascension.render.GorgonEyeLayer;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraftforge.entity.PartEntity;

public class AetherionRenderer extends MobRenderer<AetherionBoss, AetherionModel> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(ExoAscensionMod.MODID, "textures/entity/aetherion.png");
    public static final ModelLayerLocation AETHERION_LAYER = new ModelLayerLocation(
            new ResourceLocation(ExoAscensionMod.MODID, "aetherion_layer"), "main");
    public static final float MODEL_SCALE = 4f;

    public AetherionRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new AetherionModel(pContext.bakeLayer(AETHERION_LAYER)), 10.0f);
//        this.addLayer(new GorgonEyeLayer<>(this));
    }

    @Override
    protected void setupRotations(AetherionBoss pEntityLiving, PoseStack pPoseStack, float pAgeInTicks, float pRotationYaw, float pPartialTicks) {
//        pPoseStack.scale(MODEL_SCALE, MODEL_SCALE, MODEL_SCALE);
        pPoseStack.mulPose(Axis.YP.rotationDegrees(180));
    }

    public boolean shouldRender(AetherionBoss entity, Frustum camera, double x, double y, double z) {
        if (super.shouldRender(entity, camera, x, y, z)) {
            return true;
        } else {
            for (PartEntity part : entity.getParts()) {
                if (camera.isVisible(part.getBoundingBoxForCulling())) {
                    return true;
                }
            }
            return false;
        }
    }


    @Override
    protected void scale(AetherionBoss pLivingEntity, PoseStack pPoseStack, float pPartialTickTime) {
    }

    @Override
    public ResourceLocation getTextureLocation(AetherionBoss pEntity) {
        return TEXTURE;
    }
}
