package app.model.artillery;

import app.exceptions.InvalidPropertyException;

public class AutomotiveHowitzer extends Howitzer {

    private String platformType;

    public AutomotiveHowitzer() {
        this.platformType = this.defaultStrValue;
    }

    public String getPlatformType() {
        return platformType;
    }

    public void setPlatformType(String platformType) {
        InvalidPropertyException.check(!(platformType != null && platformType.length() > 1), "platform type " + platformType);
        this.platformType = platformType;
    }

    @Override
    public String toString() {
        String data = super.toString();
        return data + "," + getPlatformType();
    }
}
