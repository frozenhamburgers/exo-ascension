package net.jelly.marionette_lib.entity.goals;

import net.jelly.marionette_lib.entity.invasion.drone.DroneEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.ai.goal.Goal;

import java.util.EnumSet;

public class HoverGoal extends Goal {
    private final Entity mob;
    private final double MIN_HEIGHT; // blocks above ground
    private final double RISE_SPEED; // upward motion per tick

    public HoverGoal(Entity mob, double minHeight, double riseSpeed) {
        this.mob = mob;
        MIN_HEIGHT = minHeight;
        RISE_SPEED = riseSpeed;
        this.setFlags(EnumSet.of(Flag.MOVE));
    }

    @Override
    public boolean canUse() {
        // Start rising if too close to ground
        return ((IHoverEntity)mob).getGroundDistance() < MIN_HEIGHT;
    }

    @Override
    public boolean canContinueToUse() {
        // Keep rising until we’re high enough
        return ((IHoverEntity)mob).getGroundDistance() < MIN_HEIGHT;
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
