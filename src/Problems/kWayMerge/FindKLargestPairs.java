package Problems.kWayMerge;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class FindKLargestPairs {

    public static List<int[]> kLargestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> result = new ArrayList<>();
        if (nums1.length * nums2.length * k == 0) {
            return result;
        }
    
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
                (a, b) -> (nums1[b[0]] + nums2[b[1]]) - (nums1[a[0]] + nums2[a[1]]));
    
        for (int i = 0; i < Math.min(nums1.length, k); i++) {
            maxHeap.add(new int[] { i, 0 });
        }
    
        while (!maxHeap.isEmpty() && k-- > 0) {
            int[] curr = maxHeap.poll();
    
            result.add(new int[] { nums1[curr[0]], nums2[curr[1]]});
    
            if (curr[1] < nums2.length - 1) {
                curr[1]++;
                maxHeap.add(curr);
            }
        }
    
        return result;
      }

    public static void main(String[] args) {
        int[] nums1 = { 9, 8, 2 };
        int[] nums2 = { 6, 3, 1 };
        int k = 3;
        System.out.println(kLargestPairs(nums1, nums2, k)); //[9, 6] [8, 6] [9, 3] 
    }
}
