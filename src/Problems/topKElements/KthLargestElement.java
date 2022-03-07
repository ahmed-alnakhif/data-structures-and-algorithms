package Problems.topKElements;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KthLargestElement {

    // T: O(N*log(N)), S: O(1)
    public static int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    // T: O(N*log(k)), S: O(k)
    public static int findKthLargest2(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // keep k largest elements in the heap
        for (int n : nums) {
            minHeap.add(n);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        return minHeap.peek();
    }

    public static void main(String[] args) {
        System.out.println(findKthLargest(new int[] { 3, 2, 1, 5, 6, 4 }, 2));
    }
}
