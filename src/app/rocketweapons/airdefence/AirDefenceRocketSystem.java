package app.rocketweapons.airdefence;


import app.rocketweapons.RocketLongRangeWeapon;

public class AirDefenceRocketSystem extends RocketLongRangeWeapon {

    private double detectionRadius;

    public AirDefenceRocketSystem() {
        this.detectionRadius = 10;
    }

    public double getDetectionRadius() {
        return detectionRadius;
    }

    public void setDetectionRadius(double detectionRadius) {
        if (detectionRadius >= 10_000 && detectionRadius <= 400_000)
            this.detectionRadius = detectionRadius;
        else
            System.out.println("Invalid detection radius : " + detectionRadius);
    }

    @Override
    public String toString() {
        return super.toString() + "," + detectionRadius;
    }

}
