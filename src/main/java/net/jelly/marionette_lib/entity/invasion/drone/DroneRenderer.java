package net.jelly.marionette_lib.entity.invasion.drone;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.jelly.marionette_lib.MarionetteMod;
import net.jelly.marionette_lib.entity.examples.wyvern.WyvernEntity;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.PhantomRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.monster.Phantom;
import net.minecraft.world.phys.Vec3;
import org.joml.Matrix4f;

public class DroneRenderer extends MobRenderer<DroneEntity, DroneModel> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(MarionetteMod.MODID, "textures/entity/drone.png");
    public static final ModelLayerLocation DRONE_LAYER = new ModelLayerLocation(
            new ResourceLocation(MarionetteMod.MODID, "drone_layer"), "main");

    public DroneRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new DroneModel(pContext.bakeLayer(DRONE_LAYER)), 0.75F);
    }

    @Override
    public ResourceLocation getTextureLocation(DroneEntity pEntity) {
        return TEXTURE;
    }

    protected void setupRotations(DroneEntity pEntityLiving, PoseStack pPoseStack, float pAgeInTicks, float pRotationYaw, float pPartialTicks) {
        super.setupRotations(pEntityLiving, pPoseStack, pAgeInTicks, pRotationYaw, pPartialTicks);
        pPoseStack.mulPose(Axis.XP.rotationDegrees(-pEntityLiving.getXRot()));
    }
}
