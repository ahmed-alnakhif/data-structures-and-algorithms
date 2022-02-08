package Problems.SlidingWindow;

/**
 * Given an array of positive numbers and a positive number ‘k,’ find the
 * maximum sum of any contiguous subarray of size ‘k’.
 * 
 * Example 1:
 * 
 * Input: [2, 1, 5, 1, 3, 2], k=3
 * Output: 9
 * Explanation: Subarray with maximum sum is [5, 1, 3].
 */

public class MaximumSumSubarrayOfSizeK {

    public int maximumSumSubarrayOfSizeK(int[] arr, int k) {
        int left = 0, right = k - 1;
        int max = 0, sum = 0;
        for (int i = 0; i < k; i++) {
            sum = sum + arr[i];
        }

        while (left < right) {
            right++;
            left++;

            if (right == arr.length)
                break;

            sum = sum - arr[left - 1] + arr[right];
            max = Math.max(max, sum);
        }

        return max;
    }

    public void run() {
        int[] nums = { 2, 1, 5, 1, 3, 2 };
        int k = 3;
        System.out.println(maximumSumSubarrayOfSizeK(nums, k));
    }
}
