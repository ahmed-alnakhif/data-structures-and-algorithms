package Problems.dynamicProgramming.tabulation;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an integer n, return the number of structurally unique BST's (binary
 * search trees) which has exactly n nodes of unique values from 1 to n.
 * 
 * Example 1:
 * Input: n = 3
 * Output: 5
 * 
 * Example 2:
 * Input: n = 1
 * Output: 1
 */

public class UniqueBinarySearchTrees {

    // tabulation
    public static int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i < dp.length; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }

        return dp[n];
    }

    // using Catalan number formula
    public int numTrees2(int n) {
        // Note: we should use long here instead of int to avoid overflow
        long C = 1;
        for (int i = 0; i < n; ++i) {
            C = C * 2 * (2 * i + 1) / (i + 2);
        }
        return (int) C;
    }

    // memoization
    Map<Integer, Integer> cache = new HashMap<>();  
    public int numTrees3(int n) {
        if (n <= 1) {
            return 1;
        }

        int total = 0;
        for (int i = 1; i < n + 1; i++) {
            int countOfLeftSubtrees = cache.getOrDefault(i-1, numTrees(i - 1));
            int countOfRightSubtrees = cache.getOrDefault(n-i, numTrees(n - i));
            total += (countOfLeftSubtrees * countOfRightSubtrees);
        }

        cache.put(n, total);
       
        return total;
    }

    public static void main(String[] args) {
        System.out.println(numTrees(5));
    }
}
