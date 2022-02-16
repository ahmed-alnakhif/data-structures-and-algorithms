package Problems.Intervals;

import java.util.TreeMap;

public class CarPooling {

    // T: O(N*log(N)), S: O(N)
    public boolean carPooling(int[][] trips, int capacity) {
        TreeMap<Integer, Integer> timestamp = new TreeMap<>();

        for (int[] trip : trips) {
            timestamp.put(trip[1], timestamp.getOrDefault(trip[1], 0) + trip[0]);
            timestamp.put(trip[2], timestamp.getOrDefault(trip[2], 0) - trip[0]);
        }

        int usedCapacity = 0;
        for (int passengerChange : timestamp.values()) {
            usedCapacity += passengerChange;
            if (usedCapacity > capacity) {
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

    public void run() {
        int[][] trips = new int[][] {
                { 2, 1, 5 }, { 3, 3, 7 }
        };

        int capacity = 4;

        System.out.println(carPooling(trips, capacity));
    }
}
