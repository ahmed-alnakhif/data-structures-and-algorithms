package Problems.Sequences;

/**
 * Suppose an array of length n sorted in ascending order is rotated between 1
 * and n times. 
 * 
 * For example, the array nums = [0,1,2,4,5,6,7] might become:
 * [4,5,6,7,0,1,2] if it was rotated 4 times.
 * [0,1,2,4,5,6,7] if it was rotated 7 times.
 * 
 * Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results
 * in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].
 * 
 * Given the sorted rotated array nums of unique elements, return the minimum element of this array.
 * 
 * Example 1:
 * 
 * Input: nums = [3,4,5,1,2]
 * Output: 1
 * Explanation: The original array was [1,2,3,4,5] rotated 3 times.
 */

public class MinimumInRotatedSortedArray {

    int getRotateIndex(int[] nums) {
        int rotateIndex = -1;
        int l = (nums.length - 1) / 2;
        int r = l;

        while (l >= 0 && r <= nums.length - 1) {
            if (r + 1 <= nums.length - 1 && nums[r] > nums[r + 1]) {
                rotateIndex = r + 1;
                break;
            }
            r++;

            if (l - 1 >= 0 && nums[l] < nums[l - 1]) {
                rotateIndex = l;
                break;
            }
            l--;
        }
        return rotateIndex;
    }

    public int findMin1(int[] nums) {
        int index = getRotateIndex(nums);
        return index >= 0 ? nums[index] : nums[0];
    }

    public int findMin2(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = (right + left) / 2;
            // search left side
            if (nums[mid] < nums[right]) {
                right = mid;
            } else { // search right side
                left = mid + 1;
            }
        }

        return nums[left];
    }

    public void run() {
        int[] nums = { 3, 4, 5, 1, 2 };
        System.out.println(findMin2(nums));
    }
}
