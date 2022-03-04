package algorithms.other;

import java.util.LinkedList;
import java.util.List;

/**
 * Given two integers n and k, return all possible combinations of k numbers out
 * of the range [1, n].
 * 
 * You may return the answer in any order.
 * 
 * 
 * Example 1:
 * 
 * Input: n = 4, k = 2
 * Output:
 * [ [2,4], [3,4], [2,3], [1,2], [1,3], [1,4] ]
 */

public class Combination {
    
    //T: O(N^2), S: O(N^2)

    public List<List<Integer>> combination(int n, int k) {
        combine(1, n, k, new LinkedList<>());
        return null;
    }

    private void combine(int start, int n, int k, LinkedList<Integer> comb) {
       
    }

    public void run() {
        // System.out.println(combination(n, k));
    }
}
