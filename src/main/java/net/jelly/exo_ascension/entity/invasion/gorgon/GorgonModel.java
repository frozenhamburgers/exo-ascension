package net.jelly.exo_ascension.entity.invasion.gorgon;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.jelly.exo_ascension.utility.AbstractPartEntity;
import net.jelly.exo_ascension.utility.MultipartModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.phys.Vec3;

public class GorgonModel extends MultipartModel<GorgonEntity> {
    private final ModelPart body;

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-12.0F, -14.0F, -12.0F, 24.0F, 24.0F, 24.0F, new CubeDeformation(0.0F))
                .texOffs(0, 92).addBox(-12.0F, -16.0F, -10.0F, 24.0F, 28.0F, 20.0F, new CubeDeformation(0.0F))
                .texOffs(0, 48).addBox(-14.0F, -14.0F, -10.0F, 28.0F, 24.0F, 20.0F, new CubeDeformation(0.0F))
                .texOffs(88, 92).addBox(-18.0F, -7.0F, -5.0F, 36.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 10.0F, 0.0F));

        PartDefinition bone = body.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(96, 0).addBox(-14.0F, 1.0F, -10.0F, 10.0F, 2.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offset(9.0F, -19.0F, 0.0F));

        PartDefinition cube_r1 = bone.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(142, 112).addBox(-5.0F, -1.0F, -3.0F, 10.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.0F, 6.75F, -13.2F, 1.5708F, 0.0F, 0.0F));

        PartDefinition cube_r2 = bone.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(150, 58).addBox(-5.0F, -1.0F, -2.0F, 10.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.0F, 3.5F, -12.0F, 0.6109F, 0.0F, 0.0F));

        PartDefinition bone2 = body.addOrReplaceChild("bone2", CubeListBuilder.create().texOffs(96, 44).addBox(-3.5F, -2.9877F, -18.2635F, 7.0F, 2.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(11.5F, -13.0123F, 8.2635F, 0.0F, 0.0F, 0.3491F));

        PartDefinition cube_r3 = bone2.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(156, 28).addBox(-5.0F, -1.0F, -3.0F, 7.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, 2.7623F, -21.4635F, 1.5708F, 0.0F, 0.0F));

        PartDefinition cube_r4 = bone2.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(88, 164).addBox(-5.0F, -1.0F, -2.0F, 7.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, -0.4877F, -20.2635F, 0.6109F, 0.0F, 0.0F));

        PartDefinition bone3 = body.addOrReplaceChild("bone3", CubeListBuilder.create().texOffs(96, 66).addBox(-3.5F, -2.9877F, -1.7365F, 7.0F, 2.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-11.5F, -13.0123F, -8.2635F, 0.0F, 0.0F, -0.3491F));

        PartDefinition cube_r5 = bone3.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(156, 36).addBox(-2.0F, -1.0F, -3.0F, 7.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5F, 2.7623F, -4.9365F, 1.5708F, 0.0F, 0.0F));

        PartDefinition cube_r6 = bone3.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(112, 164).addBox(-2.0F, -1.0F, -2.0F, 7.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5F, -0.4877F, -3.7365F, 0.6109F, 0.0F, 0.0F));

        PartDefinition bone4 = body.addOrReplaceChild("bone4", CubeListBuilder.create().texOffs(88, 112).addBox(-3.5F, 0.9877F, -1.7365F, 7.0F, 2.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-11.5F, 9.0123F, -8.2635F, 0.0F, 0.0F, 0.3491F));

        PartDefinition cube_r7 = bone4.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(88, 156).addBox(-2.0F, -1.0F, -3.0F, 7.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5F, -2.7623F, -4.9365F, -1.5708F, 0.0F, 0.0F));

        PartDefinition cube_r8 = bone4.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(136, 164).addBox(-2.0F, -1.0F, -2.0F, 7.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5F, 0.4877F, -3.7365F, -0.6109F, 0.0F, 0.0F));

        PartDefinition bone5 = body.addOrReplaceChild("bone5", CubeListBuilder.create().texOffs(96, 22).addBox(-5.0F, 0.9877F, -1.7365F, 10.0F, 2.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 11.0123F, -8.2635F));

        PartDefinition cube_r9 = bone5.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(142, 120).addBox(-5.0F, -1.0F, -3.0F, 10.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.7623F, -4.9365F, -1.5708F, 0.0F, 0.0F));

        PartDefinition cube_r10 = bone5.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(150, 65).addBox(-5.0F, -1.0F, -2.0F, 10.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.4877F, -3.7365F, -0.6109F, 0.0F, 0.0F));

        PartDefinition bone6 = body.addOrReplaceChild("bone6", CubeListBuilder.create().texOffs(88, 134).addBox(-3.5F, 0.9877F, -1.7365F, 7.0F, 2.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(11.5F, 9.0123F, -8.2635F, 0.0F, 0.0F, -0.3491F));

        PartDefinition cube_r11 = bone6.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(114, 156).addBox(-5.0F, -1.0F, -3.0F, 7.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, -2.7623F, -4.9365F, -1.5708F, 0.0F, 0.0F));

        PartDefinition cube_r12 = bone6.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(140, 157).addBox(-5.0F, -1.0F, -2.0F, 7.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, 0.4877F, -3.7365F, -0.6109F, 0.0F, 0.0F));

        PartDefinition bone7 = body.addOrReplaceChild("bone7", CubeListBuilder.create().texOffs(0, 140).addBox(0.9877F, -4.0F, -1.7365F, 2.0F, 8.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offset(12.0F, -2.0123F, -8.2635F));

        PartDefinition cube_r13 = bone7.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(14, 168).addBox(-1.0F, -4.0F, -2.0F, 2.0F, 8.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.7623F, 0.0F, -4.9365F, 0.0F, 1.5708F, 0.0F));

        PartDefinition cube_r14 = bone7.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(0, 168).addBox(-1.0F, -4.0F, -2.0F, 2.0F, 8.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.4877F, 0.0F, -3.7365F, 0.0F, 0.6109F, 0.0F));

        PartDefinition bone8 = body.addOrReplaceChild("bone8", CubeListBuilder.create().texOffs(44, 140).addBox(-30.8211F, -4.0F, -18.2635F, 2.0F, 8.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offset(15.8333F, -2.0123F, 8.2635F));

        PartDefinition cube_r15 = bone8.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(42, 168).addBox(-1.0F, -4.0F, -2.0F, 2.0F, 8.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-25.0711F, 0.0F, -21.4635F, 0.0F, -1.5708F, 0.0F));

        PartDefinition cube_r16 = bone8.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(28, 168).addBox(-1.0F, -4.0F, -2.0F, 2.0F, 8.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-28.3211F, 0.0F, -20.2635F, 0.0F, -0.6109F, 0.0F));

        PartDefinition bone9 = body.addOrReplaceChild("bone9", CubeListBuilder.create().texOffs(150, 72).addBox(-16.0F, -15.0F, -5.0F, 12.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(150, 82).addBox(-16.0F, -1.0F, -5.0F, 12.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(10.0F, 5.0F, -10.0F));

        PartDefinition cube_r17 = bone9.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(150, 77).addBox(-6.0F, -1.0F, -1.5F, 12.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -7.0F, -3.5F, 0.0F, 0.0F, 1.5708F));

        PartDefinition cube_r18 = bone9.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(150, 87).addBox(-6.0F, -1.0F, -1.5F, 12.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-17.0F, -7.0F, -3.5F, 0.0F, 0.0F, 1.5708F));

        PartDefinition t1 = partdefinition.addOrReplaceChild("t1", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition cube_r19 = t1.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(142, 128).addBox(-6.0F, 9.0F, 3.0F, 6.0F, 9.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 6.0F, -14.0F, 1.5708F, 0.0F, 0.0F));

        PartDefinition t2 = partdefinition.addOrReplaceChild("t2", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition cube_r20 = t2.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(142, 143).addBox(-6.0F, 10.0F, 3.0F, 6.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 6.0F, -14.0F, 1.5708F, 0.0F, 0.0F));

        PartDefinition t3 = partdefinition.addOrReplaceChild("t3", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition cube_r21 = t3.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(150, 44).addBox(-6.0F, 10.0F, 3.0F, 6.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 6.0F, -14.0F, 1.5708F, 0.0F, 0.0F));

        PartDefinition t4 = partdefinition.addOrReplaceChild("t4", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition cube_r22 = t4.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(156, 0).addBox(-5.0F, 10.0F, 3.0F, 4.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 6.0F, -14.0F, 1.5708F, 0.0F, 0.0F));

        PartDefinition t5 = partdefinition.addOrReplaceChild("t5", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition cube_r23 = t5.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(156, 14).addBox(-5.0F, 10.0F, 3.0F, 4.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 6.0F, -14.0F, 1.5708F, 0.0F, 0.0F));

        PartDefinition t6 = partdefinition.addOrReplaceChild("t6", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition cube_r24 = t6.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(164, 157).addBox(-5.0F, 10.0F, 4.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 6.0F, -14.0F, 1.5708F, 0.0F, 0.0F));

        PartDefinition t7 = partdefinition.addOrReplaceChild("t7", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition cube_r25 = t7.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(166, 128).addBox(-2.0F, -4.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.5708F, 0.0F, 0.0F));

        PartDefinition t8 = partdefinition.addOrReplaceChild("t8", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition cube_r26 = t8.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(166, 140).addBox(-2.0F, -4.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.5708F, 0.0F, 0.0F));

        PartDefinition t9 = partdefinition.addOrReplaceChild("t9", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition cube_r27 = t9.addOrReplaceChild("cube_r27", CubeListBuilder.create().texOffs(56, 168).addBox(-4.0F, 10.0F, 4.0F, 2.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 6.0F, -14.0F, 1.5708F, 0.0F, 0.0F));

        PartDefinition t10 = partdefinition.addOrReplaceChild("t10", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition cube_r28 = t10.addOrReplaceChild("cube_r28", CubeListBuilder.create().texOffs(68, 168).addBox(-4.0F, 10.0F, 5.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 6.0F, -14.0F, 1.5708F, 0.0F, 0.0F));

        PartDefinition t11 = partdefinition.addOrReplaceChild("t11", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition cube_r29 = t11.addOrReplaceChild("cube_r29", CubeListBuilder.create().texOffs(76, 168).addBox(-4.0F, 10.0F, 5.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 6.0F, -14.0F, 1.5708F, 0.0F, 0.0F));

        PartDefinition t12 = partdefinition.addOrReplaceChild("t12", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition cube_r30 = t12.addOrReplaceChild("cube_r30", CubeListBuilder.create().texOffs(142, 128).addBox(-6.0F, 9.0F, 3.0F, 6.0F, 9.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 6.0F, -14.0F, 1.5708F, 0.0F, 0.0F));

        PartDefinition t13 = partdefinition.addOrReplaceChild("t13", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition cube_r31 = t13.addOrReplaceChild("cube_r31", CubeListBuilder.create().texOffs(142, 143).addBox(-6.0F, 10.0F, 3.0F, 6.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 6.0F, -14.0F, 1.5708F, 0.0F, 0.0F));

        PartDefinition t14 = partdefinition.addOrReplaceChild("t14", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition cube_r32 = t14.addOrReplaceChild("cube_r32", CubeListBuilder.create().texOffs(150, 44).addBox(-6.0F, 10.0F, 3.0F, 6.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 6.0F, -14.0F, 1.5708F, 0.0F, 0.0F));

        PartDefinition t15 = partdefinition.addOrReplaceChild("t15", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition cube_r33 = t15.addOrReplaceChild("cube_r33", CubeListBuilder.create().texOffs(156, 0).addBox(-5.0F, 10.0F, 3.0F, 4.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 6.0F, -14.0F, 1.5708F, 0.0F, 0.0F));

        PartDefinition t16 = partdefinition.addOrReplaceChild("t16", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition cube_r34 = t16.addOrReplaceChild("cube_r34", CubeListBuilder.create().texOffs(156, 14).addBox(-5.0F, 10.0F, 3.0F, 4.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 6.0F, -14.0F, 1.5708F, 0.0F, 0.0F));

        PartDefinition t17 = partdefinition.addOrReplaceChild("t17", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition cube_r35 = t17.addOrReplaceChild("cube_r35", CubeListBuilder.create().texOffs(164, 157).addBox(-5.0F, 10.0F, 4.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 6.0F, -14.0F, 1.5708F, 0.0F, 0.0F));

        PartDefinition t18 = partdefinition.addOrReplaceChild("t18", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition cube_r36 = t18.addOrReplaceChild("cube_r36", CubeListBuilder.create().texOffs(166, 128).addBox(-2.0F, -4.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.5708F, 0.0F, 0.0F));

        PartDefinition t19 = partdefinition.addOrReplaceChild("t19", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition cube_r37 = t19.addOrReplaceChild("cube_r37", CubeListBuilder.create().texOffs(166, 140).addBox(-2.0F, -4.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.5708F, 0.0F, 0.0F));

        PartDefinition t20 = partdefinition.addOrReplaceChild("t20", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition cube_r38 = t20.addOrReplaceChild("cube_r38", CubeListBuilder.create().texOffs(56, 168).addBox(-4.0F, 10.0F, 4.0F, 2.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 6.0F, -14.0F, 1.5708F, 0.0F, 0.0F));

        PartDefinition t21 = partdefinition.addOrReplaceChild("t21", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition cube_r39 = t21.addOrReplaceChild("cube_r39", CubeListBuilder.create().texOffs(68, 168).addBox(-4.0F, 10.0F, 5.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 6.0F, -14.0F, 1.5708F, 0.0F, 0.0F));

        PartDefinition t22 = partdefinition.addOrReplaceChild("t22", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition cube_r40 = t22.addOrReplaceChild("cube_r40", CubeListBuilder.create().texOffs(76, 168).addBox(-4.0F, 10.0F, 5.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 6.0F, -14.0F, 1.5708F, 0.0F, 0.0F));

        PartDefinition t23 = partdefinition.addOrReplaceChild("t23", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition cube_r41 = t23.addOrReplaceChild("cube_r41", CubeListBuilder.create().texOffs(142, 128).addBox(-6.0F, 9.0F, 3.0F, 6.0F, 9.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 6.0F, -14.0F, 1.5708F, 0.0F, 0.0F));

        PartDefinition t24 = partdefinition.addOrReplaceChild("t24", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition cube_r42 = t24.addOrReplaceChild("cube_r42", CubeListBuilder.create().texOffs(142, 143).addBox(-6.0F, 10.0F, 3.0F, 6.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 6.0F, -14.0F, 1.5708F, 0.0F, 0.0F));

        PartDefinition t25 = partdefinition.addOrReplaceChild("t25", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition cube_r43 = t25.addOrReplaceChild("cube_r43", CubeListBuilder.create().texOffs(150, 44).addBox(-6.0F, 10.0F, 3.0F, 6.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 6.0F, -14.0F, 1.5708F, 0.0F, 0.0F));

        PartDefinition t26 = partdefinition.addOrReplaceChild("t26", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition cube_r44 = t26.addOrReplaceChild("cube_r44", CubeListBuilder.create().texOffs(156, 0).addBox(-5.0F, 10.0F, 3.0F, 4.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 6.0F, -14.0F, 1.5708F, 0.0F, 0.0F));

        PartDefinition t27 = partdefinition.addOrReplaceChild("t27", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition cube_r45 = t27.addOrReplaceChild("cube_r45", CubeListBuilder.create().texOffs(156, 14).addBox(-5.0F, 10.0F, 3.0F, 4.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 6.0F, -14.0F, 1.5708F, 0.0F, 0.0F));

        PartDefinition t28 = partdefinition.addOrReplaceChild("t28", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition cube_r46 = t28.addOrReplaceChild("cube_r46", CubeListBuilder.create().texOffs(164, 157).addBox(-5.0F, 10.0F, 4.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 6.0F, -14.0F, 1.5708F, 0.0F, 0.0F));

        PartDefinition t29 = partdefinition.addOrReplaceChild("t29", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition cube_r47 = t29.addOrReplaceChild("cube_r47", CubeListBuilder.create().texOffs(166, 128).addBox(-2.0F, -4.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.5708F, 0.0F, 0.0F));

        PartDefinition t30 = partdefinition.addOrReplaceChild("t30", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition cube_r48 = t30.addOrReplaceChild("cube_r48", CubeListBuilder.create().texOffs(166, 140).addBox(-2.0F, -4.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.5708F, 0.0F, 0.0F));

        PartDefinition t31 = partdefinition.addOrReplaceChild("t31", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition cube_r49 = t31.addOrReplaceChild("cube_r49", CubeListBuilder.create().texOffs(56, 168).addBox(-4.0F, 10.0F, 4.0F, 2.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 6.0F, -14.0F, 1.5708F, 0.0F, 0.0F));

        PartDefinition t32 = partdefinition.addOrReplaceChild("t32", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition cube_r50 = t32.addOrReplaceChild("cube_r50", CubeListBuilder.create().texOffs(68, 168).addBox(-4.0F, 10.0F, 5.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 6.0F, -14.0F, 1.5708F, 0.0F, 0.0F));

        PartDefinition t33 = partdefinition.addOrReplaceChild("t33", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition cube_r51 = t33.addOrReplaceChild("cube_r51", CubeListBuilder.create().texOffs(76, 168).addBox(-4.0F, 10.0F, 5.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 6.0F, -14.0F, 1.5708F, 0.0F, 0.0F));

        PartDefinition t34 = partdefinition.addOrReplaceChild("t34", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition cube_r52 = t34.addOrReplaceChild("cube_r52", CubeListBuilder.create().texOffs(142, 128).addBox(-6.0F, 9.0F, 3.0F, 6.0F, 9.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 6.0F, -14.0F, 1.5708F, 0.0F, 0.0F));

        PartDefinition t35 = partdefinition.addOrReplaceChild("t35", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition cube_r53 = t35.addOrReplaceChild("cube_r53", CubeListBuilder.create().texOffs(142, 143).addBox(-6.0F, 10.0F, 3.0F, 6.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 6.0F, -14.0F, 1.5708F, 0.0F, 0.0F));

        PartDefinition t36 = partdefinition.addOrReplaceChild("t36", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition cube_r54 = t36.addOrReplaceChild("cube_r54", CubeListBuilder.create().texOffs(150, 44).addBox(-6.0F, 10.0F, 3.0F, 6.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 6.0F, -14.0F, 1.5708F, 0.0F, 0.0F));

        PartDefinition t37 = partdefinition.addOrReplaceChild("t37", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition cube_r55 = t37.addOrReplaceChild("cube_r55", CubeListBuilder.create().texOffs(156, 0).addBox(-5.0F, 10.0F, 3.0F, 4.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 6.0F, -14.0F, 1.5708F, 0.0F, 0.0F));

        PartDefinition t38 = partdefinition.addOrReplaceChild("t38", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition cube_r56 = t38.addOrReplaceChild("cube_r56", CubeListBuilder.create().texOffs(156, 14).addBox(-5.0F, 10.0F, 3.0F, 4.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 6.0F, -14.0F, 1.5708F, 0.0F, 0.0F));

        PartDefinition t39 = partdefinition.addOrReplaceChild("t39", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition cube_r57 = t39.addOrReplaceChild("cube_r57", CubeListBuilder.create().texOffs(164, 157).addBox(-5.0F, 10.0F, 4.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 6.0F, -14.0F, 1.5708F, 0.0F, 0.0F));

        PartDefinition t40 = partdefinition.addOrReplaceChild("t40", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition cube_r58 = t40.addOrReplaceChild("cube_r58", CubeListBuilder.create().texOffs(166, 128).addBox(-2.0F, -4.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.5708F, 0.0F, 0.0F));

        PartDefinition t41 = partdefinition.addOrReplaceChild("t41", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition cube_r59 = t41.addOrReplaceChild("cube_r59", CubeListBuilder.create().texOffs(166, 140).addBox(-2.0F, -4.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.5708F, 0.0F, 0.0F));

        PartDefinition t42 = partdefinition.addOrReplaceChild("t42", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition cube_r60 = t42.addOrReplaceChild("cube_r60", CubeListBuilder.create().texOffs(56, 168).addBox(-4.0F, 10.0F, 4.0F, 2.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 6.0F, -14.0F, 1.5708F, 0.0F, 0.0F));

        PartDefinition t43 = partdefinition.addOrReplaceChild("t43", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition cube_r61 = t43.addOrReplaceChild("cube_r61", CubeListBuilder.create().texOffs(68, 168).addBox(-4.0F, 10.0F, 5.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 6.0F, -14.0F, 1.5708F, 0.0F, 0.0F));

        PartDefinition t44 = partdefinition.addOrReplaceChild("t44", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition cube_r62 = t44.addOrReplaceChild("cube_r62", CubeListBuilder.create().texOffs(76, 168).addBox(-4.0F, 10.0F, 5.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 6.0F, -14.0F, 1.5708F, 0.0F, 0.0F));

        PartDefinition t45 = partdefinition.addOrReplaceChild("t45", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition cube_r63 = t45.addOrReplaceChild("cube_r63", CubeListBuilder.create().texOffs(142, 128).addBox(-6.0F, 9.0F, 3.0F, 6.0F, 9.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 6.0F, -14.0F, 1.5708F, 0.0F, 0.0F));

        PartDefinition t46 = partdefinition.addOrReplaceChild("t46", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition cube_r64 = t46.addOrReplaceChild("cube_r64", CubeListBuilder.create().texOffs(142, 143).addBox(-6.0F, 10.0F, 3.0F, 6.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 6.0F, -14.0F, 1.5708F, 0.0F, 0.0F));

        PartDefinition t47 = partdefinition.addOrReplaceChild("t47", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition cube_r65 = t47.addOrReplaceChild("cube_r65", CubeListBuilder.create().texOffs(150, 44).addBox(-6.0F, 10.0F, 3.0F, 6.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 6.0F, -14.0F, 1.5708F, 0.0F, 0.0F));

        PartDefinition t48 = partdefinition.addOrReplaceChild("t48", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition cube_r66 = t48.addOrReplaceChild("cube_r66", CubeListBuilder.create().texOffs(156, 0).addBox(-5.0F, 10.0F, 3.0F, 4.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 6.0F, -14.0F, 1.5708F, 0.0F, 0.0F));

        PartDefinition t49 = partdefinition.addOrReplaceChild("t49", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition cube_r67 = t49.addOrReplaceChild("cube_r67", CubeListBuilder.create().texOffs(156, 14).addBox(-5.0F, 10.0F, 3.0F, 4.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 6.0F, -14.0F, 1.5708F, 0.0F, 0.0F));

        PartDefinition t50 = partdefinition.addOrReplaceChild("t50", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition cube_r68 = t50.addOrReplaceChild("cube_r68", CubeListBuilder.create().texOffs(164, 157).addBox(-5.0F, 10.0F, 4.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 6.0F, -14.0F, 1.5708F, 0.0F, 0.0F));

        PartDefinition t51 = partdefinition.addOrReplaceChild("t51", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition cube_r69 = t51.addOrReplaceChild("cube_r69", CubeListBuilder.create().texOffs(166, 128).addBox(-2.0F, -4.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.5708F, 0.0F, 0.0F));

        PartDefinition t52 = partdefinition.addOrReplaceChild("t52", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition cube_r70 = t52.addOrReplaceChild("cube_r70", CubeListBuilder.create().texOffs(166, 140).addBox(-2.0F, -4.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.5708F, 0.0F, 0.0F));

        PartDefinition t53 = partdefinition.addOrReplaceChild("t53", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition cube_r71 = t53.addOrReplaceChild("cube_r71", CubeListBuilder.create().texOffs(56, 168).addBox(-4.0F, 10.0F, 4.0F, 2.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 6.0F, -14.0F, 1.5708F, 0.0F, 0.0F));

        PartDefinition t54 = partdefinition.addOrReplaceChild("t54", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition cube_r72 = t54.addOrReplaceChild("cube_r72", CubeListBuilder.create().texOffs(68, 168).addBox(-4.0F, 10.0F, 5.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 6.0F, -14.0F, 1.5708F, 0.0F, 0.0F));

        PartDefinition t55 = partdefinition.addOrReplaceChild("t55", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition cube_r73 = t55.addOrReplaceChild("cube_r73", CubeListBuilder.create().texOffs(76, 168).addBox(-4.0F, 10.0F, 5.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 6.0F, -14.0F, 1.5708F, 0.0F, 0.0F));

        PartDefinition t56 = partdefinition.addOrReplaceChild("t56", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition cube_r74 = t56.addOrReplaceChild("cube_r74", CubeListBuilder.create().texOffs(142, 128).addBox(-6.0F, 9.0F, 3.0F, 6.0F, 9.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 6.0F, -14.0F, 1.5708F, 0.0F, 0.0F));

        PartDefinition t57 = partdefinition.addOrReplaceChild("t57", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition cube_r75 = t57.addOrReplaceChild("cube_r75", CubeListBuilder.create().texOffs(142, 143).addBox(-6.0F, 10.0F, 3.0F, 6.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 6.0F, -14.0F, 1.5708F, 0.0F, 0.0F));

        PartDefinition t58 = partdefinition.addOrReplaceChild("t58", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition cube_r76 = t58.addOrReplaceChild("cube_r76", CubeListBuilder.create().texOffs(150, 44).addBox(-6.0F, 10.0F, 3.0F, 6.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 6.0F, -14.0F, 1.5708F, 0.0F, 0.0F));

        PartDefinition t59 = partdefinition.addOrReplaceChild("t59", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition cube_r77 = t59.addOrReplaceChild("cube_r77", CubeListBuilder.create().texOffs(156, 0).addBox(-5.0F, 10.0F, 3.0F, 4.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 6.0F, -14.0F, 1.5708F, 0.0F, 0.0F));

        PartDefinition t60 = partdefinition.addOrReplaceChild("t60", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition cube_r78 = t60.addOrReplaceChild("cube_r78", CubeListBuilder.create().texOffs(156, 14).addBox(-5.0F, 10.0F, 3.0F, 4.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 6.0F, -14.0F, 1.5708F, 0.0F, 0.0F));

        PartDefinition t61 = partdefinition.addOrReplaceChild("t61", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition cube_r79 = t61.addOrReplaceChild("cube_r79", CubeListBuilder.create().texOffs(164, 157).addBox(-5.0F, 10.0F, 4.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 6.0F, -14.0F, 1.5708F, 0.0F, 0.0F));

        PartDefinition t62 = partdefinition.addOrReplaceChild("t62", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition cube_r80 = t62.addOrReplaceChild("cube_r80", CubeListBuilder.create().texOffs(166, 128).addBox(-2.0F, -4.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.5708F, 0.0F, 0.0F));

        PartDefinition t63 = partdefinition.addOrReplaceChild("t63", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition cube_r81 = t63.addOrReplaceChild("cube_r81", CubeListBuilder.create().texOffs(166, 140).addBox(-2.0F, -4.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.5708F, 0.0F, 0.0F));

        PartDefinition t64 = partdefinition.addOrReplaceChild("t64", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition cube_r82 = t64.addOrReplaceChild("cube_r82", CubeListBuilder.create().texOffs(56, 168).addBox(-4.0F, 10.0F, 4.0F, 2.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 6.0F, -14.0F, 1.5708F, 0.0F, 0.0F));

        PartDefinition t65 = partdefinition.addOrReplaceChild("t65", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition cube_r83 = t65.addOrReplaceChild("cube_r83", CubeListBuilder.create().texOffs(68, 168).addBox(-4.0F, 10.0F, 5.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 6.0F, -14.0F, 1.5708F, 0.0F, 0.0F));

        PartDefinition t66 = partdefinition.addOrReplaceChild("t66", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition cube_r84 = t66.addOrReplaceChild("cube_r84", CubeListBuilder.create().texOffs(76, 168).addBox(-4.0F, 10.0F, 5.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 6.0F, -14.0F, 1.5708F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 256, 256);
    }



    public GorgonModel(ModelPart root) {
        // segment names. names of the folders containing the geometry of each animatable segment in blockbench
        super(root, new String[]
                {"t1", "t2", "t3", "t4", "t5", "t6", "t7", "t8", "t9", "t10", "t11",
                        "t12", "t13", "t14", "t15", "t16", "t17", "t18", "t19", "t20", "t21", "t22",
                        "t23", "t24", "t25", "t26", "t27", "t28", "t29", "t30", "t31", "t32", "t33",
                        "t34", "t35", "t36", "t37", "t38", "t39", "t40", "t41", "t42", "t43", "t44",
                        "t45", "t46", "t47", "t48", "t49", "t50", "t51", "t52", "t53", "t54", "t55",
                        "t56", "t57", "t58", "t59", "t60", "t61", "t62", "t63", "t64", "t65", "t66", });
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
    public void setupAnim(GorgonEntity entity, float pLimbSwing, float pLimbSwingAmount, float ageInTicks, float pNetHeadYaw, float pHeadPitch) {
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
        body.setRotation((float)Math.toRadians(entity.getViewXRot(partialTicks)), (float)Math.toRadians(entity.yBodyRot), 0f);
    }

}
