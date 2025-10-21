package net.jelly.exo_ascension.entity.invasion.aetherion;

import net.jelly.exo_ascension.utility.AbstractPartEntity;
import net.jelly.exo_ascension.utility.FabrikAnimator;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.Vec3;

public class AetherionArmAnimator extends FabrikAnimator {
    public boolean shooting;
    public Vec3 prevEnd;

    public AetherionArmAnimator(Entity owner, AbstractPartEntity[] allParts) {
        super(owner, allParts);
    }

    public AbstractPartEntity[] getParts() {
        return allParts;
    }

    public void setShooting(boolean b) {
        shooting = b;
    }

    public void setPrevEnd(Vec3 v) {
        prevEnd = v;
    }

    public Vec3 getPrevEnd() {
        return prevEnd;
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
    public void aim(Vec3 target) {
        AbstractPartEntity[] parts = this.getParts();
        this.setShooting(true);
        this.setPrevEnd(this.chainEndPos());

        Vec3 preCannonArmPos = parts[parts.length - 2].getEndPos();
        Vec3 targetDir = target.subtract(preCannonArmPos).normalize();
        parts[parts.length - 1].setPartDirection(targetDir);
        parts[parts.length - 1].setRootPos(preCannonArmPos);
    }



}
