package com.richluick.datastructuresandalgorithms.datastructures.stack;

/**
 * Created by rluick on 1/22/2017.
 */
public class MinimumElement {

    private Stack<Integer> integerStack;
    private Stack<Integer> minStack;

    public void push(int data) throws StackOverflowException, StackUnderflowException {
        int min = data;
        if (!minStack.isEmpty()) {
            if (data > minStack.peek()) {
                min = minStack.peek();
            }
        }

        integerStack.push(data);
        minStack.push(min);
    }

    public int pop() throws StackUnderflowException {
        minStack.pop();
        return integerStack.pop();
    }

    public int getMinimum() throws StackUnderflowException {
        return minStack.peek();
    }
}
