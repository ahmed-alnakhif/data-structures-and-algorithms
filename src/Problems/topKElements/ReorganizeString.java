package Problems.topKElements;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Given a string s, rearrange the characters of s so that any two adjacent
 * characters are not the same.
 * 
 * Return any possible rearrangement of s or return "" if not possible.
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
        Map<Character, Integer> charFreqMap = new HashMap<>();
        for (char ch : str.toCharArray()) {
            charFreqMap.put(ch, charFreqMap.getOrDefault(ch, 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>(
                (a, b) -> b.getValue() - a.getValue());

        // add all characters to the max heap
        maxHeap.addAll(charFreqMap.entrySet());

        Queue<Map.Entry<Character, Integer>> queue = new LinkedList<>();
        StringBuilder resultString = new StringBuilder(str.length());
        while (!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> currEntry = maxHeap.poll();

            resultString.append(currEntry.getKey());
            currEntry.setValue(currEntry.getValue() - 1);
            
            queue.offer(currEntry);
            
            if (queue.size() == 2) {
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
        System.out.println(reorganizeString("vvvlo"));
    }
}
