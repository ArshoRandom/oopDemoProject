package app.model.base;

public interface HeavyLongRangeWeapon {

    boolean isEffective(double distance);

    boolean isSubjectOfUpdate();

    boolean notSuitable();


}
