package com.zipcodechallenge;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class IntervalSorter implements Comparator<ZipcodeIntervals> {

    public int compare(ZipcodeIntervals interval1, ZipcodeIntervals interval2) {
        if (interval1.getLowerInterval() > interval2.getLowerInterval())
            return 1;
        else
            return -1;
    }


    public List<ZipcodeIntervals> sortLowerInterval (List<ZipcodeIntervals> zipcodeIntervalsList) {
        Collections.sort(zipcodeIntervalsList, new IntervalSorter());
        return zipcodeIntervalsList;
    }
}
