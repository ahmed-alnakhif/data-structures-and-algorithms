package Problems.matrixBFS;

import java.util.LinkedList;
import java.util.Queue;

/**
 * You are given an m x n grid where each cell can have one of three values:
 * 
 * 0 representing an empty cell,
 * 1 representing a fresh orange, or
 * 2 representing a rotten orange.
 * Every minute, any fresh orange that is 4-directionally adjacent to a rotten
 * orange becomes rotten.
 * 
 * Return the minimum number of minutes that must elapse until no cell has a
 * fresh orange. If this is impossible, return -1
 * 
 * Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
 * Output: 4
 */

public class RottingOranges {

    public int orangesRotting(int[][] grid) {
        Queue<int[]> rottenQueue = new LinkedList<>();
        int freshOranges = 0;
        
        for(int row = 0; row < grid.length; row++){
            for(int col = 0; col < grid[0].length; col++){
                if(grid[row][col] == 2){
                    rottenQueue.offer(new int[]{row, col});
                } else if(grid[row][col] == 1){
                    freshOranges++;
                }
            }
        }
        
        if(freshOranges == 0){
            return 0;
        }
        
        int elapsedTime = 0;
        int[][] dirs = { {1,0}, {-1, 0}, {0, 1}, {0, -1}};
        
        while(!rottenQueue.isEmpty()){
            elapsedTime++;
            
            int size = rottenQueue.size();
            for(int i = 0; i<size; i++){
                int[] cell = rottenQueue.poll();
                for(int[] dir: dirs){
                    int x = cell[0] + dir[0];
                    int y = cell[1] + dir[1];

                    if(isValidCell(x, y, grid) && isFreshOrange(x, y, grid)){
                        grid[x][y] = 2;
                        rottenQueue.offer(new int[]{x, y});
                        freshOranges--;
                    }
                }
            }

        }
        
        if(freshOranges == 0){
            return elapsedTime - 1;
        }
        
        return -1;
    }
    
    boolean isValidCell(int row, int col, int[][] grid){
        return row>=0 && row<grid.length && col>=0 && col<grid[0].length;
    }
    
    boolean isFreshOrange(int row, int col, int[][] grid){
        return grid[row][col] == 1;
    }

    public static void main(String[] args) {
        RottingOranges ro = new RottingOranges();
        int[][] grid = { { 2, 1, 1 }, { 1, 1, 0 }, { 0, 1, 1 } };
        System.out.println(ro.orangesRotting(grid));
    }
}
