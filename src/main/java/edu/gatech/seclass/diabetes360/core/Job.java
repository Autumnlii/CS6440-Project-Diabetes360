package edu.gatech.seclass.diabetes360.core;

public abstract class Job {
    private String title;
    private String company;
    private Location location;
    private float yearlySalary;
    private float yearlyBonus;
    private float restrictedStockAward;
    private float relocStipend;
    private Integer holidays;
    private float score;

    public Job(String title, String company, Location location, float yearlySalary,
               float yearlyBonus, float restrictedStockAward, float relocStipend,
               Integer holidays, float score) {
        this.title = title;
        this.company = company;
        this.location = location;
        this.yearlySalary = yearlySalary;
        this.yearlyBonus = yearlyBonus;
        this.restrictedStockAward = restrictedStockAward;
        this.relocStipend = relocStipend;
        this.holidays = holidays;
        this.score = score;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public float getYearlySalary() {
        return yearlySalary;
    }

    public void setYearlySalary(float yearlySalary) {
        this.yearlySalary = yearlySalary;
    }

    public float getYearlyBonus() {
        return yearlyBonus;
    }

    public void setYearlyBonus(float yearlyBonus) {
        this.yearlyBonus = yearlyBonus;
    }

    public float getRestrictedStockAward() {
        return restrictedStockAward;
    }

    public void setRestrictedStockAward(float restrictedStockAward) {
        this.restrictedStockAward = restrictedStockAward;
    }

    public float getRelocStipend() {
        return relocStipend;
    }

    public void setRelocStipend(float relocStipend) {
        this.relocStipend = relocStipend;
    }

    public Integer getHolidays() {
        return holidays;
    }

    public void setHolidays(Integer holidays) {
        this.holidays = holidays;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }
}
