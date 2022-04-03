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
        int left = 0, right = 0;
        int maxLength = 0, charFreq = 0;

        while (right < s.length()) {
            char ch = s.charAt(right);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            charFreq = Math.max(charFreq, map.get(ch));

            while ((right - left + 1) - charFreq > k) {
                char leftChar = s.charAt(left++);
                map.put(leftChar, map.get(leftChar) - 1);
            }

            maxLength = Math.max(maxLength, (right - left + 1));
            right++;
        }

        return maxLength;
    }

    public static void main(String[] args) {
        LongestRepeatingCharacterReplacement l = new LongestRepeatingCharacterReplacement();
        System.out.println(l.characterReplacement("AABABBA", 1));
    }
}
