package Problems.Intervals;

import java.util.Arrays;

public class MeetingRoomsII {

    public int minMeetingRooms(int[][] intervals) {
        int[] startTimes = new int[intervals.length];
        int[] endTimes = new int[intervals.length];

        for (int i = 0; i < intervals.length; i++) {
            startTimes[i] = intervals[i][0];
            endTimes[i] = intervals[i][1];
        }

        Arrays.sort(startTimes);
        Arrays.sort(endTimes);

        int count = 0;
        int i = 0, j = 0;
        while (i < startTimes.length && j < endTimes.length) {
            if (startTimes[i] >= endTimes[j]) {
                count--;
                j++;
            }

            count++;
            i++;
        }

        return count;
    }

    public void run() {
        int[][] intervals = new int[][] {
            { 0, 30 }, { 5, 10 }, { 15, 20 }
        };

        System.out.println(minMeetingRooms(intervals));
    }
}
