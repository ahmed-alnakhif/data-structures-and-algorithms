package Problems.topologicalSort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * There is a new alien language that uses the English alphabet. However, the
 * order among the letters is unknown to you.
 * 
 * You are given a list of strings words from the alien language's dictionary,
 * where the strings in words are sorted lexicographically by the rules of this
 * new language.
 * 
 * Return a string of the unique letters in the new alien language sorted in
 * lexicographically increasing order by the new language's rules. If there is
 * no solution, return "". If there are multiple solutions, return any of them.
 * 
 * A string s is lexicographically smaller than a string t if at the first
 * letter where they differ, the letter in s comes before the letter in t in the
 * alien language. If the first min(s.length, t.length) letters are the same,
 * then s is smaller if and only if s.length < t.length.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: words = ["wrt","wrf","er","ett","rftt"]
 * Output: "wertf"
 */

public class AlienDictionary {

    public String alienOrder(String[] words) {
        HashMap<Character, ArrayList<Character>> graph = new HashMap<>();
        HashMap<Character, Integer> inDegree = new HashMap<>();

        for (String word : words) {
            for (char ch : word.toCharArray()) {
                graph.put(ch, new ArrayList<>());
                inDegree.put(ch, 0);
            }
        }

        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i];
            String w2 = words[i + 1];

            if (w1.length() > w2.length() && w1.startsWith(w2)) {
                return "";
            }

            for (int j = 0; j < Math.min(w1.length(), w2.length()); j++) {
                char parent = w1.charAt(j), child = w2.charAt(j);
                if (parent != child) {
                    graph.get(parent).add(child);
                    inDegree.put(child, inDegree.get(child) + 1);
                    break; // only the first different character between the two words will help us find
                           // the order
                }
            }
        }

        Queue<Character> sourcesQueue = new LinkedList<>();
        inDegree.forEach((key, val) -> {
            if (val == 0) {
                sourcesQueue.add(key);
            }
        });

        StringBuilder sortedOrder = new StringBuilder();

        while (!sourcesQueue.isEmpty()) {
            Character node = sourcesQueue.poll();
            sortedOrder.append(node);
            for (Character child : graph.get(node)) {
                inDegree.put(child, inDegree.get(child) - 1);
                if (inDegree.get(child) == 0) {
                    sourcesQueue.add(child);
                }
            }
        }

        if (sortedOrder.length() != inDegree.size()) {
            return "";
        }

        return sortedOrder.toString();
    }

    public static void main(String[] args) {
        AlienDictionary alienDictionary = new AlienDictionary();
        System.out.println("Alien Order: " + alienDictionary.alienOrder(new String[] { "wrt", "wrf", "er", "ett", "rftt" }));
        System.out.println("Alien Order: " + alienDictionary.alienOrder(new String[] { "z", "x", "z" }));
    }
}
