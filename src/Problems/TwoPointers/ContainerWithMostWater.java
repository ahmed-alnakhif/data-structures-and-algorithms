package Problems.TwoPointers;

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

    int getArea(int height, int width) {
        return height * width;
    }

    public int maxArea(int[] heights) {
        int left = 0, right = heights.length - 1;

        int maxArea = 0;
        int minCol = 0;

        while (left < right) {
            minCol = Math.min(heights[left], heights[right]);
            maxArea = Math.max(maxArea, getArea(minCol, right - left));

            if (heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {
        ContainerWithMostWater c = new ContainerWithMostWater();
        System.out.println(c.maxArea(new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 }));
    }
}
