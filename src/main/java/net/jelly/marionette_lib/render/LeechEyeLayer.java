package net.jelly.marionette_lib.render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.jelly.marionette_lib.MarionetteMod;
import net.jelly.marionette_lib.entity.invasion.leech.LeechEntity;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;

public class LeechEyeLayer<T extends LivingEntity, M extends EntityModel<T>> extends RenderLayer<T, M> {
    private static final ResourceLocation EYE_TEXTURE = new ResourceLocation(MarionetteMod.MODID, "textures/entity/leechE.png");
    private static final RenderType CHARGED_EYES = RenderType.eyes(EYE_TEXTURE);


    public LeechEyeLayer(RenderLayerParent<T, M> parent) {
        super(parent);
    }

    @Override
    public void render(PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight, T pLivingEntity, float pLimbSwing, float pLimbSwingAmount, float pPartialTicks, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {
        VertexConsumer vertexconsumer = pBuffer.getBuffer(CHARGED_EYES);
        float charge = 0;
        if(pLivingEntity instanceof LeechEntity) charge = ((LeechEntity) pLivingEntity).getCharge() / (float)LeechEntity.MAX_CHARGE;

        float r = 0, g = 0, b = 0;
        if (charge < 1f / 3f) {
            g = charge * 3f;
        } else if (charge < 2f / 3f) {
            g = 1f;
            b = (charge - 1f / 3f) * 3f;
        } else {
            g = 1f;
            b = 1f;
            r = (charge - 2f / 3f) * 3f;
        }

        this.getParentModel().renderToBuffer(pPoseStack, vertexconsumer, 15728640, OverlayTexture.NO_OVERLAY, r, g, b, 1.0F);
    }
}