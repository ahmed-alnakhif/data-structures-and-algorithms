package Problems.dynamicProgramming.tabulation;

/*
 return true if 2 numbers in the array can sum up to the target number
*/

public class CanSum {

    static boolean canSum(int targetSum, int[] nums) {
        boolean[] table = new boolean[targetSum + 1];
        table[0] = true;

        for (int i = 0; i < table.length; i++) {
            if (table[i] == true) {
                for (int num : nums) {
                    if (i + num < table.length) {
                        table[i + num] = true;
                    }
                }
            }
        }

        return table[targetSum];
    }

    public static void main(String[] args) {
        System.out.println(canSum(7, new int[] { 2, 3 })); // true
        System.out.println(canSum(7, new int[] { 2, 3, 4, 7 })); // true
        System.out.println(canSum(7, new int[] { 2, 4 })); // false
        System.out.println(canSum(8, new int[] { 2, 3, 5 })); // true
        System.out.println(canSum(300, new int[] { 7, 14 })); // false
    }
}
