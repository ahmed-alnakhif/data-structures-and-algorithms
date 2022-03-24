package Companies.facebook;

/**
 * A parentheses string is valid if and only if:
 * 
 * It is the empty string,
 * It can be written as AB (A concatenated with B), where A and B are valid
 * strings, or
 * It can be written as (A), where A is a valid string.
 * You are given a parentheses string s. In one move, you can insert a
 * parenthesis at any position of the string.
 * 
 * For example, if s = "()))", you can insert an opening parenthesis to be
 * "(()))" or a closing parenthesis to be "())))".
 * Return the minimum number of moves required to make s valid.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "())"
 * Output: 1
 * Example 2:
 * 
 * Input: s = "((("
 * Output: 3
 */


public class MakeParenthesesValid {

    //T: O(N), S:O(1)
    public int minAddToMakeValid(String s) {
        int open = 0, close = 0;
        
        for(char ch : s.toCharArray()){
            if(ch == '('){
                open++;
            } else {
                if(open > 0) open--;
                else close++;
            } 
        }
        
        return open + close;
    }

    public static void main(String[] args) {
        MakeParenthesesValid m = new MakeParenthesesValid();
        System.out.println(m.minAddToMakeValid("(())))"));
    }
}
