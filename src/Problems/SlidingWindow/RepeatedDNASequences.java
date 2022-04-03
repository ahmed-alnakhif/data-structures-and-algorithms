package Problems.SlidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * The DNA sequence is composed of a series of nucleotides abbreviated as 'A',
 * 'C', 'G', and 'T'.
 * 
 * For example, "ACGAATTCCG" is a DNA sequence.
 * When studying DNA, it is useful to identify repeated sequences within the
 * DNA.
 * 
 * Given a string s that represents a DNA sequence, return all the
 * 10-letter-long sequences (substrings) that occur more than once in a DNA
 * molecule. You may return the answer in any order.
 * 
 * Example 1:
 * 
 * Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
 * Output: ["AAAAACCCCC","CCCCCAAAAA"]
 * Example 2:
 * 
 * Input: s = "AAAAAAAAAAAAA"
 * Output: ["AAAAAAAAAA"]
 */

public class RepeatedDNASequences {

    public List<String> findRepeatedDnaSequences(String s) {
        if (s.length() < 10)
            return new ArrayList<>();

        List<String> result = new LinkedList<>();
        HashMap<String, Integer> map = new HashMap<>();

        int left = 0, right = 9;

        while (right < s.length()) {
            String window = s.substring(left, right + 1);

            map.put(window, map.getOrDefault(window, 0) + 1);

            if (map.get(window) == 2) {
                result.add(window);
            }

            right++;
            left++;
        }

        return result;
    }

    public static void main(String[] args) {
        RepeatedDNASequences r = new RepeatedDNASequences();
        System.out.println(r.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
    }
}
