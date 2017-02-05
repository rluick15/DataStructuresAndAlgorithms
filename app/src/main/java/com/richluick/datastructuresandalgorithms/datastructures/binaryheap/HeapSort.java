package com.richluick.datastructuresandalgorithms.datastructures.binaryheap;

/**
 * Created by rluic on 2/5/2017.
 */

public class HeapSort {

    private int[] array;

    private int getLeftChildIndex(int index, int endIndex) {
        int leftIndex = (2 * index) + 1;
        if (leftIndex > endIndex) {
            return -1;
        }
        return leftIndex;
    }

    private int getRightChildIndex(int index, int endIndex) {
        int rightIndex = (2 * index) + 2;
        if (rightIndex > endIndex) {
            return -1;
        }
        return rightIndex;
    }

    private int getParent(int index, int endIndex) {
        if (index < 0 || index > endIndex) {
            return -1;
        }
        return (index - 1) / 2;
    }

    private void swap(int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    private void percolateDown(int index, int endIndex) {
        int leftIndex = getLeftChildIndex(index, endIndex);
        int rightIndex = getRightChildIndex(index, endIndex);

        if (leftIndex != -1 && array[leftIndex] > array[index]) {
            swap(leftIndex, index);
            percolateDown(leftIndex, endIndex);
        }
        if (rightIndex != -1 && array[rightIndex] > array[index]) {
            swap(rightIndex, index);
            percolateDown(rightIndex, endIndex);
        }
    }

    public void heapify(int endIndex) {
        int index = getParent(endIndex, endIndex);

        while (index >= 0) {
            percolateDown(index, endIndex);
            index--;
        }
    }

    public void heapSort() {
        int endIndex = array.length - 1;
        heapify(endIndex);

        while (endIndex > 0) {
            swap(0, endIndex);
            percolateDown(0, endIndex);
            endIndex--;
        }
    }
}
