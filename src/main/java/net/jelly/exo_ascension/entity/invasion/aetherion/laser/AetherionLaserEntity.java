package net.jelly.exo_ascension.entity.invasion.aetherion.laser;

import com.mojang.math.Transformation;
import mod.chloeprime.aaaparticles.api.common.AAALevel;
import mod.chloeprime.aaaparticles.api.common.ParticleEmitterInfo;
import net.jelly.exo_ascension.ExoAscensionMod;
import net.jelly.exo_ascension.entity.ModEntities;
import net.jelly.exo_ascension.entity.invasion.aetherion.AetherionBoss;
import net.jelly.exo_ascension.global.invasion.InvasionData;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Display;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import org.joml.Quaternionf;
import org.joml.Vector3f;

public class AetherionLaserEntity extends Entity {
    private static final ParticleEmitterInfo LASER_PARTICLE = new ParticleEmitterInfo(new ResourceLocation(ExoAscensionMod.MODID, "laser/aetherion_laser"));
    ParticleEmitterInfo laser;
    public static final int DURATION = 134;
    private int timer = 0;
    private AetherionBoss owner;

    public AetherionLaserEntity(EntityType<?> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public void start(AetherionBoss owner) {
        this.owner = owner;
        laser = LASER_PARTICLE.clone()
                .bindOnEntity(this)
                .useEntityHeadSpace()
                .scale(1.5f);
        AAALevel.addParticle(this.level(), false, laser);
    }

    @Override
    public void tick() {
        super.tick();
        timer++;
        if (this.timer > DURATION) {
            this.remove(RemovalReason.DISCARDED);
        }

        if (timer >= 47 && timer < DURATION) {
            Vec3 start = this.position().add(0, this.getEyeHeight(), 0);
            Vec3 end = start.add(this.getLookAngle().normalize().scale(30.0));
            var aabb = this.getBoundingBox().expandTowards(this.getLookAngle().scale(30.0)).inflate(0.5);

            // Entity hit logic
            for (LivingEntity hit : this.level().getEntitiesOfClass(LivingEntity.class, aabb, e -> e.isAlive())) {
                var optionalHit = hit.getBoundingBox().clip(start, end);
                if (optionalHit.isPresent()) {
                    if (InvasionData.isInvasionMob(hit)) continue;
                    if (owner != null) hit.hurt(this.damageSources().mobAttack(owner), 12.0F);
                    if (!this.level().isClientSide) {
                        Vec3 push = this.getLookAngle().scale(0.1);
                        hit.push(push.x, 0.01, push.z);
                    }
                }
            }

            // === Block Terraforming Logic ===
            if (!this.level().isClientSide) {
                BlockHitResult hitResult = this.level().clip(new ClipContext(
                        start, end,
                        ClipContext.Block.OUTLINE,
                        ClipContext.Fluid.NONE,
                        this
                ));

                if (hitResult.getType() == HitResult.Type.BLOCK) {
                    BlockPos hitPos = hitResult.getBlockPos();
                    BlockState state = this.level().getBlockState(hitPos);

                    if (!state.isAir() && state.getDestroySpeed(this.level(), hitPos) >= 0 && state.getDestroySpeed(this.level(), hitPos) < 50F) {
                        ServerLevel serverLevel = (ServerLevel) this.level();

                        // transform nearby blocks
                        int radius = 2;
                        for (BlockPos pos : BlockPos.betweenClosed(hitPos.offset(-radius, -radius, -radius), hitPos.offset(radius, radius, radius))) {
                            if (this.level().random.nextFloat() < 0.25f) {
                                transformBlock(serverLevel, pos);
                            }
                        }

                        // tear up the main impact block
                        if (!state.isAir()) {
                            if(this.level().random.nextFloat() < 0.45f) spawnBlockShard(hitPos, state);

                            if(this.level().random.nextFloat() < 0.25f) {
                                this.level().playSound(null, hitPos, SoundEvents.GENERIC_EXPLODE, SoundSource.BLOCKS, 0.8F, 1.2F);
                                this.level().destroyBlock(hitPos, false); // Remove original block without dropping items
                            }
                        }

                        // beam impact effects
                        serverLevel.sendParticles(ParticleTypes.EXPLOSION,
                                hitPos.getX() + 0.5, hitPos.getY() + 0.5, hitPos.getZ() + 0.5,
                                1, 0.0, 0.0, 0.0, 0.0);
                        serverLevel.sendParticles(ParticleTypes.LAVA,
                                hitPos.getX() + 0.5, hitPos.getY() + 0.5, hitPos.getZ() + 0.5,
                                6, 0.2, 0.2, 0.2, 0.02);

                    }
                }
            }
        }
    }

    /**
     * Converts terrain blocks
     */
    private void transformBlock(ServerLevel level, BlockPos pos) {
        BlockState state = level.getBlockState(pos);
        Block block = state.getBlock();

        if (block == Blocks.DIRT) {
            level.setBlock(pos, Blocks.COARSE_DIRT.defaultBlockState(), 3);
        } else if (block == Blocks.GRASS_BLOCK) {
            level.setBlock(pos, Blocks.DIRT.defaultBlockState(), 3);
        } else if (block == Blocks.STONE) {
            level.setBlock(pos, Blocks.MAGMA_BLOCK.defaultBlockState(), 3);
        } else if (block == Blocks.SAND) {
            level.setBlock(pos, Blocks.GLASS.defaultBlockState(), 3);
        } else if (block == Blocks.GRAVEL) {
            level.setBlock(pos, Blocks.SAND.defaultBlockState(), 3);
        } else if (block == Blocks.ICE || block == Blocks.PACKED_ICE) {
            level.setBlock(pos, Blocks.WATER.defaultBlockState(), 3);
        } else if (block == Blocks.SNOW_BLOCK) {
            level.setBlock(pos, Blocks.AIR.defaultBlockState(), 3);
        } else if (block == Blocks.CLAY) {
            level.setBlock(pos, Blocks.TERRACOTTA.defaultBlockState(), 3);
        }
    }

    private void spawnBlockShard(BlockPos pos, BlockState state) {
        if (!(this.level() instanceof ServerLevel server)) return;

        Vec3 velocity = new Vec3(
                (random.nextDouble() - 0.5) * 0.6,
                0.3 + random.nextDouble() * 0.3,
                (random.nextDouble() - 0.5) * 0.6
        );

        BlockShardEntity shard = ModEntities.BLOCK_SHARD.get().create(server);
        if (shard == null) return;

        shard.initialize(
                state,
                new Vec3(pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5),
                velocity
        );

        server.addFreshEntity(shard);
    }


    @Override
    protected void defineSynchedData() {

    }

    @Override
    protected void readAdditionalSaveData(CompoundTag pCompound) {

    }

    @Override
    protected void addAdditionalSaveData(CompoundTag pCompound) {

    }
}
