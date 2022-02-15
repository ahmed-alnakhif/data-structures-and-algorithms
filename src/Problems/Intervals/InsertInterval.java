package Problems.Intervals;

import java.util.Collections;
import java.util.LinkedList;

public class InsertInterval {
    // T: O(N*log(N)), S: O(N)
    public int[][] insert(int[][] intervals, int[] newInterval) {
        LinkedList<int[]> list = new LinkedList<>();

        for (int[] interval : intervals) {
            list.add(interval);
        }
        list.add(newInterval);

        Collections.sort(list, (a, b) -> a[0] - b[0]);

        int i = 1;
        while (i < list.size()) {
            if (list.get(i)[0] <= list.get(i - 1)[1]) {
                list.get(i - 1)[1] = Math.max(list.get(i - 1)[1], list.get(i)[1]);
                list.get(i - 1)[0] = Math.min(list.get(i - 1)[0], list.get(i)[0]);
                list.remove(i);
            } else {
                i++;
            }
        }

        return list.toArray(new int[list.size()][]);
    }

    // T: O(N), S: O(N)
    public int[][] insert2(int[][] intervals, int[] newInterval) {
        LinkedList<int[]> resultList = new LinkedList<>();

        int[] toAddInterval = newInterval;

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

    public void run() {
        int[][] intervals = new int[][] {
                { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 }
        };
        int[] newInterval = { 3, 4 };

        System.out.println(insert2(intervals, newInterval));
    }
}
