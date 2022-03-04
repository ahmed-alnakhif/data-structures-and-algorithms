package Problems.dynamicProgramming.tabulation;

import java.util.ArrayList;
import java.util.List;

/*
 return a combination of 2 numbers in the array that add up to the target number
*/

public class HowSum {

    // T: O(n * m^2), S: O(m^2)
    static List<Integer> howSum(int target, int[] nums) {
        List[] table = new List[target + 1];
        table[0] = new ArrayList<>();

        for (int i = 0; i < table.length; i++) {
            if (table[i] != null) {
                for (int num : nums) {
                    if (i + num < table.length) {
                        // replace list at index i + num with with list at index i + num
                        List<Integer> list = new ArrayList<>(table[i]);
                        list.add(num);
                        table[i+num] = list;
                    }
                }
            }
        }

        return table[target];
    }

    public static void main(String[] args) {
        System.out.println(howSum(7, new int[] { 2, 3 }));
        System.out.println(howSum(7, new int[] { 5, 3, 4 }));
        System.out.println(howSum(7, new int[] { 2, 4 }));
        System.out.println(howSum(8, new int[] { 2, 3, 5 }));
        System.out.println(howSum(300, new int[] { 7, 14 }));
    }
}
