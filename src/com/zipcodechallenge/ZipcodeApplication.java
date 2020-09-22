package com.zipcodechallenge;

import java.util.List;
import java.util.Scanner;

public class ZipcodeApplication {

    public static void main(String[] args) {
        var scan = new Scanner(System.in);
        System.out.println("Enter zipcode ranges: ");
        String zipcodeRanges = scan.nextLine();

        var zipcodeProcessor = new IntervalProcessor(zipcodeRanges);
        List<ZipcodeIntervals> zipcodeIntervalsList = zipcodeProcessor.stripZipcode();

        var zipcodeSorter = new IntervalSorter();
        List<ZipcodeIntervals> sortedZipCodeList = zipcodeSorter.sortLowerInterval(zipcodeIntervalsList);

        var zipcodeMerger = new IntervalMerger();
        List<ZipcodeIntervals> mergedIntervalsList = zipcodeMerger.mergeZipcodes(sortedZipCodeList);

        for (ZipcodeIntervals zipcodeIntervals : mergedIntervalsList) {
            System.out.println("[" + zipcodeIntervals.getLowerInterval() + "," + zipcodeIntervals.getUpperInterval() + "]");
        }
    }
}
