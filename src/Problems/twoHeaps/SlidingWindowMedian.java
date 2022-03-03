package Problems.twoHeaps;

import java.util.Comparator;
import java.util.TreeSet;

public class SlidingWindowMedian {

    TreeSet<Integer> minHeap;
    TreeSet<Integer> maxHeap;

    //T: O(N*log(n)), S: O(N)
    public double[] medianSlidingWindow(int[] nums, int k) {
        Comparator<Integer> comparator = (a, b) -> nums[a] != nums[b]
                ? Integer.compare(nums[a], nums[b])
                : a - b;
        minHeap = new TreeSet<>(comparator);
        maxHeap = new TreeSet<>(comparator.reversed());

        double[] result = new double[nums.length - k + 1];

        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            // if window size is greater than k
            if (i >= k) {
                minHeap.remove(i - k);
                maxHeap.remove(i - k);
            }

            // add current num
            add(i);

            // we have full window size
            if (i >= k - 1) {
                result[index++] = getMedian(nums, k);
            }
        }

        return result;
    }

    private void add(int i) {
        // add
        minHeap.add(i);

        // balance
        maxHeap.add(minHeap.pollFirst());
        if (maxHeap.size() > minHeap.size()) {
            minHeap.add(maxHeap.pollFirst());
        }

    }

    private double getMedian(int[] nums, int k) {
        if (k % 2 == 0) { //even
            return ((double) nums[minHeap.first()] + (double) nums[maxHeap.first()]) / 2;
        } else { // odd
            return (double) nums[minHeap.first()];
        }
    }
}
