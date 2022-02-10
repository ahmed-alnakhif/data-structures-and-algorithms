package Problems.TwoPointers;

/**
 * Given an integer array nums sorted in non-decreasing order, return an array
 * of the squares of each number sorted in non-decreasing order.
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [-4,-1,0,3,10]
 * Output: [0,1,9,16,100]
 * Explanation: After squaring, the array becomes [16,1,0,9,100].
 * After sorting, it becomes [0,1,9,16,100].
 */

public class SquaresOfSortedArray {
    public int[] sortedSquares(int[] nums) {
        int left = 0, right = nums.length - 1;
        int[] result = new int[nums.length];

        for (int i = nums.length - 1; i >= 0; i--) {
            if (Math.abs(nums[left]) < Math.abs(nums[right])) {
                result[i] = nums[right] * nums[right];
                right--;
            } else {
                result[i] = nums[left] * nums[left];
                left++;
            }
        }

        return result;
    }

    public void run() {
        int[] nums = { -7, -3, 2, 3, 11 };
        System.out.println(sortedSquares(nums));
    }
}
