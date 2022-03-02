package Problems.dynamicProgramming.memoization;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
  given a word and a string of words, return all the ways that the target can be constructed from the word bank array
   
*/

public class AllConstruct {

    //m = target.length, n = wordBack.length
    //T: O(n^m), S: O(n^m)
    static List<List<String>> allConstruct(String target, String[] wordBank) {
        return allConstructHelper(target, wordBank, new HashMap<>());
    }

    static List<List<String>> allConstructHelper(String target, String[] wordBank,
            HashMap<String, List<List<String>>> memoMap) {
        List<List<String>> result = new ArrayList<>();

        if (target.equals("")) {
            result.add(new ArrayList<>());
            return result;
        }

        if (memoMap.containsKey(target)) {
            return memoMap.get(target);
        }

        for (String word : wordBank) {
            if (target.indexOf(word) == 0) {
                String suffix = target.substring(word.length());
                List<List<String>> suffixWays = allConstructHelper(suffix, wordBank, memoMap);
                for (List<String> subList : suffixWays) {
                    List<String> newList = new ArrayList<String>(subList);
                    newList.add(0, word);
                    result.add(newList);
                }
            }
        }

        memoMap.put(target, result);

        return result;
    }

    public static void main(String[] args) {
        System.out.println(allConstruct("abcdef", new String[] { "ab", "abc", "cd", "def", "abcd", "ef", "c" }));
        System.out.println(allConstruct("skateboard", new String[] { "bo", "rd", "ate", "t", "ska", "sk", "boar" }));
        System.out.println(allConstruct("enterapotentpot", new String[] { "a", "p", "ent", "enter", "ot", "o", "t" })); //not correct
        System.out.println(allConstruct("purple", new String[] { "purp", "p", "ur", "le", "purpl" }));
        System.out.println(allConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef",
                new String[] { "e", "ee", "eee", "eeee", "eeeee" }));
    }
}
