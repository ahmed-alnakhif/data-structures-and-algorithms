package Companies.google;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * return the max amount of olives from 2 slices in a pizza.
 * the two slices cannot be next to each other.
 */

class PizzaSlice {
    int olives;

    PizzaSlice(int olives) {
        this.olives = olives;
    }
}

public class MaxOlivesInPizza {

    public int maxOlives(List<PizzaSlice> slices) {
        PriorityQueue<int[]> maxPQ = new PriorityQueue<>((a, b) -> b[0] - a[0]);

        for (int i = 0; i < slices.size(); i++) {
            maxPQ.add(new int[] { slices.get(i).olives, i });
        }

        Queue<int[]> maxOlives = new LinkedList<>();

        int count = 0;
        while (count < 4) {
            maxOlives.add(maxPQ.poll());
            count++;
        }

        // TODO: fix logic here
        int[] firstTwoMaxOlives = maxOlives.poll();
        int[] secondTwoMaxOlives;
        while (!maxOlives.isEmpty()) {
            for (int i = 1; i < maxOlives.size(); i++) {
                
            }
        }

        // return Math.max(firstTwoMaxOlives, secondTwoMaxOlives);
        return -1;
    }

    public static void main(String[] args) {
        List<PizzaSlice> slices = new ArrayList<>();
        slices.add(new PizzaSlice(0));
        slices.add(new PizzaSlice(2));
        slices.add(new PizzaSlice(6));
        slices.add(new PizzaSlice(7));
        slices.add(new PizzaSlice(6));
        slices.add(new PizzaSlice(4));
        slices.add(new PizzaSlice(3));
        slices.add(new PizzaSlice(1));

        MaxOlivesInPizza maxOlivesInPizza = new MaxOlivesInPizza();
        System.out.println(maxOlivesInPizza.maxOlives(slices));

    }
}
