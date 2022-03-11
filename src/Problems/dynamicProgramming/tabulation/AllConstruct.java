package Problems.dynamicProgramming.tabulation;

import java.util.ArrayList;
import java.util.List;

/*
  given a word and a string of words, return all the ways that the target can be constructed from the word bank array
   
*/

public class AllConstruct {

    static List<List<String>> allConstruct(String target, String[] wordBank) {
        List<List<List<String>>> table = new ArrayList<>();
        for (int i = 0; i < target.length() + 1; i++) {
            table.add(new ArrayList<>());
            if (i == 0) {
                table.get(i).add(new ArrayList<>());
            }
        }

        for (int i = 0; i < table.size(); i++) {
            for (String word : wordBank) {
                if (i + word.length() < target.length() + 1) {
                    String substring = target.substring(i, i + word.length());
                    if (word.equals(substring)) {
                        // copy the current list + word at index i to the [i+word.length] list
                        for (List<String> comb : table.get(i)) {
                            List<String> newComb = new ArrayList<>(comb);
                            newComb.add(word);
                            table.get(i + word.length()).add(newComb);
                        }
                    }
                }
            }
        }

        return table.get(target.length());
    }

    

    public static void main(String[] args) {
        System.out.println(allConstruct("purple", new String[] { "purp", "p", "ur", "le", "purpl" }));
        System.out.println(allConstruct("abcdef", new String[] { "ab", "abc", "cd", "def", "abcd", "ef", "c" }));
        System.out.println(allConstruct("skateboard", new String[] { "bo", "rd", "ate", "t", "ska", "sk", "boar" }));
        System.out.println(allConstruct("aaaaaaaaaaaaz", new String[] { "a", "aa", "aaa", "aaaa", "aaaaa" }));
        System.out.println(allConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef",
                new String[] { "e", "ee", "eee", "eeee", "eeeee" }));
    }
}
