package Problems.SlidingWindow;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

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
        Set<String> result = new HashSet<>();
        Set<String> seen = new HashSet<>();

        int left = 0, right = 9;

        while (right < s.length()) {
            String window = s.substring(left, right + 1);

            if (seen.contains(window)) {
                result.add(window);
            }

            seen.add(window);

            right++;
            left++;
        }

        return new ArrayList<>(result);
    }

    public static void main(String[] args) {
        RepeatedDNASequences r = new RepeatedDNASequences();
        System.out.println(r.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
    }
}
