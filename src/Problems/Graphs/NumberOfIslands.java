package Problems.Graphs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Given an m x n 2D binary grid grid which represents a map of '1's (land) and
 * '0's (water), return the number of islands.
 * 
 * An island is surrounded by water and is formed by connecting adjacent lands
 * horizontally or vertically. You may assume all four edges of the grid are all
 * surrounded by water.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: grid = [
 * ["1","1","1","1","0"],
 * ["1","1","0","1","0"],
 * ["1","1","0","0","0"],
 * ["0","0","0","0","0"]
 * ]
 * Output: 1
 */

public class NumberOfIslands {

    int[][] dir = {{1,0}, {-1, 0}, {0, 1}, {0, -1}};
    boolean [][] visited;

    HashSet<String> seenCells = new HashSet<>();

    public int numIslands(char[][] grid) {
        int numbOfIslands = 0;

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (dfs(grid, row, col)) {
                    numbOfIslands++;
                }
            }
        }

        return numbOfIslands;
    }

    private boolean dfs(char[][] grid, int row, int col) {
        if (!isValidCell(grid, row, col)) return false;
        if (isWater(grid, row, col)) return false;
        if (visited[row][col]) return false;

        visited[row][col] = true;

        dfs(grid, row + 1, col);
        dfs(grid, row - 1, col);
        dfs(grid, row, col + 1);
        dfs(grid, row, col - 1);

        return true;
    }

    private boolean bfs(char[][] grid, int row, int col){
        if(visited[row][col]) return false;
        if(grid[row][col] == '0') return false;
        Queue<int[]> queue = new LinkedList<>();
        
        queue.offer(new int[]{row, col});
        visited[row][col] = true;
        
        while(!queue.isEmpty()){
            int size = queue.size();
            
            for(int i = 0; i<size; i++){
                int[] node = queue.poll();
                
                for(int j = 0; j < dir.length; j++){
                    int newX = node[0] + dir[j][0], newY = node[1] + dir[j][1];
                    
                    if(isValidCell(grid, newX, newY) && !visited[newX][newY]  && grid[newX][newY] == '1'){
                        queue.offer(new int[]{newX, newY});
                        visited[newX][newY] = true;
                    }
                }
            }
        }
    
        return true;
    }

    private boolean isValidCell(char[][] grid, int row, int col) {
        boolean rowInBounds = row >= 0 && row < grid.length;
        boolean colInBounds = col >= 0 && col < grid[0].length;
        return rowInBounds && colInBounds;
    }

    private boolean isWater(char[][] grid, int row, int col) {
        return grid[row][col] == '0';
    }

    char[][] generateGrid() {
        char[][] grid = {
                { 'W', 'L', 'W', 'W', 'L' },
                { 'W', 'L', 'W', 'W', 'W' },
                { 'W', 'W', 'W', 'L', 'W' },
                { 'W', 'W', 'L', 'L', 'W' },
                { 'L', 'W', 'W', 'L', 'L' },
                { 'L', 'L', 'W', 'W', 'W' },
        };

        return grid;
    }

    public static void main(String[] args) {
        NumberOfIslands n = new NumberOfIslands();
        char[][] grid = n.generateGrid();
        System.out.println(n.numIslands(grid)); 
    }
}
