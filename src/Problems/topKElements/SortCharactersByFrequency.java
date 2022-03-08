package Problems.topKElements;

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

    static class LetterFreq {
        char letter;
        int freq;
        String word;

        LetterFreq(char l, int f) {
            this.letter = l;
            this.freq = f;
            this.word = String.valueOf(l);
        }

        LetterFreq(String w, int f) {
            this.freq = f;
            this.word = w;
        }

        void incrementFreq() {
            this.freq += 1;
            this.word += String.valueOf(letter);
        }
    }

    public static String frequencySort(String s) {
        Map<Character, LetterFreq> map = new HashMap<>();

        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                map.get(c).incrementFreq();
            } else {
                map.put(c, new LetterFreq(c, 1));
            }
        }

        PriorityQueue<LetterFreq> maxHeap = new PriorityQueue<>((a, b) -> b.freq != a.freq
                ? b.freq - a.freq
                : a.word.compareTo(b.word));

        map.forEach((e, v) -> {
            maxHeap.add(new LetterFreq(v.word, v.freq));
        });

        String result = "";
        while (!maxHeap.isEmpty()) {
            result += maxHeap.poll().word;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(frequencySort("abbccaacbbb"));
    }
}
