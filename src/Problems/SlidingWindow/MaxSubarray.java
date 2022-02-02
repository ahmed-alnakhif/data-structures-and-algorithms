package Problems.SlidingWindow;


/**
 * Given an integer array nums, find the contiguous subarray (containing at
 * least one number) which has the largest sum and return its sum.
 * 
 * A subarray is a contiguous part of an array.
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 */

public class MaxSubarray {

    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int sum = 0;
        
        for(int num : nums){
            if(sum < 0){
                sum = 0;
            }
            sum = sum + num;
            max = Math.max(max, sum);
        }
        
        return max;
    }

    public void run() {
        int[] nums = { -2,1,-3,4,-1,2,1,-5,4 };
        System.out.println(maxSubArray(nums));
    }
}
