package Problems.Intervals;

import java.util.Arrays;
import java.util.LinkedList;

public class MergeIntervals {

    //Approach 1 
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        LinkedList<int[]> resultList = new LinkedList<>();
        int[] toAddInterval = intervals[0];

        for (int[] current : intervals) {
            // smaller than current
            if (toAddInterval[1] < current[0]) {
                resultList.add(toAddInterval);
                toAddInterval = current;
            }

            // greater than current
            else if (toAddInterval[0] > current[1]) {
                resultList.add(current);
            }

            // they overlap
            else {
                toAddInterval[0] = Math.min(toAddInterval[0], current[0]);
                toAddInterval[1] = Math.max(toAddInterval[1], current[1]);
            }
        }

        resultList.add(toAddInterval);

        return resultList.toArray(new int[resultList.size()][2]);
    }

    // Approach 2
    public int[][] merge2(int[][] intervals) {
        LinkedList<int[]> list = new LinkedList<>();
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

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
