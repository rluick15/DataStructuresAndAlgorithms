package com.richluick.datastructuresandalgorithms.datastructures.stack;

/**
 * Created by rluic on 1/19/2017.
 */

public class Stack<T> {

    private static int MAX_SIZE = 40;

    private Element<T> top;
    private int size = 0;

    public void push(T data) throws StackOverflowException {
        if (size == MAX_SIZE) {
            throw new StackOverflowException();
        }

        top = new Element(data, top);
        size++;
    }

    public T pop() throws StackUnderflowException {
        if (size == 0) {
            throw new StackUnderflowException();
        }
        T data = top.getData();
        top = top.getNext();
        size--;
        return data;
    }

    public T peek() throws StackUnderflowException {
        if (size == 0) {
            throw new StackUnderflowException();
        }

        return top.getData();
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == MAX_SIZE;
    }

    public int getSize() {
        return size;
    }
}
