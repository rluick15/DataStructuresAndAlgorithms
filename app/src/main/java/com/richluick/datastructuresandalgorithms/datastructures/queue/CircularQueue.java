package com.richluick.datastructuresandalgorithms.datastructures.queue;

/**
 * Created by rluic on 2/9/2017.
 */

public class CircularQueue {

    private int[] queue;
    private static final int MAX_SIZE = 40;
    private int count = 0;

    int headIndex = 0;
    int tailIndex = 0;

    public CircularQueue() {
        queue = new int[MAX_SIZE];
    }

    public void enqueue(int data) throws QueueOverflowException {
        if (isFull()) {
            throw new QueueOverflowException();
        }

        tailIndex = (1 + tailIndex) % queue.length;
        queue[tailIndex] = data;

        count++;
    }

    public int dequeue() throws QueueUnderflowException {
        if (isEmpty()) {
            throw new QueueUnderflowException();
        }

        int data = queue[headIndex];
        headIndex = (headIndex + 1) % queue.length;
        count--;
        return data;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == MAX_SIZE;
    }
}
