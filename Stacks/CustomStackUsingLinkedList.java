package org.koushik.dsa.stacks;

/**
 * A custom implementation of a stack using a linked list.
 * This implementation supports basic stack operations: push and pop.
 */
public class CustomStackUsingLinkedList {

    private Node head;
    
    private int size;
    
    public void push(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
        } else {
            newNode.setNext(head);
            head = newNode;
        }
        size++;
        System.out.printf("Current stack size is: %d%n", size);
    } // TC: O(1) & SC: O(1)

    public int pop() {
        if(head == null) {
            System.out.println("Stack is empty");
            return -1;
        } else {
            int val = head.getData();
            head = head.getNext();
            size--;
            System.out.printf("Current stack size is: %d%n", size);
            return val;
        }
    } // TC: O(1) & SC: O(1)

    public void printStack() {
        if(head == null) {
            System.out.printf("Stack is empty: %s%n", "null");
        } else {
            System.out.printf("Current stack size is: %d%n", size);
            Node current = head;
            while(current != null) {
                System.out.printf("%d -> ", current.getData());
                current = current.getNext();
            }
            System.out.println("null");
        }
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
