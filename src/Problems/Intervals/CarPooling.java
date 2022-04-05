package Problems.Intervals;

import java.util.TreeMap;

public class CarPooling {

    // T: O(N*log(N)), S: O(N)
    public boolean carPooling(int[][] trips, int capacity) {
        //if values are the same, pick drop off time first
        // PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b)->
        //     a[0] == b[0] ? b[2]-a[2]: a[0]-b[0] 
        // );
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
