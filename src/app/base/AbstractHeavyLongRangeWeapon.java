package app.base;

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
        if (year >= 1950 && year <= Integer.parseInt(currentYear))
            this.dateOfProduction = new GregorianCalendar(year,month-1,day).getTime();
        else
            System.out.println("Invalid year : " + dateOfProduction);
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        if (model != null && model.length() > 0)
            this.model = model;
        else
            System.out.println("Invalid model : " + model);
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        if (country != null && country.matches("[a-zA-Z]+"))
            this.country = country;
        else
            System.out.println("invalid country : " + country);
    }

    public double getCaliber() {
        return caliber;
    }

    public void setCaliber(double caliber) {
        if (caliber > 60 && caliber < 800)
            this.caliber = caliber;
        else
            System.out.println("Invalid caliber : " + caliber);
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        if (distance >= 3000 && distance <= 700_000)
            this.distance = distance;
        else
            System.out.println("Invalid distance : " + distance);
    }

    public int getPersonnelCount() {
        return personnelCount;
    }

    public void setPersonnelCount(int personnelCount) {
        if (personnelCount > 0 && personnelCount <= 30)
            this.personnelCount = personnelCount;
        else
            System.out.println("Invalid personal count : " + personnelCount);
    }

    @Override
    public boolean isEffective(double distance) {
        return !(this.distance < distance);
    }

    @Override
    public boolean isSubjectOfUpdate() {
        return this.dateOfProduction.before(new GregorianCalendar(1990,GregorianCalendar.JANUARY,1).getTime())
                && this.dateOfProduction.after(new GregorianCalendar(1980,GregorianCalendar.JANUARY,1).getTime());
    }

    @Override
    public boolean notSuitable() {
        return this.dateOfProduction.before(new GregorianCalendar(1980,GregorianCalendar.JANUARY,1).getTime());
    }

    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String simpleDate = dateFormat.format(getDateOfProduction());
        return String.format("%s,%s,%f,%f,%d,%s",getCountry(),getModel(),getDistance(),getCaliber(),getPersonnelCount(),simpleDate);
    }
}
