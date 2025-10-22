package net.jelly.exo_ascension.entity.invasion.aetherion;

import net.jelly.exo_ascension.entity.ModEntities;
import net.jelly.exo_ascension.entity.invasion.aetherion.beam.AetherionBeamEntity;
import net.jelly.exo_ascension.entity.invasion.aetherion.laser.AetherionLaserEntity;
import net.jelly.exo_ascension.utility.AbstractPartEntity;
import net.minecraft.commands.arguments.EntityAnchorArgument;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.phys.Vec3;

public class AetherionBeamArmAnimator extends AetherionArmAnimator {
    private int timer = 0;
    AetherionBoss mob;
    private AetherionBeamEntity beam;

    public AetherionBeamArmAnimator(AetherionBoss owner, AbstractPartEntity[] allParts) {
        super(owner, allParts);
        mob = owner;
    }

    public void beginAttack() {
        if(attacking) return;
        timer = 0;
        attacking = true;
        Vec3 endPos = allParts[allParts.length-1].getEndPos();
        BlockPos spawnPos = new BlockPos((int) Math.floor(endPos.x), (int) endPos.y, (int) Math.floor(endPos.z));
        if(!mob.level().isClientSide) {
            beam = ModEntities.AETHERION_BEAM.get().spawn(
                    (ServerLevel)mob.level(),
                    spawnPos,
                    MobSpawnType.MOB_SUMMONED);
            beam.start(mob);
        }
        System.out.println("added beam to level");
    }

    public void tickArm() {
        AbstractPartEntity cannonPart = allParts[allParts.length-1];
        Vec3 endPos = cannonPart.getEndPos();
        if(beam != null) {
            beam.lerpTo(endPos.x, endPos.y, endPos.z, beam.getXRot(), beam.getYRot(), 1, true);
            beam.lookAt(EntityAnchorArgument.Anchor.EYES, cannonPart.position().add(cannonPart.direction.scale(cannonPart.length*2)));
        }
        if(!attacking) return;
        if(timer > AetherionLaserEntity.DURATION) attacking = false;

        timer++;
    }

}
