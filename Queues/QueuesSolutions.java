package org.koushik.dsa.queues;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class QueuesSolutions {

    public static void main(String[] args) {
        reverseFirstKElementsOfQueue(new LinkedList<>(Arrays.asList(3, 10, 2, 12, 19, 6, 8, 10, 14)), 4);
    }

    public static void reverseFirstKElementsOfQueue(Queue<Integer> queue, int k) {
        if(queue == null || queue.isEmpty()) return;

        Stack<Integer> stack = new Stack<>();
        int counter = k;
        while(counter > 0) {
            stack.push(queue.poll());
            counter--;
        }

        while(!stack.isEmpty()) {
            queue.add(stack.pop());
        }

        counter = queue.size() - k;

        while(counter > 0) {
            Integer value = queue.poll();
            queue.add(value);
            counter--;
        }

        System.out.printf("The reversed first %d elements of queue is: %s%n", k, queue);

    } // TC: O(n), SC: O(n)

}
