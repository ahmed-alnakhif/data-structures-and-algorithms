package Problems.TwoPointers;

import java.util.Arrays;

/**
 * Given n non-negative integers representing an elevation map where the width
 * of each bar is 1,
 * compute how much water it can trap after raining.
 * 
 * Ex:
 * Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 * 
 * Explanation: The above elevation map (black section) is represented by array
 * [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section)
 * are being trapped.
 */

public class TrappingRainWater {
    public int trap(int[] height) {
        if (height.length == 0)
            return 0;

        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        int ans = 0;

        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);

            if (leftMax < rightMax) {
                ans += Math.max(0, leftMax - height[left++]);
            } else {
                ans += Math.max(0, rightMax - height[right--]);
            }
        }

        return ans;
    }

    //intuition: get max of left and right, then get min of both. 
    //result[i] = Math.min(maxLeft, maxRight) - height[i];
    public int trap2(int[] height) {
        int[] leftMaxArr = new int[height.length];
        int[] rightMaxArr = new int[height.length];
        int[] ans = new int[height.length];

        int leftMax = 0, rightMax = 0;

        for (int i = 1; i < height.length; i++) {
            leftMax = Math.max(leftMax, height[i-1]);
            leftMaxArr[i] = leftMax;
        }

        for(int i = height.length - 2; i>=0; i--){
            rightMax = Math.max(rightMax, height[i + 1]);
            rightMaxArr[i] = rightMax;
        }

        for (int i = 0; i < ans.length; i++) {
            ans[i] = Math.max(0, Math.min(leftMaxArr[i], rightMaxArr[i]) - height[i]);
        }

        return Arrays.stream(ans).sum();
    }

    public static void main(String[] args) {
        TrappingRainWater t = new TrappingRainWater();
        System.out.println(t.trap2(new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 }));
    }
}
