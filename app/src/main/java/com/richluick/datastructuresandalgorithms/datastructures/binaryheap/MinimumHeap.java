package com.richluick.datastructuresandalgorithms.datastructures.binaryheap;

/**
 * Created by rluic on 2/2/2017.
 */

public class MinimumHeap<T extends Comparable> extends Heap<T> {

    public MinimumHeap(Class<T> clazz) {
        super(clazz);
    }

    public MinimumHeap(Class<T> clazz, int size) {
        super(clazz, size);
    }

    @Override
    void siftDown(int index) {
        int leftIndex = getLeftChildIndex(index);
        int rightIndex = getRightChildIndex(index);

        int smallerIndex = -1;
        if (leftIndex != -1 && rightIndex != -1) {
            smallerIndex = getElementAtIndex(leftIndex).compareTo(getElementAtIndex(rightIndex)) < 0 ? leftIndex : rightIndex;
        } else if (leftIndex != -1) {
            smallerIndex = leftIndex;
        } else if(rightIndex != -1) {
            smallerIndex = rightIndex;
        }

        if (smallerIndex == -1) {
            return;
        }

        if (getElementAtIndex(smallerIndex).compareTo(getElementAtIndex(index)) < 0) {
            swap(index, smallerIndex);
            siftDown(smallerIndex);
        }
    }
}
