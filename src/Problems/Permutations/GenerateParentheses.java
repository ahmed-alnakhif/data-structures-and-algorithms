package Problems.Permutations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

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
public class GenerateParentheses {

    // base case: open == close == n
    // only add open parentheses if open < n
    // only add close parentheses if close < open

    static List<String> result = new ArrayList<>();

    public static List<String> generateParenthesis(int n) {
        backtrack(n, 0, 0, new StringBuilder());
        return result;
    }

    private static void backtrack(int n, int open, int close, StringBuilder perString) {
        if (open == close && open == n) {
            result.add(perString.toString());
            return;
        }

        if (open < n) {
            backtrack(n, open + 1, close, perString.append("("));
            perString.deleteCharAt(perString.length() - 1);
        }

        if (close < open) {
            backtrack(n, open, close + 1, perString.append(")"));
            perString.deleteCharAt(perString.length() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }
}
