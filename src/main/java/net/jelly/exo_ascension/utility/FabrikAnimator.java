package net.jelly.exo_ascension.utility;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.Vec3;

/**
 * Animates multipart entity with FABRIK
 */
public class FabrikAnimator {
    protected final Entity owner;
    protected final AbstractPartEntity[] allParts;
    protected Vec3 fabrikTarget = Vec3.ZERO;
    protected boolean followRootOnly = false;
    protected Vec3 root;

    public FabrikAnimator(Entity owner, AbstractPartEntity[] allParts) {
        this.owner = owner;
        this.allParts = allParts;
    }

    /**
     * Sets target for end of the chain to reach for
     */
    public Vec3 getFabrikTarget() {
        return fabrikTarget;
    }

    public void setFabrikTarget(Vec3 fabrikTarget) {
        this.fabrikTarget = fabrikTarget;
    }

    public Vec3 chainEndPos() {
        return allParts[allParts.length-1].getEndPos();
    }

    public Vec3 chainRoot() {
        return allParts[0].getRootPos();
    }

    /**
     * Set root of the chain. Default is parent entity's position.
     */
    public void setRoot(Vec3 root) {
        this.root = root;
    }

    /**
     * Makes it so the segments only follow the root and the target has no effect.
     * Good for things like worms, snakes, tails, trailing cloths, etc.
     */
    public void setFollowRootOnly(boolean b) {
        this.followRootOnly = b;
    }

    protected Vec3 root() {
        if(root != null) return root;
        return owner.position();
    }

    protected void fabrikForward(Vec3 target) {
        for (int i = allParts.length - 1; i >= 0; i--) {
            AbstractPartEntity currentSegment = allParts[i];
            Vec3 lastEndPos;
            Vec3 nextRootPos;

            if (i == 0) {
                lastEndPos = root();
            } else {
                lastEndPos = allParts[i - 1].getEndPos();
            }

            if (i == allParts.length - 1) {
                nextRootPos = target;
            } else {
                nextRootPos = allParts[i + 1].getRootPos();
            }

            currentSegment.setPartDirection(nextRootPos.subtract(lastEndPos));
            currentSegment.setEndPos(nextRootPos);
        }
    }

    protected void fabrikBackward(Vec3 target) {
        for (int i = 0; i < allParts.length; i++) {
            AbstractPartEntity currentSegment = allParts[i];
            Vec3 lastEndPos;
            Vec3 nextRootPos;

            if (i == 0) {
                lastEndPos = root();
            } else {
                lastEndPos = allParts[i - 1].getEndPos();
            }

            if (i == allParts.length - 1) {
                if(!followRootOnly) nextRootPos = target;
                else nextRootPos = currentSegment.getEndPos();
            } else {
                nextRootPos = allParts[i + 1].getRootPos();
            }

            currentSegment.setPartDirection(nextRootPos.subtract(lastEndPos));
            currentSegment.setRootPos(lastEndPos);
        }
    }

    public void tickMultipart() {
        primeMultipart();
        for (AbstractPartEntity part : allParts) part.tick();
    }

    public void primeMultipart() {
        // total chain length
        float totalLength = 0;
        float distToTarget = (float) (fabrikTarget.subtract(root()).length());
        for (AbstractPartEntity part : allParts) totalLength += part.getLength();

        if (distToTarget >= totalLength && !followRootOnly) {
            // target too far: fully extend
            Vec3 rootToTarget = fabrikTarget.subtract(root()).normalize();
            for (int i = 0; i < allParts.length; i++) {
                AbstractPartEntity currentSegment = allParts[i];
                Vec3 lastEndPos = (i == 0) ? root() : allParts[i - 1].getEndPos();

                currentSegment.setPartDirection(rootToTarget);
                currentSegment.setRootPos(lastEndPos);
            }
        } else {
            // FABRIK iterations
            float tolerance = 0.01f;
            int fiterations = 0;
            do { // run at least one fabrik iteration per tick, in case of manual changes.
                if(!followRootOnly) fabrikForward(fabrikTarget);
                fabrikBackward(fabrikTarget);
                fiterations++;
            } while (!followRootOnly && fabrikTarget.subtract(allParts[allParts.length - 1].getEndPos()).length() > tolerance && fiterations < 100);
            if (fiterations >= 100 ) System.out.println("iterations greater than 99");
        }
    }
}
