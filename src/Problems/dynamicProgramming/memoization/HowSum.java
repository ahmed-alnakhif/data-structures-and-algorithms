package Problems.dynamicProgramming.memoization;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 return list of combination of 2 numbers in the array that add up to the target number
*/

public class HowSum {

    Map<Integer, List<Integer>> memoMap;

    List<Integer> howSum(int target, int[] nums) {
        memoMap = new HashMap<>();
        List<Integer> result = howSumHelper(target, nums);
        
        return result == null ? new ArrayList<>() : result;
    }

    List<Integer> howSumHelper(int target, int[] nums) {
        if (target == 0) return new ArrayList<>();
        if (target < 0) return null;
        if (memoMap.containsKey(target)) return memoMap.get(target);

        for (int num : nums) {
            int remainder = target - num;
            List<Integer> list = howSumHelper(remainder, nums);

            if (list != null) {
                list.add(num);
                memoMap.put(target, list);
                return list;
            }
        }

        memoMap.put(target, null);

        return null;
    }

    public static void main(String[] args) {
        HowSum h = new HowSum();
        // System.out.println(h.howSum(7, new int[] { 2, 3 }));
        // System.out.println(h.howSum(7, new int[] { 5, 3, 4, 7 }));
        // System.out.println(h.howSum(7, new int[] { 2, 4 }));
        // System.out.println(h.howSum(8, new int[] { 2, 3, 5 }));
        // System.out.println(h.howSum(300, new int[] { 7, 14 }));
        System.out.println(h.howSum(4, new int[] { 1, 1, 2, 3 }));
    }
}
