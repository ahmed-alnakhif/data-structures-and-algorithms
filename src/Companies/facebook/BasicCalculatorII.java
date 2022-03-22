package Companies.facebook;

import java.util.HashSet;
import java.util.List;

/**
 * Given a string s which represents an expression, evaluate this expression and
 * return its value.
 * 
 * The integer division should truncate toward zero.
 * 
 * You may assume that the given expression is always valid. All intermediate
 * results will be in the range of [-231, 231 - 1].
 * 
 * Note: You are not allowed to use any built-in function which evaluates
 * strings as mathematical expressions, such as eval().
 * 
 * 
 * Example 1:
 * 
 * Input: s = "3+2*2"
 * Output: 7
 */

public class BasicCalculatorII {

    //T: O(N), S: O(1)
    public int calculate(String equation) {
        if (equation.isEmpty()) return 0;

        HashSet<Character> opsSet = new HashSet<>(List.of('+', '-', '*', '/'));

        int result = 0;
        int currNum = 0, lastNum = 0;
        char operation = '+';

        for (int i = 0; i < equation.length(); i++) {
            char currChar = equation.charAt(i);

            if (Character.isDigit(currChar)) {
                currNum = (currNum * 10) + (currChar - '0');
            }

            if (opsSet.contains(currChar) || i == equation.length() - 1) {
                if (operation == '+') {
                    result += lastNum;
                    lastNum = currNum;
                } else if (operation == '-') {
                    result += lastNum;
                    lastNum = -currNum;
                } else if (operation == '*') {
                    lastNum *= currNum;
                } else if (operation == '/') {
                    lastNum /= currNum;
                }

                currNum = 0;
                operation = currChar;
            }
        }
        result += lastNum;

        return result;
    }

    public static void main(String[] args) {
        BasicCalculatorII basicCalculatorII = new BasicCalculatorII();
        System.out.println(basicCalculatorII.calculate("3+22*2"));
    }
}
