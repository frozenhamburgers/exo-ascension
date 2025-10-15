package net.jelly.marionette_lib.entity.goals.gorgon;

import mod.chloeprime.aaaparticles.api.common.AAALevel;
import mod.chloeprime.aaaparticles.api.common.ParticleEmitterInfo;
import net.jelly.marionette_lib.MarionetteMod;
import net.jelly.marionette_lib.entity.invasion.gorgon.GorgonEntity;
import net.minecraft.commands.arguments.EntityAnchorArgument;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.phys.Vec3;

import java.util.EnumSet;

public class GorgonAttackGoal extends Goal {
    private final GorgonEntity mob;
    private int timer = 0;
    private static final double MIN_HEIGHT = 2.0;
    private static final double RISE_SPEED = 0.1;
    private static final ParticleEmitterInfo DRILL = new ParticleEmitterInfo(new ResourceLocation(MarionetteMod.MODID, "drill/drill"));
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
        mob.lookAt(EntityAnchorArgument.Anchor.EYES, target.position());
        System.out.println(timer);

        if(!retreat) {
            if (mob.distanceTo(mob.getTarget()) < 3)
                mob.addDeltaMovement(mob.getLookAngle().normalize().scale(-0.035f));
            else if (mob.distanceTo(mob.getTarget()) > 5)
                mob.addDeltaMovement(mob.getLookAngle().normalize().scale(0.035f));
        }

        if(mob.getGroundDistance() < MIN_HEIGHT) {
            this.mob.addDeltaMovement(new Vec3(0, RISE_SPEED, 0));
        }

        if(timer == 124) AAALevel.addParticle(mob.level(), false, drill);
        if(timer >= 124 && timer < 134) {
            Vec3 start = mob.position().add(0, mob.getEyeHeight(), 0);
            Vec3 end = start.add(mob.getLookAngle().normalize().scale(6.0));
            var aabb = mob.getBoundingBox().expandTowards(mob.getLookAngle().scale(10.0)).inflate(0.5);

            for (LivingEntity hit : mob.level().getEntitiesOfClass(LivingEntity.class, aabb, e -> e != mob && e.isAlive())) {
                var optionalHit = hit.getBoundingBox().clip(start, end);
                if (optionalHit.isPresent()) {
                    hit.hurt(mob.damageSources().mobAttack(mob), 3.0F);
                    Vec3 push = mob.getLookAngle().scale(0.1);
                    hit.push(push.x, 0.05, push.z);
                    if(target != null && hit == target) {
                        attackHit = true;
                    }
                }
            }
        }
        else if(timer >= 134) {
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
