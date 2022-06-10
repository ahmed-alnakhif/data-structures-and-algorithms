package Problems.dynamicProgramming.memoization;

/*
 * you are a traveler on a 2d grid. you'r beginning from the top-left corner, and your goal is to travel to the bottom-right corner
 * you may only move down or right
 * 
 * in how many ways can you travel to the goal on a grid with dimensions m * n 
 */

public class CountUniquePaths {

    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        return countPaths(dp, m, n);
    }

    private static int countPaths(int[][] dp, int row, int col) {
        if (row * col == 0) return 0;
        if (row == 1 && col == 1) return 1;
        if (dp[row][col] != 0) return dp[row][col];

        dp[row][col] = countPaths(dp, row - 1, col) + countPaths(dp, row, col - 1);

        return dp[row][col]; 
    }

    public static void main(String[] args) {
        System.out.println(uniquePaths(1, 1));
        System.out.println(uniquePaths(2, 2));
        System.out.println(uniquePaths(2, 3));
        System.out.println(uniquePaths(3, 2));
        System.out.println(uniquePaths(3, 7));
        System.out.println(uniquePaths(5, 5));
        System.out.println(uniquePaths(18, 18));
    }
}
