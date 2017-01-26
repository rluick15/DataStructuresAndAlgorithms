package com.richluick.datastructuresandalgorithms.sorting;

import static com.richluick.datastructuresandalgorithms.sorting.HelperMethods.print;
import static com.richluick.datastructuresandalgorithms.sorting.HelperMethods.swap;

/**
 * Created by rluic on 1/25/2017.
 */
public class Bubble {

    public static int[] bubbleSort(int[] listToSort) {
        boolean didSort;
        for (int i = 0; i < listToSort.length; i++) {
            didSort = false;
            for (int j = 0; j < listToSort.length - i; j++) {
                if (listToSort[j] > listToSort[j + 1]) {
                    didSort = true;
                    swap(listToSort, j, j + 1);
                }
            }
            print(listToSort);
            if (!didSort) {
                break;
            }
        }
        return listToSort;
    }
}
