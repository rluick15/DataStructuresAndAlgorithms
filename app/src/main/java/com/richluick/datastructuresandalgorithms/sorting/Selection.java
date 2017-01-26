package com.richluick.datastructuresandalgorithms.sorting;

/**
 * Created by rluic on 1/25/2017.
 */
public class Selection {

    public static int[] selectionSort(int[] listToSort) {
        for (int i = 0; i < listToSort.length; i++) {
            for (int j = i + 1; j < listToSort.length; j++) {
                if (listToSort[i] > listToSort[j]) {
                    HelperMethods.swap(listToSort, i, j);
                    HelperMethods.print(listToSort);
                }
            }
        }
        return listToSort;
    }
}
