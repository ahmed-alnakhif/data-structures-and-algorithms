package Problems.GraphsProblems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * return the number of connected islands in a graph
 */

public class PacificAtlanticWaterFlow {

    Map<String, int[]> pacMap = new HashMap<>();
    Map<String, int[]> atlMap = new HashMap<>();

    boolean isValidCell(int[] cell, int[][] heights) {
        boolean rowInBounds = cell[0] >= 0 && cell[0] <= heights.length - 1;
        boolean colInBounds = cell[1] >= 0 && cell[1] <= heights[0].length - 1;
        return rowInBounds && colInBounds;
    }

    void dfs(int[] cell, int[] prevCell, Map<String, int[]> visitedMap, int[][] heights) {
        String key = String.valueOf(cell[0]) + "," + String.valueOf(cell[1]);
        int[] value = { cell[0], cell[1] };

        if (visitedMap.containsKey(key)) {
            return;
        }

        if (!isValidCell(cell, heights)) {
            return;
        }

        if (heights[cell[0]][cell[1]] < heights[prevCell[0]][prevCell[1]]) {
            return;
        }

        visitedMap.put(key, value);

        dfs(new int[] { cell[0] + 1, cell[1] }, value, visitedMap, heights);
        dfs(new int[] { cell[0] - 1, cell[1] }, value, visitedMap, heights);
        dfs(new int[] { cell[0], cell[1] + 1 }, value, visitedMap, heights);
        dfs(new int[] { cell[0], cell[1] - 1 }, value, visitedMap, heights);
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new LinkedList<>();

        // find all cell that can reach top and bottom oceans sides
        for (int col = 0; col < heights[0].length; col++) {
            dfs(new int[] { 0, col }, new int[] { 0, col }, pacMap, heights);
            dfs(new int[] { heights.length - 1, col }, new int[] { heights.length - 1, col }, atlMap, heights);
        }

        // find all cell that can reach left and right oceans sides
        for (int row = 0; row < heights.length; row++) {
            dfs(new int[] { row, 0 }, new int[] { row, 0 }, pacMap, heights);
            dfs(new int[] { row, heights[0].length - 1 }, new int[] { row, heights[0].length - 1 }, atlMap, heights);
        }

        // return intersected cells that can reach pac ocean and atl ocean
        for (Map.Entry<String, int[]> entry : pacMap.entrySet()) {
            if (atlMap.containsKey(entry.getKey())) {
                result.add(Arrays.asList(entry.getValue()[0], entry.getValue()[1]));
            }
        }

        return result;
    }

    public void run() {
        int[][] heights = {{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
        System.out.println(pacificAtlantic(heights));
    }
}
