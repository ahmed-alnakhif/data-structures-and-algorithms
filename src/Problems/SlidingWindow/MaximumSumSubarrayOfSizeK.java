package Problems.SlidingWindow;

/**
 * Given an array of positive numbers and a positive number ‘k,’ find the
 * maximum sum of any contiguous subarray of size ‘k’.
 * 
 * Example 1:
 * 
 * Input: [2, 1, 5, 1, 3, 2], k=3
 * Output: 9
 * Explanation: Subarray with maximum sum is [5, 1, 3].
 */

//8, 7,
public class MaximumSumSubarrayOfSizeK {

    public int maxSubArraySum(int[] arr, int k) {
        int maxSum = 0;
        int sum = 0;
        int left = 0, right = 0;

        while (right < k) {
            sum += arr[right++];
        }
        maxSum = sum;

        while (right < arr.length) {
            sum = sum - arr[left++] + arr[right++];
            maxSum = Math.max(maxSum, sum);
        }

        return maxSum;
    }

    public int maxSum(int[] arr, int k){
        int left = 0, right = 0;
        int sum = 0, max = 0;
        
        while(right < arr.length){
            sum += arr[right];
            if(right >= k){
                sum -= arr[left++];
            }
            max = Math.max(max, sum);
            right++;
        }
        
        return max;
    }

    public static void main(String[] args) {
        MaximumSumSubarrayOfSizeK mOfSizeK = new MaximumSumSubarrayOfSizeK();
        System.out.println(mOfSizeK.maxSum(new int[]{ 2, 1, 5, 1, 3, 2 }, 3));
    }
}
