package Problems.Sequences;

import java.util.HashMap;

/**
 * Given an array of integers nums and an integer k, return the total number of
 * continuous subarrays whose sum equals to k.
 * 
 * Example 1:
 * 
 * Input: nums = [1,1,1], k = 2
 * Output: 2
 *
 *  
 * Example 2:
 *
 * Input: nums = [1,2,3], k = 3
 * Output: 2
 */

public class SubarraySumEqualsK {

    //Time: O(N^2)
    public int subarraySum1(int[] nums, int k) {
        HashMap<Integer, int[]> map = new HashMap<>();
        int count = 0;
        
        for(int i=0; i<nums.length; i++){
            int sum = 0;
            for(int j = i; j<nums.length; j++){
                sum = sum + nums[j];
                if(sum == k) count++;
            }
        }
        
        return count;
    }

    //Time: O(N)
    public int subarraySum2(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0, sum = 0;
        
        map.put(0, 1);
        for(int i=0; i<nums.length; i++){
            sum += nums[i];
            if(map.containsKey(sum - k)){
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) +1);
        }
        
        return count;
    }

    public void run() {
        int[] nums = { 7, 1, 5, -3, 6, 4 };
        int k = 5;
        System.out.println(subarraySum2(nums, k));
    }
}
