package net.jelly.exo_ascension.entity.invasion.aetherion;

import net.jelly.exo_ascension.entity.ModEntities;
import net.jelly.exo_ascension.entity.invasion.aetherion.laser.AetherionLaserEntity;
import net.jelly.exo_ascension.utility.AbstractPartEntity;
import net.minecraft.commands.arguments.EntityAnchorArgument;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.phys.Vec3;

public class AetherionLaserArmAnimator extends AetherionArmAnimator {
    private int timer = 0;
    AetherionBoss mob;
    public boolean attacking;
    private AetherionLaserEntity laser;

    public AetherionLaserArmAnimator(AetherionBoss owner, AbstractPartEntity[] allParts) {
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
            laser = ModEntities.AETHERION_LASER.get().spawn(
                    (ServerLevel)mob.level(),
                    spawnPos,
                    MobSpawnType.MOB_SUMMONED);
            laser.start(mob);
        }
        System.out.println("added laser to level");
    }

    public void tickArm() {
        AbstractPartEntity cannonPart = allParts[allParts.length-1];
        Vec3 endPos = cannonPart.getEndPos();
        if(laser != null) {
            laser.setPos(endPos);
            laser.lookAt(EntityAnchorArgument.Anchor.EYES, cannonPart.position().add(cannonPart.direction.scale(cannonPart.length*2)));
        }
        if(!attacking) return;
        if(timer >= 47 && timer < AetherionLaserEntity.DURATION) {
//            Vec3 start = mob.position().add(0, mob.getEyeHeight(), 0);
//            Vec3 end = start.add(mob.getLookAngle().normalize().scale(6.0));
//            var aabb = mob.getBoundingBox().expandTowards(mob.getLookAngle().scale(6.0)).inflate(0.5);
//
//            for (LivingEntity hit : mob.level().getEntitiesOfClass(LivingEntity.class, aabb, e -> e != mob && e.isAlive())) {
//                var optionalHit = hit.getBoundingBox().clip(start, end);
//                if (optionalHit.isPresent()) {
//                    if(InvasionData.isInvasionMob(hit)) continue;
//                    hit.hurt(mob.damageSources().mobAttack(mob), 4.0F);
//                    Vec3 push = mob.getLookAngle().scale(0.1);
//                    hit.push(push.x, 0.05, push.z);
//                }
//            }
        }
        if(timer > AetherionLaserEntity.DURATION) attacking = false;

        timer++;
    }

}
