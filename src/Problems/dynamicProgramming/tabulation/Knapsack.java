package Problems.dynamicProgramming.tabulation;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two integer arrays to represent weights and profits of ‘N’ items, we
 * need to find a subset of these items which will give us maximum profit such
 * that their cumulative weight is not more than a given number ‘C.’ Each item
 * can only be selected once, which means either we put an item in the knapsack
 * or we skip it.
 */

public class Knapsack {
    Map<String, Integer> cache = new HashMap<String, Integer>();

    public int solveKnapsack(int[] profits, int[] weights, int capacity) {
        int[][] dp = new int[profits.length][capacity + 1];

        for (int cap = 0; cap <= capacity; cap++) {
            if (weights[0] <= cap) {
                dp[0][cap] = profits[0];
            }
        }

        //formula: 
        //dp[i][c] = max (dp[i-1][c], profit[i] + dp[i-1][c-weight[i]])
        for (int row = 1; row < dp.length; row++) {
            for (int cap = 1; cap < dp[0].length; cap++) {                
                int profitByNotPickingUpItem = dp[row - 1][cap]; //upper cell
                
                //if the item weight <= capacity, then [upper][cap - weight] + profit
                int profitByPickingUpItem = 0;
                if (weights[row] <= cap) { 
                    profitByPickingUpItem = profits[row] + dp[row - 1][cap - weights[row]];
                }

                dp[row][cap] = Math.max(profitByPickingUpItem, profitByNotPickingUpItem);
            }
        }

        return dp[profits.length - 1][capacity];
    }

    public static void main(String[] args) {
        Knapsack knapsack = new Knapsack();
        int[] profits = { 1, 6, 10, 16 };
        int[] weights = { 1, 2, 3, 5 };

        int maxProfit = knapsack.solveKnapsack(profits, weights, 7);
        System.out.println("Total knapsack profit ---> " + maxProfit);

        maxProfit = knapsack.solveKnapsack(profits, weights, 6);
        System.out.println("Total knapsack profit ---> " + maxProfit);
    }
}
