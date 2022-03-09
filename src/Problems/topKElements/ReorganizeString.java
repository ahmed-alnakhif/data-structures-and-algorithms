package Problems.topKElements;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Given a string s, rearrange the characters of s so that any two adjacent
 * characters are not the same.
 * 
 * Return any possible rearrangement of s or return "" if not possible.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "aab"
 * Output: "aba"
 * Example 2:
 * 
 * Input: s = "aaab"
 * Output: ""
 */

public class ReorganizeString {

    public static String reorganizeString(String str) {
        Map<Character, Integer> charFrequencyMap = new HashMap<>();
        for (char chr : str.toCharArray()) {
            charFrequencyMap.put(chr, charFrequencyMap.getOrDefault(chr, 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<Map.Entry<Character, Integer>>(
                (a, b) -> b.getValue() - a.getValue());

        // add all characters to the max heap
        maxHeap.addAll(charFrequencyMap.entrySet());

        Map.Entry<Character, Integer> previousEntry = null;
        StringBuilder resultString = new StringBuilder(str.length());
        while (!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> currentEntry = maxHeap.poll();

            // add the previous entry back in the heap if its frequency is greater than zero
            if (previousEntry != null && previousEntry.getValue() > 0) {
                maxHeap.offer(previousEntry);
            }

            // append the current character to the result string and decrement its count
            resultString.append(currentEntry.getKey());
            currentEntry.setValue(currentEntry.getValue() - 1);
            
            previousEntry = currentEntry;
        }

        // if successful in appending all the characters to the result string, return it
        return resultString.length() == str.length() ? resultString.toString() : "";
    }

    public static void main(String[] args) {
        System.out.println(reorganizeString("vvvlo"));
    }
}
