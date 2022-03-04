package Problems.twoHeaps;

import java.util.PriorityQueue;

/**
 * You are given an array of intervals, where intervals[i] = [starti, endi] and
 * each starti is unique.
 * 
 * The right interval for an interval i is an interval j such that startj >=
 * endi and startj is minimized.
 * 
 * Return an array of right interval indices for each interval i. If no right
 * interval exists for interval i, then put -1 at index i.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: intervals = [[1,2]]
 * Output: [-1]
 * Explanation: There is only one interval in the collection, so it outputs -1
 * 
 * Input: intervals = [[1,4],[2,3],[3,4]]
 * Output: [-1,2,-1]
 * Explanation: There is no right interval for [1,4] and [3,4].
 * The right interval for [2,3] is [3,4] since start2 = 3 is the smallest start
 * that is >= end1 = 3.
 */

class Interval {
    int start;
    int end;
    int index;

    Interval(int start, int end, int index) {
        this.start = start;
        this.end = end;
        this.index = index;
    }
}

public class FindRightInterval {

    public static int[] findRightInterval(int[][] intervals) {
        int[] result = new int[intervals.length];

        // max heap for start times
        PriorityQueue<Interval> maxStartHeap = new PriorityQueue<>((a, b) -> (b.start - a.start));
        // max heap for end times
        PriorityQueue<Interval> maxEndHeap = new PriorityQueue<>((a, b) -> (b.end - a.end));

        // initialization
        for (int i = 0; i < intervals.length; i++) {
            maxEndHeap.add(new Interval(intervals[i][0], intervals[i][1], i));
            maxStartHeap.add(new Interval(intervals[i][0], intervals[i][1], i));
        }

        // go through each interval 0 -> intervals.length
        while (!maxEndHeap.isEmpty()) {
            Interval maxEndInterval = maxEndHeap.poll();
            result[maxEndInterval.index] = -1;

            // if start time at the top is >= end time at the top, then we find a possible right interval
            // however, we still need to check if there's a smaller start time
            if (!maxStartHeap.isEmpty() && maxStartHeap.peek().start >= maxEndInterval.end) {
                Interval maxStart = maxStartHeap.poll();

                // check if there's a smaller start time
                while (!maxStartHeap.isEmpty() && maxStartHeap.peek().start >= maxEndInterval.end) {
                    maxStart = maxStartHeap.poll();
                }

                // update our result
                result[maxEndInterval.index] = maxStart.index;

                // add back the top start time, so other end times can process it.
                maxStartHeap.add(maxStart);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] intervals = { { 1, 4 }, { 2, 3 }, { 3, 4 } };
        int[] result = findRightInterval(intervals);

        for (int i : result) {
            System.out.print(i + ", ");
        }
        System.out.println();
    }
}
