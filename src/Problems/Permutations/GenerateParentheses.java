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
        generate(n, 0, 0, new StringBuilder());
        return result;
    }

    private static void generate(int n, int open, int close, StringBuilder str) {
        if (open == n && close == n) {
            result.add(str.toString());
            return;
        }

        if (open < n) {
            generate(n, open + 1, close, str.append("("));
            str.deleteCharAt(str.length() - 1);
        }

        if (close < open) {
            generate(n, open, close + 1, str.append(")"));
            str.deleteCharAt(str.length() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }
}
