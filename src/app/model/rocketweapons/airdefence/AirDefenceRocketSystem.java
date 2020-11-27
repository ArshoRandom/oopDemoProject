package app.model.rocketweapons.airdefence;


import app.exceptions.InvalidPropertyException;
import app.model.rocketweapons.RocketLongRangeWeapon;

public class AirDefenceRocketSystem extends RocketLongRangeWeapon {

    private double detectionRadius;

    public AirDefenceRocketSystem() {
        this.detectionRadius = 10;
    }

    public double getDetectionRadius() {
        return detectionRadius;
    }

    @Override
    public void setDistance(double distance) {
        InvalidPropertyException.check(!(distance >= 10_000 && distance <= 300_000), "distance " + distance);
        super.setDistance(distance);
    }

    @Override
    public void setCaliber(double caliber) {
        InvalidPropertyException.check(!(caliber >= 200 && caliber <= 400), "caliber " + caliber);
        super.setCaliber(caliber);
    }

    public void setDetectionRadius(double detectionRadius) {
        InvalidPropertyException.check(!(detectionRadius >= 10_000 && detectionRadius <= 400_000), "detection radius " + detectionRadius);
        this.detectionRadius = detectionRadius;
    }

    @Override
    public String toString() {
        return super.toString() + "," + detectionRadius;
    }

}
