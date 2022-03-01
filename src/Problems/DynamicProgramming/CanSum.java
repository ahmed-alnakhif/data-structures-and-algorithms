package Problems.DynamicProgramming;

import java.util.HashMap;
import java.util.Map;

/*
 return true if 2 numbers in the array can sum up to the target number
*/

public class CanSum {

    Map<Integer, Boolean> memoMap = new HashMap<>();

    boolean targetSum(int target, int[] nums) {
        boolean result = canSum(target, nums);
        memoMap.clear();
        return result;
    }

    boolean canSum(int target, int[] nums) {
        if (memoMap.containsKey(target)) {
            return memoMap.get(target);
        }

        if (target == 0) {
            return true;
        }

        if (target < 0) {
            return false;
        }

        for (int num : nums) {
            int remainder = target - num;
            if (canSum(remainder, nums)) {
                memoMap.put(target, true);
                return true;
            }
        }

        memoMap.put(target, false);
        return false;
    }

    public void run() {
        System.out.println(targetSum(7, new int[] { 2, 3 })); // true
        System.out.println(targetSum(7, new int[] { 2, 3, 4, 7 })); // true
        System.out.println(targetSum(7, new int[] { 2, 4 })); // false
        System.out.println(targetSum(8, new int[] { 2, 3, 5 })); // true
        System.out.println(targetSum(300, new int[] { 7, 14 })); // false
    }
}
