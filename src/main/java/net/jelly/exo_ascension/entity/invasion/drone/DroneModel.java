package net.jelly.exo_ascension.entity.invasion.drone;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;

public class DroneModel extends EntityModel<DroneEntity> {
    private final ModelPart bb_main;

    public DroneModel(ModelPart root) {
        this.bb_main = root.getChild("bone");
    }


    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition bone = partdefinition.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(0, 0).addBox(-6.0F, -10.24F, -6.0F, 12.0F, 12.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(48, 13).addBox(-3.0F, -7.24F, 6.0F, 6.0F, 6.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(22, 57).addBox(-4.0F, -8.24F, 10.0F, 8.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 20.24F, 0.0F));

        PartDefinition bone5 = bone.addOrReplaceChild("bone5", CubeListBuilder.create(), PartPose.offset(-3.6F, -11.24F, 0.0F));

        PartDefinition bone6 = bone5.addOrReplaceChild("bone6", CubeListBuilder.create().texOffs(48, 0).addBox(-1.9F, 1.0F, -5.0F, 1.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.7854F));

        PartDefinition cube_r1 = bone6.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(48, 71).addBox(-0.5F, 1.0F, -1.5F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 0.0F, 5.7F, 0.0F, 0.7854F, 0.0F));

        PartDefinition cube_r2 = bone6.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(78, 60).addBox(-0.5F, 1.0F, -1.5F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.7F, 0.0F, 6.6F, 0.0F, 1.5708F, 0.0F));

        PartDefinition cube_r3 = bone6.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(56, 78).addBox(-0.5F, 1.0F, -0.5F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.7F, 0.0F, -6.6F, 0.0F, -1.5708F, 0.0F));

        PartDefinition cube_r4 = bone6.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(42, 57).addBox(-0.5F, 1.0F, -1.5F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 0.0F, -5.7F, 0.0F, -0.7854F, 0.0F));

        PartDefinition bone7 = bone5.addOrReplaceChild("bone7", CubeListBuilder.create().texOffs(0, 37).addBox(0.0F, -5.0F, -6.0F, 1.0F, 8.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.4F, 8.0F, 0.0F));

        PartDefinition cube_r5 = bone7.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(66, 67).addBox(-0.5F, -4.0F, -1.5F, 1.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.4F, -1.0F, 6.7F, 0.0F, 0.7854F, 0.0F));

        PartDefinition cube_r6 = bone7.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(30, 71).addBox(-0.5F, -4.0F, -1.5F, 1.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.6F, -1.0F, 7.6F, 0.0F, 1.5708F, 0.0F));

        PartDefinition cube_r7 = bone7.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(24, 71).addBox(-0.5F, -4.0F, -0.5F, 1.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.6F, -1.0F, -7.6F, 0.0F, -1.5708F, 0.0F));

        PartDefinition cube_r8 = bone7.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(58, 67).addBox(-0.5F, -4.0F, -1.5F, 1.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.4F, -1.0F, -6.7F, 0.0F, -0.7854F, 0.0F));

        PartDefinition bone2 = bone5.addOrReplaceChild("bone2", CubeListBuilder.create().texOffs(52, 37).addBox(-1.9F, -4.0F, -5.0F, 1.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 14.0F, 0.0F, 0.0F, 0.0F, -0.7854F));

        PartDefinition cube_r9 = bone2.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(74, 36).addBox(-0.5F, -4.0F, -1.5F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 0.0F, 5.7F, 0.0F, 0.7854F, 0.0F));

        PartDefinition cube_r10 = bone2.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(68, 78).addBox(-0.5F, -4.0F, -1.5F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.7F, 0.0F, 6.6F, 0.0F, 1.5708F, 0.0F));

        PartDefinition cube_r11 = bone2.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(62, 78).addBox(-0.5F, -4.0F, -0.5F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.7F, 0.0F, -6.6F, 0.0F, -1.5708F, 0.0F));

        PartDefinition cube_r12 = bone2.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(72, 30).addBox(-0.5F, -4.0F, -1.5F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 0.0F, -5.7F, 0.0F, -0.7854F, 0.0F));

        PartDefinition bone3 = bone.addOrReplaceChild("bone3", CubeListBuilder.create(), PartPose.offset(3.6F, -11.24F, 0.0F));

        PartDefinition bone4 = bone3.addOrReplaceChild("bone4", CubeListBuilder.create().texOffs(52, 50).addBox(0.9F, 1.0F, -5.0F, 1.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.7854F));

        PartDefinition cube_r13 = bone4.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(74, 48).addBox(-0.5F, 1.0F, -1.5F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.0F, 5.7F, 0.0F, -0.7854F, 0.0F));

        PartDefinition cube_r14 = bone4.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(74, 79).addBox(-0.5F, 1.0F, -1.5F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.7F, 0.0F, 6.6F, 0.0F, -1.5708F, 0.0F));

        PartDefinition cube_r15 = bone4.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(8, 79).addBox(-0.5F, 1.0F, -0.5F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.7F, 0.0F, -6.6F, 0.0F, 1.5708F, 0.0F));

        PartDefinition cube_r16 = bone4.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(74, 42).addBox(-0.5F, 1.0F, -1.5F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.0F, -5.7F, 0.0F, 0.7854F, 0.0F));

        PartDefinition bone8 = bone3.addOrReplaceChild("bone8", CubeListBuilder.create().texOffs(26, 37).addBox(-1.0F, -5.0F, -6.0F, 1.0F, 8.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(4.4F, 8.0F, 0.0F));

        PartDefinition cube_r17 = bone8.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(0, 70).addBox(-0.5F, -4.0F, -1.5F, 1.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.4F, -1.0F, 6.7F, 0.0F, -0.7854F, 0.0F));

        PartDefinition cube_r18 = bone8.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(42, 71).addBox(-0.5F, -4.0F, -1.5F, 1.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.6F, -1.0F, 7.6F, 0.0F, -1.5708F, 0.0F));

        PartDefinition cube_r19 = bone8.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(36, 71).addBox(-0.5F, -4.0F, -0.5F, 1.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.6F, -1.0F, -7.6F, 0.0F, 1.5708F, 0.0F));

        PartDefinition cube_r20 = bone8.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(68, 13).addBox(-0.5F, -4.0F, -1.5F, 1.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.4F, -1.0F, -6.7F, 0.0F, 0.7854F, 0.0F));

        PartDefinition bone9 = bone3.addOrReplaceChild("bone9", CubeListBuilder.create().texOffs(0, 57).addBox(0.9F, -4.0F, -5.0F, 1.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 14.0F, 0.0F, 0.0F, 0.0F, 0.7854F));

        PartDefinition cube_r21 = bone9.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(74, 67).addBox(-0.5F, -4.0F, -1.5F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.0F, 5.7F, 0.0F, -0.7854F, 0.0F));

        PartDefinition cube_r22 = bone9.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(80, 30).addBox(-0.5F, -4.0F, -1.5F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.7F, 0.0F, 6.6F, 0.0F, -1.5708F, 0.0F));

        PartDefinition cube_r23 = bone9.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(14, 80).addBox(-0.5F, -4.0F, -0.5F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.7F, 0.0F, -6.6F, 0.0F, 1.5708F, 0.0F));

        PartDefinition cube_r24 = bone9.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(74, 54).addBox(-0.5F, -4.0F, -1.5F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.0F, -5.7F, 0.0F, 0.7854F, 0.0F));

        PartDefinition bone10 = bone.addOrReplaceChild("bone10", CubeListBuilder.create().texOffs(0, 24).addBox(-3.0F, -8.0F, -6.0F, 6.0F, 1.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -5.04F, 0.0F));

        PartDefinition cube_r25 = bone10.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(60, 63).addBox(-3.0F, -0.5F, -1.5F, 6.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.6F, 6.7F, -0.7854F, 0.0F, 0.0F));

        PartDefinition cube_r26 = bone10.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(70, 3).addBox(-3.0F, -0.5F, -1.5F, 6.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.4F, 7.6F, -1.5708F, 0.0F, 0.0F));

        PartDefinition cube_r27 = bone10.addOrReplaceChild("cube_r27", CubeListBuilder.create().texOffs(70, 0).addBox(-3.0F, -0.5F, -0.5F, 6.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.4F, -7.6F, 1.5708F, 0.0F, 0.0F));

        PartDefinition cube_r28 = bone10.addOrReplaceChild("cube_r28", CubeListBuilder.create().texOffs(42, 63).addBox(-3.0F, -0.5F, -1.5F, 6.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.6F, -6.7F, 0.7854F, 0.0F, 0.0F));

        PartDefinition bone11 = bone.addOrReplaceChild("bone11", CubeListBuilder.create().texOffs(36, 24).addBox(-3.0F, 7.0F, -6.0F, 6.0F, 1.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.24F, 0.0F));

        PartDefinition cube_r29 = bone11.addOrReplaceChild("cube_r29", CubeListBuilder.create().texOffs(40, 67).addBox(-3.0F, -0.5F, -1.5F, 6.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 6.6F, 6.7F, 0.7854F, 0.0F, 0.0F));

        PartDefinition cube_r30 = bone11.addOrReplaceChild("cube_r30", CubeListBuilder.create().texOffs(70, 9).addBox(-3.0F, -0.5F, -1.5F, 6.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 4.4F, 7.6F, 1.5708F, 0.0F, 0.0F));

        PartDefinition cube_r31 = bone11.addOrReplaceChild("cube_r31", CubeListBuilder.create().texOffs(70, 6).addBox(-3.0F, -0.5F, -0.5F, 6.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 5.0F, -7.6F, -1.5708F, 0.0F, 0.0F));

        PartDefinition cube_r32 = bone11.addOrReplaceChild("cube_r32", CubeListBuilder.create().texOffs(22, 67).addBox(-3.0F, -0.5F, -1.5F, 6.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 6.6F, -6.7F, -0.7854F, 0.0F, 0.0F));

        PartDefinition bone12 = bone.addOrReplaceChild("bone12", CubeListBuilder.create().texOffs(8, 70).addBox(5.0F, -3.0F, -2.0F, 1.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(72, 24).addBox(6.0F, -1.0F, -1.0F, 5.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-18.0F, -4.24F, 0.0F));

        PartDefinition cube_r33 = bone12.addOrReplaceChild("cube_r33", CubeListBuilder.create().texOffs(76, 12).addBox(-0.5F, -3.0F, -1.5F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.7F, 5.5F, -0.5F, 0.0F, 0.0F, -0.4363F));

        PartDefinition cube_r34 = bone12.addOrReplaceChild("cube_r34", CubeListBuilder.create().texOffs(74, 73).addBox(-0.5F, 0.0F, -1.5F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.7F, -5.5F, -0.5F, 0.0F, 0.0F, 0.4363F));

        PartDefinition bone13 = bone.addOrReplaceChild("bone13", CubeListBuilder.create().texOffs(16, 71).addBox(-6.0F, -3.0F, -2.0F, 1.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(72, 27).addBox(-11.0F, -1.0F, -1.0F, 5.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(18.0F, -4.24F, 0.0F));

        PartDefinition cube_r35 = bone13.addOrReplaceChild("cube_r35", CubeListBuilder.create().texOffs(48, 77).addBox(-0.5F, -3.0F, -1.5F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.7F, 5.5F, -0.5F, 0.0F, 0.0F, 0.4363F));

        PartDefinition cube_r36 = bone13.addOrReplaceChild("cube_r36", CubeListBuilder.create().texOffs(76, 18).addBox(-0.5F, 0.0F, -1.5F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.7F, -5.5F, -0.5F, 0.0F, 0.0F, -0.4363F));

        return LayerDefinition.create(meshdefinition, 128, 128);
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        bb_main.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }

    @Override
    public void setupAnim(DroneEntity pEntity, float pLimbSwing, float pLimbSwingAmount, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {
        
    }
}
