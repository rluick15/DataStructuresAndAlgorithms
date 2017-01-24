package com.richluick.datastructuresandalgorithms.datastructures.queue;

import java.lang.reflect.Array;

/**
 * Created by rluic on 1/22/2017.
 */

public class Queue<T> {

    private static final int SPECIAL_EMPTY_VALUE = -1;
    private static int MAX_SIZE = 40;
    private T[] elements;

    private int headIndex = SPECIAL_EMPTY_VALUE;
    private int tailIndex = SPECIAL_EMPTY_VALUE;

    public Queue(Class<T> clazz) {
        elements = (T[]) Array.newInstance(clazz, MAX_SIZE);
    }

    public void enqueue(T data) throws QueueOverflowException {
        if (isFull()) {
            throw new QueueOverflowException();
        }

        tailIndex = (tailIndex + 1) % elements.length;
        elements[tailIndex] = data;

        if (headIndex == SPECIAL_EMPTY_VALUE) {
            headIndex = tailIndex;
        }
    }

    public T dequeue() throws QueueUnderflowException {
        if (headIndex == SPECIAL_EMPTY_VALUE) {
            throw new QueueUnderflowException();
        }

        T data = elements[headIndex];
        if (headIndex == tailIndex) {
            headIndex = SPECIAL_EMPTY_VALUE;
        } else {
            headIndex = (headIndex + 1) % elements.length;
        }

        return data;
    }

    public boolean isFull() {
        int nextIndex = (tailIndex + 1) % elements.length;
        return nextIndex == headIndex;
    }

    public boolean isEmpty() {
        return headIndex == SPECIAL_EMPTY_VALUE;
    }
}
