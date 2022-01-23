package Problems.StringAndArrayManipulation;

/**
 * Given an integer array nums, find a contiguous non-empty subarray within the
 * array that has the largest product, and return the product.
 * 
 * The test cases are generated so that the answer will fit in a 32-bit integer.
 * 
 * A subarray is a contiguous subsequence of the array.
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [2,3,-2,4]
 * Output: 6
 * Explanation: [2,3] has the largest product 6.
 */

public class MaxProductSubarray {

    public int maxProductSubarrayApproach1(int[] nums) {
        int max = Integer.MIN_VALUE;

        int product = 1;
        for (int num : nums) {
            product *= num;
            max = Math.max(product, max);
            if (product == 0)
                product = 1;

        }

        product = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            product *= nums[i];
            max = Math.max(product, max);
            if (product == 0)
                product = 1;
        }

        return max;
    }

    public int maxProductSubarrayApproach2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int max = nums[0];
        int maxSoFar = nums[0];
        int minSoFar = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int curr = nums[i];

            int tmpMax = Math.max(curr, Math.max(maxSoFar * curr, minSoFar * curr));
            minSoFar = Math.min(curr, Math.min(maxSoFar * curr, minSoFar * curr));
            maxSoFar = tmpMax;
            max = Math.max(max, maxSoFar);
        }

        return max;
    }

    public void run() {
        int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        System.out.println(maxProductSubarrayApproach2(nums));
    }
}
