package net.jelly.marionette_lib.entity.goals;

import net.minecraft.commands.arguments.EntityAnchorArgument;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.Goal;

import java.util.EnumSet;

public class MoveTowardTargetGoal extends Goal {
    private final Mob mob;
    private final float MAX_DIST; // blocks above ground
    private final float MAX_SPEED;
    private final float ACCEL;

    public MoveTowardTargetGoal(Mob mob, float maxDist, float maxSpeed, float accel) {
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
        mob.lookAt(EntityAnchorArgument.Anchor.EYES, target.position().add(0,1,0));
        if(mob.getSpeed() <= MAX_SPEED) mob.addDeltaMovement(mob.getLookAngle().normalize().scale(ACCEL));
    }
}
