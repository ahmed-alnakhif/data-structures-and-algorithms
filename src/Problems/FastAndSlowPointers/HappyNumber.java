package Problems.FastAndSlowPointers;

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
 * 
 * Example 1:
 * 
 * Input: nums = [1,3,4,2,2]
 * Output: 2
 */

public class HappyNumber {

    // Floyd's Algorithm => T: O(N), S: O(1), no modification
    public boolean isHappy(int n) {
        int slow = n;
        int fast = getNextDigit(n);

        while (slow != fast && fast != 1) {
            slow = getNextDigit(slow);
            fast = getNextDigit(getNextDigit(fast));
        }

        return fast == 1;
    }

    private int getNextDigit(int n) {
        int totalSum = 0;
        while (n > 0) {
            int digit = n % 10;
            n = n / 10;
            totalSum = totalSum + (digit * digit);
        }
        return totalSum;
    }

    public void run() {
        int n = 19;
        System.out.println(isHappy(n));
    }
}
