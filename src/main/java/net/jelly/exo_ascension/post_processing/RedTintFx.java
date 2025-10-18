package net.jelly.exo_ascension.post_processing;

import org.joml.Vector3f;
import team.lodestar.lodestone.systems.postprocess.DynamicShaderFxInstance;

import java.util.function.BiConsumer;

public class RedTintFx extends DynamicShaderFxInstance {
    public float intensity;
    public Vector3f color;

    public RedTintFx(float intensity, Vector3f color) {
        this.intensity = intensity;
        this.color = color;
    }

    @Override
    public void writeDataToBuffer(BiConsumer<Integer, Float> writer) {
        writer.accept(0, intensity);
        writer.accept(1, color.x());
        writer.accept(2, color.y());
        writer.accept(3, color.z());
    }
}