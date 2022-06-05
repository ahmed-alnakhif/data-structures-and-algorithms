package Problems.SlidingWindow;

/**
 * Given a binary array nums, return the maximum number of consecutive 1's in
 * the array if you can flip at most one 0.
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
            if (nums[right++] == 0) {
                allowedZeros--;
            }

            if (allowedZeros < 0) {
                if (nums[left++] == 0) {
                    allowedZeros++;
                }
            }
        }

        return right - left;
    }

    public int findMaxConsecutiveOnes2(int[] nums) {
        int left = 0, right = 0;
        int maxLength = 0, onesCount = 0;
        int k = 1;

        while (right < nums.length) {
            if (nums[right] == 1) {
                onesCount++;
            }

            while ((right - left + 1) - onesCount > k) {
                if (nums[left++] == 1) {
                    onesCount--;
                }
            }

            maxLength = Math.max(maxLength, (right - left + 1));
            right++;
        }

        return maxLength;
    }

    public static void main(String[] args) {
        MaxConsecutiveOnesII maxOnes = new MaxConsecutiveOnesII();
        int[] nums = { 1, 0, 1, 1, 0 };
        System.out.println(maxOnes.findMaxConsecutiveOnes(nums));
    }
}
