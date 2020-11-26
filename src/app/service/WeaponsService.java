package app.service;

import app.exceptions.ErrorMessage;
import app.rocketweapons.airdefence.AirDefenceRocketSystem;
import app.artillery.Artillery;
import app.artillery.AutomotiveHowitzer;
import app.base.AbstractHeavyLongRangeWeapon;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class WeaponsService {



    public static void printCharacteristics(AbstractHeavyLongRangeWeapon weapon) {
        String model = weapon.getModel();
        System.out.println("\n-+-+-+-+-+-+ " + model + " -+-+-+-+-+-+");
        System.out.printf("Model : %s\n", model);
        System.out.printf("Country : %s\n", weapon.getCountry());
        System.out.printf("Distance : %d\n", Math.round(weapon.getDistance()));
        System.out.printf("Personal count : %d\n", weapon.getPersonnelCount());
        System.out.printf("Caliber : %d\n", Math.round(weapon.getCaliber()));
        System.out.printf("Year of production : %s\n", weapon.getDateOfProduction());
        if (weapon instanceof AirDefenceRocketSystem)
            System.out.printf("Detection radius : %s\n", ((AirDefenceRocketSystem) weapon).getDetectionRadius());
        if (weapon instanceof Artillery)
            System.out.printf("Is Flat : %s\n", ((Artillery) weapon).isFlat());
        if (weapon instanceof AutomotiveHowitzer)
            System.out.printf("Platform type : %s\n", ((AutomotiveHowitzer) weapon).getPlatformType());
    }


    public static int getCountOfDefenders(AbstractHeavyLongRangeWeapon weapon, double frontLength, double targetDepth) {
        double weaponDistance = weapon.getDistance();
        if (weapon.isEffective(targetDepth)) {
            int unitCounts = (int) (frontLength / weapon.getDistance() + 1);
            if (weapon.getCaliber() < 300)
                return 3 * unitCounts;
            else if (weapon.getCaliber() < 600) {
                return 2 * unitCounts;
            } else
                return unitCounts;
        }
        System.out.println("Ineffective weapon for distance " + weaponDistance);
        return 0;
    }


    public static Date getExpirationDate(AbstractHeavyLongRangeWeapon weapon) {
        Date expDate = new Date();
        if (!weapon.notSuitable()) {
            Date productionDate = weapon.getDateOfProduction();
            GregorianCalendar calendar = new GregorianCalendar();
            calendar.setTime(productionDate);
            calendar.add(Calendar.YEAR, 40);
            expDate = calendar.getTime();
        }
        return expDate;
    }

    public static AbstractHeavyLongRangeWeapon searchWeapon(AbstractHeavyLongRangeWeapon [] weapons, String searchModel){
        for (AbstractHeavyLongRangeWeapon weapon : weapons){
            if (weapon.getModel().equalsIgnoreCase(searchModel))
                return weapon;
        }
        ErrorMessage.printNotFoundErrorMessage(searchModel);
        return null;
    }
}
