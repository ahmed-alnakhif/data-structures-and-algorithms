package Companies.facebook;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;

/**
 * Given a string s of '(' , ')' and lowercase English characters.
 * 
 * Your task is to remove the minimum number of parentheses ( '(' or ')', in any
 * positions ) so that the resulting parentheses string is valid and return any
 * valid string.
 * 
 * Formally, a parentheses string is valid if and only if:
 * 
 * It is the empty string, contains only lowercase characters, or
 * It can be written as AB (A concatenated with B), where A and B are valid
 * strings, or
 * It can be written as (A), where A is a valid string.
 * 
 * 
 * Example 1:
 * 
 * Input: s = "lee(t(c)o)de)"
 * Output: "lee(t(c)o)de"
 * Explanation: "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.
 * Example 2:
 * 
 * Input: s = "a)b(c)d"
 * Output: "ab(c)d"
 */

public class MinRemoveToMakeValidParentheses {

    public String minRemoveToMakeValid(String s) {
        StringBuilder str = new StringBuilder();
        Deque<Integer> stack = new ArrayDeque<>();
        HashSet<Integer> toRemoveIndices = new HashSet<>();
        
        for(int i = 0; i<s.length(); i++){
            char ch = s.charAt(i);
            
            if(ch == '('){
                stack.push(i);
            } else if(ch == ')'){
                if(stack.isEmpty()){
                    toRemoveIndices.add(i);
                } else {
                    stack.pop();
                }
            }
        }
        
        while(!stack.isEmpty()){
           toRemoveIndices.add(stack.pop());
        }
        
        for(int i = 0; i<s.length(); i++){
            if(!toRemoveIndices.contains(i)){
                str.append(s.charAt(i));
            }    
        }
        
        return str.toString();
    }

    public String minRemoveToMakeValid2(String s) {

        // Pass 1: Remove all invalid ")"
        StringBuilder sb = new StringBuilder();
        int open = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                open++;
            } else if (c == ')') {
                if (open == 0) continue; // skip invalid close parentheses
                open--;
            }
            
            sb.append(c);
        }
        
        // Pass 2: Remove the rightmost "("
        StringBuilder result = new StringBuilder();
        for (int i = sb.length() - 1; i >= 0; i--) {
            char ch = sb.charAt(i);
            
            if (ch == '('){
                if(open-- > 0) continue; // skip invalid open parentheses
            } 
            result.append(ch);
        }

        return result.toString();
    }

    

    public static void main(String[] args) {
        MinRemoveToMakeValidParentheses mValidParentheses = new MinRemoveToMakeValidParentheses();
        System.out.println(mValidParentheses.minRemoveToMakeValid("lee(t(c)o)de)("));
    }
}
