package Problems.dynamicProgramming;

/**
 * You are given an integer array cost where cost[i] is the cost of ith step on
 * a staircase. Once you pay the cost, you can either climb one or two steps.
 * 
 * You can either start from the step with index 0, or the step with index 1.
 * 
 * Return the minimum cost to reach the top of the floor.
 * 
 * 
 * Example 1:
 * 
 * Input: cost = [10,15,20]
 * Output: 15
 * Explanation: You will start at index 1.
 * - Pay 15 and climb two steps to reach the top.
 * The total cost is 15.
 */

public class MinCostClimbingStairs {

    public int minCostClimbingStairs(int[] cost) {
        if(cost.length == 1) return cost[0];
        
        int[] minCost = new int[cost.length+1];
        
        for (int i = 2; i < minCost.length; i++) {
            int takeOneStep = minCost[i - 1] + cost[i - 1];
            int takeTwoSteps = minCost[i - 2] + cost[i - 2];

            minCost[i] = Math.min(takeOneStep, takeTwoSteps);
        }
        
        return minCost[minCost.length-1];
        
    }
    public static void main(String[] args) {
        MinCostClimbingStairs mccs = new MinCostClimbingStairs();
        System.out.println(mccs.minCostClimbingStairs(new int[] {10,15,20}));
    }
}