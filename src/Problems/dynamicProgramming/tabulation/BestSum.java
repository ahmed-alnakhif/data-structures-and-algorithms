package Problems.dynamicProgramming.tabulation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 return list of the shortest combination in the array that add up to the target number
*/

public class BestSum {

    static List<Integer> bestSum(int target, int[] nums) {
        
    }

  

    public static void main(String[] args) {
        System.out.println(bestSum(7, new int[] { 5, 3, 4, 7 }));
        System.out.println(bestSum(8, new int[] { 2, 3, 5 }));
        System.out.println(bestSum(8, new int[] { 1, 4, 5 }));
        System.out.println(bestSum(100, new int[] { 1, 2, 5, 25 })); // not correct
    }
}
