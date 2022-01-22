package Problems.StringAndArrayManipulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given an array of strings strs, group the anagrams together. You can return
 * the answer in any order.
 * 
 * An Anagram is a word or phrase formed by rearranging the letters of a
 * different word or phrase, typically using all the original letters exactly
 * once.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: strs = ["eat","tea","tan","ate","nat","bat"]
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * 
 */

public class GroupAnagram {

    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) {
            return new ArrayList();
        }
        
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
