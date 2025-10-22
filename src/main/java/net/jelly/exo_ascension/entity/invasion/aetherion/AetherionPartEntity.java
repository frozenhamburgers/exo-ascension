package net.jelly.exo_ascension.entity.invasion.aetherion;

import net.jelly.exo_ascension.global.invasion.InvasionData;
import net.jelly.exo_ascension.networking.AetherionArmMessage;
import net.jelly.exo_ascension.networking.ModMessages;
import net.jelly.exo_ascension.networking.MultipartEntityMessage;
import net.jelly.exo_ascension.utility.AbstractPartEntity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

import java.util.List;

public class AetherionPartEntity extends AbstractPartEntity<AetherionBoss> {
    private EntityDimensions size;
    private int index;

    public AetherionPartEntity(AetherionBoss parent, float sizeXZ, float sizeY, float length, int index) {
        super(parent);
        this.size = EntityDimensions.fixed(sizeXZ, sizeY);
        this.refreshDimensions();
        this.length = length;
        this.index = index;
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
    public boolean hurt(DamageSource source, float amount) {
        AetherionBoss parent = this.getParent();
        if (parent != null) {
            Entity player = source.getEntity();
            if (player != null && player.level().isClientSide) {
                ModMessages.sendToServer(new AetherionArmMessage(parent.getId(), player.getId(), 1, amount, this.index));
            }
            else {
                parent.hurtArm(this.index, amount);
                parent.hurt(level().damageSources().generic(), 0);
            }
        }
        return true;
    }
}
