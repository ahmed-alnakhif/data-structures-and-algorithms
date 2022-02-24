package Problems.Graphs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * There is an m x n rectangular island that borders both the Pacific Ocean and
 * Atlantic Ocean. The Pacific Ocean touches the island's left and top edges,
 * and the Atlantic Ocean touches the island's right and bottom edges.
 * 
 * The island is partitioned into a grid of square cells. You are given an m x n
 * integer matrix heights where heights[r][c] represents the height above sea
 * level of the cell at coordinate (r, c).
 * 
 * The island receives a lot of rain, and the rain water can flow to neighboring
 * cells directly north, south, east, and west if the neighboring cell's height
 * is less than or equal to the current cell's height. Water can flow from any
 * cell adjacent to an ocean into the ocean.
 * 
 * Return a 2D list of grid coordinates result where result[i] = [ri, ci]
 * denotes that rain water can flow from cell (ri, ci) to both the Pacific and
 * Atlantic oceans.
 * 
 * Input: heights = [[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]
 * Output: [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]
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
        int[][] heights = { { 1, 2, 2, 3, 5 }, { 3, 2, 3, 4, 4 }, { 2, 4, 5, 3, 1 }, { 6, 7, 1, 4, 5 },
                { 5, 1, 1, 2, 4 } };
        System.out.println(pacificAtlantic(heights));
    }
}
