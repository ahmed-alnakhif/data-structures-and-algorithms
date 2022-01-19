package Problems.StringAndArrayManipulation;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an integer array nums, return an array answer such that answer[i] is
 * equal to the product of all the elements of nums except nums[i].
 * 
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit
 * integer.
 * 
 * You must write an algorithm that runs in O(n) time and without using the
 * division operation.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [1,2,3,4]
 * Output: [24,12,8,6]
 */

public class ProductOfArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int product = 1;
        int zeroCount = 0;

        for (int num : nums) {
            if (num == 0) {
                zeroCount++;
            } else {
                product = product * num;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (zeroCount > 1) {
                nums[i] = 0;
            } else if (nums[i] != 0 && zeroCount == 1) {
                nums[i] = 0;
            } else {
                nums[i] = nums[i] == 0 ? product : product / nums[i];
            }
        }

        return nums;
    }

    public void run() {
        int[] nums = { 1, 2, 3, 4 };

        System.out.println(productExceptSelf(nums));
    }
}
