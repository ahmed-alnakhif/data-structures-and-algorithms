package Problems.Subsets;

import java.util.ArrayList;
import java.util.LinkedList;
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

    // using backtracking (recursion)
    List<List<Integer>> result = new LinkedList<>();
    LinkedList<Integer> subset = new LinkedList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backtrack(0, nums);
        return result;
    }

    private void backtrack(int index, int[] nums) {
        if (index >= nums.length) {
            result.add(new LinkedList<>(subset));
            return;
        }

        // decision to include nums[index]
        subset.add(nums[index]);
        backtrack(index + 1, nums);
        subset.removeLast();

        // decision not to include nums[index]
        backtrack(index + 1, nums);
    }

    // using cascading
    public List<List<Integer>> subsets2(int[] nums) {
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

    // using bitmask
    public List<List<Integer>> subsets3(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        int n = nums.length;

        for (int i = (int) Math.pow(2, n); i < (int) Math.pow(2, n + 1); ++i) {
            // generate bitmask, from 0..00 to 1..11
            String bitmask = Integer.toBinaryString(i).substring(1);

            // append subset corresponding to that bitmask
            List<Integer> curr = new ArrayList<>();
            for (int j = 0; j < n; ++j) {
                if (bitmask.charAt(j) == '1'){
                    curr.add(nums[j]);
                }
            }
            output.add(curr);
        }
        return output;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };
        System.out.println(nums);
    }
}
