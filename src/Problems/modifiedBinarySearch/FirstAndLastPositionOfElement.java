package Problems.modifiedBinarySearch;

import java.util.Arrays;

/**
 * Given an array of integers nums sorted in non-decreasing order, find the
 * starting and ending position of a given target value.
 * 
 * If target is not found in the array, return [-1, -1].
 * 
 * You must write an algorithm with O(log n) runtime complexity.
 * 
 * Example 1:
 * 
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 */

public class FirstAndLastPositionOfElement {

    public int[] searchRange(int[] nums, int target) {
        int[] answer = { -1, -1 };

        int pos = Arrays.binarySearch(nums, target);

        if (pos > -1) {
            answer[0] = pos;
            int i = pos;
            while (i < nums.length && nums[i] == target) {
                answer[1] = i;
                i++;
            }

            i = pos;
            while (i >= 0 && nums[i] == target) {
                answer[0] = i;
                i--;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        FirstAndLastPositionOfElement f = new FirstAndLastPositionOfElement();
        int[] nums = { 5, 7, 7, 8, 8, 10 };
        int target = 8;
        System.out.println(f.searchRange(nums, target));
    }
}
