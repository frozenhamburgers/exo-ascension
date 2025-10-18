package net.jelly.exo_ascension.entity.goals.drone;

import mod.chloeprime.aaaparticles.api.common.AAALevel;
import mod.chloeprime.aaaparticles.api.common.ParticleEmitterInfo;
import net.jelly.exo_ascension.ExoAscensionMod;
import net.jelly.exo_ascension.entity.invasion.drone.DroneEntity;
import net.jelly.exo_ascension.global.invasion.InvasionData;
import net.minecraft.commands.arguments.EntityAnchorArgument;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.phys.Vec3;

import java.util.EnumSet;

public class DroneAttackGoal extends Goal {
    private final DroneEntity mob;
    private int timer = 0;
    private static final double MIN_HEIGHT = 2.0;
    private static final double RISE_SPEED = 0.1;
    private static final ParticleEmitterInfo LASER_PARTICLE = new ParticleEmitterInfo(new ResourceLocation(ExoAscensionMod.MODID, "laser/blue_laser"));
    ParticleEmitterInfo laser;


    public DroneAttackGoal(DroneEntity mob) {
        this.mob = mob;
        this.setFlags(EnumSet.of(Flag.MOVE));
    }

    @Override
    public boolean canUse() {
        return (mob.getTarget() != null && mob.distanceTo(mob.getTarget()) < 7);
    }

    @Override
    public void start() {
        laser = LASER_PARTICLE.clone()
                .bindOnEntity(mob)
                .useEntityHeadSpace()
                .scale(0.2f);
        AAALevel.addParticle(mob.level(), false, laser);
        timer = 0;
    }

    @Override
    public boolean isInterruptable() {
        return false;
    }

    @Override
    public void stop() {
        super.stop();
    }

    @Override
    public boolean canContinueToUse() {
        return (mob.getTarget() != null && timer < 134 + 80); // 4 seconds of cooldown
    }

    @Override
    public boolean requiresUpdateEveryTick() {
        return true;
    } // timer purposes

    @Override
    public void tick() {
        LivingEntity target = mob.getTarget();
        mob.lookAt(EntityAnchorArgument.Anchor.EYES, target.position());
        if(mob.distanceTo(mob.getTarget()) < 4) mob.addDeltaMovement(mob.getLookAngle().normalize().scale(-0.025f));
        else if(mob.distanceTo(mob.getTarget()) > 6) mob.addDeltaMovement(mob.getLookAngle().normalize().scale(0.025f));

        if(mob.getGroundDistance() < MIN_HEIGHT) {
            this.mob.addDeltaMovement(new Vec3(0, RISE_SPEED, 0));
        }

        if(timer >= 47 && timer < 134) {
            Vec3 start = mob.position().add(0, mob.getEyeHeight(), 0);
            Vec3 end = start.add(mob.getLookAngle().normalize().scale(6.0));
            var aabb = mob.getBoundingBox().expandTowards(mob.getLookAngle().scale(6.0)).inflate(0.5);

            for (LivingEntity hit : mob.level().getEntitiesOfClass(LivingEntity.class, aabb, e -> e != mob && e.isAlive())) {
                var optionalHit = hit.getBoundingBox().clip(start, end);
                if (optionalHit.isPresent()) {
                    if(InvasionData.isInvasionMob(hit)) continue;
                    hit.hurt(mob.damageSources().mobAttack(mob), 4.0F);
                    Vec3 push = mob.getLookAngle().scale(0.1);
                    hit.push(push.x, 0.05, push.z);
                }
            }
        }

        timer++;
    }
}
