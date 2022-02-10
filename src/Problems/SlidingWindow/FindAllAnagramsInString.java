package Problems.SlidingWindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given two strings s and p, return an array of all the start indices of p's
 * anagrams in s. You may return the answer in any order.
 * 
 * An Anagram is a word or phrase formed by rearranging the letters of a
 * different word or phrase, typically using all the original letters exactly
 * once.
 * 
 * 
 * Example 1:
 * 
 * Input: s = "cbaebabacd", p = "abc"
 * Output: [0,6]
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of "abc".
 */

public class FindAllAnagramsInString {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        
        Map<Character, Integer> pCount = new HashMap<>();
        Map<Character, Integer> sCount = new HashMap<>();
        
        for(char ch : p.toCharArray()){
            pCount.put(ch, pCount.getOrDefault(ch, 0)+1);
        }
        
        
        int left = 0, right = 0;
        while(right < s.length()){
            char currChar = s.charAt(right);
            sCount.put(currChar, sCount.getOrDefault(currChar, 0)+1);
            
            //if we reached max window size, remove or decrement LMC
            if(right >= p.length()){
                char leftMostChar = s.charAt(left);
                if(sCount.get(leftMostChar) == 1){
                    sCount.remove(leftMostChar);
                } else {
                    sCount.put(leftMostChar, sCount.get(leftMostChar)-1);
                }
                left++;
            }
            
            //if both maps are the same then we anagram
            if(pCount.equals(sCount)){
                result.add(left);
            }
            
            right++;
        }
        
        return result;
    }

    //not very effecient
    public List<Integer> findAnagrams2(String s, String p) {
        List<Integer> result = new ArrayList<>();

        p = sort(p);

        int left = 0, right = p.length() - 1;
        while (right < s.length()) {
            String sub = sort(s.substring(left, right + 1));
            if (p.equals(sub)) {
                result.add(left);
            }
            right++;
            left++;
        }

        return result;
    }
    private String sort(String str) {
        char[] arr = str.toCharArray();
        Arrays.sort(arr);
        return String.valueOf(arr);
    }

    public void run() {
        String s = "cbaebabacd";
        String p = "abc";
        System.out.println(findAnagrams(s, p));
    }
}