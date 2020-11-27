package app.model.artillery;


import app.exceptions.InvalidPropertyException;
import app.model.base.AbstractHeavyLongRangeWeapon;

public abstract class Artillery extends AbstractHeavyLongRangeWeapon {

    private boolean isFlat;

    public boolean isFlat() {
        return isFlat;
    }

    public void setFlat(boolean flat) {
        isFlat = flat;
    }

    @Override
    public void setDistance(double distance) {
        InvalidPropertyException.check(!(distance >= 3000 && distance <= 15_000), "distance " + distance);
        super.setDistance(distance);
    }

    @Override
    public void setCaliber(double caliber) {
        InvalidPropertyException.check(!(caliber >= 120 && caliber <= 150), "caliber " + caliber);
        super.setCaliber(caliber);
    }

    @Override
    public String toString() {
        String data = super.toString();
        return this.getClass().getSimpleName() + " : " + data + "," + isFlat();

    }
}
