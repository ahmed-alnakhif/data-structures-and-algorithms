package Problems.modifiedBinarySearch;

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

    public static char nextGreatestLetter(char[] letters, char target) {
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

    }
}
