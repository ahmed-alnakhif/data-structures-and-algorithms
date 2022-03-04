package algorithms.other.recursion;

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

public class AllPermutations {
    public static class PermutationString {
        List<String> result = new ArrayList<>();

        private List<String> permutations(String str) {
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
    }

    public static class PermutationArray {
        static List<List<Integer>> result = new ArrayList<>();

        private static List<List<Integer>> permutations(int[] nums) {
            backtrack(nums, 0);
            return result;
        }

        private static void backtrack(int[] nums, int left) {
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

        private static void swap(int[] arr, int i, int j) {
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
    }

    // different approach
    public static class PermutationList {
        // T: O(N!), S: O(N^2)
        public static List<List<String>> permutations(List<String> elements) {
            // base case
            if (elements.isEmpty()) {
                List<String> list = new ArrayList<>();
                List<List<String>> res = new ArrayList<>();
                res.add(list);
                return res;
            }

            String firstEle = elements.get(0);
            List<String> rest = elements.subList(1, elements.size());

            List<List<String>> permutationsWithoutFirst = permutations(rest);
            List<List<String>> allPermutations = new ArrayList<>();

            // insert first at all possible position
            permutationsWithoutFirst.forEach(permList -> {
                for (int i = 0; i < permList.size() + 1; i++) {
                    List<String> prefix = permList.subList(0, i);
                    List<String> suffix = permList.subList(i, permList.size());

                    List<String> finalPermList = new ArrayList<>();
                    prefix.forEach(ele -> finalPermList.add(ele));
                    finalPermList.add(firstEle);
                    suffix.forEach(ele -> finalPermList.add(ele));
                    allPermutations.add(finalPermList);
                }
            });

            return allPermutations;
        }

    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };
        // System.out.println(PermutationArray.permutations(nums));
        System.out.println(PermutationList.permutations(List.of("1", "2", "3")));
    }

}
