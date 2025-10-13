package net.jelly.marionette_lib.entity.invasion.grappler;

import net.jelly.marionette_lib.entity.goals.MoveTowardTargetGoal;
import net.jelly.marionette_lib.entity.goals.HoverGoal;
import net.jelly.marionette_lib.entity.goals.IHoverEntity;
import net.jelly.marionette_lib.entity.goals.grappler.GrapplerPunchGoal;
import net.jelly.marionette_lib.entity.invasion.drone.DroneEntity;
import net.jelly.marionette_lib.utility.FabrikAnimator;
import net.jelly.marionette_lib.utility.ProceduralAnimatable;
import net.minecraft.core.BlockPos;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.FlyingMob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.entity.PartEntity;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector3f;

import java.util.ArrayList;

public class GrapplerEntity extends FlyingMob implements ProceduralAnimatable, IHoverEntity {
    private final GrapplerPartEntity[] allParts;
    FabrikAnimator[] legAnimators = new FabrikAnimator[2];
    int attackTicks = 0;
    int attackDuration = 15;
    private static final EntityDataAccessor<Integer> PHASE = SynchedEntityData.defineId(GrapplerEntity.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Vector3f> TARGET_POS = SynchedEntityData.defineId(GrapplerEntity.class, EntityDataSerializers.VECTOR3);

    public GrapplerEntity(EntityType entityType, Level level) {
        super(entityType, level);
        GrapplerPartEntity arm11 = new GrapplerPartEntity(this, 16f/16, 16f/16, 20f/16);
        GrapplerPartEntity arm12 = new GrapplerPartEntity(this, 16f/16, 16f/16, 20f/16);
        GrapplerPartEntity arm13 = new GrapplerPartEntity(this, 16f/16, 16f/16, 10f/16);
        GrapplerPartEntity arm21 = new GrapplerPartEntity(this, 16f/16, 16f/16, 20f/16);
        GrapplerPartEntity arm22 = new GrapplerPartEntity(this, 16f/16, 16f/16, 20f/16);
        GrapplerPartEntity arm23 = new GrapplerPartEntity(this, 16f/16, 16f/16, 10f/16);
        legAnimators[0] = new FabrikAnimator(this, new GrapplerPartEntity[]
                {arm11, arm12, arm13});
        legAnimators[1] = new FabrikAnimator(this, new GrapplerPartEntity[]
                {arm21, arm22, arm23});
        allParts = new GrapplerPartEntity[]
                {arm11, arm12, arm13, arm21, arm22, arm23};

        this.lookControl = new DroneEntity.DroneLookControl(this);

        // goals
        this.goalSelector.addGoal(0, new NearestAttackableTargetGoal<>(this, Player.class, false));
        this.goalSelector.addGoal(1, new GrapplerPunchGoal(this));
        this.goalSelector.addGoal(2, new MoveTowardTargetGoal(this, 3, 0.85f, 0.065f));
        this.goalSelector.addGoal(3, new HoverGoal(this, 1f, 0.1f));
        this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));
    }

    @Override
    public ArrayList<FabrikAnimator> getAnimators() {
        ArrayList<FabrikAnimator> animators = new ArrayList<>();
        animators.add(legAnimators[0]);
        animators.add(legAnimators[1]);
        return animators;
    }
    @Override
    public boolean isMultipartEntity() {
        return true;
    }

    @Override
    public @Nullable PartEntity<?>[] getParts() {
        return allParts;
    }

    public void remove(RemovalReason removalReason) {
        super.remove(removalReason);
        if (allParts != null) {
            for (PartEntity part : allParts) {
                part.remove(RemovalReason.KILLED);
            }
        }
    }

    public AttackPhase getPhase() {
        return AttackPhase.values()[this.entityData.get(PHASE)];
    }

    public void setPhase(AttackPhase phase) {
        System.out.println("phase set from " + this.level().isClientSide + " to " + phase);
        this.entityData.set(PHASE, phase.ordinal());
    }

    public static enum AttackPhase {
        MOVE,
        PUNCH
    }

    public void beginAttack(int attackDuration) {
        this.attackDuration = attackDuration;
    }

    public void endAttack() {
        this.attackTicks = 0;
    }

    public void tick() {
        super.tick();

        for (int i=0; i<2; i++) {
            FabrikAnimator legAnimator = legAnimators[i];
            int bodySide = 1;
            if(i%2 == 0) bodySide = -1;

            Vec3 direction = Vec3.directionFromRotation(0, this.yBodyRot);
            Vec3 legRoot = this.position()
                    .add(direction.cross(new Vec3(0, 1, 0)).normalize().scale(10/16f*bodySide))
                    .add(new Vec3(0, 0.75, 0));
            legAnimator.setRoot(legRoot);

            if(getPhase() == AttackPhase.MOVE) {
                double horizontalSpeed = (new Vec3(this.getDeltaMovement().x, 0, this.getDeltaMovement().z).length()); // "hang" arms while moving;
                Vec3 legRest = this.position()
                        .add(direction.cross(new Vec3(0, 1, 0)).normalize().scale(1.25f * bodySide))
                        .add(direction.normalize().scale(1.25f))
                        .add(new Vec3(0, -1.25, 0))
                        .add(new Vec3(0, -1, 0) // "hang" arms while moving
                                .scale(horizontalSpeed));
                Vec3 restPos = legRest;


                double slowWhenMoving = 1 / (horizontalSpeed + 1);
                if (legAnimator.chainEndPos().distanceTo(restPos) > 0.2) {
                    legAnimator.setFabrikTarget(legAnimator.chainEndPos()
                            .add(restPos.subtract(legAnimator.chainEndPos()).normalize()
                                    .scale(this.getDeltaMovement().dot(restPos.subtract(legAnimator.chainEndPos())) * 0.15f * slowWhenMoving)) // damping relative to velocity
                            .add(restPos.subtract(legAnimator.chainEndPos()).scale(0.1 * slowWhenMoving)) // exponential approach rest position
                            .add(restPos.subtract(legAnimator.chainEndPos()).normalize().scale(0.1)) // linear approach rest position
                    );
                }
            }
            /* PUNCH ATTACK */
            else if (getPhase() == AttackPhase.PUNCH && i == 0) {
                // wow this code sucks
                LivingEntity target = this.getTarget();
                if(!this.level().isClientSide() && target != null) {
                    this.entityData.set(TARGET_POS, target.position().toVector3f());
                }
                Vec3 targetPos = new Vec3(this.entityData.get(TARGET_POS));
                if (targetPos == Vec3.ZERO) {
                    if (!this.level().isClientSide()) setPhase(AttackPhase.MOVE);
                    continue;
                }

                System.out.println(attackTicks);

                // Track punch progress (0 → 1)
                if (attackTicks > attackDuration) {
                    if (!this.level().isClientSide()) setPhase(AttackPhase.MOVE);
                    attackTicks = 0;
                    continue;
                }
                attackTicks++;

                double progress = (double) attackTicks / attackDuration;

// --- Motion curve ---
// 0.0–0.3  : wind-up (pull arm back)
// 0.3–0.6  : thrust (attack forward)
// 0.6–1.0  : retract
                double curve;
                if (progress < 0.3) {
                    // Pull back smoothly
                    double t = progress / 0.3;
                    curve = -0.4 * Math.sin(t * Math.PI * 0.5); // ease-in pullback
                } else if (progress < 0.6) {
                    // Thrust fast, strong ease-out
                    double t = (progress - 0.3) / 0.3;
                    curve = Math.sin(t * Math.PI * 0.5); // fast acceleration forward
                } else {
                    // Retract arm back to rest
                    double t = (progress - 0.6) / 0.4;
                    curve = (1.0 - t) * 0.3; // smooth retract
                }

                // --- Direction ---
                Vec3 toTarget = targetPos.subtract(this.position());
                Vec3 punchDir = toTarget.normalize();

                // --- Reach ---
                // Slight scaling so long targets extend a bit more, but not crazy
                double targetDist = toTarget.length();
                double reach = Mth.clamp(targetDist * 0.6, 1.0, 3.0);

                // --- Arm endpoint ---
                Vec3 base = legAnimator.chainEndPos(); // current arm base position
                Vec3 armTargetPos = base.add(punchDir.scale(curve * reach));

                legAnimator.setFabrikTarget(armTargetPos);


                // Simple hit detection
                if (attackTicks == (int)(attackDuration * 0.5)) { // midpoint impact
                    if (targetPos.distanceTo(legAnimator.chainEndPos()) < 1.5) {
                        if(target != null) target.hurt(this.damageSources().mobAttack(this), 6.0f);
                    }
                }
            }

        }
        tickMultipart();
    }


    public static AttributeSupplier.Builder createAttributes() {
        return Animal.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 20D)
                .add(Attributes.KNOCKBACK_RESISTANCE, 100)
                .add(Attributes.FOLLOW_RANGE, 24D)
                .add(Attributes.MOVEMENT_SPEED, 0.25D)
                .add(Attributes.ARMOR_TOUGHNESS, 0.1f)
                .add(Attributes.ATTACK_KNOCKBACK, 0.5f)
                .add(Attributes.ATTACK_DAMAGE, 2f);
    }

    @Override
    public boolean hurt(DamageSource pSource, float pAmount) {
        System.out.println("ouch: " + pAmount);
        return super.hurt(pSource, pAmount);
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

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(PHASE, 0);
        this.entityData.define(TARGET_POS, new Vector3f(0,0,0));
    }
}
