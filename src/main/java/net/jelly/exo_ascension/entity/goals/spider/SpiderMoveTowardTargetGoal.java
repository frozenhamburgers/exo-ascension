package net.jelly.exo_ascension.entity.goals.spider;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.phys.Vec3;

import java.util.EnumSet;

public class SpiderMoveTowardTargetGoal extends Goal {
    private final Mob mob;
    private final float MAX_DIST; // blocks above ground
    private final float MAX_SPEED;
    private final float ACCEL;

    public SpiderMoveTowardTargetGoal(Mob mob, float maxDist, float maxSpeed, float accel) {
        this.mob = mob;
        this.setFlags(EnumSet.of(Flag.LOOK, Flag.MOVE));
        this.MAX_DIST = maxDist;
        this.MAX_SPEED = maxSpeed;
        this.ACCEL = accel;
    }

    @Override
    public boolean canUse() {
        return (mob.getTarget() != null && mob.distanceTo(mob.getTarget()) > MAX_DIST);
    }

    @Override
    public void start() {
    }

    @Override
    public boolean canContinueToUse() {
        return (mob.getTarget() != null && mob.distanceTo(mob.getTarget()) > MAX_DIST);
    }

    @Override
    public void tick() {
        LivingEntity target = mob.getTarget();
        mob.lookAt(target, 180, 180);
        Vec3 accel = mob.getLookAngle().normalize().scale(ACCEL);
        if(mob.getSpeed() <= MAX_SPEED) mob.addDeltaMovement(new Vec3(accel.x, 0, accel.z));
    }
}
