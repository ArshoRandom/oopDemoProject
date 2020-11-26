package app.rocketweapons;

import app.base.AbstractHeavyLongRangeWeapon;

public abstract class RocketLongRangeWeapon extends AbstractHeavyLongRangeWeapon {

    private int rocketCount;

    public RocketLongRangeWeapon() {
        this.rocketCount = 1;
    }

    public int getRocketCount() {
        return rocketCount;
    }

    public void setRocketCount(int rocketCount) {
        if (rocketCount > 0 && rocketCount <= 50)
            this.rocketCount = rocketCount;
        else
            System.out.println("Invalid rockets count : " + rocketCount);
    }

    @Override
    public String toString() {
        String data = super.toString();
        return this.getClass().getSimpleName() + " : " + data + "," + getRocketCount();

    }


}
