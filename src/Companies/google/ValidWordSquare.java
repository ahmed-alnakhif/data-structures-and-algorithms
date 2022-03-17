package Companies.google;

import java.util.List;

/**
 * Given an array of strings words, return true if it forms a valid word square.
 * 
 * A sequence of strings forms a valid word square if the kth row and column
 * read the same string, where 0 <= k < max(numRows, numColumns).
 * 
 * Input: words = ["abcd","bnrt","crmy","dtye"]
 * Output: true
 * Explanation:
 * The 1st row and 1st column both read "abcd".
 * The 2nd row and 2nd column both read "bnrt".
 * The 3rd row and 3rd column both read "crmy".
 * The 4th row and 4th column both read "dtye".
 * Therefore, it is a valid word square.
 */

public class ValidWordSquare {

    public boolean validWordSquare(List<String> words) {
        for (int i = 0; i < words.size(); i++) {
            for (int j = 0; j < words.get(i).length(); j++) {
                if (j >= words.size() ||
                        words.get(j).length() <= i ||
                        words.get(j).charAt(i) != words.get(i).charAt(j)) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        ValidWordSquare v = new ValidWordSquare();
        System.out.println(v.validWordSquare(List.of("abcd", "bnrt", "crmy", "dtye")));
    }
}
