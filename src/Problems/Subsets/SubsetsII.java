package Problems.Subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    // using cascading
    public List<List<Integer>> subsetsWithDup(int[] nums) {
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
