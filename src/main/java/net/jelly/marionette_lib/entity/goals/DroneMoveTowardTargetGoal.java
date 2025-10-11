package net.jelly.marionette_lib.entity.goals;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.Goal;

import java.util.EnumSet;

public class DroneMoveTowardTargetGoal extends Goal {
    private final Mob mob;

    public DroneMoveTowardTargetGoal(Mob mob) {
        this.mob = mob;
        this.setFlags(EnumSet.of(Flag.LOOK, Flag.MOVE));
    }

    @Override
    public boolean canUse() {
        return (mob.getTarget() != null && mob.distanceTo(mob.getTarget()) > 6);
    }

    @Override
    public void start() {
    }

    @Override
    public boolean canContinueToUse() {
        return (mob.getTarget() != null && mob.distanceTo(mob.getTarget()) > 6);
    }

    @Override
    public void tick() {
        LivingEntity target = mob.getTarget();
        mob.lookAt(target, 180, 180);
        if(mob.getSpeed() <= 1.2f) mob.addDeltaMovement(mob.getLookAngle().normalize().scale(0.1f));
    }
}
