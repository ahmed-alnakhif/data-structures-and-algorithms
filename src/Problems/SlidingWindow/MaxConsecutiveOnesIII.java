package Problems.SlidingWindow;

/**
 * Given a binary array nums and an integer k, return the maximum number of
 * consecutive 1's in the array if you can flip at most k 0's.
 * 
 * Example 1:
 * 
 * Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
 * Output: 6
 * Explanation: [1,1,1,0,0,1,1,1,1,1,1]
 * Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
 */

public class MaxConsecutiveOnesIII {

    public int longestOnes(int[] nums, int k) {
        int right = 0, left = 0;

        while (right < nums.length) {
            if (nums[right] == 0) {
                k--;
            }

            if (k < 0) {
                if (nums[left] == 0) {
                    k++;
                }
                left++;
            }

            right++;
        }

        return right - left;
    }

    public void run() {
        int[] nums = { 1, 1, 0, 1, 0, 1 };
        int k = 2;
        System.out.println(longestOnes(nums, k));
    }
}
