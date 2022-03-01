package Problems.dynamicProgramming.tabulation;

/*
 * you are a traveler on a 2d grid. you beging in the top-left corner, and your goal is to travel to the bottom-right corner
 * you may only move down or right
 * 
 * in how many ways can you travel to the goal on agrid with dimenstions m * n 
 */

public class GridTraveler {

    static long gridTraveler(int n, int m) {
        long[][] table = new long[n + 1][m + 1];
        table[1][1] = 1;

        for (int row = 0; row < n + 1; row++) {
            for (int col = 0; col < m + 1; col++) {
                if (row + 1 <= n) {
                    table[row + 1][col] += table[row][col];
                }
                if (col + 1 <= m) {
                    table[row][col + 1] += table[row][col];
                }
            }
        }

        return table[n][m];
    }

    public static void main(String[] args) {
        System.out.println(gridTraveler(1, 1));
        System.out.println(gridTraveler(2, 3));
        System.out.println(gridTraveler(3, 2));
        System.out.println(gridTraveler(5, 5));
        System.out.println(gridTraveler(18, 18));
    }
}
