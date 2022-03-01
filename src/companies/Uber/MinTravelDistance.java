package Companies.Uber;

import java.util.PriorityQueue;

public class MinTravelDistance {

    //Greedy 
    public int minTravelDistance(int[] locations, int target) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

        for (int location : locations) {
            pq.add(location);
        }

        int min = 0, dist = 0;

        while (!pq.isEmpty() && dist < target) {
            int val = pq.poll();
            if (dist <= val) {
                min += (val - dist);
                dist = (val + 10);
            }
        }

        if (dist < target) {
            return min + (target - dist);
        } else {
            return min;
        }
    }

    public void run() {
        int[] locations = { 15, 20, 10 };
        int target = 18;
        System.out.println(minTravelDistance(locations, target));
    }
}
