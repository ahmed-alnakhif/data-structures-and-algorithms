package Problems.topKElements;

import java.util.PriorityQueue;

/**
 * Design a class to find the kth largest element in a stream. Note that it is
 * the kth largest element in the sorted order, not the kth distinct element.
 * 
 * Implement KthLargest class:
 * 
 * KthLargest(int k, int[] nums) Initializes the object with the integer k and
 * the stream of integers nums.
 * int add(int val) Appends the integer val to the stream and returns the
 * element representing the kth largest element in the stream.
 * 
 * 
 * Example 1:
 * 
 * Input
 * ["KthLargest", "add", "add", "add", "add", "add"]
 * [[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]
 * Output
 * [null, 4, 5, 5, 8, 8]
 * 
 * Explanation
 * KthLargest kthLargest = new KthLargest(3, [4, 5, 8, 2]);
 * kthLargest.add(3); // return 4
 * kthLargest.add(5); // return 5
 * kthLargest.add(10); // return 5
 * kthLargest.add(9); // return 8
 * kthLargest.add(4); // return 8
 */

public class KthLargestElementInStream {
    private static PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    private static int K;

    public static void KthLargest(int k, int[] nums) {
        K = k;
        for (int num : nums) {
            minHeap.add(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
    }

    public int add(int val) {
        minHeap.add(val);
        if (minHeap.size() > K) {
            minHeap.poll();
        }

        return minHeap.peek();
    }

    public static void main(String[] args) {

    }
}
