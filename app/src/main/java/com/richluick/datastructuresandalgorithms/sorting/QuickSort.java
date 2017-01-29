package com.richluick.datastructuresandalgorithms.sorting;

import static com.richluick.datastructuresandalgorithms.sorting.HelperMethods.print;
import static com.richluick.datastructuresandalgorithms.sorting.HelperMethods.swap;

/**
 * Created by rluic on 1/29/2017.
 */
public class QuickSort {

    public static void quickSort(int[] listToSort, int low, int high) {
        if (listToSort.length == 1) {
            return;
        }

        int pivotIndex = partition(listToSort, low, high);
        quickSort(listToSort, low, pivotIndex - 1);
        quickSort(listToSort, pivotIndex + 1, high);
    }

    public static int partition(int[] listToSort, int low, int high) {
        int pivot = listToSort[low];
        int l = low;
        int h = high;

        //slowly move towards center, checking if is greater or smaller than the pivot
        while (l < h) {
            while (listToSort[l] <= pivot && l < h) {
                l++;
            }
            while (listToSort[h] > pivot) {
                h--;
            }
            if (l < h) {
                swap(listToSort, low, h);
            }
        }

        System.out.println("Pivot: " + pivot);
        print(listToSort);
        return h;
    }
}
