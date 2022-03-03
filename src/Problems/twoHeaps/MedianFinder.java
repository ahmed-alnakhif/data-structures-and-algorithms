package Problems.twoHeaps;

import java.util.PriorityQueue;

public class MedianFinder {
    PriorityQueue<Integer> minH;
    PriorityQueue<Integer> maxH;

    public MedianFinder() {
        maxH = new PriorityQueue<>((a, b) -> b - a);
        minH = new PriorityQueue<>();
    }

    public void addNum(int num) {
        // 1) add to max heap
        maxH.add(num);

        // 2) balancing
        minH.add(maxH.poll());

        // 3) maintain size property
        if (minH.size() > maxH.size()) {
            maxH.add(minH.poll());
        }
    }

    public double findMedian() {
        if (minH.size() == maxH.size()) {
            return (double) (maxH.peek() + minH.peek()) / 2.0;
        } else {
            return (double) maxH.peek();
        }

    }
}
