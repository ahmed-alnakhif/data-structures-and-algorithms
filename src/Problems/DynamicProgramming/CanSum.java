package Problems.DynamicProgramming;

/*
 return true if 2 numbers in the array can sum up to the target number
*/

public class CanSum {

    boolean canSum(int target, int[] nums) {

    }

    public void run() {
        System.out.println(canSum(7, new int[] { 2, 3 })); // true
        System.out.println(canSum(7, new int[] { 2, 3, 4, 7 })); // true
        System.out.println(canSum(7, new int[] { 2, 4 })); // false
        System.out.println(canSum(8, new int[] { 2, 3, 5 })); // true
        System.out.println(canSum(300, new int[] { 7, 14 })); // true
    }
}
