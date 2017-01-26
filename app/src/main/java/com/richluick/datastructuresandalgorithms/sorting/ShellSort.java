package com.richluick.datastructuresandalgorithms.sorting;

import static com.richluick.datastructuresandalgorithms.sorting.HelperMethods.print;
import static com.richluick.datastructuresandalgorithms.sorting.HelperMethods.swap;

/**
 * Created by q1410049 on 1/26/17.
 */

public class ShellSort {

    public static void shellSort(int[] listToSort) {
        int increment = listToSort.length / 2; //random increment value
        while (increment >= 1) {
            for (int i = 0; i < increment; i++) {
                insertionSort(listToSort, i, increment);
            }
            increment--;
        }
    }

    private static void insertionSort(int[] listToSort, int startIndex, int increment) {
        for (int i = startIndex; i < listToSort.length; i = i + increment) {
            for (int j = Math.min(i + increment, listToSort.length - 1);
                    j - increment > 0;
                    j = j- increment) {

                if (listToSort[j] > listToSort[j - increment]) {
                    swap(listToSort, j, j - increment);
                } else {
                    break;
                }
                print(listToSort);
            }
        }
    }
}
