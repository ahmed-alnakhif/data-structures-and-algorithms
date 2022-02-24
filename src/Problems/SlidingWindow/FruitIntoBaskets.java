package Problems.SlidingWindow;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * You are visiting a farm that has a single row of fruit trees arranged from
 * left to right. The trees are represented by an integer array fruits where
 * fruits[i] is the type of fruit the ith tree produces.
 * 
 * You want to collect as much fruit as possible. However, the owner has some
 * strict rules that you must follow:
 * 
 * You only have two baskets, and each basket can only hold a single type of
 * fruit. There is no limit on the amount of fruit each basket can hold.
 * Starting from any tree of your choice, you must pick exactly one fruit from
 * every tree (including the start tree) while moving to the right. The picked
 * fruits must fit in one of your baskets.
 * Once you reach a tree with fruit that cannot fit in your baskets, you must
 * stop.
 * Given the integer array fruits, return the maximum number of fruits you can
 * pick.
 * 
 * 
 * Example 1:
 * 
 * Input: fruits = [1,2,1]
 * Output: 3
 * Explanation: We can pick from all 3 trees.
 */

public class FruitIntoBaskets {

    public int totalFruit(int[] fruits) {
        if (fruits.length == 0)
            return 0;

        Map<Integer, Integer> map = new LinkedHashMap<>();
        int maxLen = 0;
        int left = 0, right = 0;

        while (right < fruits.length) {
            if (map.containsKey(fruits[right])) {
                map.remove(fruits[right]);
            }
            map.put(fruits[right], right);

            if (map.size() > 2) {
                Map.Entry<Integer, Integer> leftMostFruit = map.entrySet().iterator().next();
                map.remove(leftMostFruit.getKey());
                left = leftMostFruit.getValue() + 1;
            }

            right++;

            maxLen = Math.max(maxLen, right - left);
        }

        return maxLen;
    }

    public void run() {
        int[] fruits = { 1, 2, 1 };

        System.out.println(totalFruit(fruits));
    }
}
