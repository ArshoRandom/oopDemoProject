package app.artillery;


import app.base.AbstractHeavyLongRangeWeapon;

public abstract class Artillery extends AbstractHeavyLongRangeWeapon {

    private boolean isFlat;

    public boolean isFlat() {
        return isFlat;
    }

    public void setFlat(boolean flat) {
        isFlat = flat;
    }

    @Override
    public String toString() {
        String data = super.toString();
        return this.getClass().getSimpleName() + " : " + data + "," + isFlat();

    }
}
