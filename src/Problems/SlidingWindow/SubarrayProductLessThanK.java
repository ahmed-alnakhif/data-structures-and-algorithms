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
        // the product should be less than k,
        // and since nums are positive k should be greater than 1
        if (k <= 1) return 0;

        int result = 0;
        int product = 1, left = 0, right = 0;

        while (right < nums.length) {
            product *= nums[right++];
            while (product >= k) {
                product /= nums[left++];
            }
            result += right - left;
        }

        return result;
    }

    public static void main(String[] args) {
        SubarrayProductLessThanK s = new SubarrayProductLessThanK();                 
        System.out.println(s.numSubarrayProductLessThanK(new int[] { 10, 5, 2, 6 }, 100));
    }
}
