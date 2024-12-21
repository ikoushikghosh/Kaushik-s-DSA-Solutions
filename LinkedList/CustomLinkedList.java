package org.koushik.dsa.linkedlist;


/**
 * A custom implementation of a singly linked list. This class provides
 * methods for creating, inserting, deleting, reversing, and printing
 * linked list nodes, as well as utility operations at specific positions
 * in the list.
 */
public class CustomLinkedList {

    private Node tail;
    private int size = 1;

    public Node createLinkedList(int[] listData) {
        if(listData == null || listData.length == 0) return null;

        Node head = new Node(listData[0]);
        tail = head;

        for(int i = 1; i < listData.length; i++) {
            tail.setNext(new Node(listData[i]));
            tail = tail.getNext();
            size++;
        }

        return head;
    }

    public Node insertAtHead(Node head, int data) {
        if(head == null) {
            head = new Node(data);
            tail = head;
        } else {
            Node newNode = new Node(data);
            newNode.setNext(head);
            head = newNode;
        }
        size++;

        return head;
    } // TC: O(1) & SC: O(1)

    public Node insertAtTail(Node head, int data) {

        if(head == null) {
            head = new Node(data);
            tail = head;
        } else {
            Node newNode = new Node(data);
            tail.setNext(newNode);
            tail = tail.getNext();
        }
        size++;
        return head;

    } // TC: O(1) & SC: O(1)

    public Node insertAtKthPosition(Node head, int data, int k) {
        if(head == null || k > size) return head;

        if(k == 0) {
            head = insertAtHead(head, data);
        } else if (k == size) {
            head = insertAtTail(head, data);
        } else {
            Node current = head;
            int count = 1;
            Node newNode = new Node(data);
            while(current != null && count <= k) {
                if(count == k) {
                    newNode.setNext(current.getNext());
                    current.setNext(newNode);
                    if(current.getNext() == null) {
                        tail = current;
                    }
                    break;
                }
                current = current.getNext();
                count++;
            }
            size++;
        }
        return head;
    } // TC: O(n) & SC: O(1)

    public Node deleteNodeAtHead(Node head) {
        if(head == null) return null;

        head = head.getNext();
        size--;
        return head;
    } // TC: O(1) & SC: O(1)

    public Node deleteNodeAtTail(Node head) {
        if(head == null) return null;

        Node current = head;

        while(current.getNext().getNext() != null) {
            current = current.getNext();
        }

        current.setNext(null);
        tail = current;
        size--;
        return head;
    }// TC: O(n) & SC: O(1)

    public Node deleteNodeAtKthPosition(Node head, int k) {
        if(head == null || k > size) return head;

        if(k == 0) {
            head = deleteNodeAtHead(head);
        } else if(k == size) {
            head = deleteNodeAtTail(head);
        } else {
            Node current = head;
            int count = 1;

            while(current != null && count <= k) {
                if(count == k) {
                    current.setNext(current.getNext().getNext());
                    if(current.getNext() == null) {
                        tail = current;
                    }
                }
                current = current.getNext();
                count++;
            }
            size--;
        }

        return head;
    }// TC: O(n) & SC: O(1)

    public Node reverse(Node head) {
        if(head == null || head.getNext() == null) return head;

        // update tail before reverse
        tail = head;

        Node newHead = null;
        Node current = head;
        Node temp;

        while(current != null) {
            temp = current;
            current = current.getNext();
            temp.setNext(newHead);
            newHead = temp;
        }

        return newHead;
    }// TC: O(n) & SC: O(1)

    public Node reverseFirstKNodes(Node head, int k) {
        if(head == null || k == 0 || k > size) return head;
        else if(k == size) return reverse(head);
        else {
            Node newHead = null;
            Node current = head;
            Node temp;

            while (current != null && k > 0) {
                temp = current;
                current = current.getNext();
                temp.setNext(newHead);
                newHead = temp;
                k--;
            }
            head.setNext(current);

            return newHead;
        }
    }// TC: O(n) & SC: O(1)

    public Node reverseKGroup(Node head, int k) {
        if(head == null || k <= 1) return head;

        Node current = head;
        Node newHead = null;
        Node temp;

        int groupSize = k;
        while(current != null && groupSize > 0) {
            temp = current;
            current = current.getNext();
            temp.setNext(newHead);
            newHead = temp;
            groupSize--;
        }

        head.setNext(reverseKGroup(current, k));

        return newHead;
    }

    public void printLinkedList(Node head) {
        System.out.printf("The linked list of size = %d is: ", size);

        if(head == null) {
            System.out.println("null");
            return;
        }

        Node currentNode = head;
        while(currentNode != null) {
            System.out.printf("%d -> ", currentNode.getData());
            currentNode = currentNode.getNext();
        }
        System.out.println("null");

    }
}
