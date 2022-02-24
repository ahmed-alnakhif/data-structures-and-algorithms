package Problems.Sequences;

import java.util.LinkedList;
import java.util.List;

/**
 * Given an array nums of n integers where nums[i] is in the range [1, n],
 * return an array of all the integers in the range [1, n] that do not appear in
 * nums.
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [4,3,2,7,8,2,3,1]
 * Output: [5,6]
 * Example 2:
 * 
 * Input: nums = [1,1]
 * Output: [2]
 */

public class FindDuplicateNumbers {

    // T: O(N), S:(1)
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new LinkedList<>();

        for (int num : nums) {
            int index = Math.abs(num);
            if (nums[index - 1] > 0) {
                nums[index - 1] *= -1;
            } else {
                list.add(index);
            }
        }

        return list;
    }

    public void run() {
        int[] nums = { 4,3,2,7,8,2,3,1 };
        System.out.println(findDuplicates(nums));
    }
}
