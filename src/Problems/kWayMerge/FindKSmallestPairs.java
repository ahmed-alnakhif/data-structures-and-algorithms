package Problems.kWayMerge;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

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

        while (k-- > 0 && !minHeap.isEmpty()) {
            int[] curr = minHeap.poll();

            result.add(new ArrayList<>(List.of(nums1[curr[0]], nums2[curr[1]])));

            if (curr[1] < nums2.length - 1) {
                curr[1] += 1;
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
