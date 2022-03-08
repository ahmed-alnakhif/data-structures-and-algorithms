package dataStructures;

import java.util.TreeMap;

public class TreeMaps {

    static void treeMaps(int[] nums) {
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        System.out.println(map);
        System.out.println(map.descendingMap());
    }

    public static void main(String[] args) {
        treeMaps(new int[] { 1, 2, 3, 1, 1, 7, 3, 4, 9, 2, 1 });
    }
}
