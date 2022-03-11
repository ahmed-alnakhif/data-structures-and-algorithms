package Problems.dynamicProgramming.memoization;

import java.util.HashMap;
import java.util.Map;

/*
  given a word and a string of words. can you construct the word using any combination of of the strings in the word back
*/

public class CanConstruct {

    static Map<String, Boolean> memoMap;

    static Boolean canConstruct(String word, String[] wordBank) {
        memoMap = new HashMap<>();
        return canConstructHelper(word, wordBank);
    }

    static Boolean canConstructHelper(String target, String[] wordBank) {
        // base case: string becomes empty;
        // meaning that we were able to take off all the letters from the word bank
        if (target.equals("")) {
            return true;
        }

        if (memoMap.containsKey(target)) {
            return memoMap.get(target);
        }

        for (String word : wordBank) {
            if (target.indexOf(word) == 0) {
                String prefix = target.substring(word.length());
                if (canConstructHelper(prefix, wordBank)) {
                    memoMap.put(target, true);
                    return true;
                }
            }
        }

        memoMap.put(target, false);

        return false;
    }

    public static void main(String[] args) {
        System.out.println(canConstruct("abcdef", new String[] { "ab", "abc", "cd", "def", "abcd" })); // true
        System.out.println(canConstruct("skateboard", new String[] { "bo", "rd", "ate", "t", "ska", "sk", "boar" })); // false
        System.out.println(canConstruct("enterapotentpot", new String[] { "a", "p", "ent", "enter", "ot", "o", "t" })); // true
        System.out.println(canConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef",
                new String[] { "e", "ee", "eee", "eeee", "eeeee" })); // false
    }
}
