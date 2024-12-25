package org.koushik.dsa.stacks;

import java.util.Stack;
/**
 * A custom implementation of a stack using a Java Stack.
 * This implementation supports basic stack operations: push and pop,
 * as well as a method to get the current minimum element in the stack, getMin().
 */
public class CustomStackUsingJavaStack {

    Stack<Integer> stack;
    Stack<Integer> minStack;

    public CustomStackUsingJavaStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if(minStack.isEmpty() || x < minStack.peek()) {
            minStack.push(x);
        }
    } // TC: O(1) & SC: O(1)

    public Integer pop() {
        if(stack.isEmpty()) {
            return -1;
        } else {
            if(stack.peek().equals(minStack.peek())) {
                minStack.pop();
            }
            return stack.pop();
        }
    } // TC: O(1) & SC: O(1)

    public Integer getMin() {
        if(stack.isEmpty()) {
            return -1;
        } else {
            return minStack.peek();
        }
    } // TC: O(1) & SC: O(1)
}
