package net.jelly.exo_ascension.entity.invasion.aetherion;

import net.jelly.exo_ascension.entity.goals.IHoverEntity;
import net.jelly.exo_ascension.entity.goals.aetherion.AetherionMoveTowardTargetGoal;
import net.jelly.exo_ascension.entity.goals.spider.SpiderMoveTowardTargetGoal;
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
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.entity.PartEntity;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;

public class AetherionBoss extends FlyingMob implements ProceduralAnimatable, IHoverEntity {
    public static final int DEATH_VALUE = 7;
    private final AetherionPartEntity[] allParts;
    FabrikAnimator[] armAnimators = new FabrikAnimator[4];
    Vec3[] restPos = new Vec3[4];
    private static final EntityDataAccessor<Integer> GROUND_POS_1 = SynchedEntityData.defineId(AetherionBoss.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> GROUND_POS_2 = SynchedEntityData.defineId(AetherionBoss.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> GROUND_POS_3 = SynchedEntityData.defineId(AetherionBoss.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> GROUND_POS_4 = SynchedEntityData.defineId(AetherionBoss.class, EntityDataSerializers.INT);

    private AetherionPartEntity[] createLeg() {
        AetherionPartEntity legPart1 = new AetherionPartEntity(this, 16f/16, 16f/16, 20f/16);
        AetherionPartEntity legPart2 = new AetherionPartEntity(this, 12f/16, 12f/16, 18f/16);
        AetherionPartEntity legPart3 = new AetherionPartEntity(this, 12f/16, 12f/16, 18f/16);
        AetherionPartEntity legPart4 = new AetherionPartEntity(this, 12f/16, 12f/16, 18f/16);
        AetherionPartEntity[] parts  = new AetherionPartEntity[]
                {legPart1, legPart2, legPart3, legPart4};
        return parts;
    }

    public AetherionBoss(EntityType entityType, Level level) {
        super(entityType, level);
        float scale = AetherionRenderer.MODEL_SCALE;

        AetherionPartEntity specialArm11 = new AetherionPartEntity(this, 16f/16, 16f/16, scale*37f/16);
        AetherionPartEntity specialArm12 = new AetherionPartEntity(this, 12f/16, 12f/16, scale*37f/16);
        AetherionPartEntity specialArm13 = new AetherionPartEntity(this, scale*37f/16, scale*37f/16, scale*37f/16);
        armAnimators[0] = new FabrikAnimator(this, new AetherionPartEntity[]
                {specialArm11, specialArm12, specialArm13});
        AetherionPartEntity laserArm11 = new AetherionPartEntity(this, 16f/16, 16f/16, scale*30f/16);
        AetherionPartEntity laserArm12 = new AetherionPartEntity(this, 12f/16, 12f/16, scale*30f/16);
        AetherionPartEntity laserArm13 = new AetherionPartEntity(this, 12f/16, 12f/16, scale*37f/16);
        AetherionPartEntity laserArm14 = new AetherionPartEntity(this, scale*37f/16, scale*37f/16, scale*37f/16);
        armAnimators[1] = new FabrikAnimator(this, new AetherionPartEntity[]
                {laserArm11, laserArm12, laserArm13, laserArm14});
        AetherionPartEntity specialArm21 = new AetherionPartEntity(this, 16f/16, 16f/16, scale*37f/16);
        AetherionPartEntity specialArm22 = new AetherionPartEntity(this, 12f/16, 12f/16, scale*37f/16);
        AetherionPartEntity specialArm23 = new AetherionPartEntity(this, scale*37f/16, scale*37f/16, scale*37f/16);
        armAnimators[2] = new FabrikAnimator(this, new AetherionPartEntity[]
                {specialArm21, specialArm22, specialArm23});
        AetherionPartEntity laserArm21 = new AetherionPartEntity(this, 16f/16, 16f/16, scale*30f/16);
        AetherionPartEntity laserArm22 = new AetherionPartEntity(this, 12f/16, 12f/16, scale*30f/16);
        AetherionPartEntity laserArm23 = new AetherionPartEntity(this, 12f/16, 12f/16, scale*37f/16);
        AetherionPartEntity laserArm24 = new AetherionPartEntity(this, scale*37f/16, scale*37f/16, scale*37f/16);
        armAnimators[3] = new FabrikAnimator(this, new AetherionPartEntity[]
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
        this.goalSelector.addGoal(2, new AetherionMoveTowardTargetGoal(this, 2, 0.15f, 0.035f));
//        this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Animal.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 40D)
                .add(Attributes.FOLLOW_RANGE, 80D)
                .add(Attributes.ARMOR, 8.0f)
                .add(Attributes.ARMOR_TOUGHNESS, 3.0f)
                .add(Attributes.KNOCKBACK_RESISTANCE, 0.6f);
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
    public void tick() {
        super.tick();

        float scale = AetherionRenderer.MODEL_SCALE;

        // Apply gentle hover damping
        if (this.getGroundDistance() > 20) this.addDeltaMovement(new Vec3(0, -0.1f, 0));
        if (this.getGroundDistance() < 10) this.addDeltaMovement(new Vec3(0, 0.05f, 0));

        // Extract orientation vectors
        Vec3 forward = Vec3.directionFromRotation(this.xRotO, this.yBodyRot).normalize();
        Vec3 right = forward.cross(new Vec3(0, 1, 0)).normalize();
        Vec3 up = right.cross(forward).normalize();

        System.out.println(up);

        for (int i = 0; i < 4; i++) {
            FabrikAnimator arm = armAnimators[i];

//            arm.setFabrikTarget(this.position().add(0,100,0));
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
                                        .scale(this.getDeltaMovement().dot(toRest) * 0.15f * damping))
                                .add(toRest.scale(0.1 * damping))
                                .add(toRest.normalize().scale(0.1))
                );
            } else {
                arm.setFabrikTarget(chainEnd);
            }

        }

        // Apply part transforms
        tickMultipart();
    }




    @Override
    public boolean hurt(DamageSource pSource, float pAmount) {
        System.out.println("ouch: " + pAmount + ", " + (this.level().isClientSide ? "client" : "server"));
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

    public void setLegGroundY(int i, int y) {
        switch (i) {
            case 1:
                this.entityData.set(GROUND_POS_1, y);
            case 2:
                this.entityData.set(GROUND_POS_2, y);
            case 3:
                this.entityData.set(GROUND_POS_3, y);
            case 4:
                this.entityData.set(GROUND_POS_4, y);
        }
    }

    public int getLegGroundY(int i) {
        switch (i) {
            case 1:
                return this.entityData.get(GROUND_POS_1);
            case 2:
                return this.entityData.get(GROUND_POS_2);
            case 3:
                return this.entityData.get(GROUND_POS_3);
            default:
                return this.entityData.get(GROUND_POS_4);
        }
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(GROUND_POS_1, 0);
        this.entityData.define(GROUND_POS_2, 0);
        this.entityData.define(GROUND_POS_3, 0);
        this.entityData.define(GROUND_POS_4, 0);
    }

    @Override
    public void die(DamageSource pDamageSource) {
        InvasionData data = InvasionData.get(this.getServer().getLevel(Level.OVERWORLD));
        data.addProgress(DEATH_VALUE);
        super.die(pDamageSource);
    }
}
