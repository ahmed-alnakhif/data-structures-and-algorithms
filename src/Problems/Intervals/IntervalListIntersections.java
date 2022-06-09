package Problems.Intervals;

import java.util.ArrayList;
import java.util.List;

public class IntervalListIntersections {

    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> result = new ArrayList<>();
        int i = 0, j = 0;

        while (i < firstList.length && j < secondList.length) {
            int maxStart = Math.max(firstList[i][0], secondList[j][0]);
            int minEnd = Math.min(firstList[i][1], secondList[j][1]);

            if (maxStart <= minEnd) {
                result.add(new int[] { maxStart, minEnd });
            }

            if (firstList[i][1] < secondList[j][1]) {
                i++;
            } else {
                j++;
            }
        }

        return result.toArray(new int[result.size()][2]);
    }

    public static void main(String[] args) {
        IntervalListIntersections i = new IntervalListIntersections();

        int[][] firstList = new int[][] {
                { 0, 2 }, { 5, 10 }, { 13, 23 }, { 24, 25 }
        };
        int[][] secondList = new int[][] {
                { 1, 5 }, { 8, 12 }, { 15, 24 }, { 25, 26 }
        };

        System.out.println(i.intervalIntersection(firstList, secondList));
    }
}
