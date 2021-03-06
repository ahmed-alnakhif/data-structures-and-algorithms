package Problems.Permutations;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string s, you can transform every letter individually to be lowercase
 * or uppercase to create another string.
 * 
 * Return a list of all possible strings we could create. Return the output in
 * any order.
 * 
 * 
 * Example 1:
 * 
 * Input: s = "a1b2"
 * Output: ["a1b2","a1B2","A1b2","A1B2"]
 * Example 2:
 * 
 * Input: s = "3z4"
 * Output: ["3z4","3Z4"]
 */

// Can be solved in a more optimized way using sliding window
public class LetterCasePermutation {

    List<String> result = new ArrayList<>();

    public List<String> letterCasePermutation(String s) {
        backtrack(s, new StringBuilder(), 0);
        return result;
    }

    private void backtrack(String str, StringBuilder resultStr, int left) {
        if (left == str.length()) {
            result.add(resultStr.toString());
            return;
        }

        char c = str.charAt(left);
        if (Character.isLetter(c)) {
            // for lower case
            backtrack(str, resultStr.append(Character.toLowerCase(c)), left + 1);
            resultStr.deleteCharAt(resultStr.length() - 1);

            // for upper case
            backtrack(str, resultStr.append(Character.toUpperCase(c)), left + 1);
            resultStr.deleteCharAt(resultStr.length() - 1);
        } else {
            backtrack(str, resultStr.append(c), left + 1);
            resultStr.deleteCharAt(resultStr.length() - 1);
        }
    }

    public static void main(String[] args) {
        LetterCasePermutation c = new LetterCasePermutation();
        System.out.println(c.letterCasePermutation("a1b2"));
    }
}
