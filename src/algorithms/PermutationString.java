package algorithms;

import java.util.ArrayList;
import java.util.List;

public class PermutationString {
    public static class Solution {
        List<String> result = new ArrayList<>();

        private void swap(char[] chars, int i, int j){
            char tmp = chars[i];
            chars[i] = chars[j];
            chars[j] = tmp;
        }

        private void permute(char[] array, int left){
            if(left == array.length){
                result.add(String.valueOf(array));
                return;
            }

            for (int i = left; i < array.length; i++) {
                swap(array, left, i);
                permute(array, left+1);
                swap(array, left, i);
            }
        }

        private List<String> permutation(String str) {
            permute(str.toCharArray(), 0 );
            return result;
        }

        public void main(){
            String str = "abc";
            System.out.println(permutation(str));
        }
    }
}
