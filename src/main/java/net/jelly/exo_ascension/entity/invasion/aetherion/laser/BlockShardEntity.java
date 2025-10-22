package net.jelly.exo_ascension.entity.invasion.aetherion.laser;

import com.mojang.math.Transformation;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.world.entity.Display;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraft.client.renderer.entity.DisplayRenderer;
import org.joml.Quaternionf;
import org.joml.Vector3f;

public class BlockShardEntity extends Display.BlockDisplay {
    private Vec3 velocity = Vec3.ZERO;
    private Quaternionf rotation = new Quaternionf();
    private Vec3 spinAxis = new Vec3(0, 1, 0);
    private int lifetime = 60;
    private int age = 0;

    public BlockShardEntity(EntityType<? extends BlockDisplay> type, Level level) {
        super(type, level);
    }

    public void initialize(BlockState state, Vec3 pos, Vec3 initialVel) {
        this.setBlockState(state);
        this.setPos(pos);
        this.velocity = initialVel;

        // Random spin axis
        this.spinAxis = new Vec3(
                this.level().random.nextDouble() - 0.5,
                this.level().random.nextDouble() - 0.5,
                this.level().random.nextDouble() - 0.5
        ).normalize();

        this.rotation = new Quaternionf();
        this.lifetime = 40 + this.level().random.nextInt(40);
    }

    @Override
    public void tick() {
        super.tick();

        age++;
        if (age > lifetime) {
            discard();
            return;
        }

        // Gravity + motion
        this.move(MoverType.SELF, this.velocity);

        // Spin rotation
        float spinSpeed = 0.2f;
        Quaternionf spinStep = new Quaternionf().fromAxisAngleRad(
                (float) spinAxis.x, (float) spinAxis.y, (float) spinAxis.z, spinSpeed
        );
        this.rotation.mul(spinStep);

        // Compute shrink factor near the end of lifespan
        float shrinkStart = 0.8f; // start shrinking at 80% of lifetime
        float lifeProgress = (float) age / (float) lifetime;
        float scaleValue = 1.0f;
        if (lifeProgress > shrinkStart) {
            float shrinkProgress = (lifeProgress - shrinkStart) / (1.0f - shrinkStart);
            scaleValue = 1.0f - shrinkProgress; // linearly shrink to 0
        }

        // Clamp scaleValue to avoid negative scaling
        scaleValue = Math.max(scaleValue, 0.0f);

        // Update transformation for rendering
        this.setTransformation(new Transformation(
                new Vector3f(0, 0, 0), // position
                this.rotation,          // rotation
                new Vector3f(scaleValue, scaleValue, scaleValue), // scale
                new Quaternionf()       // right rotation (unused)
        ));
    }



    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
    }

    @Override
    protected void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
    }

    @Override
    protected void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
    }
}
