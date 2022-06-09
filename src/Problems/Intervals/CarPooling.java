package Problems.Intervals;

import java.util.TreeMap;

/**
 * There is a car with capacity empty seats. The vehicle only drives east (i.e.,
 * it cannot turn around and drive west).
 * 
 * You are given the integer capacity and an array trips where trips[i] =
 * [numPassengersi, fromi, toi] indicates that the ith trip has numPassengersi
 * passengers and the locations to pick them up and drop them off are fromi and
 * toi respectively. The locations are given as the number of kilometers due
 * east from the car's initial location.
 * 
 * Return true if it is possible to pick up and drop off all passengers for all
 * the given trips, or false otherwise.
 * 
 * Example 1:
 * 
 * Input: trips = [[2,1,5],[3,3,7]], capacity = 4
 * Output: false
 * Example 2:
 * 
 * Input: trips = [[2,1,5],[3,3,7]], capacity = 5
 * Output: true
 */

public class CarPooling {

    // T: O(N*log(N)), S: O(N)
    public boolean carPooling(int[][] trips, int capacity) {
        // if values are the same, pick drop off time first
        // PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b)-> a[0] == b[0] ? b[2]-a[2]: a[0]-b[0]);

        TreeMap<Integer, Integer> timestamp = new TreeMap<>();

        for (int[] trip : trips) {
            timestamp.put(trip[1], timestamp.getOrDefault(trip[1], 0) + trip[0]);
            timestamp.put(trip[2], timestamp.getOrDefault(trip[2], 0) - trip[0]);
        }

        int currCapacity = 0;
        for (int passengerChange : timestamp.values()) {
            currCapacity += passengerChange;
            if (currCapacity > capacity) {
                return false;
            }
        }
        return true;
    }

    // if size is known, we can then use Bucket Sort. T: O(max(N, 1001)), S: O(1)
    public boolean carPooling2(int[][] trips, int capacity) {
        int[] timestamp = new int[1001];
        for (int[] trip : trips) {
            timestamp[trip[1]] += trip[0];
            timestamp[trip[2]] -= trip[0];
        }
        int usedCapacity = 0;
        for (int number : timestamp) {
            usedCapacity += number;
            if (usedCapacity > capacity) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        CarPooling cp = new CarPooling();
        int[][] trips = new int[][] {
                { 2, 1, 5 }, { 3, 3, 7 }
        };
        System.out.println(cp.carPooling(trips, 4));
    }
}
