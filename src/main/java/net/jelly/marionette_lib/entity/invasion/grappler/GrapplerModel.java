package net.jelly.marionette_lib.entity.invasion.grappler;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.jelly.marionette_lib.utility.MultipartModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;

public class GrapplerModel extends MultipartModel<GrapplerEntity> {
    private final ModelPart body;

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, 16.0F, 0.0F));

        PartDefinition cube_r1 = body.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-8.0F, -6.0F, -10.0F, 16.0F, 12.0F, 20.0F, new CubeDeformation(0.0F))
                .texOffs(0, 32).addBox(-6.0F, 6.0F, -6.0F, 12.0F, 12.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -12.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

        PartDefinition arm11 = partdefinition.addOrReplaceChild("arm11", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition cube_r2 = arm11.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(48, 32).addBox(-3.0F, -10.5F, -3.0F, 6.0F, 21.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.25F, 1.5708F, 0.0F, 0.0F));

        PartDefinition arm12 = partdefinition.addOrReplaceChild("arm12", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition cube_r3 = arm12.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(24, 56).addBox(-2.0F, -10.5F, -2.0F, 4.0F, 21.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.5708F, 0.0F, 0.0F));

        PartDefinition arm13 = partdefinition.addOrReplaceChild("arm13", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition cube_r4 = arm13.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(56, 59).addBox(-2.0F, -5.5F, -2.0F, 4.0F, 11.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.5708F, 0.0F, 0.0F));

        PartDefinition arm21 = partdefinition.addOrReplaceChild("arm21", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition cube_r5 = arm21.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(48, 32).addBox(-3.0F, -10.5F, -3.0F, 6.0F, 21.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.25F, 1.5708F, 0.0F, 0.0F));

        PartDefinition arm22 = partdefinition.addOrReplaceChild("arm22", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition cube_r6 = arm22.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(24, 56).addBox(-2.0F, -10.5F, -2.0F, 4.0F, 21.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.5708F, 0.0F, 0.0F));

        PartDefinition arm23 = partdefinition.addOrReplaceChild("arm23", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition cube_r7 = arm23.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(56, 59).addBox(-2.0F, -5.5F, -2.0F, 4.0F, 11.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.5708F, 0.0F, 0.0F));

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
        for(int i=0 ; i<allSegments.length; i++) {
            allSegments[i].render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        }
        body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }

}
