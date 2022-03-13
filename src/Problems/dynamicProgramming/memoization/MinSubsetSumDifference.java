package Problems.dynamicProgramming.memoization;

import java.util.Map;
import java.util.HashMap;

/**
 * Given a set of positive numbers, partition the set into two subsets with a
 * minimum difference between their subset sums.
 */

public class MinSubsetSumDifference {

    Map<String, Integer> cache = new HashMap<>();

    public int minimumDifference(int[] nums) {
        return minimumDifferenceRecursive(nums, 0, 0, 0);
    }

    private int minimumDifferenceRecursive(int[] nums, int sum1, int sum2, int index) {
        // base case:
        if (index >= nums.length) {
            return Math.abs(sum1 - sum2);
        }

        String key = index + "," + sum1 + "," + sum2;

        if (cache.containsKey(key)) {
            return cache.get(key);
        }

        // recursive case:
        int includeNumberToFirstSet = minimumDifferenceRecursive(nums, sum1, sum2 + nums[index], index + 1);
        int includeNumberToSecondSet = minimumDifferenceRecursive(nums, sum1 + nums[index], sum2, index + 1);

        cache.put(key, Math.min(includeNumberToFirstSet, includeNumberToSecondSet));
        return cache.get(key);
    }

    public static void main(String[] args) {
        MinSubsetSumDifference m = new MinSubsetSumDifference();
        System.out.println(m.minimumDifference(new int[] { 3, 9, 7, 3 }));
    }
}
