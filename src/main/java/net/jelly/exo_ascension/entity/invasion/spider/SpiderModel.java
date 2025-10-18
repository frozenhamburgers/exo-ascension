package net.jelly.exo_ascension.entity.invasion.spider;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.jelly.exo_ascension.utility.AbstractPartEntity;
import net.jelly.exo_ascension.utility.MultipartModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.phys.Vec3;

public class SpiderModel extends MultipartModel<SpiderEntity> {
    private final ModelPart body;

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-8.0F, -8.0F, -8.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 16.0F, 0.0F));

        // arm 1
        PartDefinition arm11 = partdefinition.addOrReplaceChild("arm11", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition cube_r11 = arm11.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(0, 32).addBox(-3.0F, -10.5F, -3.0F, 6.0F, 21.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.5708F, 0.0F, 0.0F));

        PartDefinition arm12 = partdefinition.addOrReplaceChild("arm12", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition cube_r12 = arm12.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(40, 54).addBox(-2.0F, -2.0F, -1.0F, 4.0F, 18.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, -7.0F, 1.5708F, 0.0F, 0.0F));

        PartDefinition arm13 = partdefinition.addOrReplaceChild("arm13", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition cube_r13 = arm13.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(40, 32).addBox(-2.0F, -2.0F, -1.0F, 4.0F, 18.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, -7.0F, 1.5708F, 0.0F, 0.0F));

        PartDefinition arm14 = partdefinition.addOrReplaceChild("arm14", CubeListBuilder.create(), PartPose.offset(0.0F, 23.9858F, -0.1662F));

        PartDefinition cube_r14 = arm14.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(24, 32).addBox(-2.0F, -9.0F, -2.0F, 4.0F, 19.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -0.5F, 1.5708F, 0.0F, 0.0F));

        // arm 2
        PartDefinition arm21 = partdefinition.addOrReplaceChild("arm21", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition cube_r21 = arm21.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(0, 32).addBox(-3.0F, -10.5F, -3.0F, 6.0F, 21.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.5708F, 0.0F, 0.0F));

        PartDefinition arm22 = partdefinition.addOrReplaceChild("arm22", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition cube_r22 = arm22.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(40, 54).addBox(-2.0F, -2.0F, -1.0F, 4.0F, 18.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, -7.0F, 1.5708F, 0.0F, 0.0F));

        PartDefinition arm23 = partdefinition.addOrReplaceChild("arm23", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition cube_r23 = arm23.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(40, 32).addBox(-2.0F, -2.0F, -1.0F, 4.0F, 18.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, -7.0F, 1.5708F, 0.0F, 0.0F));

        PartDefinition arm24 = partdefinition.addOrReplaceChild("arm24", CubeListBuilder.create(), PartPose.offset(0.0F, 23.9858F, -0.1662F));

        PartDefinition cube_r24 = arm24.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(24, 32).addBox(-2.0F, -9.0F, -2.0F, 4.0F, 19.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -0.5F, 1.5708F, 0.0F, 0.0F));

        // arm 3
        PartDefinition arm31 = partdefinition.addOrReplaceChild("arm31", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition cube_r31 = arm31.addOrReplaceChild("cube_r31", CubeListBuilder.create().texOffs(0, 32).addBox(-3.0F, -10.5F, -3.0F, 6.0F, 21.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.5708F, 0.0F, 0.0F));

        PartDefinition arm32 = partdefinition.addOrReplaceChild("arm32", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition cube_r32 = arm32.addOrReplaceChild("cube_r32", CubeListBuilder.create().texOffs(40, 54).addBox(-2.0F, -2.0F, -1.0F, 4.0F, 18.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, -7.0F, 1.5708F, 0.0F, 0.0F));

        PartDefinition arm33 = partdefinition.addOrReplaceChild("arm33", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition cube_r33 = arm33.addOrReplaceChild("cube_r33", CubeListBuilder.create().texOffs(40, 32).addBox(-2.0F, -2.0F, -1.0F, 4.0F, 18.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, -7.0F, 1.5708F, 0.0F, 0.0F));

        PartDefinition arm34 = partdefinition.addOrReplaceChild("arm34", CubeListBuilder.create(), PartPose.offset(0.0F, 23.9858F, -0.1662F));

        PartDefinition cube_r34 = arm34.addOrReplaceChild("cube_r34", CubeListBuilder.create().texOffs(24, 32).addBox(-2.0F, -9.0F, -2.0F, 4.0F, 19.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -0.5F, 1.5708F, 0.0F, 0.0F));

        // arm 4
        PartDefinition arm41 = partdefinition.addOrReplaceChild("arm41", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition cube_r41 = arm41.addOrReplaceChild("cube_r41", CubeListBuilder.create().texOffs(0, 32).addBox(-3.0F, -10.5F, -3.0F, 6.0F, 21.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.5708F, 0.0F, 0.0F));

        PartDefinition arm42 = partdefinition.addOrReplaceChild("arm42", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition cube_r42 = arm42.addOrReplaceChild("cube_r42", CubeListBuilder.create().texOffs(40, 54).addBox(-2.0F, -2.0F, -1.0F, 4.0F, 18.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, -7.0F, 1.5708F, 0.0F, 0.0F));

        PartDefinition arm43 = partdefinition.addOrReplaceChild("arm43", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition cube_r43 = arm43.addOrReplaceChild("cube_r43", CubeListBuilder.create().texOffs(40, 32).addBox(-2.0F, -2.0F, -1.0F, 4.0F, 18.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, -7.0F, 1.5708F, 0.0F, 0.0F));

        PartDefinition arm44 = partdefinition.addOrReplaceChild("arm44", CubeListBuilder.create(), PartPose.offset(0.0F, 23.9858F, -0.1662F));

        PartDefinition cube_r44 = arm44.addOrReplaceChild("cube_r44", CubeListBuilder.create().texOffs(24, 32).addBox(-2.0F, -9.0F, -2.0F, 4.0F, 19.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -0.5F, 1.5708F, 0.0F, 0.0F));



        return LayerDefinition.create(meshdefinition, 128, 128);
    }


    public SpiderModel(ModelPart root) {
        // segment names. names of the folders containing the geometry of each animatable segment in blockbench
        super(root, new String[]
                {"arm11", "arm12", "arm13", "arm14",
                        "arm21", "arm22", "arm23", "arm24",
                        "arm31", "arm32", "arm33", "arm34",
                        "arm41", "arm42", "arm43", "arm44",});
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
    public void setupAnim(SpiderEntity entity, float pLimbSwing, float pLimbSwingAmount, float ageInTicks, float pNetHeadYaw, float pHeadPitch) {
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
