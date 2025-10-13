package net.jelly.marionette_lib.entity.invasion.drone;

import net.jelly.marionette_lib.entity.goals.MoveTowardTargetGoal;
import net.jelly.marionette_lib.entity.goals.drone.DroneAttackGoal;
import net.jelly.marionette_lib.entity.goals.HoverGoal;
import net.jelly.marionette_lib.entity.goals.IHoverEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.FlyingMob;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.BodyRotationControl;
import net.minecraft.world.entity.ai.control.LookControl;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class DroneEntity extends FlyingMob implements IHoverEntity {

    public DroneEntity(EntityType<? extends FlyingMob> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.lookControl = new DroneLookControl(this);

        // Basic behaviors
        this.goalSelector.addGoal(0, new NearestAttackableTargetGoal<>(this, Player.class, false));
        this.goalSelector.addGoal(1, new DroneAttackGoal(this));
        this.goalSelector.addGoal(2, new MoveTowardTargetGoal(this, 6f, 1.2f, 0.1f));
        this.goalSelector.addGoal(3, new HoverGoal(this, 5f, 0.2f));
        this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Animal.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 20D)
                .add(Attributes.FOLLOW_RANGE, 80D)
                .add(Attributes.MOVEMENT_SPEED, 0.25D)
                .add(Attributes.ARMOR_TOUGHNESS, 0.1f)
                .add(Attributes.ATTACK_KNOCKBACK, 0.5f)
                .add(Attributes.ATTACK_DAMAGE, 2f);
    }

    protected BodyRotationControl createBodyControl() {
        return new DroneBodyRotationControl(this);
    }

    class DroneBodyRotationControl extends BodyRotationControl {
        public DroneBodyRotationControl(Mob pMob) {
            super(pMob);
        }
        public void clientTick() {
            DroneEntity.this.yHeadRot = DroneEntity.this.yBodyRot;
            DroneEntity.this.yBodyRot = DroneEntity.this.getYRot();
        }
    }

    public static class DroneLookControl extends LookControl {
        public DroneLookControl(Mob pMob) {
            super(pMob);
        }
        public void tick() {
        }
    }

    public double getGroundDistance() {
        BlockPos pos = this.blockPosition();
        Level level = this.level();
        int y = pos.getY();

        // Search downward for first solid block
        while (y > level.getMinBuildHeight() && level.getBlockState(new BlockPos(pos.getX(), y - 1, pos.getZ())).isAir()) {
            y--;
        }

        return this.getY() - y;
    }
}
