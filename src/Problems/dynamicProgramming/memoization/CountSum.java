package Problems.dynamicProgramming.memoization;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a set of positive numbers, find the total number of subsets whose sum
 * is equal to a given number ‘S’.
 */

public class CountSum {
    private Map<String, Integer> cache;

    public int countSubsets(int[] nums, int targetSum) {
        cache = new HashMap<>();
        return countSubsetsRecursive(nums, targetSum, 0);
    }

    private int countSubsetsRecursive(int[] nums, int targetSum, int index) {
        if (targetSum == 0) {
            return 1;
        }

        if (targetSum < 0 || index >= nums.length) {
            return 0;
        }

        String key = targetSum + "," + nums[index];
        if (cache.containsKey(key)) {
            return cache.get(key);
        }

        int count = 0;

        // decision to include the number
        count += countSubsetsRecursive(nums, targetSum - nums[index], index + 1);

        // decision not to include the number
        count += countSubsetsRecursive(nums, targetSum, index + 1);

        cache.put(key, count);
        return count;
    }

    public static void main(String[] args) {
        CountSum c = new CountSum();
        System.out.println(c.countSubsets(new int[] { 1, 1, 2, 3 }, 4));
        System.out.println(c.countSubsets(new int[] { 1, 2, 7, 1, 5 }, 9));
    }
}
