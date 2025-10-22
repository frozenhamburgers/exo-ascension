package net.jelly.exo_ascension.entity.invasion.aetherion;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.jelly.exo_ascension.utility.AbstractPartEntity;
import net.jelly.exo_ascension.utility.MultipartModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.phys.Vec3;

public class AetherionModel extends MultipartModel<AetherionBoss> {
    private final ModelPart body;

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(94, 140).addBox(-9.0F, -53.0F, -9.0F, 18.0F, 18.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 28.0F, 0.0F));

        PartDefinition cube_r1 = body.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(166, 140).addBox(-10.0F, -4.0F, -7.0F, 7.0F, 6.0F, 28.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(16.0F, -38.5F, 0.0F, 0.0F, 1.5708F, -1.3963F));

        PartDefinition cube_r2 = body.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 148).addBox(3.0F, -4.0F, -7.0F, 7.0F, 6.0F, 28.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-16.0F, -38.5F, 0.0F, 0.0F, -1.5708F, 1.3963F));

        PartDefinition cube_r3 = body.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(70, 176).addBox(-10.0F, -4.0F, -7.0F, 20.0F, 6.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-20.0F, -38.5F, 0.0F, 0.0F, -1.5708F, 1.2654F));

        PartDefinition cube_r4 = body.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(166, 174).addBox(-10.0F, -4.0F, -7.0F, 20.0F, 6.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(20.0F, -38.5F, 0.0F, 0.0F, 1.5708F, -1.2654F));

        PartDefinition cube_r5 = body.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(108, 96).addBox(-12.0F, -8.0F, -14.0F, 8.0F, 16.0F, 28.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -31.75F, -3.5F, 1.5708F, -0.7854F, -1.5708F));

        PartDefinition cube_r6 = body.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(222, 0).addBox(-5.0F, -4.0F, -8.5F, 10.0F, 10.0F, 17.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-20.5F, -31.0F, 0.0F, 0.0F, 1.5708F, 0.9163F));

        PartDefinition cube_r7 = body.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(200, 60).addBox(-5.0F, -4.0F, -8.5F, 10.0F, 10.0F, 17.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(20.5F, -31.0F, 0.0F, 0.0F, -1.5708F, -0.9163F));

        PartDefinition cube_r8 = body.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(0, 0).addBox(-12.0F, -12.0F, -20.0F, 24.0F, 16.0F, 40.0F, new CubeDeformation(0.0F))
                .texOffs(108, 56).addBox(-10.0F, 4.0F, -13.0F, 20.0F, 14.0F, 26.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -24.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

        PartDefinition cube_r9 = body.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(276, 0).addBox(-9.0F, -7.0F, -4.5F, 18.0F, 14.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-11.5F, -16.0F, 0.0F, 0.0F, 1.5708F, -0.3927F));

        PartDefinition cube_r10 = body.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(272, 27).addBox(-9.0F, -7.0F, -4.5F, 18.0F, 14.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(11.5F, -16.0F, 0.0F, 0.0F, -1.5708F, 0.3927F));

        PartDefinition cube_r11 = body.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(52, 200).addBox(-10.0F, -8.0F, -5.0F, 20.0F, 13.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -13.0F, -2.0F, 0.0F, -1.5708F, 0.7854F));

        PartDefinition cube_r12 = body.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(288, 280).addBox(-10.0F, -7.0F, -3.0F, 20.0F, 12.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.0F, -20.0F, -1.0F, 0.0F, 1.5708F, -0.48F));

        PartDefinition cube_r13 = body.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(236, 280).addBox(-10.0F, -7.0F, -3.0F, 20.0F, 12.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0F, -20.0F, -1.0F, 0.0F, -1.5708F, 0.48F));

        PartDefinition cube_r14 = body.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(260, 104).addBox(-10.0F, -11.0F, -5.0F, 20.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -14.0F, -3.0F, 0.0F, -1.5708F, 0.0F));

        PartDefinition cube_r15 = body.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(198, 198).addBox(6.0F, -12.0F, -12.0F, 4.0F, 14.0F, 24.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -10.5F, -0.5F, -1.5708F, -1.3526F, 1.5708F));

        PartDefinition bone = body.addOrReplaceChild("bone", CubeListBuilder.create(), PartPose.offset(0.0F, -32.0F, 0.0F));

        PartDefinition bone10 = bone.addOrReplaceChild("bone10", CubeListBuilder.create().texOffs(200, 40).addBox(-9.5F, -12.5F, -9.0F, 18.0F, 2.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -13.2F, 0.0F));

        PartDefinition cube_r16 = bone10.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(222, 27).addBox(-9.5F, -1.25F, -1.75F, 18.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -9.9F, -10.05F, 0.7854F, 0.0F, 0.0F));

        PartDefinition cube_r17 = bone10.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(222, 33).addBox(1.5F, -1.25F, -1.75F, 10.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, 16.4F, -10.4F, 1.5708F, 0.0F, -1.2217F));

        PartDefinition cube_r18 = bone10.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(172, 48).addBox(-11.5F, -1.25F, -1.75F, 10.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, 16.4F, -10.4F, 1.5708F, 0.0F, 1.2217F));

        PartDefinition cube_r19 = bone10.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(254, 229).addBox(-10.5F, -1.25F, -1.75F, 9.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(11.0F, 10.4F, -10.4F, 1.5708F, 0.0F, 1.2217F));

        PartDefinition cube_r20 = bone10.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(254, 224).addBox(1.5F, -1.25F, -1.75F, 9.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-11.0F, 10.4F, -10.4F, 1.5708F, 0.0F, -1.2217F));

        PartDefinition cube_r21 = bone10.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(248, 33).addBox(1.5F, -1.25F, -1.75F, 9.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-10.0F, -6.6F, -11.4F, 1.5708F, 0.0F, 0.2182F));

        PartDefinition cube_r22 = bone10.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(176, 40).addBox(-10.5F, -1.25F, -1.75F, 9.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(10.0F, -6.6F, -11.4F, 1.5708F, 0.0F, -0.2182F));

        PartDefinition cube_r23 = bone10.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(200, 87).addBox(-9.5F, -1.25F, -1.75F, 18.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.6F, -11.4F, 1.5708F, 0.0F, 0.0F));

        PartDefinition cube_r24 = bone10.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(128, 40).addBox(-9.5F, -1.25F, -3.25F, 18.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.6F, 11.4F, -1.5708F, 0.0F, 0.0F));

        PartDefinition cube_r25 = bone10.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(128, 48).addBox(-9.5F, -1.25F, -1.75F, 18.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -9.9F, 10.05F, -0.7854F, 0.0F, 0.0F));

        PartDefinition bone3 = bone.addOrReplaceChild("bone3", CubeListBuilder.create(), PartPose.offset(5.4F, -22.5F, 0.0F));

        PartDefinition bone4 = bone3.addOrReplaceChild("bone4", CubeListBuilder.create().texOffs(100, 226).addBox(0.85F, 2.0F, -8.5F, 2.0F, 4.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.7854F));

        PartDefinition cube_r26 = bone4.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(278, 224).addBox(-1.25F, 2.0F, -1.75F, 2.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.75F, 0.0F, -8.55F, 0.0F, 0.7854F, 0.0F));

        PartDefinition cube_r27 = bone4.addOrReplaceChild("cube_r27", CubeListBuilder.create().texOffs(136, 226).addBox(-1.25F, 2.0F, -1.25F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.55F, 0.0F, 9.9F, 0.0F, -1.5708F, 0.0F));

        PartDefinition cube_r28 = bone4.addOrReplaceChild("cube_r28", CubeListBuilder.create().texOffs(244, 87).addBox(-1.25F, 2.0F, -1.75F, 2.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.75F, 0.0F, 8.55F, 0.0F, -0.7854F, 0.0F));

        PartDefinition bone8 = bone3.addOrReplaceChild("bone8", CubeListBuilder.create().texOffs(0, 274).addBox(-2.0F, -7.5F, -9.0F, 2.0F, 14.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offset(6.6F, 12.0F, 0.0F));

        PartDefinition cube_r29 = bone8.addOrReplaceChild("cube_r29", CubeListBuilder.create().texOffs(52, 182).addBox(-1.25F, -6.0F, -1.75F, 2.0F, 14.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.1F, -1.5F, -10.05F, 0.0F, 0.7854F, 0.0F));

        PartDefinition cube_r30 = bone8.addOrReplaceChild("cube_r30", CubeListBuilder.create().texOffs(70, 148).addBox(-1.25F, -6.0F, -3.25F, 2.0F, 14.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.4F, -1.5F, 11.4F, 0.0F, -1.5708F, 0.0F));

        PartDefinition cube_r31 = bone8.addOrReplaceChild("cube_r31", CubeListBuilder.create().texOffs(146, 176).addBox(-1.25F, -6.0F, -1.75F, 2.0F, 14.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.1F, -1.5F, 10.05F, 0.0F, -0.7854F, 0.0F));

        PartDefinition bone5 = bone.addOrReplaceChild("bone5", CubeListBuilder.create(), PartPose.offset(-5.4F, -22.5F, 0.0F));

        PartDefinition bone6 = bone5.addOrReplaceChild("bone6", CubeListBuilder.create().texOffs(96, 290).addBox(-3.2293F, -4.0F, -8.4707F, 2.0F, 6.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.5138F, 3.1431F, -0.0293F, 0.0F, 0.0F, 0.3491F));

        PartDefinition cube_r32 = bone6.addOrReplaceChild("cube_r32", CubeListBuilder.create().texOffs(260, 124).addBox(-1.25F, 0.0F, -1.75F, 2.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.6293F, -4.0F, -8.5207F, 0.0F, -0.7854F, 0.0F));

        PartDefinition cube_r33 = bone6.addOrReplaceChild("cube_r33", CubeListBuilder.create().texOffs(158, 176).addBox(-1.25F, 0.0F, -1.25F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.6707F, -4.0F, 9.9293F, 0.0F, 1.5708F, 0.0F));

        PartDefinition cube_r34 = bone6.addOrReplaceChild("cube_r34", CubeListBuilder.create().texOffs(94, 128).addBox(-1.25F, 0.0F, -1.75F, 2.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.6293F, -4.0F, 8.5793F, 0.0F, 0.7854F, 0.0F));

        PartDefinition bone7 = bone5.addOrReplaceChild("bone7", CubeListBuilder.create().texOffs(196, 280).addBox(-0.5F, -7.5F, -9.0F, 2.0F, 14.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offset(-6.6F, 12.0F, 0.0F));

        PartDefinition cube_r35 = bone7.addOrReplaceChild("cube_r35", CubeListBuilder.create().texOffs(132, 290).addBox(-1.25F, -6.0F, -1.75F, 2.0F, 14.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1F, -1.5F, -10.05F, 0.0F, -0.7854F, 0.0F));

        PartDefinition cube_r36 = bone7.addOrReplaceChild("cube_r36", CubeListBuilder.create().texOffs(118, 200).addBox(-1.25F, -6.0F, -3.25F, 2.0F, 14.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.4F, -1.5F, 11.4F, 0.0F, 1.5708F, 0.0F));

        PartDefinition cube_r37 = bone7.addOrReplaceChild("cube_r37", CubeListBuilder.create().texOffs(242, 180).addBox(-1.25F, -6.0F, -1.75F, 2.0F, 14.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1F, -1.5F, 10.05F, 0.0F, 0.7854F, 0.0F));

        PartDefinition bone2 = bone5.addOrReplaceChild("bone2", CubeListBuilder.create().texOffs(290, 124).addBox(1.2293F, -4.0F, -8.4707F, 2.0F, 6.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(14.3138F, 3.1431F, -0.0293F, 0.0F, 0.0F, -0.3491F));

        PartDefinition cube_r38 = bone2.addOrReplaceChild("cube_r38", CubeListBuilder.create().texOffs(272, 124).addBox(-0.75F, 0.0F, -1.75F, 2.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.6293F, -4.0F, -8.5207F, 0.0F, 0.7854F, 0.0F));

        PartDefinition cube_r39 = bone2.addOrReplaceChild("cube_r39", CubeListBuilder.create().texOffs(158, 184).addBox(-0.75F, 0.0F, -1.25F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.6707F, -4.0F, 9.9293F, 0.0F, -1.5708F, 0.0F));

        PartDefinition cube_r40 = bone2.addOrReplaceChild("cube_r40", CubeListBuilder.create().texOffs(272, 50).addBox(-0.75F, 0.0F, -1.75F, 2.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.6293F, -4.0F, 8.5793F, 0.0F, -0.7854F, 0.0F));

        PartDefinition arm = partdefinition.addOrReplaceChild("arm", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition cube_r41 = arm.addOrReplaceChild("cube_r41", CubeListBuilder.create().texOffs(0, 128).addBox(-18.5F, -5.0F, -5.0F, 37.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

        PartDefinition bone28 = arm.addOrReplaceChild("bone28", CubeListBuilder.create(), PartPose.offset(-0.5031F, -6.0604F, 14.0055F));

        PartDefinition bone18 = bone28.addOrReplaceChild("bone18", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition bone9 = bone18.addOrReplaceChild("bone9", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.3927F, 0.0F));

        PartDefinition cube_r42 = bone9.addOrReplaceChild("cube_r42", CubeListBuilder.create().texOffs(158, 192).addBox(-3.0F, 0.0F, -1.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, 0.6354F, 7.6945F, -1.5564F, -1.0911F, 1.5504F));

        PartDefinition cube_r43 = bone9.addOrReplaceChild("cube_r43", CubeListBuilder.create().texOffs(84, 172).addBox(-3.0F, 0.0F, -1.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, -0.9646F, 4.0195F, -1.5708F, -1.3526F, 1.5708F));

        PartDefinition cube_r44 = bone9.addOrReplaceChild("cube_r44", CubeListBuilder.create().texOffs(194, 138).addBox(-3.0F, 0.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, -1.1896F, -1.8555F, 1.5708F, -1.4399F, -1.5708F));

        PartDefinition cube_r45 = bone9.addOrReplaceChild("cube_r45", CubeListBuilder.create().texOffs(94, 138).addBox(-3.0F, 0.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, 0.5604F, -7.5055F, 1.5708F, -1.0908F, -1.5708F));

        PartDefinition bone13 = bone18.addOrReplaceChild("bone13", CubeListBuilder.create(), PartPose.offset(2.5031F, 12.5604F, -7.5055F));

        PartDefinition cube_r46 = bone13.addOrReplaceChild("cube_r46", CubeListBuilder.create().texOffs(246, 38).addBox(-3.0F, 0.0F, -1.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -10.925F, 15.2F, -1.5564F, -1.0911F, 1.5504F));

        PartDefinition cube_r47 = bone13.addOrReplaceChild("cube_r47", CubeListBuilder.create().texOffs(84, 174).addBox(-3.0F, 0.0F, -1.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -12.525F, 11.525F, -1.5708F, -1.3526F, 1.5708F));

        PartDefinition cube_r48 = bone13.addOrReplaceChild("cube_r48", CubeListBuilder.create().texOffs(146, 194).addBox(-3.0F, 0.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -12.75F, 5.65F, 1.5708F, -1.4399F, -1.5708F));

        PartDefinition cube_r49 = bone13.addOrReplaceChild("cube_r49", CubeListBuilder.create().texOffs(142, 54).addBox(-3.0F, 0.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -11.0F, 0.0F, 1.5708F, -1.0908F, -1.5708F));

        PartDefinition bone16 = bone18.addOrReplaceChild("bone16", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, -2.0F, 0.0F, -0.3054F, 0.0F));

        PartDefinition cube_r50 = bone16.addOrReplaceChild("cube_r50", CubeListBuilder.create().texOffs(260, 134).addBox(-3.0F, 0.0F, -1.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, 0.6354F, 7.6945F, -1.5564F, -1.0911F, 1.5504F));

        PartDefinition cube_r51 = bone16.addOrReplaceChild("cube_r51", CubeListBuilder.create().texOffs(136, 244).addBox(-3.0F, 0.0F, -1.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, -0.9646F, 4.0195F, -1.5708F, -1.3526F, 1.5708F));

        PartDefinition cube_r52 = bone16.addOrReplaceChild("cube_r52", CubeListBuilder.create().texOffs(208, 136).addBox(-3.0F, 0.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, -1.1896F, -1.8555F, 1.5708F, -1.4399F, -1.5708F));

        PartDefinition cube_r53 = bone16.addOrReplaceChild("cube_r53", CubeListBuilder.create().texOffs(128, 54).addBox(-3.0F, 0.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, 0.5604F, -7.5055F, 1.5708F, -1.0908F, -1.5708F));

        PartDefinition bone19 = bone28.addOrReplaceChild("bone19", CubeListBuilder.create(), PartPose.offset(2.5031F, 11.5604F, -8.5055F));

        PartDefinition bone14 = bone19.addOrReplaceChild("bone14", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition cube_r54 = bone14.addOrReplaceChild("cube_r54", CubeListBuilder.create().texOffs(254, 38).addBox(-3.0F, -1.0F, -1.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.075F, 15.2F, 1.5564F, -1.0911F, -1.5504F));

        PartDefinition cube_r55 = bone14.addOrReplaceChild("cube_r55", CubeListBuilder.create().texOffs(190, 45).addBox(-3.0F, -1.0F, -1.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.525F, 11.525F, 1.5708F, -1.3526F, -1.5708F));

        PartDefinition cube_r56 = bone14.addOrReplaceChild("cube_r56", CubeListBuilder.create().texOffs(146, 196).addBox(-3.0F, -1.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.75F, 5.65F, -1.5708F, -1.4399F, 1.5708F));

        PartDefinition cube_r57 = bone14.addOrReplaceChild("cube_r57", CubeListBuilder.create().texOffs(156, 54).addBox(-3.0F, -1.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.5708F, -1.0908F, 1.5708F));

        PartDefinition bone15 = bone19.addOrReplaceChild("bone15", CubeListBuilder.create(), PartPose.offset(-1.0F, -0.775F, 2.125F));

        PartDefinition cube_r58 = bone15.addOrReplaceChild("cube_r58", CubeListBuilder.create().texOffs(254, 234).addBox(-3.0F, -1.0F, -1.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, -0.075F, 15.2F, 1.5564F, -1.0911F, -1.5504F));

        PartDefinition cube_r59 = bone15.addOrReplaceChild("cube_r59", CubeListBuilder.create().texOffs(228, 93).addBox(-3.0F, -1.0F, -1.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 1.525F, 11.525F, 1.5708F, -1.3526F, -1.5708F));

        PartDefinition cube_r60 = bone15.addOrReplaceChild("cube_r60", CubeListBuilder.create().texOffs(200, 93).addBox(-3.0F, -1.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 1.75F, 5.65F, -1.5708F, -1.4399F, 1.5708F));

        PartDefinition cube_r61 = bone15.addOrReplaceChild("cube_r61", CubeListBuilder.create().texOffs(170, 54).addBox(-3.0F, -1.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 0.0F, 0.0F, -1.5708F, -1.0908F, 1.5708F));

        PartDefinition bone17 = bone19.addOrReplaceChild("bone17", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.5031F, -0.2396F, 7.5055F, 0.0F, 0.3927F, 0.0F));

        PartDefinition cube_r62 = bone17.addOrReplaceChild("cube_r62", CubeListBuilder.create().texOffs(262, 38).addBox(-3.0F, -1.0F, -1.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, -0.6354F, 7.6945F, 1.5564F, -1.0911F, -1.5504F));

        PartDefinition cube_r63 = bone17.addOrReplaceChild("cube_r63", CubeListBuilder.create().texOffs(136, 232).addBox(-3.0F, -1.0F, -1.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, 0.9646F, 4.0195F, 1.5708F, -1.3526F, -1.5708F));

        PartDefinition cube_r64 = bone17.addOrReplaceChild("cube_r64", CubeListBuilder.create().texOffs(208, 138).addBox(-3.0F, -1.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, 1.1896F, -1.8555F, -1.5708F, -1.4399F, 1.5708F));

        PartDefinition cube_r65 = bone17.addOrReplaceChild("cube_r65", CubeListBuilder.create().texOffs(70, 172).addBox(-3.0F, -1.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, -0.5604F, -7.5055F, -1.5708F, -1.0908F, 1.5708F));

        PartDefinition bone20 = bone28.addOrReplaceChild("bone20", CubeListBuilder.create(), PartPose.offsetAndRotation(-2.1656F, 4.8368F, -4.7435F, 0.0F, 0.0F, -1.5708F));

        PartDefinition bone21 = bone20.addOrReplaceChild("bone21", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.8344F, -4.1868F, 3.1685F, 0.0F, 0.3927F, 0.0F));

        PartDefinition cube_r66 = bone21.addOrReplaceChild("cube_r66", CubeListBuilder.create().texOffs(262, 234).addBox(-3.0F, 0.0F, -1.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, 0.6354F, 7.6945F, -1.5564F, -1.0911F, 1.5504F));

        PartDefinition cube_r67 = bone21.addOrReplaceChild("cube_r67", CubeListBuilder.create().texOffs(136, 234).addBox(-3.0F, 0.0F, -1.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, -0.9646F, 4.0195F, -1.5708F, -1.3526F, 1.5708F));

        PartDefinition cube_r68 = bone21.addOrReplaceChild("cube_r68", CubeListBuilder.create().texOffs(214, 93).addBox(-3.0F, 0.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, -1.1896F, -1.8555F, 1.5708F, -1.4399F, -1.5708F));

        PartDefinition cube_r69 = bone21.addOrReplaceChild("cube_r69", CubeListBuilder.create().texOffs(70, 174).addBox(-3.0F, 0.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, 0.5604F, -7.5055F, 1.5708F, -1.0908F, -1.5708F));

        PartDefinition bone22 = bone20.addOrReplaceChild("bone22", CubeListBuilder.create(), PartPose.offset(1.6687F, 8.3736F, -4.337F));

        PartDefinition cube_r70 = bone22.addOrReplaceChild("cube_r70", CubeListBuilder.create().texOffs(268, 134).addBox(-3.0F, 0.0F, -1.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -10.925F, 15.2F, -1.5564F, -1.0911F, 1.5504F));

        PartDefinition cube_r71 = bone22.addOrReplaceChild("cube_r71", CubeListBuilder.create().texOffs(236, 38).addBox(-3.0F, 0.0F, -1.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -12.525F, 11.525F, -1.5708F, -1.3526F, 1.5708F));

        PartDefinition cube_r72 = bone22.addOrReplaceChild("cube_r72", CubeListBuilder.create().texOffs(222, 38).addBox(-3.0F, 0.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -12.75F, 5.65F, 1.5708F, -1.4399F, -1.5708F));

        PartDefinition cube_r73 = bone22.addOrReplaceChild("cube_r73", CubeListBuilder.create().texOffs(176, 45).addBox(-3.0F, 0.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -11.0F, 0.0F, 1.5708F, -1.0908F, -1.5708F));

        PartDefinition bone23 = bone20.addOrReplaceChild("bone23", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.8344F, -4.1868F, 1.1685F, 0.0F, -0.3054F, 0.0F));

        PartDefinition cube_r74 = bone23.addOrReplaceChild("cube_r74", CubeListBuilder.create().texOffs(270, 234).addBox(-3.0F, 0.0F, -1.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, 0.6354F, 7.6945F, -1.5564F, -1.0911F, 1.5504F));

        PartDefinition cube_r75 = bone23.addOrReplaceChild("cube_r75", CubeListBuilder.create().texOffs(136, 236).addBox(-3.0F, 0.0F, -1.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, -0.9646F, 4.0195F, -1.5708F, -1.3526F, 1.5708F));

        PartDefinition cube_r76 = bone23.addOrReplaceChild("cube_r76", CubeListBuilder.create().texOffs(222, 136).addBox(-3.0F, 0.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, -1.1896F, -1.8555F, 1.5708F, -1.4399F, -1.5708F));

        PartDefinition cube_r77 = bone23.addOrReplaceChild("cube_r77", CubeListBuilder.create().texOffs(180, 136).addBox(-3.0F, 0.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, 0.5604F, -7.5055F, 1.5708F, -1.0908F, -1.5708F));

        PartDefinition bone24 = bone28.addOrReplaceChild("bone24", CubeListBuilder.create(), PartPose.offsetAndRotation(5.5031F, 4.5604F, -8.5055F, 0.0F, 0.0F, -1.5708F));

        PartDefinition bone25 = bone24.addOrReplaceChild("bone25", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition cube_r78 = bone25.addOrReplaceChild("cube_r78", CubeListBuilder.create().texOffs(40, 274).addBox(-3.0F, -1.0F, -1.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.075F, 15.2F, 1.5564F, -1.0911F, -1.5504F));

        PartDefinition cube_r79 = bone25.addOrReplaceChild("cube_r79", CubeListBuilder.create().texOffs(136, 238).addBox(-3.0F, -1.0F, -1.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.525F, 11.525F, 1.5708F, -1.3526F, -1.5708F));

        PartDefinition cube_r80 = bone25.addOrReplaceChild("cube_r80", CubeListBuilder.create().texOffs(222, 138).addBox(-3.0F, -1.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.75F, 5.65F, -1.5708F, -1.4399F, 1.5708F));

        PartDefinition cube_r81 = bone25.addOrReplaceChild("cube_r81", CubeListBuilder.create().texOffs(180, 138).addBox(-3.0F, -1.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.5708F, -1.0908F, 1.5708F));

        PartDefinition bone26 = bone24.addOrReplaceChild("bone26", CubeListBuilder.create(), PartPose.offset(-1.0F, -0.775F, 2.125F));

        PartDefinition cube_r82 = bone26.addOrReplaceChild("cube_r82", CubeListBuilder.create().texOffs(276, 23).addBox(-3.0F, -1.0F, -1.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, -0.075F, 15.2F, 1.5564F, -1.0911F, -1.5504F));

        PartDefinition cube_r83 = bone26.addOrReplaceChild("cube_r83", CubeListBuilder.create().texOffs(136, 240).addBox(-3.0F, -1.0F, -1.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 1.525F, 11.525F, 1.5708F, -1.3526F, -1.5708F));

        PartDefinition cube_r84 = bone26.addOrReplaceChild("cube_r84", CubeListBuilder.create().texOffs(118, 224).addBox(-3.0F, -1.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 1.75F, 5.65F, -1.5708F, -1.4399F, 1.5708F));

        PartDefinition cube_r85 = bone26.addOrReplaceChild("cube_r85", CubeListBuilder.create().texOffs(184, 53).addBox(-3.0F, -1.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 0.0F, 0.0F, -1.5708F, -1.0908F, 1.5708F));

        PartDefinition bone27 = bone24.addOrReplaceChild("bone27", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.5031F, -0.2396F, 7.5055F, 0.0F, 0.3927F, 0.0F));

        PartDefinition cube_r86 = bone27.addOrReplaceChild("cube_r86", CubeListBuilder.create().texOffs(276, 25).addBox(-3.0F, -1.0F, -1.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, -0.6354F, 7.6945F, 1.5564F, -1.0911F, -1.5504F));

        PartDefinition cube_r87 = bone27.addOrReplaceChild("cube_r87", CubeListBuilder.create().texOffs(136, 242).addBox(-3.0F, -1.0F, -1.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, 0.9646F, 4.0195F, 1.5708F, -1.3526F, -1.5708F));

        PartDefinition cube_r88 = bone27.addOrReplaceChild("cube_r88", CubeListBuilder.create().texOffs(132, 224).addBox(-3.0F, -1.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, 1.1896F, -1.8555F, -1.5708F, -1.4399F, 1.5708F));

        PartDefinition cube_r89 = bone27.addOrReplaceChild("cube_r89", CubeListBuilder.create().texOffs(194, 136).addBox(-3.0F, -1.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, -0.5604F, -7.5055F, -1.5708F, -1.0908F, 1.5708F));

        PartDefinition arm2 = partdefinition.addOrReplaceChild("arm2", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition cube_r90 = arm2.addOrReplaceChild("cube_r90", CubeListBuilder.create().texOffs(128, 0).addBox(-18.5F, -5.0F, -5.0F, 37.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

        PartDefinition bone11 = arm2.addOrReplaceChild("bone11", CubeListBuilder.create(), PartPose.offset(-0.5031F, -6.0604F, 14.0055F));

        PartDefinition bone12 = bone11.addOrReplaceChild("bone12", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition bone29 = bone12.addOrReplaceChild("bone29", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.3927F, 0.0F));

        PartDefinition cube_r91 = bone29.addOrReplaceChild("cube_r91", CubeListBuilder.create().texOffs(158, 192).addBox(-3.0F, 0.0F, -1.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, 0.6354F, 7.6945F, -1.5564F, -1.0911F, 1.5504F));

        PartDefinition cube_r92 = bone29.addOrReplaceChild("cube_r92", CubeListBuilder.create().texOffs(84, 172).addBox(-3.0F, 0.0F, -1.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, -0.9646F, 4.0195F, -1.5708F, -1.3526F, 1.5708F));

        PartDefinition cube_r93 = bone29.addOrReplaceChild("cube_r93", CubeListBuilder.create().texOffs(194, 138).addBox(-3.0F, 0.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, -1.1896F, -1.8555F, 1.5708F, -1.4399F, -1.5708F));

        PartDefinition cube_r94 = bone29.addOrReplaceChild("cube_r94", CubeListBuilder.create().texOffs(94, 138).addBox(-3.0F, 0.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, 0.5604F, -7.5055F, 1.5708F, -1.0908F, -1.5708F));

        PartDefinition bone30 = bone12.addOrReplaceChild("bone30", CubeListBuilder.create(), PartPose.offset(2.5031F, 12.5604F, -7.5055F));

        PartDefinition cube_r95 = bone30.addOrReplaceChild("cube_r95", CubeListBuilder.create().texOffs(246, 38).addBox(-3.0F, 0.0F, -1.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -10.925F, 15.2F, -1.5564F, -1.0911F, 1.5504F));

        PartDefinition cube_r96 = bone30.addOrReplaceChild("cube_r96", CubeListBuilder.create().texOffs(84, 174).addBox(-3.0F, 0.0F, -1.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -12.525F, 11.525F, -1.5708F, -1.3526F, 1.5708F));

        PartDefinition cube_r97 = bone30.addOrReplaceChild("cube_r97", CubeListBuilder.create().texOffs(146, 194).addBox(-3.0F, 0.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -12.75F, 5.65F, 1.5708F, -1.4399F, -1.5708F));

        PartDefinition cube_r98 = bone30.addOrReplaceChild("cube_r98", CubeListBuilder.create().texOffs(142, 54).addBox(-3.0F, 0.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -11.0F, 0.0F, 1.5708F, -1.0908F, -1.5708F));

        PartDefinition bone31 = bone12.addOrReplaceChild("bone31", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, -2.0F, 0.0F, -0.3054F, 0.0F));

        PartDefinition cube_r99 = bone31.addOrReplaceChild("cube_r99", CubeListBuilder.create().texOffs(260, 134).addBox(-3.0F, 0.0F, -1.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, 0.6354F, 7.6945F, -1.5564F, -1.0911F, 1.5504F));

        PartDefinition cube_r100 = bone31.addOrReplaceChild("cube_r100", CubeListBuilder.create().texOffs(136, 244).addBox(-3.0F, 0.0F, -1.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, -0.9646F, 4.0195F, -1.5708F, -1.3526F, 1.5708F));

        PartDefinition cube_r101 = bone31.addOrReplaceChild("cube_r101", CubeListBuilder.create().texOffs(208, 136).addBox(-3.0F, 0.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, -1.1896F, -1.8555F, 1.5708F, -1.4399F, -1.5708F));

        PartDefinition cube_r102 = bone31.addOrReplaceChild("cube_r102", CubeListBuilder.create().texOffs(128, 54).addBox(-3.0F, 0.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, 0.5604F, -7.5055F, 1.5708F, -1.0908F, -1.5708F));

        PartDefinition bone32 = bone11.addOrReplaceChild("bone32", CubeListBuilder.create(), PartPose.offset(2.5031F, 11.5604F, -8.5055F));

        PartDefinition bone33 = bone32.addOrReplaceChild("bone33", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition cube_r103 = bone33.addOrReplaceChild("cube_r103", CubeListBuilder.create().texOffs(254, 38).addBox(-3.0F, -1.0F, -1.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.075F, 15.2F, 1.5564F, -1.0911F, -1.5504F));

        PartDefinition cube_r104 = bone33.addOrReplaceChild("cube_r104", CubeListBuilder.create().texOffs(190, 45).addBox(-3.0F, -1.0F, -1.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.525F, 11.525F, 1.5708F, -1.3526F, -1.5708F));

        PartDefinition cube_r105 = bone33.addOrReplaceChild("cube_r105", CubeListBuilder.create().texOffs(146, 196).addBox(-3.0F, -1.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.75F, 5.65F, -1.5708F, -1.4399F, 1.5708F));

        PartDefinition cube_r106 = bone33.addOrReplaceChild("cube_r106", CubeListBuilder.create().texOffs(156, 54).addBox(-3.0F, -1.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.5708F, -1.0908F, 1.5708F));

        PartDefinition bone34 = bone32.addOrReplaceChild("bone34", CubeListBuilder.create(), PartPose.offset(-1.0F, -0.775F, 2.125F));

        PartDefinition cube_r107 = bone34.addOrReplaceChild("cube_r107", CubeListBuilder.create().texOffs(254, 234).addBox(-3.0F, -1.0F, -1.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, -0.075F, 15.2F, 1.5564F, -1.0911F, -1.5504F));

        PartDefinition cube_r108 = bone34.addOrReplaceChild("cube_r108", CubeListBuilder.create().texOffs(228, 93).addBox(-3.0F, -1.0F, -1.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 1.525F, 11.525F, 1.5708F, -1.3526F, -1.5708F));

        PartDefinition cube_r109 = bone34.addOrReplaceChild("cube_r109", CubeListBuilder.create().texOffs(200, 93).addBox(-3.0F, -1.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 1.75F, 5.65F, -1.5708F, -1.4399F, 1.5708F));

        PartDefinition cube_r110 = bone34.addOrReplaceChild("cube_r110", CubeListBuilder.create().texOffs(170, 54).addBox(-3.0F, -1.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 0.0F, 0.0F, -1.5708F, -1.0908F, 1.5708F));

        PartDefinition bone35 = bone32.addOrReplaceChild("bone35", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.5031F, -0.2396F, 7.5055F, 0.0F, 0.3927F, 0.0F));

        PartDefinition cube_r111 = bone35.addOrReplaceChild("cube_r111", CubeListBuilder.create().texOffs(262, 38).addBox(-3.0F, -1.0F, -1.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, -0.6354F, 7.6945F, 1.5564F, -1.0911F, -1.5504F));

        PartDefinition cube_r112 = bone35.addOrReplaceChild("cube_r112", CubeListBuilder.create().texOffs(136, 232).addBox(-3.0F, -1.0F, -1.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, 0.9646F, 4.0195F, 1.5708F, -1.3526F, -1.5708F));

        PartDefinition cube_r113 = bone35.addOrReplaceChild("cube_r113", CubeListBuilder.create().texOffs(208, 138).addBox(-3.0F, -1.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, 1.1896F, -1.8555F, -1.5708F, -1.4399F, 1.5708F));

        PartDefinition cube_r114 = bone35.addOrReplaceChild("cube_r114", CubeListBuilder.create().texOffs(70, 172).addBox(-3.0F, -1.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, -0.5604F, -7.5055F, -1.5708F, -1.0908F, 1.5708F));

        PartDefinition bone36 = bone11.addOrReplaceChild("bone36", CubeListBuilder.create(), PartPose.offsetAndRotation(-2.1656F, 4.8368F, -4.7435F, 0.0F, 0.0F, -1.5708F));

        PartDefinition bone37 = bone36.addOrReplaceChild("bone37", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.8344F, -4.1868F, 3.1685F, 0.0F, 0.3927F, 0.0F));

        PartDefinition cube_r115 = bone37.addOrReplaceChild("cube_r115", CubeListBuilder.create().texOffs(262, 234).addBox(-3.0F, 0.0F, -1.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, 0.6354F, 7.6945F, -1.5564F, -1.0911F, 1.5504F));

        PartDefinition cube_r116 = bone37.addOrReplaceChild("cube_r116", CubeListBuilder.create().texOffs(136, 234).addBox(-3.0F, 0.0F, -1.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, -0.9646F, 4.0195F, -1.5708F, -1.3526F, 1.5708F));

        PartDefinition cube_r117 = bone37.addOrReplaceChild("cube_r117", CubeListBuilder.create().texOffs(214, 93).addBox(-3.0F, 0.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, -1.1896F, -1.8555F, 1.5708F, -1.4399F, -1.5708F));

        PartDefinition cube_r118 = bone37.addOrReplaceChild("cube_r118", CubeListBuilder.create().texOffs(70, 174).addBox(-3.0F, 0.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, 0.5604F, -7.5055F, 1.5708F, -1.0908F, -1.5708F));

        PartDefinition bone38 = bone36.addOrReplaceChild("bone38", CubeListBuilder.create(), PartPose.offset(1.6687F, 8.3736F, -4.337F));

        PartDefinition cube_r119 = bone38.addOrReplaceChild("cube_r119", CubeListBuilder.create().texOffs(268, 134).addBox(-3.0F, 0.0F, -1.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -10.925F, 15.2F, -1.5564F, -1.0911F, 1.5504F));

        PartDefinition cube_r120 = bone38.addOrReplaceChild("cube_r120", CubeListBuilder.create().texOffs(236, 38).addBox(-3.0F, 0.0F, -1.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -12.525F, 11.525F, -1.5708F, -1.3526F, 1.5708F));

        PartDefinition cube_r121 = bone38.addOrReplaceChild("cube_r121", CubeListBuilder.create().texOffs(222, 38).addBox(-3.0F, 0.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -12.75F, 5.65F, 1.5708F, -1.4399F, -1.5708F));

        PartDefinition cube_r122 = bone38.addOrReplaceChild("cube_r122", CubeListBuilder.create().texOffs(176, 45).addBox(-3.0F, 0.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -11.0F, 0.0F, 1.5708F, -1.0908F, -1.5708F));

        PartDefinition bone39 = bone36.addOrReplaceChild("bone39", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.8344F, -4.1868F, 1.1685F, 0.0F, -0.3054F, 0.0F));

        PartDefinition cube_r123 = bone39.addOrReplaceChild("cube_r123", CubeListBuilder.create().texOffs(270, 234).addBox(-3.0F, 0.0F, -1.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, 0.6354F, 7.6945F, -1.5564F, -1.0911F, 1.5504F));

        PartDefinition cube_r124 = bone39.addOrReplaceChild("cube_r124", CubeListBuilder.create().texOffs(136, 236).addBox(-3.0F, 0.0F, -1.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, -0.9646F, 4.0195F, -1.5708F, -1.3526F, 1.5708F));

        PartDefinition cube_r125 = bone39.addOrReplaceChild("cube_r125", CubeListBuilder.create().texOffs(222, 136).addBox(-3.0F, 0.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, -1.1896F, -1.8555F, 1.5708F, -1.4399F, -1.5708F));

        PartDefinition cube_r126 = bone39.addOrReplaceChild("cube_r126", CubeListBuilder.create().texOffs(180, 136).addBox(-3.0F, 0.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, 0.5604F, -7.5055F, 1.5708F, -1.0908F, -1.5708F));

        PartDefinition bone40 = bone11.addOrReplaceChild("bone40", CubeListBuilder.create(), PartPose.offsetAndRotation(5.5031F, 4.5604F, -8.5055F, 0.0F, 0.0F, -1.5708F));

        PartDefinition bone41 = bone40.addOrReplaceChild("bone41", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition cube_r127 = bone41.addOrReplaceChild("cube_r127", CubeListBuilder.create().texOffs(40, 274).addBox(-3.0F, -1.0F, -1.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.075F, 15.2F, 1.5564F, -1.0911F, -1.5504F));

        PartDefinition cube_r128 = bone41.addOrReplaceChild("cube_r128", CubeListBuilder.create().texOffs(136, 238).addBox(-3.0F, -1.0F, -1.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.525F, 11.525F, 1.5708F, -1.3526F, -1.5708F));

        PartDefinition cube_r129 = bone41.addOrReplaceChild("cube_r129", CubeListBuilder.create().texOffs(222, 138).addBox(-3.0F, -1.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.75F, 5.65F, -1.5708F, -1.4399F, 1.5708F));

        PartDefinition cube_r130 = bone41.addOrReplaceChild("cube_r130", CubeListBuilder.create().texOffs(180, 138).addBox(-3.0F, -1.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.5708F, -1.0908F, 1.5708F));

        PartDefinition bone42 = bone40.addOrReplaceChild("bone42", CubeListBuilder.create(), PartPose.offset(-1.0F, -0.775F, 2.125F));

        PartDefinition cube_r131 = bone42.addOrReplaceChild("cube_r131", CubeListBuilder.create().texOffs(276, 23).addBox(-3.0F, -1.0F, -1.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, -0.075F, 15.2F, 1.5564F, -1.0911F, -1.5504F));

        PartDefinition cube_r132 = bone42.addOrReplaceChild("cube_r132", CubeListBuilder.create().texOffs(136, 240).addBox(-3.0F, -1.0F, -1.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 1.525F, 11.525F, 1.5708F, -1.3526F, -1.5708F));

        PartDefinition cube_r133 = bone42.addOrReplaceChild("cube_r133", CubeListBuilder.create().texOffs(118, 224).addBox(-3.0F, -1.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 1.75F, 5.65F, -1.5708F, -1.4399F, 1.5708F));

        PartDefinition cube_r134 = bone42.addOrReplaceChild("cube_r134", CubeListBuilder.create().texOffs(184, 53).addBox(-3.0F, -1.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 0.0F, 0.0F, -1.5708F, -1.0908F, 1.5708F));

        PartDefinition bone43 = bone40.addOrReplaceChild("bone43", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.5031F, -0.2396F, 7.5055F, 0.0F, 0.3927F, 0.0F));

        PartDefinition cube_r135 = bone43.addOrReplaceChild("cube_r135", CubeListBuilder.create().texOffs(276, 25).addBox(-3.0F, -1.0F, -1.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, -0.6354F, 7.6945F, 1.5564F, -1.0911F, -1.5504F));

        PartDefinition cube_r136 = bone43.addOrReplaceChild("cube_r136", CubeListBuilder.create().texOffs(136, 242).addBox(-3.0F, -1.0F, -1.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, 0.9646F, 4.0195F, 1.5708F, -1.3526F, -1.5708F));

        PartDefinition cube_r137 = bone43.addOrReplaceChild("cube_r137", CubeListBuilder.create().texOffs(132, 224).addBox(-3.0F, -1.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, 1.1896F, -1.8555F, -1.5708F, -1.4399F, 1.5708F));

        PartDefinition cube_r138 = bone43.addOrReplaceChild("cube_r138", CubeListBuilder.create().texOffs(194, 136).addBox(-3.0F, -1.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, -0.5604F, -7.5055F, -1.5708F, -1.0908F, 1.5708F));

        PartDefinition arm3 = partdefinition.addOrReplaceChild("arm3", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition cube_r139 = arm3.addOrReplaceChild("cube_r139", CubeListBuilder.create().texOffs(100, 246).addBox(11.5F, -11.0F, -11.0F, 2.0F, 22.0F, 22.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -24.0F, 0.0F, -1.5708F, 0.0F));

        PartDefinition cube_r140 = arm3.addOrReplaceChild("cube_r140", CubeListBuilder.create().texOffs(242, 136).addBox(11.5F, -11.0F, -11.0F, 2.0F, 22.0F, 22.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -18.0F, 0.0F, -1.5708F, 0.0F));

        PartDefinition cube_r141 = arm3.addOrReplaceChild("cube_r141", CubeListBuilder.create().texOffs(198, 236).addBox(11.5F, -11.0F, -11.0F, 2.0F, 22.0F, 22.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -12.0F, 0.0F, -1.5708F, 0.0F));

        PartDefinition cube_r142 = arm3.addOrReplaceChild("cube_r142", CubeListBuilder.create().texOffs(0, 230).addBox(11.5F, -11.0F, -11.0F, 2.0F, 22.0F, 22.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -6.0F, 0.0F, -1.5708F, 0.0F));

        PartDefinition cube_r143 = arm3.addOrReplaceChild("cube_r143", CubeListBuilder.create().texOffs(0, 182).addBox(11.5F, -12.0F, -12.0F, 2.0F, 24.0F, 24.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 5.0F, 0.0F, -1.5708F, 0.0F));

        PartDefinition cube_r144 = arm3.addOrReplaceChild("cube_r144", CubeListBuilder.create().texOffs(52, 226).addBox(11.5F, -11.0F, -11.0F, 2.0F, 22.0F, 22.0F, new CubeDeformation(0.0F))
                .texOffs(1, 56).addBox(-16.5F, -9.0F, -9.0F, 35.0F, 18.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

        PartDefinition arm4 = partdefinition.addOrReplaceChild("arm4", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition cube_r145 = arm4.addOrReplaceChild("cube_r145", CubeListBuilder.create().texOffs(180, 96).addBox(-15.0F, -5.0F, -5.0F, 30.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

        PartDefinition bone44 = arm4.addOrReplaceChild("bone44", CubeListBuilder.create(), PartPose.offset(-0.5031F, -6.0604F, 10.0055F));

        PartDefinition bone45 = bone44.addOrReplaceChild("bone45", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition bone46 = bone45.addOrReplaceChild("bone46", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.3927F, 0.0F));

        PartDefinition cube_r146 = bone46.addOrReplaceChild("cube_r146", CubeListBuilder.create().texOffs(158, 192).addBox(-3.0F, 0.0F, -1.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, 0.6354F, 7.6945F, -1.5564F, -1.0911F, 1.5504F));

        PartDefinition cube_r147 = bone46.addOrReplaceChild("cube_r147", CubeListBuilder.create().texOffs(84, 172).addBox(-3.0F, 0.0F, -1.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, -0.9646F, 4.0195F, -1.5708F, -1.3526F, 1.5708F));

        PartDefinition cube_r148 = bone46.addOrReplaceChild("cube_r148", CubeListBuilder.create().texOffs(194, 138).addBox(-3.0F, 0.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, -1.1896F, -1.8555F, 1.5708F, -1.4399F, -1.5708F));

        PartDefinition cube_r149 = bone46.addOrReplaceChild("cube_r149", CubeListBuilder.create().texOffs(94, 138).addBox(-3.0F, 0.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, 0.5604F, -7.5055F, 1.5708F, -1.0908F, -1.5708F));

        PartDefinition bone47 = bone45.addOrReplaceChild("bone47", CubeListBuilder.create(), PartPose.offset(2.5031F, 12.5604F, -7.5055F));

        PartDefinition cube_r150 = bone47.addOrReplaceChild("cube_r150", CubeListBuilder.create().texOffs(246, 38).addBox(-3.0F, 0.0F, -1.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -10.925F, 15.2F, -1.5564F, -1.0911F, 1.5504F));

        PartDefinition cube_r151 = bone47.addOrReplaceChild("cube_r151", CubeListBuilder.create().texOffs(84, 174).addBox(-3.0F, 0.0F, -1.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -12.525F, 11.525F, -1.5708F, -1.3526F, 1.5708F));

        PartDefinition cube_r152 = bone47.addOrReplaceChild("cube_r152", CubeListBuilder.create().texOffs(146, 194).addBox(-3.0F, 0.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -12.75F, 5.65F, 1.5708F, -1.4399F, -1.5708F));

        PartDefinition cube_r153 = bone47.addOrReplaceChild("cube_r153", CubeListBuilder.create().texOffs(142, 54).addBox(-3.0F, 0.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -11.0F, 0.0F, 1.5708F, -1.0908F, -1.5708F));

        PartDefinition bone48 = bone45.addOrReplaceChild("bone48", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, -2.0F, 0.0F, -0.3054F, 0.0F));

        PartDefinition cube_r154 = bone48.addOrReplaceChild("cube_r154", CubeListBuilder.create().texOffs(260, 134).addBox(-3.0F, 0.0F, -1.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, 0.6354F, 7.6945F, -1.5564F, -1.0911F, 1.5504F));

        PartDefinition cube_r155 = bone48.addOrReplaceChild("cube_r155", CubeListBuilder.create().texOffs(136, 244).addBox(-3.0F, 0.0F, -1.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, -0.9646F, 4.0195F, -1.5708F, -1.3526F, 1.5708F));

        PartDefinition cube_r156 = bone48.addOrReplaceChild("cube_r156", CubeListBuilder.create().texOffs(208, 136).addBox(-3.0F, 0.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, -1.1896F, -1.8555F, 1.5708F, -1.4399F, -1.5708F));

        PartDefinition cube_r157 = bone48.addOrReplaceChild("cube_r157", CubeListBuilder.create().texOffs(128, 54).addBox(-3.0F, 0.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, 0.5604F, -7.5055F, 1.5708F, -1.0908F, -1.5708F));

        PartDefinition bone49 = bone44.addOrReplaceChild("bone49", CubeListBuilder.create(), PartPose.offset(2.5031F, 11.5604F, -8.5055F));

        PartDefinition bone50 = bone49.addOrReplaceChild("bone50", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition cube_r158 = bone50.addOrReplaceChild("cube_r158", CubeListBuilder.create().texOffs(254, 38).addBox(-3.0F, -1.0F, -1.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.075F, 15.2F, 1.5564F, -1.0911F, -1.5504F));

        PartDefinition cube_r159 = bone50.addOrReplaceChild("cube_r159", CubeListBuilder.create().texOffs(190, 45).addBox(-3.0F, -1.0F, -1.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.525F, 11.525F, 1.5708F, -1.3526F, -1.5708F));

        PartDefinition cube_r160 = bone50.addOrReplaceChild("cube_r160", CubeListBuilder.create().texOffs(146, 196).addBox(-3.0F, -1.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.75F, 5.65F, -1.5708F, -1.4399F, 1.5708F));

        PartDefinition cube_r161 = bone50.addOrReplaceChild("cube_r161", CubeListBuilder.create().texOffs(156, 54).addBox(-3.0F, -1.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.5708F, -1.0908F, 1.5708F));

        PartDefinition bone51 = bone49.addOrReplaceChild("bone51", CubeListBuilder.create(), PartPose.offset(-1.0F, -0.775F, 2.125F));

        PartDefinition cube_r162 = bone51.addOrReplaceChild("cube_r162", CubeListBuilder.create().texOffs(254, 234).addBox(-3.0F, -1.0F, -1.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, -0.075F, 15.2F, 1.5564F, -1.0911F, -1.5504F));

        PartDefinition cube_r163 = bone51.addOrReplaceChild("cube_r163", CubeListBuilder.create().texOffs(228, 93).addBox(-3.0F, -1.0F, -1.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 1.525F, 11.525F, 1.5708F, -1.3526F, -1.5708F));

        PartDefinition cube_r164 = bone51.addOrReplaceChild("cube_r164", CubeListBuilder.create().texOffs(200, 93).addBox(-3.0F, -1.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 1.75F, 5.65F, -1.5708F, -1.4399F, 1.5708F));

        PartDefinition cube_r165 = bone51.addOrReplaceChild("cube_r165", CubeListBuilder.create().texOffs(170, 54).addBox(-3.0F, -1.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 0.0F, 0.0F, -1.5708F, -1.0908F, 1.5708F));

        PartDefinition bone52 = bone49.addOrReplaceChild("bone52", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.5031F, -0.2396F, 7.5055F, 0.0F, 0.3927F, 0.0F));

        PartDefinition cube_r166 = bone52.addOrReplaceChild("cube_r166", CubeListBuilder.create().texOffs(262, 38).addBox(-3.0F, -1.0F, -1.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, -0.6354F, 7.6945F, 1.5564F, -1.0911F, -1.5504F));

        PartDefinition cube_r167 = bone52.addOrReplaceChild("cube_r167", CubeListBuilder.create().texOffs(136, 232).addBox(-3.0F, -1.0F, -1.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, 0.9646F, 4.0195F, 1.5708F, -1.3526F, -1.5708F));

        PartDefinition cube_r168 = bone52.addOrReplaceChild("cube_r168", CubeListBuilder.create().texOffs(208, 138).addBox(-3.0F, -1.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, 1.1896F, -1.8555F, -1.5708F, -1.4399F, 1.5708F));

        PartDefinition cube_r169 = bone52.addOrReplaceChild("cube_r169", CubeListBuilder.create().texOffs(70, 172).addBox(-3.0F, -1.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, -0.5604F, -7.5055F, -1.5708F, -1.0908F, 1.5708F));

        PartDefinition bone53 = bone44.addOrReplaceChild("bone53", CubeListBuilder.create(), PartPose.offsetAndRotation(-2.1656F, 4.8368F, -4.7435F, 0.0F, 0.0F, -1.5708F));

        PartDefinition bone54 = bone53.addOrReplaceChild("bone54", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.8344F, -4.1868F, 3.1685F, 0.0F, 0.3927F, 0.0F));

        PartDefinition cube_r170 = bone54.addOrReplaceChild("cube_r170", CubeListBuilder.create().texOffs(262, 234).addBox(-3.0F, 0.0F, -1.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, 0.6354F, 7.6945F, -1.5564F, -1.0911F, 1.5504F));

        PartDefinition cube_r171 = bone54.addOrReplaceChild("cube_r171", CubeListBuilder.create().texOffs(136, 234).addBox(-3.0F, 0.0F, -1.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, -0.9646F, 4.0195F, -1.5708F, -1.3526F, 1.5708F));

        PartDefinition cube_r172 = bone54.addOrReplaceChild("cube_r172", CubeListBuilder.create().texOffs(214, 93).addBox(-3.0F, 0.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, -1.1896F, -1.8555F, 1.5708F, -1.4399F, -1.5708F));

        PartDefinition cube_r173 = bone54.addOrReplaceChild("cube_r173", CubeListBuilder.create().texOffs(70, 174).addBox(-3.0F, 0.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, 0.5604F, -7.5055F, 1.5708F, -1.0908F, -1.5708F));

        PartDefinition bone55 = bone53.addOrReplaceChild("bone55", CubeListBuilder.create(), PartPose.offset(1.6687F, 8.3736F, -4.337F));

        PartDefinition cube_r174 = bone55.addOrReplaceChild("cube_r174", CubeListBuilder.create().texOffs(268, 134).addBox(-3.0F, 0.0F, -1.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -10.925F, 15.2F, -1.5564F, -1.0911F, 1.5504F));

        PartDefinition cube_r175 = bone55.addOrReplaceChild("cube_r175", CubeListBuilder.create().texOffs(236, 38).addBox(-3.0F, 0.0F, -1.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -12.525F, 11.525F, -1.5708F, -1.3526F, 1.5708F));

        PartDefinition cube_r176 = bone55.addOrReplaceChild("cube_r176", CubeListBuilder.create().texOffs(222, 38).addBox(-3.0F, 0.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -12.75F, 5.65F, 1.5708F, -1.4399F, -1.5708F));

        PartDefinition cube_r177 = bone55.addOrReplaceChild("cube_r177", CubeListBuilder.create().texOffs(176, 45).addBox(-3.0F, 0.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -11.0F, 0.0F, 1.5708F, -1.0908F, -1.5708F));

        PartDefinition bone56 = bone53.addOrReplaceChild("bone56", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.8344F, -4.1868F, 1.1685F, 0.0F, -0.3054F, 0.0F));

        PartDefinition cube_r178 = bone56.addOrReplaceChild("cube_r178", CubeListBuilder.create().texOffs(270, 234).addBox(-3.0F, 0.0F, -1.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, 0.6354F, 7.6945F, -1.5564F, -1.0911F, 1.5504F));

        PartDefinition cube_r179 = bone56.addOrReplaceChild("cube_r179", CubeListBuilder.create().texOffs(136, 236).addBox(-3.0F, 0.0F, -1.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, -0.9646F, 4.0195F, -1.5708F, -1.3526F, 1.5708F));

        PartDefinition cube_r180 = bone56.addOrReplaceChild("cube_r180", CubeListBuilder.create().texOffs(222, 136).addBox(-3.0F, 0.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, -1.1896F, -1.8555F, 1.5708F, -1.4399F, -1.5708F));

        PartDefinition cube_r181 = bone56.addOrReplaceChild("cube_r181", CubeListBuilder.create().texOffs(180, 136).addBox(-3.0F, 0.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, 0.5604F, -7.5055F, 1.5708F, -1.0908F, -1.5708F));

        PartDefinition bone57 = bone44.addOrReplaceChild("bone57", CubeListBuilder.create(), PartPose.offsetAndRotation(5.5031F, 4.5604F, -8.5055F, 0.0F, 0.0F, -1.5708F));

        PartDefinition bone58 = bone57.addOrReplaceChild("bone58", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition cube_r182 = bone58.addOrReplaceChild("cube_r182", CubeListBuilder.create().texOffs(40, 274).addBox(-3.0F, -1.0F, -1.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.075F, 15.2F, 1.5564F, -1.0911F, -1.5504F));

        PartDefinition cube_r183 = bone58.addOrReplaceChild("cube_r183", CubeListBuilder.create().texOffs(136, 238).addBox(-3.0F, -1.0F, -1.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.525F, 11.525F, 1.5708F, -1.3526F, -1.5708F));

        PartDefinition cube_r184 = bone58.addOrReplaceChild("cube_r184", CubeListBuilder.create().texOffs(222, 138).addBox(-3.0F, -1.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.75F, 5.65F, -1.5708F, -1.4399F, 1.5708F));

        PartDefinition cube_r185 = bone58.addOrReplaceChild("cube_r185", CubeListBuilder.create().texOffs(180, 138).addBox(-3.0F, -1.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.5708F, -1.0908F, 1.5708F));

        PartDefinition bone59 = bone57.addOrReplaceChild("bone59", CubeListBuilder.create(), PartPose.offset(-1.0F, -0.775F, 2.125F));

        PartDefinition cube_r186 = bone59.addOrReplaceChild("cube_r186", CubeListBuilder.create().texOffs(276, 23).addBox(-3.0F, -1.0F, -1.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, -0.075F, 15.2F, 1.5564F, -1.0911F, -1.5504F));

        PartDefinition cube_r187 = bone59.addOrReplaceChild("cube_r187", CubeListBuilder.create().texOffs(136, 240).addBox(-3.0F, -1.0F, -1.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 1.525F, 11.525F, 1.5708F, -1.3526F, -1.5708F));

        PartDefinition cube_r188 = bone59.addOrReplaceChild("cube_r188", CubeListBuilder.create().texOffs(118, 224).addBox(-3.0F, -1.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 1.75F, 5.65F, -1.5708F, -1.4399F, 1.5708F));

        PartDefinition cube_r189 = bone59.addOrReplaceChild("cube_r189", CubeListBuilder.create().texOffs(184, 53).addBox(-3.0F, -1.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 0.0F, 0.0F, -1.5708F, -1.0908F, 1.5708F));

        PartDefinition bone60 = bone57.addOrReplaceChild("bone60", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.5031F, -0.2396F, 7.5055F, 0.0F, 0.3927F, 0.0F));

        PartDefinition cube_r190 = bone60.addOrReplaceChild("cube_r190", CubeListBuilder.create().texOffs(276, 25).addBox(-3.0F, -1.0F, -1.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, -0.6354F, 7.6945F, 1.5564F, -1.0911F, -1.5504F));

        PartDefinition cube_r191 = bone60.addOrReplaceChild("cube_r191", CubeListBuilder.create().texOffs(136, 242).addBox(-3.0F, -1.0F, -1.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, 0.9646F, 4.0195F, 1.5708F, -1.3526F, -1.5708F));

        PartDefinition cube_r192 = bone60.addOrReplaceChild("cube_r192", CubeListBuilder.create().texOffs(132, 224).addBox(-3.0F, -1.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, 1.1896F, -1.8555F, -1.5708F, -1.4399F, 1.5708F));

        PartDefinition cube_r193 = bone60.addOrReplaceChild("cube_r193", CubeListBuilder.create().texOffs(194, 136).addBox(-3.0F, -1.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, -0.5604F, -7.5055F, -1.5708F, -1.0908F, 1.5708F));

        PartDefinition arm5 = partdefinition.addOrReplaceChild("arm5", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition cube_r194 = arm5.addOrReplaceChild("cube_r194", CubeListBuilder.create().texOffs(180, 116).addBox(-15.0F, -5.0F, -5.0F, 30.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

        PartDefinition bone61 = arm5.addOrReplaceChild("bone61", CubeListBuilder.create(), PartPose.offset(-0.5031F, -6.0604F, 10.0055F));

        PartDefinition bone62 = bone61.addOrReplaceChild("bone62", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition bone63 = bone62.addOrReplaceChild("bone63", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.3927F, 0.0F));

        PartDefinition cube_r195 = bone63.addOrReplaceChild("cube_r195", CubeListBuilder.create().texOffs(158, 192).addBox(-3.0F, 0.0F, -1.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, 0.6354F, 7.6945F, -1.5564F, -1.0911F, 1.5504F));

        PartDefinition cube_r196 = bone63.addOrReplaceChild("cube_r196", CubeListBuilder.create().texOffs(84, 172).addBox(-3.0F, 0.0F, -1.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, -0.9646F, 4.0195F, -1.5708F, -1.3526F, 1.5708F));

        PartDefinition cube_r197 = bone63.addOrReplaceChild("cube_r197", CubeListBuilder.create().texOffs(194, 138).addBox(-3.0F, 0.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, -1.1896F, -1.8555F, 1.5708F, -1.4399F, -1.5708F));

        PartDefinition cube_r198 = bone63.addOrReplaceChild("cube_r198", CubeListBuilder.create().texOffs(94, 138).addBox(-3.0F, 0.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, 0.5604F, -7.5055F, 1.5708F, -1.0908F, -1.5708F));

        PartDefinition bone64 = bone62.addOrReplaceChild("bone64", CubeListBuilder.create(), PartPose.offset(2.5031F, 12.5604F, -7.5055F));

        PartDefinition cube_r199 = bone64.addOrReplaceChild("cube_r199", CubeListBuilder.create().texOffs(246, 38).addBox(-3.0F, 0.0F, -1.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -10.925F, 15.2F, -1.5564F, -1.0911F, 1.5504F));

        PartDefinition cube_r200 = bone64.addOrReplaceChild("cube_r200", CubeListBuilder.create().texOffs(84, 174).addBox(-3.0F, 0.0F, -1.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -12.525F, 11.525F, -1.5708F, -1.3526F, 1.5708F));

        PartDefinition cube_r201 = bone64.addOrReplaceChild("cube_r201", CubeListBuilder.create().texOffs(146, 194).addBox(-3.0F, 0.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -12.75F, 5.65F, 1.5708F, -1.4399F, -1.5708F));

        PartDefinition cube_r202 = bone64.addOrReplaceChild("cube_r202", CubeListBuilder.create().texOffs(142, 54).addBox(-3.0F, 0.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -11.0F, 0.0F, 1.5708F, -1.0908F, -1.5708F));

        PartDefinition bone65 = bone62.addOrReplaceChild("bone65", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, -2.0F, 0.0F, -0.3054F, 0.0F));

        PartDefinition cube_r203 = bone65.addOrReplaceChild("cube_r203", CubeListBuilder.create().texOffs(260, 134).addBox(-3.0F, 0.0F, -1.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, 0.6354F, 7.6945F, -1.5564F, -1.0911F, 1.5504F));

        PartDefinition cube_r204 = bone65.addOrReplaceChild("cube_r204", CubeListBuilder.create().texOffs(136, 244).addBox(-3.0F, 0.0F, -1.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, -0.9646F, 4.0195F, -1.5708F, -1.3526F, 1.5708F));

        PartDefinition cube_r205 = bone65.addOrReplaceChild("cube_r205", CubeListBuilder.create().texOffs(208, 136).addBox(-3.0F, 0.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, -1.1896F, -1.8555F, 1.5708F, -1.4399F, -1.5708F));

        PartDefinition cube_r206 = bone65.addOrReplaceChild("cube_r206", CubeListBuilder.create().texOffs(128, 54).addBox(-3.0F, 0.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, 0.5604F, -7.5055F, 1.5708F, -1.0908F, -1.5708F));

        PartDefinition bone66 = bone61.addOrReplaceChild("bone66", CubeListBuilder.create(), PartPose.offset(2.5031F, 11.5604F, -8.5055F));

        PartDefinition bone67 = bone66.addOrReplaceChild("bone67", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition cube_r207 = bone67.addOrReplaceChild("cube_r207", CubeListBuilder.create().texOffs(254, 38).addBox(-3.0F, -1.0F, -1.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.075F, 15.2F, 1.5564F, -1.0911F, -1.5504F));

        PartDefinition cube_r208 = bone67.addOrReplaceChild("cube_r208", CubeListBuilder.create().texOffs(190, 45).addBox(-3.0F, -1.0F, -1.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.525F, 11.525F, 1.5708F, -1.3526F, -1.5708F));

        PartDefinition cube_r209 = bone67.addOrReplaceChild("cube_r209", CubeListBuilder.create().texOffs(146, 196).addBox(-3.0F, -1.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.75F, 5.65F, -1.5708F, -1.4399F, 1.5708F));

        PartDefinition cube_r210 = bone67.addOrReplaceChild("cube_r210", CubeListBuilder.create().texOffs(156, 54).addBox(-3.0F, -1.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.5708F, -1.0908F, 1.5708F));

        PartDefinition bone68 = bone66.addOrReplaceChild("bone68", CubeListBuilder.create(), PartPose.offset(-1.0F, -0.775F, 2.125F));

        PartDefinition cube_r211 = bone68.addOrReplaceChild("cube_r211", CubeListBuilder.create().texOffs(254, 234).addBox(-3.0F, -1.0F, -1.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, -0.075F, 15.2F, 1.5564F, -1.0911F, -1.5504F));

        PartDefinition cube_r212 = bone68.addOrReplaceChild("cube_r212", CubeListBuilder.create().texOffs(228, 93).addBox(-3.0F, -1.0F, -1.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 1.525F, 11.525F, 1.5708F, -1.3526F, -1.5708F));

        PartDefinition cube_r213 = bone68.addOrReplaceChild("cube_r213", CubeListBuilder.create().texOffs(200, 93).addBox(-3.0F, -1.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 1.75F, 5.65F, -1.5708F, -1.4399F, 1.5708F));

        PartDefinition cube_r214 = bone68.addOrReplaceChild("cube_r214", CubeListBuilder.create().texOffs(170, 54).addBox(-3.0F, -1.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 0.0F, 0.0F, -1.5708F, -1.0908F, 1.5708F));

        PartDefinition bone69 = bone66.addOrReplaceChild("bone69", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.5031F, -0.2396F, 7.5055F, 0.0F, 0.3927F, 0.0F));

        PartDefinition cube_r215 = bone69.addOrReplaceChild("cube_r215", CubeListBuilder.create().texOffs(262, 38).addBox(-3.0F, -1.0F, -1.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, -0.6354F, 7.6945F, 1.5564F, -1.0911F, -1.5504F));

        PartDefinition cube_r216 = bone69.addOrReplaceChild("cube_r216", CubeListBuilder.create().texOffs(136, 232).addBox(-3.0F, -1.0F, -1.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, 0.9646F, 4.0195F, 1.5708F, -1.3526F, -1.5708F));

        PartDefinition cube_r217 = bone69.addOrReplaceChild("cube_r217", CubeListBuilder.create().texOffs(208, 138).addBox(-3.0F, -1.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, 1.1896F, -1.8555F, -1.5708F, -1.4399F, 1.5708F));

        PartDefinition cube_r218 = bone69.addOrReplaceChild("cube_r218", CubeListBuilder.create().texOffs(70, 172).addBox(-3.0F, -1.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, -0.5604F, -7.5055F, -1.5708F, -1.0908F, 1.5708F));

        PartDefinition bone70 = bone61.addOrReplaceChild("bone70", CubeListBuilder.create(), PartPose.offsetAndRotation(-2.1656F, 4.8368F, -4.7435F, 0.0F, 0.0F, -1.5708F));

        PartDefinition bone71 = bone70.addOrReplaceChild("bone71", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.8344F, -4.1868F, 3.1685F, 0.0F, 0.3927F, 0.0F));

        PartDefinition cube_r219 = bone71.addOrReplaceChild("cube_r219", CubeListBuilder.create().texOffs(262, 234).addBox(-3.0F, 0.0F, -1.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, 0.6354F, 7.6945F, -1.5564F, -1.0911F, 1.5504F));

        PartDefinition cube_r220 = bone71.addOrReplaceChild("cube_r220", CubeListBuilder.create().texOffs(136, 234).addBox(-3.0F, 0.0F, -1.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, -0.9646F, 4.0195F, -1.5708F, -1.3526F, 1.5708F));

        PartDefinition cube_r221 = bone71.addOrReplaceChild("cube_r221", CubeListBuilder.create().texOffs(214, 93).addBox(-3.0F, 0.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, -1.1896F, -1.8555F, 1.5708F, -1.4399F, -1.5708F));

        PartDefinition cube_r222 = bone71.addOrReplaceChild("cube_r222", CubeListBuilder.create().texOffs(70, 174).addBox(-3.0F, 0.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, 0.5604F, -7.5055F, 1.5708F, -1.0908F, -1.5708F));

        PartDefinition bone72 = bone70.addOrReplaceChild("bone72", CubeListBuilder.create(), PartPose.offset(1.6687F, 8.3736F, -4.337F));

        PartDefinition cube_r223 = bone72.addOrReplaceChild("cube_r223", CubeListBuilder.create().texOffs(268, 134).addBox(-3.0F, 0.0F, -1.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -10.925F, 15.2F, -1.5564F, -1.0911F, 1.5504F));

        PartDefinition cube_r224 = bone72.addOrReplaceChild("cube_r224", CubeListBuilder.create().texOffs(236, 38).addBox(-3.0F, 0.0F, -1.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -12.525F, 11.525F, -1.5708F, -1.3526F, 1.5708F));

        PartDefinition cube_r225 = bone72.addOrReplaceChild("cube_r225", CubeListBuilder.create().texOffs(222, 38).addBox(-3.0F, 0.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -12.75F, 5.65F, 1.5708F, -1.4399F, -1.5708F));

        PartDefinition cube_r226 = bone72.addOrReplaceChild("cube_r226", CubeListBuilder.create().texOffs(176, 45).addBox(-3.0F, 0.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -11.0F, 0.0F, 1.5708F, -1.0908F, -1.5708F));

        PartDefinition bone73 = bone70.addOrReplaceChild("bone73", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.8344F, -4.1868F, 1.1685F, 0.0F, -0.3054F, 0.0F));

        PartDefinition cube_r227 = bone73.addOrReplaceChild("cube_r227", CubeListBuilder.create().texOffs(270, 234).addBox(-3.0F, 0.0F, -1.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, 0.6354F, 7.6945F, -1.5564F, -1.0911F, 1.5504F));

        PartDefinition cube_r228 = bone73.addOrReplaceChild("cube_r228", CubeListBuilder.create().texOffs(136, 236).addBox(-3.0F, 0.0F, -1.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, -0.9646F, 4.0195F, -1.5708F, -1.3526F, 1.5708F));

        PartDefinition cube_r229 = bone73.addOrReplaceChild("cube_r229", CubeListBuilder.create().texOffs(222, 136).addBox(-3.0F, 0.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, -1.1896F, -1.8555F, 1.5708F, -1.4399F, -1.5708F));

        PartDefinition cube_r230 = bone73.addOrReplaceChild("cube_r230", CubeListBuilder.create().texOffs(180, 136).addBox(-3.0F, 0.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, 0.5604F, -7.5055F, 1.5708F, -1.0908F, -1.5708F));

        PartDefinition bone74 = bone61.addOrReplaceChild("bone74", CubeListBuilder.create(), PartPose.offsetAndRotation(5.5031F, 4.5604F, -8.5055F, 0.0F, 0.0F, -1.5708F));

        PartDefinition bone75 = bone74.addOrReplaceChild("bone75", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition cube_r231 = bone75.addOrReplaceChild("cube_r231", CubeListBuilder.create().texOffs(40, 274).addBox(-3.0F, -1.0F, -1.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.075F, 15.2F, 1.5564F, -1.0911F, -1.5504F));

        PartDefinition cube_r232 = bone75.addOrReplaceChild("cube_r232", CubeListBuilder.create().texOffs(136, 238).addBox(-3.0F, -1.0F, -1.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.525F, 11.525F, 1.5708F, -1.3526F, -1.5708F));

        PartDefinition cube_r233 = bone75.addOrReplaceChild("cube_r233", CubeListBuilder.create().texOffs(222, 138).addBox(-3.0F, -1.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.75F, 5.65F, -1.5708F, -1.4399F, 1.5708F));

        PartDefinition cube_r234 = bone75.addOrReplaceChild("cube_r234", CubeListBuilder.create().texOffs(180, 138).addBox(-3.0F, -1.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.5708F, -1.0908F, 1.5708F));

        PartDefinition bone76 = bone74.addOrReplaceChild("bone76", CubeListBuilder.create(), PartPose.offset(-1.0F, -0.775F, 2.125F));

        PartDefinition cube_r235 = bone76.addOrReplaceChild("cube_r235", CubeListBuilder.create().texOffs(276, 23).addBox(-3.0F, -1.0F, -1.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, -0.075F, 15.2F, 1.5564F, -1.0911F, -1.5504F));

        PartDefinition cube_r236 = bone76.addOrReplaceChild("cube_r236", CubeListBuilder.create().texOffs(136, 240).addBox(-3.0F, -1.0F, -1.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 1.525F, 11.525F, 1.5708F, -1.3526F, -1.5708F));

        PartDefinition cube_r237 = bone76.addOrReplaceChild("cube_r237", CubeListBuilder.create().texOffs(118, 224).addBox(-3.0F, -1.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 1.75F, 5.65F, -1.5708F, -1.4399F, 1.5708F));

        PartDefinition cube_r238 = bone76.addOrReplaceChild("cube_r238", CubeListBuilder.create().texOffs(184, 53).addBox(-3.0F, -1.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 0.0F, 0.0F, -1.5708F, -1.0908F, 1.5708F));

        PartDefinition bone77 = bone74.addOrReplaceChild("bone77", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.5031F, -0.2396F, 7.5055F, 0.0F, 0.3927F, 0.0F));

        PartDefinition cube_r239 = bone77.addOrReplaceChild("cube_r239", CubeListBuilder.create().texOffs(276, 25).addBox(-3.0F, -1.0F, -1.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, -0.6354F, 7.6945F, 1.5564F, -1.0911F, -1.5504F));

        PartDefinition cube_r240 = bone77.addOrReplaceChild("cube_r240", CubeListBuilder.create().texOffs(136, 242).addBox(-3.0F, -1.0F, -1.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, 0.9646F, 4.0195F, 1.5708F, -1.3526F, -1.5708F));

        PartDefinition cube_r241 = bone77.addOrReplaceChild("cube_r241", CubeListBuilder.create().texOffs(132, 224).addBox(-3.0F, -1.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, 1.1896F, -1.8555F, -1.5708F, -1.4399F, 1.5708F));

        PartDefinition cube_r242 = bone77.addOrReplaceChild("cube_r242", CubeListBuilder.create().texOffs(194, 136).addBox(-3.0F, -1.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, -0.5604F, -7.5055F, -1.5708F, -1.0908F, 1.5708F));

        PartDefinition arm6 = partdefinition.addOrReplaceChild("arm6", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition cube_r243 = arm6.addOrReplaceChild("cube_r243", CubeListBuilder.create().texOffs(128, 20).addBox(-18.0F, -5.0F, -5.0F, 37.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

        PartDefinition bone78 = arm6.addOrReplaceChild("bone78", CubeListBuilder.create(), PartPose.offset(-0.5031F, -6.0604F, 15.0055F));

        PartDefinition bone79 = bone78.addOrReplaceChild("bone79", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition bone80 = bone79.addOrReplaceChild("bone80", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.3927F, 0.0F));

        PartDefinition cube_r244 = bone80.addOrReplaceChild("cube_r244", CubeListBuilder.create().texOffs(158, 192).addBox(-3.0F, 0.0F, -1.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, 0.6354F, 7.6945F, -1.5564F, -1.0911F, 1.5504F));

        PartDefinition cube_r245 = bone80.addOrReplaceChild("cube_r245", CubeListBuilder.create().texOffs(84, 172).addBox(-3.0F, 0.0F, -1.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, -0.9646F, 4.0195F, -1.5708F, -1.3526F, 1.5708F));

        PartDefinition cube_r246 = bone80.addOrReplaceChild("cube_r246", CubeListBuilder.create().texOffs(194, 138).addBox(-3.0F, 0.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, -1.1896F, -1.8555F, 1.5708F, -1.4399F, -1.5708F));

        PartDefinition cube_r247 = bone80.addOrReplaceChild("cube_r247", CubeListBuilder.create().texOffs(94, 138).addBox(-3.0F, 0.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, 0.5604F, -7.5055F, 1.5708F, -1.0908F, -1.5708F));

        PartDefinition bone81 = bone79.addOrReplaceChild("bone81", CubeListBuilder.create(), PartPose.offset(2.5031F, 12.5604F, -7.5055F));

        PartDefinition cube_r248 = bone81.addOrReplaceChild("cube_r248", CubeListBuilder.create().texOffs(246, 38).addBox(-3.0F, 0.0F, -1.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -10.925F, 15.2F, -1.5564F, -1.0911F, 1.5504F));

        PartDefinition cube_r249 = bone81.addOrReplaceChild("cube_r249", CubeListBuilder.create().texOffs(84, 174).addBox(-3.0F, 0.0F, -1.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -12.525F, 11.525F, -1.5708F, -1.3526F, 1.5708F));

        PartDefinition cube_r250 = bone81.addOrReplaceChild("cube_r250", CubeListBuilder.create().texOffs(146, 194).addBox(-3.0F, 0.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -12.75F, 5.65F, 1.5708F, -1.4399F, -1.5708F));

        PartDefinition cube_r251 = bone81.addOrReplaceChild("cube_r251", CubeListBuilder.create().texOffs(142, 54).addBox(-3.0F, 0.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -11.0F, 0.0F, 1.5708F, -1.0908F, -1.5708F));

        PartDefinition bone82 = bone79.addOrReplaceChild("bone82", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, -2.0F, 0.0F, -0.3054F, 0.0F));

        PartDefinition cube_r252 = bone82.addOrReplaceChild("cube_r252", CubeListBuilder.create().texOffs(260, 134).addBox(-3.0F, 0.0F, -1.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, 0.6354F, 7.6945F, -1.5564F, -1.0911F, 1.5504F));

        PartDefinition cube_r253 = bone82.addOrReplaceChild("cube_r253", CubeListBuilder.create().texOffs(136, 244).addBox(-3.0F, 0.0F, -1.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, -0.9646F, 4.0195F, -1.5708F, -1.3526F, 1.5708F));

        PartDefinition cube_r254 = bone82.addOrReplaceChild("cube_r254", CubeListBuilder.create().texOffs(208, 136).addBox(-3.0F, 0.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, -1.1896F, -1.8555F, 1.5708F, -1.4399F, -1.5708F));

        PartDefinition cube_r255 = bone82.addOrReplaceChild("cube_r255", CubeListBuilder.create().texOffs(128, 54).addBox(-3.0F, 0.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, 0.5604F, -7.5055F, 1.5708F, -1.0908F, -1.5708F));

        PartDefinition bone83 = bone78.addOrReplaceChild("bone83", CubeListBuilder.create(), PartPose.offset(2.5031F, 11.5604F, -8.5055F));

        PartDefinition bone84 = bone83.addOrReplaceChild("bone84", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition cube_r256 = bone84.addOrReplaceChild("cube_r256", CubeListBuilder.create().texOffs(254, 38).addBox(-3.0F, -1.0F, -1.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.075F, 15.2F, 1.5564F, -1.0911F, -1.5504F));

        PartDefinition cube_r257 = bone84.addOrReplaceChild("cube_r257", CubeListBuilder.create().texOffs(190, 45).addBox(-3.0F, -1.0F, -1.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.525F, 11.525F, 1.5708F, -1.3526F, -1.5708F));

        PartDefinition cube_r258 = bone84.addOrReplaceChild("cube_r258", CubeListBuilder.create().texOffs(146, 196).addBox(-3.0F, -1.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.75F, 5.65F, -1.5708F, -1.4399F, 1.5708F));

        PartDefinition cube_r259 = bone84.addOrReplaceChild("cube_r259", CubeListBuilder.create().texOffs(156, 54).addBox(-3.0F, -1.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.5708F, -1.0908F, 1.5708F));

        PartDefinition bone85 = bone83.addOrReplaceChild("bone85", CubeListBuilder.create(), PartPose.offset(-1.0F, -0.775F, 2.125F));

        PartDefinition cube_r260 = bone85.addOrReplaceChild("cube_r260", CubeListBuilder.create().texOffs(254, 234).addBox(-3.0F, -1.0F, -1.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, -0.075F, 15.2F, 1.5564F, -1.0911F, -1.5504F));

        PartDefinition cube_r261 = bone85.addOrReplaceChild("cube_r261", CubeListBuilder.create().texOffs(228, 93).addBox(-3.0F, -1.0F, -1.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 1.525F, 11.525F, 1.5708F, -1.3526F, -1.5708F));

        PartDefinition cube_r262 = bone85.addOrReplaceChild("cube_r262", CubeListBuilder.create().texOffs(200, 93).addBox(-3.0F, -1.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 1.75F, 5.65F, -1.5708F, -1.4399F, 1.5708F));

        PartDefinition cube_r263 = bone85.addOrReplaceChild("cube_r263", CubeListBuilder.create().texOffs(170, 54).addBox(-3.0F, -1.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 0.0F, 0.0F, -1.5708F, -1.0908F, 1.5708F));

        PartDefinition bone86 = bone83.addOrReplaceChild("bone86", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.5031F, -0.2396F, 7.5055F, 0.0F, 0.3927F, 0.0F));

        PartDefinition cube_r264 = bone86.addOrReplaceChild("cube_r264", CubeListBuilder.create().texOffs(262, 38).addBox(-3.0F, -1.0F, -1.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, -0.6354F, 7.6945F, 1.5564F, -1.0911F, -1.5504F));

        PartDefinition cube_r265 = bone86.addOrReplaceChild("cube_r265", CubeListBuilder.create().texOffs(136, 232).addBox(-3.0F, -1.0F, -1.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, 0.9646F, 4.0195F, 1.5708F, -1.3526F, -1.5708F));

        PartDefinition cube_r266 = bone86.addOrReplaceChild("cube_r266", CubeListBuilder.create().texOffs(208, 138).addBox(-3.0F, -1.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, 1.1896F, -1.8555F, -1.5708F, -1.4399F, 1.5708F));

        PartDefinition cube_r267 = bone86.addOrReplaceChild("cube_r267", CubeListBuilder.create().texOffs(70, 172).addBox(-3.0F, -1.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, -0.5604F, -7.5055F, -1.5708F, -1.0908F, 1.5708F));

        PartDefinition bone87 = bone78.addOrReplaceChild("bone87", CubeListBuilder.create(), PartPose.offsetAndRotation(-2.1656F, 4.8368F, -4.7435F, 0.0F, 0.0F, -1.5708F));

        PartDefinition bone88 = bone87.addOrReplaceChild("bone88", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.8344F, -4.1868F, 3.1685F, 0.0F, 0.3927F, 0.0F));

        PartDefinition cube_r268 = bone88.addOrReplaceChild("cube_r268", CubeListBuilder.create().texOffs(262, 234).addBox(-3.0F, 0.0F, -1.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, 0.6354F, 7.6945F, -1.5564F, -1.0911F, 1.5504F));

        PartDefinition cube_r269 = bone88.addOrReplaceChild("cube_r269", CubeListBuilder.create().texOffs(136, 234).addBox(-3.0F, 0.0F, -1.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, -0.9646F, 4.0195F, -1.5708F, -1.3526F, 1.5708F));

        PartDefinition cube_r270 = bone88.addOrReplaceChild("cube_r270", CubeListBuilder.create().texOffs(214, 93).addBox(-3.0F, 0.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, -1.1896F, -1.8555F, 1.5708F, -1.4399F, -1.5708F));

        PartDefinition cube_r271 = bone88.addOrReplaceChild("cube_r271", CubeListBuilder.create().texOffs(70, 174).addBox(-3.0F, 0.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, 0.5604F, -7.5055F, 1.5708F, -1.0908F, -1.5708F));

        PartDefinition bone89 = bone87.addOrReplaceChild("bone89", CubeListBuilder.create(), PartPose.offset(1.6687F, 8.3736F, -4.337F));

        PartDefinition cube_r272 = bone89.addOrReplaceChild("cube_r272", CubeListBuilder.create().texOffs(268, 134).addBox(-3.0F, 0.0F, -1.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -10.925F, 15.2F, -1.5564F, -1.0911F, 1.5504F));

        PartDefinition cube_r273 = bone89.addOrReplaceChild("cube_r273", CubeListBuilder.create().texOffs(236, 38).addBox(-3.0F, 0.0F, -1.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -12.525F, 11.525F, -1.5708F, -1.3526F, 1.5708F));

        PartDefinition cube_r274 = bone89.addOrReplaceChild("cube_r274", CubeListBuilder.create().texOffs(222, 38).addBox(-3.0F, 0.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -12.75F, 5.65F, 1.5708F, -1.4399F, -1.5708F));

        PartDefinition cube_r275 = bone89.addOrReplaceChild("cube_r275", CubeListBuilder.create().texOffs(176, 45).addBox(-3.0F, 0.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -11.0F, 0.0F, 1.5708F, -1.0908F, -1.5708F));

        PartDefinition bone90 = bone87.addOrReplaceChild("bone90", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.8344F, -4.1868F, 1.1685F, 0.0F, -0.3054F, 0.0F));

        PartDefinition cube_r276 = bone90.addOrReplaceChild("cube_r276", CubeListBuilder.create().texOffs(270, 234).addBox(-3.0F, 0.0F, -1.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, 0.6354F, 7.6945F, -1.5564F, -1.0911F, 1.5504F));

        PartDefinition cube_r277 = bone90.addOrReplaceChild("cube_r277", CubeListBuilder.create().texOffs(136, 236).addBox(-3.0F, 0.0F, -1.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, -0.9646F, 4.0195F, -1.5708F, -1.3526F, 1.5708F));

        PartDefinition cube_r278 = bone90.addOrReplaceChild("cube_r278", CubeListBuilder.create().texOffs(222, 136).addBox(-3.0F, 0.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, -1.1896F, -1.8555F, 1.5708F, -1.4399F, -1.5708F));

        PartDefinition cube_r279 = bone90.addOrReplaceChild("cube_r279", CubeListBuilder.create().texOffs(180, 136).addBox(-3.0F, 0.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, 0.5604F, -7.5055F, 1.5708F, -1.0908F, -1.5708F));

        PartDefinition bone91 = bone78.addOrReplaceChild("bone91", CubeListBuilder.create(), PartPose.offsetAndRotation(5.5031F, 4.5604F, -8.5055F, 0.0F, 0.0F, -1.5708F));

        PartDefinition bone92 = bone91.addOrReplaceChild("bone92", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition cube_r280 = bone92.addOrReplaceChild("cube_r280", CubeListBuilder.create().texOffs(40, 274).addBox(-3.0F, -1.0F, -1.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.075F, 15.2F, 1.5564F, -1.0911F, -1.5504F));

        PartDefinition cube_r281 = bone92.addOrReplaceChild("cube_r281", CubeListBuilder.create().texOffs(136, 238).addBox(-3.0F, -1.0F, -1.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.525F, 11.525F, 1.5708F, -1.3526F, -1.5708F));

        PartDefinition cube_r282 = bone92.addOrReplaceChild("cube_r282", CubeListBuilder.create().texOffs(222, 138).addBox(-3.0F, -1.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.75F, 5.65F, -1.5708F, -1.4399F, 1.5708F));

        PartDefinition cube_r283 = bone92.addOrReplaceChild("cube_r283", CubeListBuilder.create().texOffs(180, 138).addBox(-3.0F, -1.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.5708F, -1.0908F, 1.5708F));

        PartDefinition bone93 = bone91.addOrReplaceChild("bone93", CubeListBuilder.create(), PartPose.offset(-1.0F, -0.775F, 2.125F));

        PartDefinition cube_r284 = bone93.addOrReplaceChild("cube_r284", CubeListBuilder.create().texOffs(276, 23).addBox(-3.0F, -1.0F, -1.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, -0.075F, 15.2F, 1.5564F, -1.0911F, -1.5504F));

        PartDefinition cube_r285 = bone93.addOrReplaceChild("cube_r285", CubeListBuilder.create().texOffs(136, 240).addBox(-3.0F, -1.0F, -1.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 1.525F, 11.525F, 1.5708F, -1.3526F, -1.5708F));

        PartDefinition cube_r286 = bone93.addOrReplaceChild("cube_r286", CubeListBuilder.create().texOffs(118, 224).addBox(-3.0F, -1.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 1.75F, 5.65F, -1.5708F, -1.4399F, 1.5708F));

        PartDefinition cube_r287 = bone93.addOrReplaceChild("cube_r287", CubeListBuilder.create().texOffs(184, 53).addBox(-3.0F, -1.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 0.0F, 0.0F, -1.5708F, -1.0908F, 1.5708F));

        PartDefinition bone94 = bone91.addOrReplaceChild("bone94", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.5031F, -0.2396F, 7.5055F, 0.0F, 0.3927F, 0.0F));

        PartDefinition cube_r288 = bone94.addOrReplaceChild("cube_r288", CubeListBuilder.create().texOffs(276, 25).addBox(-3.0F, -1.0F, -1.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, -0.6354F, 7.6945F, 1.5564F, -1.0911F, -1.5504F));

        PartDefinition cube_r289 = bone94.addOrReplaceChild("cube_r289", CubeListBuilder.create().texOffs(136, 242).addBox(-3.0F, -1.0F, -1.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, 0.9646F, 4.0195F, 1.5708F, -1.3526F, -1.5708F));

        PartDefinition cube_r290 = bone94.addOrReplaceChild("cube_r290", CubeListBuilder.create().texOffs(132, 224).addBox(-3.0F, -1.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, 1.1896F, -1.8555F, -1.5708F, -1.4399F, 1.5708F));

        PartDefinition cube_r291 = bone94.addOrReplaceChild("cube_r291", CubeListBuilder.create().texOffs(194, 136).addBox(-3.0F, -1.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, -0.5604F, -7.5055F, -1.5708F, -1.0908F, 1.5708F));

        PartDefinition arm7 = partdefinition.addOrReplaceChild("arm7", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition cube_r292 = arm7.addOrReplaceChild("cube_r292", CubeListBuilder.create().texOffs(0, 92).addBox(-17.5F, -9.0F, -9.0F, 36.0F, 18.0F, 18.0F, new CubeDeformation(0.0F))
                .texOffs(148, 246).addBox(11.5F, -11.0F, -11.0F, 2.0F, 22.0F, 22.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

        PartDefinition cube_r293 = arm7.addOrReplaceChild("cube_r293", CubeListBuilder.create().texOffs(146, 198).addBox(11.5F, -12.0F, -12.0F, 2.0F, 24.0F, 24.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 5.0F, 0.0F, -1.5708F, 0.0F));

        PartDefinition cube_r294 = arm7.addOrReplaceChild("cube_r294", CubeListBuilder.create().texOffs(246, 236).addBox(11.5F, -11.0F, -11.0F, 2.0F, 22.0F, 22.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -6.0F, 0.0F, -1.5708F, 0.0F));

        PartDefinition cube_r295 = arm7.addOrReplaceChild("cube_r295", CubeListBuilder.create().texOffs(254, 180).addBox(11.5F, -11.0F, -11.0F, 2.0F, 22.0F, 22.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -12.0F, 0.0F, -1.5708F, 0.0F));

        PartDefinition cube_r296 = arm7.addOrReplaceChild("cube_r296", CubeListBuilder.create().texOffs(260, 60).addBox(11.5F, -11.0F, -11.0F, 2.0F, 22.0F, 22.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -18.0F, 0.0F, -1.5708F, 0.0F));

        PartDefinition cube_r297 = arm7.addOrReplaceChild("cube_r297", CubeListBuilder.create().texOffs(48, 270).addBox(11.5F, -11.0F, -11.0F, 2.0F, 22.0F, 22.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -24.0F, 0.0F, -1.5708F, 0.0F));

        PartDefinition arm8 = partdefinition.addOrReplaceChild("arm8", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition cube_r298 = arm8.addOrReplaceChild("cube_r298", CubeListBuilder.create().texOffs(0, 128).addBox(-18.5F, -5.0F, -5.0F, 37.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

        PartDefinition bone95 = arm8.addOrReplaceChild("bone95", CubeListBuilder.create(), PartPose.offset(-0.5031F, -6.0604F, 14.0055F));

        PartDefinition bone96 = bone95.addOrReplaceChild("bone96", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition bone97 = bone96.addOrReplaceChild("bone97", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.3927F, 0.0F));

        PartDefinition cube_r299 = bone97.addOrReplaceChild("cube_r299", CubeListBuilder.create().texOffs(158, 192).addBox(-3.0F, 0.0F, -1.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, 0.6354F, 7.6945F, -1.5564F, -1.0911F, 1.5504F));

        PartDefinition cube_r300 = bone97.addOrReplaceChild("cube_r300", CubeListBuilder.create().texOffs(84, 172).addBox(-3.0F, 0.0F, -1.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, -0.9646F, 4.0195F, -1.5708F, -1.3526F, 1.5708F));

        PartDefinition cube_r301 = bone97.addOrReplaceChild("cube_r301", CubeListBuilder.create().texOffs(194, 138).addBox(-3.0F, 0.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, -1.1896F, -1.8555F, 1.5708F, -1.4399F, -1.5708F));

        PartDefinition cube_r302 = bone97.addOrReplaceChild("cube_r302", CubeListBuilder.create().texOffs(94, 138).addBox(-3.0F, 0.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, 0.5604F, -7.5055F, 1.5708F, -1.0908F, -1.5708F));

        PartDefinition bone98 = bone96.addOrReplaceChild("bone98", CubeListBuilder.create(), PartPose.offset(2.5031F, 12.5604F, -7.5055F));

        PartDefinition cube_r303 = bone98.addOrReplaceChild("cube_r303", CubeListBuilder.create().texOffs(246, 38).addBox(-3.0F, 0.0F, -1.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -10.925F, 15.2F, -1.5564F, -1.0911F, 1.5504F));

        PartDefinition cube_r304 = bone98.addOrReplaceChild("cube_r304", CubeListBuilder.create().texOffs(84, 174).addBox(-3.0F, 0.0F, -1.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -12.525F, 11.525F, -1.5708F, -1.3526F, 1.5708F));

        PartDefinition cube_r305 = bone98.addOrReplaceChild("cube_r305", CubeListBuilder.create().texOffs(146, 194).addBox(-3.0F, 0.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -12.75F, 5.65F, 1.5708F, -1.4399F, -1.5708F));

        PartDefinition cube_r306 = bone98.addOrReplaceChild("cube_r306", CubeListBuilder.create().texOffs(142, 54).addBox(-3.0F, 0.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -11.0F, 0.0F, 1.5708F, -1.0908F, -1.5708F));

        PartDefinition bone99 = bone96.addOrReplaceChild("bone99", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, -2.0F, 0.0F, -0.3054F, 0.0F));

        PartDefinition cube_r307 = bone99.addOrReplaceChild("cube_r307", CubeListBuilder.create().texOffs(260, 134).addBox(-3.0F, 0.0F, -1.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, 0.6354F, 7.6945F, -1.5564F, -1.0911F, 1.5504F));

        PartDefinition cube_r308 = bone99.addOrReplaceChild("cube_r308", CubeListBuilder.create().texOffs(136, 244).addBox(-3.0F, 0.0F, -1.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, -0.9646F, 4.0195F, -1.5708F, -1.3526F, 1.5708F));

        PartDefinition cube_r309 = bone99.addOrReplaceChild("cube_r309", CubeListBuilder.create().texOffs(208, 136).addBox(-3.0F, 0.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, -1.1896F, -1.8555F, 1.5708F, -1.4399F, -1.5708F));

        PartDefinition cube_r310 = bone99.addOrReplaceChild("cube_r310", CubeListBuilder.create().texOffs(128, 54).addBox(-3.0F, 0.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, 0.5604F, -7.5055F, 1.5708F, -1.0908F, -1.5708F));

        PartDefinition bone100 = bone95.addOrReplaceChild("bone100", CubeListBuilder.create(), PartPose.offset(2.5031F, 11.5604F, -8.5055F));

        PartDefinition bone101 = bone100.addOrReplaceChild("bone101", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition cube_r311 = bone101.addOrReplaceChild("cube_r311", CubeListBuilder.create().texOffs(254, 38).addBox(-3.0F, -1.0F, -1.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.075F, 15.2F, 1.5564F, -1.0911F, -1.5504F));

        PartDefinition cube_r312 = bone101.addOrReplaceChild("cube_r312", CubeListBuilder.create().texOffs(190, 45).addBox(-3.0F, -1.0F, -1.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.525F, 11.525F, 1.5708F, -1.3526F, -1.5708F));

        PartDefinition cube_r313 = bone101.addOrReplaceChild("cube_r313", CubeListBuilder.create().texOffs(146, 196).addBox(-3.0F, -1.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.75F, 5.65F, -1.5708F, -1.4399F, 1.5708F));

        PartDefinition cube_r314 = bone101.addOrReplaceChild("cube_r314", CubeListBuilder.create().texOffs(156, 54).addBox(-3.0F, -1.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.5708F, -1.0908F, 1.5708F));

        PartDefinition bone102 = bone100.addOrReplaceChild("bone102", CubeListBuilder.create(), PartPose.offset(-1.0F, -0.775F, 2.125F));

        PartDefinition cube_r315 = bone102.addOrReplaceChild("cube_r315", CubeListBuilder.create().texOffs(254, 234).addBox(-3.0F, -1.0F, -1.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, -0.075F, 15.2F, 1.5564F, -1.0911F, -1.5504F));

        PartDefinition cube_r316 = bone102.addOrReplaceChild("cube_r316", CubeListBuilder.create().texOffs(228, 93).addBox(-3.0F, -1.0F, -1.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 1.525F, 11.525F, 1.5708F, -1.3526F, -1.5708F));

        PartDefinition cube_r317 = bone102.addOrReplaceChild("cube_r317", CubeListBuilder.create().texOffs(200, 93).addBox(-3.0F, -1.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 1.75F, 5.65F, -1.5708F, -1.4399F, 1.5708F));

        PartDefinition cube_r318 = bone102.addOrReplaceChild("cube_r318", CubeListBuilder.create().texOffs(170, 54).addBox(-3.0F, -1.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 0.0F, 0.0F, -1.5708F, -1.0908F, 1.5708F));

        PartDefinition bone103 = bone100.addOrReplaceChild("bone103", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.5031F, -0.2396F, 7.5055F, 0.0F, 0.3927F, 0.0F));

        PartDefinition cube_r319 = bone103.addOrReplaceChild("cube_r319", CubeListBuilder.create().texOffs(262, 38).addBox(-3.0F, -1.0F, -1.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, -0.6354F, 7.6945F, 1.5564F, -1.0911F, -1.5504F));

        PartDefinition cube_r320 = bone103.addOrReplaceChild("cube_r320", CubeListBuilder.create().texOffs(136, 232).addBox(-3.0F, -1.0F, -1.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, 0.9646F, 4.0195F, 1.5708F, -1.3526F, -1.5708F));

        PartDefinition cube_r321 = bone103.addOrReplaceChild("cube_r321", CubeListBuilder.create().texOffs(208, 138).addBox(-3.0F, -1.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, 1.1896F, -1.8555F, -1.5708F, -1.4399F, 1.5708F));

        PartDefinition cube_r322 = bone103.addOrReplaceChild("cube_r322", CubeListBuilder.create().texOffs(70, 172).addBox(-3.0F, -1.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, -0.5604F, -7.5055F, -1.5708F, -1.0908F, 1.5708F));

        PartDefinition bone104 = bone95.addOrReplaceChild("bone104", CubeListBuilder.create(), PartPose.offsetAndRotation(-2.1656F, 4.8368F, -4.7435F, 0.0F, 0.0F, -1.5708F));

        PartDefinition bone105 = bone104.addOrReplaceChild("bone105", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.8344F, -4.1868F, 3.1685F, 0.0F, 0.3927F, 0.0F));

        PartDefinition cube_r323 = bone105.addOrReplaceChild("cube_r323", CubeListBuilder.create().texOffs(262, 234).addBox(-3.0F, 0.0F, -1.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, 0.6354F, 7.6945F, -1.5564F, -1.0911F, 1.5504F));

        PartDefinition cube_r324 = bone105.addOrReplaceChild("cube_r324", CubeListBuilder.create().texOffs(136, 234).addBox(-3.0F, 0.0F, -1.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, -0.9646F, 4.0195F, -1.5708F, -1.3526F, 1.5708F));

        PartDefinition cube_r325 = bone105.addOrReplaceChild("cube_r325", CubeListBuilder.create().texOffs(214, 93).addBox(-3.0F, 0.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, -1.1896F, -1.8555F, 1.5708F, -1.4399F, -1.5708F));

        PartDefinition cube_r326 = bone105.addOrReplaceChild("cube_r326", CubeListBuilder.create().texOffs(70, 174).addBox(-3.0F, 0.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, 0.5604F, -7.5055F, 1.5708F, -1.0908F, -1.5708F));

        PartDefinition bone106 = bone104.addOrReplaceChild("bone106", CubeListBuilder.create(), PartPose.offset(1.6687F, 8.3736F, -4.337F));

        PartDefinition cube_r327 = bone106.addOrReplaceChild("cube_r327", CubeListBuilder.create().texOffs(268, 134).addBox(-3.0F, 0.0F, -1.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -10.925F, 15.2F, -1.5564F, -1.0911F, 1.5504F));

        PartDefinition cube_r328 = bone106.addOrReplaceChild("cube_r328", CubeListBuilder.create().texOffs(236, 38).addBox(-3.0F, 0.0F, -1.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -12.525F, 11.525F, -1.5708F, -1.3526F, 1.5708F));

        PartDefinition cube_r329 = bone106.addOrReplaceChild("cube_r329", CubeListBuilder.create().texOffs(222, 38).addBox(-3.0F, 0.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -12.75F, 5.65F, 1.5708F, -1.4399F, -1.5708F));

        PartDefinition cube_r330 = bone106.addOrReplaceChild("cube_r330", CubeListBuilder.create().texOffs(176, 45).addBox(-3.0F, 0.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -11.0F, 0.0F, 1.5708F, -1.0908F, -1.5708F));

        PartDefinition bone107 = bone104.addOrReplaceChild("bone107", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.8344F, -4.1868F, 1.1685F, 0.0F, -0.3054F, 0.0F));

        PartDefinition cube_r331 = bone107.addOrReplaceChild("cube_r331", CubeListBuilder.create().texOffs(270, 234).addBox(-3.0F, 0.0F, -1.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, 0.6354F, 7.6945F, -1.5564F, -1.0911F, 1.5504F));

        PartDefinition cube_r332 = bone107.addOrReplaceChild("cube_r332", CubeListBuilder.create().texOffs(136, 236).addBox(-3.0F, 0.0F, -1.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, -0.9646F, 4.0195F, -1.5708F, -1.3526F, 1.5708F));

        PartDefinition cube_r333 = bone107.addOrReplaceChild("cube_r333", CubeListBuilder.create().texOffs(222, 136).addBox(-3.0F, 0.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, -1.1896F, -1.8555F, 1.5708F, -1.4399F, -1.5708F));

        PartDefinition cube_r334 = bone107.addOrReplaceChild("cube_r334", CubeListBuilder.create().texOffs(180, 136).addBox(-3.0F, 0.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, 0.5604F, -7.5055F, 1.5708F, -1.0908F, -1.5708F));

        PartDefinition bone108 = bone95.addOrReplaceChild("bone108", CubeListBuilder.create(), PartPose.offsetAndRotation(5.5031F, 4.5604F, -8.5055F, 0.0F, 0.0F, -1.5708F));

        PartDefinition bone109 = bone108.addOrReplaceChild("bone109", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition cube_r335 = bone109.addOrReplaceChild("cube_r335", CubeListBuilder.create().texOffs(40, 274).addBox(-3.0F, -1.0F, -1.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.075F, 15.2F, 1.5564F, -1.0911F, -1.5504F));

        PartDefinition cube_r336 = bone109.addOrReplaceChild("cube_r336", CubeListBuilder.create().texOffs(136, 238).addBox(-3.0F, -1.0F, -1.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.525F, 11.525F, 1.5708F, -1.3526F, -1.5708F));

        PartDefinition cube_r337 = bone109.addOrReplaceChild("cube_r337", CubeListBuilder.create().texOffs(222, 138).addBox(-3.0F, -1.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.75F, 5.65F, -1.5708F, -1.4399F, 1.5708F));

        PartDefinition cube_r338 = bone109.addOrReplaceChild("cube_r338", CubeListBuilder.create().texOffs(180, 138).addBox(-3.0F, -1.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.5708F, -1.0908F, 1.5708F));

        PartDefinition bone110 = bone108.addOrReplaceChild("bone110", CubeListBuilder.create(), PartPose.offset(-1.0F, -0.775F, 2.125F));

        PartDefinition cube_r339 = bone110.addOrReplaceChild("cube_r339", CubeListBuilder.create().texOffs(276, 23).addBox(-3.0F, -1.0F, -1.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, -0.075F, 15.2F, 1.5564F, -1.0911F, -1.5504F));

        PartDefinition cube_r340 = bone110.addOrReplaceChild("cube_r340", CubeListBuilder.create().texOffs(136, 240).addBox(-3.0F, -1.0F, -1.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 1.525F, 11.525F, 1.5708F, -1.3526F, -1.5708F));

        PartDefinition cube_r341 = bone110.addOrReplaceChild("cube_r341", CubeListBuilder.create().texOffs(118, 224).addBox(-3.0F, -1.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 1.75F, 5.65F, -1.5708F, -1.4399F, 1.5708F));

        PartDefinition cube_r342 = bone110.addOrReplaceChild("cube_r342", CubeListBuilder.create().texOffs(184, 53).addBox(-3.0F, -1.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 0.0F, 0.0F, -1.5708F, -1.0908F, 1.5708F));

        PartDefinition bone111 = bone108.addOrReplaceChild("bone111", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.5031F, -0.2396F, 7.5055F, 0.0F, 0.3927F, 0.0F));

        PartDefinition cube_r343 = bone111.addOrReplaceChild("cube_r343", CubeListBuilder.create().texOffs(276, 25).addBox(-3.0F, -1.0F, -1.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, -0.6354F, 7.6945F, 1.5564F, -1.0911F, -1.5504F));

        PartDefinition cube_r344 = bone111.addOrReplaceChild("cube_r344", CubeListBuilder.create().texOffs(136, 242).addBox(-3.0F, -1.0F, -1.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, 0.9646F, 4.0195F, 1.5708F, -1.3526F, -1.5708F));

        PartDefinition cube_r345 = bone111.addOrReplaceChild("cube_r345", CubeListBuilder.create().texOffs(132, 224).addBox(-3.0F, -1.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, 1.1896F, -1.8555F, -1.5708F, -1.4399F, 1.5708F));

        PartDefinition cube_r346 = bone111.addOrReplaceChild("cube_r346", CubeListBuilder.create().texOffs(194, 136).addBox(-3.0F, -1.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, -0.5604F, -7.5055F, -1.5708F, -1.0908F, 1.5708F));

        PartDefinition arm9 = partdefinition.addOrReplaceChild("arm9", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition cube_r347 = arm9.addOrReplaceChild("cube_r347", CubeListBuilder.create().texOffs(128, 0).addBox(-18.5F, -5.0F, -5.0F, 37.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

        PartDefinition bone112 = arm9.addOrReplaceChild("bone112", CubeListBuilder.create(), PartPose.offset(-0.5031F, -6.0604F, 14.0055F));

        PartDefinition bone113 = bone112.addOrReplaceChild("bone113", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition bone114 = bone113.addOrReplaceChild("bone114", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.3927F, 0.0F));

        PartDefinition cube_r348 = bone114.addOrReplaceChild("cube_r348", CubeListBuilder.create().texOffs(158, 192).addBox(-3.0F, 0.0F, -1.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, 0.6354F, 7.6945F, -1.5564F, -1.0911F, 1.5504F));

        PartDefinition cube_r349 = bone114.addOrReplaceChild("cube_r349", CubeListBuilder.create().texOffs(84, 172).addBox(-3.0F, 0.0F, -1.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, -0.9646F, 4.0195F, -1.5708F, -1.3526F, 1.5708F));

        PartDefinition cube_r350 = bone114.addOrReplaceChild("cube_r350", CubeListBuilder.create().texOffs(194, 138).addBox(-3.0F, 0.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, -1.1896F, -1.8555F, 1.5708F, -1.4399F, -1.5708F));

        PartDefinition cube_r351 = bone114.addOrReplaceChild("cube_r351", CubeListBuilder.create().texOffs(94, 138).addBox(-3.0F, 0.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, 0.5604F, -7.5055F, 1.5708F, -1.0908F, -1.5708F));

        PartDefinition bone115 = bone113.addOrReplaceChild("bone115", CubeListBuilder.create(), PartPose.offset(2.5031F, 12.5604F, -7.5055F));

        PartDefinition cube_r352 = bone115.addOrReplaceChild("cube_r352", CubeListBuilder.create().texOffs(246, 38).addBox(-3.0F, 0.0F, -1.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -10.925F, 15.2F, -1.5564F, -1.0911F, 1.5504F));

        PartDefinition cube_r353 = bone115.addOrReplaceChild("cube_r353", CubeListBuilder.create().texOffs(84, 174).addBox(-3.0F, 0.0F, -1.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -12.525F, 11.525F, -1.5708F, -1.3526F, 1.5708F));

        PartDefinition cube_r354 = bone115.addOrReplaceChild("cube_r354", CubeListBuilder.create().texOffs(146, 194).addBox(-3.0F, 0.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -12.75F, 5.65F, 1.5708F, -1.4399F, -1.5708F));

        PartDefinition cube_r355 = bone115.addOrReplaceChild("cube_r355", CubeListBuilder.create().texOffs(142, 54).addBox(-3.0F, 0.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -11.0F, 0.0F, 1.5708F, -1.0908F, -1.5708F));

        PartDefinition bone116 = bone113.addOrReplaceChild("bone116", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, -2.0F, 0.0F, -0.3054F, 0.0F));

        PartDefinition cube_r356 = bone116.addOrReplaceChild("cube_r356", CubeListBuilder.create().texOffs(260, 134).addBox(-3.0F, 0.0F, -1.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, 0.6354F, 7.6945F, -1.5564F, -1.0911F, 1.5504F));

        PartDefinition cube_r357 = bone116.addOrReplaceChild("cube_r357", CubeListBuilder.create().texOffs(136, 244).addBox(-3.0F, 0.0F, -1.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, -0.9646F, 4.0195F, -1.5708F, -1.3526F, 1.5708F));

        PartDefinition cube_r358 = bone116.addOrReplaceChild("cube_r358", CubeListBuilder.create().texOffs(208, 136).addBox(-3.0F, 0.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, -1.1896F, -1.8555F, 1.5708F, -1.4399F, -1.5708F));

        PartDefinition cube_r359 = bone116.addOrReplaceChild("cube_r359", CubeListBuilder.create().texOffs(128, 54).addBox(-3.0F, 0.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, 0.5604F, -7.5055F, 1.5708F, -1.0908F, -1.5708F));

        PartDefinition bone117 = bone112.addOrReplaceChild("bone117", CubeListBuilder.create(), PartPose.offset(2.5031F, 11.5604F, -8.5055F));

        PartDefinition bone118 = bone117.addOrReplaceChild("bone118", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition cube_r360 = bone118.addOrReplaceChild("cube_r360", CubeListBuilder.create().texOffs(254, 38).addBox(-3.0F, -1.0F, -1.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.075F, 15.2F, 1.5564F, -1.0911F, -1.5504F));

        PartDefinition cube_r361 = bone118.addOrReplaceChild("cube_r361", CubeListBuilder.create().texOffs(190, 45).addBox(-3.0F, -1.0F, -1.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.525F, 11.525F, 1.5708F, -1.3526F, -1.5708F));

        PartDefinition cube_r362 = bone118.addOrReplaceChild("cube_r362", CubeListBuilder.create().texOffs(146, 196).addBox(-3.0F, -1.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.75F, 5.65F, -1.5708F, -1.4399F, 1.5708F));

        PartDefinition cube_r363 = bone118.addOrReplaceChild("cube_r363", CubeListBuilder.create().texOffs(156, 54).addBox(-3.0F, -1.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.5708F, -1.0908F, 1.5708F));

        PartDefinition bone119 = bone117.addOrReplaceChild("bone119", CubeListBuilder.create(), PartPose.offset(-1.0F, -0.775F, 2.125F));

        PartDefinition cube_r364 = bone119.addOrReplaceChild("cube_r364", CubeListBuilder.create().texOffs(254, 234).addBox(-3.0F, -1.0F, -1.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, -0.075F, 15.2F, 1.5564F, -1.0911F, -1.5504F));

        PartDefinition cube_r365 = bone119.addOrReplaceChild("cube_r365", CubeListBuilder.create().texOffs(228, 93).addBox(-3.0F, -1.0F, -1.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 1.525F, 11.525F, 1.5708F, -1.3526F, -1.5708F));

        PartDefinition cube_r366 = bone119.addOrReplaceChild("cube_r366", CubeListBuilder.create().texOffs(200, 93).addBox(-3.0F, -1.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 1.75F, 5.65F, -1.5708F, -1.4399F, 1.5708F));

        PartDefinition cube_r367 = bone119.addOrReplaceChild("cube_r367", CubeListBuilder.create().texOffs(170, 54).addBox(-3.0F, -1.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 0.0F, 0.0F, -1.5708F, -1.0908F, 1.5708F));

        PartDefinition bone120 = bone117.addOrReplaceChild("bone120", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.5031F, -0.2396F, 7.5055F, 0.0F, 0.3927F, 0.0F));

        PartDefinition cube_r368 = bone120.addOrReplaceChild("cube_r368", CubeListBuilder.create().texOffs(262, 38).addBox(-3.0F, -1.0F, -1.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, -0.6354F, 7.6945F, 1.5564F, -1.0911F, -1.5504F));

        PartDefinition cube_r369 = bone120.addOrReplaceChild("cube_r369", CubeListBuilder.create().texOffs(136, 232).addBox(-3.0F, -1.0F, -1.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, 0.9646F, 4.0195F, 1.5708F, -1.3526F, -1.5708F));

        PartDefinition cube_r370 = bone120.addOrReplaceChild("cube_r370", CubeListBuilder.create().texOffs(208, 138).addBox(-3.0F, -1.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, 1.1896F, -1.8555F, -1.5708F, -1.4399F, 1.5708F));

        PartDefinition cube_r371 = bone120.addOrReplaceChild("cube_r371", CubeListBuilder.create().texOffs(70, 172).addBox(-3.0F, -1.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, -0.5604F, -7.5055F, -1.5708F, -1.0908F, 1.5708F));

        PartDefinition bone121 = bone112.addOrReplaceChild("bone121", CubeListBuilder.create(), PartPose.offsetAndRotation(-2.1656F, 4.8368F, -4.7435F, 0.0F, 0.0F, -1.5708F));

        PartDefinition bone122 = bone121.addOrReplaceChild("bone122", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.8344F, -4.1868F, 3.1685F, 0.0F, 0.3927F, 0.0F));

        PartDefinition cube_r372 = bone122.addOrReplaceChild("cube_r372", CubeListBuilder.create().texOffs(262, 234).addBox(-3.0F, 0.0F, -1.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, 0.6354F, 7.6945F, -1.5564F, -1.0911F, 1.5504F));

        PartDefinition cube_r373 = bone122.addOrReplaceChild("cube_r373", CubeListBuilder.create().texOffs(136, 234).addBox(-3.0F, 0.0F, -1.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, -0.9646F, 4.0195F, -1.5708F, -1.3526F, 1.5708F));

        PartDefinition cube_r374 = bone122.addOrReplaceChild("cube_r374", CubeListBuilder.create().texOffs(214, 93).addBox(-3.0F, 0.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, -1.1896F, -1.8555F, 1.5708F, -1.4399F, -1.5708F));

        PartDefinition cube_r375 = bone122.addOrReplaceChild("cube_r375", CubeListBuilder.create().texOffs(70, 174).addBox(-3.0F, 0.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, 0.5604F, -7.5055F, 1.5708F, -1.0908F, -1.5708F));

        PartDefinition bone123 = bone121.addOrReplaceChild("bone123", CubeListBuilder.create(), PartPose.offset(1.6687F, 8.3736F, -4.337F));

        PartDefinition cube_r376 = bone123.addOrReplaceChild("cube_r376", CubeListBuilder.create().texOffs(268, 134).addBox(-3.0F, 0.0F, -1.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -10.925F, 15.2F, -1.5564F, -1.0911F, 1.5504F));

        PartDefinition cube_r377 = bone123.addOrReplaceChild("cube_r377", CubeListBuilder.create().texOffs(236, 38).addBox(-3.0F, 0.0F, -1.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -12.525F, 11.525F, -1.5708F, -1.3526F, 1.5708F));

        PartDefinition cube_r378 = bone123.addOrReplaceChild("cube_r378", CubeListBuilder.create().texOffs(222, 38).addBox(-3.0F, 0.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -12.75F, 5.65F, 1.5708F, -1.4399F, -1.5708F));

        PartDefinition cube_r379 = bone123.addOrReplaceChild("cube_r379", CubeListBuilder.create().texOffs(176, 45).addBox(-3.0F, 0.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -11.0F, 0.0F, 1.5708F, -1.0908F, -1.5708F));

        PartDefinition bone124 = bone121.addOrReplaceChild("bone124", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.8344F, -4.1868F, 1.1685F, 0.0F, -0.3054F, 0.0F));

        PartDefinition cube_r380 = bone124.addOrReplaceChild("cube_r380", CubeListBuilder.create().texOffs(270, 234).addBox(-3.0F, 0.0F, -1.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, 0.6354F, 7.6945F, -1.5564F, -1.0911F, 1.5504F));

        PartDefinition cube_r381 = bone124.addOrReplaceChild("cube_r381", CubeListBuilder.create().texOffs(136, 236).addBox(-3.0F, 0.0F, -1.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, -0.9646F, 4.0195F, -1.5708F, -1.3526F, 1.5708F));

        PartDefinition cube_r382 = bone124.addOrReplaceChild("cube_r382", CubeListBuilder.create().texOffs(222, 136).addBox(-3.0F, 0.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, -1.1896F, -1.8555F, 1.5708F, -1.4399F, -1.5708F));

        PartDefinition cube_r383 = bone124.addOrReplaceChild("cube_r383", CubeListBuilder.create().texOffs(180, 136).addBox(-3.0F, 0.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, 0.5604F, -7.5055F, 1.5708F, -1.0908F, -1.5708F));

        PartDefinition bone125 = bone112.addOrReplaceChild("bone125", CubeListBuilder.create(), PartPose.offsetAndRotation(5.5031F, 4.5604F, -8.5055F, 0.0F, 0.0F, -1.5708F));

        PartDefinition bone126 = bone125.addOrReplaceChild("bone126", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition cube_r384 = bone126.addOrReplaceChild("cube_r384", CubeListBuilder.create().texOffs(40, 274).addBox(-3.0F, -1.0F, -1.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.075F, 15.2F, 1.5564F, -1.0911F, -1.5504F));

        PartDefinition cube_r385 = bone126.addOrReplaceChild("cube_r385", CubeListBuilder.create().texOffs(136, 238).addBox(-3.0F, -1.0F, -1.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.525F, 11.525F, 1.5708F, -1.3526F, -1.5708F));

        PartDefinition cube_r386 = bone126.addOrReplaceChild("cube_r386", CubeListBuilder.create().texOffs(222, 138).addBox(-3.0F, -1.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.75F, 5.65F, -1.5708F, -1.4399F, 1.5708F));

        PartDefinition cube_r387 = bone126.addOrReplaceChild("cube_r387", CubeListBuilder.create().texOffs(180, 138).addBox(-3.0F, -1.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.5708F, -1.0908F, 1.5708F));

        PartDefinition bone127 = bone125.addOrReplaceChild("bone127", CubeListBuilder.create(), PartPose.offset(-1.0F, -0.775F, 2.125F));

        PartDefinition cube_r388 = bone127.addOrReplaceChild("cube_r388", CubeListBuilder.create().texOffs(276, 23).addBox(-3.0F, -1.0F, -1.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, -0.075F, 15.2F, 1.5564F, -1.0911F, -1.5504F));

        PartDefinition cube_r389 = bone127.addOrReplaceChild("cube_r389", CubeListBuilder.create().texOffs(136, 240).addBox(-3.0F, -1.0F, -1.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 1.525F, 11.525F, 1.5708F, -1.3526F, -1.5708F));

        PartDefinition cube_r390 = bone127.addOrReplaceChild("cube_r390", CubeListBuilder.create().texOffs(118, 224).addBox(-3.0F, -1.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 1.75F, 5.65F, -1.5708F, -1.4399F, 1.5708F));

        PartDefinition cube_r391 = bone127.addOrReplaceChild("cube_r391", CubeListBuilder.create().texOffs(184, 53).addBox(-3.0F, -1.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 0.0F, 0.0F, -1.5708F, -1.0908F, 1.5708F));

        PartDefinition bone128 = bone125.addOrReplaceChild("bone128", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.5031F, -0.2396F, 7.5055F, 0.0F, 0.3927F, 0.0F));

        PartDefinition cube_r392 = bone128.addOrReplaceChild("cube_r392", CubeListBuilder.create().texOffs(276, 25).addBox(-3.0F, -1.0F, -1.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, -0.6354F, 7.6945F, 1.5564F, -1.0911F, -1.5504F));

        PartDefinition cube_r393 = bone128.addOrReplaceChild("cube_r393", CubeListBuilder.create().texOffs(136, 242).addBox(-3.0F, -1.0F, -1.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, 0.9646F, 4.0195F, 1.5708F, -1.3526F, -1.5708F));

        PartDefinition cube_r394 = bone128.addOrReplaceChild("cube_r394", CubeListBuilder.create().texOffs(132, 224).addBox(-3.0F, -1.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, 1.1896F, -1.8555F, -1.5708F, -1.4399F, 1.5708F));

        PartDefinition cube_r395 = bone128.addOrReplaceChild("cube_r395", CubeListBuilder.create().texOffs(194, 136).addBox(-3.0F, -1.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, -0.5604F, -7.5055F, -1.5708F, -1.0908F, 1.5708F));

        PartDefinition arm10 = partdefinition.addOrReplaceChild("arm10", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition cube_r396 = arm10.addOrReplaceChild("cube_r396", CubeListBuilder.create().texOffs(100, 246).addBox(11.5F, -11.0F, -11.0F, 2.0F, 22.0F, 22.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -24.0F, 0.0F, -1.5708F, 0.0F));

        PartDefinition cube_r397 = arm10.addOrReplaceChild("cube_r397", CubeListBuilder.create().texOffs(242, 136).addBox(11.5F, -11.0F, -11.0F, 2.0F, 22.0F, 22.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -18.0F, 0.0F, -1.5708F, 0.0F));

        PartDefinition cube_r398 = arm10.addOrReplaceChild("cube_r398", CubeListBuilder.create().texOffs(198, 236).addBox(11.5F, -11.0F, -11.0F, 2.0F, 22.0F, 22.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -12.0F, 0.0F, -1.5708F, 0.0F));

        PartDefinition cube_r399 = arm10.addOrReplaceChild("cube_r399", CubeListBuilder.create().texOffs(0, 230).addBox(11.5F, -11.0F, -11.0F, 2.0F, 22.0F, 22.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -6.0F, 0.0F, -1.5708F, 0.0F));

        PartDefinition cube_r400 = arm10.addOrReplaceChild("cube_r400", CubeListBuilder.create().texOffs(0, 182).addBox(11.5F, -12.0F, -12.0F, 2.0F, 24.0F, 24.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 5.0F, 0.0F, -1.5708F, 0.0F));

        PartDefinition cube_r401 = arm10.addOrReplaceChild("cube_r401", CubeListBuilder.create().texOffs(52, 226).addBox(11.5F, -11.0F, -11.0F, 2.0F, 22.0F, 22.0F, new CubeDeformation(0.0F))
                .texOffs(1, 56).addBox(-16.5F, -9.0F, -9.0F, 35.0F, 18.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

        PartDefinition arm11 = partdefinition.addOrReplaceChild("arm11", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition cube_r402 = arm11.addOrReplaceChild("cube_r402", CubeListBuilder.create().texOffs(180, 96).addBox(-15.0F, -5.0F, -5.0F, 30.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

        PartDefinition bone129 = arm11.addOrReplaceChild("bone129", CubeListBuilder.create(), PartPose.offset(-0.5031F, -6.0604F, 10.0055F));

        PartDefinition bone130 = bone129.addOrReplaceChild("bone130", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition bone131 = bone130.addOrReplaceChild("bone131", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.3927F, 0.0F));

        PartDefinition cube_r403 = bone131.addOrReplaceChild("cube_r403", CubeListBuilder.create().texOffs(158, 192).addBox(-3.0F, 0.0F, -1.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, 0.6354F, 7.6945F, -1.5564F, -1.0911F, 1.5504F));

        PartDefinition cube_r404 = bone131.addOrReplaceChild("cube_r404", CubeListBuilder.create().texOffs(84, 172).addBox(-3.0F, 0.0F, -1.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, -0.9646F, 4.0195F, -1.5708F, -1.3526F, 1.5708F));

        PartDefinition cube_r405 = bone131.addOrReplaceChild("cube_r405", CubeListBuilder.create().texOffs(194, 138).addBox(-3.0F, 0.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, -1.1896F, -1.8555F, 1.5708F, -1.4399F, -1.5708F));

        PartDefinition cube_r406 = bone131.addOrReplaceChild("cube_r406", CubeListBuilder.create().texOffs(94, 138).addBox(-3.0F, 0.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, 0.5604F, -7.5055F, 1.5708F, -1.0908F, -1.5708F));

        PartDefinition bone132 = bone130.addOrReplaceChild("bone132", CubeListBuilder.create(), PartPose.offset(2.5031F, 12.5604F, -7.5055F));

        PartDefinition cube_r407 = bone132.addOrReplaceChild("cube_r407", CubeListBuilder.create().texOffs(246, 38).addBox(-3.0F, 0.0F, -1.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -10.925F, 15.2F, -1.5564F, -1.0911F, 1.5504F));

        PartDefinition cube_r408 = bone132.addOrReplaceChild("cube_r408", CubeListBuilder.create().texOffs(84, 174).addBox(-3.0F, 0.0F, -1.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -12.525F, 11.525F, -1.5708F, -1.3526F, 1.5708F));

        PartDefinition cube_r409 = bone132.addOrReplaceChild("cube_r409", CubeListBuilder.create().texOffs(146, 194).addBox(-3.0F, 0.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -12.75F, 5.65F, 1.5708F, -1.4399F, -1.5708F));

        PartDefinition cube_r410 = bone132.addOrReplaceChild("cube_r410", CubeListBuilder.create().texOffs(142, 54).addBox(-3.0F, 0.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -11.0F, 0.0F, 1.5708F, -1.0908F, -1.5708F));

        PartDefinition bone133 = bone130.addOrReplaceChild("bone133", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, -2.0F, 0.0F, -0.3054F, 0.0F));

        PartDefinition cube_r411 = bone133.addOrReplaceChild("cube_r411", CubeListBuilder.create().texOffs(260, 134).addBox(-3.0F, 0.0F, -1.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, 0.6354F, 7.6945F, -1.5564F, -1.0911F, 1.5504F));

        PartDefinition cube_r412 = bone133.addOrReplaceChild("cube_r412", CubeListBuilder.create().texOffs(136, 244).addBox(-3.0F, 0.0F, -1.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, -0.9646F, 4.0195F, -1.5708F, -1.3526F, 1.5708F));

        PartDefinition cube_r413 = bone133.addOrReplaceChild("cube_r413", CubeListBuilder.create().texOffs(208, 136).addBox(-3.0F, 0.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, -1.1896F, -1.8555F, 1.5708F, -1.4399F, -1.5708F));

        PartDefinition cube_r414 = bone133.addOrReplaceChild("cube_r414", CubeListBuilder.create().texOffs(128, 54).addBox(-3.0F, 0.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, 0.5604F, -7.5055F, 1.5708F, -1.0908F, -1.5708F));

        PartDefinition bone134 = bone129.addOrReplaceChild("bone134", CubeListBuilder.create(), PartPose.offset(2.5031F, 11.5604F, -8.5055F));

        PartDefinition bone135 = bone134.addOrReplaceChild("bone135", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition cube_r415 = bone135.addOrReplaceChild("cube_r415", CubeListBuilder.create().texOffs(254, 38).addBox(-3.0F, -1.0F, -1.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.075F, 15.2F, 1.5564F, -1.0911F, -1.5504F));

        PartDefinition cube_r416 = bone135.addOrReplaceChild("cube_r416", CubeListBuilder.create().texOffs(190, 45).addBox(-3.0F, -1.0F, -1.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.525F, 11.525F, 1.5708F, -1.3526F, -1.5708F));

        PartDefinition cube_r417 = bone135.addOrReplaceChild("cube_r417", CubeListBuilder.create().texOffs(146, 196).addBox(-3.0F, -1.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.75F, 5.65F, -1.5708F, -1.4399F, 1.5708F));

        PartDefinition cube_r418 = bone135.addOrReplaceChild("cube_r418", CubeListBuilder.create().texOffs(156, 54).addBox(-3.0F, -1.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.5708F, -1.0908F, 1.5708F));

        PartDefinition bone136 = bone134.addOrReplaceChild("bone136", CubeListBuilder.create(), PartPose.offset(-1.0F, -0.775F, 2.125F));

        PartDefinition cube_r419 = bone136.addOrReplaceChild("cube_r419", CubeListBuilder.create().texOffs(254, 234).addBox(-3.0F, -1.0F, -1.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, -0.075F, 15.2F, 1.5564F, -1.0911F, -1.5504F));

        PartDefinition cube_r420 = bone136.addOrReplaceChild("cube_r420", CubeListBuilder.create().texOffs(228, 93).addBox(-3.0F, -1.0F, -1.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 1.525F, 11.525F, 1.5708F, -1.3526F, -1.5708F));

        PartDefinition cube_r421 = bone136.addOrReplaceChild("cube_r421", CubeListBuilder.create().texOffs(200, 93).addBox(-3.0F, -1.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 1.75F, 5.65F, -1.5708F, -1.4399F, 1.5708F));

        PartDefinition cube_r422 = bone136.addOrReplaceChild("cube_r422", CubeListBuilder.create().texOffs(170, 54).addBox(-3.0F, -1.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 0.0F, 0.0F, -1.5708F, -1.0908F, 1.5708F));

        PartDefinition bone137 = bone134.addOrReplaceChild("bone137", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.5031F, -0.2396F, 7.5055F, 0.0F, 0.3927F, 0.0F));

        PartDefinition cube_r423 = bone137.addOrReplaceChild("cube_r423", CubeListBuilder.create().texOffs(262, 38).addBox(-3.0F, -1.0F, -1.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, -0.6354F, 7.6945F, 1.5564F, -1.0911F, -1.5504F));

        PartDefinition cube_r424 = bone137.addOrReplaceChild("cube_r424", CubeListBuilder.create().texOffs(136, 232).addBox(-3.0F, -1.0F, -1.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, 0.9646F, 4.0195F, 1.5708F, -1.3526F, -1.5708F));

        PartDefinition cube_r425 = bone137.addOrReplaceChild("cube_r425", CubeListBuilder.create().texOffs(208, 138).addBox(-3.0F, -1.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, 1.1896F, -1.8555F, -1.5708F, -1.4399F, 1.5708F));

        PartDefinition cube_r426 = bone137.addOrReplaceChild("cube_r426", CubeListBuilder.create().texOffs(70, 172).addBox(-3.0F, -1.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, -0.5604F, -7.5055F, -1.5708F, -1.0908F, 1.5708F));

        PartDefinition bone138 = bone129.addOrReplaceChild("bone138", CubeListBuilder.create(), PartPose.offsetAndRotation(-2.1656F, 4.8368F, -4.7435F, 0.0F, 0.0F, -1.5708F));

        PartDefinition bone139 = bone138.addOrReplaceChild("bone139", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.8344F, -4.1868F, 3.1685F, 0.0F, 0.3927F, 0.0F));

        PartDefinition cube_r427 = bone139.addOrReplaceChild("cube_r427", CubeListBuilder.create().texOffs(262, 234).addBox(-3.0F, 0.0F, -1.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, 0.6354F, 7.6945F, -1.5564F, -1.0911F, 1.5504F));

        PartDefinition cube_r428 = bone139.addOrReplaceChild("cube_r428", CubeListBuilder.create().texOffs(136, 234).addBox(-3.0F, 0.0F, -1.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, -0.9646F, 4.0195F, -1.5708F, -1.3526F, 1.5708F));

        PartDefinition cube_r429 = bone139.addOrReplaceChild("cube_r429", CubeListBuilder.create().texOffs(214, 93).addBox(-3.0F, 0.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, -1.1896F, -1.8555F, 1.5708F, -1.4399F, -1.5708F));

        PartDefinition cube_r430 = bone139.addOrReplaceChild("cube_r430", CubeListBuilder.create().texOffs(70, 174).addBox(-3.0F, 0.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, 0.5604F, -7.5055F, 1.5708F, -1.0908F, -1.5708F));

        PartDefinition bone140 = bone138.addOrReplaceChild("bone140", CubeListBuilder.create(), PartPose.offset(1.6687F, 8.3736F, -4.337F));

        PartDefinition cube_r431 = bone140.addOrReplaceChild("cube_r431", CubeListBuilder.create().texOffs(268, 134).addBox(-3.0F, 0.0F, -1.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -10.925F, 15.2F, -1.5564F, -1.0911F, 1.5504F));

        PartDefinition cube_r432 = bone140.addOrReplaceChild("cube_r432", CubeListBuilder.create().texOffs(236, 38).addBox(-3.0F, 0.0F, -1.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -12.525F, 11.525F, -1.5708F, -1.3526F, 1.5708F));

        PartDefinition cube_r433 = bone140.addOrReplaceChild("cube_r433", CubeListBuilder.create().texOffs(222, 38).addBox(-3.0F, 0.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -12.75F, 5.65F, 1.5708F, -1.4399F, -1.5708F));

        PartDefinition cube_r434 = bone140.addOrReplaceChild("cube_r434", CubeListBuilder.create().texOffs(176, 45).addBox(-3.0F, 0.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -11.0F, 0.0F, 1.5708F, -1.0908F, -1.5708F));

        PartDefinition bone141 = bone138.addOrReplaceChild("bone141", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.8344F, -4.1868F, 1.1685F, 0.0F, -0.3054F, 0.0F));

        PartDefinition cube_r435 = bone141.addOrReplaceChild("cube_r435", CubeListBuilder.create().texOffs(270, 234).addBox(-3.0F, 0.0F, -1.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, 0.6354F, 7.6945F, -1.5564F, -1.0911F, 1.5504F));

        PartDefinition cube_r436 = bone141.addOrReplaceChild("cube_r436", CubeListBuilder.create().texOffs(136, 236).addBox(-3.0F, 0.0F, -1.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, -0.9646F, 4.0195F, -1.5708F, -1.3526F, 1.5708F));

        PartDefinition cube_r437 = bone141.addOrReplaceChild("cube_r437", CubeListBuilder.create().texOffs(222, 136).addBox(-3.0F, 0.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, -1.1896F, -1.8555F, 1.5708F, -1.4399F, -1.5708F));

        PartDefinition cube_r438 = bone141.addOrReplaceChild("cube_r438", CubeListBuilder.create().texOffs(180, 136).addBox(-3.0F, 0.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, 0.5604F, -7.5055F, 1.5708F, -1.0908F, -1.5708F));

        PartDefinition bone142 = bone129.addOrReplaceChild("bone142", CubeListBuilder.create(), PartPose.offsetAndRotation(5.5031F, 4.5604F, -8.5055F, 0.0F, 0.0F, -1.5708F));

        PartDefinition bone143 = bone142.addOrReplaceChild("bone143", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition cube_r439 = bone143.addOrReplaceChild("cube_r439", CubeListBuilder.create().texOffs(40, 274).addBox(-3.0F, -1.0F, -1.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.075F, 15.2F, 1.5564F, -1.0911F, -1.5504F));

        PartDefinition cube_r440 = bone143.addOrReplaceChild("cube_r440", CubeListBuilder.create().texOffs(136, 238).addBox(-3.0F, -1.0F, -1.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.525F, 11.525F, 1.5708F, -1.3526F, -1.5708F));

        PartDefinition cube_r441 = bone143.addOrReplaceChild("cube_r441", CubeListBuilder.create().texOffs(222, 138).addBox(-3.0F, -1.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.75F, 5.65F, -1.5708F, -1.4399F, 1.5708F));

        PartDefinition cube_r442 = bone143.addOrReplaceChild("cube_r442", CubeListBuilder.create().texOffs(180, 138).addBox(-3.0F, -1.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.5708F, -1.0908F, 1.5708F));

        PartDefinition bone144 = bone142.addOrReplaceChild("bone144", CubeListBuilder.create(), PartPose.offset(-1.0F, -0.775F, 2.125F));

        PartDefinition cube_r443 = bone144.addOrReplaceChild("cube_r443", CubeListBuilder.create().texOffs(276, 23).addBox(-3.0F, -1.0F, -1.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, -0.075F, 15.2F, 1.5564F, -1.0911F, -1.5504F));

        PartDefinition cube_r444 = bone144.addOrReplaceChild("cube_r444", CubeListBuilder.create().texOffs(136, 240).addBox(-3.0F, -1.0F, -1.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 1.525F, 11.525F, 1.5708F, -1.3526F, -1.5708F));

        PartDefinition cube_r445 = bone144.addOrReplaceChild("cube_r445", CubeListBuilder.create().texOffs(118, 224).addBox(-3.0F, -1.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 1.75F, 5.65F, -1.5708F, -1.4399F, 1.5708F));

        PartDefinition cube_r446 = bone144.addOrReplaceChild("cube_r446", CubeListBuilder.create().texOffs(184, 53).addBox(-3.0F, -1.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 0.0F, 0.0F, -1.5708F, -1.0908F, 1.5708F));

        PartDefinition bone145 = bone142.addOrReplaceChild("bone145", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.5031F, -0.2396F, 7.5055F, 0.0F, 0.3927F, 0.0F));

        PartDefinition cube_r447 = bone145.addOrReplaceChild("cube_r447", CubeListBuilder.create().texOffs(276, 25).addBox(-3.0F, -1.0F, -1.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, -0.6354F, 7.6945F, 1.5564F, -1.0911F, -1.5504F));

        PartDefinition cube_r448 = bone145.addOrReplaceChild("cube_r448", CubeListBuilder.create().texOffs(136, 242).addBox(-3.0F, -1.0F, -1.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, 0.9646F, 4.0195F, 1.5708F, -1.3526F, -1.5708F));

        PartDefinition cube_r449 = bone145.addOrReplaceChild("cube_r449", CubeListBuilder.create().texOffs(132, 224).addBox(-3.0F, -1.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, 1.1896F, -1.8555F, -1.5708F, -1.4399F, 1.5708F));

        PartDefinition cube_r450 = bone145.addOrReplaceChild("cube_r450", CubeListBuilder.create().texOffs(194, 136).addBox(-3.0F, -1.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, -0.5604F, -7.5055F, -1.5708F, -1.0908F, 1.5708F));

        PartDefinition arm12 = partdefinition.addOrReplaceChild("arm12", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition cube_r451 = arm12.addOrReplaceChild("cube_r451", CubeListBuilder.create().texOffs(180, 116).addBox(-15.0F, -5.0F, -5.0F, 30.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

        PartDefinition bone146 = arm12.addOrReplaceChild("bone146", CubeListBuilder.create(), PartPose.offset(-0.5031F, -6.0604F, 10.0055F));

        PartDefinition bone147 = bone146.addOrReplaceChild("bone147", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition bone148 = bone147.addOrReplaceChild("bone148", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.3927F, 0.0F));

        PartDefinition cube_r452 = bone148.addOrReplaceChild("cube_r452", CubeListBuilder.create().texOffs(158, 192).addBox(-3.0F, 0.0F, -1.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, 0.6354F, 7.6945F, -1.5564F, -1.0911F, 1.5504F));

        PartDefinition cube_r453 = bone148.addOrReplaceChild("cube_r453", CubeListBuilder.create().texOffs(84, 172).addBox(-3.0F, 0.0F, -1.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, -0.9646F, 4.0195F, -1.5708F, -1.3526F, 1.5708F));

        PartDefinition cube_r454 = bone148.addOrReplaceChild("cube_r454", CubeListBuilder.create().texOffs(194, 138).addBox(-3.0F, 0.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, -1.1896F, -1.8555F, 1.5708F, -1.4399F, -1.5708F));

        PartDefinition cube_r455 = bone148.addOrReplaceChild("cube_r455", CubeListBuilder.create().texOffs(94, 138).addBox(-3.0F, 0.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, 0.5604F, -7.5055F, 1.5708F, -1.0908F, -1.5708F));

        PartDefinition bone149 = bone147.addOrReplaceChild("bone149", CubeListBuilder.create(), PartPose.offset(2.5031F, 12.5604F, -7.5055F));

        PartDefinition cube_r456 = bone149.addOrReplaceChild("cube_r456", CubeListBuilder.create().texOffs(246, 38).addBox(-3.0F, 0.0F, -1.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -10.925F, 15.2F, -1.5564F, -1.0911F, 1.5504F));

        PartDefinition cube_r457 = bone149.addOrReplaceChild("cube_r457", CubeListBuilder.create().texOffs(84, 174).addBox(-3.0F, 0.0F, -1.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -12.525F, 11.525F, -1.5708F, -1.3526F, 1.5708F));

        PartDefinition cube_r458 = bone149.addOrReplaceChild("cube_r458", CubeListBuilder.create().texOffs(146, 194).addBox(-3.0F, 0.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -12.75F, 5.65F, 1.5708F, -1.4399F, -1.5708F));

        PartDefinition cube_r459 = bone149.addOrReplaceChild("cube_r459", CubeListBuilder.create().texOffs(142, 54).addBox(-3.0F, 0.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -11.0F, 0.0F, 1.5708F, -1.0908F, -1.5708F));

        PartDefinition bone150 = bone147.addOrReplaceChild("bone150", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, -2.0F, 0.0F, -0.3054F, 0.0F));

        PartDefinition cube_r460 = bone150.addOrReplaceChild("cube_r460", CubeListBuilder.create().texOffs(260, 134).addBox(-3.0F, 0.0F, -1.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, 0.6354F, 7.6945F, -1.5564F, -1.0911F, 1.5504F));

        PartDefinition cube_r461 = bone150.addOrReplaceChild("cube_r461", CubeListBuilder.create().texOffs(136, 244).addBox(-3.0F, 0.0F, -1.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, -0.9646F, 4.0195F, -1.5708F, -1.3526F, 1.5708F));

        PartDefinition cube_r462 = bone150.addOrReplaceChild("cube_r462", CubeListBuilder.create().texOffs(208, 136).addBox(-3.0F, 0.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, -1.1896F, -1.8555F, 1.5708F, -1.4399F, -1.5708F));

        PartDefinition cube_r463 = bone150.addOrReplaceChild("cube_r463", CubeListBuilder.create().texOffs(128, 54).addBox(-3.0F, 0.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, 0.5604F, -7.5055F, 1.5708F, -1.0908F, -1.5708F));

        PartDefinition bone151 = bone146.addOrReplaceChild("bone151", CubeListBuilder.create(), PartPose.offset(2.5031F, 11.5604F, -8.5055F));

        PartDefinition bone152 = bone151.addOrReplaceChild("bone152", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition cube_r464 = bone152.addOrReplaceChild("cube_r464", CubeListBuilder.create().texOffs(254, 38).addBox(-3.0F, -1.0F, -1.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.075F, 15.2F, 1.5564F, -1.0911F, -1.5504F));

        PartDefinition cube_r465 = bone152.addOrReplaceChild("cube_r465", CubeListBuilder.create().texOffs(190, 45).addBox(-3.0F, -1.0F, -1.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.525F, 11.525F, 1.5708F, -1.3526F, -1.5708F));

        PartDefinition cube_r466 = bone152.addOrReplaceChild("cube_r466", CubeListBuilder.create().texOffs(146, 196).addBox(-3.0F, -1.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.75F, 5.65F, -1.5708F, -1.4399F, 1.5708F));

        PartDefinition cube_r467 = bone152.addOrReplaceChild("cube_r467", CubeListBuilder.create().texOffs(156, 54).addBox(-3.0F, -1.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.5708F, -1.0908F, 1.5708F));

        PartDefinition bone153 = bone151.addOrReplaceChild("bone153", CubeListBuilder.create(), PartPose.offset(-1.0F, -0.775F, 2.125F));

        PartDefinition cube_r468 = bone153.addOrReplaceChild("cube_r468", CubeListBuilder.create().texOffs(254, 234).addBox(-3.0F, -1.0F, -1.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, -0.075F, 15.2F, 1.5564F, -1.0911F, -1.5504F));

        PartDefinition cube_r469 = bone153.addOrReplaceChild("cube_r469", CubeListBuilder.create().texOffs(228, 93).addBox(-3.0F, -1.0F, -1.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 1.525F, 11.525F, 1.5708F, -1.3526F, -1.5708F));

        PartDefinition cube_r470 = bone153.addOrReplaceChild("cube_r470", CubeListBuilder.create().texOffs(200, 93).addBox(-3.0F, -1.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 1.75F, 5.65F, -1.5708F, -1.4399F, 1.5708F));

        PartDefinition cube_r471 = bone153.addOrReplaceChild("cube_r471", CubeListBuilder.create().texOffs(170, 54).addBox(-3.0F, -1.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 0.0F, 0.0F, -1.5708F, -1.0908F, 1.5708F));

        PartDefinition bone154 = bone151.addOrReplaceChild("bone154", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.5031F, -0.2396F, 7.5055F, 0.0F, 0.3927F, 0.0F));

        PartDefinition cube_r472 = bone154.addOrReplaceChild("cube_r472", CubeListBuilder.create().texOffs(262, 38).addBox(-3.0F, -1.0F, -1.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, -0.6354F, 7.6945F, 1.5564F, -1.0911F, -1.5504F));

        PartDefinition cube_r473 = bone154.addOrReplaceChild("cube_r473", CubeListBuilder.create().texOffs(136, 232).addBox(-3.0F, -1.0F, -1.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, 0.9646F, 4.0195F, 1.5708F, -1.3526F, -1.5708F));

        PartDefinition cube_r474 = bone154.addOrReplaceChild("cube_r474", CubeListBuilder.create().texOffs(208, 138).addBox(-3.0F, -1.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, 1.1896F, -1.8555F, -1.5708F, -1.4399F, 1.5708F));

        PartDefinition cube_r475 = bone154.addOrReplaceChild("cube_r475", CubeListBuilder.create().texOffs(70, 172).addBox(-3.0F, -1.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, -0.5604F, -7.5055F, -1.5708F, -1.0908F, 1.5708F));

        PartDefinition bone155 = bone146.addOrReplaceChild("bone155", CubeListBuilder.create(), PartPose.offsetAndRotation(-2.1656F, 4.8368F, -4.7435F, 0.0F, 0.0F, -1.5708F));

        PartDefinition bone156 = bone155.addOrReplaceChild("bone156", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.8344F, -4.1868F, 3.1685F, 0.0F, 0.3927F, 0.0F));

        PartDefinition cube_r476 = bone156.addOrReplaceChild("cube_r476", CubeListBuilder.create().texOffs(262, 234).addBox(-3.0F, 0.0F, -1.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, 0.6354F, 7.6945F, -1.5564F, -1.0911F, 1.5504F));

        PartDefinition cube_r477 = bone156.addOrReplaceChild("cube_r477", CubeListBuilder.create().texOffs(136, 234).addBox(-3.0F, 0.0F, -1.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, -0.9646F, 4.0195F, -1.5708F, -1.3526F, 1.5708F));

        PartDefinition cube_r478 = bone156.addOrReplaceChild("cube_r478", CubeListBuilder.create().texOffs(214, 93).addBox(-3.0F, 0.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, -1.1896F, -1.8555F, 1.5708F, -1.4399F, -1.5708F));

        PartDefinition cube_r479 = bone156.addOrReplaceChild("cube_r479", CubeListBuilder.create().texOffs(70, 174).addBox(-3.0F, 0.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, 0.5604F, -7.5055F, 1.5708F, -1.0908F, -1.5708F));

        PartDefinition bone157 = bone155.addOrReplaceChild("bone157", CubeListBuilder.create(), PartPose.offset(1.6687F, 8.3736F, -4.337F));

        PartDefinition cube_r480 = bone157.addOrReplaceChild("cube_r480", CubeListBuilder.create().texOffs(268, 134).addBox(-3.0F, 0.0F, -1.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -10.925F, 15.2F, -1.5564F, -1.0911F, 1.5504F));

        PartDefinition cube_r481 = bone157.addOrReplaceChild("cube_r481", CubeListBuilder.create().texOffs(236, 38).addBox(-3.0F, 0.0F, -1.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -12.525F, 11.525F, -1.5708F, -1.3526F, 1.5708F));

        PartDefinition cube_r482 = bone157.addOrReplaceChild("cube_r482", CubeListBuilder.create().texOffs(222, 38).addBox(-3.0F, 0.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -12.75F, 5.65F, 1.5708F, -1.4399F, -1.5708F));

        PartDefinition cube_r483 = bone157.addOrReplaceChild("cube_r483", CubeListBuilder.create().texOffs(176, 45).addBox(-3.0F, 0.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -11.0F, 0.0F, 1.5708F, -1.0908F, -1.5708F));

        PartDefinition bone158 = bone155.addOrReplaceChild("bone158", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.8344F, -4.1868F, 1.1685F, 0.0F, -0.3054F, 0.0F));

        PartDefinition cube_r484 = bone158.addOrReplaceChild("cube_r484", CubeListBuilder.create().texOffs(270, 234).addBox(-3.0F, 0.0F, -1.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, 0.6354F, 7.6945F, -1.5564F, -1.0911F, 1.5504F));

        PartDefinition cube_r485 = bone158.addOrReplaceChild("cube_r485", CubeListBuilder.create().texOffs(136, 236).addBox(-3.0F, 0.0F, -1.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, -0.9646F, 4.0195F, -1.5708F, -1.3526F, 1.5708F));

        PartDefinition cube_r486 = bone158.addOrReplaceChild("cube_r486", CubeListBuilder.create().texOffs(222, 136).addBox(-3.0F, 0.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, -1.1896F, -1.8555F, 1.5708F, -1.4399F, -1.5708F));

        PartDefinition cube_r487 = bone158.addOrReplaceChild("cube_r487", CubeListBuilder.create().texOffs(180, 136).addBox(-3.0F, 0.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, 0.5604F, -7.5055F, 1.5708F, -1.0908F, -1.5708F));

        PartDefinition bone159 = bone146.addOrReplaceChild("bone159", CubeListBuilder.create(), PartPose.offsetAndRotation(5.5031F, 4.5604F, -8.5055F, 0.0F, 0.0F, -1.5708F));

        PartDefinition bone160 = bone159.addOrReplaceChild("bone160", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition cube_r488 = bone160.addOrReplaceChild("cube_r488", CubeListBuilder.create().texOffs(40, 274).addBox(-3.0F, -1.0F, -1.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.075F, 15.2F, 1.5564F, -1.0911F, -1.5504F));

        PartDefinition cube_r489 = bone160.addOrReplaceChild("cube_r489", CubeListBuilder.create().texOffs(136, 238).addBox(-3.0F, -1.0F, -1.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.525F, 11.525F, 1.5708F, -1.3526F, -1.5708F));

        PartDefinition cube_r490 = bone160.addOrReplaceChild("cube_r490", CubeListBuilder.create().texOffs(222, 138).addBox(-3.0F, -1.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.75F, 5.65F, -1.5708F, -1.4399F, 1.5708F));

        PartDefinition cube_r491 = bone160.addOrReplaceChild("cube_r491", CubeListBuilder.create().texOffs(180, 138).addBox(-3.0F, -1.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.5708F, -1.0908F, 1.5708F));

        PartDefinition bone161 = bone159.addOrReplaceChild("bone161", CubeListBuilder.create(), PartPose.offset(-1.0F, -0.775F, 2.125F));

        PartDefinition cube_r492 = bone161.addOrReplaceChild("cube_r492", CubeListBuilder.create().texOffs(276, 23).addBox(-3.0F, -1.0F, -1.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, -0.075F, 15.2F, 1.5564F, -1.0911F, -1.5504F));

        PartDefinition cube_r493 = bone161.addOrReplaceChild("cube_r493", CubeListBuilder.create().texOffs(136, 240).addBox(-3.0F, -1.0F, -1.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 1.525F, 11.525F, 1.5708F, -1.3526F, -1.5708F));

        PartDefinition cube_r494 = bone161.addOrReplaceChild("cube_r494", CubeListBuilder.create().texOffs(118, 224).addBox(-3.0F, -1.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 1.75F, 5.65F, -1.5708F, -1.4399F, 1.5708F));

        PartDefinition cube_r495 = bone161.addOrReplaceChild("cube_r495", CubeListBuilder.create().texOffs(184, 53).addBox(-3.0F, -1.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 0.0F, 0.0F, -1.5708F, -1.0908F, 1.5708F));

        PartDefinition bone162 = bone159.addOrReplaceChild("bone162", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.5031F, -0.2396F, 7.5055F, 0.0F, 0.3927F, 0.0F));

        PartDefinition cube_r496 = bone162.addOrReplaceChild("cube_r496", CubeListBuilder.create().texOffs(276, 25).addBox(-3.0F, -1.0F, -1.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, -0.6354F, 7.6945F, 1.5564F, -1.0911F, -1.5504F));

        PartDefinition cube_r497 = bone162.addOrReplaceChild("cube_r497", CubeListBuilder.create().texOffs(136, 242).addBox(-3.0F, -1.0F, -1.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, 0.9646F, 4.0195F, 1.5708F, -1.3526F, -1.5708F));

        PartDefinition cube_r498 = bone162.addOrReplaceChild("cube_r498", CubeListBuilder.create().texOffs(132, 224).addBox(-3.0F, -1.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, 1.1896F, -1.8555F, -1.5708F, -1.4399F, 1.5708F));

        PartDefinition cube_r499 = bone162.addOrReplaceChild("cube_r499", CubeListBuilder.create().texOffs(194, 136).addBox(-3.0F, -1.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, -0.5604F, -7.5055F, -1.5708F, -1.0908F, 1.5708F));

        PartDefinition arm13 = partdefinition.addOrReplaceChild("arm13", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition cube_r500 = arm13.addOrReplaceChild("cube_r500", CubeListBuilder.create().texOffs(128, 20).addBox(-18.0F, -5.0F, -5.0F, 37.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

        PartDefinition bone163 = arm13.addOrReplaceChild("bone163", CubeListBuilder.create(), PartPose.offset(-0.5031F, -6.0604F, 15.0055F));

        PartDefinition bone164 = bone163.addOrReplaceChild("bone164", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition bone165 = bone164.addOrReplaceChild("bone165", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.3927F, 0.0F));

        PartDefinition cube_r501 = bone165.addOrReplaceChild("cube_r501", CubeListBuilder.create().texOffs(158, 192).addBox(-3.0F, 0.0F, -1.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, 0.6354F, 7.6945F, -1.5564F, -1.0911F, 1.5504F));

        PartDefinition cube_r502 = bone165.addOrReplaceChild("cube_r502", CubeListBuilder.create().texOffs(84, 172).addBox(-3.0F, 0.0F, -1.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, -0.9646F, 4.0195F, -1.5708F, -1.3526F, 1.5708F));

        PartDefinition cube_r503 = bone165.addOrReplaceChild("cube_r503", CubeListBuilder.create().texOffs(194, 138).addBox(-3.0F, 0.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, -1.1896F, -1.8555F, 1.5708F, -1.4399F, -1.5708F));

        PartDefinition cube_r504 = bone165.addOrReplaceChild("cube_r504", CubeListBuilder.create().texOffs(94, 138).addBox(-3.0F, 0.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, 0.5604F, -7.5055F, 1.5708F, -1.0908F, -1.5708F));

        PartDefinition bone166 = bone164.addOrReplaceChild("bone166", CubeListBuilder.create(), PartPose.offset(2.5031F, 12.5604F, -7.5055F));

        PartDefinition cube_r505 = bone166.addOrReplaceChild("cube_r505", CubeListBuilder.create().texOffs(246, 38).addBox(-3.0F, 0.0F, -1.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -10.925F, 15.2F, -1.5564F, -1.0911F, 1.5504F));

        PartDefinition cube_r506 = bone166.addOrReplaceChild("cube_r506", CubeListBuilder.create().texOffs(84, 174).addBox(-3.0F, 0.0F, -1.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -12.525F, 11.525F, -1.5708F, -1.3526F, 1.5708F));

        PartDefinition cube_r507 = bone166.addOrReplaceChild("cube_r507", CubeListBuilder.create().texOffs(146, 194).addBox(-3.0F, 0.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -12.75F, 5.65F, 1.5708F, -1.4399F, -1.5708F));

        PartDefinition cube_r508 = bone166.addOrReplaceChild("cube_r508", CubeListBuilder.create().texOffs(142, 54).addBox(-3.0F, 0.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -11.0F, 0.0F, 1.5708F, -1.0908F, -1.5708F));

        PartDefinition bone167 = bone164.addOrReplaceChild("bone167", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, -2.0F, 0.0F, -0.3054F, 0.0F));

        PartDefinition cube_r509 = bone167.addOrReplaceChild("cube_r509", CubeListBuilder.create().texOffs(260, 134).addBox(-3.0F, 0.0F, -1.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, 0.6354F, 7.6945F, -1.5564F, -1.0911F, 1.5504F));

        PartDefinition cube_r510 = bone167.addOrReplaceChild("cube_r510", CubeListBuilder.create().texOffs(136, 244).addBox(-3.0F, 0.0F, -1.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, -0.9646F, 4.0195F, -1.5708F, -1.3526F, 1.5708F));

        PartDefinition cube_r511 = bone167.addOrReplaceChild("cube_r511", CubeListBuilder.create().texOffs(208, 136).addBox(-3.0F, 0.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, -1.1896F, -1.8555F, 1.5708F, -1.4399F, -1.5708F));

        PartDefinition cube_r512 = bone167.addOrReplaceChild("cube_r512", CubeListBuilder.create().texOffs(128, 54).addBox(-3.0F, 0.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, 0.5604F, -7.5055F, 1.5708F, -1.0908F, -1.5708F));

        PartDefinition bone168 = bone163.addOrReplaceChild("bone168", CubeListBuilder.create(), PartPose.offset(2.5031F, 11.5604F, -8.5055F));

        PartDefinition bone169 = bone168.addOrReplaceChild("bone169", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition cube_r513 = bone169.addOrReplaceChild("cube_r513", CubeListBuilder.create().texOffs(254, 38).addBox(-3.0F, -1.0F, -1.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.075F, 15.2F, 1.5564F, -1.0911F, -1.5504F));

        PartDefinition cube_r514 = bone169.addOrReplaceChild("cube_r514", CubeListBuilder.create().texOffs(190, 45).addBox(-3.0F, -1.0F, -1.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.525F, 11.525F, 1.5708F, -1.3526F, -1.5708F));

        PartDefinition cube_r515 = bone169.addOrReplaceChild("cube_r515", CubeListBuilder.create().texOffs(146, 196).addBox(-3.0F, -1.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.75F, 5.65F, -1.5708F, -1.4399F, 1.5708F));

        PartDefinition cube_r516 = bone169.addOrReplaceChild("cube_r516", CubeListBuilder.create().texOffs(156, 54).addBox(-3.0F, -1.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.5708F, -1.0908F, 1.5708F));

        PartDefinition bone170 = bone168.addOrReplaceChild("bone170", CubeListBuilder.create(), PartPose.offset(-1.0F, -0.775F, 2.125F));

        PartDefinition cube_r517 = bone170.addOrReplaceChild("cube_r517", CubeListBuilder.create().texOffs(254, 234).addBox(-3.0F, -1.0F, -1.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, -0.075F, 15.2F, 1.5564F, -1.0911F, -1.5504F));

        PartDefinition cube_r518 = bone170.addOrReplaceChild("cube_r518", CubeListBuilder.create().texOffs(228, 93).addBox(-3.0F, -1.0F, -1.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 1.525F, 11.525F, 1.5708F, -1.3526F, -1.5708F));

        PartDefinition cube_r519 = bone170.addOrReplaceChild("cube_r519", CubeListBuilder.create().texOffs(200, 93).addBox(-3.0F, -1.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 1.75F, 5.65F, -1.5708F, -1.4399F, 1.5708F));

        PartDefinition cube_r520 = bone170.addOrReplaceChild("cube_r520", CubeListBuilder.create().texOffs(170, 54).addBox(-3.0F, -1.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 0.0F, 0.0F, -1.5708F, -1.0908F, 1.5708F));

        PartDefinition bone171 = bone168.addOrReplaceChild("bone171", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.5031F, -0.2396F, 7.5055F, 0.0F, 0.3927F, 0.0F));

        PartDefinition cube_r521 = bone171.addOrReplaceChild("cube_r521", CubeListBuilder.create().texOffs(262, 38).addBox(-3.0F, -1.0F, -1.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, -0.6354F, 7.6945F, 1.5564F, -1.0911F, -1.5504F));

        PartDefinition cube_r522 = bone171.addOrReplaceChild("cube_r522", CubeListBuilder.create().texOffs(136, 232).addBox(-3.0F, -1.0F, -1.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, 0.9646F, 4.0195F, 1.5708F, -1.3526F, -1.5708F));

        PartDefinition cube_r523 = bone171.addOrReplaceChild("cube_r523", CubeListBuilder.create().texOffs(208, 138).addBox(-3.0F, -1.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, 1.1896F, -1.8555F, -1.5708F, -1.4399F, 1.5708F));

        PartDefinition cube_r524 = bone171.addOrReplaceChild("cube_r524", CubeListBuilder.create().texOffs(70, 172).addBox(-3.0F, -1.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, -0.5604F, -7.5055F, -1.5708F, -1.0908F, 1.5708F));

        PartDefinition bone172 = bone163.addOrReplaceChild("bone172", CubeListBuilder.create(), PartPose.offsetAndRotation(-2.1656F, 4.8368F, -4.7435F, 0.0F, 0.0F, -1.5708F));

        PartDefinition bone173 = bone172.addOrReplaceChild("bone173", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.8344F, -4.1868F, 3.1685F, 0.0F, 0.3927F, 0.0F));

        PartDefinition cube_r525 = bone173.addOrReplaceChild("cube_r525", CubeListBuilder.create().texOffs(262, 234).addBox(-3.0F, 0.0F, -1.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, 0.6354F, 7.6945F, -1.5564F, -1.0911F, 1.5504F));

        PartDefinition cube_r526 = bone173.addOrReplaceChild("cube_r526", CubeListBuilder.create().texOffs(136, 234).addBox(-3.0F, 0.0F, -1.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, -0.9646F, 4.0195F, -1.5708F, -1.3526F, 1.5708F));

        PartDefinition cube_r527 = bone173.addOrReplaceChild("cube_r527", CubeListBuilder.create().texOffs(214, 93).addBox(-3.0F, 0.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, -1.1896F, -1.8555F, 1.5708F, -1.4399F, -1.5708F));

        PartDefinition cube_r528 = bone173.addOrReplaceChild("cube_r528", CubeListBuilder.create().texOffs(70, 174).addBox(-3.0F, 0.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, 0.5604F, -7.5055F, 1.5708F, -1.0908F, -1.5708F));

        PartDefinition bone174 = bone172.addOrReplaceChild("bone174", CubeListBuilder.create(), PartPose.offset(1.6687F, 8.3736F, -4.337F));

        PartDefinition cube_r529 = bone174.addOrReplaceChild("cube_r529", CubeListBuilder.create().texOffs(268, 134).addBox(-3.0F, 0.0F, -1.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -10.925F, 15.2F, -1.5564F, -1.0911F, 1.5504F));

        PartDefinition cube_r530 = bone174.addOrReplaceChild("cube_r530", CubeListBuilder.create().texOffs(236, 38).addBox(-3.0F, 0.0F, -1.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -12.525F, 11.525F, -1.5708F, -1.3526F, 1.5708F));

        PartDefinition cube_r531 = bone174.addOrReplaceChild("cube_r531", CubeListBuilder.create().texOffs(222, 38).addBox(-3.0F, 0.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -12.75F, 5.65F, 1.5708F, -1.4399F, -1.5708F));

        PartDefinition cube_r532 = bone174.addOrReplaceChild("cube_r532", CubeListBuilder.create().texOffs(176, 45).addBox(-3.0F, 0.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -11.0F, 0.0F, 1.5708F, -1.0908F, -1.5708F));

        PartDefinition bone175 = bone172.addOrReplaceChild("bone175", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.8344F, -4.1868F, 1.1685F, 0.0F, -0.3054F, 0.0F));

        PartDefinition cube_r533 = bone175.addOrReplaceChild("cube_r533", CubeListBuilder.create().texOffs(270, 234).addBox(-3.0F, 0.0F, -1.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, 0.6354F, 7.6945F, -1.5564F, -1.0911F, 1.5504F));

        PartDefinition cube_r534 = bone175.addOrReplaceChild("cube_r534", CubeListBuilder.create().texOffs(136, 236).addBox(-3.0F, 0.0F, -1.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, -0.9646F, 4.0195F, -1.5708F, -1.3526F, 1.5708F));

        PartDefinition cube_r535 = bone175.addOrReplaceChild("cube_r535", CubeListBuilder.create().texOffs(222, 136).addBox(-3.0F, 0.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, -1.1896F, -1.8555F, 1.5708F, -1.4399F, -1.5708F));

        PartDefinition cube_r536 = bone175.addOrReplaceChild("cube_r536", CubeListBuilder.create().texOffs(180, 136).addBox(-3.0F, 0.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, 0.5604F, -7.5055F, 1.5708F, -1.0908F, -1.5708F));

        PartDefinition bone176 = bone163.addOrReplaceChild("bone176", CubeListBuilder.create(), PartPose.offsetAndRotation(5.5031F, 4.5604F, -8.5055F, 0.0F, 0.0F, -1.5708F));

        PartDefinition bone177 = bone176.addOrReplaceChild("bone177", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition cube_r537 = bone177.addOrReplaceChild("cube_r537", CubeListBuilder.create().texOffs(40, 274).addBox(-3.0F, -1.0F, -1.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.075F, 15.2F, 1.5564F, -1.0911F, -1.5504F));

        PartDefinition cube_r538 = bone177.addOrReplaceChild("cube_r538", CubeListBuilder.create().texOffs(136, 238).addBox(-3.0F, -1.0F, -1.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.525F, 11.525F, 1.5708F, -1.3526F, -1.5708F));

        PartDefinition cube_r539 = bone177.addOrReplaceChild("cube_r539", CubeListBuilder.create().texOffs(222, 138).addBox(-3.0F, -1.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.75F, 5.65F, -1.5708F, -1.4399F, 1.5708F));

        PartDefinition cube_r540 = bone177.addOrReplaceChild("cube_r540", CubeListBuilder.create().texOffs(180, 138).addBox(-3.0F, -1.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.5708F, -1.0908F, 1.5708F));

        PartDefinition bone178 = bone176.addOrReplaceChild("bone178", CubeListBuilder.create(), PartPose.offset(-1.0F, -0.775F, 2.125F));

        PartDefinition cube_r541 = bone178.addOrReplaceChild("cube_r541", CubeListBuilder.create().texOffs(276, 23).addBox(-3.0F, -1.0F, -1.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, -0.075F, 15.2F, 1.5564F, -1.0911F, -1.5504F));

        PartDefinition cube_r542 = bone178.addOrReplaceChild("cube_r542", CubeListBuilder.create().texOffs(136, 240).addBox(-3.0F, -1.0F, -1.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 1.525F, 11.525F, 1.5708F, -1.3526F, -1.5708F));

        PartDefinition cube_r543 = bone178.addOrReplaceChild("cube_r543", CubeListBuilder.create().texOffs(118, 224).addBox(-3.0F, -1.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 1.75F, 5.65F, -1.5708F, -1.4399F, 1.5708F));

        PartDefinition cube_r544 = bone178.addOrReplaceChild("cube_r544", CubeListBuilder.create().texOffs(184, 53).addBox(-3.0F, -1.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 0.0F, 0.0F, -1.5708F, -1.0908F, 1.5708F));

        PartDefinition bone179 = bone176.addOrReplaceChild("bone179", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.5031F, -0.2396F, 7.5055F, 0.0F, 0.3927F, 0.0F));

        PartDefinition cube_r545 = bone179.addOrReplaceChild("cube_r545", CubeListBuilder.create().texOffs(276, 25).addBox(-3.0F, -1.0F, -1.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, -0.6354F, 7.6945F, 1.5564F, -1.0911F, -1.5504F));

        PartDefinition cube_r546 = bone179.addOrReplaceChild("cube_r546", CubeListBuilder.create().texOffs(136, 242).addBox(-3.0F, -1.0F, -1.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, 0.9646F, 4.0195F, 1.5708F, -1.3526F, -1.5708F));

        PartDefinition cube_r547 = bone179.addOrReplaceChild("cube_r547", CubeListBuilder.create().texOffs(132, 224).addBox(-3.0F, -1.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, 1.1896F, -1.8555F, -1.5708F, -1.4399F, 1.5708F));

        PartDefinition cube_r548 = bone179.addOrReplaceChild("cube_r548", CubeListBuilder.create().texOffs(194, 136).addBox(-3.0F, -1.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4969F, -0.5604F, -7.5055F, -1.5708F, -1.0908F, 1.5708F));

        PartDefinition arm14 = partdefinition.addOrReplaceChild("arm14", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition cube_r549 = arm14.addOrReplaceChild("cube_r549", CubeListBuilder.create().texOffs(0, 92).addBox(-17.5F, -9.0F, -9.0F, 36.0F, 18.0F, 18.0F, new CubeDeformation(0.0F))
                .texOffs(148, 246).addBox(11.5F, -11.0F, -11.0F, 2.0F, 22.0F, 22.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

        PartDefinition cube_r550 = arm14.addOrReplaceChild("cube_r550", CubeListBuilder.create().texOffs(146, 198).addBox(11.5F, -12.0F, -12.0F, 2.0F, 24.0F, 24.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 5.0F, 0.0F, -1.5708F, 0.0F));

        PartDefinition cube_r551 = arm14.addOrReplaceChild("cube_r551", CubeListBuilder.create().texOffs(246, 236).addBox(11.5F, -11.0F, -11.0F, 2.0F, 22.0F, 22.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -6.0F, 0.0F, -1.5708F, 0.0F));

        PartDefinition cube_r552 = arm14.addOrReplaceChild("cube_r552", CubeListBuilder.create().texOffs(254, 180).addBox(11.5F, -11.0F, -11.0F, 2.0F, 22.0F, 22.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -12.0F, 0.0F, -1.5708F, 0.0F));

        PartDefinition cube_r553 = arm14.addOrReplaceChild("cube_r553", CubeListBuilder.create().texOffs(260, 60).addBox(11.5F, -11.0F, -11.0F, 2.0F, 22.0F, 22.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -18.0F, 0.0F, -1.5708F, 0.0F));

        PartDefinition cube_r554 = arm14.addOrReplaceChild("cube_r554", CubeListBuilder.create().texOffs(48, 270).addBox(11.5F, -11.0F, -11.0F, 2.0F, 22.0F, 22.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -24.0F, 0.0F, -1.5708F, 0.0F));

        return LayerDefinition.create(meshdefinition, 512, 512);
    }


    public AetherionModel(ModelPart root) {
        // segment names. names of the folders containing the geometry of each animatable segment in blockbench
        super(root, new String[]
                {"arm", "arm2", "arm3",
                "arm4", "arm5", "arm6", "arm7",
                "arm8", "arm9", "arm10",
                "arm11", "arm12", "arm13", "arm14"});
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
    public void setupAnim(AetherionBoss entity, float pLimbSwing, float pLimbSwingAmount, float ageInTicks, float pNetHeadYaw, float pHeadPitch) {
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
            allSegments[i].xScale = AetherionRenderer.MODEL_SCALE;
            allSegments[i].yScale = AetherionRenderer.MODEL_SCALE;
            allSegments[i].zScale = AetherionRenderer.MODEL_SCALE;
        }

        // body parts
//        body.setRotation(0f, (float)Math.toRadians(entity.yBodyRot), 0f);
        body.setRotation((float)Math.toRadians(entity.getViewXRot(partialTicks)), (float)Math.toRadians(entity.yBodyRot), 0f);
        body.xScale = AetherionRenderer.MODEL_SCALE;
        body.yScale = AetherionRenderer.MODEL_SCALE;
        body.zScale = AetherionRenderer.MODEL_SCALE;
    }

}
