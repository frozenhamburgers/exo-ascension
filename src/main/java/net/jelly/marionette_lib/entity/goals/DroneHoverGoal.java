package net.jelly.marionette_lib.entity.goals;

import net.jelly.marionette_lib.entity.invasion.drone.DroneEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.level.Level;

import java.util.EnumSet;

public class DroneHoverGoal extends Goal {
    private final DroneEntity mob;
    private static final double MIN_HEIGHT = 5.0; // blocks above ground
    private static final double RISE_SPEED = 0.2; // upward motion per tick

    public DroneHoverGoal(DroneEntity mob) {
        this.mob = mob;
        this.setFlags(EnumSet.of(Flag.MOVE));
    }

    @Override
    public boolean canUse() {
        // Start rising if too close to ground
        return mob.getGroundDistance() < MIN_HEIGHT;
    }

    @Override
    public boolean canContinueToUse() {
        // Keep rising until we’re high enough
        return mob.getGroundDistance() < MIN_HEIGHT;
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
