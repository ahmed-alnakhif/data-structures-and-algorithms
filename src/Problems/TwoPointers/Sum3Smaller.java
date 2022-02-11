package Problems.TwoPointers;

import java.util.Arrays;

/**
 * Given an array of n integers nums and an integer target, find the number of
 * index triplets i, j, k with 0 <= i < j < k < n that satisfy the condition
 * nums[i] + nums[j] + nums[k] < target.
 * 
 * Example 1:
 * 
 * Input: nums = [-2,0,1,3], target = 2
 * Output: 2
 * Explanation: Because there are two triplets which sums are less than 2:
 * [-2,0,1]
 * [-2,0,3]
 */

public class Sum3Smaller {

    int result;
    int minDiff = Integer.MAX_VALUE;

    int count = 0;

    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            twoSum(i, nums, target);
        }

        return count;
    }

    private void twoSum(int i, int[] nums, int target) {
        int left = i + 1, right = nums.length - 1;

        while (left < right) {
            int sum = nums[i] + nums[left] + nums[right];

            if (sum < target) {
                count = count + right - left;
                left++;
            } else {
                right--;
            }
        }
    }

    public void run() {
        int[] nums = { -2,0,1,3,-2,1 };
        int target = 2;
        System.out.println(threeSumSmaller(nums, target));
    }
}
