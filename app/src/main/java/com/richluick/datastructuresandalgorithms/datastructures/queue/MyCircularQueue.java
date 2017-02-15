package com.richluick.datastructuresandalgorithms.datastructures.queue;

/**
 * Created by rluic on 2/14/2017.
 */

public class MyCircularQueue {

    private static final int MAX_SIZE = 40;

    private int[] queue;
    private int size = 0;
    private int headIndex = 0;
    private int tailIndex = 0;

    public MyCircularQueue() {
        queue = new int[MAX_SIZE];
    }

    public void enqueue(int data) throws QueueOverflowException {
        if (isFull()) {
            throw new QueueOverflowException();
        }

        tailIndex = (tailIndex + 1) % queue.length;
        queue[tailIndex] = data;
        size++;
    }

    public int dequeue() throws QueueUnderflowException {
        if (isEmpty()) {
            throw new QueueUnderflowException();
        }

        int data = queue[headIndex];
        headIndex = (headIndex + 1) % queue.length;
        size--;
        return data;
    }

    public boolean isFull() {
        return size == MAX_SIZE;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
