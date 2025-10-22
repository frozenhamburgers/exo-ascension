package net.jelly.exo_ascension.entity.invasion.aetherion;

import net.jelly.exo_ascension.entity.goals.IHoverEntity;
import net.jelly.exo_ascension.entity.goals.aetherion.AetherionMoveTowardTargetGoal;
import net.jelly.exo_ascension.entity.invasion.drone.DroneEntity;
import net.jelly.exo_ascension.global.invasion.InvasionData;
import net.jelly.exo_ascension.utility.AbstractPartEntity;
import net.jelly.exo_ascension.utility.FabrikAnimator;
import net.jelly.exo_ascension.utility.ProceduralAnimatable;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.FlyingMob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.BodyRotationControl;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.entity.PartEntity;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector3f;

import java.util.ArrayList;

public class AetherionBoss extends FlyingMob implements ProceduralAnimatable, IHoverEntity {
    public static final int DEATH_VALUE = 7;
    private final AetherionPartEntity[] allParts;
    AetherionArmAnimator[] armAnimators = new AetherionArmAnimator[4];
    private static final EntityDataAccessor<Vector3f> TARGET_POS = SynchedEntityData.defineId(AetherionBoss.class, EntityDataSerializers.VECTOR3);
    private static final int ATTACK_COOLDOWN = 200;
    private int nextAttack = ATTACK_COOLDOWN;
    private static final EntityDataAccessor<Float> ARM_0_HP = SynchedEntityData.defineId(AetherionBoss.class, EntityDataSerializers.FLOAT);
    private static final EntityDataAccessor<Float> ARM_1_HP = SynchedEntityData.defineId(AetherionBoss.class, EntityDataSerializers.FLOAT);
    private static final EntityDataAccessor<Float> ARM_2_HP = SynchedEntityData.defineId(AetherionBoss.class, EntityDataSerializers.FLOAT);
    private static final EntityDataAccessor<Float> ARM_3_HP = SynchedEntityData.defineId(AetherionBoss.class, EntityDataSerializers.FLOAT);

    public AetherionBoss(EntityType entityType, Level level) {
        super(entityType, level);
        float scale = AetherionRenderer.MODEL_SCALE;

        AetherionPartEntity specialArm11 = new AetherionPartEntity(this, 16f/16, 16f/16, scale*37f/16, 0);
        AetherionPartEntity specialArm12 = new AetherionPartEntity(this, 12f/16, 12f/16, scale*37f/16, 0);
        AetherionPartEntity specialArm13 = new AetherionPartEntity(this, scale*37f/16, scale*37f/16, scale*37f/16, 0);
        armAnimators[0] = new AetherionLaserArmAnimator(this, new AetherionPartEntity[]
                {specialArm11, specialArm12, specialArm13});
        AetherionPartEntity laserArm11 = new AetherionPartEntity(this, 16f/16, 16f/16, scale*30f/16, 1);
        AetherionPartEntity laserArm12 = new AetherionPartEntity(this, 12f/16, 12f/16, scale*30f/16, 1);
        AetherionPartEntity laserArm13 = new AetherionPartEntity(this, 12f/16, 12f/16, scale*37f/16, 1);
        AetherionPartEntity laserArm14 = new AetherionPartEntity(this, scale*37f/16, scale*37f/16, scale*37f/16, 1);
        armAnimators[1] = new AetherionLaserArmAnimator(this, new AetherionPartEntity[]
                {laserArm11, laserArm12, laserArm13, laserArm14});
        AetherionPartEntity specialArm21 = new AetherionPartEntity(this, 16f/16, 16f/16, scale*37f/16, 2);
        AetherionPartEntity specialArm22 = new AetherionPartEntity(this, 12f/16, 12f/16, scale*37f/16, 2);
        AetherionPartEntity specialArm23 = new AetherionPartEntity(this, scale*37f/16, scale*37f/16, scale*37f/16, 2);
        armAnimators[2] = new AetherionLaserArmAnimator(this, new AetherionPartEntity[]
                {specialArm21, specialArm22, specialArm23});
        AetherionPartEntity laserArm21 = new AetherionPartEntity(this, 16f/16, 16f/16, scale*30f/16, 3);
        AetherionPartEntity laserArm22 = new AetherionPartEntity(this, 12f/16, 12f/16, scale*30f/16, 3);
        AetherionPartEntity laserArm23 = new AetherionPartEntity(this, 12f/16, 12f/16, scale*37f/16, 3);
        AetherionPartEntity laserArm24 = new AetherionPartEntity(this, scale*37f/16, scale*37f/16, scale*37f/16, 3);
        armAnimators[3] = new AetherionLaserArmAnimator(this, new AetherionPartEntity[]
                {laserArm21, laserArm22, laserArm23, laserArm24});

        allParts = new AetherionPartEntity[]
                {specialArm11, specialArm12, specialArm13,
                        laserArm11, laserArm12, laserArm13, laserArm14,
                        specialArm21, specialArm22, specialArm23,
                        laserArm21, laserArm22, laserArm23, laserArm24
                };

        this.lookControl = new DroneEntity.DroneLookControl(this);

        // goals
        this.goalSelector.addGoal(0, new NearestAttackableTargetGoal<>(this, Player.class, false));
        this.goalSelector.addGoal(2, new AetherionMoveTowardTargetGoal(this, 20, 0.15f, 0.035f));
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Animal.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 200D)
                .add(Attributes.FOLLOW_RANGE, 200D)
                .add(Attributes.ARMOR, 20.0f)
                .add(Attributes.ARMOR_TOUGHNESS, 5.0f)
                .add(Attributes.KNOCKBACK_RESISTANCE, 100f);
    }

    @Override
    public ArrayList<FabrikAnimator> getAnimators() {
        ArrayList<FabrikAnimator> animators = new ArrayList<>();
        animators.add(armAnimators[0]);
        animators.add(armAnimators[1]);
        animators.add(armAnimators[2]);
        animators.add(armAnimators[3]);
        return animators;
    }

    @Override
    public void tick() {
        super.tick();

        // Apply gentle hover damping
        if (this.getGroundDistance() > 20) this.addDeltaMovement(new Vec3(0, -0.1f, 0));
        if (this.getGroundDistance() < 10) this.addDeltaMovement(new Vec3(0, 0.05f, 0));

        // maintain synched target posiiton
        if(this.getTarget() != null) {
            LivingEntity target = this.getTarget();
            this.lookAt(target, 2, 2);
            if (!this.level().isClientSide) this.entityData.set(TARGET_POS, target.position().toVector3f());
        }
        else if (!this.level().isClientSide) this.entityData.set(TARGET_POS, null);

        // maintain
        tickArmControl();

        // common side logic for attacks
        for (int i = 0; i < 4; i++) {
            AetherionArmAnimator arm = armAnimators[i];
            if(getArmHP(i) <= 0) {
                arm.setAiming(false);
                continue;
            }

            if(entityData.get(TARGET_POS) != null) { // if target exists
                Vec3 targetPos = new Vec3(entityData.get(TARGET_POS));
                arm.setAiming(true);
                arm.aimAt(targetPos, 0.5f, 0.5f);

                boolean isSpecial = (i == 0 || i == 2); // indices 0, 2 = short lower special arms
                // laser attack
                arm.beginAttack();

                if(isSpecial) {
                }
            }
            else {
                arm.setAiming(false);
                if(arm.prevEnd != null) arm.aimAt(arm.prevEnd, 2, 2); // gradually reset to rest position
            }

            arm.tickArm();
        }


        // finalize all arms
        for (AetherionArmAnimator arm : armAnimators) arm.finalize();

    }

    private void tickArmControl() {
        Vec3 forward = Vec3.directionFromRotation(this.xRotO, this.yBodyRot).normalize();
        Vec3 right = forward.cross(new Vec3(0, 1, 0)).normalize();
        Vec3 up = right.cross(forward).normalize();
        float scale = AetherionRenderer.MODEL_SCALE;

        for (int i = 0; i < 4; i++) {
            AetherionArmAnimator arm = armAnimators[i];

            // if arm is destroyed
            if(getArmHP(i) <= 0) {
                arm.setFollowRootOnly(true);
                if(arm.chainRoot().y > -150) arm.setRoot(arm.chainRoot().subtract(new Vec3(0,0.25, 0)));
                continue;
            }

            // --- IF LIMB IS SHOOTING, MANUALLY RESET END EFFECTOR TO PREVIOUS END POS BEFORE FABRIK
            if(arm.getPrevEnd() != null ) {
                AbstractPartEntity[] parts = arm.getParts();
                Vec3 preCannonArmPos = parts[parts.length - 2].getEndPos();
                Vec3 prevDir = arm.getPrevEnd().subtract(preCannonArmPos).normalize();
                parts[parts.length - 1].setPartDirection(prevDir);
                parts[parts.length - 1].setRootPos(preCannonArmPos);
            }

            int side = (i < 2) ? -1 : 1; // left (-1), right (+1)

            boolean isSpecial = (i == 0 || i == 2); // indices 0, 2 = short lower special arms

            // --- Local-space root positions (scaled) ---
            Vec3 localRoot = isSpecial
//                    ? new Vec3(-19f / 16f * side, 29f / 16f, 0f / 16f)
                    ? new Vec3(19f / 16f * side, 16f / 16f, -0f / 16f)
                    : new Vec3(19f / 16f * side, 32f / 16f, 4f / 16f);
            localRoot = localRoot.scale(scale);

            // --- Convert root to world space ---
            Vec3 armRoot = this.position()
                    .add(forward.scale(localRoot.z))
                    .add(right.scale(localRoot.x))
                    .add(up.scale(localRoot.y));

            arm.setRoot(armRoot);

                // --- Define rest position offset in local space ---
            Vec3 localRest = isSpecial
                    ? new Vec3(45f / 16f * side, -32f / 16f, 40f / 16f)
                    : new Vec3(45f / 16f * side, 60f / 16f, 30f / 16f);
            localRest = localRest.scale(scale);

            // --- Convert rest position to world space ---
            Vec3 restPos = this.position()
                    .add(forward.scale(localRest.z))
                    .add(right.scale(localRest.x))
                    .add(up.scale(localRest.y));

            // --- Get chain end position (current end effector) ---
            Vec3 chainEnd = arm.chainEndPos();

            // --- PRIME LIMB ---
            Vec3 localPrime = isSpecial
                    ? new Vec3(0.2 * side,-0.1,-1)
                    : new Vec3(0.2 * side,0.1,-1);
            localPrime = localPrime.normalize().scale(100*scale);

            // --- Convert rest position to world space ---
            Vec3 globalPrime = this.position()
                    .add(forward.scale(localPrime.z))
                    .add(right.scale(localPrime.x))
                    .add(up.scale(localPrime.y));

            // prime arms before setting final target
            arm.setFabrikTarget(globalPrime);
            arm.primeMultipart();


            // --- Compute relative offset ---
            Vec3 toRest = restPos.subtract(chainEnd);
            double horizontalSpeed = new Vec3(this.getDeltaMovement().x, 0, this.getDeltaMovement().z).length();
            double damping = 1.0 / (horizontalSpeed + 1.0);

            // --- Compute target with velocity-aware smoothing ---
            if (toRest.length() > 0.1) {
                arm.setFabrikTarget(
                        chainEnd
                                .add(toRest.normalize()
                                        .scale(this.getDeltaMovement().dot(toRest) * 0.05f * damping))
                                .add(toRest.scale(0.05 * damping))
                                .add(toRest.normalize().scale(0.1))
                );
            } else {
                arm.setFabrikTarget(chainEnd);
            }

        }

        // Apply part transforms
        tickMultipart();
    }

    public void hurtArm(int index, float amount) {
        System.out.println("arm " + index + ": ouch!");
        setArmHP(index, Math.max(getArmHP(index)-amount, 0));
        System.out.println(getArmHP(index));
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

    private static final EntityDataAccessor<Float>[] ARM_HPS = new EntityDataAccessor[]{
            ARM_0_HP, ARM_1_HP, ARM_2_HP, ARM_3_HP
    };

    public void setArmHP(int i, float hp) {
        if (i >= 0 && i < ARM_HPS.length)
            this.entityData.set(ARM_HPS[i], hp);
    }

    public float getArmHP(int i) {
        if (i >= 0 && i < ARM_HPS.length)
            return this.entityData.get(ARM_HPS[i]);
        return 0;
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(TARGET_POS, new Vector3f(0,0,0));
        this.entityData.define(ARM_0_HP, 75f);
        this.entityData.define(ARM_1_HP, 75f);
        this.entityData.define(ARM_2_HP, 75f);
        this.entityData.define(ARM_3_HP, 75f);
    }

    @Override
    public boolean isPersistenceRequired() {
        return true;
    }

    @Override
    public boolean fireImmune() {
        return true;
    }
    class AetherionBodyRotationControl extends BodyRotationControl {
        public AetherionBodyRotationControl(Mob pMob) {
            super(pMob);
        }
        public void clientTick() {
            AetherionBoss.this.yHeadRot = AetherionBoss.this.yBodyRot;
            AetherionBoss.this.yBodyRot = AetherionBoss.this.getYRot();
        }
    }

    protected BodyRotationControl createBodyControl() {
        return new AetherionBodyRotationControl(this);
    }

    @Override
    public boolean shouldRenderAtSqrDistance(double pDistance) {
        return true;
    }

    @Override
    public void die(DamageSource pDamageSource) {
        if(!this.level().isClientSide) {
            InvasionData data = InvasionData.get(this.getServer().getLevel(Level.OVERWORLD));
            data.addProgress(DEATH_VALUE);
        }
        super.die(pDamageSource);
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

    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        for (int i = 0; i < 4; i++) {
            String key = "arm_" + i + "_hp";
            if (tag.contains(key, Tag.TAG_FLOAT)) {
                setArmHP(i,tag.getFloat(key));
            }
        }
    }

    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        tag.putFloat("arm_0_hp", getArmHP(0));
        tag.putFloat("arm_1_hp", getArmHP(1));
        tag.putFloat("arm_2_hp", getArmHP(2));
        tag.putFloat("arm_3_hp", getArmHP(3));
    }
}
