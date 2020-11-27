package app.util;

import app.model.artillery.AutomotiveHowitzer;
import app.model.artillery.Howitzer;
import app.model.rocketweapons.LongRangeBallisticMissile;
import app.model.rocketweapons.MultipleRocketLauncher;
import app.model.rocketweapons.airdefence.AirDefenceRocketSystem;

import java.util.Scanner;

public class WeaponsCreator {

    private static String model;
    private static String country;
    private static double distance;
    private static int year;
    private static int month;
    private static int day;
    private static double caliber;
    private static int personalCount;

    private static boolean isFlat;
    private static String platformType;
    private static int rocketCount;
    private static int rateOfFire;
    private static double detectionRadius;


    public static Howitzer createHowitzer() throws NumberFormatException {
        FieldsFiller.fillHowitzer();
        Howitzer howitzer = new Howitzer();
        howitzer.setCountry(country);
        howitzer.setModel(model);
        howitzer.setCaliber(caliber);
        howitzer.setFlat(isFlat);
        howitzer.setPersonnelCount(personalCount);
        howitzer.setDistance(distance);
        howitzer.setDateOfProduction(year, month, day);
        FieldsFiller.clean();
        return howitzer;
    }

    public static AutomotiveHowitzer createAutomaticHowitzer() throws NumberFormatException {
        FieldsFiller.fillAutomaticHowitzer();
        AutomotiveHowitzer automotiveHowitzer = new AutomotiveHowitzer();
        automotiveHowitzer.setModel(model);
        automotiveHowitzer.setCountry(country);
        automotiveHowitzer.setCaliber(caliber);
        automotiveHowitzer.setDistance(distance);
        automotiveHowitzer.setDateOfProduction(year, month, day);
        automotiveHowitzer.setPersonnelCount(personalCount);
        automotiveHowitzer.setFlat(isFlat);
        automotiveHowitzer.setPlatformType(platformType);
        FieldsFiller.clean();
        return automotiveHowitzer;
    }

    public static LongRangeBallisticMissile createLongRangeBallisticMissile() throws NumberFormatException {
        FieldsFiller.fillLongRangeRocketWeapon();
        LongRangeBallisticMissile rocketLongRangeWeapon = new LongRangeBallisticMissile();
        rocketLongRangeWeapon.setModel(model);
        rocketLongRangeWeapon.setCountry(country);
        rocketLongRangeWeapon.setCaliber(caliber);
        rocketLongRangeWeapon.setDistance(distance);
        rocketLongRangeWeapon.setDateOfProduction(year, month, day);
        rocketLongRangeWeapon.setPersonnelCount(personalCount);
        rocketLongRangeWeapon.setRocketCount(rocketCount);
        FieldsFiller.clean();
        return rocketLongRangeWeapon;
    }

    public static MultipleRocketLauncher createMRL() throws NumberFormatException {
        FieldsFiller.fillMRL();
        MultipleRocketLauncher mrl = new MultipleRocketLauncher();
        mrl.setCountry(country);
        mrl.setModel(model);
        mrl.setPersonnelCount(personalCount);
        mrl.setDistance(distance);
        mrl.setCaliber(caliber);
        mrl.setRocketCount(rocketCount);
        mrl.setDateOfProduction(year, month, day);
        mrl.setRateOfFire(rateOfFire);
        FieldsFiller.clean();
        return mrl;
    }

    public static AirDefenceRocketSystem createAirDefenceSystem() throws NumberFormatException {
        FieldsFiller.fillAirDefenceSystem();
        AirDefenceRocketSystem airDefenceRocketSystem = new AirDefenceRocketSystem();
        airDefenceRocketSystem.setCountry(country);
        airDefenceRocketSystem.setModel(model);
        airDefenceRocketSystem.setDistance(distance);
        airDefenceRocketSystem.setCaliber(caliber);
        airDefenceRocketSystem.setPersonnelCount(personalCount);
        airDefenceRocketSystem.setRocketCount(rocketCount);
        airDefenceRocketSystem.setDateOfProduction(year, month, day);
        airDefenceRocketSystem.setDetectionRadius(detectionRadius);
        FieldsFiller.clean();
        return airDefenceRocketSystem;
    }


    private static class FieldsFiller {

        private static Scanner scanner = new Scanner(System.in);

        private static void fillBaseCharacteristics() throws NumberFormatException {
            System.out.println("Enter model");
            WeaponsCreator.model = scanner.nextLine();
            System.out.println("Enter country");
            WeaponsCreator.country = scanner.nextLine();
            System.out.println("Enter distance\n" +
                    "(Howitzers max - 15_000, min - 3000)\n" +
                    "(MRL max - 120_000, min - 10_000)\n" +
                    "(Ballistic Missile max - 700_000, min - 25_000)\n" +
                    "(Air defence system max - 300_000, min - 10_000)");
            WeaponsCreator.distance = Double.parseDouble(scanner.nextLine().trim());
            System.out.println("Enter production year (min - 1950, max - current year)");
            WeaponsCreator.year = Integer.parseInt(scanner.nextLine().trim());
            System.out.println("Enter production month");
            WeaponsCreator.month = Integer.parseInt(scanner.nextLine().trim());
            System.out.println("Enter production day");
            WeaponsCreator.day = Integer.parseInt(scanner.nextLine().trim());
            System.out.println("Enter caliber\n" +
                    "(Howitzers max - 150, min - 120)\n" +
                    "(MRL max - 350, min - 120)\n" +
                    "(Ballistic Missile max - 500, min - 300)\n" +
                    "(Air defence system max - 400, min - 200)");
            WeaponsCreator.caliber = Double.parseDouble(scanner.nextLine().trim());
            System.out.println("Enter personal count");
            WeaponsCreator.personalCount = Integer.parseInt(scanner.nextLine().trim());
        }

        private static void fillHowitzer() throws NumberFormatException {
            fillBaseCharacteristics();
            System.out.println("Enter true if howitzer is flat, else enter false");
            WeaponsCreator.isFlat = Boolean.parseBoolean(scanner.nextLine().trim());
        }

        private static void fillAutomaticHowitzer() throws NumberFormatException {
            fillHowitzer();
            System.out.println("Enter platform model");
            WeaponsCreator.platformType = scanner.nextLine();
        }

        private static void fillLongRangeRocketWeapon() throws NumberFormatException {
            fillBaseCharacteristics();
            System.out.println("Enter rocket counts");
            WeaponsCreator.rocketCount = Integer.parseInt(scanner.nextLine().trim());
        }

        private static void fillMRL() throws NumberFormatException {
            fillLongRangeRocketWeapon();
            System.out.println("Enter rate of fire (integer value)");
            WeaponsCreator.rateOfFire = Integer.parseInt(scanner.nextLine().trim());
        }


        private static void fillAirDefenceSystem() throws NumberFormatException {
            fillLongRangeRocketWeapon();
            System.out.println("Enter detection radius (max - 400_000, min - 10_000)");
            WeaponsCreator.detectionRadius = Double.parseDouble(scanner.nextLine().trim());
        }

        private static void clean() {
            WeaponsCreator.country = null;
            WeaponsCreator.model = null;
            WeaponsCreator.distance = 0;
            WeaponsCreator.caliber = 0;
            WeaponsCreator.personalCount = 0;
            WeaponsCreator.year = 0;
            WeaponsCreator.day = 0;
            WeaponsCreator.month = 0;

            WeaponsCreator.isFlat = false;
            WeaponsCreator.platformType = null;

            WeaponsCreator.rateOfFire = 0;
            WeaponsCreator.rocketCount = 0;
            WeaponsCreator.detectionRadius = 0;
        }
    }
}
