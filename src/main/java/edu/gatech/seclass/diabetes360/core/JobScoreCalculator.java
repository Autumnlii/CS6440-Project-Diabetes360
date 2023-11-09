package edu.gatech.seclass.diabetes360.core;

public class JobScoreCalculator {
    private float salaryWeight = 1.0f;
    private float bonusWeight = 1.0f;
    private float stockWeight = 1.0f;
    private float relocationWeight = 1.0f;
    private float holidayWeight = 1.0f;

    public JobScoreCalculator() {
    }

    public JobScoreCalculator(float salaryWeight, float bonusWeight, float stockWeight,
                              float relocationWeight, float holidayWeight) {
        this.salaryWeight = salaryWeight;
        this.bonusWeight = bonusWeight;
        this.stockWeight = stockWeight;
        this.relocationWeight = relocationWeight;
        this.holidayWeight = holidayWeight;
    }

    public float calculateScore(Job job, Location location) {
        float yearlySalaryAdjusted = location.adjustIncome(job.getYearlySalary());
        float yearlyBonusAdjusted = location.adjustIncome(job.getYearlyBonus());
        float restrictedStockUnitAward = job.getRestrictedStockAward();
        float relocationStipend = job.getRelocStipend();
        int personalChoiceHolidays = job.getHolidays();

        return (salaryWeight / 7) * yearlySalaryAdjusted
                + (bonusWeight / 7) * yearlyBonusAdjusted
                + (stockWeight / 28) * restrictedStockUnitAward
                + (relocationWeight / 7) * relocationStipend
                + (holidayWeight / 182.5f) * (personalChoiceHolidays * yearlySalaryAdjusted / 260);
    }

    public float getSalaryWeight() {
        return salaryWeight;
    }

    public void setSalaryWeight(float salaryWeight) {
        this.salaryWeight = salaryWeight;
    }

    public float getBonusWeight() {
        return bonusWeight;
    }

    public void setBonusWeight(float bonusWeight) {
        this.bonusWeight = bonusWeight;
    }

    public float getStockWeight() {
        return stockWeight;
    }

    public void setStockWeight(float stockWeight) {
        this.stockWeight = stockWeight;
    }

    public float getRelocationWeight() {
        return relocationWeight;
    }

    public void setRelocationWeight(float relocationWeight) {
        this.relocationWeight = relocationWeight;
    }

    public float getHolidayWeight() {
        return holidayWeight;
    }

    public void setHolidayWeight(float holidayWeight) {
        this.holidayWeight = holidayWeight;
    }
}
