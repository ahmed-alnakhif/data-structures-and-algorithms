package Problems.Graphs;

/**
 * There are n cities. Some of them are connected, while some are not. If city a
 * is connected directly with city b, and city b is connected directly with city
 * c, then city a is connected indirectly with city c.
 * 
 * A province is a group of directly or indirectly connected cities and no other
 * cities outside of the group.
 * 
 * You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the
 * ith city and the jth city are directly connected, and isConnected[i][j] = 0
 * otherwise.
 * 
 * Return the total number of provinces
 * 
 * Input: board = [[1,1,0],[1,1,0],[0,0,1]]
 * Output: 2
 */

public class NumberOfProvinces {

    public int numberOfProvinces(int[][] board) {
        boolean[] visited = new boolean[board.length];
        int numOfProvinces = 0;

        for (int i = 0; i < board.length; i++) {
            if (dfs(board, i, visited)) {
                numOfProvinces++;
            }
        }

        return numOfProvinces;
    }

    private boolean dfs(int[][] board, int index, boolean[] visited) {
        if (visited[index])
            return false;

        visited[index] = true;

        for (int i = 0; i < board.length; i++) {
            if (!visited[i] && board[index][i] == 1) {
                dfs(board, i, visited);
            }
        }

        return true;
    }

    public static void main(String[] args) {
        NumberOfProvinces n = new NumberOfProvinces();
        int[][] board = { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } };
        System.out.println(n.numberOfProvinces(board));
    }
}
