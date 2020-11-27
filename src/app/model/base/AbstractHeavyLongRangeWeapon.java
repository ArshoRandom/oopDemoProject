package app.model.base;

import app.exceptions.InvalidPropertyException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public abstract class AbstractHeavyLongRangeWeapon implements HeavyLongRangeWeapon {

    private String model;
    private String country;
    private double distance;
    private int personnelCount;
    private double caliber;
    private Date dateOfProduction;

    protected String defaultStrValue = "SECRET";


    public AbstractHeavyLongRangeWeapon() {
        this.model = this.defaultStrValue;
        this.country = this.defaultStrValue;
        this.caliber = 120;
        this.personnelCount = 5;
        this.distance = 5000;
        this.dateOfProduction = new Date();
    }

    public Date getDateOfProduction() {
        return new Date(dateOfProduction.getTime());
    }

    public void setDateOfProduction(int year, int month, int day) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        String currentYear = sdf.format(new Date());
        InvalidPropertyException.check(!(year >= 1950 && year <= Integer.parseInt(currentYear)), "year " + year);
        InvalidPropertyException.check(!(month >= 0 && month <= 11), "month " + month);
        InvalidPropertyException.check(!(day >= 1 && day <= 31), "day " + day);
        this.dateOfProduction = new GregorianCalendar(year, month - 1, day).getTime();
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        InvalidPropertyException.check(!(model != null && model.length() > 0), model);
        this.model = model;

    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        InvalidPropertyException.check(!(country != null && country.matches("[a-zA-Z]+")), "country " + country);
        this.country = country;
    }

    public double getCaliber() {
        return caliber;
    }

    public void setCaliber(double caliber) {
        this.caliber = caliber;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public int getPersonnelCount() {
        return personnelCount;
    }

    public void setPersonnelCount(int personnelCount) {
        InvalidPropertyException.check(!(personnelCount > 0 && personnelCount <= 30), "personal count " + personnelCount);
        this.personnelCount = personnelCount;
    }

    @Override
    public boolean isEffective(double distance) {
        return !(this.distance < distance);
    }

    @Override
    public boolean isSubjectOfUpdate() {
        return this.dateOfProduction.before(new GregorianCalendar(1990, GregorianCalendar.JANUARY, 1).getTime())
                && this.dateOfProduction.after(new GregorianCalendar(1980, GregorianCalendar.JANUARY, 1).getTime());
    }

    @Override
    public boolean notSuitable() {
        return this.dateOfProduction.before(new GregorianCalendar(1980, GregorianCalendar.JANUARY, 1).getTime());
    }

    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String simpleDate = dateFormat.format(getDateOfProduction());
        return String.format("%s,%s,%f,%f,%d,%s", getCountry(), getModel(), getDistance(), getCaliber(), getPersonnelCount(), simpleDate);
    }
}
