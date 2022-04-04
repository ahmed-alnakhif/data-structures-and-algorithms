package Problems.TwoPointers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Given an array nums of n integers, return an array of all the unique
 * quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:
 * 
 * 0 <= a, b, c, d < n
 * a, b, c, and d are distinct.
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 * You may return the answer in any order.
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [1,0,-1,0,-2,2], target = 0
 * Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 */

public class FourSum {

    List<List<Integer>> result = new LinkedList<>();

    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums.length < 4) return result;

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 3; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                threeSum(i, target, nums);
            }
        }

        return result;
    }

    private void threeSum(int i, int target, int[] nums) {
        for (int j = i + 1; j < nums.length - 2; j++) {
            if (j == i + 1 || nums[j] != nums[j - 1]) {
                twoSum(i, j, target, nums);
            }
        }
    }

    private void twoSum(int i, int j, int target, int[] nums) {
        int left = j + 1, right = nums.length - 1;

        while (left < right) {
            int sum = nums[i] + nums[j] + nums[left] + nums[right];

            if (sum == target) {
                result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                left++;
                while (left < nums.length && nums[left] == nums[left - 1]) {
                    left++;
                }
            } else if (sum > target) {
                right--;
            } else {
                left++;
            }
        }
    }

    public static void main(String[] args) {
        FourSum f = new FourSum();
        System.out.println(f.fourSum(new int[] { 1, 0, -1, 0, -2, 2 }, 0));
    }
}
