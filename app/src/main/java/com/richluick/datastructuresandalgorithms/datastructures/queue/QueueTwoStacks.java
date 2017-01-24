package com.richluick.datastructuresandalgorithms.datastructures.queue;

import com.richluick.datastructuresandalgorithms.datastructures.stack.Stack;
import com.richluick.datastructuresandalgorithms.datastructures.stack.StackOverflowException;
import com.richluick.datastructuresandalgorithms.datastructures.stack.StackUnderflowException;

/**
 * Created by rluic on 1/23/2017.
 *
 * Queue made with two stack
 */
public class QueueTwoStacks<T> {

    private static int MAX_SIZE = 40;

    private Stack<T> forwardStack = new Stack<>();
    private Stack<T> reverseStack = new Stack<>();

    public void enqueue(T data) throws QueueOverflowException {
        if (isFull()) {
            throw new QueueOverflowException();
        }

        try {
            if (reverseStack.getSize() > 0) {
                while (reverseStack.isEmpty()) {
                    forwardStack.push(reverseStack.pop());
                }
            }
            forwardStack.push(data);
        } catch (StackOverflowException | StackUnderflowException e) {
            throw new QueueOverflowException();
        }
    }

    public T dequeue() throws QueueUnderflowException {
        if (isEmpty()) {
            throw new QueueUnderflowException();
        }

        try {
            if (reverseStack.isEmpty()) {
                while (!forwardStack.isEmpty()) {
                    reverseStack.push(forwardStack.pop());
                }
            }
            return reverseStack.pop();
        } catch (StackUnderflowException | StackOverflowException e) {
            throw new QueueUnderflowException();
        }
    }

    public boolean isFull() {
        return forwardStack.isFull() || reverseStack.isFull();
    }

    public boolean isEmpty() {
        return forwardStack.isEmpty() && reverseStack.isEmpty();
    }
}
