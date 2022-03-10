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
 */

public class MinSizeSubArraySum {

    public static int findMinSubArray(int[] arr, int k) {
        int sum = arr[0];
        int left = 0, right = 0;
        int min = Integer.MAX_VALUE;

        while (left <= right && right < arr.length) {

            if (sum >= k) {
                int windowSize = right - left + 1;
                min = Math.min(min, windowSize);
                sum = sum - arr[left];
                left++;
            } else {
                right++;
                if(right < arr.length){
                    sum = sum + arr[right];
                }
            }

        }

        return min;
    }

    public void run() {
        int[] arr1 = { 2, 1, 5, 2, 3, 2 };
        int S1 = 7;
        System.out.println(findMinSubArray(arr1, S1));
        int[] arr2 = { 3, 4, 1, 1, 6 };
        int S2 = 8;
        System.out.println(findMinSubArray(arr2, S2));
        int[] arr3 = { 2, 1, 5, 2, 8 };
        int S3 = 7;
        System.out.println(findMinSubArray(arr3, S3));
    }
}
