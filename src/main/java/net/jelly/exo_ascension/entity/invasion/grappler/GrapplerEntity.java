package net.jelly.exo_ascension.entity.invasion.grappler;

import net.jelly.exo_ascension.entity.goals.MoveTowardTargetGoal;
import net.jelly.exo_ascension.entity.goals.HoverGoal;
import net.jelly.exo_ascension.entity.goals.IHoverEntity;
import net.jelly.exo_ascension.entity.invasion.drone.DroneEntity;
import net.jelly.exo_ascension.global.invasion.InvasionData;
import net.jelly.exo_ascension.utility.FabrikAnimator;
import net.jelly.exo_ascension.utility.ProceduralAnimatable;
import net.minecraft.core.BlockPos;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
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
    public static final int DEATH_VALUE = 5;
    private final GrapplerPartEntity[] allParts;
    FabrikAnimator[] legAnimators = new FabrikAnimator[2];
    private static final EntityDataAccessor<Vector3f> TARGET_POS = SynchedEntityData.defineId(GrapplerEntity.class, EntityDataSerializers.VECTOR3);

    public GrapplerEntity(EntityType entityType, Level level) {
        super(entityType, level);
        GrapplerPartEntity arm11 = new GrapplerPartEntity(this, 16f/16, 16f/16, 20f/16);
        GrapplerPartEntity arm12 = new GrapplerPartEntity(this, 12f/16, 12f/16, 20f/16);
        GrapplerPartEntity arm13 = new GrapplerPartEntity(this, 8f/16, 8f/16, 10f/16);
        GrapplerPartEntity arm21 = new GrapplerPartEntity(this, 16f/16, 16f/16, 20f/16);
        GrapplerPartEntity arm22 = new GrapplerPartEntity(this, 12f/16, 12f/16, 20f/16);
        GrapplerPartEntity arm23 = new GrapplerPartEntity(this, 8f/16, 8f/16, 10f/16);
        legAnimators[0] = new FabrikAnimator(this, new GrapplerPartEntity[]
                {arm11, arm12, arm13});
        legAnimators[1] = new FabrikAnimator(this, new GrapplerPartEntity[]
                {arm21, arm22, arm23});
        allParts = new GrapplerPartEntity[]
                {arm11, arm12, arm13, arm21, arm22, arm23};

        this.lookControl = new DroneEntity.DroneLookControl(this);

        // goals
        this.goalSelector.addGoal(0, new NearestAttackableTargetGoal<>(this, Player.class, false));
        this.goalSelector.addGoal(2, new MoveTowardTargetGoal(this, 3, 0.85f, 0.065f));
        this.goalSelector.addGoal(3, new HoverGoal(this, 1.5f, 0.1f, true, 0));
        this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Animal.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 40D)
                .add(Attributes.FOLLOW_RANGE, 80D)
                .add(Attributes.ARMOR, 6.0f)
                .add(Attributes.ARMOR_TOUGHNESS, 2.0f)
                .add(Attributes.KNOCKBACK_RESISTANCE, 0.8f);
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

    public void tick() {
        super.tick();

        if(this.getGroundDistance() > 10) {
            this.addDeltaMovement(new Vec3(0, -0.1f, 0));;
        }

        LivingEntity target = this.getTarget();
        if(!this.level().isClientSide() && target != null) {
            this.entityData.set(TARGET_POS, target.position().toVector3f());
        }
        Vec3 targetPos = new Vec3(this.entityData.get(TARGET_POS));

        for (int i=0; i<2; i++) {
            FabrikAnimator legAnimator = legAnimators[i];
            int bodySide = 1;
            if(i%2 == 0) bodySide = -1;

            Vec3 direction = Vec3.directionFromRotation(0, this.yBodyRot);
            Vec3 legRoot = this.position()
                    .add(direction.cross(new Vec3(0, 1, 0)).normalize().scale(10/16f*bodySide))
                    .add(new Vec3(0, 0.75, 0));
            legAnimator.setRoot(legRoot);

            if(this.position().distanceTo(targetPos) > 3) {
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
            // Grab player visually
            else {
                // Extend arms visually toward target
                Vec3 toTarget = targetPos.subtract(legRoot);
                double dist = toTarget.length();
                Vec3 dir = toTarget.normalize();

                // smoothly move the arm end toward the target
                Vec3 desiredPos = legRoot.add(dir.scale(Math.min(dist, 3.5))); // cap reach distance
                Vec3 currentEnd = legAnimator.chainEndPos();

                // simple smoothing for visual stability
                Vec3 smoothed = currentEnd.add(desiredPos.subtract(currentEnd).scale(0.25));
                legAnimator.setFabrikTarget(smoothed);

                // Server-side interaction: pull target slightly toward grappler
                if (target != null && this.distanceTo(target) < 3) {
                    System.out.println("PULL");
                    Vec3 pullDir = this.position().subtract(target.position()).normalize();
                    target.addDeltaMovement(pullDir.scale(0.08));
                    target.hurtMarked = true;
                    this.addDeltaMovement(pullDir.scale(0.04));
                }

            }

        }
        tickMultipart();
    }

    @Override
    public boolean hurt(DamageSource pSource, float pAmount) {
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
        this.entityData.define(TARGET_POS, new Vector3f(0,0,0));
    }

    @Override
    public void die(DamageSource pDamageSource) {
        InvasionData data = InvasionData.get(this.getServer().getLevel(Level.OVERWORLD));
        data.addProgress(DEATH_VALUE);
        super.die(pDamageSource);
    }
}
