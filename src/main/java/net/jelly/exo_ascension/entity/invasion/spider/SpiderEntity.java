package net.jelly.exo_ascension.entity.invasion.spider;

import net.jelly.exo_ascension.entity.goals.IHoverEntity;
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

public class SpiderEntity extends FlyingMob implements ProceduralAnimatable, IHoverEntity {
    public static final int DEATH_VALUE = 7;
    private final SpiderPartEntity[] allParts;
    FabrikAnimator[] legAnimators = new FabrikAnimator[4];
    Vec3[] restPos = new Vec3[4];
    private static final EntityDataAccessor<Integer> GROUND_POS_1 = SynchedEntityData.defineId(SpiderEntity.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> GROUND_POS_2 = SynchedEntityData.defineId(SpiderEntity.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> GROUND_POS_3 = SynchedEntityData.defineId(SpiderEntity.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> GROUND_POS_4 = SynchedEntityData.defineId(SpiderEntity.class, EntityDataSerializers.INT);

    private SpiderPartEntity[] createLeg() {
        SpiderPartEntity legPart1 = new SpiderPartEntity(this, 16f/16, 16f/16, 20f/16);
        SpiderPartEntity legPart2 = new SpiderPartEntity(this, 12f/16, 12f/16, 18f/16);
        SpiderPartEntity legPart3 = new SpiderPartEntity(this, 12f/16, 12f/16, 18f/16);
        SpiderPartEntity legPart4 = new SpiderPartEntity(this, 12f/16, 12f/16, 18f/16);
        SpiderPartEntity[] parts  = new SpiderPartEntity[]
                {legPart1, legPart2, legPart3, legPart4};
        return parts;
    }

    public SpiderEntity(EntityType entityType, Level level) {
        super(entityType, level);
        SpiderPartEntity[] leg1 = createLeg();
        legAnimators[0] = new FabrikAnimator(this, leg1);
        SpiderPartEntity[] leg2 = createLeg();
        legAnimators[1] = new FabrikAnimator(this, leg2);
        SpiderPartEntity[] leg3 = createLeg();
        legAnimators[2] = new FabrikAnimator(this, leg3);
        SpiderPartEntity[] leg4 = createLeg();
        legAnimators[3] = new FabrikAnimator(this, leg4);
        allParts = new SpiderPartEntity[]
                {leg1[0], leg1[1], leg1[2], leg1[3],
                        leg2[0], leg2[1], leg2[2], leg2[3],
                        leg3[0], leg3[1], leg3[2], leg3[3],
                        leg4[0], leg4[1], leg4[2], leg4[3]};

        this.lookControl = new DroneEntity.DroneLookControl(this);

        // goals
        this.goalSelector.addGoal(0, new NearestAttackableTargetGoal<>(this, Player.class, false));
        this.goalSelector.addGoal(2, new SpiderMoveTowardTargetGoal(this, 2, 0.15f, 0.035f));
        this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));
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
        animators.add(legAnimators[0]);
        animators.add(legAnimators[1]);
        animators.add(legAnimators[2]);
        animators.add(legAnimators[3]);
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

        if(this.getGroundDistance() > 2.5) {
            this.addDeltaMovement(new Vec3(0, -0.01f, 0));;
        }

        if (this.getGroundDistance() < 2.25f) {
            this.addDeltaMovement(new Vec3(0, 0.01f, 0));
        }

        for (int i = 0; i < 4; i++) {
            FabrikAnimator legAnimator = legAnimators[i];

            // forward/back and left/right base offsets (in local body space)
            double forwardRootOffset = (i < 2) ? 0.6 : -0.6;  // front/back
            double sideRootOffset = (i % 2 == 0) ? -0.6 : 0.6; // left/right

            double forwardRestOffset = (i < 2) ? 2.6 : -1.6;  // front/back
            double sideRestOffset = (i % 2 == 0) ? -1.0 : 1.0; // left/right

            Vec3 forward = Vec3.directionFromRotation(0, this.yBodyRot).normalize();
            Vec3 right = forward.cross(new Vec3(0, 1, 0)).normalize();

            // compute unique leg root per limb
            Vec3 legRoot = this.position()
                    .add(forward.scale(forwardRootOffset))
                    .add(right.scale(sideRootOffset))
                    .add(new Vec3(0, 0.65, 0));
            legAnimator.setRoot(legRoot);

            // compute rest position — down and outward a bit
            Vec3 legRest = this.position()
                    .add(forward.scale(forwardRestOffset))
                    .add(right.scale(sideRestOffset))
                    .add(new Vec3(0, -2.0f, 0));

            // Probe terrain height at rest X/Z
            BlockPos restPosXZ = BlockPos.containing(legRest.x, this.getY() + 2, legRest.z);
            int groundY;
            if(!this.level().isClientSide) {
                groundY = (this.level().getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, restPosXZ.getX(), restPosXZ.getZ()));
                setLegGroundY(i, groundY);
            }
            else groundY = getLegGroundY(i); // heightmap is inverted on client

            // Clamp adjustment to prevent extreme stretching
            double baseY = this.position().y;
            if (Math.abs(groundY - baseY) < 7.0) {
                legRest = new Vec3(legRest.x, groundY - 0.2, legRest.z);
            }
            // step forward
            if(restPos[i] == null || restPos[i].distanceTo(legRest) > 4) restPos[i] = legRest;

            Vec3 chainEndPos = legAnimator.chainEndPos();

            legAnimator.setFabrikTarget(legRoot.add(forward.scale(forwardRootOffset*10))
                                        .add(right.scale(sideRootOffset*10)));
            legAnimator.primeMultipart(); // prime leg in the legs direction

            if (chainEndPos.distanceTo(restPos[i]) > 0.1) {
                Vec3 toRest = restPos[i].subtract(chainEndPos);
                legAnimator.setFabrikTarget(
                        chainEndPos
                                .add(toRest.normalize().scale(0.25))
                                .add(toRest.scale(0.1))
                                .add(toRest.normalize().scale(this.getDeltaMovement().dot(toRest)*0.75f))
                );
            }
            else legAnimator.setFabrikTarget(chainEndPos);
        }
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
