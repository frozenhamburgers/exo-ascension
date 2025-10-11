package net.jelly.marionette_lib.entity.goals;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.Goal;

import java.util.EnumSet;

public class RoarGoal extends Goal {
    private final Mob mob;
    private int timer;

    public RoarGoal(Mob mob) {
        this.mob = mob;
        this.setFlags(EnumSet.of(Flag.LOOK));
    }

    @Override
    public boolean canUse() {
        // 1 in 200 chance each tick to start roaring
        return mob.getRandom().nextInt(200) == 0;
    }

    @Override
    public void start() {
        timer = 40; // roar for 2 seconds (20 ticks/second)
        mob.level().playSound(null, mob.blockPosition(), SoundEvents.ENDER_DRAGON_GROWL, SoundSource.HOSTILE, 1.0F, 1.0F);
        System.out.println("roar");
    }

    @Override
    public boolean canContinueToUse() {
        return timer > 0;
    }

    @Override
    public void tick() {
        timer--;
    }
}
