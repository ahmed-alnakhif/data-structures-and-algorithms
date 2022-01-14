package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Combination {
    public static class Solution {
        List<List<Integer>> result = new ArrayList<>();

        private void swap(int[] arr, int i, int j){
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }

        private List<List<Integer>> combination(int[] nums){

            return result;
        }

        public void main(){
            int[] nums = {1,2,3};
            System.out.println(combination(nums));
        }
    }
}
