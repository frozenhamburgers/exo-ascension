package net.jelly.marionette_lib.entity.invasion.gorgon;

import net.jelly.marionette_lib.networking.ModMessages;
import net.jelly.marionette_lib.networking.MultipartEntityMessage;
import net.jelly.marionette_lib.utility.AbstractPartEntity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

import java.util.List;

public class GorgonPartEntity extends AbstractPartEntity<GorgonEntity> {
    private EntityDimensions size;

    public GorgonPartEntity(GorgonEntity parent, float sizeXZ, float sizeY, float length) {
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

    @Override
    public void tick() {
        super.tick();
        if (!this.level().isClientSide) {
            double damageRadius = 0.7; // slightly larger than its hitbox

            // Find nearby living entities
            List<LivingEntity> targets = this.level().getEntitiesOfClass(
                    LivingEntity.class,
                    this.getBoundingBox().inflate(damageRadius),
                    entity -> entity.isAlive() && !(entity instanceof GorgonEntity) // avoid self-hits or friendly fire
            );

            for (LivingEntity target : targets) {
                if (this.distanceTo(target) < damageRadius + 0.5) {
                    target.hurt(this.damageSources().mobAttack(this.getParent()), 4.0f); // damage amount adjustable
                    Vec3 push = this.position().subtract(target.position()).normalize().scale(0.3);
                    target.push(push.x, 0.05, push.z);
                }
            }
        }
    }
}
