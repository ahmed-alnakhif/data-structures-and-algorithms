package Problems.kWayMerge;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * You are given two integer arrays nums1 and nums2 sorted in ascending order
 * and an integer k.
 * 
 * Define a pair (u, v) which consists of one element from the first array and
 * one element from the second array.
 * 
 * Return the k pairs (u1, v1), (u2, v2), ..., (uk, vk) with the smallest sums.
 * 
 * 
 * Example 1:
 * 
 * Input: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
 * Output: [[1,2],[1,4],[1,6]]
 * Explanation: The first 3 pairs are returned from the sequence:
 * [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
 */

public class FindKSmallestPairs {

    public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums1.length * nums2.length * k == 0) {
            return result;
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
                (a, b) -> (nums1[a[0]] + nums2[a[1]]) - (nums1[b[0]] + nums2[b[1]]));

        for (int i = 0; i < Math.min(nums1.length, k); i++) {
            minHeap.add(new int[] { i, 0 });
        }

        while (!minHeap.isEmpty() && k-- > 0) {
            int[] curr = minHeap.poll();

            result.add(new ArrayList<>(List.of(nums1[curr[0]], nums2[curr[1]])));

            if (curr[1] < nums2.length - 1) {
                curr[1]++;
                minHeap.add(curr);
            }
        }

        return result;
    }

    public static List<List<Integer>> kSmallestPairs2(int[] nums1, int[] nums2, int k) {
        if (nums1.length * nums2.length == 0) {
            return new ArrayList<>();
        }

        PriorityQueue<List<Integer>> maxHeap = new PriorityQueue<>(
                (a, b) -> (b.get(0) + b.get(1)) - (a.get(0) + a.get(1)));

        for (int i = 0; i < Math.min(nums1.length, k); i++) {
            for (int j = 0; j < Math.min(nums1.length, k); j++) {
                if (maxHeap.size() < k) {
                    maxHeap.add(new ArrayList<>(List.of(nums1[i], nums2[j])));
                } else {
                    if (nums1[i] + nums2[j] > maxHeap.peek().get(0) + maxHeap.peek().get(1)) {
                        break;
                    } else {
                        maxHeap.poll();
                        maxHeap.add(new ArrayList<>(List.of(nums1[i], nums2[j])));
                    }
                }
            }
        }

        return new ArrayList<>(maxHeap);
    }

    public static void main(String[] args) {
        int[] nums1 = { 1, 7, 11 };
        int[] nums2 = { 2, 4, 6 };
        int k = 3;
        System.out.println(kSmallestPairs(nums1, nums2, k));
    }
}
