package app.util;

import app.exceptions.InvalidDataFormatException;
import app.model.artillery.AutomotiveHowitzer;
import app.model.artillery.Howitzer;
import app.model.base.AbstractHeavyLongRangeWeapon;
import app.model.rocketweapons.LongRangeBallisticMissile;
import app.model.rocketweapons.MultipleRocketLauncher;
import app.model.rocketweapons.airdefence.AirDefenceRocketSystem;

public class WeaponsMapper {

    public static AbstractHeavyLongRangeWeapon[] map(String[] rawData) throws InvalidDataFormatException {
        AbstractHeavyLongRangeWeapon[] abstractHeavyLongRangeWeapons = new AbstractHeavyLongRangeWeapon[rawData.length];

        for (int i = 0; i < rawData.length; i++) {
            String[] chunks = rawData[i].split(" : ");
            String typeName = chunks[0];
            String[] values = chunks[1].split(",");

            int[] dateChunks = splitDate(values[5]);
            try {
                switch (typeName) {
                    case "Howitzer":
                        Howitzer howitzer = new Howitzer();
                        howitzer.setCountry(values[0]);
                        howitzer.setModel(values[1]);
                        howitzer.setDistance(Double.parseDouble(values[2]));
                        howitzer.setCaliber(Double.parseDouble(values[3]));
                        howitzer.setPersonnelCount(Integer.parseInt(values[4]));
                        howitzer.setDateOfProduction(dateChunks[2], dateChunks[1], dateChunks[0]);
                        howitzer.setFlat(Boolean.parseBoolean(values[6]));
                        abstractHeavyLongRangeWeapons[i] = howitzer;
                        break;
                    case "AutomotiveHowitzer":
                        AutomotiveHowitzer automotiveHowitzer = new AutomotiveHowitzer();
                        automotiveHowitzer.setCountry(values[0]);
                        automotiveHowitzer.setModel(values[1]);
                        automotiveHowitzer.setDistance(Double.parseDouble(values[2]));
                        automotiveHowitzer.setCaliber(Double.parseDouble(values[3]));
                        automotiveHowitzer.setPersonnelCount(Integer.parseInt(values[4]));
                        automotiveHowitzer.setDateOfProduction(dateChunks[2], dateChunks[1], dateChunks[0]);
                        automotiveHowitzer.setFlat(Boolean.parseBoolean(values[6]));
                        automotiveHowitzer.setPlatformType(values[7]);
                        abstractHeavyLongRangeWeapons[i] = automotiveHowitzer;
                        break;
                    case "LongRangeBallisticMissile":
                        LongRangeBallisticMissile longRangeBallisticMissile = new LongRangeBallisticMissile();
                        longRangeBallisticMissile.setCountry(values[0]);
                        longRangeBallisticMissile.setModel(values[1]);
                        longRangeBallisticMissile.setDistance(Double.parseDouble(values[2]));
                        longRangeBallisticMissile.setCaliber(Double.parseDouble(values[3]));
                        longRangeBallisticMissile.setPersonnelCount(Integer.parseInt(values[4]));
                        longRangeBallisticMissile.setDateOfProduction(dateChunks[2], dateChunks[1], dateChunks[0]);
                        longRangeBallisticMissile.setRocketCount(Integer.parseInt(values[6]));
                        abstractHeavyLongRangeWeapons[i] = longRangeBallisticMissile;
                        break;
                    case "MultipleRocketLauncher":
                        MultipleRocketLauncher mrl = new MultipleRocketLauncher();
                        mrl.setCountry(values[0]);
                        mrl.setModel(values[1]);
                        mrl.setDistance(Double.parseDouble(values[2]));
                        mrl.setCaliber(Double.parseDouble(values[3]));
                        mrl.setPersonnelCount(Integer.parseInt(values[4]));
                        mrl.setDateOfProduction(dateChunks[2], dateChunks[1], dateChunks[0]);
                        mrl.setRocketCount(Integer.parseInt(values[6]));
                        mrl.setRateOfFire(Integer.parseInt(values[7]));
                        abstractHeavyLongRangeWeapons[i] = mrl;
                        break;
                    case "AirDefenceRocketSystem":
                        AirDefenceRocketSystem airDefenceRocketSystem = new AirDefenceRocketSystem();
                        airDefenceRocketSystem.setCountry(values[0]);
                        airDefenceRocketSystem.setModel(values[1]);
                        airDefenceRocketSystem.setDistance(Double.parseDouble(values[2]));
                        airDefenceRocketSystem.setCaliber(Double.parseDouble(values[3]));
                        airDefenceRocketSystem.setPersonnelCount(Integer.parseInt(values[4]));
                        airDefenceRocketSystem.setDateOfProduction(dateChunks[2], dateChunks[1], dateChunks[0]);
                        airDefenceRocketSystem.setRocketCount(Integer.parseInt(values[6]));
                        airDefenceRocketSystem.setDetectionRadius(Double.parseDouble(values[7]));
                        abstractHeavyLongRangeWeapons[i] = airDefenceRocketSystem;
                        break;
                    default:
                        throw new InvalidDataFormatException(typeName);
                }
            } catch (NumberFormatException e) {
                throw new InvalidDataFormatException(rawData[i]);
            }
        }
        return abstractHeavyLongRangeWeapons;
    }

    private static int[] splitDate(String dateData) {
        String[] strChunks = dateData.split("/");
        int[] intChunks = new int[strChunks.length];
        for (int i = 0; i < strChunks.length; i++) {
            if (strChunks[i].startsWith("0"))
                strChunks[i] = strChunks[i].replace("0", "");
            intChunks[i] = Integer.parseInt(strChunks[i]);
        }
        return intChunks;
    }
}
