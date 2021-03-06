package Problems.topKElements;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Given a string s, sort it in decreasing order based on the frequency of the
 * characters. The frequency of a character is the number of times it appears in
 * the string.
 * 
 * Return the sorted string. If there are multiple answers, return any of them.
 * 
 * 
 * Example 1:
 * 
 * Input: s = "tree"
 * Output: "eert"
 * Explanation: 'e' appears twice while 'r' and 't' both appear once.
 * So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid
 * answer.
 */

public class SortCharactersByFrequency {

    public static String frequencySort(String s) {
        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>(
                (a, b) -> b.getValue() - a.getValue());
        Map<Character, Integer> frequency = new HashMap<>();

        for (Character c : s.toCharArray()) {
            frequency.put(c, frequency.getOrDefault(c, 0) + 1);
        }

        maxHeap.addAll(frequency.entrySet());

        StringBuilder sb = new StringBuilder();
        while (maxHeap.size() > 0) {
            Map.Entry<Character, Integer> entry = maxHeap.remove();
            for (int i = 0; i < entry.getValue(); i++) {
                sb.append(entry.getKey());
            }
        }

        return sb.toString();
    }

    public int leastInterval(char[] tasks, int n) {
        // frequencies of the tasks
        int[] frequencies = new int[26];
        for (int task : tasks) {
            frequencies[task - 'A']++;
        }

        Arrays.sort(frequencies);

        // max frequency
        int maxFreq = frequencies[25];
        int idleTime = (maxFreq - 1) * n;
        
        for (int i = frequencies.length - 2; i >= 0 && idleTime > 0; --i) {
            idleTime -= Math.min(maxFreq - 1, frequencies[i]); 
        }
        
        idleTime = Math.max(0, idleTime);

        return idleTime + tasks.length;
    }

    public static void main(String[] args) {
        System.out.println(frequencySort("abbccaacbbb"));
    }
}
