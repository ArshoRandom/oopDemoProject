package app.model.rocketweapons;

import app.exceptions.InvalidPropertyException;

public class MultipleRocketLauncher extends RocketLongRangeWeapon {

    private int rateOfFire;

    public MultipleRocketLauncher() {
        this.rateOfFire = 30;
    }

    public int getRateOfFire() {
        return rateOfFire;
    }

    @Override
    public void setDistance(double distance) {
        InvalidPropertyException.check(!(distance >= 10_000 && distance <= 120_000), "distance " + distance);
        super.setDistance(distance);
    }

    @Override
    public void setCaliber(double caliber) {
        InvalidPropertyException.check(!(caliber >= 120 && caliber <= 350), "caliber " + caliber);
        super.setCaliber(caliber);
    }

    public void setRateOfFire(int rateOfFire) {
        InvalidPropertyException.check(!(rateOfFire >= 5 && rateOfFire <= 40), "rate of fire " + rateOfFire);
        this.rateOfFire = rateOfFire;
    }

    @Override
    public String toString() {
        return super.toString() + "," + getRateOfFire();
    }

}
