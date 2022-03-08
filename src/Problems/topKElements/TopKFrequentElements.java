package Problems.topKElements;

import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * Given an integer array nums and an integer k, return the k most frequent
 * elements. You may return the answer in any order.
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 * Example 2:
 * 
 * Input: nums = [1], k = 1
 * Output: [1]
 */

public class TopKFrequentElements {

    public static int[] topKFrequent(int[] nums, int k) {
        if (k == nums.length) {
            return nums;
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue<int[]> minHeap = new PriorityQueue<int[]>((a, b) -> a[1] - b[1]);

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        map.forEach((key, val) -> {
            minHeap.add(new int[] { key, val });
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        });

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = minHeap.poll()[0];
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 1, 1, 2, 2, 3 };
        int k = 3;
        System.out.println(topKFrequent(nums, k));
    }
}
