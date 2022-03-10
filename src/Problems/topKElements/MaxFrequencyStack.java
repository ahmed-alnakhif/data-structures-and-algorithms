package Problems.topKElements;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * Design a stack-like data structure to push elements to the stack and pop the
 * most frequent element from the stack.
 * 
 * Implement the FreqStack class:
 * 
 * FreqStack() constructs an empty frequency stack.
 * void push(int val) pushes an integer val onto the top of the stack.
 * int pop() removes and returns the most frequent element in the stack.
 * If there is a tie for the most frequent element, the element closest to the
 * stack's top is removed and returned.
 */

class Element {
    int num;
    int freq;
    int created;

    Element(int num, int freq, int created) {
        this.num = num;
        this.freq = freq;
        this.created = created;
    }
}

class ElementComparator implements Comparator<Element> {
    public int compare(Element e1, Element e2) {
        if (e1.freq != e2.freq) {
            return e2.freq - e1.freq;
        } else {
            return e2.created - e1.created;
        }
    }
}

public class MaxFrequencyStack {

    HashMap<Integer, Integer> map;
    PriorityQueue<Element> maxHeap;
    int created;

    public MaxFrequencyStack() {
        map = new HashMap<Integer, Integer>();
        maxHeap = new PriorityQueue<Element>(new ElementComparator());
        created = 0;
    }

    public void push(int val) {
        map.put(val, map.getOrDefault(val, 0) + 1);
        maxHeap.add(new Element(val, map.get(val), created++));
    }

    public int pop() {
        int topNum = maxHeap.poll().num;

        if (map.get(topNum) > 1) {
            map.put(topNum, map.get(topNum) - 1);
        } else {
            map.remove(topNum);
        }

        return topNum;
    }

    /**
     * Your FreqStack object will be instantiated and called as such:
     * FreqStack obj = new FreqStack();
     * obj.push(val);
     * int param_2 = obj.pop();
     */

    public static void main(String[] args) {

    }
}
