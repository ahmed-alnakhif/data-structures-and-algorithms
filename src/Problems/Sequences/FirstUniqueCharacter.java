package Problems.Sequences;

import java.util.HashMap;

/**
 * Given a string s, find the first non-repeating character in it and return its
 * index. If it does not exist, return -1.
 * 
 * Example 1:
 * 
 * Input: s = "leetcode"
 * Output: 0
 * Example 2:
 * 
 * Input: s = "loveleetcode"
 * Output: 2
 */

public class FirstUniqueCharacter {

    public int firstUniqChar(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) return i;
        }

        return -1;
    }

    public static void main(String[] args) {
        FirstUniqueCharacter f = new FirstUniqueCharacter();
        System.out.println(f.firstUniqChar("loveleetcode"));
    }
}
