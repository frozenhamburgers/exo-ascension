package net.jelly.marionette_lib.entity.invasion.grappler;

import net.jelly.marionette_lib.networking.ModMessages;
import net.jelly.marionette_lib.networking.MultipartEntityMessage;
import net.jelly.marionette_lib.utility.AbstractPartEntity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.phys.AABB;

public class GrapplerPartEntity extends AbstractPartEntity<GrapplerEntity> {
    private EntityDimensions size;

    public GrapplerPartEntity(GrapplerEntity parent, float sizeXZ, float sizeY, float length) {
        super(parent);
        this.size = EntityDimensions.fixed(sizeXZ, sizeY);
        this.refreshDimensions();
        this.length = length;
    }

    public EntityDimensions getDimensions(Pose pose) {
        return size;
    }

    public AABB getBoundingBoxForCulling() {
        return this.getBoundingBox().inflate(1.0D, 1.0D, 1.0D);
    }

    @Override
    public boolean fireImmune() {
        return true;
    }

    @Override
    public boolean canBeHitByProjectile() {
        return true;
    }
    @Override
    public boolean isPickable() {
        return true;
    }

    @Override
    public boolean canBeCollidedWith() {
        return true;
    }

    @Override
    public boolean hurt(DamageSource source, float amount) {
        Entity parent = this.getParent();
        if (parent != null) {
            Entity player = source.getEntity();
            if (player != null && player.level().isClientSide) {
                ModMessages.sendToServer(new MultipartEntityMessage(parent.getId(), player.getId(), 1, amount));
            }
            else parent.hurt(source, amount);
        }
        return true;
    }


}
