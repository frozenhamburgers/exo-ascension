package net.jelly.exo_ascension.entity.invasion.gorgon;

import net.jelly.exo_ascension.entity.goals.HoverGoal;
import net.jelly.exo_ascension.entity.goals.IHoverEntity;
import net.jelly.exo_ascension.entity.goals.MoveTowardTargetGoal;
import net.jelly.exo_ascension.entity.goals.gorgon.GorgonAttackGoal;
import net.jelly.exo_ascension.global.invasion.InvasionData;
import net.jelly.exo_ascension.utility.FabrikAnimator;
import net.jelly.exo_ascension.utility.ProceduralAnimatable;
import net.minecraft.commands.arguments.EntityAnchorArgument;
import net.minecraft.core.BlockPos;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.FlyingMob;
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

import java.util.ArrayList;
import java.util.Collections;

public class GorgonEntity extends FlyingMob implements ProceduralAnimatable, IHoverEntity {
    public static final int DEATH_VALUE = 9;
    private final GorgonPartEntity[] allParts;
    FabrikAnimator[] legAnimators = new FabrikAnimator[6];
    Vec3[] restPos = new Vec3[6];
    ArrayList<GorgonPartEntity> allPartsList = new ArrayList<>();
    public boolean attacking = false;
    public Vec3 lastLook;

    private GorgonPartEntity[] createTentacle() {
        GorgonPartEntity legPart1 = new GorgonPartEntity(this, 6f/16, 6f/16, 9f/16);
        GorgonPartEntity legPart2 = new GorgonPartEntity(this, 6f/16, 6f/16, 8f/16);
        GorgonPartEntity legPart3 = new GorgonPartEntity(this, 6f/16, 6f/16, 8f/16);
        GorgonPartEntity legPart4 = new GorgonPartEntity(this, 4f/16, 4f/16, 8f/16);
        GorgonPartEntity legPart5 = new GorgonPartEntity(this, 4f/16, 4f/16, 8f/16);
        GorgonPartEntity legPart6 = new GorgonPartEntity(this, 4f/16, 4f/16, 8f/16);
        GorgonPartEntity legPart7 = new GorgonPartEntity(this, 4f/16, 4f/16, 8f/16);
        GorgonPartEntity legPart8 = new GorgonPartEntity(this, 4f/16, 4f/16, 8f/16);
        GorgonPartEntity legPart9 = new GorgonPartEntity(this, 4f/16, 4f/16, 8f/16);
        GorgonPartEntity legPart10 = new GorgonPartEntity(this, 2f/16, 2f/16, 8f/16);
        GorgonPartEntity legPart11 = new GorgonPartEntity(this, 2f/16, 2f/16, 8f/16);
        GorgonPartEntity[] parts  = new GorgonPartEntity[]
                {legPart1, legPart2, legPart3, legPart4, legPart5, legPart6, legPart7, legPart8, legPart9, legPart10, legPart11};
        Collections.addAll(allPartsList, parts);
        return parts;
    }

    public GorgonEntity(EntityType entityType, Level level) {
        super(entityType, level);
        legAnimators[0] = new FabrikAnimator(this, createTentacle());
        legAnimators[1] = new FabrikAnimator(this, createTentacle());
        legAnimators[2] = new FabrikAnimator(this, createTentacle());
        legAnimators[3] = new FabrikAnimator(this, createTentacle());
        legAnimators[4] = new FabrikAnimator(this, createTentacle());
        legAnimators[5] = new FabrikAnimator(this, createTentacle());
        allParts = allPartsList.toArray(new GorgonPartEntity[6*11]);

        // goals
        this.targetSelector.addGoal(0, new NearestAttackableTargetGoal<>(this, Player.class, false));
        this.goalSelector.addGoal(1, new GorgonAttackGoal(this));
        this.goalSelector.addGoal(2, new MoveTowardTargetGoal(this, 4.5f, 1.2f, 0.1f));
        this.goalSelector.addGoal(3, new HoverGoal(this, 5f, 0.2f, true, 0));
        this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Animal.createLivingAttributes()
                        .add(Attributes.MAX_HEALTH, 40D)
                .add(Attributes.FOLLOW_RANGE, 100D)
                .add(Attributes.ARMOR, 10.0f)
                .add(Attributes.ARMOR_TOUGHNESS, 4.0f)
                .add(Attributes.KNOCKBACK_RESISTANCE, 0.2f);
    }

    @Override
    public ArrayList<FabrikAnimator> getAnimators() {
        ArrayList<FabrikAnimator> animators = new ArrayList<>();
        animators.add(legAnimators[0]);
        animators.add(legAnimators[1]);
        animators.add(legAnimators[2]);
        animators.add(legAnimators[3]);
        animators.add(legAnimators[4]);
        animators.add(legAnimators[5]);
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

        if(this.getGroundDistance() < 3) {
            this.addDeltaMovement(new Vec3(0, 0.05f, 0));;
        }

        if(this.getTarget() != null) {
            if (!attacking) {
                this.lookAt(EntityAnchorArgument.Anchor.EYES, this.getTarget().position().add(0,1,0));
                lastLook = this.getTarget().position();
            }
            else this.lookAt(EntityAnchorArgument.Anchor.EYES, lastLook.add(0,1,0));

        }

        for (int i = 0; i < 6; i++) {
            FabrikAnimator legAnimator = legAnimators[i];

            Vec3 forward = Vec3.directionFromRotation(this.xRotO, this.yBodyRot).normalize();
            Vec3 right = forward.cross(new Vec3(0, 1, 0)).normalize();

            Vec3 legRoot;
            Vec3 legRest;

            // 0 = left side appendage
            // 1 = right side appendage
            // 2..5 = four bottom appendages (front-left, front-right, back-left, back-right)
            if (i == 0 || i == 1) {
                // SIDE APPENDAGES (one per side), mounted at mid-body
                int sideSign = (i == 0) ? -1 : 1; // 0:left, 1:right

                // attach at mid height
                double mountHeight = 1.0;

                // slight forward/back bias so the side appendages are not exactly centered:
                double forwardBias = 0.1; // small forward push

                // root sits slightly outside the 2×2 body edges (body half-width ~1 block)
                legRoot = this.position()
                        .add(right.scale(0.85 * sideSign))      // out to the side
                        .add(forward.scale(forwardBias))       // small forward bias
                        .add(new Vec3(0, mountHeight, 0));     // mid-height mount
                legAnimator.setRoot(legRoot);

                // rest droop: out + down + slight forward
                legRest = legRoot
                        .add(right.scale(0.5 * sideSign))
                        .add(forward.scale(0.5))
                        .add(new Vec3(0, -2.4, 0)); // hang down ~2.4 blocks
            } else {
                // BOTTOM APPENDAGES (4 total)
                // map 2->front-left, 3->front-right, 4->back-left, 5->back-right
                int idx = i - 2;
                boolean front = (idx == 0 || idx == 1);
                boolean left  = (idx == 0 || idx == 2);

                double forwardOffset = front ? 0.3 : -0.6;     // front/back spacing
                double sideOffset    = left  ? -0.6 : 0.6;     // left/right spacing
                double yOffset    = front  ? 0 : 0;     // up/down spacing

                // roots attached to underside; small upward offset
                double mountUnderZ = 0.1;  // slight raise above exact bottom to avoid clipping

                legRoot = this.position()
                        .add(forward.scale(forwardOffset))
                        .add(right.scale(sideOffset))
                        .add(new Vec3(0, mountUnderZ, 0)); // mounted at underside
                legAnimator.setRoot(legRoot);

                // rest for bottom appendages: hang mostly straight down with a slight flare
                legRest = legRoot
                        .add(new Vec3(0, -3.0, 0))            // hang 3 blocks down
                        .add(right.scale(0.25 * sideOffset)) // slight outward flare
                        .add(forward.scale(0.15 * forwardOffset)) // slight forward/back bias
                        .add(new Vec3(0,1,0).scale(yOffset));

            }

            // step logic
            if (restPos[i] == null || restPos[i].distanceTo(legRest) > 4) restPos[i] = legRest;

            Vec3 chainEndPos = legAnimator.chainEndPos();

            // prime the FABRIK solver roughly toward the hanging direction:
            Vec3 primeTarget = legRoot.add(new Vec3(0, -1.5, 0));
            legAnimator.setFabrikTarget(primeTarget);
            legAnimator.primeMultipart();

            // smoothly approach the rest position (preserve your movement bias)
            if (chainEndPos.distanceTo(restPos[i]) > 0.1) {
                Vec3 toRest = restPos[i].subtract(chainEndPos);
                legAnimator.setFabrikTarget(
                        chainEndPos
                                .add(toRest.normalize().scale(0.25))
                                .add(toRest.scale(0.1))
                                .add(toRest.normalize().scale(this.getDeltaMovement().dot(toRest) * 0.75f))
                );
            } else {
                legAnimator.setFabrikTarget(chainEndPos);
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
    public boolean canCollideWith(Entity other) {
        return !(other instanceof GorgonPartEntity);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
    }

    @Override
    public void die(DamageSource pDamageSource) {
        InvasionData data = InvasionData.get(this.getServer().getLevel(Level.OVERWORLD));
        data.addProgress(DEATH_VALUE);
        super.die(pDamageSource);
    }
}
