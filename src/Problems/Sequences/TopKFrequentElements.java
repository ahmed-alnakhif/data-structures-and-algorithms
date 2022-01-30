package Problems.Sequences;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Given an integer array nums and an integer k, return the k most frequent
 * elements. You may return the answer in any order.
 * 
 * Example 1:
 * 
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 */

public class TopKFrequentElements {

    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue<int[]> maxPQ = new PriorityQueue<int[]>((a, b) -> b[1] - a[1]);

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            maxPQ.add(new int[] { e.getKey(), e.getValue() });
        }

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = maxPQ.poll()[0];
        }

        return result;
    }

    public void run() {
        int[] nums = { 4, 1, -1, 2, -1, 2, 3 };
        int k = 2;
        System.out.println(topKFrequent(nums, k));
    }
}
