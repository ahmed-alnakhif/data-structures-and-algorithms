package dataStructures;

import java.util.LinkedList;

public class CircularQueue {

    private LinkedList<Integer> list;
    private int size;

    public CircularQueue(int k) {
        list = new LinkedList<>();
        size = k;
    }

    public boolean enQueue(int value) {
        if (list.size() >= size) {
            return false;
        }

        list.addLast(value);
        return true;
    }

    public boolean deQueue() {
        if (list.isEmpty()) {
            return false;
        }

        list.removeFirst();
        return true;
    }

    public int Front() {
        if (list.isEmpty()) {
            return -1;
        } else {
            return list.getFirst();
        }
    }

    public int Rear() {
        if (list.isEmpty()) {
            return -1;
        } else {
            return list.getLast();
        }
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public boolean isFull() {
        return list.size() == size;
    }

    public static void main(String[] args) {

    }
}
