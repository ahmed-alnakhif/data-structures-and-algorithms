package Problems.Permutations;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a string containing digits from 2-9 inclusive, return all possible
 * letter combinations that the number could represent. Return the answer in any
 * order.
 * 
 * A mapping of digit to letters (just like on the telephone buttons) is given
 * below. Note that 1 does not map to any letters.
 * 
 * Example:
 * Input: digits = "23"
 * Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
 */

public class LetterCombinationOfPhone {

    HashMap<Character, String> map = new HashMap<>();
    List<String> combination = new LinkedList<>();

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return new LinkedList<>();

        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        backtrack(0, "", digits);

        return combination;
    }

    private void backtrack(int index, String subString, String digits) {
        if (subString.length() == digits.length()) {
            combination.add(subString);
            return;
        }

        for (char c : map.get(digits.charAt(index)).toCharArray()) {
            backtrack(index + 1, subString + String.valueOf(c), digits);
        }
    }

    public void run() {
        String digits = "23";
        System.out.println(letterCombinations(digits));
    }
}
