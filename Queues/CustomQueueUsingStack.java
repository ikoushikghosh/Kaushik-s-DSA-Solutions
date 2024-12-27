package org.koushik.dsa.queues;

import java.util.Stack;

/**
 * A custom implementation of a queue using two stacks.
 *
 * This implementation of a queue uses two stacks to support queue operations.
 * It uses one stack to store elements added to the queue (enqueue stack) and
 * another stack to store elements removed from the queue (dequeue stack).
 *
 * The {@link #enqueue(int)} operation adds an element to the enqueue stack.
 * The {@link #dequeue()} operation removes an element from the dequeue stack.
 * If the dequeue stack is empty, elements are first copied from the enqueue stack
 * to the dequeue stack in reverse order before removing the element from the dequeue stack.
 * The {@link #peek()} operation returns the top element from the dequeue stack.
 * If the dequeue stack is empty, elements are first copied from the enqueue stack
 * to the dequeue stack in reverse order before returning the element from the dequeue stack.
 * The {@link #printQueue()} operation prints the elements in the dequeue stack.
 * If the dequeue stack is empty, elements are first copied from the enqueue stack
 * to the dequeue stack in reverse order before printing the elements from the dequeue stack.
 *
 * @author Koushik
 */
public class CustomQueueUsingStack {

    private Stack<Integer> enqueueStack;

    private Stack<Integer> dequeueStack;


    public CustomQueueUsingStack() {
        enqueueStack = new Stack<>();
        dequeueStack = new Stack<>();
    }

    public void enqueue(int item) {
        enqueueStack.push(item);
    } // TC: O(1), SC: O(1)

    public int dequeue() {
        if(enqueueStack.isEmpty() && dequeueStack.isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        copyStackToAnother(enqueueStack, dequeueStack);
        return dequeueStack.pop();
    } // TC: O(1)[Amortized TC], SC: O(n)

    public int peek() {
        if(enqueueStack.isEmpty() && dequeueStack.isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        copyStackToAnother(enqueueStack, dequeueStack);
        return dequeueStack.peek();
    } // TC: O(1)[Amortized TC], SC: O(n)

    public void printQueue() {
        if (enqueueStack.isEmpty() && dequeueStack.isEmpty()) {
            System.out.println("Queue is empty");
        } else {
            Stack<Integer> printerStack = new Stack<>();
            printerStack.addAll(dequeueStack);
            printerStack.addAll(enqueueStack);
            System.out.printf("The queue of size = %d, is: %s%n", printerStack.size(), printerStack);
        }
    }

    private void copyStackToAnother(Stack<Integer> stackFromCopy, Stack<Integer> stackToCopy) {
        if(stackFromCopy.isEmpty() && stackToCopy.isEmpty()) return;
        if (stackToCopy.isEmpty()) {
            while(!stackFromCopy.isEmpty()) {
                stackToCopy.push(stackFromCopy.pop());
            }
        }
    }
}
