#version 150
#moj_import <fog.glsl>

uniform float TotalTime;         // continuous world time in seconds
uniform float MeteorDensity;     // 0..1 intensity
uniform float MeteorBrightness;  // brightness multiplier
uniform float MeteorLength;      // 1 = short streaks, higher = longer
uniform float MeteorSpeed;       // movement speed (0.05–0.2 typical)
uniform vec3  MeteorColor;       // base color (e.g. vec3(1.0, 0.8, 0.6))
uniform mat3  IViewRotMat;       // inverse view rotation
uniform mat4  ProjMat;       // inverse view rotation

in vec2 texCoord;
out vec4 fragColor;

const float TWO_PI = 6.28318530718;

// ---- Improved meteor helper functions ----
// hash and randomDir left as before
float hash(float n) { return fract(sin(n) * 43758.5453123); }

vec3 randomDir(float seed) {
    float u = hash(seed) * 2.0 - 1.0;
    float theta = hash(seed + 1.0) * 6.28318530718;
    float r = sqrt(max(0.0, 1.0 - u*u));
    return vec3(r * cos(theta), u, r * sin(theta));
}

// Compute meteor streak contribution with a hard core + tail
// dir: unit world direction of this fragment
// origin: unit start direction for the meteor
// motion: unit motion direction (rough) for the meteor
// t: local meteor normalized life [0..1] where 0=start, 1=done
// lengthAngle: max angular half-length of streak (radians). e.g. 0.4
// widthAngle: angular half-width of streak (radians). e.g. 0.01 (narrow)
// ---- Meteor trail using angular math (expects unit 'dir', 'origin', 'motion') ----
float meteorTrailAngular(vec3 dir, vec3 origin, vec3 motion, float t, float lengthAngle, float widthAngle) {
    // head position (cheap lerp+normalize along approximate great-circle)
    vec3 pos = normalize(mix(origin, origin + motion * (t * 2.0), t));

    // great-circle normal (guard degenerate case)
    vec3 N = cross(origin, motion);
    float nlen = length(N);
    if (nlen < 1e-6) return 0.0;
    N /= nlen;

    // tangent direction along great circle at pos
    vec3 T = normalize(cross(N, pos));

    // perpendicular angular distance from dir to the great-circle plane (radians)
    float sinPerp = clamp(abs(dot(dir, N)), 0.0, 1.0);
    float perpAngle = asin(sinPerp);

    // signed along-track angle (radians) relative to the current head position
    // atan(y, x) gives signed angle in [-PI, PI]
    float alongX = clamp(dot(dir, pos), -1.0, 1.0); // cosine of small angle along the track
    float alongY = dot(dir, T);                     // sine-sign term
    float alongAngleSigned = atan(alongY, alongX);  // signed angle between pos -> dir in plane
    float alongAbs = abs(alongAngleSigned);

    // normalized position along the allowed streak length (0 at head, 1 at max length)
    float alongNorm = alongAbs / max(1e-6, lengthAngle);

    // head mask: strong near the head (alongNorm small)
    float headFrac = 0.12; // fraction of length that counts as the "head"
    float headMask = 1.0 - smoothstep(0.0, headFrac, alongNorm);

    // tail base: present along the length; stronger behind (negative signed angle)
    float tailBase = 1.0 - smoothstep(0.0, 1.0, alongNorm); // 1 at head, 0 beyond length
    float behind = step(alongAngleSigned, 0.0); // 1.0 if alongAngleSigned <= 0 (behind), else 0
    float tailMask = tailBase * behind; // weaker ahead-of-head, full behind

    // lateral mask using angular distance (radians) for correct spherical width
    float lateralMask = 1.0 - smoothstep(widthAngle * 0.75, widthAngle * 1.25, perpAngle);

    // life multiplier handled by caller; here we create a per-meteor local brightness shape
    // Compose: bright head + solid tail (both modulated by lateralMask)
    float core = headMask * lateralMask;
    float tail = tailMask * lateralMask * (1.0 - 0.35 * alongNorm); // slight along-length falloff

    // final local brightness (caller multiplies by life / global brightness)
    float localBrightness = core * 1.8 + tail * 1.05;
    return max(localBrightness, 0.0);
}


// ---- Sum meteors (small fixed loop) ----
// dir: unit world direction
// time: TotalTime seconds
// density: 0..1 (controls how many meteors are actively considered)
// brightnessMult: global multiplier (uniform)
// lengthAng: angular half-length in radians (e.g. radians(24.0))
// widthAng: angular half-width in radians (e.g. radians(0.6))
// speed: controls temporal frequency
float computeMeteorsSharp(vec3 dir, float time, float density, float brightnessMult, float lengthAng, float widthAng, float speed) {
    float acc = 0.0;
    const int MAX_METEORS = 6;
    int activeCount = 1 + int(floor(float(MAX_METEORS - 1) * clamp(density, 0.0, 1.0)));

    // Visible life window per meteor (fraction of its cycle)
    float lifeWindow = 0.30; // visible length (0.30 = 30% of cycle). Tweak to taste.

    // spacing and period control
    float phaseSpacing = 6.3; // spread meteors in time by index
    float cycleSpeed = max(1e-5, speed);

    for (int i = 0; i < MAX_METEORS; ++i) {
        if (i >= activeCount) break;

        // cycle variable: increases with global time and per-index offset
        float cycle = time * cycleSpeed + float(i) * phaseSpacing;

        float localT = fract(cycle);      // 0..1 within this meteor's cycle
        if (localT > lifeWindow) continue; // only active during lifeWindow of the cycle

        // normalize life to 0..1 over the visible window
        float tnorm = localT / max(1e-6, lifeWindow);

        // deterministic seed based on whole-cycle index
        float seedIndex = floor(cycle);
        float seed = seedIndex * 23.0 + float(i) * 13.0;

        vec3 start = randomDir(seed);
        vec3 motion = randomDir(seed + 101.0);

        // length jitter
        float len = lengthAng * (0.75 + 0.5 * hash(seed + 3.0));

        // compute raw trail brightness for this meteor
        float raw = meteorTrailAngular(dir, start, motion, tnorm, len, widthAng);

        // life shaping: linger at full length then fade entire streak
        float activePhase = 0.70; // fraction of tnorm where it's fully visible
        float fadePhase = 1.0 - activePhase;
        float lifeMultiplier = (tnorm <= activePhase)
        ? 1.0
        : clamp(1.0 - (tnorm - activePhase) / max(1e-6, fadePhase), 0.0, 1.0);

        acc += raw * lifeMultiplier;
    }

    return acc * brightnessMult;
}



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
    vec3 dir = getWorldDir(texCoord);

    // settings (tweak these uniforms or constants)
    float lenAngle = radians(45.0); // exaggerate streak length
    float widthAngle = radians(0.25); // make thicker
    float meteorGlow = computeMeteorsSharp(dir, TotalTime, MeteorDensity, MeteorBrightness, lenAngle, widthAngle, MeteorSpeed);

    // color + apply
    vec3 meteorCol = MeteorColor;
    vec3 add = meteorCol * meteorGlow;
    float alpha = clamp(meteorGlow * 25, 0.0, 1.0);
    fragColor = vec4(add, alpha);
}
