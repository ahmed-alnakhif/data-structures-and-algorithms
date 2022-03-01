package Problems.DynamicProgramming;

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

    static Boolean canConstructHelper(String word, String[] wordBank) {
        if (word.equals("")) {
            return true;
        }

        if (memoMap.containsKey(word)) {
            return memoMap.get(word);
        }

        for (String str : wordBank) {
            // str is a prefix
            if (word.indexOf(str) == 0) {
                String suffix = word.substring(str.length());
                if (canConstructHelper(suffix, wordBank)) {
                    memoMap.put(word, true);
                    return true;
                }
            }
        }

        memoMap.put(word, false);

        return false;
    }

    public static void main(String[] args) {
        System.out.println(canConstruct("abcdef", new String[] { "ab", "abc", "cd", "def", "abcd" })); //true
        System.out.println(canConstruct("skateboard", new String[] { "bo", "rd", "ate", "t", "ska", "sk", "boar" })); //false
        System.out.println(canConstruct("enterapotentpot", new String[] { "a", "p", "ent", "enter", "ot", "o", "t" })); // true
        System.out.println(canConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef",
                new String[] { "e", "ee", "eee", "eeee", "eeeee" })); //false
    }
}
