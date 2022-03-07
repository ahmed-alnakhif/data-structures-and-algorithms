package Problems.Sequences;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array of distinct integers arr, find all pairs of elements with the
 * minimum absolute difference of any two elements.
 * 
 * Return a list of pairs in ascending order(with respect to pairs), each pair
 * [a, b] follows
 * 
 * a, b are from arr
 * a < b
 * b - a equals to the minimum absolute difference of any two elements in arr
 * 
 * 
 * Example 1:
 * 
 * Input: arr = [4,2,1,3]
 * Output: [[1,2],[2,3],[3,4]]
 * Explanation: The minimum absolute difference is 1. List all pairs with
 * difference equal to 1 in ascending order.
 */

public class MinimumAbsoluteDifference {

    public static List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(arr);

        int minPairDiff = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length - 1; i++) {
            int currPairDiff = arr[i + 1] - arr[i];

            if (currPairDiff == minPairDiff) {
                result.add(new ArrayList<>(List.of(arr[i], arr[i + 1])));
            }

            else if (currPairDiff < minPairDiff) {
                result.clear();
                result.add(new ArrayList<>(List.of(arr[i], arr[i + 1])));
                minPairDiff = currPairDiff;
            }
        }

        return result;

    }

    public static void main(String[] args) {
        System.out.println(minimumAbsDifference(new int[] { 4, 2, 1, 3 }));
    }
}
