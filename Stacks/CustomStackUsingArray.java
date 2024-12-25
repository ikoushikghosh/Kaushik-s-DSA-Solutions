package org.koushik.dsa.stacks;

/**
 * A custom implementation of a stack using an array.
 * This implementation supports basic stack operations: push and pop,
 * with a fixed capacity defined at the time of instantiation.
 */
public class CustomStackUsingArray {

    private final int[] array;
    private int top;

    public CustomStackUsingArray(int capacity) {
        array = new int[capacity];
        top = 0;
    }

    public void push(int item) {
        if(top < array.length) {
            array[top++] = item;
        } else {
            System.out.printf("Stack is full, reached max array size: %d%n", array.length);
        }
    } // TC: O(1) & SC: O(1)

    public int pop() {
        if(top > 0) {
            // as top++ already increased to next pointer while doing push(),
            // so at the time of pop() we need to do --top instead of top--
            return array[--top];
        }
        System.out.println("Stack is empty");
        return -1;
    } // TC: O(1) & SC: O(1)

}
