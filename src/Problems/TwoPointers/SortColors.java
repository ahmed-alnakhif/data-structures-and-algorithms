package Problems.TwoPointers;

/**
 * Given an array nums with n objects colored red, white, or blue, sort them
 * in-place so that objects of the same color are adjacent, with the colors in
 * the order red, white, and blue.
 * 
 * We will use the integers 0, 1, and 2 to represent the color red, white, and
 * blue, respectively.
 * 
 * You must solve this problem without using the library's sort function.
 * 
 * Example 1:
 * 
 * Input: nums = [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 */

public class SortColors {

    public void sortColors(int[] nums) {
        int left = 0, right = nums.length - 1;
        int i = 0;
        while (i <= right) {
            if (nums[i] == 0) {
                swap(i++, left++, nums);
            } else if (nums[i] == 1) {
                i++;
            } else if (nums[i] == 2) {
                swap(i, right--, nums);
            }
        }
    }

    private void swap(int i, int j, int[] nums) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

   public static void main(String[] args) {
        SortColors s = new SortColors();    
        s.sortColors(new int[]{ 2, 0, 2, 1, 1, 0 });
    }
}
