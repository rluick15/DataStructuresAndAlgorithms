package com.richluick.datastructuresandalgorithms.datastructures.queue;

import com.richluick.datastructuresandalgorithms.datastructures.stack.Stack;
import com.richluick.datastructuresandalgorithms.datastructures.stack.StackOverflowException;
import com.richluick.datastructuresandalgorithms.datastructures.stack.StackUnderflowException;

/**
 * Created by rluic on 2/14/2017.
 */

public class MyQueue {

    private static final int MAX_SIZE = 40;

    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    public void enqueue(int data) throws StackOverflowException {
        stack1.push(data);
    }

    public int dequeue() throws StackUnderflowException, StackOverflowException {
        if (!stack2.isEmpty()) {
            return stack2.peek();
        }

        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }

        return stack2.pop();
    }

    public int peek() throws StackUnderflowException, StackOverflowException {
        if (!stack2.isEmpty()) {
            return stack2.peek();
        }


        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }

        return stack2.peek();

    }
}
