package app.model.rocketweapons;

import app.exceptions.InvalidPropertyException;
import app.model.base.AbstractHeavyLongRangeWeapon;

public abstract class RocketLongRangeWeapon extends AbstractHeavyLongRangeWeapon {

    private int rocketCount;

    public RocketLongRangeWeapon() {
        this.rocketCount = 1;
    }

    public int getRocketCount() {
        return rocketCount;
    }

    public void setRocketCount(int rocketCount) {
        InvalidPropertyException.check(!(rocketCount > 0 && rocketCount <= 50), "rockets count " + rocketCount);
        this.rocketCount = rocketCount;
    }

    @Override
    public String toString() {
        String data = super.toString();
        return this.getClass().getSimpleName() + " : " + data + "," + getRocketCount();

    }


}
