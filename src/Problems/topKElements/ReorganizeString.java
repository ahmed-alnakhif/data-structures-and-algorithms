package Problems.topKElements;

import java.util.HashMap;
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

    static class Pair {
        char c;
        int freq;

        Pair(char c, int freq) {
            this.c = c;
            this.freq = freq;
        }
    }

    public static String reorganizeString(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (Character c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);

            // impossible to form a solution
            if (map.get(c) > (s.length() + 1) / 2) {
                return "";
            }
        }

        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((a, b) -> b.freq - a.freq);
        map.forEach((e, v) -> maxHeap.add(new Pair(e, v)));

        StringBuilder strB = new StringBuilder();

        while (!maxHeap.isEmpty()) {
            Pair curr = maxHeap.poll();

            if (strB.length() == 0 || strB.charAt(strB.length() - 1) != curr.c) {
                strB.append(curr.c);
                curr.freq -= 1;
            } else {
                Pair next = maxHeap.poll();
                strB.append(next.c);
                next.freq -= 1;
                if (next.freq > 0) {
                    maxHeap.add(next);
                }
            }

            if (curr.freq > 0) {
                maxHeap.add(curr);
            }
        }

        return strB.toString();
    }

    public static void main(String[] args) {
        System.out.println(reorganizeString("vvvlo"));
    }
}
