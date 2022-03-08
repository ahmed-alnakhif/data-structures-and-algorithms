package Problems.topKElements;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Given an array of strings words and an integer k, return the k most frequent
 * strings.
 * 
 * Return the answer sorted by the frequency from highest to lowest. Sort the
 * words with the same frequency by their lexicographical order.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: words = ["i","love","leetcode","i","love","coding"], k = 2
 * Output: ["i","love"]
 * Explanation: "i" and "love" are the two most frequent words.
 * Note that "i" comes before "love" due to a lower alphabetical order.
 */

public class TopKFrequentWords {

    static class WordFreq {
        String word;
        int freq;

        WordFreq(String word, int freq) {
            this.word = word;
            this.freq = freq;
        }
    }

    public static List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new LinkedHashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<WordFreq> minHeap = new PriorityQueue<WordFreq>((a, b) -> a.freq != b.freq
                ? a.freq - b.freq
                : b.word.compareTo(a.word));

        map.forEach((key, value) -> {
            minHeap.add(new WordFreq(key, value));
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        });

        LinkedList<String> result = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            result.addFirst(minHeap.poll().word);
        }

        return result;
    }

    public static void main(String[] args) {
        String[] words = { "i", "love", "leetcode", "i", "love", "coding" };
        int k = 3;
        System.out.println(topKFrequent(words, k));
    }
}
