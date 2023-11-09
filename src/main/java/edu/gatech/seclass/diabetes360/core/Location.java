package edu.gatech.seclass.diabetes360.core;

public class Location {
    private String city;
    private String state;
    private Integer costOfLivingIndex;

    public Location(String city, String state, Integer costOfLivingIndex) {
        this.city = city;
        this.state = state;
        this.costOfLivingIndex = costOfLivingIndex;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getCostOfLivingIndex() {
        return costOfLivingIndex;
    }

    public void setCostOfLivingIndex(Integer costOfLivingIndex) {
        this.costOfLivingIndex = costOfLivingIndex;
    }

    public float adjustIncome(float income) {
        return income / costOfLivingIndex;
    }
}
