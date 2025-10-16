package net.jelly.marionette_lib.entity.invasion.leech;

import net.jelly.marionette_lib.utility.MultipartModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;

public class LeechModel extends MultipartModel<LeechEntity> {

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition bone = partdefinition.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(30, 18).addBox(-2.5F, -2.5F, -4.0F, 5.0F, 5.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition tooth = bone.addOrReplaceChild("tooth", CubeListBuilder.create(), PartPose.offset(-0.2085F, -3.2F, 2.3806F));

        PartDefinition cube_r1 = tooth.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 56).addBox(-0.5F, -0.5F, -2.5F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.475F, 4.725F, 2.3998F, 0.0F, 0.0F));

        PartDefinition cube_r2 = tooth.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(14, 52).addBox(-0.5F, -0.5F, -3.5F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.825F, 0.4F, 3.0107F, 0.0F, 0.0F));

        PartDefinition cube_r3 = tooth.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(0, 61).addBox(-0.5F, -0.5F, -1.5F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.375F, 0.0F, 2.0508F, 0.0F, 0.0F));

        PartDefinition tooth2 = bone.addOrReplaceChild("tooth2", CubeListBuilder.create(), PartPose.offset(3.7915F, -0.2F, 2.3806F));

        PartDefinition cube_r4 = tooth2.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(56, 17).addBox(-0.5F, -0.5F, -2.5F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.475F, 0.0F, 4.725F, 0.0F, 2.3998F, 0.0F));

        PartDefinition cube_r5 = tooth2.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(26, 52).addBox(-0.5F, -0.5F, -3.5F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.825F, 0.0F, 0.4F, 0.0F, 3.0107F, 0.0F));

        PartDefinition cube_r6 = tooth2.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(18, 62).addBox(-0.5F, -0.5F, -1.5F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.375F, 0.0F, 0.0F, 0.0F, 2.0508F, 0.0F));

        PartDefinition tooth3 = bone.addOrReplaceChild("tooth3", CubeListBuilder.create(), PartPose.offset(-3.7915F, -0.2F, 2.3806F));

        PartDefinition cube_r7 = tooth3.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(56, 22).addBox(-0.5F, -0.5F, -2.5F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.475F, 0.0F, 4.725F, 0.0F, -2.3998F, 0.0F));

        PartDefinition cube_r8 = tooth3.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(54, 31).addBox(-0.5F, -0.5F, -3.5F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.825F, 0.0F, 0.4F, 0.0F, -3.0107F, 0.0F));

        PartDefinition cube_r9 = tooth3.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(26, 62).addBox(-0.5F, -0.5F, -1.5F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.375F, 0.0F, 0.0F, 0.0F, -2.0508F, 0.0F));

        PartDefinition tooth4 = bone.addOrReplaceChild("tooth4", CubeListBuilder.create(), PartPose.offset(-0.2085F, 3.2F, 2.3806F));

        PartDefinition cube_r10 = tooth4.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(38, 57).addBox(-0.5F, -0.5F, -2.5F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.475F, 4.725F, -2.3998F, 0.0F, 0.0F));

        PartDefinition cube_r11 = tooth4.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(54, 37).addBox(-0.5F, -0.5F, -3.5F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.825F, 0.4F, -3.0107F, 0.0F, 0.0F));

        PartDefinition cube_r12 = tooth4.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(34, 62).addBox(-0.5F, -0.5F, -1.5F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.375F, 0.0F, -2.0508F, 0.0F, 0.0F));

        PartDefinition plate4 = bone.addOrReplaceChild("plate4", CubeListBuilder.create(), PartPose.offset(-2.675F, 6.5F, 5.375F));

        PartDefinition b2 = plate4.addOrReplaceChild("b2", CubeListBuilder.create().texOffs(18, 43).addBox(-1.825F, -8.0F, -8.375F, 1.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition cube_r13 = b2.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(56, 57).addBox(0.0F, -2.0F, 0.0F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.0F, -10.75F, 0.0F, -0.6545F, 0.0F));

        PartDefinition cube_r14 = b2.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(48, 57).addBox(0.0F, -2.0F, -3.0F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.0F, 0.0F, 0.0F, 0.6545F, 0.0F));

        PartDefinition b3 = plate4.addOrReplaceChild("b3", CubeListBuilder.create().texOffs(46, 43).addBox(-1.039F, 0.0F, -3.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.614F, -9.2F, -5.375F, 0.0F, 0.0F, 0.9163F));

        PartDefinition cube_r15 = b3.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(56, 27).addBox(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.786F, 0.0F, -5.375F, 0.0F, -0.6545F, 0.0F));

        PartDefinition cube_r16 = b3.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(38, 52).addBox(0.0F, 0.0F, -3.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.786F, 0.0F, 5.375F, 0.0F, 0.6545F, 0.0F));

        PartDefinition b4 = plate4.addOrReplaceChild("b4", CubeListBuilder.create().texOffs(0, 49).addBox(-1.039F, -1.0F, -3.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.614F, -3.8F, -5.375F, 0.0F, 0.0F, -0.9163F));

        PartDefinition cube_r17 = b4.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(18, 58).addBox(0.0F, -1.0F, 0.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.786F, 0.0F, -5.375F, 0.0F, -0.6545F, 0.0F));

        PartDefinition cube_r18 = b4.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(58, 6).addBox(0.0F, -1.0F, -3.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.786F, 0.0F, 5.375F, 0.0F, 0.6545F, 0.0F));

        PartDefinition plate5 = bone.addOrReplaceChild("plate5", CubeListBuilder.create(), PartPose.offset(2.675F, 6.5F, -5.375F));

        PartDefinition b5 = plate5.addOrReplaceChild("b5", CubeListBuilder.create().texOffs(32, 43).addBox(0.825F, -8.0F, 2.375F, 1.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition cube_r19 = b5.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(10, 58).addBox(-1.0F, -2.0F, -3.0F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.0F, 10.75F, 0.0F, -0.6545F, 0.0F));

        PartDefinition cube_r20 = b5.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(58, 0).addBox(-1.0F, -2.0F, 0.0F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.0F, 0.0F, 0.0F, 0.6545F, 0.0F));

        PartDefinition b12 = plate5.addOrReplaceChild("b12", CubeListBuilder.create().texOffs(50, 10).addBox(0.039F, 0.0F, -3.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.614F, -9.2F, 5.375F, 0.0F, 0.0F, -0.9163F));

        PartDefinition cube_r21 = b12.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(60, 43).addBox(-1.0F, 0.0F, -3.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.786F, 0.0F, 5.375F, 0.0F, -0.6545F, 0.0F));

        PartDefinition cube_r22 = b12.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(26, 58).addBox(-1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.786F, 0.0F, -5.375F, 0.0F, 0.6545F, 0.0F));

        PartDefinition b13 = plate5.addOrReplaceChild("b13", CubeListBuilder.create().texOffs(46, 50).addBox(0.039F, -1.0F, -3.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.614F, -3.8F, 5.375F, 0.0F, 0.0F, 0.9163F));

        PartDefinition cube_r23 = b13.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(60, 51).addBox(-1.0F, -1.0F, -3.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.786F, 0.0F, 5.375F, 0.0F, -0.6545F, 0.0F));

        PartDefinition cube_r24 = b13.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(60, 47).addBox(-1.0F, -1.0F, 0.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.786F, 0.0F, -5.375F, 0.0F, 0.6545F, 0.0F));

        PartDefinition bone2 = partdefinition.addOrReplaceChild("bone2", CubeListBuilder.create().texOffs(0, 18).addBox(-3.5F, -1.5F, -4.0F, 7.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition plate2 = bone2.addOrReplaceChild("plate2", CubeListBuilder.create(), PartPose.offset(-2.675F, 6.5F, 5.375F));

        PartDefinition b6 = plate2.addOrReplaceChild("b6", CubeListBuilder.create().texOffs(18, 43).addBox(-1.825F, -8.0F, -8.375F, 1.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition cube_r25 = b6.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(56, 57).addBox(0.0F, -2.0F, 0.0F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.0F, -10.75F, 0.0F, -0.6545F, 0.0F));

        PartDefinition cube_r26 = b6.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(48, 57).addBox(0.0F, -2.0F, -3.0F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.0F, 0.0F, 0.0F, 0.6545F, 0.0F));

        PartDefinition b7 = plate2.addOrReplaceChild("b7", CubeListBuilder.create().texOffs(46, 43).addBox(-1.039F, 0.0F, -3.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.614F, -9.2F, -5.375F, 0.0F, 0.0F, 0.9163F));

        PartDefinition cube_r27 = b7.addOrReplaceChild("cube_r27", CubeListBuilder.create().texOffs(56, 27).addBox(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.786F, 0.0F, -5.375F, 0.0F, -0.6545F, 0.0F));

        PartDefinition cube_r28 = b7.addOrReplaceChild("cube_r28", CubeListBuilder.create().texOffs(38, 52).addBox(0.0F, 0.0F, -3.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.786F, 0.0F, 5.375F, 0.0F, 0.6545F, 0.0F));

        PartDefinition b8 = plate2.addOrReplaceChild("b8", CubeListBuilder.create().texOffs(0, 49).addBox(-1.039F, -1.0F, -3.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.614F, -3.8F, -5.375F, 0.0F, 0.0F, -0.9163F));

        PartDefinition cube_r29 = b8.addOrReplaceChild("cube_r29", CubeListBuilder.create().texOffs(18, 58).addBox(0.0F, -1.0F, 0.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.786F, 0.0F, -5.375F, 0.0F, -0.6545F, 0.0F));

        PartDefinition cube_r30 = b8.addOrReplaceChild("cube_r30", CubeListBuilder.create().texOffs(58, 6).addBox(0.0F, -1.0F, -3.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.786F, 0.0F, 5.375F, 0.0F, 0.6545F, 0.0F));

        PartDefinition plate3 = bone2.addOrReplaceChild("plate3", CubeListBuilder.create(), PartPose.offset(2.675F, 6.5F, -5.375F));

        PartDefinition b9 = plate3.addOrReplaceChild("b9", CubeListBuilder.create().texOffs(32, 43).addBox(0.825F, -8.0F, 2.375F, 1.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition cube_r31 = b9.addOrReplaceChild("cube_r31", CubeListBuilder.create().texOffs(10, 58).addBox(-1.0F, -2.0F, -3.0F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.0F, 10.75F, 0.0F, -0.6545F, 0.0F));

        PartDefinition cube_r32 = b9.addOrReplaceChild("cube_r32", CubeListBuilder.create().texOffs(58, 0).addBox(-1.0F, -2.0F, 0.0F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.0F, 0.0F, 0.0F, 0.6545F, 0.0F));

        PartDefinition b10 = plate3.addOrReplaceChild("b10", CubeListBuilder.create().texOffs(50, 10).addBox(0.039F, 0.0F, -3.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.614F, -9.2F, 5.375F, 0.0F, 0.0F, -0.9163F));

        PartDefinition cube_r33 = b10.addOrReplaceChild("cube_r33", CubeListBuilder.create().texOffs(60, 43).addBox(-1.0F, 0.0F, -3.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.786F, 0.0F, 5.375F, 0.0F, -0.6545F, 0.0F));

        PartDefinition cube_r34 = b10.addOrReplaceChild("cube_r34", CubeListBuilder.create().texOffs(26, 58).addBox(-1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.786F, 0.0F, -5.375F, 0.0F, 0.6545F, 0.0F));

        PartDefinition b11 = plate3.addOrReplaceChild("b11", CubeListBuilder.create().texOffs(46, 50).addBox(0.039F, -1.0F, -3.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.614F, -3.8F, 5.375F, 0.0F, 0.0F, 0.9163F));

        PartDefinition cube_r35 = b11.addOrReplaceChild("cube_r35", CubeListBuilder.create().texOffs(60, 51).addBox(-1.0F, -1.0F, -3.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.786F, 0.0F, 5.375F, 0.0F, -0.6545F, 0.0F));

        PartDefinition cube_r36 = b11.addOrReplaceChild("cube_r36", CubeListBuilder.create().texOffs(60, 47).addBox(-1.0F, -1.0F, 0.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.786F, 0.0F, -5.375F, 0.0F, 0.6545F, 0.0F));

        PartDefinition bone10 = partdefinition.addOrReplaceChild("bone10", CubeListBuilder.create().texOffs(0, 29).addBox(-3.5F, -1.5F, -4.0F, 7.0F, 3.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(0, 40).addBox(-0.5F, -0.5F, -12.0F, 1.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition plate6 = bone10.addOrReplaceChild("plate6", CubeListBuilder.create(), PartPose.offset(-2.675F, 6.5F, 5.375F));

        PartDefinition b14 = plate6.addOrReplaceChild("b14", CubeListBuilder.create().texOffs(18, 43).addBox(-1.825F, -8.0F, -8.375F, 1.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition cube_r37 = b14.addOrReplaceChild("cube_r37", CubeListBuilder.create().texOffs(56, 57).addBox(0.0F, -2.0F, 0.0F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.0F, -10.75F, 0.0F, -0.6545F, 0.0F));

        PartDefinition cube_r38 = b14.addOrReplaceChild("cube_r38", CubeListBuilder.create().texOffs(48, 57).addBox(0.0F, -2.0F, -3.0F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.0F, 0.0F, 0.0F, 0.6545F, 0.0F));

        PartDefinition b15 = plate6.addOrReplaceChild("b15", CubeListBuilder.create().texOffs(46, 43).addBox(-1.039F, 0.0F, -3.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.614F, -9.2F, -5.375F, 0.0F, 0.0F, 0.9163F));

        PartDefinition cube_r39 = b15.addOrReplaceChild("cube_r39", CubeListBuilder.create().texOffs(56, 27).addBox(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.786F, 0.0F, -5.375F, 0.0F, -0.6545F, 0.0F));

        PartDefinition cube_r40 = b15.addOrReplaceChild("cube_r40", CubeListBuilder.create().texOffs(38, 52).addBox(0.0F, 0.0F, -3.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.786F, 0.0F, 5.375F, 0.0F, 0.6545F, 0.0F));

        PartDefinition b16 = plate6.addOrReplaceChild("b16", CubeListBuilder.create().texOffs(0, 49).addBox(-1.039F, -1.0F, -3.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.614F, -3.8F, -5.375F, 0.0F, 0.0F, -0.9163F));

        PartDefinition cube_r41 = b16.addOrReplaceChild("cube_r41", CubeListBuilder.create().texOffs(18, 58).addBox(0.0F, -1.0F, 0.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.786F, 0.0F, -5.375F, 0.0F, -0.6545F, 0.0F));

        PartDefinition cube_r42 = b16.addOrReplaceChild("cube_r42", CubeListBuilder.create().texOffs(58, 6).addBox(0.0F, -1.0F, -3.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.786F, 0.0F, 5.375F, 0.0F, 0.6545F, 0.0F));

        PartDefinition plate7 = bone10.addOrReplaceChild("plate7", CubeListBuilder.create(), PartPose.offset(2.675F, 6.5F, -5.375F));

        PartDefinition b17 = plate7.addOrReplaceChild("b17", CubeListBuilder.create().texOffs(32, 43).addBox(0.825F, -8.0F, 2.375F, 1.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition cube_r43 = b17.addOrReplaceChild("cube_r43", CubeListBuilder.create().texOffs(10, 58).addBox(-1.0F, -2.0F, -3.0F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.0F, 10.75F, 0.0F, -0.6545F, 0.0F));

        PartDefinition cube_r44 = b17.addOrReplaceChild("cube_r44", CubeListBuilder.create().texOffs(58, 0).addBox(-1.0F, -2.0F, 0.0F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.0F, 0.0F, 0.0F, 0.6545F, 0.0F));

        PartDefinition b18 = plate7.addOrReplaceChild("b18", CubeListBuilder.create().texOffs(50, 10).addBox(0.039F, 0.0F, -3.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.614F, -9.2F, 5.375F, 0.0F, 0.0F, -0.9163F));

        PartDefinition cube_r45 = b18.addOrReplaceChild("cube_r45", CubeListBuilder.create().texOffs(60, 43).addBox(-1.0F, 0.0F, -3.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.786F, 0.0F, 5.375F, 0.0F, -0.6545F, 0.0F));

        PartDefinition cube_r46 = b18.addOrReplaceChild("cube_r46", CubeListBuilder.create().texOffs(26, 58).addBox(-1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.786F, 0.0F, -5.375F, 0.0F, 0.6545F, 0.0F));

        PartDefinition b19 = plate7.addOrReplaceChild("b19", CubeListBuilder.create().texOffs(46, 50).addBox(0.039F, -1.0F, -3.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.614F, -3.8F, 5.375F, 0.0F, 0.0F, 0.9163F));

        PartDefinition cube_r47 = b19.addOrReplaceChild("cube_r47", CubeListBuilder.create().texOffs(60, 51).addBox(-1.0F, -1.0F, -3.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.786F, 0.0F, 5.375F, 0.0F, -0.6545F, 0.0F));

        PartDefinition cube_r48 = b19.addOrReplaceChild("cube_r48", CubeListBuilder.create().texOffs(60, 47).addBox(-1.0F, -1.0F, 0.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.786F, 0.0F, -5.375F, 0.0F, 0.6545F, 0.0F));

        PartDefinition bone11 = partdefinition.addOrReplaceChild("bone11", CubeListBuilder.create().texOffs(36, 0).addBox(-1.5F, -1.0F, -4.0F, 3.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition bone12 = partdefinition.addOrReplaceChild("bone12", CubeListBuilder.create().texOffs(30, 31).addBox(-1.0F, -2.0F, -5.0F, 2.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 25.0F, 0.0F));

        PartDefinition bone13 = partdefinition.addOrReplaceChild("bone13", CubeListBuilder.create(), PartPose.offset(0.0F, 25.0F, 0.0F));

        PartDefinition cube_r49 = bone13.addOrReplaceChild("cube_r49", CubeListBuilder.create().texOffs(36, 10).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 4.6229F, -6.4071F, 2.7053F, 0.0F, 0.0F));

        PartDefinition cube_r50 = bone13.addOrReplaceChild("cube_r50", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -1.0F, -16.0F, 2.0F, 2.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.1F, 8.4F, 0.3927F, 0.0F, 0.0F));

        PartDefinition bone3 = partdefinition.addOrReplaceChild("bone3", CubeListBuilder.create().texOffs(0, 18).addBox(-3.5F, -1.5F, -4.0F, 7.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition plate8 = bone3.addOrReplaceChild("plate8", CubeListBuilder.create(), PartPose.offset(-2.675F, 6.5F, 5.375F));

        PartDefinition b20 = plate8.addOrReplaceChild("b20", CubeListBuilder.create().texOffs(18, 43).addBox(-1.825F, -8.0F, -8.375F, 1.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition cube_r51 = b20.addOrReplaceChild("cube_r51", CubeListBuilder.create().texOffs(56, 57).addBox(0.0F, -2.0F, 0.0F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.0F, -10.75F, 0.0F, -0.6545F, 0.0F));

        PartDefinition cube_r52 = b20.addOrReplaceChild("cube_r52", CubeListBuilder.create().texOffs(48, 57).addBox(0.0F, -2.0F, -3.0F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.0F, 0.0F, 0.0F, 0.6545F, 0.0F));

        PartDefinition b21 = plate8.addOrReplaceChild("b21", CubeListBuilder.create().texOffs(46, 43).addBox(-1.039F, 0.0F, -3.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.614F, -9.2F, -5.375F, 0.0F, 0.0F, 0.9163F));

        PartDefinition cube_r53 = b21.addOrReplaceChild("cube_r53", CubeListBuilder.create().texOffs(56, 27).addBox(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.786F, 0.0F, -5.375F, 0.0F, -0.6545F, 0.0F));

        PartDefinition cube_r54 = b21.addOrReplaceChild("cube_r54", CubeListBuilder.create().texOffs(38, 52).addBox(0.0F, 0.0F, -3.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.786F, 0.0F, 5.375F, 0.0F, 0.6545F, 0.0F));

        PartDefinition b22 = plate8.addOrReplaceChild("b22", CubeListBuilder.create().texOffs(0, 49).addBox(-1.039F, -1.0F, -3.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.614F, -3.8F, -5.375F, 0.0F, 0.0F, -0.9163F));

        PartDefinition cube_r55 = b22.addOrReplaceChild("cube_r55", CubeListBuilder.create().texOffs(18, 58).addBox(0.0F, -1.0F, 0.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.786F, 0.0F, -5.375F, 0.0F, -0.6545F, 0.0F));

        PartDefinition cube_r56 = b22.addOrReplaceChild("cube_r56", CubeListBuilder.create().texOffs(58, 6).addBox(0.0F, -1.0F, -3.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.786F, 0.0F, 5.375F, 0.0F, 0.6545F, 0.0F));

        PartDefinition plate9 = bone3.addOrReplaceChild("plate9", CubeListBuilder.create(), PartPose.offset(2.675F, 6.5F, -5.375F));

        PartDefinition b23 = plate9.addOrReplaceChild("b23", CubeListBuilder.create().texOffs(32, 43).addBox(0.825F, -8.0F, 2.375F, 1.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition cube_r57 = b23.addOrReplaceChild("cube_r57", CubeListBuilder.create().texOffs(10, 58).addBox(-1.0F, -2.0F, -3.0F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.0F, 10.75F, 0.0F, -0.6545F, 0.0F));

        PartDefinition cube_r58 = b23.addOrReplaceChild("cube_r58", CubeListBuilder.create().texOffs(58, 0).addBox(-1.0F, -2.0F, 0.0F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.0F, 0.0F, 0.0F, 0.6545F, 0.0F));

        PartDefinition b24 = plate9.addOrReplaceChild("b24", CubeListBuilder.create().texOffs(50, 10).addBox(0.039F, 0.0F, -3.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.614F, -9.2F, 5.375F, 0.0F, 0.0F, -0.9163F));

        PartDefinition cube_r59 = b24.addOrReplaceChild("cube_r59", CubeListBuilder.create().texOffs(60, 43).addBox(-1.0F, 0.0F, -3.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.786F, 0.0F, 5.375F, 0.0F, -0.6545F, 0.0F));

        PartDefinition cube_r60 = b24.addOrReplaceChild("cube_r60", CubeListBuilder.create().texOffs(26, 58).addBox(-1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.786F, 0.0F, -5.375F, 0.0F, 0.6545F, 0.0F));

        PartDefinition b25 = plate9.addOrReplaceChild("b25", CubeListBuilder.create().texOffs(46, 50).addBox(0.039F, -1.0F, -3.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.614F, -3.8F, 5.375F, 0.0F, 0.0F, 0.9163F));

        PartDefinition cube_r61 = b25.addOrReplaceChild("cube_r61", CubeListBuilder.create().texOffs(60, 51).addBox(-1.0F, -1.0F, -3.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.786F, 0.0F, 5.375F, 0.0F, -0.6545F, 0.0F));

        PartDefinition cube_r62 = b25.addOrReplaceChild("cube_r62", CubeListBuilder.create().texOffs(60, 47).addBox(-1.0F, -1.0F, 0.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.786F, 0.0F, -5.375F, 0.0F, 0.6545F, 0.0F));

        PartDefinition bone4 = partdefinition.addOrReplaceChild("bone4", CubeListBuilder.create().texOffs(0, 18).addBox(-3.5F, -1.5F, -4.0F, 7.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition plate10 = bone4.addOrReplaceChild("plate10", CubeListBuilder.create(), PartPose.offset(-2.675F, 6.5F, 5.375F));

        PartDefinition b26 = plate10.addOrReplaceChild("b26", CubeListBuilder.create().texOffs(18, 43).addBox(-1.825F, -8.0F, -8.375F, 1.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition cube_r63 = b26.addOrReplaceChild("cube_r63", CubeListBuilder.create().texOffs(56, 57).addBox(0.0F, -2.0F, 0.0F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.0F, -10.75F, 0.0F, -0.6545F, 0.0F));

        PartDefinition cube_r64 = b26.addOrReplaceChild("cube_r64", CubeListBuilder.create().texOffs(48, 57).addBox(0.0F, -2.0F, -3.0F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.0F, 0.0F, 0.0F, 0.6545F, 0.0F));

        PartDefinition b27 = plate10.addOrReplaceChild("b27", CubeListBuilder.create().texOffs(46, 43).addBox(-1.039F, 0.0F, -3.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.614F, -9.2F, -5.375F, 0.0F, 0.0F, 0.9163F));

        PartDefinition cube_r65 = b27.addOrReplaceChild("cube_r65", CubeListBuilder.create().texOffs(56, 27).addBox(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.786F, 0.0F, -5.375F, 0.0F, -0.6545F, 0.0F));

        PartDefinition cube_r66 = b27.addOrReplaceChild("cube_r66", CubeListBuilder.create().texOffs(38, 52).addBox(0.0F, 0.0F, -3.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.786F, 0.0F, 5.375F, 0.0F, 0.6545F, 0.0F));

        PartDefinition b28 = plate10.addOrReplaceChild("b28", CubeListBuilder.create().texOffs(0, 49).addBox(-1.039F, -1.0F, -3.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.614F, -3.8F, -5.375F, 0.0F, 0.0F, -0.9163F));

        PartDefinition cube_r67 = b28.addOrReplaceChild("cube_r67", CubeListBuilder.create().texOffs(18, 58).addBox(0.0F, -1.0F, 0.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.786F, 0.0F, -5.375F, 0.0F, -0.6545F, 0.0F));

        PartDefinition cube_r68 = b28.addOrReplaceChild("cube_r68", CubeListBuilder.create().texOffs(58, 6).addBox(0.0F, -1.0F, -3.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.786F, 0.0F, 5.375F, 0.0F, 0.6545F, 0.0F));

        PartDefinition plate11 = bone4.addOrReplaceChild("plate11", CubeListBuilder.create(), PartPose.offset(2.675F, 6.5F, -5.375F));

        PartDefinition b29 = plate11.addOrReplaceChild("b29", CubeListBuilder.create().texOffs(32, 43).addBox(0.825F, -8.0F, 2.375F, 1.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition cube_r69 = b29.addOrReplaceChild("cube_r69", CubeListBuilder.create().texOffs(10, 58).addBox(-1.0F, -2.0F, -3.0F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.0F, 10.75F, 0.0F, -0.6545F, 0.0F));

        PartDefinition cube_r70 = b29.addOrReplaceChild("cube_r70", CubeListBuilder.create().texOffs(58, 0).addBox(-1.0F, -2.0F, 0.0F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.0F, 0.0F, 0.0F, 0.6545F, 0.0F));

        PartDefinition b30 = plate11.addOrReplaceChild("b30", CubeListBuilder.create().texOffs(50, 10).addBox(0.039F, 0.0F, -3.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.614F, -9.2F, 5.375F, 0.0F, 0.0F, -0.9163F));

        PartDefinition cube_r71 = b30.addOrReplaceChild("cube_r71", CubeListBuilder.create().texOffs(60, 43).addBox(-1.0F, 0.0F, -3.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.786F, 0.0F, 5.375F, 0.0F, -0.6545F, 0.0F));

        PartDefinition cube_r72 = b30.addOrReplaceChild("cube_r72", CubeListBuilder.create().texOffs(26, 58).addBox(-1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.786F, 0.0F, -5.375F, 0.0F, 0.6545F, 0.0F));

        PartDefinition b31 = plate11.addOrReplaceChild("b31", CubeListBuilder.create().texOffs(46, 50).addBox(0.039F, -1.0F, -3.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.614F, -3.8F, 5.375F, 0.0F, 0.0F, 0.9163F));

        PartDefinition cube_r73 = b31.addOrReplaceChild("cube_r73", CubeListBuilder.create().texOffs(60, 51).addBox(-1.0F, -1.0F, -3.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.786F, 0.0F, 5.375F, 0.0F, -0.6545F, 0.0F));

        PartDefinition cube_r74 = b31.addOrReplaceChild("cube_r74", CubeListBuilder.create().texOffs(60, 47).addBox(-1.0F, -1.0F, 0.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.786F, 0.0F, -5.375F, 0.0F, 0.6545F, 0.0F));

        PartDefinition bone5 = partdefinition.addOrReplaceChild("bone5", CubeListBuilder.create().texOffs(0, 18).addBox(-3.5F, -1.5F, -4.0F, 7.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition plate12 = bone5.addOrReplaceChild("plate12", CubeListBuilder.create(), PartPose.offset(-2.675F, 6.5F, 5.375F));

        PartDefinition b32 = plate12.addOrReplaceChild("b32", CubeListBuilder.create().texOffs(18, 43).addBox(-1.825F, -8.0F, -8.375F, 1.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition cube_r75 = b32.addOrReplaceChild("cube_r75", CubeListBuilder.create().texOffs(56, 57).addBox(0.0F, -2.0F, 0.0F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.0F, -10.75F, 0.0F, -0.6545F, 0.0F));

        PartDefinition cube_r76 = b32.addOrReplaceChild("cube_r76", CubeListBuilder.create().texOffs(48, 57).addBox(0.0F, -2.0F, -3.0F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.0F, 0.0F, 0.0F, 0.6545F, 0.0F));

        PartDefinition b33 = plate12.addOrReplaceChild("b33", CubeListBuilder.create().texOffs(46, 43).addBox(-1.039F, 0.0F, -3.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.614F, -9.2F, -5.375F, 0.0F, 0.0F, 0.9163F));

        PartDefinition cube_r77 = b33.addOrReplaceChild("cube_r77", CubeListBuilder.create().texOffs(56, 27).addBox(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.786F, 0.0F, -5.375F, 0.0F, -0.6545F, 0.0F));

        PartDefinition cube_r78 = b33.addOrReplaceChild("cube_r78", CubeListBuilder.create().texOffs(38, 52).addBox(0.0F, 0.0F, -3.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.786F, 0.0F, 5.375F, 0.0F, 0.6545F, 0.0F));

        PartDefinition b34 = plate12.addOrReplaceChild("b34", CubeListBuilder.create().texOffs(0, 49).addBox(-1.039F, -1.0F, -3.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.614F, -3.8F, -5.375F, 0.0F, 0.0F, -0.9163F));

        PartDefinition cube_r79 = b34.addOrReplaceChild("cube_r79", CubeListBuilder.create().texOffs(18, 58).addBox(0.0F, -1.0F, 0.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.786F, 0.0F, -5.375F, 0.0F, -0.6545F, 0.0F));

        PartDefinition cube_r80 = b34.addOrReplaceChild("cube_r80", CubeListBuilder.create().texOffs(58, 6).addBox(0.0F, -1.0F, -3.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.786F, 0.0F, 5.375F, 0.0F, 0.6545F, 0.0F));

        PartDefinition plate13 = bone5.addOrReplaceChild("plate13", CubeListBuilder.create(), PartPose.offset(2.675F, 6.5F, -5.375F));

        PartDefinition b35 = plate13.addOrReplaceChild("b35", CubeListBuilder.create().texOffs(32, 43).addBox(0.825F, -8.0F, 2.375F, 1.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition cube_r81 = b35.addOrReplaceChild("cube_r81", CubeListBuilder.create().texOffs(10, 58).addBox(-1.0F, -2.0F, -3.0F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.0F, 10.75F, 0.0F, -0.6545F, 0.0F));

        PartDefinition cube_r82 = b35.addOrReplaceChild("cube_r82", CubeListBuilder.create().texOffs(58, 0).addBox(-1.0F, -2.0F, 0.0F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.0F, 0.0F, 0.0F, 0.6545F, 0.0F));

        PartDefinition b36 = plate13.addOrReplaceChild("b36", CubeListBuilder.create().texOffs(50, 10).addBox(0.039F, 0.0F, -3.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.614F, -9.2F, 5.375F, 0.0F, 0.0F, -0.9163F));

        PartDefinition cube_r83 = b36.addOrReplaceChild("cube_r83", CubeListBuilder.create().texOffs(60, 43).addBox(-1.0F, 0.0F, -3.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.786F, 0.0F, 5.375F, 0.0F, -0.6545F, 0.0F));

        PartDefinition cube_r84 = b36.addOrReplaceChild("cube_r84", CubeListBuilder.create().texOffs(26, 58).addBox(-1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.786F, 0.0F, -5.375F, 0.0F, 0.6545F, 0.0F));

        PartDefinition b37 = plate13.addOrReplaceChild("b37", CubeListBuilder.create().texOffs(46, 50).addBox(0.039F, -1.0F, -3.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.614F, -3.8F, 5.375F, 0.0F, 0.0F, 0.9163F));

        PartDefinition cube_r85 = b37.addOrReplaceChild("cube_r85", CubeListBuilder.create().texOffs(60, 51).addBox(-1.0F, -1.0F, -3.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.786F, 0.0F, 5.375F, 0.0F, -0.6545F, 0.0F));

        PartDefinition cube_r86 = b37.addOrReplaceChild("cube_r86", CubeListBuilder.create().texOffs(60, 47).addBox(-1.0F, -1.0F, 0.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.786F, 0.0F, -5.375F, 0.0F, 0.6545F, 0.0F));

        PartDefinition bone6 = partdefinition.addOrReplaceChild("bone6", CubeListBuilder.create().texOffs(0, 18).addBox(-3.5F, -1.5F, -4.0F, 7.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition plate14 = bone6.addOrReplaceChild("plate14", CubeListBuilder.create(), PartPose.offset(-2.675F, 6.5F, 5.375F));

        PartDefinition b38 = plate14.addOrReplaceChild("b38", CubeListBuilder.create().texOffs(18, 43).addBox(-1.825F, -8.0F, -8.375F, 1.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition cube_r87 = b38.addOrReplaceChild("cube_r87", CubeListBuilder.create().texOffs(56, 57).addBox(0.0F, -2.0F, 0.0F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.0F, -10.75F, 0.0F, -0.6545F, 0.0F));

        PartDefinition cube_r88 = b38.addOrReplaceChild("cube_r88", CubeListBuilder.create().texOffs(48, 57).addBox(0.0F, -2.0F, -3.0F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.0F, 0.0F, 0.0F, 0.6545F, 0.0F));

        PartDefinition b39 = plate14.addOrReplaceChild("b39", CubeListBuilder.create().texOffs(46, 43).addBox(-1.039F, 0.0F, -3.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.614F, -9.2F, -5.375F, 0.0F, 0.0F, 0.9163F));

        PartDefinition cube_r89 = b39.addOrReplaceChild("cube_r89", CubeListBuilder.create().texOffs(56, 27).addBox(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.786F, 0.0F, -5.375F, 0.0F, -0.6545F, 0.0F));

        PartDefinition cube_r90 = b39.addOrReplaceChild("cube_r90", CubeListBuilder.create().texOffs(38, 52).addBox(0.0F, 0.0F, -3.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.786F, 0.0F, 5.375F, 0.0F, 0.6545F, 0.0F));

        PartDefinition b40 = plate14.addOrReplaceChild("b40", CubeListBuilder.create().texOffs(0, 49).addBox(-1.039F, -1.0F, -3.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.614F, -3.8F, -5.375F, 0.0F, 0.0F, -0.9163F));

        PartDefinition cube_r91 = b40.addOrReplaceChild("cube_r91", CubeListBuilder.create().texOffs(18, 58).addBox(0.0F, -1.0F, 0.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.786F, 0.0F, -5.375F, 0.0F, -0.6545F, 0.0F));

        PartDefinition cube_r92 = b40.addOrReplaceChild("cube_r92", CubeListBuilder.create().texOffs(58, 6).addBox(0.0F, -1.0F, -3.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.786F, 0.0F, 5.375F, 0.0F, 0.6545F, 0.0F));

        PartDefinition plate15 = bone6.addOrReplaceChild("plate15", CubeListBuilder.create(), PartPose.offset(2.675F, 6.5F, -5.375F));

        PartDefinition b41 = plate15.addOrReplaceChild("b41", CubeListBuilder.create().texOffs(32, 43).addBox(0.825F, -8.0F, 2.375F, 1.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition cube_r93 = b41.addOrReplaceChild("cube_r93", CubeListBuilder.create().texOffs(10, 58).addBox(-1.0F, -2.0F, -3.0F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.0F, 10.75F, 0.0F, -0.6545F, 0.0F));

        PartDefinition cube_r94 = b41.addOrReplaceChild("cube_r94", CubeListBuilder.create().texOffs(58, 0).addBox(-1.0F, -2.0F, 0.0F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.0F, 0.0F, 0.0F, 0.6545F, 0.0F));

        PartDefinition b42 = plate15.addOrReplaceChild("b42", CubeListBuilder.create().texOffs(50, 10).addBox(0.039F, 0.0F, -3.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.614F, -9.2F, 5.375F, 0.0F, 0.0F, -0.9163F));

        PartDefinition cube_r95 = b42.addOrReplaceChild("cube_r95", CubeListBuilder.create().texOffs(60, 43).addBox(-1.0F, 0.0F, -3.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.786F, 0.0F, 5.375F, 0.0F, -0.6545F, 0.0F));

        PartDefinition cube_r96 = b42.addOrReplaceChild("cube_r96", CubeListBuilder.create().texOffs(26, 58).addBox(-1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.786F, 0.0F, -5.375F, 0.0F, 0.6545F, 0.0F));

        PartDefinition b43 = plate15.addOrReplaceChild("b43", CubeListBuilder.create().texOffs(46, 50).addBox(0.039F, -1.0F, -3.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.614F, -3.8F, 5.375F, 0.0F, 0.0F, 0.9163F));

        PartDefinition cube_r97 = b43.addOrReplaceChild("cube_r97", CubeListBuilder.create().texOffs(60, 51).addBox(-1.0F, -1.0F, -3.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.786F, 0.0F, 5.375F, 0.0F, -0.6545F, 0.0F));

        PartDefinition cube_r98 = b43.addOrReplaceChild("cube_r98", CubeListBuilder.create().texOffs(60, 47).addBox(-1.0F, -1.0F, 0.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.786F, 0.0F, -5.375F, 0.0F, 0.6545F, 0.0F));

        PartDefinition bone7 = partdefinition.addOrReplaceChild("bone7", CubeListBuilder.create().texOffs(0, 18).addBox(-3.5F, -1.5F, -4.0F, 7.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition plate16 = bone7.addOrReplaceChild("plate16", CubeListBuilder.create(), PartPose.offset(-2.675F, 6.5F, 5.375F));

        PartDefinition b44 = plate16.addOrReplaceChild("b44", CubeListBuilder.create().texOffs(18, 43).addBox(-1.825F, -8.0F, -8.375F, 1.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition cube_r99 = b44.addOrReplaceChild("cube_r99", CubeListBuilder.create().texOffs(56, 57).addBox(0.0F, -2.0F, 0.0F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.0F, -10.75F, 0.0F, -0.6545F, 0.0F));

        PartDefinition cube_r100 = b44.addOrReplaceChild("cube_r100", CubeListBuilder.create().texOffs(48, 57).addBox(0.0F, -2.0F, -3.0F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.0F, 0.0F, 0.0F, 0.6545F, 0.0F));

        PartDefinition b45 = plate16.addOrReplaceChild("b45", CubeListBuilder.create().texOffs(46, 43).addBox(-1.039F, 0.0F, -3.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.614F, -9.2F, -5.375F, 0.0F, 0.0F, 0.9163F));

        PartDefinition cube_r101 = b45.addOrReplaceChild("cube_r101", CubeListBuilder.create().texOffs(56, 27).addBox(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.786F, 0.0F, -5.375F, 0.0F, -0.6545F, 0.0F));

        PartDefinition cube_r102 = b45.addOrReplaceChild("cube_r102", CubeListBuilder.create().texOffs(38, 52).addBox(0.0F, 0.0F, -3.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.786F, 0.0F, 5.375F, 0.0F, 0.6545F, 0.0F));

        PartDefinition b46 = plate16.addOrReplaceChild("b46", CubeListBuilder.create().texOffs(0, 49).addBox(-1.039F, -1.0F, -3.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.614F, -3.8F, -5.375F, 0.0F, 0.0F, -0.9163F));

        PartDefinition cube_r103 = b46.addOrReplaceChild("cube_r103", CubeListBuilder.create().texOffs(18, 58).addBox(0.0F, -1.0F, 0.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.786F, 0.0F, -5.375F, 0.0F, -0.6545F, 0.0F));

        PartDefinition cube_r104 = b46.addOrReplaceChild("cube_r104", CubeListBuilder.create().texOffs(58, 6).addBox(0.0F, -1.0F, -3.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.786F, 0.0F, 5.375F, 0.0F, 0.6545F, 0.0F));

        PartDefinition plate17 = bone7.addOrReplaceChild("plate17", CubeListBuilder.create(), PartPose.offset(2.675F, 6.5F, -5.375F));

        PartDefinition b47 = plate17.addOrReplaceChild("b47", CubeListBuilder.create().texOffs(32, 43).addBox(0.825F, -8.0F, 2.375F, 1.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition cube_r105 = b47.addOrReplaceChild("cube_r105", CubeListBuilder.create().texOffs(10, 58).addBox(-1.0F, -2.0F, -3.0F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.0F, 10.75F, 0.0F, -0.6545F, 0.0F));

        PartDefinition cube_r106 = b47.addOrReplaceChild("cube_r106", CubeListBuilder.create().texOffs(58, 0).addBox(-1.0F, -2.0F, 0.0F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.0F, 0.0F, 0.0F, 0.6545F, 0.0F));

        PartDefinition b48 = plate17.addOrReplaceChild("b48", CubeListBuilder.create().texOffs(50, 10).addBox(0.039F, 0.0F, -3.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.614F, -9.2F, 5.375F, 0.0F, 0.0F, -0.9163F));

        PartDefinition cube_r107 = b48.addOrReplaceChild("cube_r107", CubeListBuilder.create().texOffs(60, 43).addBox(-1.0F, 0.0F, -3.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.786F, 0.0F, 5.375F, 0.0F, -0.6545F, 0.0F));

        PartDefinition cube_r108 = b48.addOrReplaceChild("cube_r108", CubeListBuilder.create().texOffs(26, 58).addBox(-1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.786F, 0.0F, -5.375F, 0.0F, 0.6545F, 0.0F));

        PartDefinition b49 = plate17.addOrReplaceChild("b49", CubeListBuilder.create().texOffs(46, 50).addBox(0.039F, -1.0F, -3.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.614F, -3.8F, 5.375F, 0.0F, 0.0F, 0.9163F));

        PartDefinition cube_r109 = b49.addOrReplaceChild("cube_r109", CubeListBuilder.create().texOffs(60, 51).addBox(-1.0F, -1.0F, -3.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.786F, 0.0F, 5.375F, 0.0F, -0.6545F, 0.0F));

        PartDefinition cube_r110 = b49.addOrReplaceChild("cube_r110", CubeListBuilder.create().texOffs(60, 47).addBox(-1.0F, -1.0F, 0.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.786F, 0.0F, -5.375F, 0.0F, 0.6545F, 0.0F));

        PartDefinition bone8 = partdefinition.addOrReplaceChild("bone8", CubeListBuilder.create().texOffs(0, 18).addBox(-3.5F, -1.5F, -4.0F, 7.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition plate18 = bone8.addOrReplaceChild("plate18", CubeListBuilder.create(), PartPose.offset(-2.675F, 6.5F, 5.375F));

        PartDefinition b50 = plate18.addOrReplaceChild("b50", CubeListBuilder.create().texOffs(18, 43).addBox(-1.825F, -8.0F, -8.375F, 1.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition cube_r111 = b50.addOrReplaceChild("cube_r111", CubeListBuilder.create().texOffs(56, 57).addBox(0.0F, -2.0F, 0.0F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.0F, -10.75F, 0.0F, -0.6545F, 0.0F));

        PartDefinition cube_r112 = b50.addOrReplaceChild("cube_r112", CubeListBuilder.create().texOffs(48, 57).addBox(0.0F, -2.0F, -3.0F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.0F, 0.0F, 0.0F, 0.6545F, 0.0F));

        PartDefinition b51 = plate18.addOrReplaceChild("b51", CubeListBuilder.create().texOffs(46, 43).addBox(-1.039F, 0.0F, -3.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.614F, -9.2F, -5.375F, 0.0F, 0.0F, 0.9163F));

        PartDefinition cube_r113 = b51.addOrReplaceChild("cube_r113", CubeListBuilder.create().texOffs(56, 27).addBox(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.786F, 0.0F, -5.375F, 0.0F, -0.6545F, 0.0F));

        PartDefinition cube_r114 = b51.addOrReplaceChild("cube_r114", CubeListBuilder.create().texOffs(38, 52).addBox(0.0F, 0.0F, -3.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.786F, 0.0F, 5.375F, 0.0F, 0.6545F, 0.0F));

        PartDefinition b52 = plate18.addOrReplaceChild("b52", CubeListBuilder.create().texOffs(0, 49).addBox(-1.039F, -1.0F, -3.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.614F, -3.8F, -5.375F, 0.0F, 0.0F, -0.9163F));

        PartDefinition cube_r115 = b52.addOrReplaceChild("cube_r115", CubeListBuilder.create().texOffs(18, 58).addBox(0.0F, -1.0F, 0.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.786F, 0.0F, -5.375F, 0.0F, -0.6545F, 0.0F));

        PartDefinition cube_r116 = b52.addOrReplaceChild("cube_r116", CubeListBuilder.create().texOffs(58, 6).addBox(0.0F, -1.0F, -3.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.786F, 0.0F, 5.375F, 0.0F, 0.6545F, 0.0F));

        PartDefinition plate19 = bone8.addOrReplaceChild("plate19", CubeListBuilder.create(), PartPose.offset(2.675F, 6.5F, -5.375F));

        PartDefinition b53 = plate19.addOrReplaceChild("b53", CubeListBuilder.create().texOffs(32, 43).addBox(0.825F, -8.0F, 2.375F, 1.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition cube_r117 = b53.addOrReplaceChild("cube_r117", CubeListBuilder.create().texOffs(10, 58).addBox(-1.0F, -2.0F, -3.0F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.0F, 10.75F, 0.0F, -0.6545F, 0.0F));

        PartDefinition cube_r118 = b53.addOrReplaceChild("cube_r118", CubeListBuilder.create().texOffs(58, 0).addBox(-1.0F, -2.0F, 0.0F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.0F, 0.0F, 0.0F, 0.6545F, 0.0F));

        PartDefinition b54 = plate19.addOrReplaceChild("b54", CubeListBuilder.create().texOffs(50, 10).addBox(0.039F, 0.0F, -3.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.614F, -9.2F, 5.375F, 0.0F, 0.0F, -0.9163F));

        PartDefinition cube_r119 = b54.addOrReplaceChild("cube_r119", CubeListBuilder.create().texOffs(60, 43).addBox(-1.0F, 0.0F, -3.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.786F, 0.0F, 5.375F, 0.0F, -0.6545F, 0.0F));

        PartDefinition cube_r120 = b54.addOrReplaceChild("cube_r120", CubeListBuilder.create().texOffs(26, 58).addBox(-1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.786F, 0.0F, -5.375F, 0.0F, 0.6545F, 0.0F));

        PartDefinition b55 = plate19.addOrReplaceChild("b55", CubeListBuilder.create().texOffs(46, 50).addBox(0.039F, -1.0F, -3.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.614F, -3.8F, 5.375F, 0.0F, 0.0F, 0.9163F));

        PartDefinition cube_r121 = b55.addOrReplaceChild("cube_r121", CubeListBuilder.create().texOffs(60, 51).addBox(-1.0F, -1.0F, -3.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.786F, 0.0F, 5.375F, 0.0F, -0.6545F, 0.0F));

        PartDefinition cube_r122 = b55.addOrReplaceChild("cube_r122", CubeListBuilder.create().texOffs(60, 47).addBox(-1.0F, -1.0F, 0.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.786F, 0.0F, -5.375F, 0.0F, 0.6545F, 0.0F));

        PartDefinition bone9 = partdefinition.addOrReplaceChild("bone9", CubeListBuilder.create().texOffs(0, 18).addBox(-3.5F, -1.5F, -4.0F, 7.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition plate20 = bone9.addOrReplaceChild("plate20", CubeListBuilder.create(), PartPose.offset(-2.675F, 6.5F, 5.375F));

        PartDefinition b56 = plate20.addOrReplaceChild("b56", CubeListBuilder.create().texOffs(18, 43).addBox(-1.825F, -8.0F, -8.375F, 1.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition cube_r123 = b56.addOrReplaceChild("cube_r123", CubeListBuilder.create().texOffs(56, 57).addBox(0.0F, -2.0F, 0.0F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.0F, -10.75F, 0.0F, -0.6545F, 0.0F));

        PartDefinition cube_r124 = b56.addOrReplaceChild("cube_r124", CubeListBuilder.create().texOffs(48, 57).addBox(0.0F, -2.0F, -3.0F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.0F, 0.0F, 0.0F, 0.6545F, 0.0F));

        PartDefinition b57 = plate20.addOrReplaceChild("b57", CubeListBuilder.create().texOffs(46, 43).addBox(-1.039F, 0.0F, -3.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.614F, -9.2F, -5.375F, 0.0F, 0.0F, 0.9163F));

        PartDefinition cube_r125 = b57.addOrReplaceChild("cube_r125", CubeListBuilder.create().texOffs(56, 27).addBox(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.786F, 0.0F, -5.375F, 0.0F, -0.6545F, 0.0F));

        PartDefinition cube_r126 = b57.addOrReplaceChild("cube_r126", CubeListBuilder.create().texOffs(38, 52).addBox(0.0F, 0.0F, -3.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.786F, 0.0F, 5.375F, 0.0F, 0.6545F, 0.0F));

        PartDefinition b58 = plate20.addOrReplaceChild("b58", CubeListBuilder.create().texOffs(0, 49).addBox(-1.039F, -1.0F, -3.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.614F, -3.8F, -5.375F, 0.0F, 0.0F, -0.9163F));

        PartDefinition cube_r127 = b58.addOrReplaceChild("cube_r127", CubeListBuilder.create().texOffs(18, 58).addBox(0.0F, -1.0F, 0.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.786F, 0.0F, -5.375F, 0.0F, -0.6545F, 0.0F));

        PartDefinition cube_r128 = b58.addOrReplaceChild("cube_r128", CubeListBuilder.create().texOffs(58, 6).addBox(0.0F, -1.0F, -3.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.786F, 0.0F, 5.375F, 0.0F, 0.6545F, 0.0F));

        PartDefinition plate21 = bone9.addOrReplaceChild("plate21", CubeListBuilder.create(), PartPose.offset(2.675F, 6.5F, -5.375F));

        PartDefinition b59 = plate21.addOrReplaceChild("b59", CubeListBuilder.create().texOffs(32, 43).addBox(0.825F, -8.0F, 2.375F, 1.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition cube_r129 = b59.addOrReplaceChild("cube_r129", CubeListBuilder.create().texOffs(10, 58).addBox(-1.0F, -2.0F, -3.0F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.0F, 10.75F, 0.0F, -0.6545F, 0.0F));

        PartDefinition cube_r130 = b59.addOrReplaceChild("cube_r130", CubeListBuilder.create().texOffs(58, 0).addBox(-1.0F, -2.0F, 0.0F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.0F, 0.0F, 0.0F, 0.6545F, 0.0F));

        PartDefinition b60 = plate21.addOrReplaceChild("b60", CubeListBuilder.create().texOffs(50, 10).addBox(0.039F, 0.0F, -3.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.614F, -9.2F, 5.375F, 0.0F, 0.0F, -0.9163F));

        PartDefinition cube_r131 = b60.addOrReplaceChild("cube_r131", CubeListBuilder.create().texOffs(60, 43).addBox(-1.0F, 0.0F, -3.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.786F, 0.0F, 5.375F, 0.0F, -0.6545F, 0.0F));

        PartDefinition cube_r132 = b60.addOrReplaceChild("cube_r132", CubeListBuilder.create().texOffs(26, 58).addBox(-1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.786F, 0.0F, -5.375F, 0.0F, 0.6545F, 0.0F));

        PartDefinition b61 = plate21.addOrReplaceChild("b61", CubeListBuilder.create().texOffs(46, 50).addBox(0.039F, -1.0F, -3.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.614F, -3.8F, 5.375F, 0.0F, 0.0F, 0.9163F));

        PartDefinition cube_r133 = b61.addOrReplaceChild("cube_r133", CubeListBuilder.create().texOffs(60, 51).addBox(-1.0F, -1.0F, -3.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.786F, 0.0F, 5.375F, 0.0F, -0.6545F, 0.0F));

        PartDefinition cube_r134 = b61.addOrReplaceChild("cube_r134", CubeListBuilder.create().texOffs(60, 47).addBox(-1.0F, -1.0F, 0.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.786F, 0.0F, -5.375F, 0.0F, 0.6545F, 0.0F));

        PartDefinition bone14 = partdefinition.addOrReplaceChild("bone14", CubeListBuilder.create().texOffs(36, 0).addBox(-1.5F, -1.0F, -4.0F, 3.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition bone15 = partdefinition.addOrReplaceChild("bone15", CubeListBuilder.create().texOffs(30, 31).addBox(-1.0F, -2.0F, -5.0F, 2.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 25.0F, 0.0F));

        PartDefinition bone16 = partdefinition.addOrReplaceChild("bone16", CubeListBuilder.create(), PartPose.offset(0.0F, 25.0F, 0.0F));

        PartDefinition cube_r135 = bone16.addOrReplaceChild("cube_r135", CubeListBuilder.create().texOffs(36, 10).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 4.6229F, -6.4071F, 2.7053F, 0.0F, 0.0F));

        PartDefinition cube_r136 = bone16.addOrReplaceChild("cube_r136", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -1.0F, -16.0F, 2.0F, 2.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.1F, 8.4F, 0.3927F, 0.0F, 0.0F));

        PartDefinition bone17 = partdefinition.addOrReplaceChild("bone17", CubeListBuilder.create().texOffs(36, 0).addBox(-1.5F, -1.0F, -4.0F, 3.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition bone18 = partdefinition.addOrReplaceChild("bone18", CubeListBuilder.create().texOffs(30, 31).addBox(-1.0F, -2.0F, -5.0F, 2.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 25.0F, 0.0F));

        PartDefinition bone19 = partdefinition.addOrReplaceChild("bone19", CubeListBuilder.create(), PartPose.offset(0.0F, 25.0F, 0.0F));

        PartDefinition cube_r137 = bone19.addOrReplaceChild("cube_r137", CubeListBuilder.create().texOffs(36, 10).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 4.6229F, -6.4071F, 2.7053F, 0.0F, 0.0F));

        PartDefinition cube_r138 = bone19.addOrReplaceChild("cube_r138", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -1.0F, -16.0F, 2.0F, 2.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.1F, 8.4F, 0.3927F, 0.0F, 0.0F));

        PartDefinition bone20 = partdefinition.addOrReplaceChild("bone20", CubeListBuilder.create().texOffs(36, 0).addBox(-1.5F, -1.0F, -4.0F, 3.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition bone21 = partdefinition.addOrReplaceChild("bone21", CubeListBuilder.create().texOffs(30, 31).addBox(-1.0F, -2.0F, -5.0F, 2.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 25.0F, 0.0F));

        PartDefinition bone22 = partdefinition.addOrReplaceChild("bone22", CubeListBuilder.create(), PartPose.offset(0.0F, 25.0F, 0.0F));

        PartDefinition cube_r139 = bone22.addOrReplaceChild("cube_r139", CubeListBuilder.create().texOffs(36, 10).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 4.6229F, -6.4071F, 2.7053F, 0.0F, 0.0F));

        PartDefinition cube_r140 = bone22.addOrReplaceChild("cube_r140", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -1.0F, -16.0F, 2.0F, 2.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.1F, 8.4F, 0.3927F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 128, 128);
    }

    public LeechModel(ModelPart root) {
        // segment names. names of the folders containing the geometry of each animatable segment in blockbench
        super(root, new String[]
                {"bone", "bone2", "bone3", "bone4", "bone5", "bone6", "bone7", "bone8", "bone9", "bone10",
                        "bone11", "bone12", "bone13", "bone14", "bone15",
                        "bone16", "bone17", "bone18", "bone19", "bone20", "bone21", "bone22"});
    }

}
