package Problems.DynamicProgramming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 return list of the shortest combination in the array that add up to the target number
*/

public class BestSum {

    static Map<Integer, List<Integer>> memoMap;
    ArrayList<Integer> shortedList;

    static List<Integer> bestSum(int target, int[] nums) {
        memoMap = new HashMap<>();
        return smallestSum(target, nums);
    }

    static List<Integer> smallestSum(int target, int[] nums) {
        if (target == 0) {
            return new ArrayList<>();
        }

        if (target < 0) {
            return null;
        }

        if (memoMap.containsKey(target)) {
            return memoMap.get(target);
        }

        List<Integer> shortedCombination = null;

        for (int num : nums) {
            int remainder = target - num;
            List<Integer> combination = smallestSum(remainder, nums);
            if (combination != null) {
                combination.add(num);
                if (shortedCombination == null || combination.size() < shortedCombination.size()) {
                    shortedCombination = new ArrayList<Integer>(combination);;
                }
            }
        }

        memoMap.put(target, shortedCombination);

        return shortedCombination;
    }

    public static void main(String[] args) {
        System.out.println(bestSum(7, new int[] { 5, 3, 4, 7 }));
        System.out.println(bestSum(8, new int[] { 2, 3, 5 }));
        System.out.println(bestSum(8, new int[] { 1, 4, 5 }));
        System.out.println(bestSum(100, new int[] { 1, 2, 5, 25 })); // not correct
    }
}
