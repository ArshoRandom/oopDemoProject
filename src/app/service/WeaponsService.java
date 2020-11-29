package app.service;

import app.exceptions.ModelNotFoundException;
import app.model.artillery.Artillery;
import app.model.artillery.AutomotiveHowitzer;
import app.model.base.AbstractHeavyLongRangeWeapon;
import app.model.rocketweapons.airdefence.AirDefenceRocketSystem;
import app.util.color.Color;
import app.util.color.ColorChanger;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class WeaponsService {


    public static void printCharacteristics(AbstractHeavyLongRangeWeapon weapon) {
        String model = weapon.getModel();
        ColorChanger.changeColor(Color.PURPLE);
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
        if (frontLength <= 1_000_000_000) {
            if (weapon.isEffective(targetDepth)) {
                int unitCounts = (int) (frontLength / weapon.getDistance() + 1);
                if (weapon.getCaliber() < 300)
                    return 3 * unitCounts;
                else if (weapon.getCaliber() < 600) {
                    return 2 * unitCounts;
                } else
                    return unitCounts;
            }
        }
        return 0;
    }


    public static void printAllWeapons(AbstractHeavyLongRangeWeapon[] weapons) {
        int count = weapons.length;
        for (AbstractHeavyLongRangeWeapon weapon : weapons) {
            printCharacteristics(weapon);
        }
        ColorChanger.changeColor(Color.GREEN);
        System.out.println("All weapons count : " + count);
    }

    public static void printAllEffectiveWeaponsFor(double distance, AbstractHeavyLongRangeWeapon[] weapons) {
        int count = 0;
        for (AbstractHeavyLongRangeWeapon weapon : weapons) {
            if (weapon.isEffective(distance)) {
                count++;
                printCharacteristics(weapon);
            }
        }
        ColorChanger.changeColor(Color.GREEN);
        System.out.println("All effective weapons count : " + count);
    }

    public static void printAllUpgradableWeapons(AbstractHeavyLongRangeWeapon[] weapons) {
        int count = 0;
        for (AbstractHeavyLongRangeWeapon weapon : weapons) {
            if (weapon.isSubjectOfUpdate()) {
                count++;
                printCharacteristics(weapon);
            }
        }
        ColorChanger.changeColor(Color.GREEN);
        System.out.println("All upgradable weapons count : " + count);
    }

    public static void printAllSuitableWeapons(AbstractHeavyLongRangeWeapon[] weapons) {
        int count = 0;
        for (AbstractHeavyLongRangeWeapon weapon : weapons) {
            if (!weapon.notSuitable()) {
                count++;
                printCharacteristics(weapon);
            }
        }
        ColorChanger.changeColor(Color.GREEN);
        System.out.println("All suitable weapons count : " + count);
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

    public static AbstractHeavyLongRangeWeapon searchWeapon(AbstractHeavyLongRangeWeapon[] weapons, String searchModel) throws ModelNotFoundException {
        for (AbstractHeavyLongRangeWeapon weapon : weapons) {
            if (weapon.getModel().equalsIgnoreCase(searchModel))
                return weapon;
        }
        throw new ModelNotFoundException(searchModel);
    }
}
