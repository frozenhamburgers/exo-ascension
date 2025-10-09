#version 150
#moj_import <fog.glsl>

uniform float TotalTime;         // continuous world time in seconds
uniform float MeteorDensity;     // 0..1 intensity
uniform float MeteorBrightness;  // brightness multiplier
uniform float MeteorLength;      // 1 = short streaks, higher = longer
uniform float MeteorSpeed;       // movement speed (0.05–0.2 typical)
uniform vec3  MeteorColor;       // base color (e.g. vec3(1.0, 0.8, 0.6))
uniform mat3  IViewRotMat;       // inverse view rotation

in vec2 texCoord;
out vec4 fragColor;

const float TWO_PI = 6.28318530718;

// ---- Random helpers ----
float hash(float n) { return fract(sin(n) * 43758.5453123); }

vec3 randomDir(float seed) {
    float u = hash(seed) * 2.0 - 1.0;          // y (-1..1)
    float theta = hash(seed + 1.0) * TWO_PI;   // azimuth
    float r = sqrt(1.0 - u*u);
    return vec3(r * cos(theta), u, r * sin(theta));
}

// Compute meteor trail brightness
float meteorTrail(vec3 dir, vec3 origin, vec3 motion, float t) {
    vec3 pos = normalize(origin + motion * t * MeteorLength);
    float d = distance(dir, pos);
    return exp(-pow(d * 25.0, 2.0)); // streak width/falloff
}

// Sum multiple random meteors
float computeMeteors(vec3 dir, float time) {
    float brightness = 0.0;
    int count = int(3.0 + 4.0 * MeteorDensity); // up to ~7 if full density

    for (int i = 0; i < 8; i++) { // fixed upper bound for GLSL
        if (i >= count) break;

        float cycle = floor(time * MeteorSpeed + float(i) * 7.0);
        float seed = cycle + float(i) * 19.37;
        float localTime = fract(time * MeteorSpeed + float(i) * 7.0); // 0..1

        float meteorsActive = smoothstep(0.0, 0.2, 0.2 - localTime);
        if (meteorsActive > 0.0) {
            vec3 start = randomDir(seed);
            vec3 motion = randomDir(seed + 100.0);
            float streak = meteorTrail(dir, start, motion, localTime * 4.0);
            brightness += streak * meteorsActive;
        }
    }

    return brightness;
}

void main() {
    // Convert from screen to world direction
    vec3 dir = normalize(IViewRotMat * vec3(texCoord - 0.5, 1.0));

    float meteorGlow = computeMeteors(dir, TotalTime);

    vec3 color = MeteorColor * meteorGlow * MeteorBrightness;

    // Transparent unless a meteor passes
    float alpha = clamp(meteorGlow * MeteorBrightness, 0.0, 1.0);

    fragColor = vec4(color, alpha);
}
