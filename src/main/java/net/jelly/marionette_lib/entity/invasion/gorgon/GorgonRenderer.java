package net.jelly.marionette_lib.entity.invasion.gorgon;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.jelly.marionette_lib.MarionetteMod;
import net.jelly.marionette_lib.render.ChargedEyeLayer;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.SpiderEyesLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.entity.PartEntity;

public class GorgonRenderer extends MobRenderer<GorgonEntity, GorgonModel> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(MarionetteMod.MODID, "textures/entity/gorgon.png");
    public static final ModelLayerLocation GORGON_LAYER = new ModelLayerLocation(
            new ResourceLocation(MarionetteMod.MODID, "gorgon_layer"), "main");

    public GorgonRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new GorgonModel(pContext.bakeLayer(GORGON_LAYER)), 2.0f);
        this.addLayer(new ChargedEyeLayer<>(this));
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
