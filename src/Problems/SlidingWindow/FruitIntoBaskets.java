package Problems.SlidingWindow;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Given an integer array nums, return true if any value appears at least twice
 * in the array, and return false if every element is distinct.
 * 
 * Example 1:
 * 
 * Input: nums = [1,2,3,1]
 * Output: true
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
