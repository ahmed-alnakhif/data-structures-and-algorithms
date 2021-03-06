package Problems.TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
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
    List<List<Integer>> result = new ArrayList<>();

    public boolean isThreeSum(int[] nums){
        for (int i = 0; i < nums.length - 2; i++) {
            if(isTwoSum(nums, i)){
                return true;
            }
        }
        return false;
    }

    public boolean isTwoSum(int[] nums, int index){
        HashSet<Integer> set = new HashSet<>();
        for (int i = index + 1; i < nums.length; i++) {
            int comp = - nums[index] - nums[i];
            if(set.contains(comp)){
                return true;
            }
            set.add(nums[i]);
        }
        return false;
    }

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
        int left = i + 1, right = nums.length - 1;
        while (left < right) {
            int sum = nums[i] + nums[left] + nums[right];

            if (sum == 0) {
                result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                left++;
                while (left < right && nums[left] == nums[left - 1]) {
                    left++;
                }

            } else if (sum < 0) {
                left++;
            } else {
                right--;
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
    
    List<List<Integer>> result2 = new ArrayList<>();
    Set<String> seen = new HashSet<>();
    
    public List<List<Integer>> threeSum2(int[] nums) {
        Arrays.sort(nums);
        for(int i = 0; i<nums.length-2; i++){
            twoSumWithHashSet2(i, nums);
        }
        return result;
    }
    
    void twoSumWithHashSet2(int i, int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int j = i + 1; j < nums.length; j++) {
            int comp = -nums[i] - nums[j];
            String sum = nums[i]+","+nums[j]+","+comp;
            
            if (set.contains(comp) && !seen.contains(sum)) {
                result.add(List.of(nums[i], nums[j], comp));
                seen.add(sum);
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

   public static void main(String[] args) {
       ThreeSum t = new ThreeSum();
        int[] nums = { -1, 0, 1, 2, -1, -4 };
        System.out.println(t.isThreeSum(nums));
    }
}
