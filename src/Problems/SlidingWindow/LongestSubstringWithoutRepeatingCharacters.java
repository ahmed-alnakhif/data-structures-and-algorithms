package Problems.SlidingWindow;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an integer array nums, return true if any value appears at least twice
 * in the array, and return false if every element is distinct.
 * 
 * Example 1:
 * 
 * Input: nums = [1,2,3,1]
 * Output: true
 */

public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int max = 0, left = 0, right = 0;

        while (right < s.length()) {
            if (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left++));
            } else {
                set.add(s.charAt(right++));
                max = Math.max(max, set.size());
            }
        }

        return max;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters f = new LongestSubstringWithoutRepeatingCharacters();
        System.out.println(f.lengthOfLongestSubstring("abcabcbb"));
    }
}
