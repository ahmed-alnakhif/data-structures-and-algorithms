package Problems.Intervals;

import java.util.Arrays;

public class MeetingRooms {

    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        for (int i = 0; i < intervals.length - 1; i++) {
            if (intervals[i][1] > intervals[i + 1][0]) {
                return false;
            }
        }

        return true;
    }

    public void run() {
        int[][] firstList = new int[][] {
                { 0, 2 }, { 5, 10 }, { 13, 23 }, { 24, 25 }
        };

        System.out.println(canAttendMeetings(firstList));
    }
}
