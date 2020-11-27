package app.model.rocketweapons;

import app.exceptions.InvalidPropertyException;

public class LongRangeBallisticMissile extends RocketLongRangeWeapon {


    @Override
    public void setDistance(double distance) {
        InvalidPropertyException.check(!(distance >= 25_000 && distance <= 700_000), "distance " + distance);
        super.setDistance(distance);
    }

    @Override
    public void setCaliber(double caliber) {
        InvalidPropertyException.check(!(caliber >= 300 && caliber <= 500), "caliber " + caliber);
        super.setCaliber(caliber);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
