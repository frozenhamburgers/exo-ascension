package net.jelly.exo_ascension.entity.invasion.aetherion.beam;

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

public class AetherionBeamEntity extends Entity {
    private static final ParticleEmitterInfo BEAM_PARTICLE = new ParticleEmitterInfo(new ResourceLocation(ExoAscensionMod.MODID, "drill/drill"));
    ParticleEmitterInfo beam;
    public static final int DURATION = 167;
    private int timer = 0;
    private AetherionBoss owner;

    public AetherionBeamEntity(EntityType<?> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        beam = BEAM_PARTICLE.clone()
                .bindOnEntity(this)
                .useEntityHeadSpace()
                .scale(1.5f);
    }

    public void start(AetherionBoss owner) {
        this.owner = owner;
        AAALevel.addParticle(this.level(), false, beam);
    }

    @Override
    public void tick() {
        super.tick();
        timer++;
        if(this.timer > DURATION) {
            this.remove(RemovalReason.DISCARDED);
        }
        if(timer < DURATION) {
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
