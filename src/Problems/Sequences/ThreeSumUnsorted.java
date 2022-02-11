package Problems.Sequences;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.ArrayList;

/**
 * Given an integer array nums, return all the triplets [nums[i], nums[j],
 * nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] +
 * nums[k] == 0.
 * 
 * Notice that the solution set must not contain duplicate triplets.
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 */

public class ThreeSumUnsorted {
    Set<List<Integer>> result = new HashSet<>();

    public List<List<Integer>> threeSum(int[] nums) {
        Set<Integer> seen = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (!seen.contains(nums[i])) {
                twoSum(i, nums);
            }
            seen.add(nums[i]);
        }

        return new ArrayList<List<Integer>>(result);
    }

    void twoSum(int i, int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int j = i + 1; j < nums.length; j++) {
            int comp = -nums[i] - nums[j];
            if (set.contains(comp)) {
                List<Integer> triplet = Arrays.asList(nums[i], nums[j], comp);
                Collections.sort(triplet);
                result.add(triplet);
            }

            set.add(nums[j]);
        }
    }

    public void run() {
        int[] nums = { -1, 0, 1, 2, -1, -4 };
        System.out.println(threeSum(nums));
    }
}
