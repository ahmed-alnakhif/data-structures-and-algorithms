package Problems.SlidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * You are given a string s and an integer k. You can choose any character of
 * the string and change it to any other uppercase English character. You can
 * perform this operation at most k times.
 * 
 * Return the length of the longest substring containing the same letter you can
 * get after performing the above operations.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "ABAB", k = 2
 * Output: 4
 * Explanation: Replace the two 'A's with two 'B's or vice versa.
 */

public class LongestRepeatingCharacterReplacement {

    public int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int result = 0, maxFreq = 0;
        int left = 0, right = 0;

        while (right < s.length()) {
            char rightChar = s.charAt(right);
            map.put(rightChar, map.getOrDefault(rightChar, 0) + 1);

            maxFreq = Math.max(maxFreq, map.get(rightChar));
            while ((right - left + 1) - maxFreq > k) {
                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);
                left++;
            }
            result = Math.max(result, (right - left + 1));
            right++;
        }
        return result;
    }

    public void run() {
        String s = "AABABBA";
        int k = 4;
        System.out.println(characterReplacement(s, k));
    }
}
