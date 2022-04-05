package Problems.fastAndSlowPointers;

/**
 * Given an array of integers nums containing n + 1 integers where each integer
 * is in the range [1, n] inclusive.
 * 
 * There is only one repeated number in nums, return this repeated number.
 * 
 * You must solve the problem without modifying the array nums and uses only
 * constant extra space.
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [1,3,4,2,2]
 * Output: 2
 */

public class FindDuplicateNumber {

    // Floyd's Algorithm => T: O(N), S: O(1), no modification
    public int findDuplicate(int[] nums) {
        int slow = nums[0], fast = nums[0];

        // find the intersection point of the two pointers
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (fast != slow);

        // find the entrance to the cycle
        slow = nums[0]; // reset to the beginning
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return fast;
    }

    // T: O(N), S: O(1), array modified
    public int findDuplicate2(int[] nums) {
        while (nums[0] != nums[nums[0]]) {
            int next = nums[nums[0]];
            nums[nums[0]] = nums[0];
            nums[0] = next;
        }
        return nums[0];
    }

    public static void main(String[] args) {
        FindDuplicateNumber f = new FindDuplicateNumber();
        System.out.println(f.findDuplicate(new int[] { 1, 3, 4, 2, 2 }));
    }
}