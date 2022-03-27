package Companies.facebook;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * return the longest subsequence 
 * 
 * input : [2,0,3,4,4,5,7,1]
 * output : [2,3,4,5] => 4
 */

public class LongestIncreasingSubsequence {
    
    int longestIncreasingSubsequence(int[] nums){
        Map<Integer, Integer> countMap = new HashMap<>();
        for(int num : nums){
            if(countMap.containsKey(num - 1)){
                countMap.put(num, countMap.get(num - 1) + 1);
            } else {
                countMap.put(num, 1);
            }
        }

        return Collections.max(countMap.values());
    }

    public static void main(String[] args) {
        LongestIncreasingSubsequence lSubsequence = new LongestIncreasingSubsequence();
        System.out.println(lSubsequence.longestIncreasingSubsequence(new int[]{2,0,3,4,4,5,7,1}));
    }
}
