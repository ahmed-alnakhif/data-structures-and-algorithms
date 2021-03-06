package Problems.Sequences;

import java.util.HashSet;

/**
 * Given a string s, return the number of palindromic substrings in it.
 * 
 * A string is a palindrome when it reads the same backward as forward.
 * 
 * A substring is a contiguous sequence of characters within the string.
 * 
 * 
 * Example 1:
 * 
 * Input: s = "abc"
 * Output: 3
 * Explanation: Three palindromic strings: "a", "b", "c"
 * 
 */

public class PalindromicSubstrings {
    HashSet<String> set = new HashSet<>();

    public int countSubstrings2(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            String sub = "";
            for (int j = i; j < s.length(); j++) {
                sub += String.valueOf(s.charAt(j));
                if (isPalindrome(sub)) {
                    set.add(sub);
                    count++;
                }
            }
        }

        return count;
    }

    boolean isPalindrome(String str) {
        if (set.contains(str)) {
            return true;
        }

        for (int left = 0, right = str.length() - 1; left < right; left++, right--) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Palindromes are like onions, you remove the boundary characters and you're
     * left with another, smaller palindrome.
     */
    public int countSubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            // for odds
            count += palindromeAroundCenter(i, i, s);
            // for even
            count += palindromeAroundCenter(i, i + 1, s);
        }
        return count;
    }

    int palindromeAroundCenter(int left, int right, String str) {
        int count = 0;
        while (left >= 0 && right < str.length()) {
            if (str.charAt(left) != str.charAt(right)) {
                break;
            }
            count++;

            left--;
            right++;
        }

        return count;
    }

   public static void main(String[] args) {
        PalindromicSubstrings p = new PalindromicSubstrings();
        System.out.println(p.countSubstrings("abcddcba"));
    }
}
