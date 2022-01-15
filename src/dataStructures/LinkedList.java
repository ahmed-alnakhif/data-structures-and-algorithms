package dataStructures;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LinkedList {
    Node head;
    int size;

    public static class Node {
        public int data;
        public Node next;

        Node(int data) {
            this.data = data;
        }
    }

    public Node generateRandomList(int size) {
        if (size < 1) {
            return null;
        }

        Random random = new Random();
        this.head = new Node(random.nextInt(size));
        Node prev = this.head;

        for (int i = 0; i < size; i++) {
            Node node = new Node(random.nextInt(size));
            prev.next = node;
            prev = node;
        }

        return this.head;
    }

    public Node generateStaticList(int size) {
        if (size < 1) {
            return null;
        }

        this.head = new Node(0);
        Node prev = this.head;
        for (int i = 1; i < size; i++) {
            Node node = new Node(i);
            prev.next = node;
            prev = node;
        }
        return this.head;
    }

    public List<Integer> traverse() {
        List<Integer> list = new ArrayList<>();
        Node curr = this.head;
        while (curr != null) {
            list.add(curr.data);
            curr = curr.next;
        }
        return list;
    }

    public Node getTail() {
        if (this.head == null) {
            return this.head;
        }

        Node tail = this.head;

        while (tail != null) {
            if (tail.next == null) {
                return tail;
            }
            tail = tail.next;
        }
        return tail;
    }

    public void insertFirst(int value) {
        Node newNode = new Node(value);

        if (this.head == null) {
            this.head = newNode;
            return;
        }

        if (this.head.next == null) {
            newNode.next = this.head;
            this.head = newNode;
            return;
        }

        newNode.next = this.head;
        this.head = newNode;
    }

    public void insertLast(int value) {
        Node newNode = new Node(value);

        if (this.head == null) {
            this.head = newNode;
            return;
        }

        Node curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = newNode;
    }

    public void insertAt(int value, int index) {
        if (index <= 0) {
            this.insertFirst(value);
            return;
        }

        Node newNode = new Node(value);
        Node curr = this.head;
        for (int i = 1; i < index - 1 && curr.next != null; i++) {
            curr = curr.next;
        }
        newNode.next = curr.next;
        curr.next = newNode;
        System.out.println();
    }

    public void delete(int value) {
        if(head == null){
            return;
        }

        Node curr = this.head;
        Node prev = this.head;
        while(curr != null){
            if(curr.data == value){
                if(curr == this.head){
                    this.head = curr.next;
                }
                prev.next = curr.next;
                return;
            }
            prev = curr;
            curr = curr.next;
        }
    }

    public Node find(int value) {
        Node curr = this.head;
        while(curr != null){
            if(curr.data == value){
                return curr;
            }
            curr = curr.next;
        }
        return null;
    }
}
