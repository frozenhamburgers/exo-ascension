package net.jelly.exo_ascension.entity.goals.gorgon;

import mod.chloeprime.aaaparticles.api.common.AAALevel;
import mod.chloeprime.aaaparticles.api.common.ParticleEmitterInfo;
import net.jelly.exo_ascension.ExoAscensionMod;
import net.jelly.exo_ascension.entity.invasion.gorgon.GorgonEntity;
import net.jelly.exo_ascension.global.invasion.InvasionData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

import java.util.EnumSet;

public class GorgonAttackGoal extends Goal {
    private final GorgonEntity mob;
    private int timer = 0;
    private static final double MIN_HEIGHT = 2.0;
    private static final double RISE_SPEED = 0.1;
    private static final ParticleEmitterInfo DRILL = new ParticleEmitterInfo(new ResourceLocation(ExoAscensionMod.MODID, "drill/drill"));
    ParticleEmitterInfo drill;
    boolean attackHit = false;
    boolean charging = false;
    int chargeTimer = 0;
    boolean retreat = false;


    public GorgonAttackGoal(GorgonEntity mob) {
        this.mob = mob;
        this.setFlags(EnumSet.of(Flag.MOVE));
    }

    @Override
    public boolean canUse() {
        return (mob.getTarget() != null && mob.distanceTo(mob.getTarget()) < 7);
    }

    @Override
    public void start() {
        drill = DRILL.clone()
                .bindOnEntity(mob)
                .useEntityHeadSpace()
                .scale(0.2f);
        timer = 0;
        attackHit = false;
        charging = false;
        chargeTimer = 0;
        retreat = false;
    }

    @Override
    public boolean isInterruptable() {
        return false;
    }

    @Override
    public void stop() {
        mob.attacking = false;
        super.stop();
    }

    @Override
    public boolean canContinueToUse() {
        return (mob.getTarget() != null && timer < 134 + 120); // 6 seconds of cooldown
    }

    @Override
    public boolean requiresUpdateEveryTick() {
        return true;
    } // timer purposes

    @Override
    public void tick() {
        LivingEntity target = mob.getTarget();

        if(!retreat && !mob.attacking) {
            if (mob.distanceTo(mob.getTarget()) < 3)
                mob.addDeltaMovement(mob.getLookAngle().normalize().scale(-0.035f));
            else if (mob.distanceTo(mob.getTarget()) > 5)
                mob.addDeltaMovement(mob.getLookAngle().normalize().scale(0.035f));
        }

        if(mob.getGroundDistance() < MIN_HEIGHT) {
            this.mob.addDeltaMovement(new Vec3(0, RISE_SPEED, 0));
        }

        if(timer == 114) mob.attacking = true;
        if(timer == 124) AAALevel.addParticle(mob.level(), false, drill);
        if(timer >= 124 && timer < 134) {
            Vec3 eyePos = mob.position().add(0, mob.getEyeHeight(), 0);
            Vec3 lookDir = mob.getLookAngle().normalize();
            double range = 7.0;
            double coneAngle = Math.toRadians(30);

            AABB searchBox = mob.getBoundingBox().expandTowards(lookDir.scale(range)).inflate(2.0);

            for (LivingEntity hit : mob.level().getEntitiesOfClass(LivingEntity.class, searchBox,
                    e -> e != mob && e.isAlive())) {

                Vec3 toTarget = hit.position().add(0, hit.getBbHeight() * 0.5, 0).subtract(eyePos);
                double distance = toTarget.length();

                if (distance > range)
                    continue;

                double dot = lookDir.dot(toTarget.normalize());
                double angle = Math.acos(dot); // in radians

                if (angle <= coneAngle) {
                    // inside cone apply damage or effects
                    if(InvasionData.isInvasionMob(hit)) continue;
                    hit.hurt(mob.damageSources().mobAttack(mob), 3.0F);

                    Vec3 push = lookDir.scale(0.1);
                    hit.push(push.x, 0.05, push.z);

                    if (target != null && hit == target) {
                        attackHit = true;
                    }
                }
            }
        }
        else if(timer >= 134) {
            mob.attacking = false;
            if(target == null) return;
            if(attackHit) {
                charging = true;
                mob.lookAt(target, 180, 180);
                if(mob.getSpeed() <= 1.45f) mob.addDeltaMovement(mob.getLookAngle().normalize().scale(0.3f));
                chargeTimer++;
                if(chargeTimer > 70) {
                    attackHit = false;
                    charging = false;
                }
            }
            else if (mob.distanceTo(target) <= 20){
                retreat = true;
                mob.lookAt(target, 180, 180);
                if(mob.getSpeed() <= 1.2f) mob.addDeltaMovement(target.position().subtract(mob.position()).normalize().scale(-0.1f));
            }
        }

        if(!charging) timer++;
    }
}
