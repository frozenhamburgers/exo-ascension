package net.jelly.exo_ascension.entity.invasion.gorgon;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.jelly.exo_ascension.ExoAscensionMod;
import net.jelly.exo_ascension.render.GorgonEyeLayer;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.entity.PartEntity;

public class GorgonRenderer extends MobRenderer<GorgonEntity, GorgonModel> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(ExoAscensionMod.MODID, "textures/entity/gorgon.png");
    public static final ModelLayerLocation GORGON_LAYER = new ModelLayerLocation(
            new ResourceLocation(ExoAscensionMod.MODID, "gorgon_layer"), "main");

    public GorgonRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new GorgonModel(pContext.bakeLayer(GORGON_LAYER)), 2.0f);
        this.addLayer(new GorgonEyeLayer<>(this));
    }

    @Override
    protected void setupRotations(GorgonEntity pEntityLiving, PoseStack pPoseStack, float pAgeInTicks, float pRotationYaw, float pPartialTicks) {
        pPoseStack.mulPose(Axis.YP.rotationDegrees(180));
    }

    public boolean shouldRender(GorgonEntity entity, Frustum camera, double x, double y, double z) {
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
    public ResourceLocation getTextureLocation(GorgonEntity pEntity) {
        return TEXTURE;
    }
}
