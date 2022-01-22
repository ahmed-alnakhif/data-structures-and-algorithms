package Problems.StringAndArrayManipulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given two strings s and t, return true if t is an anagram of s, and false
 * otherwise.
 * 
 * An Anagram is a word or phrase formed by rearranging the letters of a
 * different word or phrase, typically using all the original letters exactly
 * once.
 * 
 * 
 * Example 1:
 * 
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 * Example 2:
 * 
 * Input: s = "rat", t = "car"
 * Output: false
 * 
 */

public class GroupAnagram {

    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0)
            return new ArrayList();

        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String word = String.valueOf(chars);

            if (map.containsKey(word)) {
                map.get(word).add(str);
            } else {
                map.put(word, new ArrayList<>(Arrays.asList(str)));
            }
        }

        return new ArrayList(map.values());
    }

    public void run() {
        String[] words = { "eat", "tea", "tan", "ate", "nat", "bat" };
        System.out.println(groupAnagrams(words));
    }
}
