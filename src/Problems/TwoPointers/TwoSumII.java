package Problems.TwoPointers;

/**
 * Given a 1-indexed array of integers numbers that is already sorted in
 * non-decreasing order, find two numbers such that they add up to a specific
 * target number. Let these two numbers be numbers[index1] and numbers[index2]
 * where 1 <= index1 < index2 <= numbers.length.
 * 
 * Return the indices of the two numbers, index1 and index2, added by one as an
 * integer array [index1, index2] of length 2.
 * 
 * The tests are generated such that there is exactly one solution. You may not
 * use the same element twice.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: numbers = [2,7,11,15], target = 9
 * Output: [1,2]
 * Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We
 * return [1, 2].
 */

public class TwoSumII {
    /** We can use HashMap or Pointers. This solution uses pointers for sorted arrays */

    public int[] twoSumII(int[] numbers, int target) {
        int low = 0;
        int high = numbers.length - 1;

        while (low < high) {
            int num = numbers[low] + numbers[high];
            if (num == target) {
                return new int[] { low + 1, high + 1 };
            } else if (num > target) {
                high--;
            } else {
                low++;
            }
        }

        return new int[2];
    }

    public void run() {
        int[] nums = { 2, 7, 11, 15 };
        int target = 9;
        System.out.println(twoSumII(nums, target)[0]);
        System.out.println(twoSumII(nums, target)[1]);
    }
}
