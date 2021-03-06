package Problems.twoHeaps;

import java.util.Collections;
import java.util.PriorityQueue;

public class SlidingWindowMedianV2 {
    PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

    public double[] medianSlidingWindow(int[] nums, int k) {
        int resultSize = nums.length - k + 1;
        double[] result = new double[resultSize];

        for (int i = 0; i <= nums.length; i++) {
            if (i >= k) {
                result[i - k] = getMedian();
                remove(nums[i - k]);
            }

            if (i < nums.length) {
                add(nums[i]);
            }
        }

        return result;
    }

    private void add(int num) {
        if (num < getMedian()) {
            maxHeap.add(num);
        } else {
            minHeap.add(num);
        }

        if (maxHeap.size() > minHeap.size()) {
            minHeap.add(maxHeap.poll());
        }
        if (minHeap.size() - maxHeap.size() > 1) {
            maxHeap.add(minHeap.poll());
        }
    }

    private void remove(int num) {
        if (num < getMedian()) {
            maxHeap.remove(num);
        } else {
            minHeap.remove(num);
        }

        if (maxHeap.size() > minHeap.size()) {
            minHeap.add(maxHeap.poll());
        }
        if (minHeap.size() - maxHeap.size() > 1) {
            maxHeap.add(minHeap.poll());
        }
    }

    private double getMedian() {
        if (maxHeap.isEmpty() && minHeap.isEmpty()) {
            return 0;
        }

        if (maxHeap.size() == minHeap.size()) {
            return ((double) maxHeap.peek() + (double) minHeap.peek()) / 2.0;
        } else {
            return (double) minHeap.peek();
        }
    }
}
