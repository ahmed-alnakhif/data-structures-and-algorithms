package Problems.dynamicProgramming.memoization;

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
        return solveKnapSackHelper(profits, weights, capacity, 0);
    }

    public int solveKnapSackHelper(int[] profits, int[] weights, int capacity, int index) {
        // base case:
        if (capacity <= 0 || index >= weights.length) {
            return 0;
        }

        // check cache
        String key = capacity + "," + index;
        if (cache.containsKey(key)) {
            return cache.get(key);
        }

        // recursive case:
        int profitByPickingUpItem = 0;
        if (weights[index] <= capacity) {
            profitByPickingUpItem = profits[index]
                    + solveKnapSackHelper(profits, weights, capacity - weights[index], index + 1);
        }

        int profitByNotPickingUpItem = solveKnapSackHelper(profits, weights, capacity, index + 1);

        int maxProfit = Math.max(profitByPickingUpItem, profitByNotPickingUpItem);
        cache.put(key, maxProfit);
        
        return maxProfit;
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
