package net.jelly.marionette_lib.entity.goals;

import net.jelly.marionette_lib.entity.invasion.drone.DroneEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.Goal;

import java.util.EnumSet;

public class HoverGoal extends Goal {
    private final Mob mob;
    private final double MIN_HEIGHT; // blocks above ground
    private final double RISE_SPEED; // upward motion per tick
    private final boolean hoverIfTargetNear;
    private final double targetMaxDist;

    public HoverGoal(Mob mob, double minHeight, double riseSpeed, boolean hoverIfTargetNear, double targetMaxDist) {
        this.mob = mob;
        MIN_HEIGHT = minHeight;
        RISE_SPEED = riseSpeed;
        this.hoverIfTargetNear = hoverIfTargetNear;
        this.targetMaxDist = targetMaxDist;
        this.setFlags(EnumSet.of(Flag.MOVE));
    }

    @Override
    public boolean canUse() {
        // Start rising if too close to ground
        return ((IHoverEntity)mob).getGroundDistance() < MIN_HEIGHT
                && (hoverIfTargetNear || (mob.getTarget() != null
                && mob.distanceTo(mob.getTarget()) > targetMaxDist));
    }

    @Override
    public boolean canContinueToUse() {
        // Keep rising until we’re high enough
        return ((IHoverEntity)mob).getGroundDistance() < MIN_HEIGHT
                && (hoverIfTargetNear || (mob.getTarget() != null
                && mob.distanceTo(mob.getTarget()) > targetMaxDist));
    }

    @Override
    public void tick() {
        // Apply small upward velocity
        this.mob.setDeltaMovement(
                this.mob.getDeltaMovement().x,
                RISE_SPEED,
                this.mob.getDeltaMovement().z
        );
    }


}
