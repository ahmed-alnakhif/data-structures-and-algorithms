package Problems.Sequences;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an array nums containing n distinct numbers in the range [0, n], return
 * the only number in the range that is missing from the array.
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [3,0,1]
 * Output: 2
 * Explanation: n = 3 since there are 3 numbers, so all numbers are in the range
 * [0,3]. 2 is the missing number in the range since it does not appear in nums.
 */

public class FindMissingNumber {

    // using Gauss' Formula
    public int missingNumber(int[] nums) {
        int expectedSum = nums.length * (nums.length + 1) / 2;

        // instead of using the formula, you can get the expected sum from i -> n

        int actualSum = 0;
        for (int num : nums) {
            actualSum += num;
        }

        return expectedSum - actualSum;
    }

    // using Set
    public int missingNumber2(int[] nums) {
        Set<Integer> numSet = new HashSet<Integer>();
        for (int num : nums) {
            numSet.add(num);
        }

        int expectedNumCount = nums.length + 1;
        for (int num = 0; num < expectedNumCount; num++) {
            if (!numSet.contains(num)) {
                return num;
            }
        }

        return -1;
    }

    //using Bit manipulation 
    public int missingNumber3(int[] nums) {
        int missing = nums.length;
        for (int i = 0; i < nums.length; i++) {
            missing = missing ^ i ^ nums[i];
        }
        return missing;
    }

   public static void main(String[] args) {
        FindMissingNumber f = new FindMissingNumber();
        int[] num = { 7, 1, 5, 3, 6, 4 };
        System.out.println(f.missingNumber(num));
    }
}
