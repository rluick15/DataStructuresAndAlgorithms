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

    @Override
    void siftUp(int index) {
        int parentIndex = getParent(index);

        if (parentIndex != -1 && getElementAtIndex(index).compareTo(getElementAtIndex(parentIndex)) < 0) {
            swap(index, parentIndex);
            siftUp(parentIndex);
        }
    }

    public T findMaximumElement() throws HeapEmptyException {
        int lastIndex = getCount() - 1;
        int firstChildIndex = getParent(lastIndex) + 1;

        T max = getElementAtIndex(firstChildIndex);

        for (int i = firstChildIndex; i <= lastIndex; i++) {
            if (max.compareTo(getElementAtIndex(i)) < 0) {
                max = getElementAtIndex(i);
            }
        }

        return max;
    }

    public void findLargestLElementsInAStream(int k, int[] randomNumberArry) throws HeapFullException, HeapEmptyException {
        MinimumHeap<Integer> minimumHeap = new MinimumHeap<Integer>(Integer.class, k);

        for (int i : randomNumberArry) {
            if (minimumHeap.isEmpty()) {
                minimumHeap.insert(i);
            } else if (!minimumHeap.isFull() || minimumHeap.getHighestPriority() < i) {
                if (minimumHeap.isFull()) {
                    minimumHeap.remove();
                }
                minimumHeap.insert(i);
            }
        }
    }
}
