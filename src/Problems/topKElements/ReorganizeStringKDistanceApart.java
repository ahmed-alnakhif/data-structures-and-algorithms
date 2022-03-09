package Problems.topKElements;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Given a string s and an integer k, rearrange s such that the same characters
 * are at least distance k from each other. If it is not possible to rearrange
 * the string, return an empty string "".
 * 
 * 
 * Example 1:
 * 
 * Input: s = "aabbcc", k = 3
 * Output: "abcabc"
 * Explanation: The same letters are at least a distance of 3 from each other.
 * Example 2:
 * 
 * Input: s = "aaabc", k = 3
 * Output: ""
 * Explanation: It is not possible to rearrange the string.
 */

public class ReorganizeStringKDistanceApart {

    public static String rearrangeString(String str, int k) {
        if (k <= 1) {
            return str;
        }

        Map<Character, Integer> charFrequencyMap = new HashMap<>();
        for (char chr : str.toCharArray()) {
            charFrequencyMap.put(chr, charFrequencyMap.getOrDefault(chr, 0) + 1);
            if (charFrequencyMap.get(chr) > (str.length() + 1) / 2) {
                return "";
            }
        }

        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<Map.Entry<Character, Integer>>(
                (a, b) -> b.getValue() - a.getValue());

        // add all characters to the max heap
        maxHeap.addAll(charFrequencyMap.entrySet());

        Queue<Map.Entry<Character, Integer>> queue = new LinkedList<>();
        StringBuilder resultString = new StringBuilder(str.length());
        while (!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> currentEntry = maxHeap.poll();

            // append the current character to the result string and decrement its count
            resultString.append(currentEntry.getKey());
            currentEntry.setValue(currentEntry.getValue() - 1);

            queue.offer(currentEntry);

            // add item waiting in the queue if we reach k distance
            if (queue.size() == k) {
                Map.Entry<Character, Integer> entry = queue.poll();
                if (entry.getValue() > 0) {
                    maxHeap.offer(entry);
                }
            }

        }

        // if successful in appending all the characters to the result string, return it
        return resultString.length() == str.length() ? resultString.toString() : "";
    }

    public static void main(String[] args) {
        System.out.println(rearrangeString("vvvlo", 2));
    }
}
