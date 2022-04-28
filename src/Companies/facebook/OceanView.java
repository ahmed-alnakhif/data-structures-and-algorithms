package Companies.facebook;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * There are n buildings in a line. You are given an integer array heights of
 * size n that represents the heights of the buildings in the line.
 * 
 * The ocean is to the right of the buildings. A building has an ocean view if
 * the building can see the ocean without obstructions. Formally, a building has
 * an ocean view if all the buildings to its right have a smaller height.
 * 
 * Return a list of indices (0-indexed) of buildings that have an ocean view,
 * sorted in increasing order.
 * 
 * 
 * Example 1:
 * 
 * Input: heights = [4,2,3,1]
 * Output: [0,2,3]
 * Explanation: Building 1 (0-indexed) does not have an ocean view because
 * building 2 is taller.
 */

public class OceanView {

    public int[] findBuildings(int[] heights) {
        ArrayList<Integer> result = new ArrayList<>();
        int max = Integer.MIN_VALUE;

        for (int i = heights.length - 1; i >= 0; i--) {
            if (heights[i] > max) {
                result.add(i);
                max = heights[i];
            }
        }

        int[] res = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            res[i] = result.get(result.size() - 1 - i);
        }
        return res;
    }

    public static void main(String[] args) {
        OceanView oceanView = new OceanView();
        System.out.println(Arrays.toString(oceanView.findBuildings(new int[] { 4, 2, 3, 1 })));
    }
}
