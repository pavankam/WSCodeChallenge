package com.zipcodechallenge;

import java.util.LinkedList;
import java.util.List;

public class IntervalProcessor {
    private String zipcodeRanges;

    public IntervalProcessor(String zipcodeRanges) {
        this.zipcodeRanges = zipcodeRanges;
    }

    public List<ZipcodeIntervals> stripZipcode() {
        String[] zipcodeIntervals = zipcodeRanges.split(" ");
        return loadZipcode(zipcodeIntervals);
    }

    public int stringToInt(String zipcode) {
        return Integer.parseInt(zipcode);
    }

    public boolean checkZipLength(int zipcode) {
        if ((int) (Math.log10(zipcode) + 1) != 5)
            return false;
        return true;
    }

    public boolean compareZipcodeRange(int lowerInterval, int upperInterval) {
        if (lowerInterval > upperInterval)
            return false;
        return true;
    }

    public boolean validateZipcodeRange(int lowerInterval, int upperInterval) {
        if (!checkZipLength(lowerInterval) && !checkZipLength(upperInterval))
            throw new IllegalArgumentException(lowerInterval + " " + upperInterval + ": " + "Zipcode should have 5 digits");
        if (compareZipcodeRange(lowerInterval, upperInterval) == false)
            throw new IllegalArgumentException(
                    lowerInterval + " " + upperInterval + ":  " + "Zipcode lower bound should be less than upper bound");
        return true;
    }

    public ZipcodeIntervals validateAndAdd(String[] zipRange) {
        if (zipRange.length != 2)
            throw new IllegalArgumentException(zipRange[0] + "Zipcode should have lower and upper bounds");
        int lowerInterval = stringToInt(zipRange[0]);
        int upperInterval = stringToInt(zipRange[1]);
        ZipcodeIntervals zipcodeIntervals = null;
        if (validateZipcodeRange(lowerInterval, upperInterval) == true)
            zipcodeIntervals = new ZipcodeIntervals(lowerInterval, upperInterval);
        return zipcodeIntervals;
    }

    public ZipcodeIntervals getZipcodeRange(String zipcodeRange) {
        return validateAndAdd(zipcodeRange.replaceAll("\\[|\\]", "").split(","));
    }

    public List<ZipcodeIntervals> loadZipcode(String[] zipcodeRange) {
        List<ZipcodeIntervals> zipcodesList = new LinkedList<ZipcodeIntervals>();
        for (int i = 0; i < zipcodeRange.length; i++) {
            zipcodesList.add(getZipcodeRange(zipcodeRange[i]));
        }
        return zipcodesList;
    }
}
