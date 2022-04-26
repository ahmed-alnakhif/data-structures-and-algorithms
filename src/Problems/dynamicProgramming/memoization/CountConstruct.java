package Problems.dynamicProgramming.memoization;

import java.util.HashMap;
import java.util.Map;

/*
  given a word and a string of words, count the number of ways that the target can be constructed from the word bank array 
*/

public class CountConstruct {

    static Map<String, Integer> memoMap;

    static int countConstruct(String word, String[] wordBank) {
        memoMap = new HashMap<>();
        return countConstructHelper(word, wordBank);
    }

    static int countConstructHelper(String target, String[] wordBank) {
        if (target.equals(""))  return 1;
        if (memoMap.containsKey(target))return memoMap.get(target);

        int totalCount = 0;
        for (String word : wordBank) {
            if (target.indexOf(word) == 0) {
                String suffix = target.substring(word.length());
                totalCount += countConstructHelper(suffix, wordBank);
            }
        }

        memoMap.put(target, totalCount);

        return totalCount;
    }

    public static void main(String[] args) {
        System.out.println(countConstruct("purple", new String[] { "purp", "p", "ur", "le", "purpl" }));
        System.out.println(countConstruct("abcdef", new String[] { "ab", "abc", "cd", "def", "abcd" }));
        System.out.println(countConstruct("skateboard", new String[] { "bo", "rd", "ate", "t", "ska", "sk", "boar" }));
        System.out
                .println(countConstruct("enterapotentpot", new String[] { "a", "p", "ent", "enter", "ot", "o", "t" }));
        System.out.println(countConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef",
                new String[] { "e", "ee", "eee", "eeee", "eeeee" }));
    }
}
 