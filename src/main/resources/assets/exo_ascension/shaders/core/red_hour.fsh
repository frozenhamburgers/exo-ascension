#version 150
#moj_import <fog.glsl>

uniform float TotalTime;
uniform float RedHourIntensity;
uniform mat4 ProjMat;
uniform mat3 IViewRotMat;

in vec2 texCoord;
out vec4 fragColor;

const float TWO_PI = 6.28318530718;
const float AURORA_SPEED = 0.06;
const float AURORA_FREQ_X = 6.0;
const float AURORA_FREQ_Y = 1.6;

vec3 getWorldDir(vec2 uv) {
        // Convert from [0,1] texCoord to Normalized Device Coordinates [-1,1]
        vec4 ndc = vec4(uv * 2.0 - 1.0, 1.0, 1.0);

        // Inverse projection: approximate by dividing by projection terms
        // (Since we're only using direction, we can ignore position offsets)
        // Assumes symmetric projection matrix
        vec3 viewDir = normalize((inverse(ProjMat) * ndc).xyz);

        // Rotate into world space using IViewRotMat (inverse view rotation)
        return normalize(IViewRotMat * viewDir);
}

void main() {
        float t = TotalTime * TWO_PI * AURORA_SPEED;

        // Compute world-space direction of current pixel
        vec3 dir = getWorldDir(texCoord);

        // Map direction to spherical coordinates
        // y is up, so we can use dir.y as "altitude" and atan2 for "azimuth"
        float azimuth = atan(dir.x, dir.z);       // horizontal angle
        float altitude = clamp(dir.y * 0.5 + 0.5, 0.0, 1.0); // 0=ground,1=zenith

        float xzPhase1 = dir.x * 4.0 + dir.z * 4.0;
        float xzPhase2 = dir.x * -2.5 + dir.z * 2.5;

        float w1 = sin(t + xzPhase1 + altitude * 2.0);
        float w2 = sin(t * 1.25 + xzPhase2 + altitude * 6.0);

//        // Aurora pattern based on azimuth + altitude
//        float w1 = sin(t + azimuth * 4.0 + altitude * 2.0);
//        float w2 = sin(t * 1.25 - azimuth * 2.5 + altitude * 6.0);

        float raw = 0.6 * w1 + 0.4 * w2;
        float bands = raw * 0.5 + 0.5;
        float bandMask = smoothstep(0.15, 0.85, bands);

        float vertical = pow(altitude, 1.2);
        float flicker = 0.85 + 0.15 * sin(TotalTime * TWO_PI * 0.9 + azimuth * 2.0);
        float auroraStrength = bandMask * vertical * flicker;

        // Base red hour gradient by altitude
        vec3 baseTop = vec3(0.75, 0.12, 0.04);
        vec3 baseBottom = vec3(0.06, 0.02, 0.06);
        vec3 baseSky = mix(baseBottom, baseTop, pow(altitude, 0.9));

        vec3 auroraColor = vec3(1.0, 0.85, 0.55);
        vec3 redHourSky = baseSky + auroraColor * auroraStrength * 1.25;
        vec3 normalSky = vec3(0.30, 0.52, 0.92);

        vec3 color = mix(normalSky, redHourSky, clamp(RedHourIntensity, 0.0, 1.0));

        float horizonFade = mix(1.0, 0.45, smoothstep(0.0, 0.35, altitude));
        color *= horizonFade;

        float alpha = RedHourIntensity;
        fragColor = vec4(color, alpha);
}
