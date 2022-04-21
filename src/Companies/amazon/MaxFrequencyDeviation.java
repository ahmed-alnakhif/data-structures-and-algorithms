package Companies.amazon;

import java.util.HashMap;
import java.util.Map;

/**
 * given a string s, representing the input string, find the maximum possible
 * frequency deviation of any substring in the string
 */

public class MaxFrequencyDeviation {

    // Brute-force way - O(n^2)
    // TODO: do better
    public int maxFrequencyDeviation(String s) {
        int maxDeviation = 0;

        for (int i = 1; i < s.length(); i++) {
            Map<Character, Integer> countMap = new HashMap<>();
            int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

            for (int j = 0; j < i; j++) {
                char ch = s.charAt(j);
                countMap.put(ch, countMap.getOrDefault(ch, 0) + 1);
                min = Math.min(min, countMap.get(ch));
                max = Math.max(max, countMap.get(ch));
            }
            maxDeviation = Math.max(maxDeviation, max - min);
        }

        return maxDeviation;
    }

    public static void main(String[] args) {
        MaxFrequencyDeviation mfd = new MaxFrequencyDeviation();
        System.out.println(mfd.maxFrequencyDeviation("aabbcc"));
        System.out.println(mfd.maxFrequencyDeviation("bbacccabab"));
    }
}
