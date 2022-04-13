package Problems.Graphs;

/**
 * You are given an m x n binary matrix grid. An island is a group of 1's
 * (representing land) connected 4-directionally (horizontal or vertical.) You
 * may assume all four edges of the grid are surrounded by water.
 * 
 * The area of an island is the number of cells with a value 1 in the island.
 * 
 * Return the maximum area of an island in grid. If there is no island, return
 * 0.
 */


public class MaxAreaOfIsland {
    boolean[][] seen;
    
    public int maxAreaOfIsland(int[][] grid) {
        seen = new boolean[grid.length][grid[0].length];
        int max = 0;
        
        for(int row = 0; row < grid.length; row++){
            for(int col = 0; col < grid[0].length; col++){
                max = Math.max(max, dfs(grid, row, col));
            }
        }
        
        return max;
    }
    
    private int dfs(int[][] grid, int row, int col){
        if(!isValidCell(grid, row, col)) return 0;
        if(seen[row][col]) return 0;
        if(grid[row][col] == 0) return 0;
        
        seen[row][col] = true;
        
        return 1 + dfs(grid, row+1, col) +
            dfs(grid, row-1, col) + 
            dfs(grid, row, col+1) + 
            dfs(grid, row, col-1);
    }

    private boolean isValidCell(int[][] grid, int row, int col) {
        boolean rowInBounds = row >= 0 && row < grid.length;
        boolean colInBounds = col >= 0 && col < grid[0].length;
        return rowInBounds && colInBounds;
    }

    public static void main(String[] args) {
        MaxAreaOfIsland obj = new MaxAreaOfIsland();
        int[][] grid = new int[][] {
            {0,0,1,0,0,0,0,1,0,0,0,0,0},
            {0,0,0,0,0,0,0,1,1,1,0,0,0},
            {0,1,1,0,1,0,0,0,0,0,0,0,0},
            {0,1,0,0,1,1,0,0,1,0,1,0,0},
            {0,1,0,0,1,1,0,0,1,1,1,0,0},
            {0,0,0,0,0,0,0,0,0,0,1,0,0},
            {0,0,0,0,0,0,0,1,1,1,0,0,0},
            {0,0,0,0,0,0,0,1,1,0,0,0,0}
        };
        System.out.println(obj.maxAreaOfIsland(grid));
    }
}
