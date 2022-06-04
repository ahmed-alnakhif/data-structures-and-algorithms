package Problems.SlidingWindow;

/**
 * Given an array of positive numbers and a positive number ‘k,’ find the length
 * of the smallest contiguous subarray whose sum is greater than or equal to
 * ‘S’. Return 0 if no such subarray exists.
 * 
 * Example 1:
 * 
 * Input: [2, 1, 5, 2, 3, 2], k=7
 * Output: 2
 * Explanation: The smallest subarray with a sum greater than or equal to '7' is
 * [5, 2].
 */ //{ 2, 1, 5, 2, 8 }; 7

public class MinSizeSubArraySum {
    
    public int findMinSubArray(int[] arr, int k){
        int left = 0, right = 0;
        int sum = 0, min = Integer.MAX_VALUE;

        while(right < arr.length){
            sum += arr[right++];

            while(sum >= k){
                min = Math.min(min, right - left);
                sum -= arr[left++];
            }
        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }

    public int findMinSubArray2(int[] arr, int k) {
        int sum = arr[0];
        int left = 0, right = 0;
        int minLength = Integer.MAX_VALUE;

        while (left <= right && right < arr.length) {
            if (sum >= k) {
                minLength = Math.min(minLength, right - left + 1);
                sum -= arr[left++];
            } else {
                right++;
                if (right < arr.length) {
                    sum += arr[right];
                }
            }
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }


    public static void main(String[] args) {
        MinSizeSubArraySum f = new MinSizeSubArraySum();
        int[] arr1 = { 2, 1, 5, 2, 3, 2 };
        int S1 = 7;
        System.out.println(f.findMinSubArray(arr1, S1));
        int[] arr2 = { 3, 4, 1, 1, 6 };
        int S2 = 8;
        System.out.println(f.findMinSubArray(arr2, S2));
        int[] arr3 = { 2, 1, 5, 2, 8 };
        int S3 = 7;
        System.out.println(f.findMinSubArray(arr3, S3));
        int[] arr4 = { 1, 1, 1, 1, 1 };
        int S4 = 7;
        System.out.println(f.findMinSubArray(arr4, S4));
    }
}
