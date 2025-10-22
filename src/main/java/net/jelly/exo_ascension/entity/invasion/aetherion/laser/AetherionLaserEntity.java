package net.jelly.exo_ascension.entity.invasion.aetherion.laser;

import mod.chloeprime.aaaparticles.api.common.AAALevel;
import mod.chloeprime.aaaparticles.api.common.ParticleEmitterInfo;
import net.jelly.exo_ascension.ExoAscensionMod;
import net.jelly.exo_ascension.entity.invasion.aetherion.AetherionBoss;
import net.jelly.exo_ascension.global.invasion.InvasionData;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class AetherionLaserEntity extends Entity {
    private static final ParticleEmitterInfo LASER_PARTICLE = new ParticleEmitterInfo(new ResourceLocation(ExoAscensionMod.MODID, "laser/aetherion_laser"));
    ParticleEmitterInfo laser;
    public static final int DURATION = 134;
    private int timer = 0;
    private AetherionBoss owner;

    public AetherionLaserEntity(EntityType<?> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public void start(AetherionBoss owner) {
        this.owner = owner;
        laser = LASER_PARTICLE.clone()
                .bindOnEntity(this)
                .useEntityHeadSpace()
                .scale(1.5f);
        AAALevel.addParticle(this.level(), false, laser);
    }

    @Override
    public void tick() {
        super.tick();
        timer++;
        if(this.timer > DURATION) {
            this.remove(RemovalReason.DISCARDED);
        }
        if(timer >= 47 && timer < DURATION) {
            Vec3 start = this.position().add(0, this.getEyeHeight(), 0);
            Vec3 end = start.add(this.getLookAngle().normalize().scale(30.0));
            var aabb = this.getBoundingBox().expandTowards(this.getLookAngle().scale(30.0)).inflate(0.5);

            for (LivingEntity hit : this.level().getEntitiesOfClass(LivingEntity.class, aabb, e -> e.isAlive())) {
                var optionalHit = hit.getBoundingBox().clip(start, end);
                if (optionalHit.isPresent()) {
                    if (InvasionData.isInvasionMob(hit)) continue;
                    if (owner != null) hit.hurt(this.damageSources().mobAttack(owner), 12.0F);
                    if (!this.level().isClientSide) {
                        Vec3 push = this.getLookAngle().scale(0.1);
                        hit.push(push.x, 0.01, push.z);
                    }
                }
            }
        }
    }

    @Override
    protected void defineSynchedData() {

    }

    @Override
    protected void readAdditionalSaveData(CompoundTag pCompound) {

    }

    @Override
    protected void addAdditionalSaveData(CompoundTag pCompound) {

    }
}
