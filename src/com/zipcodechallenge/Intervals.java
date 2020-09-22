package com.zipcodechallenge;

public class Intervals {
    private int lowerInterval;
    private int upperInterval;

    public Intervals(int lowerInterval, int upperInterval) {
        this.lowerInterval = lowerInterval;
        this.upperInterval = upperInterval;
    }

    public int getLowerInterval() {
        return lowerInterval;
    }

    public void setLowerInterval(int lowerInterval) {
        this.lowerInterval = lowerInterval;
    }

    public int getUpperInterval() {
        return upperInterval;
    }

    public void setUpperInterval(int upperInterval) {
        this.upperInterval = upperInterval;
    }

}
