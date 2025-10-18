#version 150

// Samplers
uniform sampler2D DiffuseSampler;
uniform sampler2D MainDepthSampler;
// Multi-Instance uniforms
uniform samplerBuffer DataBuffer;
uniform int InstanceCount;
// Matrices needed for world position calculation
uniform mat4 invProjMat;
uniform mat4 invViewMat;
uniform vec3 cameraPos;

in vec2 texCoord;
out vec4 fragColor;

void main() {
        vec4 col = texture(DiffuseSampler, texCoord);
        float depth = texture(MainDepthSampler, texCoord).r;

        // Read global intensity
        float intensity = texelFetch(DataBuffer, 0).r;

        // --- Skip sky ---
        // In Minecraft’s default depth buffer, sky pixels have depth ≈ 1.0
        // So we fade out the tint entirely for those.
        float skyMask = step(depth, 0.9999); // 1.0 for scene, 0.0 for sky

        // --- Tint logic ---
        float gray = dot(col.rgb, vec3(0.3, 0.59, 0.11));
        vec3 redTint = texelFetch(DataBuffer, 1).rgb;
        vec3 mixed = mix(col.rgb, redTint * gray * 1.2, intensity * skyMask);

        fragColor = vec4(mixed, col.a);
}