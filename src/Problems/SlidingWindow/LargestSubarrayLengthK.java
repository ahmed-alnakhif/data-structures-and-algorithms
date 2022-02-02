package Problems.SlidingWindow;

/**
 * An array A is larger than some array B if for the first index i where A[i] !=
 * B[i], A[i] > B[i].
 * 
 * For example, consider 0-indexing:
 * 
 * [1,3,2,4] > [1,2,2,4], since at index 1, 3 > 2.
 * [1,4,4,4] < [2,1,1,1], since at index 0, 1 < 2.
 * A subarray is a contiguous subsequence of the array.
 * 
 * Given an integer array nums of distinct integers, return the largest subarray
 * of nums of length k.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [1,4,5,2,3], k = 3
 * Output: [5,2,3]
 * Explanation: The subarrays of size 3 are: [1,4,5], [4,5,2], and [5,2,3].
 * Of these, [5,2,3] is the largest.
 */

public class LargestSubarrayLengthK {

    public int[] largestSubarray(int[] nums, int k) {
        int start = 0;
        for (int i = 1; i <= nums.length - k; i++) {
            if (nums[i] > nums[start]) {
                start = i;
            }
        }

        int[] resultArr = new int[k];
        for (int i = 0; i < k; i++) {
            resultArr[i] = nums[start++];
        }

        return resultArr;
    }

    public void run() {
        int[] nums = { 2, 1, 5, 1, 3, 2 };
        int k = 3;
        System.out.println(largestSubarray(nums, k));
    }
}
