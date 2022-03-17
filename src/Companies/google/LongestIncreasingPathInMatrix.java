package Companies.google;

import java.util.HashMap;

/**
 * Given an m x n integers matrix, return the length of the longest increasing
 * path in matrix.
 * 
 * From each cell, you can either move in four directions: left, right, up, or
 * down. You may not move diagonally or move outside the boundary (i.e.,
 * wrap-around is not allowed).
 * 
 * Example 1:
 * Input: matrix = [[9,9,4],[6,6,8],[2,1,1]]
 * Output: 4
 * Explanation: The longest increasing path is [1, 2, 6, 9].
 */

public class LongestIncreasingPathInMatrix {
    HashMap<String, Integer> cache;

    public int longestIncreasingPath(int[][] matrix) {
        int max = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                cache = new HashMap<>();
                max = Math.max(max, dfs(matrix, row, col));
            }
        }
        return max;
    }

    private int dfs(int[][] matrix, int row, int col) {
        String key = row + "," + col;

        if (cache.containsKey(key)) {
            return cache.get(key);
        }

        int count = 0;

        if (isValidCell(matrix, row + 1, col) && matrix[row + 1][col] > matrix[row][col]) {
            count = Math.max(count, dfs(matrix, row + 1, col));
        }
        if (isValidCell(matrix, row - 1, col) && matrix[row - 1][col] > matrix[row][col]) {
            count = Math.max(count, dfs(matrix, row - 1, col));
        }
        if (isValidCell(matrix, row, col + 1) && matrix[row][col + 1] > matrix[row][col]) {
            count = Math.max(count, dfs(matrix, row, col + 1));
        }
        if (isValidCell(matrix, row, col - 1) && matrix[row][col - 1] > matrix[row][col]) {
            count = Math.max(count, dfs(matrix, row, col - 1));
        }

        count += 1;

        cache.put(key, count);

        return count;
    }

    private boolean isValidCell(int[][] grid, int row, int col) {
        boolean rowInBounds = row >= 0 && row < grid.length;
        boolean colInBounds = col >= 0 && col < grid[0].length;
        return rowInBounds && colInBounds;
    }

    public static void main(String[] args) {
        LongestIncreasingPathInMatrix l = new LongestIncreasingPathInMatrix();
        System.out.println(l.longestIncreasingPath(new int[][] { { 9, 9, 4 }, { 6, 6, 8 }, { 2, 1, 1 } }));
    }
}
