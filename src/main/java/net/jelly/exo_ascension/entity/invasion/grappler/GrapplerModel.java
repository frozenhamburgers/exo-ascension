package net.jelly.exo_ascension.entity.invasion.grappler;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.jelly.exo_ascension.utility.AbstractPartEntity;
import net.jelly.exo_ascension.utility.MultipartModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.phys.Vec3;

public class GrapplerModel extends MultipartModel<GrapplerEntity> {
    private final ModelPart body;

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(48, 28).addBox(-4.5F, -26.5F, -4.5F, 9.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 18.0F, 0.0F));

        PartDefinition cube_r1 = body.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 61).addBox(-5.0F, -2.0F, -3.5F, 10.0F, 3.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(11.5F, -16.0F, 0.0F, 0.0F, 1.5708F, -0.2618F));

        PartDefinition cube_r2 = body.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 49).addBox(-5.0F, -2.0F, -3.5F, 10.0F, 3.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-11.5F, -16.0F, 0.0F, 0.0F, -1.5708F, 0.2618F));

        PartDefinition cube_r3 = body.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(0, 0).addBox(-6.0F, -6.0F, -10.0F, 12.0F, 8.0F, 20.0F, new CubeDeformation(0.0F))
                .texOffs(0, 28).addBox(-5.0F, 2.0F, -7.0F, 10.0F, 7.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -12.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

        PartDefinition cube_r4 = body.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(88, 55).addBox(-1.0F, -6.0F, -2.0F, 2.0F, 9.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.975F, 0.0F, 1.5708F, -1.1781F, -1.5708F));

        PartDefinition bone = body.addOrReplaceChild("bone", CubeListBuilder.create(), PartPose.offset(0.0F, -16.0F, 0.0F));

        PartDefinition bone10 = bone.addOrReplaceChild("bone10", CubeListBuilder.create().texOffs(64, 0).addBox(-4.75F, -6.25F, -4.5F, 9.0F, 1.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -6.6F, 0.0F));

        PartDefinition cube_r5 = bone10.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(88, 52).addBox(-4.75F, -0.625F, -0.875F, 9.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.95F, -5.025F, 0.7854F, 0.0F, 0.0F));

        PartDefinition cube_r6 = bone10.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(88, 49).addBox(-4.75F, -0.625F, -0.875F, 9.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.3F, -5.7F, 1.5708F, 0.0F, 0.0F));

        PartDefinition cube_r7 = bone10.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(84, 21).addBox(-4.75F, -0.625F, -1.625F, 9.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.3F, 5.7F, -1.5708F, 0.0F, 0.0F));

        PartDefinition cube_r8 = bone10.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(88, 46).addBox(-4.75F, -0.625F, -0.875F, 9.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.95F, 5.025F, -0.7854F, 0.0F, 0.0F));

        PartDefinition bone3 = bone.addOrReplaceChild("bone3", CubeListBuilder.create(), PartPose.offset(2.7F, -11.25F, 0.0F));

        PartDefinition bone4 = bone3.addOrReplaceChild("bone4", CubeListBuilder.create().texOffs(84, 25).addBox(0.425F, 1.0F, -4.25F, 1.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.7854F));

        PartDefinition cube_r9 = bone4.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(56, 95).addBox(-0.625F, 1.0F, -0.875F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.375F, 0.0F, -4.275F, 0.0F, 0.7854F, 0.0F));

        PartDefinition cube_r10 = bone4.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(88, 68).addBox(-0.625F, 1.0F, -0.625F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.275F, 0.0F, 4.95F, 0.0F, -1.5708F, 0.0F));

        PartDefinition cube_r11 = bone4.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(94, 83).addBox(-0.625F, 1.0F, -0.875F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.375F, 0.0F, 4.275F, 0.0F, -0.7854F, 0.0F));

        PartDefinition bone8 = bone3.addOrReplaceChild("bone8", CubeListBuilder.create().texOffs(0, 73).addBox(-1.0F, -3.75F, -4.5F, 1.0F, 7.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(3.3F, 6.0F, 0.0F));

        PartDefinition cube_r12 = bone8.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(64, 73).addBox(-0.625F, -3.0F, -0.875F, 1.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.05F, -0.75F, -5.025F, 0.0F, 0.7854F, 0.0F));

        PartDefinition cube_r13 = bone8.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(38, 49).addBox(-0.625F, -1.0F, -1.875F, 1.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.7F, -0.75F, -5.7F, 0.0F, 1.5708F, 0.0F));

        PartDefinition cube_r14 = bone8.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(0, 89).addBox(-0.625F, -3.0F, -1.625F, 1.0F, 7.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.7F, -0.75F, 5.7F, 0.0F, -1.5708F, 0.0F));

        PartDefinition cube_r15 = bone8.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(58, 73).addBox(-0.625F, -3.0F, -0.875F, 1.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.05F, -0.75F, 5.025F, 0.0F, -0.7854F, 0.0F));

        PartDefinition bone5 = bone.addOrReplaceChild("bone5", CubeListBuilder.create(), PartPose.offset(-2.7F, -11.25F, 0.0F));

        PartDefinition bone6 = bone5.addOrReplaceChild("bone6", CubeListBuilder.create().texOffs(40, 73).addBox(-1.6147F, -2.0F, -4.2354F, 1.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.7569F, 1.5715F, -0.0146F, 0.0F, 0.0F, 0.3491F));

        PartDefinition cube_r16 = bone6.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(84, 90).addBox(-0.625F, 0.0F, -0.875F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.3147F, -2.0F, -4.2604F, 0.0F, -0.7854F, 0.0F));

        PartDefinition cube_r17 = bone6.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(44, 65).addBox(-0.625F, 0.0F, -0.625F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.3353F, -2.0F, 4.9646F, 0.0F, 1.5708F, 0.0F));

        PartDefinition cube_r18 = bone6.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(78, 90).addBox(-0.625F, 0.0F, -0.875F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.3147F, -2.0F, 4.2896F, 0.0F, 0.7854F, 0.0F));

        PartDefinition bone7 = bone5.addOrReplaceChild("bone7", CubeListBuilder.create().texOffs(20, 73).addBox(-0.25F, -3.75F, -4.5F, 1.0F, 7.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.3F, 6.0F, 0.0F));

        PartDefinition cube_r19 = bone7.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(30, 89).addBox(-0.625F, -3.0F, -0.875F, 1.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.05F, -0.75F, -5.025F, 0.0F, -0.7854F, 0.0F));

        PartDefinition cube_r20 = bone7.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(38, 57).addBox(-0.625F, -1.0F, -1.875F, 1.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.7F, -0.75F, -5.7F, 0.0F, -1.5708F, 0.0F));

        PartDefinition cube_r21 = bone7.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(12, 89).addBox(-0.625F, -3.0F, -1.625F, 1.0F, 7.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.7F, -0.75F, 5.7F, 0.0F, 1.5708F, 0.0F));

        PartDefinition cube_r22 = bone7.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(24, 89).addBox(-0.625F, -3.0F, -0.875F, 1.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.05F, -0.75F, 5.025F, 0.0F, 0.7854F, 0.0F));

        PartDefinition bone2 = bone5.addOrReplaceChild("bone2", CubeListBuilder.create().texOffs(84, 10).addBox(0.6147F, -2.0F, -4.2354F, 1.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.1569F, 1.5715F, -0.0146F, 0.0F, 0.0F, -0.3491F));

        PartDefinition cube_r23 = bone2.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(94, 68).addBox(-0.375F, 0.0F, -0.875F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.3147F, -2.0F, -4.2604F, 0.0F, 0.7854F, 0.0F));

        PartDefinition cube_r24 = bone2.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(44, 69).addBox(-0.375F, 0.0F, -0.625F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.3353F, -2.0F, 4.9646F, 0.0F, -1.5708F, 0.0F));

        PartDefinition cube_r25 = bone2.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(90, 90).addBox(-0.375F, 0.0F, -0.875F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.3147F, -2.0F, 4.2896F, 0.0F, -0.7854F, 0.0F));

        PartDefinition arm11 = partdefinition.addOrReplaceChild("arm11", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 2.5F));

        PartDefinition cube_r26 = arm11.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(72, 71).addBox(3.0F, -8.0F, -4.0F, 3.0F, 11.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(48, 46).addBox(-3.0F, -8.0F, -3.0F, 6.0F, 21.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.5708F, 0.0F, 0.0F));

        PartDefinition arm12 = partdefinition.addOrReplaceChild("arm12", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition cube_r27 = arm12.addOrReplaceChild("cube_r27", CubeListBuilder.create().texOffs(40, 84).addBox(2.1711F, 4.2966F, -3.0F, 2.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.5F, -1.5708F, 0.3054F, 0.0F));

        PartDefinition cube_r28 = arm12.addOrReplaceChild("cube_r28", CubeListBuilder.create().texOffs(84, 35).addBox(2.0F, 0.0F, -3.0F, 2.0F, 5.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(65, 10).addBox(-1.0F, 0.0F, -3.0F, 3.0F, 11.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(72, 46).addBox(-2.0F, -10.0F, -2.0F, 4.0F, 21.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.5F, -1.5708F, 0.0F, 0.0F));

        PartDefinition arm13 = partdefinition.addOrReplaceChild("arm13", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition cube_r29 = arm13.addOrReplaceChild("cube_r29", CubeListBuilder.create().texOffs(72, 90).addBox(-2.3657F, -0.5855F, -1.0F, 1.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.1033F, -4.0F, -1.5708F, 0.4363F, 0.0F));

        PartDefinition cube_r30 = arm13.addOrReplaceChild("cube_r30", CubeListBuilder.create().texOffs(94, 78).addBox(4.0708F, -3.3941F, -1.0F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.1033F, -4.0F, 1.5708F, 0.5672F, 3.1416F));

        PartDefinition cube_r31 = arm13.addOrReplaceChild("cube_r31", CubeListBuilder.create().texOffs(94, 73).addBox(-5.0708F, -3.3941F, -1.0F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.1033F, -4.0F, 1.5708F, -0.5672F, -3.1416F));

        PartDefinition cube_r32 = arm13.addOrReplaceChild("cube_r32", CubeListBuilder.create().texOffs(38, 65).addBox(1.3657F, -0.5855F, -1.0F, 1.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.1033F, -4.0F, -1.5708F, -0.4363F, 0.0F));

        PartDefinition cube_r33 = arm13.addOrReplaceChild("cube_r33", CubeListBuilder.create().texOffs(56, 84).addBox(-2.0F, -7.5533F, -2.0F, 4.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.1033F, -4.0F, -1.5708F, 0.0F, 0.0F));

        PartDefinition arm21 = partdefinition.addOrReplaceChild("arm21", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 2.5F));

        PartDefinition cube_r34 = arm21.addOrReplaceChild("cube_r34", CubeListBuilder.create().texOffs(72, 71).addBox(3.0F, -8.0F, -4.0F, 3.0F, 11.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(48, 46).addBox(-3.0F, -8.0F, -3.0F, 6.0F, 21.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.5708F, 0.0F, 0.0F));

        PartDefinition arm22 = partdefinition.addOrReplaceChild("arm22", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition cube_r35 = arm22.addOrReplaceChild("cube_r35", CubeListBuilder.create().texOffs(40, 84).addBox(2.1711F, 4.2966F, -3.0F, 2.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.5F, -1.5708F, 0.3054F, 0.0F));

        PartDefinition cube_r36 = arm22.addOrReplaceChild("cube_r36", CubeListBuilder.create().texOffs(84, 35).addBox(2.0F, 0.0F, -3.0F, 2.0F, 5.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(65, 10).addBox(-1.0F, 0.0F, -3.0F, 3.0F, 11.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(72, 46).addBox(-2.0F, -10.0F, -2.0F, 4.0F, 21.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.5F, -1.5708F, 0.0F, 0.0F));

        PartDefinition arm23 = partdefinition.addOrReplaceChild("arm23", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition cube_r37 = arm23.addOrReplaceChild("cube_r37", CubeListBuilder.create().texOffs(72, 90).addBox(-2.3657F, -0.5855F, -1.0F, 1.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.1033F, -4.0F, -1.5708F, 0.4363F, 0.0F));

        PartDefinition cube_r38 = arm23.addOrReplaceChild("cube_r38", CubeListBuilder.create().texOffs(94, 78).addBox(4.0708F, -3.3941F, -1.0F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.1033F, -4.0F, 1.5708F, 0.5672F, 3.1416F));

        PartDefinition cube_r39 = arm23.addOrReplaceChild("cube_r39", CubeListBuilder.create().texOffs(94, 73).addBox(-5.0708F, -3.3941F, -1.0F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.1033F, -4.0F, 1.5708F, -0.5672F, -3.1416F));

        PartDefinition cube_r40 = arm23.addOrReplaceChild("cube_r40", CubeListBuilder.create().texOffs(38, 65).addBox(1.3657F, -0.5855F, -1.0F, 1.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.1033F, -4.0F, -1.5708F, -0.4363F, 0.0F));

        PartDefinition cube_r41 = arm23.addOrReplaceChild("cube_r41", CubeListBuilder.create().texOffs(56, 84).addBox(-2.0F, -7.5533F, -2.0F, 4.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.1033F, -4.0F, -1.5708F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 128, 128);
    }


    public GrapplerModel(ModelPart root) {
        // segment names. names of the folders containing the geometry of each animatable segment in blockbench
        super(root, new String[]
                {"arm11", "arm12", "arm13", "arm21", "arm22", "arm23"});
        this.body = root.getChild("body");
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        for(int i=0 ; i<allSegments.length; i++) {
            allSegments[i].render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        }
    }

    @Override
    public void setupAnim(GrapplerEntity entity, float pLimbSwing, float pLimbSwingAmount, float ageInTicks, float pNetHeadYaw, float pHeadPitch) {
        float partialTicks = ageInTicks - entity.tickCount;

        // procedural parts
        AbstractPartEntity[] allParts = (AbstractPartEntity[])(entity.getParts());
        for(int i=0 ; i<allSegments.length; i++) {
            Vec3 dirVec = allParts[i].getPartDirection().normalize();

            float yaw = (float)(Math.atan2(-dirVec.x, dirVec.z));
            float pitch = (float)(Math.asin(dirVec.y));
            allSegments[i].setRotation(-pitch, yaw, 0f);


            Vec3 wormPos = entity.getPosition(partialTicks);
            Vec3 partPos = allParts[i].getPosition(partialTicks);
            double xOffset = partPos.x-wormPos.x;
            double yOffset = partPos.y-wormPos.y;
            double zOffset = partPos.z-wormPos.z;
            // default position of each part is (0,24,0). See PartDefinition definitions above to see why
            // 16 b/c 1 block is 16 units in model space
            allSegments[i].setPos((float)(16f*xOffset), (float) (24-16f*(yOffset + allParts[i].getBbHeight()/2)),(float)(-16f*zOffset));
        }

        // body parts
        body.setRotation(0f, (float)Math.toRadians(entity.yBodyRot), 0f);
    }

}
