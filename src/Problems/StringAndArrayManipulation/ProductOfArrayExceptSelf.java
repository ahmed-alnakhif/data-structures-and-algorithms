package Problems.StringAndArrayManipulation;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings s and t, return true if t is an anagram of s, and false
 * otherwise.
 * 
 * An Anagram is a word or phrase formed by rearranging the letters of a
 * different word or phrase, typically using all the original letters exactly
 * once.
 * 
 * 
 * Example 1:
 * 
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 * Example 2:
 * 
 * Input: s = "rat", t = "car"
 * Output: false
 * 
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
