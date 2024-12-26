package org.koushik.dsa.queues;

/**
 * A custom implementation of a queue using a linked list.
 * This implementation supports basic queue operations: enqueue, dequeue and peek,
 * as well as a method to get the size of the queue.
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
        size++;
    }

    public int dequeue() {
        if (head == null) {
            System.out.println("Queue is empty");
            return -1;
        } else {
            int value = head.getData();
            head = head.getNext();
            size--;
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
        return size;
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
