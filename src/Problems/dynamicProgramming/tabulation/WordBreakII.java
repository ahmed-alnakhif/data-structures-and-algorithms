package Problems.dynamicProgramming.tabulation;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string s and a dictionary of strings wordDict, add spaces in s to
 * construct a sentence where each word is a valid dictionary word. Return all
 * such possible sentences in any order.
 * 
 * Note that the same word in the dictionary may be reused multiple times in the
 * segmentation.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: str = "catsanddog", wordDict = ["cat","cats","and","sand","dog"]
 * Output: ["cats and dog","cat sand dog"]
 */

public class WordBreakII {

    public List<String> wordBreak(String str, List<String> wordDict) {
        List<List<String>> table = new ArrayList<>();
        for (int i = 0; i < str.length() + 1; i++) {
            table.add(new ArrayList<>());
            if (i == 0) {
                table.get(i).add("");
            }
        }

        for (int i = 0; i < table.size(); i++) {
            for (String word : wordDict) {
                if (i + word.length() < str.length() + 1) {
                    String substring = str.substring(i, i + word.length());
                    if (word.equals(substring)) {
                        List<String> sentences = table.get(i);
                        for (int j = 0; j < sentences.size(); j++) {
                            String newComb = sentences.get(j);
                            if (newComb.equals("")) {
                                newComb += word;
                            } else {
                                newComb += " " + word;
                            }

                            table.get(i + word.length()).add(newComb);
                        }
                    }
                }
            }
        }

        return table.get(str.length());
    }

    public static void main(String[] args) {
        WordBreakII wordBreakII = new WordBreakII();
        System.out.println(
                wordBreakII.wordBreak("catsanddog", new ArrayList<>(List.of("cat", "cats", "and", "sand", "dog"))));
    }
}
