package com.zipcodechallenge;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class IntervalMerger {

    public List<ZipcodeIntervals> mergeZipcodes(List<ZipcodeIntervals> sortedList) {
        List<ZipcodeIntervals> mergedIntervalsList = new LinkedList<ZipcodeIntervals>();
        ZipcodeIntervals zipcodeIntervals = null;
        for (ZipcodeIntervals zipcodeInterval : sortedList) {
            if (zipcodeIntervals == null)
                zipcodeIntervals = zipcodeInterval;

            else {
                if (zipcodeIntervals.getUpperInterval() >= zipcodeInterval.getLowerInterval()) {
                    zipcodeIntervals.setUpperInterval(Math.max(zipcodeIntervals.getUpperInterval(), zipcodeInterval.getUpperInterval()));
                }

                else {
                    mergedIntervalsList.add(zipcodeIntervals);
                    zipcodeIntervals = zipcodeInterval;
                }
            }
        }
        mergedIntervalsList.add(zipcodeIntervals);
        return mergedIntervalsList;
    }

}
