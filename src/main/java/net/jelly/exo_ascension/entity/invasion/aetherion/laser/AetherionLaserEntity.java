package net.jelly.exo_ascension.entity.invasion.aetherion.laser;

import mod.chloeprime.aaaparticles.api.common.AAALevel;
import mod.chloeprime.aaaparticles.api.common.ParticleEmitterInfo;
import net.jelly.exo_ascension.ExoAscensionMod;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

public class AetherionLaserEntity extends Entity {
    private static final ParticleEmitterInfo LASER_PARTICLE = new ParticleEmitterInfo(new ResourceLocation(ExoAscensionMod.MODID, "laser/aetherion_laser"));
    ParticleEmitterInfo laser;
    public static final int DURATION = 134;
    private int timer = 0;

    public AetherionLaserEntity(EntityType<?> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public void start() {
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
