package net.jelly.marionette_lib.entity.invasion.spider;

import net.jelly.marionette_lib.entity.examples.octopus.OctopusPartEntity;
import net.jelly.marionette_lib.entity.goals.HoverGoal;
import net.jelly.marionette_lib.entity.goals.IHoverEntity;
import net.jelly.marionette_lib.entity.goals.MoveTowardTargetGoal;
import net.jelly.marionette_lib.entity.invasion.drone.DroneEntity;
import net.jelly.marionette_lib.utility.FabrikAnimator;
import net.jelly.marionette_lib.utility.ProceduralAnimatable;
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

public class SpiderEntity extends FlyingMob implements ProceduralAnimatable, IHoverEntity {
    private final SpiderPartEntity[] allParts;
    FabrikAnimator[] legAnimators = new FabrikAnimator[4];
    private static final EntityDataAccessor<Vector3f> TARGET_POS = SynchedEntityData.defineId(SpiderEntity.class, EntityDataSerializers.VECTOR3);

    private SpiderPartEntity[] createLeg() {
        SpiderPartEntity legPart1 = new SpiderPartEntity(this, 16f/16, 16f/16, 20f/16);
        SpiderPartEntity legPart2 = new SpiderPartEntity(this, 16f/16, 16f/16, 18f/16);
        SpiderPartEntity legPart3 = new SpiderPartEntity(this, 16f/16, 16f/16, 18f/16);
        SpiderPartEntity legPart4 = new SpiderPartEntity(this, 16f/16, 16f/16, 18f/16);
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
        this.goalSelector.addGoal(2, new MoveTowardTargetGoal(this, 3, 0.85f, 0.065f));
        this.goalSelector.addGoal(3, new HoverGoal(this, 2.5f, 0.1f, true, 0));
        this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));
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

        if(this.getGroundDistance() > 1.75) {
            this.addDeltaMovement(new Vec3(0, -0.1f, 0));;
        }

        for (int i = 0; i < 4; i++) {
            FabrikAnimator legAnimator = legAnimators[i];

            // Forward/back and left/right base offsets (in local body space)
            double forwardRootOffset = (i < 2) ? 0.6 : -0.6;  // front/back
            double sideRootOffset = (i % 2 == 0) ? -0.6 : 0.6; // left/right

            double forwardRestOffset = (i < 2) ? 2.6 : -1.6;  // front/back
            double sideRestOffset = (i % 2 == 0) ? -1.0 : 1.0; // left/right

            Vec3 forward = Vec3.directionFromRotation(0, this.yBodyRot).normalize();
            Vec3 right = forward.cross(new Vec3(0, 1, 0)).normalize();

            // Compute unique leg root per limb
            Vec3 legRoot = this.position()
                    .add(forward.scale(forwardRootOffset))
                    .add(right.scale(sideRootOffset))
                    .add(new Vec3(0, 0.15, 0));
            legAnimator.setRoot(legRoot);

            // Compute rest position — down and outward a bit
            Vec3 legRest = this.position()
                    .add(forward.scale(forwardRestOffset))
                    .add(right.scale(sideRestOffset))
                    .add(new Vec3(0, -2.5f, 0));

            Vec3 restPos = legRest;

            Vec3 chainEndPos = legAnimator.chainEndPos();

            legAnimator.setFabrikTarget(legRoot.add(forward.scale(forwardRootOffset*10))
                                        .add(right.scale(sideRootOffset*10)));
            legAnimator.primeMultipart(); // prime leg in the legs direction

            if (chainEndPos.distanceTo(restPos) > 0.05) {
                Vec3 toRest = restPos.subtract(chainEndPos);
                legAnimator.setFabrikTarget(
                        chainEndPos
                                .add(toRest.normalize().scale(0.15))
                                .add(toRest.scale(0.1))
                );
            }
            else legAnimator.setFabrikTarget(chainEndPos);
        }



        tickMultipart();
    }


    public static AttributeSupplier.Builder createAttributes() {
        return Animal.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 20D)
                .add(Attributes.KNOCKBACK_RESISTANCE, 100)
                .add(Attributes.FOLLOW_RANGE, 80D)
                .add(Attributes.MOVEMENT_SPEED, 0.25D)
                .add(Attributes.ARMOR_TOUGHNESS, 0.1f)
                .add(Attributes.ATTACK_KNOCKBACK, 0.5f)
                .add(Attributes.ATTACK_DAMAGE, 2f);
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

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(TARGET_POS, new Vector3f(0,0,0));
    }
}
