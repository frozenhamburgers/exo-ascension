package net.jelly.exo_ascension.entity.invasion.aetherion;

import net.jelly.exo_ascension.utility.AbstractPartEntity;
import net.jelly.exo_ascension.utility.FabrikAnimator;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.Vec3;

/** Implements IK relevant functionalities to FabrikAnimator
 * Classes that extend this will deal more with other functionalities e.g. attacks **/
public class AetherionArmAnimator extends FabrikAnimator {
    private boolean aiming;
    public Vec3 prevEnd; // previous FABRIK end effector BEFORE aiming, used to restore FABRIK chain
    private Vec3 prevAim; // previous aim vector before reset by FABRIK, used to interpolate aiming
    public boolean attacking;
    public boolean destroyed = false;
    public Vec3 destroyedFallVelocity = Vec3.ZERO;

    public AetherionArmAnimator(Entity owner, AbstractPartEntity[] allParts) {
        super(owner, allParts);
    }

    public AbstractPartEntity[] getParts() {
        return allParts;
    }

    public void setAiming(boolean b) {
        aiming = b;
    }

    public boolean isAiming() {
        return aiming;
    }

    public void setPrevEnd(Vec3 v) {
        prevEnd = v;
    }

    public Vec3 getPrevEnd() {
        return prevEnd;
    }

    public void setDestroyed() {
        destroyed = true;
        aiming = false;
        this.setFollowRootOnly(true);
    }

    public void reviveArm(Vec3 revivePos) {
        this.destroyed = false;
        this.destroyedFallVelocity = Vec3.ZERO; // reset fall velocity
        this.prevEnd = null; // clear any previous end override used when shooting
        this.setFollowRootOnly(false);

        AbstractPartEntity[] parts = this.getParts();
        for (int i = 0; i < parts.length; i++) {
            parts[i].setRootPos(revivePos);
            parts[i].setPartDirection(new Vec3(0, 0, 1));
        }
        this.setAiming(false);

        this.setFabrikTarget(revivePos);
        this.primeMultipart();
    }


    @Override
    public void tickMultipart() {
        primeMultipart();
    }

    // decouple finalizing part positions from tickMultiPart
    public void finalize() {
        for (AbstractPartEntity part : allParts) part.tick();
    }

    // manual aim last segment
    // imports assumed: import net.minecraft.util.Mth; and Vec3

    public void aimAt(Vec3 target, float maxYawChangeDeg, float maxPitchChangeDeg) {
        AbstractPartEntity[] parts = this.getParts();
        if (parts == null || parts.length < 2) return;

        this.setPrevEnd(this.chainEndPos());

        Vec3 rootPos = parts[parts.length - 2].getEndPos();
        AbstractPartEntity cannonPart = parts[parts.length - 1];

        Vec3 toTarget = target.subtract(rootPos);
        double dist = toTarget.length();
        if (dist < 1e-6) return;

        Vec3 currentDir;
        if(prevAim == null) currentDir = cannonPart.direction.normalize();
        else currentDir = prevAim.normalize();

        float currYawDeg = (float) Math.toDegrees(Math.atan2(-currentDir.x, currentDir.z)); // flipped X, matches Minecraft
        float currPitchDeg = (float) Math.toDegrees(-Math.asin(currentDir.y));

        Vec3 td = toTarget.normalize();
        float targetYawDeg = (float) Math.toDegrees(Math.atan2(-td.x, td.z));  // flipped X again
        float targetPitchDeg = (float) Math.toDegrees(-Math.asin(td.y));

        float deltaYaw = Mth.wrapDegrees(targetYawDeg - currYawDeg);
        float deltaPitch = Mth.wrapDegrees(targetPitchDeg - currPitchDeg);

        float appliedYaw = clampSigned(deltaYaw, maxYawChangeDeg);
        float appliedPitch = clampSigned(deltaPitch, maxPitchChangeDeg);

        float currYaw = (float)Math.toDegrees(Math.atan2(-currentDir.x, currentDir.z));
        float currPitch = (float)Math.toDegrees(-Math.asin(currentDir.y));

        double yawRad = Math.toRadians(currYaw + appliedYaw);
        double pitchRad = Math.toRadians(currPitch + appliedPitch);

        Vec3 smoothedDir = new Vec3(
                -Math.sin(yawRad) * Math.cos(pitchRad),
                -Math.sin(pitchRad),
                Math.cos(yawRad) * Math.cos(pitchRad)
        );

        cannonPart.setPartDirection(smoothedDir);
        cannonPart.setRootPos(rootPos);
        prevAim = smoothedDir;
    }

    private static float clampSigned(float value, float maxAbs) {
        float abs = Math.abs(value);
        if (abs <= maxAbs) return value;
        return Math.copySign(maxAbs, value);
    }




    public void tickArm() {
    }

    public void beginAttack() {
    }
}

