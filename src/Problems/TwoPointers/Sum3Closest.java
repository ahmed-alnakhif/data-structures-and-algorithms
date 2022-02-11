package Problems.TwoPointers;

import java.util.Arrays;

/**
 * Given an integer array nums of length n and an integer target, find three
 * integers in nums such that the sum is closest to target.
 * 
 * Return the sum of the three integers.
 * 
 * You may assume that each input would have exactly one solution.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [-1,2,1,-4], target = 1
 * Output: 2
 * Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */

public class Sum3Closest {

    int result;
    int minDiff = Integer.MAX_VALUE;

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                twoSum(i, nums, target);
            }
        }

        return result;
    }

    private void twoSum(int i, int[] nums, int target) {
        int left = i + 1, right = nums.length - 1;

        while (left < right) {
            int sum = nums[i] + nums[left] + nums[right];

            if (Math.abs(sum - target) < Math.abs(minDiff)) {
                minDiff = target - sum;
            }

            if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        result = target - minDiff;
    }

    public void run() {
        int[] nums = { -1, 2, 1, -4 };
        int target = 1;
        System.out.println(threeSumClosest(nums, target));
    }
}
