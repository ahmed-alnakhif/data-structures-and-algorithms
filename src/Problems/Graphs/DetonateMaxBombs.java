package Problems.Graphs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * You are given a list of bombs. The range of a bomb is defined as the area
 * where its effect can be felt. This area is in the shape of a circle with the
 * center as the location of the bomb.
 * 
 * The bombs are represented by a 0-indexed 2D integer array bombs where
 * bombs[i] = [xi, yi, ri]. xi and yi denote the X-coordinate and Y-coordinate
 * of the location of the ith bomb, whereas ri denotes the radius of its range.
 * 
 * You may choose to detonate a single bomb. When a bomb is detonated, it will
 * detonate all bombs that lie in its range. These bombs will further detonate
 * the bombs that lie in their ranges.
 * 
 * Given the list of bombs, return the maximum number of bombs that can be
 * detonated if you are allowed to detonate only one bomb.
 * 
 * Input: bombs = [[1,2,3],[2,3,1],[3,4,2],[4,5,3],[5,6,4]]
 * Output: 5
 * Explanation:
 * The best bomb to detonate is bomb 0 because:
 * - Bomb 0 detonates bombs 1 and 2. The red circle denotes the range of bomb 0.
 * - Bomb 2 detonates bomb 3. The blue circle denotes the range of bomb 2.
 * - Bomb 3 detonates bomb 4. The green circle denotes the range of bomb 3.
 * Thus all 5 bombs are detonated.
 */

public class DetonateMaxBombs {

    public int maximumDetonation(int[][] bombs) {
        int max = 0;
        for (int i = 0; i < bombs.length; i++) {
            max = Math.max(max, getMaxDFS(i, bombs, new boolean[bombs.length]));
        }
        return max;
    }

    private int getMaxDFS(int index, int[][] bombs, boolean[] seen) {
        int count = 1;
        seen[index] = true;
        for (int i = 0; i < bombs.length; i++) {
            if (!seen[i] && isInRange(bombs[index], bombs[i])) {
                count += getMaxDFS(i, bombs, seen);
            }
        }
        return count;
    }

    private int getMaxBFS(int[][] bombs, int index) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] seen = new boolean[bombs.length];

        seen[index] = true;
        queue.offer(index);

        int count = 1; // start from 1 since the first added bomb can detonate itself

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int currBomb = queue.poll();
                for (int j = 0; j < bombs.length; j++) { // search for bombs to detonate
                    if (!seen[j] && isInRange(bombs[currBomb], bombs[j])) {
                        seen[j] = true;
                        count++;
                        queue.offer(j);
                    }
                }
            }
        }

        return count;
    }

    private boolean isInRange(int[] point1, int[] point2) {
        long dx = point1[0] - point2[0], dy = point1[1] - point2[1], radius = point1[2];
        long distance = dx * dx + dy * dy;
        return distance <= radius * radius;
    }

    public static void main(String[] args) {
        DetonateMaxBombs d = new DetonateMaxBombs();
        int[][] bombs = { { 1, 2, 3 }, { 2, 3, 1 }, { 3, 4, 2 }, { 4, 5, 3 }, { 5, 6, 4 } };
        System.out.println(d.maximumDetonation(bombs));
    }
}
