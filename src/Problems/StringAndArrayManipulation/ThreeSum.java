package Problems.StringAndArrayManipulation;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

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
 * Input: nums = [-4, -1, -1, 0, 1, 2]
 * Output: [[-1,-1,2],[-1,0,1]]
 */

public class ThreeSum {
    List<List<Integer>> result = new LinkedList<>();

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                twoSumWithPointers(i, nums);
            }
        }

        return result;
    }

    void twoSumWithPointers(int i, int[] nums) {
        int l = i + 1;
        int r = nums.length - 1;

        while (l < r) {
            int sum = nums[i] + nums[l] + nums[r];

            if (sum > 0) {
                r--;
            } else if (sum < 0) {
                l++;
            } else {
                result.add(List.of(nums[i], nums[l], nums[r]));
                l++;
                while (l < r && nums[l] == nums[l - 1]) {
                    l++;
                }
            }
        }

    }

    void twoSumWithHashSet(int i, int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int j = i + 1; j < nums.length; j++) {
            int comp = -nums[i] - nums[j];
            if (set.contains(comp)) {
                result.add(List.of(nums[i], nums[j], comp));
                while (j + 1 < nums.length && nums[j] == nums[j + 1]) {
                    j++;
                }
            }

            set.add(nums[j]);
        }
    }

    void twoSumWithBinarySearch(int i, int[] nums) {
        for (int j = i + 1; j < nums.length; j++) {
            int comp = -nums[i] - nums[j];
            int[] slicedArray = Arrays.copyOfRange(nums, j + 1, nums.length);

            int kIndex = Arrays.binarySearch(slicedArray, comp);
            if (kIndex > -1) {
                result.add(List.of(nums[i], nums[j], comp));
                while (j + 1 < nums.length && nums[j] == nums[j + 1]) {
                    j++;
                }
            }
        }
    }

    public void run() {
        int[] nums = { -1, 0, 1, 2, -1, -4 };
        System.out.println(threeSum(nums));
    }
}
