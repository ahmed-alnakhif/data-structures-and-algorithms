package Problems.kWayMerge;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class FindKLargestPairs {

    public static List<List<Integer>> kLargestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<List<Integer>> minHeap = new PriorityQueue<>(
                (a, b) -> (a.get(0) + a.get(1)) - (b.get(0) + b.get(1)));

        for (int i = 0; i < Math.min(nums1.length, k); i++) {
            for (int j = 0; j < Math.min(nums1.length, k); j++) {
                if (minHeap.size() < k) {
                    minHeap.add(new ArrayList<>(List.of(nums1[i], nums2[j])));
                } else {
                    if (nums1[i] + nums2[j] < minHeap.peek().get(0) + minHeap.peek().get(1)) {
                        break;
                    } else {
                        minHeap.poll();
                        minHeap.add(new ArrayList<>(List.of(nums1[i], nums2[j])));
                    }
                }
            }
        }

        return new ArrayList<>(minHeap);
    }

    public static void main(String[] args) {
        int[] nums1 = { 9, 8, 2 };
        int[] nums2 = { 6, 3, 1 };
        int k = 3;
        System.out.println(kLargestPairs(nums1, nums2, k));
    }
}
