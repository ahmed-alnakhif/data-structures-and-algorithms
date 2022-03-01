package Problems.DynamicProgramming;

import java.util.HashMap;
import java.util.Map;

/*
  given a word and a string of words, count the number of ways that the target can be constructed from the word bank array 
*/

public class CountConstruct {

    static Map<String, Boolean> memoMap;

    static Boolean countConstruct(String word, String[] wordBank) {
        memoMap = new HashMap<>();
        return countConstructHelper(word, wordBank);
    }

    static Boolean countConstructHelper(String word, String[] wordBank) {
        
    }

    public static void main(String[] args) {
        System.out.println(countConstruct("abcdef", new String[] { "ab", "abc", "cd", "def", "abcd" })); 
        System.out.println(countConstruct("skateboard", new String[] { "bo", "rd", "ate", "t", "ska", "sk", "boar" })); 
        System.out.println(countConstruct("enterapotentpot", new String[] { "a", "p", "ent", "enter", "ot", "o", "t" })); 
        System.out.println(countConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef",
                new String[] { "e", "ee", "eee", "eeee", "eeeee" })); 
    }
}
