package app.util;

import app.rocketweapons.airdefence.AirDefenceRocketSystem;
import app.artillery.AutomotiveHowitzer;
import app.artillery.Howitzer;
import app.rocketweapons.LongRangeBallisticMissile;
import app.rocketweapons.MultipleRocketLauncher;

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


    public static Howitzer createHowitzer() {
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

    public static AutomotiveHowitzer createAutomaticHowitzer() {
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

    public static LongRangeBallisticMissile createLongRangeBallisticMissile() {
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

    public static MultipleRocketLauncher createMRL() {
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

    public static AirDefenceRocketSystem createAirDefenceSystem() {
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

        private static void fillBaseCharacteristics() {
            System.out.println("Enter model");
            WeaponsCreator.model = scanner.nextLine();
            System.out.println("Enter country");
            WeaponsCreator.country = scanner.nextLine();
            System.out.println("Enter distance");
            WeaponsCreator.distance = scanner.nextDouble();
            System.out.println("Enter production year");
            WeaponsCreator.year = scanner.nextInt();
            System.out.println("Enter production month");
            WeaponsCreator.month = scanner.nextInt();
            System.out.println("Enter production day");
            WeaponsCreator.day = scanner.nextInt();
            System.out.println("Enter caliber");
            WeaponsCreator.caliber = scanner.nextDouble();
            System.out.println("Enter personal count");
            WeaponsCreator.personalCount = scanner.nextInt();
        }

        private static void fillHowitzer() {
            fillBaseCharacteristics();
            System.out.println("Enter true if howitzer is flat, else enter false");
            WeaponsCreator.isFlat = scanner.nextBoolean();
        }

        private static void fillAutomaticHowitzer() {
            fillHowitzer();
            System.out.println("Enter platform model");
            WeaponsCreator.platformType = scanner.nextLine();
        }

        private static void fillLongRangeRocketWeapon() {
            fillBaseCharacteristics();
            System.out.println("Enter rocket counts");
            WeaponsCreator.rocketCount = scanner.nextInt();
        }

        private static void fillMRL() {
            fillLongRangeRocketWeapon();
            System.out.println("Enter rate of fire (integer value)");
            WeaponsCreator.rateOfFire = scanner.nextInt();
        }


        private static void fillAirDefenceSystem() {
            fillLongRangeRocketWeapon();
            System.out.println("Enter detection radius");
            WeaponsCreator.detectionRadius = scanner.nextDouble();
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
