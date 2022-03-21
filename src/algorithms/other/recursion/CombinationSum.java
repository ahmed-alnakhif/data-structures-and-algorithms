package algorithms.other.recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Given an array of distinct integers candidates and a target integer target,
 * return a list of all unique combinations of candidates where the chosen
 * numbers sum to target. You may return the combinations in any order.
 * 
 * The same number may be chosen from candidates an unlimited number of times.
 * Two combinations are unique if the frequency of at least one of the chosen
 * numbers is different.
 * 
 * It is guaranteed that the number of unique combinations that sum up to target
 * is less than 150 combinations for the given input.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: candidates = [2,3,6,7], target = 7
 * Output: [[2,2,3],[7]]
 * Explanation:
 * 2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple
 * times.
 * 7 is a candidate, and 7 = 7.
 * These are the only two combinations.
 */

public class CombinationSum {
    List<List<Integer>> result;
    LinkedList<Integer> comb;
    Map<String, List<Integer>> cache;

    // can be a bit optimized if we sort the numbers
    // and exit if curr number > target
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        result = new ArrayList<>();
        comb = new LinkedList<>();
        cache = new HashMap<>();

        backtrack(nums, target, 0);

        return result;
    }

    private void backtrack(int[] nums, int targetSum, int index) {
        if (targetSum < 0 || index >= nums.length) {
            return;
        }

        if (targetSum == 0) {
            result.add(new ArrayList<>(comb));
            return;
        }

        for (int i = index; i < nums.length; i++) {
            comb.add(nums[i]);
            backtrack(nums, targetSum - nums[i], i);
            comb.removeLast();
        }
    }

    public List<List<Integer>> combinationSumDP(int[] nums, int target) {
        List<List<Integer>>[] dp = new List[target + 1];

        for (int i = 0; i < dp.length; i++) {
            dp[i] = new ArrayList<>();
        }

        dp[0].add(new ArrayList<>());

        for (int num : nums) {
            for (int i = num; i < dp.length; i++) {
                for (List<Integer> comb : dp[i - num]) {
                    List<Integer> newComb = new ArrayList<>(comb);
                    newComb.add(num);
                    dp[i].add(newComb);
                }
            }
        }

        return dp[target];
    }

    public static void main(String[] args) {
        CombinationSum cSum = new CombinationSum();
        System.out.println(cSum.combinationSum(new int[] { 2, 3, 6, 7 }, 7));
    }
}
