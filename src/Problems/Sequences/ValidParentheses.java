package Problems.Sequences;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and
 * ']', determine if the input string is valid.
 * 
 * An input string is valid if:
 * 
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * 
 * 
 * Example 1:
 * Input: s = "()[]{}"
 * Output: true
 * 
 * Example 2:
 * Input: s = "(]"
 * Output: false
 */

public class ValidParentheses {

    public static boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        Stack<Character> stack = new Stack<>();

        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        for (Character c : s.toCharArray()) {
            if (map.containsKey(c)) {
                if (stack.isEmpty() || map.get(c) != stack.pop()) {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "[([])]";

        System.out.println(isValid(s));
    }
}
