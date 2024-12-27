package org.koushik.dsa.queues;

/**
 * A custom implementation of a queue using a singly linked list.
 * This class provides methods to perform basic queue operations such as
 * enqueue, dequeue, and peek, as well as a method to get the size of the queue.
 * The queue follows the First-In-First-Out (FIFO) principle.
 *
 * <p>
 * The {@link #enqueue(int)} method adds an element to the end of the queue.
 * The {@link #dequeue()} method removes and returns the element at the front of the queue.
 * The {@link #peek()} method returns the element at the front of the queue without removing it.
 * The {@link #getSize()} method returns the current number of elements in the queue.
 * </p>
 *
 * <p>
 * This queue implementation is dynamic and can grow as needed. It maintains a reference
 * to the head and tail nodes of the linked list to efficiently add and remove elements.
 * </p>
 *
 * <p>
 * Usage example:
 * <pre>
 *     CustomQueueUsingLinkedList queue = new CustomQueueUsingLinkedList();
 *     queue.enqueue(10);
 *     queue.enqueue(20);
 *     int front = queue.peek(); // returns 10
 *     int removed = queue.dequeue(); // returns 10
 *     int size = queue.getSize(); // returns 1
 * </pre>
 * </p>
 *
 * @author Koushik
 */
public class CustomQueueUsingLinkedList {

    private Node head;

    private Node tail;

    private int size;

    public CustomQueueUsingLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void enqueue(int data) {
        if (head == null) {
            head = new Node(data);
            tail = head;
        } else {
            tail.setNext(new Node(data));
            tail = tail.getNext();
        }
        this.size++;
    }

    public int dequeue() {
        if (head == null) {
            System.out.println("Queue is empty");
            return -1;
        } else {
            int value = head.getData();
            head = head.getNext();
            this.size--;
            return value;
        }
    }

    public int peek() {
        if (head == null) {
            System.out.println("Queue is empty");
            return -1;
        } else {
            return head.getData();
        }
    }

    public int getSize() {
        return this.size;
    }

    public void printQueue() {
        System.out.printf("The queue of size = %d, is: ", getSize());
        Node current = head;
        while(current != null) {
            System.out.printf("%d -> ", current.getData());
            current = current.getNext();
        }
        System.out.println("null");
    }
}

class Node {
    private int data;

    private Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
