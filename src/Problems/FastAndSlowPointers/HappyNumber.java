package Problems.FastAndSlowPointers;

/**
 * Write an algorithm to determine if a number n is happy.
 * 
 * A happy number is a number defined by the following process:
 * 
 * Starting with any positive integer, replace the number by the sum of the
 * squares of its digits.
 * Repeat the process until the number equals 1 (where it will stay), or it
 * loops endlessly in a cycle which does not include 1.
 * Those numbers for which this process ends in 1 are happy.
 * Return true if n is a happy number, and false if not.
 * 
 * Example 1:
 * 
 * Input: n = 19
 * Output: true
 * Explanation:
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 * Example 2:
 * 
 * Input: n = 2
 * Output: false
 */

public class HappyNumber {

    // Floyd's Algorithm => T: O(N), S: O(1), no modification
    public boolean isHappy(int n) {
        int slow = n;
        int fast = getNextDigit(n);

        while (fast != 1 && slow != fast) {
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
