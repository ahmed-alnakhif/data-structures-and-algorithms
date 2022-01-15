package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Permutation {
    public static class PermutationString {
        List<String> result = new ArrayList<>();

        private void swap(char[] chars, int i, int j) {
            char tmp = chars[i];
            chars[i] = chars[j];
            chars[j] = tmp;
        }

        private void permute(char[] array, int left) {
            if (left == array.length) {
                result.add(String.valueOf(array));
                return;
            }

            for (int i = left; i < array.length; i++) {
                swap(array, left, i);
                permute(array, left + 1);
                swap(array, left, i);
            }
        }

        private List<String> permutation(String str) {
            permute(str.toCharArray(), 0);
            return result;
        }

        public void main() {
            String str = "abc";
            System.out.println(permutation(str));
        }
    }

    public static class PermutationList {
        List<List<Integer>> result = new ArrayList<>();

        private void swap(int[] arr, int i, int j) {
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }

        private void permute(int[] nums, int left) {
            if (left == nums.length) {
                result.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
                return;
            }

            for (int i = left; i < nums.length; i++) {
                swap(nums, left, i);
                permute(nums, left + 1);
                swap(nums, left, i);
            }
        }

        private List<List<Integer>> permutation(int[] nums) {
            permute(nums, 0);
            return result;
        }

        public void main() {
            int[] nums = { 1, 2, 3 };
            System.out.println(permutation(nums));
        }
    }
}
