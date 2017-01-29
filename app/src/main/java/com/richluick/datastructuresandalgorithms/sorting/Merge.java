package com.richluick.datastructuresandalgorithms.sorting;

import static com.richluick.datastructuresandalgorithms.sorting.HelperMethods.print;

/**
 * Created by rluic on 1/26/2017.
 */

public class Merge {

    public static void mergeSort(int[] listToSort) {
        if (listToSort.length == 1) {
            return;
        }

        int midIndex = listToSort.length / 2 + listToSort.length % 2;
        int[] listFirstHalf = new int[midIndex];
        int[] listSecondHalf = new int[listToSort.length - midIndex];
        split(listToSort, listFirstHalf, listSecondHalf);

        mergeSort(listFirstHalf);
        mergeSort(listSecondHalf);

        merge(listToSort, listFirstHalf, listSecondHalf);
        print(listToSort);
    }

    /**
     * Merges the first lf lists into a merged full list. List are already sorted
     *
     * @param listToSort original list
     * @param listFirstHalf first split list
     * @param listSecondHalf second split list
     */
    private static void merge(int[] listToSort, int[] listFirstHalf, int[] listSecondHalf) {
        int mergeIndex = 0;
        int firstHalfIndex = 0;
        int secondHalfIndex = 0;

        while (firstHalfIndex < listFirstHalf.length && secondHalfIndex < listFirstHalf.length) {
            //iterate over both lists, choose least one and then put into main list
            if (listFirstHalf[firstHalfIndex] < listSecondHalf[secondHalfIndex]) {
                listToSort[mergeIndex] = listFirstHalf[firstHalfIndex];
                firstHalfIndex++;
            } else {
                listToSort[mergeIndex] = listSecondHalf[secondHalfIndex];
                secondHalfIndex++;
            }
            mergeIndex++;
        }

        if (firstHalfIndex < listFirstHalf.length) {
            while (mergeIndex < listToSort.length) {
                listToSort[mergeIndex++] = listFirstHalf[firstHalfIndex];
            }
        }
        if (secondHalfIndex < listSecondHalf.length) {
            while (mergeIndex < listToSort.length) {
                listToSort[mergeIndex++] = listSecondHalf[secondHalfIndex++];
            }
        }
    }

    /**
     * Copies the first half of original list into the first hhalf list and the second half of the
     * original list into the second list
     *
     * @param listToSort original list
     * @param listFirstHalf first split list
     * @param listSecondHalf second split list
     */
    private static void split(int[] listToSort, int[] listFirstHalf, int[] listSecondHalf) {
        int index = 0;
        int seconfHalfStartIndex = listFirstHalf.length;
        for (int elements : listToSort) {
            if (index < seconfHalfStartIndex) {
                listFirstHalf[index] = listToSort[index];
            } else {
                listSecondHalf[index - seconfHalfStartIndex] = listToSort[index];
            }
            index++;
        }
    }
}
