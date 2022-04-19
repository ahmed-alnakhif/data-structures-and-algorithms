package Problems.topKElements;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Given an array of integers arr and an integer k. Find the least number of
 * unique integers after removing exactly k elements.
 * 
 * Example 1:
 * 
 * Input: arr = [5,5,4], k = 1
 * Output: 1
 * Explanation: Remove the single 4, only 5 is left.
 * Example 2:
 * Input: arr = [4,3,1,1,3,3,2], k = 3
 * Output: 2
 * Explanation: Remove 4, 2 and either one of the two 1s or three 3s. 1 and 3
 * will be left.
 */

public class LeastNumberOfUniqueIntegers {

    public static int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.addAll(map.values());

        while (!minHeap.isEmpty() && k > 0) {
            k -= minHeap.poll();
        }

        return k < 0 ? minHeap.size() + 1 : minHeap.size();
    }

    public static void main(String[] args) {
        System.out.println(findLeastNumOfUniqueInts(new int[] { 4, 3, 1, 1, 3, 3, 2 }, 3));
    }
}
