package Problems.SlidingWindow;

/**
 * You are given an integer array nums consisting of n elements, and an integer
 * k.
 * 
 * Find a contiguous subarray whose length is equal to k that has the maximum
 * average value and return this value. Any answer with a calculation error less
 * than 10-5 will be accepted.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [1,12,-5,-6,50,3], k = 4
 * Output: 12.75000
 * Explanation: Maximum average is (12 - 5 - 6 + 50) / 4 = 51 / 4 = 12.75
 */

public class MaxAverage {

    public double findMaxAverage(int[] nums, int k) {
        int left = 0;
        int right = k;
        double sum = 0.0;

        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        double maxSum = sum;

        while (right < nums.length) {
            sum = sum - nums[left] + nums[right];
            maxSum = Math.max(maxSum, sum);
            right++;
            left++;
        }

        return maxSum / k;
    }

    public void run() {
        int[] nums = { 1, 12, -5, -6, 50, 3 };
        int k = 4;
        System.out.println(findMaxAverage(nums, k));
    }
}
