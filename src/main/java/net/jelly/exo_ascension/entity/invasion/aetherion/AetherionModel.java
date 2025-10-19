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

        PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(128, 0).addBox(-9.0F, -53.0F, -9.0F, 18.0F, 18.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 28.0F, 0.0F));

        PartDefinition cube_r1 = body.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 148).addBox(-10.0F, -4.0F, -7.0F, 20.0F, 6.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-20.0F, -38.5F, 0.0F, 0.0F, -1.5708F, 1.2654F));

        PartDefinition cube_r2 = body.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(94, 138).addBox(-10.0F, -4.0F, -7.0F, 20.0F, 6.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(20.0F, -38.5F, 0.0F, 0.0F, 1.5708F, -1.2654F));

        PartDefinition cube_r3 = body.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(0, 0).addBox(-12.0F, -12.0F, -20.0F, 24.0F, 16.0F, 40.0F, new CubeDeformation(0.0F))
                .texOffs(110, 56).addBox(-10.0F, 4.0F, -14.0F, 20.0F, 14.0F, 28.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -24.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

        PartDefinition bone = body.addOrReplaceChild("bone", CubeListBuilder.create(), PartPose.offset(0.0F, -32.0F, 0.0F));

        PartDefinition bone10 = bone.addOrReplaceChild("bone10", CubeListBuilder.create().texOffs(156, 162).addBox(-9.5F, -12.5F, -9.0F, 18.0F, 2.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -13.2F, 0.0F));

        PartDefinition cube_r4 = bone10.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(200, 0).addBox(-9.5F, -1.25F, -1.75F, 18.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -9.9F, -10.05F, 0.7854F, 0.0F, 0.0F));

        PartDefinition cube_r5 = bone10.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(116, 196).addBox(-9.5F, -1.25F, -1.75F, 18.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.6F, -11.4F, 1.5708F, 0.0F, 0.0F));

        PartDefinition cube_r6 = bone10.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(116, 182).addBox(-9.5F, -1.25F, -3.25F, 18.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.6F, 11.4F, -1.5708F, 0.0F, 0.0F));

        PartDefinition cube_r7 = bone10.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(116, 190).addBox(-9.5F, -1.25F, -1.75F, 18.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -9.9F, 10.05F, -0.7854F, 0.0F, 0.0F));

        PartDefinition bone3 = bone.addOrReplaceChild("bone3", CubeListBuilder.create(), PartPose.offset(5.4F, -22.5F, 0.0F));

        PartDefinition bone4 = bone3.addOrReplaceChild("bone4", CubeListBuilder.create().texOffs(164, 182).addBox(0.85F, 2.0F, -8.5F, 2.0F, 4.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.7854F));

        PartDefinition cube_r8 = bone4.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(0, 204).addBox(-1.25F, 2.0F, -1.75F, 2.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.75F, 0.0F, -8.55F, 0.0F, 0.7854F, 0.0F));

        PartDefinition cube_r9 = bone4.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(200, 30).addBox(-1.25F, 2.0F, -1.25F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.55F, 0.0F, 9.9F, 0.0F, -1.5708F, 0.0F));

        PartDefinition cube_r10 = bone4.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(64, 172).addBox(-1.25F, 2.0F, -1.75F, 2.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.75F, 0.0F, 8.55F, 0.0F, -0.7854F, 0.0F));

        PartDefinition bone8 = bone3.addOrReplaceChild("bone8", CubeListBuilder.create().texOffs(0, 172).addBox(-2.0F, -7.5F, -9.0F, 2.0F, 14.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offset(6.6F, 12.0F, 0.0F));

        PartDefinition cube_r11 = bone8.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(160, 202).addBox(-1.25F, -6.0F, -1.75F, 2.0F, 14.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.1F, -1.5F, -10.05F, 0.0F, 0.7854F, 0.0F));

        PartDefinition cube_r12 = bone8.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(116, 202).addBox(-1.25F, -2.0F, -3.75F, 2.0F, 10.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.4F, -1.5F, -11.4F, 0.0F, 1.5708F, 0.0F));

        PartDefinition cube_r13 = bone8.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(200, 6).addBox(-1.25F, -6.0F, -3.25F, 2.0F, 14.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.4F, -1.5F, 11.4F, 0.0F, -1.5708F, 0.0F));

        PartDefinition cube_r14 = bone8.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(148, 202).addBox(-1.25F, -6.0F, -1.75F, 2.0F, 14.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.1F, -1.5F, 10.05F, 0.0F, -0.7854F, 0.0F));

        PartDefinition bone5 = bone.addOrReplaceChild("bone5", CubeListBuilder.create(), PartPose.offset(-5.4F, -22.5F, 0.0F));

        PartDefinition bone6 = bone5.addOrReplaceChild("bone6", CubeListBuilder.create().texOffs(170, 138).addBox(-3.2293F, -4.0F, -8.4707F, 2.0F, 6.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.5138F, 3.1431F, -0.0293F, 0.0F, 0.0F, 0.3491F));

        PartDefinition cube_r15 = bone6.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(76, 148).addBox(-1.25F, 0.0F, -1.75F, 2.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.6293F, -4.0F, -8.5207F, 0.0F, -0.7854F, 0.0F));

        PartDefinition cube_r16 = bone6.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(12, 204).addBox(-1.25F, 0.0F, -1.25F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.6707F, -4.0F, 9.9293F, 0.0F, 1.5708F, 0.0F));

        PartDefinition cube_r17 = bone6.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(94, 128).addBox(-1.25F, 0.0F, -1.75F, 2.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.6293F, -4.0F, 8.5793F, 0.0F, 0.7854F, 0.0F));

        PartDefinition bone7 = bone5.addOrReplaceChild("bone7", CubeListBuilder.create().texOffs(40, 182).addBox(-0.5F, -7.5F, -9.0F, 2.0F, 14.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offset(-6.6F, 12.0F, 0.0F));

        PartDefinition cube_r18 = bone7.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(184, 202).addBox(-1.25F, -6.0F, -1.75F, 2.0F, 14.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1F, -1.5F, -10.05F, 0.0F, -0.7854F, 0.0F));

        PartDefinition cube_r19 = bone7.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(132, 202).addBox(-1.25F, -2.0F, -3.75F, 2.0F, 10.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.4F, -1.5F, -11.4F, 0.0F, -1.5708F, 0.0F));

        PartDefinition cube_r20 = bone7.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(200, 182).addBox(-1.25F, -6.0F, -3.25F, 2.0F, 14.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.4F, -1.5F, 11.4F, 0.0F, 1.5708F, 0.0F));

        PartDefinition cube_r21 = bone7.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(172, 202).addBox(-1.25F, -6.0F, -1.75F, 2.0F, 14.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1F, -1.5F, 10.05F, 0.0F, 0.7854F, 0.0F));

        PartDefinition bone2 = bone5.addOrReplaceChild("bone2", CubeListBuilder.create().texOffs(80, 182).addBox(1.2293F, -4.0F, -8.4707F, 2.0F, 6.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(14.3138F, 3.1431F, -0.0293F, 0.0F, 0.0F, -0.3491F));

        PartDefinition cube_r22 = bone2.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(52, 172).addBox(-0.75F, 0.0F, -1.75F, 2.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.6293F, -4.0F, -8.5207F, 0.0F, 0.7854F, 0.0F));

        PartDefinition cube_r23 = bone2.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(20, 204).addBox(-0.75F, 0.0F, -1.25F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.6707F, -4.0F, 9.9293F, 0.0F, -1.5708F, 0.0F));

        PartDefinition cube_r24 = bone2.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(40, 172).addBox(-0.75F, 0.0F, -1.75F, 2.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.6293F, -4.0F, 8.5793F, 0.0F, -0.7854F, 0.0F));

        PartDefinition arm = partdefinition.addOrReplaceChild("arm", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition cube_r25 = arm.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(110, 98).addBox(-18.5F, -5.0F, -5.0F, 37.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

        PartDefinition arm2 = partdefinition.addOrReplaceChild("arm2", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition cube_r26 = arm2.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(110, 118).addBox(-18.5F, -5.0F, -5.0F, 37.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

        PartDefinition arm3 = partdefinition.addOrReplaceChild("arm3", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition cube_r27 = arm3.addOrReplaceChild("cube_r27", CubeListBuilder.create().texOffs(0, 56).addBox(-18.5F, -9.0F, -9.0F, 37.0F, 18.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

        PartDefinition arm4 = partdefinition.addOrReplaceChild("arm4", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition cube_r28 = arm4.addOrReplaceChild("cube_r28", CubeListBuilder.create().texOffs(128, 36).addBox(-15.0F, -5.0F, -5.0F, 30.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

        PartDefinition arm5 = partdefinition.addOrReplaceChild("arm5", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition cube_r29 = arm5.addOrReplaceChild("cube_r29", CubeListBuilder.create().texOffs(76, 162).addBox(-15.0F, -5.0F, -5.0F, 30.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

        PartDefinition arm6 = partdefinition.addOrReplaceChild("arm6", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition cube_r30 = arm6.addOrReplaceChild("cube_r30", CubeListBuilder.create().texOffs(0, 128).addBox(-18.0F, -5.0F, -5.0F, 37.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

        PartDefinition arm7 = partdefinition.addOrReplaceChild("arm7", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition cube_r31 = arm7.addOrReplaceChild("cube_r31", CubeListBuilder.create().texOffs(0, 92).addBox(-18.5F, -9.0F, -9.0F, 37.0F, 18.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

        PartDefinition arm8 = partdefinition.addOrReplaceChild("arm8", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition cube_r32 = arm8.addOrReplaceChild("cube_r32", CubeListBuilder.create().texOffs(110, 98).addBox(-18.5F, -5.0F, -5.0F, 37.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

        PartDefinition arm9 = partdefinition.addOrReplaceChild("arm9", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition cube_r33 = arm9.addOrReplaceChild("cube_r33", CubeListBuilder.create().texOffs(110, 118).addBox(-18.5F, -5.0F, -5.0F, 37.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

        PartDefinition arm10 = partdefinition.addOrReplaceChild("arm10", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition cube_r34 = arm10.addOrReplaceChild("cube_r34", CubeListBuilder.create().texOffs(0, 56).addBox(-18.5F, -9.0F, -9.0F, 37.0F, 18.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

        PartDefinition arm11 = partdefinition.addOrReplaceChild("arm11", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition cube_r35 = arm11.addOrReplaceChild("cube_r35", CubeListBuilder.create().texOffs(128, 36).addBox(-15.0F, -5.0F, -5.0F, 30.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

        PartDefinition arm12 = partdefinition.addOrReplaceChild("arm12", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition cube_r36 = arm12.addOrReplaceChild("cube_r36", CubeListBuilder.create().texOffs(76, 162).addBox(-15.0F, -5.0F, -5.0F, 30.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

        PartDefinition arm13 = partdefinition.addOrReplaceChild("arm13", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition cube_r37 = arm13.addOrReplaceChild("cube_r37", CubeListBuilder.create().texOffs(0, 128).addBox(-18.0F, -5.0F, -5.0F, 37.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

        PartDefinition arm14 = partdefinition.addOrReplaceChild("arm14", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition cube_r38 = arm14.addOrReplaceChild("cube_r38", CubeListBuilder.create().texOffs(0, 92).addBox(-18.5F, -9.0F, -9.0F, 37.0F, 18.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

        return LayerDefinition.create(meshdefinition, 256, 256);
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
