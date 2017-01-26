package com.richluick.datastructuresandalgorithms.sorting;

import static com.richluick.datastructuresandalgorithms.sorting.HelperMethods.print;
import static com.richluick.datastructuresandalgorithms.sorting.HelperMethods.swap;

/**
 * Created by rluic on 1/25/2017.
 */
public class Insertion {

    public static int[] insertionSort(int[] listToSort) {
        for (int i = 0; i < listToSort.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (listToSort[j] < listToSort[j - 1]) {
                    swap(listToSort, listToSort[i], listToSort[j]);
                } else {
                    break;
                }
            }
            print(listToSort);
        }
        return listToSort;
    }
}
