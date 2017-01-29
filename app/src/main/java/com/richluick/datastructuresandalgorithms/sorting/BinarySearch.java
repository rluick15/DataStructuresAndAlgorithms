package com.richluick.datastructuresandalgorithms.sorting;

/**
 * Created by rluic on 1/29/2017.
 */

public class BinarySearch {

    public static int binarySearch(int[] list, int number) {
        int min = 0;
        int max = list.length - 1;

        while (min <= max) {
            int mid = min + (max - min) / 2;

            if (number == list[mid]) {
                return mid;
            } else if(number < list[mid]) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }

        return -1;
    }
}
