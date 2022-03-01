package Problems.DynamicProgramming;

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
        return howSumHelper(target, nums);
    }

    List<Integer> howSumHelper(int target, int[] nums) {
        if (target == 0) {
            return new ArrayList<>();
        }

        if (target < 0) {
            return null;
        }

        if (memoMap.containsKey(target)) {
            return memoMap.get(target);
        }

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

    public void run() {
        System.out.println(howSum(7, new int[] { 2, 3 }));
        System.out.println(howSum(7, new int[] { 5, 3, 4, 7 }));
        System.out.println(howSum(7, new int[] { 2, 4 }));
        System.out.println(howSum(8, new int[] { 2, 3, 5 }));
        System.out.println(howSum(300, new int[] { 7, 14 }));
    }
}
