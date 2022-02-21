package Problems.Subsets;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer array nums of unique elements, return all possible subsets
 * (the power set).
 * 
 * The solution set must not contain duplicate subsets. Return the solution in
 * any order.
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [1,2,3]
 * Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 */

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        result.add(new ArrayList<>());

        if (nums.length == 0) {
            return result;
        }

        for (int num : nums) {
            int size = result.size();
            for (int i = 0; i < size; i++) {
                List<Integer> set = new ArrayList<>(result.get(i));
                set.add(num);
                result.add(set);
            }
        }
        return result;
    }

    public void run() {
        int[] nums = { 1, 2, 3 };
        System.out.println(nums);
    }
}
