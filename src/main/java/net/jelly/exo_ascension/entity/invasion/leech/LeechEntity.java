package net.jelly.exo_ascension.entity.invasion.leech;

import mod.chloeprime.aaaparticles.api.common.AAALevel;
import mod.chloeprime.aaaparticles.api.common.ParticleEmitterInfo;
import net.jelly.exo_ascension.ExoAscensionMod;
import net.jelly.exo_ascension.entity.invasion.drone.DroneEntity;
import net.jelly.exo_ascension.global.invasion.InvasionData;
import net.jelly.exo_ascension.utility.ProceduralAnimatable;
import net.jelly.exo_ascension.utility.FabrikAnimator;
import net.minecraft.commands.arguments.EntityAnchorArgument;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.entity.PartEntity;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.EnumSet;
import java.util.List;

public class LeechEntity extends FlyingMob implements ProceduralAnimatable {
    public static final int DEATH_VALUE = 5;
    private final LeechPartEntity[] allBodyParts;
    private final LeechPartEntity[] allParts;
    public static final int MAX_CHARGE = 30;
    FabrikAnimator bodyAnimator;
    Vec3 restPos = new Vec3(999, 999, 999);
    float moveYRot = 0;

    FabrikAnimator[] legAnimators = new FabrikAnimator[4];
    boolean[] legStatus = new boolean[4];
    private AttackPhase attackPhase = AttackPhase.CIRCLE;
    BlockPos anchorPoint = BlockPos.ZERO;
    Vec3 moveTargetPoint = Vec3.ZERO;
    boolean leeched = false;

    boolean laserPresent = false;
    int laserTimer = 0;

    private static final ParticleEmitterInfo LASER_PARTICLE = new ParticleEmitterInfo(new ResourceLocation(ExoAscensionMod.MODID, "laser/blue_laser"));
    ParticleEmitterInfo laser;

    private static final EntityDataAccessor<Integer> CHARGE = SynchedEntityData.defineId(LeechEntity.class, EntityDataSerializers.INT);



    public LeechEntity(EntityType entityType, Level level) {
        super(entityType, level);
        this.lookControl = new DroneEntity.DroneLookControl(this);
        this.moveControl = new LeechMoveControl(this);

        LeechPartEntity tail1Part = new LeechPartEntity(this, 0.5F, 0.5F, 0.5f);
        LeechPartEntity tail2Part = new LeechPartEntity(this, 0.5F, 0.5F, 0.5f);
        LeechPartEntity tail3Part = new LeechPartEntity(this, 0.5F, 0.5F, 0.5f);
        LeechPartEntity tail4Part = new LeechPartEntity(this, 0.5F, 0.5F, 0.5f);
        LeechPartEntity tail5Part = new LeechPartEntity(this, 0.5F, 0.5F, 0.5f);
        LeechPartEntity tail6Part = new LeechPartEntity(this, 0.5F, 0.5F, 0.5f);
        LeechPartEntity tail7Part = new LeechPartEntity(this, 0.5F, 0.5F, 0.5f);
        LeechPartEntity tail8Part = new LeechPartEntity(this, 0.5F, 0.5F, 0.5f);
        LeechPartEntity tail9Part = new LeechPartEntity(this, 0.5F, 0.5F, 0.5f);
        LeechPartEntity tail10Part = new LeechPartEntity(this, 0.5F, 0.5F, 0.5f);
        allBodyParts = new LeechPartEntity[]{tail1Part, tail2Part, tail3Part, tail4Part, tail5Part, tail6Part, tail7Part, tail8Part, tail9Part, tail10Part};
        bodyAnimator = new FabrikAnimator(this, allBodyParts);
        bodyAnimator.setFollowRootOnly(true);

        LeechPartEntity leg1Part1 = new LeechPartEntity(this, 0.25F, 0.25F, 8/16f);
        LeechPartEntity leg1Part2 = new LeechPartEntity(this, 0.25F, 0.25F, 10/16f);
        LeechPartEntity leg1Part3 = new LeechPartEntity(this, 0.25F, 0.25F, 16/16f);
        legAnimators[0] = new FabrikAnimator(this, new LeechPartEntity[]{leg1Part1, leg1Part2, leg1Part3});
        LeechPartEntity leg2Part1 = new LeechPartEntity(this, 0.25F, 0.25F, 8/16f);
        LeechPartEntity leg2Part2 = new LeechPartEntity(this, 0.25F, 0.25F, 10/16f);
        LeechPartEntity leg2Part3 = new LeechPartEntity(this, 0.25F, 0.25F, 16/16f);
        legAnimators[1] = new FabrikAnimator(this, new LeechPartEntity[]{leg2Part1, leg2Part2, leg2Part3});
        LeechPartEntity leg3Part1 = new LeechPartEntity(this, 0.25F, 0.25F, 9/16f);
        LeechPartEntity leg3Part2 = new LeechPartEntity(this, 0.25F, 0.25F, 10/16f);
        LeechPartEntity leg3Part3 = new LeechPartEntity(this, 0.25F, 0.25F, 16/16f);
        legAnimators[2] = new FabrikAnimator(this, new LeechPartEntity[]{leg3Part1, leg3Part2, leg3Part3});
        LeechPartEntity leg4Part1 = new LeechPartEntity(this, 0.25F, 0.25F, 9/16f);
        LeechPartEntity leg4Part2 = new LeechPartEntity(this, 0.25F, 0.25F, 10/16f);
        LeechPartEntity leg4Part3 = new LeechPartEntity(this, 0.25F, 0.25F, 16/16f);
        legAnimators[3] = new FabrikAnimator(this, new LeechPartEntity[]{leg4Part1, leg4Part2, leg4Part3});

        // allParts must still have all parts
        allParts = new LeechPartEntity[]{tail1Part, tail2Part, tail3Part, tail4Part, tail5Part, tail6Part, tail7Part, tail8Part, tail9Part, tail10Part,
                leg1Part1, leg1Part2, leg1Part3,
                leg2Part1, leg2Part2, leg2Part3,
                leg3Part1, leg3Part2, leg3Part3,
                leg4Part1, leg4Part2, leg4Part3
        };
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Animal.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 45D)
                .add(Attributes.FOLLOW_RANGE, 80D)
                .add(Attributes.ARMOR, 2.0f)
                .add(Attributes.ARMOR_TOUGHNESS, 0.5f)
                .add(Attributes.KNOCKBACK_RESISTANCE, 0.1f);
    }

    @Override
    public ArrayList<FabrikAnimator> getAnimators() {
        ArrayList<FabrikAnimator> animators = new ArrayList<>();
        animators.add(bodyAnimator);
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
        for (int i=0; i<4; i++) {
            FabrikAnimator legAnimator = legAnimators[i];
            int rootIndex;
            if(i <= 1) rootIndex = 1;
            else rootIndex = 5;
            LeechPartEntity rootPart = allBodyParts[rootIndex];
            int bodySide = 1;
            if(i%2 == 0) bodySide = -1;

            legAnimator.setRoot(rootPart.position());
            Vec3 direction = allBodyParts[rootIndex-1].position().subtract(rootPart.position()).normalize();
            Vec3 legRest = rootPart.position()
                    .add(direction.cross(new Vec3(0, 1, 0)).normalize().scale(1.5f*bodySide))
                    .add(direction.normalize().scale(1.25f));
            restPos = legRest;

            if (legAnimator.chainEndPos().distanceTo(restPos) > 2f) {
                legStatus[i] = true;
            }

            if (legStatus[i]) {
                legAnimator.setFabrikTarget(legAnimator.chainEndPos()
                        .add(restPos.subtract(legAnimator.chainEndPos()).normalize()
                                .scale(this.getDeltaMovement().dot(restPos.subtract(legAnimator.chainEndPos()))))
                        .add(restPos.subtract(legAnimator.chainEndPos()).scale(0.25))
                        .add(restPos.subtract(legAnimator.chainEndPos()).normalize().scale(0.1))
                );
                if (legAnimator.chainEndPos().distanceTo(restPos) < 0.6) {
                    legStatus[i] = false;
                }
            }
        }

        tickMultipart();

        // laser logic
        if(laserPresent) {
            LivingEntity livingEntity = this.getTarget();
            if(livingEntity != null) LeechEntity.this.lookAt(EntityAnchorArgument.Anchor.EYES, livingEntity.position().add(0,1,0));
            if(laserTimer >= 47 && laserTimer < 134) {
                Vec3 start = this.position().add(0, this.getEyeHeight(), 0);
                Vec3 end = start.add(this.getLookAngle().normalize().scale(15.0));
                var aabb = this.getBoundingBox().expandTowards(this.getLookAngle().scale(15.0)).inflate(0.75);

                for (LivingEntity hit : this.level().getEntitiesOfClass(LivingEntity.class, aabb, e -> e != this && e.isAlive())) {
                    var optionalHit = hit.getBoundingBox().clip(start, end);
                    if (optionalHit.isPresent()) {
                        hit.hurt(this.damageSources().mobAttack(this), 10.0F);
                        Vec3 push = this.getLookAngle().scale(0.1);
                        hit.push(push.x, 0.05, push.z);
                    }
                }
            }
            laserTimer++;
            if(laserTimer >= 134) {
                laserPresent = false;
                attackPhase = LeechEntity.AttackPhase.CIRCLE;
                setCharge(0);
            }
        }
        else {
            laserTimer = 0;
        }
    }

    @Override
    protected boolean isSunBurnTick() {
        return false;
    }

    @Override
    protected InteractionResult mobInteract(Player pPlayer, InteractionHand pHand) {
        return super.mobInteract(pPlayer, pHand);
    }

    // GOALS


    @Override
    public void push(Entity pEntity) {
    }

    @Override
    public void push(double pX, double pY, double pZ) {
    }

    @Override
    public boolean isPushable() {
        return false;
    }

    @Override
    protected void pushEntities() {
    }

    @Override
    public boolean canCollideWith(Entity pEntity) {
        return false;
    }

    @Override
    public boolean canBeCollidedWith() {
        return false;
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(1, new AttackStrategyGoal());
        this.goalSelector.addGoal(2, new SweepAttackGoal());
        this.goalSelector.addGoal(3, new CircleAroundAnchorGoal());
        this.targetSelector.addGoal(1, new AttackPlayerTargetGoal());
    }

    public SpawnGroupData finalizeSpawn(ServerLevelAccessor pLevel, DifficultyInstance pDifficulty, MobSpawnType pReason, @javax.annotation.Nullable SpawnGroupData pSpawnData, @javax.annotation.Nullable CompoundTag pDataTag) {
        this.anchorPoint = this.blockPosition().above(20 + this.random.nextInt(20));
        return super.finalizeSpawn(pLevel, pDifficulty, pReason, pSpawnData, pDataTag);
    }
    static enum AttackPhase {
        CIRCLE,
        SWOOP;
    }

    public class AttackPlayerTargetGoal extends Goal {
        private final TargetingConditions attackTargeting = TargetingConditions.forCombat().range(64.0D);
        private int nextScanTick = reducedTickDelay(20);

        AttackPlayerTargetGoal() {
        }

        public boolean canUse() {
            if (this.nextScanTick > 0) {
                --this.nextScanTick;
                return false;
            } else {
                this.nextScanTick = reducedTickDelay(60);
                List<Player> list = LeechEntity.this.level().getNearbyPlayers(this.attackTargeting, LeechEntity.this, LeechEntity.this.getBoundingBox().inflate(80.0D, 64.0D, 80.0D));
                if (!list.isEmpty()) {
                    list.sort(Comparator.<Entity, Double>comparing(Entity::getY).reversed());

                    for(Player player : list) {
                        if (LeechEntity.this.canAttack(player, TargetingConditions.DEFAULT)) {
                            LeechEntity.this.setTarget(player);
                            return true;
                        }
                    }
                }

                return false;
            }
        }

        public boolean canContinueToUse() {
            LivingEntity livingentity = LeechEntity.this.getTarget();
            return livingentity != null ? LeechEntity.this.canAttack(livingentity, TargetingConditions.DEFAULT) : false;
        }
    }

    public class AttackStrategyGoal extends Goal {
        private int nextSweepTick;

        AttackStrategyGoal() {
        }

        public boolean canUse() {
            LivingEntity livingentity = LeechEntity.this.getTarget();
            return livingentity != null ? LeechEntity.this.canAttack(livingentity, TargetingConditions.DEFAULT) : false;
        }

        public void start() {
            this.nextSweepTick = this.adjustedTickDelay((8 + LeechEntity.this.random.nextInt(4)) * 20);
            LeechEntity.this.attackPhase = LeechEntity.AttackPhase.CIRCLE;
            this.setAnchorAboveTarget();
        }

        public void stop() {
            LeechEntity.this.anchorPoint = LeechEntity.this.level()
                    .getHeightmapPos(Heightmap.Types.MOTION_BLOCKING, LeechEntity.this.anchorPoint)
                    .above(30 + LeechEntity.this.random.nextInt(20));
        }

        public void tick() {
            if (LeechEntity.this.attackPhase == LeechEntity.AttackPhase.CIRCLE) {
                --this.nextSweepTick;
                if (this.nextSweepTick <= 0) {
                    LeechEntity.this.attackPhase = LeechEntity.AttackPhase.SWOOP;
                    this.setAnchorAboveTarget();
                    this.nextSweepTick = this.adjustedTickDelay((8 + LeechEntity.this.random.nextInt(4)) * 20);
                }
            }

        }

        private void setAnchorAboveTarget() {
            LeechEntity.this.anchorPoint = LeechEntity.this.getTarget().blockPosition().above(15 + LeechEntity.this.random.nextInt(10));
            if (LeechEntity.this.anchorPoint.getY() < LeechEntity.this.level().getSeaLevel()) {
                LeechEntity.this.anchorPoint = new BlockPos(LeechEntity.this.anchorPoint.getX(), LeechEntity.this.level().getSeaLevel() + 1, LeechEntity.this.anchorPoint.getZ());
            }

        }
    }

    public class CircleAroundAnchorGoal extends LeechEntity.WyvernEntityMoveTargetGoal {
        private float angle;
        private float distance;
        private float height;
        private float clockwise;

        CircleAroundAnchorGoal() {
        }

        public boolean canUse() {
            return LeechEntity.this.getTarget() == null || LeechEntity.this.attackPhase == LeechEntity.AttackPhase.CIRCLE;
        }

        public void start() {
            this.distance = 5.0F + LeechEntity.this.random.nextFloat() * 10.0F;
            this.height = -4.0F + LeechEntity.this.random.nextFloat() * 9.0F;
            this.clockwise = LeechEntity.this.random.nextBoolean() ? 1.0F : -1.0F;
            this.selectNext();
        }

        public void tick() {
            if (LeechEntity.this.random.nextInt(this.adjustedTickDelay(350)) == 0) {
                this.height = -4.0F + LeechEntity.this.random.nextFloat() * 9.0F;
            }

            if (LeechEntity.this.random.nextInt(this.adjustedTickDelay(250)) == 0) {
                ++this.distance;
                if (this.distance > 15.0F) {
                    this.distance = 5.0F;
                    this.clockwise = -this.clockwise;
                }
            }

            if (LeechEntity.this.random.nextInt(this.adjustedTickDelay(450)) == 0) {
                this.angle = LeechEntity.this.random.nextFloat() * 2.0F * (float)Math.PI;
                this.selectNext();
            }

            if (this.touchingTarget()) {
                this.selectNext();
            }

            if (LeechEntity.this.moveTargetPoint.y < LeechEntity.this.getY() && !LeechEntity.this.level().isEmptyBlock(LeechEntity.this.blockPosition().below(1))) {
                this.height = Math.max(1.0F, this.height);
                this.selectNext();
            }

            if (LeechEntity.this.moveTargetPoint.y > LeechEntity.this.getY() && !LeechEntity.this.level().isEmptyBlock(LeechEntity.this.blockPosition().above(1))) {
                this.height = Math.min(-1.0F, this.height);
                this.selectNext();
            }

        }

        private void selectNext() {
            if (BlockPos.ZERO.equals(LeechEntity.this.anchorPoint)) {
                LeechEntity.this.anchorPoint = LeechEntity.this.blockPosition();
            }

            this.angle += this.clockwise * 15.0F * ((float)Math.PI / 180F);
            LeechEntity.this.moveTargetPoint = Vec3.atLowerCornerOf(LeechEntity.this.anchorPoint).add((double)(this.distance * Mth.cos(this.angle)), (double)(-4.0F + this.height), (double)(this.distance * Mth.sin(this.angle)));
        }
    }

    class LeechMoveControl extends MoveControl {
        private float speed = 0.1F;

        public LeechMoveControl(Mob pMob) {
            super(pMob);
        }

        public void tick() {
            if (LeechEntity.this.horizontalCollision) {
                LeechEntity.this.moveYRot = (LeechEntity.this.getYRot() + 180.0F);
                this.speed = 0.1F;
            }

            double d0 = LeechEntity.this.moveTargetPoint.x - LeechEntity.this.getX();
            double d1 = LeechEntity.this.moveTargetPoint.y - LeechEntity.this.getY();
            double d2 = LeechEntity.this.moveTargetPoint.z - LeechEntity.this.getZ();
            double d3 = Math.sqrt(d0 * d0 + d2 * d2);
            if (Math.abs(d3) > (double)1.0E-5F) {
                double d4 = 1.0D - Math.abs(d1 * (double)0.7F) / d3;
                d0 *= d4;
                d2 *= d4;
                d3 = Math.sqrt(d0 * d0 + d2 * d2);
                double d5 = Math.sqrt(d0 * d0 + d2 * d2 + d1 * d1);
                float f = LeechEntity.this.moveYRot;
                float f1 = (float)Mth.atan2(d2, d0);
                float f2 = Mth.wrapDegrees(LeechEntity.this.moveYRot + 90.0F);
                float f3 = Mth.wrapDegrees(f1 * (180F / (float)Math.PI));
                LeechEntity.this.moveYRot = (Mth.approachDegrees(f2, f3, 4.0F) - 90.0F);
                LeechEntity.this.yBodyRot = LeechEntity.this.moveYRot;
                if (Mth.degreesDifferenceAbs(f, LeechEntity.this.moveYRot) < 3.0F) {
                    this.speed = Mth.approach(this.speed, 1.8F, 0.005F * (1.8F / this.speed));
                } else {
                    this.speed = Mth.approach(this.speed, 0.2F, 0.025F);
                }

                float f4 = (float)(-(Mth.atan2(-d1, d3) * (double)(180F / (float)Math.PI)));
//                WyvernEntity.this.setXRot(f4);
                float f5 = LeechEntity.this.moveYRot + 90.0F;
                double d6 = (double)(this.speed * Mth.cos(f5 * ((float)Math.PI / 180F))) * Math.abs(d0 / d5);
                double d7 = (double)(this.speed * Mth.sin(f5 * ((float)Math.PI / 180F))) * Math.abs(d2 / d5);
                double d8 = (double)(this.speed * Mth.sin(f4 * ((float)Math.PI / 180F))) * Math.abs(d1 / d5);
                Vec3 vec3 = LeechEntity.this.getDeltaMovement();
                LeechEntity.this.setDeltaMovement(vec3.add((new Vec3(d6, d8, d7)).subtract(vec3).scale(0.2D)));
            }

        }
    }

    abstract class WyvernEntityMoveTargetGoal extends Goal {
        public WyvernEntityMoveTargetGoal() {
            this.setFlags(EnumSet.of(Goal.Flag.MOVE));
        }

        protected boolean touchingTarget() {
            return LeechEntity.this.moveTargetPoint.distanceToSqr(LeechEntity.this.getX(), LeechEntity.this.getY(), LeechEntity.this.getZ()) < 4.0D;
        }
    }

    class SweepAttackGoal extends LeechEntity.WyvernEntityMoveTargetGoal {

        boolean chargedAttack = false;
        int chargedAttackTimer = 0;

        public boolean canUse() {
            return LeechEntity.this.getTarget() != null && LeechEntity.this.attackPhase == LeechEntity.AttackPhase.SWOOP;
        }

        public boolean canContinueToUse() {
            LivingEntity livingentity = LeechEntity.this.getTarget();
            if (livingentity == null) {
                return false;
            } else if (!livingentity.isAlive()) {
                return false;
            } else {
                if (livingentity instanceof Player) {
                    Player player = (Player)livingentity;
                    if (livingentity.isSpectator() || player.isCreative()) {
                        return false;
                    }
                }
                return LeechEntity.this.attackPhase == LeechEntity.AttackPhase.SWOOP;
            }
        }

        public void start() {
            laser = LASER_PARTICLE.clone()
                    .bindOnEntity(LeechEntity.this)
                    .entitySpaceRelativePosition(new Vec3(0,0,100000))
                    .useEntityHeadSpace()
                    .scale(0.5f);
            chargedAttack = getCharge() >= MAX_CHARGE;
            chargedAttackTimer = 0;
        }

        public void stop() {
            LeechEntity.this.setTarget(null);
            LeechEntity.this.attackPhase = LeechEntity.AttackPhase.CIRCLE;
            LeechEntity.this.leeched = false;
            if(chargedAttack) setCharge(0);
            chargedAttack = false;
            laser.scale(0);
        }

        public void tick() {
            LivingEntity livingentity = LeechEntity.this.getTarget();
            if (livingentity != null) {

                if(!chargedAttack) { // leeching charging state
                    if (!leeched)
                        LeechEntity.this.moveTargetPoint = new Vec3(livingentity.getX(), livingentity.getY(0.5D), livingentity.getZ());
                    else LeechEntity.this.setPos(livingentity.position());
                    if (LeechEntity.this.getBoundingBox().inflate((double) 0.2F).intersects(livingentity.getBoundingBox())) {
                        livingentity.hurt(LeechEntity.this.damageSources().mobAttack(LeechEntity.this), 3.0F);
                        LeechEntity.this.leeched = true;
                        LeechEntity.this.incrementCharge();
                    }
                    if (LeechEntity.this.hurtTime > 0) {
                        LeechEntity.this.attackPhase = LeechEntity.AttackPhase.CIRCLE;
                        LeechEntity.this.leeched = false;
                    }
                }
                else { // charged laser state
                    if(LeechEntity.this.distanceTo(livingentity) < 10) {
                        if(!laserPresent) {
                            AAALevel.addParticle(LeechEntity.this.level(), false, laser);
                            laserPresent = true;
                        }
                        System.out.println(chargedAttackTimer);
                        chargedAttackTimer++;
                        if(chargedAttackTimer > 60) LeechEntity.this.attackPhase = LeechEntity.AttackPhase.CIRCLE;
                    }
                    else LeechEntity.this.moveTargetPoint = new Vec3(livingentity.getX(), livingentity.getY(0.5D) + 1, livingentity.getZ());

                }
            }
            else leeched = false;
        }
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(CHARGE, 0);
    }

    public int getCharge() {
        return this.entityData.get(CHARGE);
    }

    public void setCharge(int charge) {
        this.entityData.set(CHARGE, charge);
    }

    public void incrementCharge() {
        int charge = getCharge();
        if(charge < MAX_CHARGE) setCharge(charge+1);
    }

    @Override
    public void die(DamageSource pDamageSource) {
        InvasionData data = InvasionData.get(this.getServer().getLevel(Level.OVERWORLD));
        data.addProgress(DEATH_VALUE);
        super.die(pDamageSource);
    }

}
