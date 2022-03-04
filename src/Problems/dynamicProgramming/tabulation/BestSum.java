package Problems.dynamicProgramming.tabulation;

import java.util.ArrayList;
import java.util.List;

/*
 return list of the smallest combination in the array that add up to the target number
*/

public class BestSum {

    static List<Integer> bestSum(int target, int[] nums) {
        List[] table = new List[target + 1];
        table[0] = new ArrayList<>();

        for (int i = 0; i < table.length; i++) {
            if (table[i] != null) {
                for (int option : nums) {
                    if (i + option < table.length) {
                        ArrayList<Integer> newList = new ArrayList<>(table[i]);
                        newList.add(option);
                        if (table[i + option] == null || newList.size() < table[i + option].size()) {
                            table[i + option] = newList;
                        }
                    }
                }
            }
        }

        return table[target];
    }

    public static void main(String[] args) {
        System.out.println(bestSum(7, new int[] { 5, 3, 4, 7 }));
        System.out.println(bestSum(8, new int[] { 2, 3, 5 }));
        System.out.println(bestSum(8, new int[] { 1, 4, 5 }));
        System.out.println(bestSum(100, new int[] { 1, 2, 5, 25 }));
        System.out.println(bestSum(100, new int[] { 25, 1, 2, 5 }));
    }
}
