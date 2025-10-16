package net.jelly.marionette_lib.entity.invasion.leech;

import net.jelly.marionette_lib.networking.ModMessages;
import net.jelly.marionette_lib.networking.MultipartEntityMessage;
import net.jelly.marionette_lib.utility.AbstractPartEntity;
import net.jelly.marionette_lib.utility.ProceduralAnimatable;
import net.jelly.marionette_lib.utility.FabrikAnimator;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.entity.PartEntity;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;

public class LeechPartEntity extends AbstractPartEntity<LeechEntity> implements ProceduralAnimatable {
    private EntityDimensions size;
    private final LeechLegPartEntity[] allParts;
    FabrikAnimator animator;

    public LeechPartEntity(LeechEntity parent, float sizeXZ, float sizeY, float length) {
        super(parent);
        this.size = EntityDimensions.fixed(sizeXZ, sizeY);
        this.refreshDimensions();
        this.length = length;

        LeechLegPartEntity tail1Part = new LeechLegPartEntity(this, 1F, 1F, 0.5f);
        LeechLegPartEntity tail2Part = new LeechLegPartEntity(this, 1F, 1F, 0.5f);
        LeechLegPartEntity tail3Part = new LeechLegPartEntity(this, 1F, 1F, 0.5f);
        LeechLegPartEntity tail4Part = new LeechLegPartEntity(this, 1F, 1F, 0.5f);
        LeechLegPartEntity tail5Part = new LeechLegPartEntity(this, 1F, 1F, 0.5f);
        allParts = new LeechLegPartEntity[]{tail1Part, tail2Part, tail3Part, tail4Part, tail5Part};
        animator = new FabrikAnimator(this, allParts);
    }

    @Override
    public ArrayList<FabrikAnimator> getAnimators() {
        ArrayList<FabrikAnimator> animators = new ArrayList<>();
        animators.add(animator);
        return animators;
    }

    public EntityDimensions getDimensions(Pose pose) {
        return size;
    }

    public AABB getBoundingBoxForCulling() {
        return this.getBoundingBox().inflate(1.0D, 1.0D, 1.0D);
    }

    @Override
    public boolean fireImmune() {
        return true;
    }

    @Override
    public boolean canBeHitByProjectile() {
        return true;
    }
    @Override
    public boolean isPickable() {
        return true;
    }

    @Override
    public boolean hurt(DamageSource source, float amount) {
        Entity parent = this.getParent();
        if (parent != null) {
            Entity player = source.getEntity();
            if (player != null && player.level().isClientSide) {
                ModMessages.sendToServer(new MultipartEntityMessage(parent.getId(), player.getId(), 1, amount));
            }
            else parent.hurt(source, amount);
        }
        return true;
    }

    @Override
    public InteractionResult interact(Player player, InteractionHand hand) {
        Entity parent = this.getParent();
        if (parent == null) {
            return InteractionResult.PASS;
        } else {
            if (player.level().isClientSide) {
                ModMessages.sendToServer(new MultipartEntityMessage(parent.getId(), player.getId(), 0, 0));
            }
            return parent.interact(player, hand);
        }
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
        Player nearestPlayer = this.level().getNearestPlayer(this, 200);
        if(nearestPlayer != null) animator.setFabrikTarget(nearestPlayer.position());
        tickMultipart();
    }
}
