package Problems.GraphsProblems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * return the number of connected component in a graph
 */

public class IslandCount {
    HashSet<String> visited = new HashSet<>();

    boolean isLand(Character[][] grid, int row, int col) {
        return grid[row][col] == 'L';
    }

    boolean isValidCell(Character[][] grid, int row, int col) {
        boolean rowInBounds = 0 <= row && row <= grid.length - 1;
        boolean colInBounds = 0 <= col && col <= grid[0].length - 1;
        return rowInBounds && colInBounds;
    }

    String stringfySet(int row, int col) {
        return String.valueOf(row) + "," + String.valueOf(col);
    }

    boolean dfs(Character[][] grid, int row, int col) {
        if (!isValidCell(grid, row, col)) {
            return false;
        }

        if (!isLand(grid, row, col)) {
            return false;
        }

        if (visited.contains(stringfySet(row, col))) {
            return false;
        }

        visited.add(stringfySet(row, col));

        dfs(grid, row - 1, col);
        dfs(grid, row + 1, col);
        dfs(grid, row, col - 1);
        dfs(grid, row, col + 1);

        return true;
    }

    int islandCount(Character[][] grid) {
        int count = 0;

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (dfs(grid, row, col) == true) {
                    count++;
                }
            }
        }

        return count;
    }

    Character[][] generateGrid() {
        Character[][] grid = {
                { 'W', 'L', 'W', 'W', 'L' },
                { 'W', 'L', 'W', 'W', 'W' },
                { 'W', 'W', 'W', 'L', 'W' },
                { 'W', 'W', 'L', 'L', 'W' },
                { 'L', 'W', 'W', 'L', 'L' },
                { 'L', 'L', 'W', 'W', 'W' },
        };

        return grid;
    }

    public void run() {
        Character[][] grid = generateGrid();
        System.out.println(islandCount(grid));
    }
}
