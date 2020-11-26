package app.artillery;

public class AutomotiveHowitzer extends Howitzer {

    private String platformType;

    public AutomotiveHowitzer() {
        this.platformType = this.defaultStrValue;
    }

    public String getPlatformType() {
        return platformType;
    }

    public void setPlatformType(String platformType) {
        if (platformType != null && platformType.length() > 1)
            this.platformType = platformType;
        else
            System.out.println("Invalid platform type : " + platformType);
    }

    @Override
    public String toString() {
        String data = super.toString();
        return data + "," + getPlatformType();
    }
}
