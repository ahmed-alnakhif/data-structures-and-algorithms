package Problems.dynamicProgramming;

import java.util.HashMap;
import java.util.Map;

public class ClimbingStairs {

    Map<Integer, Integer> memoMap = new HashMap<>();

    public int climbStairsMemo(int n) {
        if (memoMap.containsKey(n)) return memoMap.get(n);
        if(n==1) return 1;
        if(n==2) return 2;

        memoMap.put(n, climbStairsMemo(n - 1) + climbStairsMemo(n - 2));

        return memoMap.get(n);
    }
    
    public int climbStairsTab(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        
        return dp[n];
    }

    public static void main(String[] args) {
        ClimbingStairs cs = new ClimbingStairs();
        System.out.println(cs.climbStairsMemo(6)); 
        System.out.println(cs.climbStairsMemo(7)); 
        System.out.println(cs.climbStairsMemo(8)); 
        System.out.println(cs.climbStairsMemo(44));  
    }
}
