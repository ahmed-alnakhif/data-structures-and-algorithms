package Problems.TwoPointers;

/**
 * Input: nums = [1,1,2]
 * Output: 2, nums = [1,2,_]
 * Explanation: Your function should return k = 2, with the first two elements
 * of nums being 1 and 2 respectively.
 * It does not matter what you leave beyond the returned k (hence they are
 * underscores).
 */

public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0)
            return 0;

        int k = 1;
        int left = 0, right = 1;
        while (right < nums.length) {
            if (nums[left] != nums[right]) {
                left++;
                k++;
                nums[left] = nums[right];
            }
            right++;
        }

        return k;
    }

    public void run() {
        int[] nums = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
        System.out.println(removeDuplicates(nums));
    }
}
