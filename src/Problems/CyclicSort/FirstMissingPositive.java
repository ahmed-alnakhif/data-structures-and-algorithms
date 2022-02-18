package Problems.CyclicSort;

import java.util.Arrays;

/**
 * Given an unsorted integer array nums, return the smallest missing positive
 * integer.
 * 
 * You must implement an algorithm that runs in O(n) time and uses constant
 * extra space.
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [1,2,0]
 * Output: 3
 * Example 2:
 * 
 * Input: nums = [3,4,-1,1]
 * Output: 2
 */

public class FirstMissingPositive {

    public int firstMissingPositive(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int index = nums[i] - 1;
            if (nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[index]) {
                swap(nums, i, index);
            } else {
                i++;
            }
        }

        for (i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        return nums.length + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public void run() {
        int[] arr = { 7, 8, 9, 11, 12 };
        firstMissingPositive(arr);
        System.out.println(Arrays.toString(arr));

    }
}
