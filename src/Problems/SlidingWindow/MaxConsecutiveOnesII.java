package Problems.SlidingWindow;

/**
 * Given a binary array nums, return the maximum number of consecutive 1's in
 * the array if you can flip at most one 0.
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [1,0,1,1,0]
 * Output: 4
 * Explanation: Flip the first zero will get the maximum number of consecutive
 * 1s. After flipping, the maximum number of consecutive 1s is 4.
 */

public class MaxConsecutiveOnesII {

    public int findMaxConsecutiveOnes(int[] nums) {
        int allowedZeros = 1;
        int right = 0, left = 0;

        while (right < nums.length) {
            if (nums[right] == 0) {
                allowedZeros--;
            }

            if (allowedZeros < 0) {
                if (nums[left] == 0) {
                    allowedZeros++;
                }
                left++;
            }

            right++;
        }

        return right - left;
    }

    public void run() {
        int[] nums = { 1, 1, 0, 1, 1, 1 };
        System.out.println(findMaxConsecutiveOnes(nums));
    }
}
