package Problems.Permutations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Given an array nums of distinct integers, return all the possible
 * permutations. You can return the answer in any order.
 * 
 * Example 1:
 * 
 * Input: nums = [1,2,3]
 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 */

public class Permutation {
    public static class PermutationString {
        List<String> result = new ArrayList<>();

        private List<String> permutation(String str) {
            backtrack(str.toCharArray(), 0);
            return result;
        }

        private void backtrack(char[] array, int left) {
            if (left == array.length) {
                result.add(String.valueOf(array));
                return;
            }

            for (int i = left; i < array.length; i++) {
                swap(array, left, i);
                backtrack(array, left + 1);
                swap(array, left, i);
            }
        }

        private void swap(char[] chars, int i, int j) {
            char tmp = chars[i];
            chars[i] = chars[j];
            chars[j] = tmp;
        }

        public void run() {
            String str = "abc";
            System.out.println(permutation(str));
        }
    }

    public static class PermutationArray {
        List<List<Integer>> result = new ArrayList<>();

        private List<List<Integer>> permutation(int[] nums) {
            backtrack(nums, 0);
            return result;
        }

        private void backtrack(int[] nums, int left) {
            if (left == nums.length) {
                result.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
                return;
            }

            for (int i = left; i < nums.length; i++) {
                swap(nums, left, i);
                backtrack(nums, left + 1);
                swap(nums, left, i);
            }
        }

        private void swap(int[] arr, int i, int j) {
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }

        public void run() {
            int[] nums = { 1, 2, 3 };
            System.out.println(permutation(nums));
        }
    }
}
