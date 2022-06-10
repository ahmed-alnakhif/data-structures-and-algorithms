package Companies.amazon;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class MinimumKnightMove {

    private final int[][] DIRECTIONS = new int[][] { { 2, 1 }, { 1, 2 }, { -1, 2 }, { -2, 1 }, { -2, -1 }, { -1, -2 },
            { 1, -2 }, { 2, -1 } };

    public int minKnightMoves(int x, int y) {
        x = Math.abs(x);
        y = Math.abs(y);

        Queue<int[]> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.add(new int[] { 0, 0 });

        int steps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                int curX = cur[0], curY = cur[1];

                if (curX == x && curY == y) {
                    return steps;
                }

                visited.add(curX + "," + curY);


                for (int[] d : DIRECTIONS) {
                    int newX = curX + d[0];
                    int newY = curY + d[1];
                    if (!visited.contains(newX + "," + newY) && newX >= -1 && newY >= -1) {
                        queue.add(new int[] { newX, newY });
                    }
                }
            }
            
            steps++;
        }
        return -1;
    }

    public static void main(String[] args) {
        MinimumKnightMove m = new MinimumKnightMove();
        System.out.println(m.minKnightMoves(2, 1));
        System.out.println(m.minKnightMoves(5, 5));
    }
}
