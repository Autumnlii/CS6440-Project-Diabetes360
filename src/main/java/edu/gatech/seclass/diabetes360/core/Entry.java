package edu.gatech.seclass.diabetes360.core;

public abstract class Entry {
    private int month;
    private int day;
    private int value;

    public Entry(int month, int day, int value) {
        this.month = month;
        this.day = day;
        this.value = value;

    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

}
