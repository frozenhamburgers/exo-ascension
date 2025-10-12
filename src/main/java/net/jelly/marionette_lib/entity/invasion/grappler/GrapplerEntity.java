package net.jelly.marionette_lib.entity.invasion.grappler;

import net.jelly.marionette_lib.entity.invasion.leech.LeechPartEntity;
import net.jelly.marionette_lib.utility.AbstractPartEntity;
import net.jelly.marionette_lib.utility.FabrikAnimator;
import net.jelly.marionette_lib.utility.ProceduralAnimatable;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.FlyingMob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.entity.PartEntity;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;

public class GrapplerEntity extends FlyingMob implements ProceduralAnimatable {
    private final GrapplerPartEntity[] allParts;
    Vec3 target1;
    Vec3 target2;
    Vec3 goal1;
    Vec3 goal2;

    FabrikAnimator[] legAnimators = new FabrikAnimator[2];
    boolean[] legStatus = new boolean[2];
    int[] legTimer = new int[2];

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

        // allParts must still have all parts
        allParts = new GrapplerPartEntity[]
                {arm11, arm12, arm13, arm21, arm22, arm23};
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

        for (int i=0; i<2; i++) {
            FabrikAnimator legAnimator = legAnimators[i];
            int bodySide = 1;
            if(i%2 == 0) bodySide = -1;

            Vec3 direction = this.getLookAngle();
            Vec3 legRoot = this.position()
                    .add(direction.cross(new Vec3(0, 1, 0)).normalize().scale(10/16f*bodySide))
                    .add(new Vec3(0, 0.5, 0));
            legAnimator.setRoot(legRoot);

            Vec3 legRest = this.position()
                    .add(direction.cross(new Vec3(0, 1, 0)).normalize().scale(1.25f*bodySide))
                    .add(direction.normalize().scale(1.25f))
                    .add(new Vec3(0, -1, 0));;
            Vec3 restPos = legRest;

            if (legAnimator.chainEndPos().distanceTo(restPos) > 1f) {
                legStatus[i] = true;
                legTimer[i] = 0;
            }

            if (legStatus[i]) {
                legAnimator.setFabrikTarget(legAnimator.chainEndPos()
                        .add(restPos.subtract(legAnimator.chainEndPos()).normalize()
                        .scale(this.getDeltaMovement().dot(restPos.subtract(legAnimator.chainEndPos()))))
                        .add(restPos.subtract(legAnimator.chainEndPos()).scale(0.25))
                        .add(restPos.subtract(legAnimator.chainEndPos()).normalize().scale(0.1))
                );
                if (legAnimator.chainEndPos().distanceTo(restPos) < 0.2) {
                    legStatus[i] = false;
                    legTimer[i]++;
                }
            }
        }
        tickMultipart();
    }


    public static AttributeSupplier.Builder createAttributes() {
        return Animal.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 20D)
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
}
