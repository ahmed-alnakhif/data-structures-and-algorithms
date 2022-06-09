package Problems.Intervals;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRoomsII {

    // T: O(nlogn), S: O(n)
    public int minMeetingRooms(int[][] intervals) {
        if (intervals.length == 0) return 0;

        PriorityQueue<Integer> roomsPQ = new PriorityQueue<>();
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        // add first meeting end time
        roomsPQ.add(intervals[0][1]);

        for (int i = 1; i < intervals.length; i++) {
            // meeting in the pq has finished, and we can take its room
            if (intervals[i][0] >= roomsPQ.peek()) {
                roomsPQ.poll();
            }

            roomsPQ.add(intervals[i][1]);
        }

        return roomsPQ.size();
    }

    // T: O(nlogn), S: O(n)
    public int minMeetingRooms2(int[][] intervals) {
        int[] startTimes = new int[intervals.length];
        int[] endTimes = new int[intervals.length];

        for (int i = 0; i < intervals.length; i++) {
            startTimes[i] = intervals[i][0];
            endTimes[i] = intervals[i][1];
        }

        Arrays.sort(startTimes);
        Arrays.sort(endTimes);

        int requiredRooms = 0;
        int i = 0, j = 0;
        while (i < startTimes.length && j < endTimes.length) {

            // If there is a meeting that has ended by the time this meeting is to start
            if (startTimes[i] >= endTimes[j]) {
                requiredRooms--;
                j++;
            }

            requiredRooms++;
            i++;
        }

        return requiredRooms;
    }

    public static void main(String[] args) {
        MeetingRoomsII m = new MeetingRoomsII();
        int[][] intervals = {{0, 30}, {5, 10}, {15, 20}};
        System.out.println(m.minMeetingRooms(intervals));
    }
}
