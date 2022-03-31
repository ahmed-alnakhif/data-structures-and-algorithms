package Problems.Graphs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * You are given an m x n grid rooms initialized with these three possible
 * values.
 * 
 * -1 A wall or an obstacle.
 * 0 A gate.
 * INF Infinity means an empty room. We use the value 231 - 1 = 2147483647 to
 * represent INF as you may assume that the distance to a gate is less than
 * 2147483647.
 * Fill each empty room with the distance to its nearest gate. If it is
 * impossible to reach a gate, it should be filled with INF.
 * 
 * Input: rooms =
 * [[2147483647,-1,0,2147483647],[2147483647,2147483647,2147483647,-1],[2147483647,-1,2147483647,-1],[0,-1,2147483647,2147483647]]
 * Output: [[3,-1,0,1],[2,2,1,-1],[1,-1,2,-1],[0,-1,3,4]]
 * 
 * Example 2:
 * Input: rooms = [[-1]]
 * Output: [[-1]]
 * 
 * Constraints:
 * 
 * m == rooms.length
 * n == rooms[i].length
 * 1 <= m, n <= 250
 * rooms[i][j] is -1, 0, or 231 - 1.
 */

public class WallsAndGates {

    int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    public void wallsAndGates(int[][] rooms) {
        if (rooms.length == 0)
            return;

        Queue<int[]> queue = new LinkedList<>();

        // 1- store all the gates
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[i].length; j++) {
                if (rooms[i][j] == 0) {
                    queue.add(new int[] { i, j });
                }
            }
        }

        // O(M*N)
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int row = cell[0], col = cell[1];
            for (int i = 0; i < dirs.length; i++) { // O(1)
                int x = row + dirs[i][0];
                int y = col + dirs[i][1];

                if (isValid(x, y, rooms) && isEmptyRoom(x, y, rooms)) {
                    if (rooms[row][col] < rooms[x][y]) {
                        rooms[x][y] = rooms[row][col] + 1;
                        queue.add(new int[] { x, y });
                    }
                }
            }
        }
    }

    private boolean isValid(int row, int col, int[][] board) {
        return row >= 0 && row < board.length && col >= 0 && col < board[0].length;
    }

    private boolean isEmptyRoom(int x, int y, int[][] board) {
        return board[x][y] > 0;
    }

    public static void main(String[] args) {
        int[][] rooms = { { Integer.MAX_VALUE, -1, 0, Integer.MAX_VALUE },
                { Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, -1 },
                { Integer.MAX_VALUE, -1, Integer.MAX_VALUE, -1 }, { 0, -1, Integer.MAX_VALUE, Integer.MAX_VALUE } };
        WallsAndGates w = new WallsAndGates();
        w.wallsAndGates(rooms);
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[i].length; j++) {
                System.out.print(rooms[i][j] + " |");
            }
            System.out.println();
        }
    }
}
