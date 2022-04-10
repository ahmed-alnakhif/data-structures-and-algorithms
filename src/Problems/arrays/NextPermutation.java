package Problems.arrays;

import java.util.Arrays;

/**
 * A permutation of an array of integers is an arrangement of its members into a
 * sequence or linear order.
 * 
 * For example, for arr = [1,2,3], the following are considered permutations of
 * arr: [1,2,3], [1,3,2], [3,1,2], [2,3,1].
 * 
 * Given an array of integers nums, find the next permutation of nums.
 * 
 * Example 1:
 * 
 * Input: nums = [1,2,3]
 * Output: [1,3,2]
 * Example 2:
 * 
 * Input: nums = [3,2,1]
 * Output: [1,2,3]
 * Example 3:
 * 
 * Input: nums = [1,1,5]
 * Output: [1,5,1]
 */

public class NextPermutation {

    public int[] nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        if (i >= 0) {
            int j = nums.length - 1;
            while (nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }

        reverse(nums, i + 1);
        
        return nums;
    }

    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i++, j--);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        NextPermutation np = new NextPermutation();
        int[] nums = { 1, 2, 3 };
        np.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}
