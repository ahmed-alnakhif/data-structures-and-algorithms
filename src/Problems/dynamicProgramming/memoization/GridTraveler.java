package Problems.dynamicProgramming.memoization;

import java.util.HashMap;
import java.util.Map;

/*
 * you are a traveler on a 2d grid. you'r beginning from the top-left corner, and your goal is to travel to the bottom-right corner
 * you may only move down or right
 * 
 * in how many ways can you travel to the goal on a grid with dimensions m * n 
 */

public class GridTraveler {

    static Map<String, Long> map = new HashMap<>();

    static long gridTraveler(int row, int col) {
        //base case: if reach end of either row or col
        if (row * col == 0) {
            return 0;
        }

        //base case: I have only one cell
        if (row == 1 && col == 1) {
            return 1;
        }

        String cell = row > col ? row + "," + col : col + "," + row;

        if (map.containsKey(cell)) {
            return map.get(cell);
        }

        //             go one step down         go one step right 
        map.put(cell, gridTraveler(row - 1, col) + gridTraveler(row, col - 1));

        return map.get(cell);
    }

    public static void main(String[] args) {
        System.out.println(gridTraveler(1, 1));
        System.out.println(gridTraveler(2, 2));
        System.out.println(gridTraveler(2, 3));
        System.out.println(gridTraveler(3, 2));
        System.out.println(gridTraveler(5, 5));
        System.out.println(gridTraveler(18, 18));
    }
}
