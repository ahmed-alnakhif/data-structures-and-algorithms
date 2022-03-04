package Problems.Subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given an integer array nums that may contain duplicates, return all possible
 * subsets (the power set).
 * 
 * The solution set must not contain duplicate subsets. Return the solution in
 * any order.
 * 
 * 
 * Input: nums = [1,2,2]
 * Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
 * Example 2:
 * 
 * Input: nums = [0]
 * Output: [[],[0]]
 */

public class SubsetsII {

    //using recursion 
    //idea: use Set for final result so you would override any existing subset
    Set<List<Integer>> result = new HashSet<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtrack(0, new ArrayList<>(), nums);
        return new ArrayList<>(result);
    }

    void backtrack(int index, List<Integer> subset, int[] nums) {
        if (index == nums.length) {
            result.add(new ArrayList<>(subset));
            return;
        }

        backtrack(index + 1, subset, nums);

        subset.add(nums[index]);
        backtrack(index + 1, subset, nums);

        subset.remove(subset.size() - 1);

    }

    // using cascading
    public List<List<Integer>> subsetsWithDup2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        result.add(new ArrayList<>());

        if (nums.length == 0) {
            return result;
        }

        Arrays.sort(nums);

        int resultSize = result.size();
        for (int i = 0; i < nums.length; i++) {
            int startingIndex = (i >= 1 && nums[i] == nums[i - 1]) ? resultSize : 0;
            resultSize = result.size();

            for (int j = startingIndex; j < resultSize; j++) {
                List<Integer> currentSubset = new ArrayList<>(result.get(j));
                currentSubset.add(nums[i]);
                result.add(currentSubset);
            }
        }

        return result;
    }

    public void run() {
        int[] nums = { 1, 2, 2, 3 };
        System.out.println(nums);
    }
}
