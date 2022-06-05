package Problems.SlidingWindow;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Given an integer array nums, return true if any value appears at least twice
 * in the array, and return false if every element is distinct.
 * 
 * Example 1:
 * 
 * Input: nums = [1,2,3,1]
 * Output: true
 */

public class LongestSubstringWithAtMostKDistinctCharacters {

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s.length() * k == 0) {
            return 0;
        }

        Map<Character, Integer> map = new LinkedHashMap<>();
        int maxLen = 0;
        int right = 0, left = 0;

        while (right < s.length()) {
            Character c = s.charAt(right);

            if (map.containsKey(c)) {
                map.remove(c);
            }
            map.put(c, right++);

            if (map.size() > k) {
                var leftEntry = map.entrySet().iterator().next();
                map.remove(leftEntry.getKey());
                left = leftEntry.getValue() + 1;
            }

            maxLen = Math.max(maxLen, right - left);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        LongestSubstringWithAtMostKDistinctCharacters f = new LongestSubstringWithAtMostKDistinctCharacters();
        String s = "eeeceba";
        int k = 2;

        System.out.println(f.lengthOfLongestSubstringKDistinct(s, k));
    }
}
