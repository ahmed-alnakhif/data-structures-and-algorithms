package Problems.SlidingWindow;

/**
 * Given an array of integers nums and an integer k, return the number of
 * contiguous subarrays where the product of all the elements in the subarray is
 * strictly less than k.
 * 
 * Example 1:
 * 
 * Input: nums = [10,5,2,6], k = 100
 * Output: 8
 * Explanation: The 8 subarrays that have product less than 100 are:
 * [10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6]
 * Note that [10, 5, 2] is not included as the product of 100 is not strictly
 * less than k.
 */

public class SubarrayProductLessThanK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;

        int count = 0;
        int left = 0, right = 0;
        int product = 1;

        while (right < nums.length) {
            product = product * nums[right];

            while (product >= k) {
                product = product / nums[left];
                left++;
            }

            // calculate the number of items inside the window
            count = count + (right - left + 1);
            right++;
        }

        return count;
    }

    public void run() {
        int[] nums = { 10, 5, 2, 6 };
        int k = 100;
        System.out.println(numSubarrayProductLessThanK(nums, k));
    }
}
