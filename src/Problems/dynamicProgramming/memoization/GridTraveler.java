package Problems.dynamicProgramming.memoization;

import java.util.HashMap;
import java.util.Map;

/*
 * you are a traveler on a 2d grid. you beging in the top-left corner, and your goal is to travel to the bottom-right corner
 * you may only move down or right
 * 
 * in how many ways can you travel to the goal on agrid with dimenstions m * n 
 */

public class GridTraveler {

    Map<String, Long> map = new HashMap<>();

    long gridTraveler(int n, int m) {
        if (n * m == 0) {
            return 0;
        }

        if (n == 1 && m == 1) {
            return 1;
        }

        String cell = n > m ? n + "," + m : m + "," + n;

        if (map.containsKey(cell)) {
            return map.get(cell);
        }

        map.put(cell, gridTraveler(n - 1, m) + gridTraveler(n, m - 1));

        return map.get(cell);
    }

    public void run() {
        System.out.println(gridTraveler(1, 1));
        System.out.println(gridTraveler(2, 3));
        System.out.println(gridTraveler(3, 2));
        System.out.println(gridTraveler(5, 5));
        System.out.println(gridTraveler(18, 18));
    }
}
