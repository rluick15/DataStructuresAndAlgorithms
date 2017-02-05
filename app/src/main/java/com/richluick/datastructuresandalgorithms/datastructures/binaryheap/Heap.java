package com.richluick.datastructuresandalgorithms.datastructures.binaryheap;

import java.lang.reflect.Array;

/**
 * Created by rluick on 2/2/2017.
 *
 * T extends comparable to help check for priority
 */
public abstract class Heap<T extends Comparable> {

    private static int MAX_SIZE = 40;
    private T[] array;
    private int count = 0;

    public Heap(Class<T> clazz) {
        this(clazz, MAX_SIZE);
    }

    public Heap(Class<T> clazz, int size) {
        array = (T[]) Array.newInstance(clazz, size);
    }

    abstract void siftDown(int index);

    abstract void siftUp(int index);

    public int getLeftChildIndex(int index) {
        int leftIndex = (2 * index) + 1;
        if (leftIndex >= count) {
            return -1;
        }
        return leftIndex;
    }

    public int getRightChildIndex(int index) {
        int rightIndex = (2 * index) + 2;
        if (rightIndex >= count) {
            return -1;
        }
        return rightIndex;
    }

    public int getParent(int index) {
        if (index > count || index < 0) {
            return -1;
        }
        return (index - 1) / 2;
    }

    protected void swap(int index1, int index2) {
        T temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    public int getCount() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == array.length;
    }

    public T getElementAtIndex(int index) {
        return array[index];
    }

    public T getHighestPriority() throws HeapEmptyException {
        if (isEmpty()) {
            throw new HeapEmptyException();
        }

        return array[0];
    }

    public void insert(T data) throws HeapFullException {
        if (isFull()) {
            throw new HeapFullException();
        }

        array[count] = data;
        siftUp(count);
        count++;
    }

    public T remove() throws HeapEmptyException {
        T data = getHighestPriority();

        array[0] = array[count - 1];
        count--;
        siftDown(0);

        return data;
    }

    public boolean isLeafNode(int index) {
        if (getLeftChildIndex(index) == -1 && getRightChildIndex(index) == -1) {
            return true;
        } else {
            return false;
        }
    }
}
