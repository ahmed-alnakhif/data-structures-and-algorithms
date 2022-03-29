package Problems.Sequences;

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

    public List<List<String>> groupAnagrams(String[] strings) {
        if (strings.length == 0) {
            return new ArrayList<>();
        }
        
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strings) {
            char[] tempChars = str.toCharArray();
            Arrays.sort(tempChars);
            String word = String.valueOf(tempChars);

            if (map.containsKey(word)) {
                map.get(word).add(str);
            } else {
                map.put(word, new ArrayList<>(Arrays.asList(str)));
            }
        }

        return new ArrayList<>(map.values());
    }

   public static void main(String[] args) {
        GroupAnagram groupAnagram = new GroupAnagram();
        System.out.println(groupAnagram.groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"}));
    }
}
