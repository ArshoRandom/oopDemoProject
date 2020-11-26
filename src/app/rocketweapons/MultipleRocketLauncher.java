package app.rocketweapons;

public class MultipleRocketLauncher extends RocketLongRangeWeapon {

    private int rateOfFire;

    public MultipleRocketLauncher() {
        this.rateOfFire = 30;
    }

    public int getRateOfFire() {
        return rateOfFire;
    }

    public void setRateOfFire(int rateOfFire) {
        if (rateOfFire >= 5 && rateOfFire <= 40)
            this.rateOfFire = rateOfFire;
        else
            System.out.println("Invalid rate of fire : " + rateOfFire);
    }

    @Override
    public String toString() {
        return super.toString() + "," + rateOfFire;
    }

}
