package Problems.SlidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings s and t of lengths m and n respectively, return the minimum
 * window substring of s such that every character in t (including duplicates)
 * is included in the window. If there is no such substring, return the empty
 * string "".
 * 
 * A substring is a contiguous sequence of characters within the string.
 * 
 * 
 * Example 1:
 * 
 * Input: s = "ADOBECODEBANC", t = "ABC"
 * Output: "BANC"
 * Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C'
 * from string t.
 */

public class MinimumWindowSubstring {

    public String minWindow(String s, String t) {
        Map<Character, Integer> freqMap = new HashMap<>();

        for (char c : t.toCharArray()){
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0, minStart = 0, minLen = Integer.MAX_VALUE, remaining = t.length();

        while (right < s.length()) {
            char c = s.charAt(right);
            
            if (freqMap.containsKey(c)) {
                freqMap.put(c, freqMap.get(c) - 1);
                if (freqMap.get(c) >= 0) {
                    remaining--;
                }
            }

            while (remaining == 0) {
                int windowSize = right - left + 1;
                if (windowSize < minLen) {
                    minLen = windowSize;
                    minStart = left;
                }
                char leftChar = s.charAt(left);
                if (freqMap.containsKey(leftChar)) {
                    freqMap.put(leftChar, freqMap.get(leftChar) + 1);
                    if (freqMap.get(leftChar) > 0) {
                        remaining++;
                    }
                }
                left++;
            }

            right++;
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }

    public void run() {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minWindow(s, t));
    }
}
