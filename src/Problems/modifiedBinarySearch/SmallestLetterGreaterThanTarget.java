package Problems.modifiedBinarySearch;

import java.util.Arrays;

/**
 * Given a characters array letters that is sorted in non-decreasing order and a
 * character target, return the smallest character in the array that is larger
 * than target.
 * 
 * Note that the letters wrap around.
 * 
 * For example, if target == 'z' and letters == ['a', 'b'], the answer is 'a'.
 * 
 * 
 * Example 1:
 * 
 * Input: letters = ["c","f","j"], target = "a"
 * Output: "c"
 */

public class SmallestLetterGreaterThanTarget {

    public char nextGreatestLetter(char[] letters, char target) {
        char nextChar = (char) ((target - 'a' + 1) + 'a');
        int nextCharIndex = Arrays.binarySearch(letters, nextChar);

        if (nextCharIndex < 0) {
            nextCharIndex = Math.abs(nextCharIndex) - 1;
        }

        if (nextCharIndex < letters.length) {
            return letters[nextCharIndex];
        }

        return letters[0];
    }

    public char nextGreatestLetter2(char[] letters, char target) {
        int left = 0, right = letters.length - 1;

        while (left <= right) {
            int mid = left + ((right - left) / 2);

            if (letters[mid] <= target) {
                left = mid + 1;
            }

            else if (letters[mid] > target) {
                right = mid - 1;
            }
        }

        if (letters[right] <= target) {
            return letters[right + 1];
        } else {
            return letters[right];
        }
    }

    public static void main(String[] args) {
        SmallestLetterGreaterThanTarget s = new SmallestLetterGreaterThanTarget();
        System.out.println(s.nextGreatestLetter(new char[] { 'c', 'f', 'j' }, 'a'));
    }
}
