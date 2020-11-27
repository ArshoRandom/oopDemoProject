package app.util;

import app.model.base.AbstractHeavyLongRangeWeapon;

public class WeaponsCache {

    private static AbstractHeavyLongRangeWeapon[] weapons = new AbstractHeavyLongRangeWeapon[10];
    private static int size;

    public static void add(AbstractHeavyLongRangeWeapon weapon) {
        if (size == weapons.length) {
            grow();
        }
        weapons[size] = weapon;
        size++;
    }

    public static AbstractHeavyLongRangeWeapon[] getAllCache() {
        AbstractHeavyLongRangeWeapon[] copy = new AbstractHeavyLongRangeWeapon[size];
        System.arraycopy(weapons, 0, copy, 0, size);
        return copy;
    }

    private static void grow() {
        AbstractHeavyLongRangeWeapon[] newArray = new AbstractHeavyLongRangeWeapon[weapons.length + size];
        System.arraycopy(weapons, 0, newArray, 0, weapons.length);
        weapons = newArray;
    }


}
