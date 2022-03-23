package Problems.Permutations;

import java.util.ArrayList;
import java.util.List;

/**
 * Given n pairs of parentheses, write a function to generate all combinations
 * of well-formed parentheses.
 * 
 * 
 * Example 1:
 * 
 * Input: n = 3
 * Output: ["((()))","(()())","(())()","()(())","()()()"]
 * Example 2:
 * 
 * Input: n = 1
 * Output: ["()"]
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
