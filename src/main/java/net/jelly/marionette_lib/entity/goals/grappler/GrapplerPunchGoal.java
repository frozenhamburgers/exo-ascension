package net.jelly.marionette_lib.entity.goals.grappler;

import net.jelly.marionette_lib.entity.invasion.grappler.GrapplerEntity;
import net.minecraft.world.entity.ai.goal.Goal;

import java.util.EnumSet;

public class GrapplerPunchGoal extends Goal {
    private final GrapplerEntity mob;
    private int timer;


    public GrapplerPunchGoal(GrapplerEntity mob) {
        this.mob = mob;
        this.setFlags(EnumSet.of(Flag.MOVE));
    }

    @Override
    public boolean canUse() {
        return (mob.getTarget() != null && mob.distanceTo(mob.getTarget()) <= 3.5) &&
                mob.getPhase() != GrapplerEntity.AttackPhase.PUNCH;
    }

    @Override
    public void start() {
        mob.setPhase(GrapplerEntity.AttackPhase.PUNCH);
        mob.beginAttack(15);
        timer = 0;
    }

    @Override
    public boolean isInterruptable() {
        return false;
    }

    @Override
    public void stop() {
        mob.setPhase(GrapplerEntity.AttackPhase.MOVE);
        mob.endAttack();
        super.stop();
    }

    @Override
    public boolean canContinueToUse() {
        return (mob.getTarget() != null && mob.getPhase() == GrapplerEntity.AttackPhase.PUNCH && timer < 80);
    }

    @Override
    public boolean requiresUpdateEveryTick() {
        return true;
    }

    @Override
    public void tick() {
        timer++;
    }
}
