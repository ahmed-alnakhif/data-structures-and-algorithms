package dataStructures;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;

public class PriorityQ {

    public int getMin(List<Integer> list) {
        PriorityQueue<Integer> minPQ = new PriorityQueue<>();

        for (Integer integer : list) {
            minPQ.add(integer);
        }

        return minPQ.peek();
    }

    public int getMax(List<Integer> list) {
        // 1)
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Collections.reverseOrder());
        // 2) PriorityQueue<Integer> maxPQ = new PriorityQueue<>((a,b) -> b - a);
        // 3) PriorityQueue<Integer> maxPQ = new PriorityQueue<>((a,b) ->
        // b.compareTo(a));
        /** 4) custom comparator:
         * PriorityQueue<Integer> pq = new PriorityQueue<Integer>(defaultSize, new Comparator<Integer>() {
         *      public int compare(Integer lhs, Integer rhs) {
         *          if (lhs < rhs) return +1;
         *          if (lhs.equals(rhs)) return 0;
         *          return -1;
         *      }
         * });
         */

        for (Integer integer : list) {
            maxPQ.add(integer);
        }

        return maxPQ.peek();
    }

    public List<Integer> generateRandomList(int size) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= size; ++i) {
            int data = new Random().nextInt(30) + 1;
            list.add(data);
        }
        return list;
    }

    public void run() {
        List<Integer> list = generateRandomList(10);
        System.out.println(list);
        System.out.println(getMin(list));
        System.out.println(getMax(list));
    }
}
