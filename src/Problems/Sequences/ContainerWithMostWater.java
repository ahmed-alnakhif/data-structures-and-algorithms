package Problems.Sequences;

/**
 * You are given an integer array height of length n. There are n vertical lines
 * drawn such that the two endpoints of the ith line are (i, 0) and (i,
 * height[i]).
 * 
 * Find two lines that together with the x-axis form a container, such that the
 * container contains the most water.
 * 
 * Return the maximum amount of water a container can store.
 */

public class ContainerWithMostWater {

    private int getArea(int height, int length) {
        return height * length;

    }

    public int maxArea(int[] height) {
        int n = height.length - 1;
        int left = 0;
        int right = n;
        int minCol = Math.min(height[left], height[right]);
        int maxArea = getArea(minCol, n);

        while (left < right) {
            minCol = Math.min(height[left], height[right]);
            maxArea = Math.max(maxArea, getArea(minCol, right - left));
            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }

    public void run() {
        int[] nums = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
        System.out.println(maxArea(nums));
    }
}
