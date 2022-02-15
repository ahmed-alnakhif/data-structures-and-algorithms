package Problems.Intervals;

import java.util.Arrays;
import java.util.LinkedList;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        LinkedList<int[]> list = new LinkedList<>();

        list.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= list.getLast()[1]) {
                list.getLast()[1] = Math.max(list.getLast()[1], intervals[i][1]);
            } else {
                list.add(intervals[i]);
            }
        }

        return list.toArray(new int[list.size()][]);
    }

    public void run() {
        int[][] intervals = new int[][] {
                { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 }
        };

        System.out.println(merge(intervals));
    }
}
