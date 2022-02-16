package Problems.Intervals;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * We are given a list schedule of employees, which represents the working time
 * for each employee.
 * 
 * Each employee has a list of non-overlapping Intervals, and these intervals
 * are in sorted order.
 * 
 * Return the list of finite intervals representing common, positive-length free
 * time for all employees, also in sorted order.
 * 
 * Example 1:
 * 
 * Input: schedule = [[[1,2],[5,6]],[[1,3]],[[4,10]]]
 * Output: [[3,4]]
 * Explanation: There are a total of three employees, and all common
 * free time intervals would be [-inf, 1], [3, 4], [10, inf].
 * We discard any intervals that contain inf as they aren't finite.
 */

public class EmployeeFreeTime {

    class Interval {
        public int start;
        public int end;

        public Interval() {
        }

        public Interval(int _start, int _end) {
            start = _start;
            end = _end;
        }
    };

    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> result = new LinkedList<>(), intervals = new LinkedList<>();
        for (List<Interval> list : schedule) {
            intervals.addAll(list);
        }

        Collections.sort(intervals, (a, b) -> (a.start - b.start));

        int end = intervals.get(0).end;
        for (Interval interval : intervals) {
            if (interval.start > end) {
                result.add(new Interval(end, interval.start));
            }
            end = Math.max(end, interval.end);
        }
        return result;
    }

    public List<Interval> employeeFreeTime2(List<List<Interval>> schedule) {
        List<Interval> result = new LinkedList<>();
        List<Interval> intervals = new LinkedList<>();

        for (List<Interval> employeeIntervals : schedule) {
            intervals.addAll(employeeIntervals);
        }
        Collections.sort(intervals, (a, b) -> a.start - b.start);

        intervals = mergeInterval(intervals);

        for (int i = 1; i < intervals.size(); i++) {
            result.add(new Interval(intervals.get(i - 1).end, intervals.get(i).start));
        }

        return result;
    }

    private List<Interval> mergeInterval(List<Interval> intervals) {
        LinkedList<Interval> list = new LinkedList<>();

        Interval toAddInterval = intervals.get(0);

        for (Interval curr : intervals) {
            if (toAddInterval.end < curr.start) {
                list.add(toAddInterval);
                toAddInterval = curr;
            } else if (toAddInterval.start > curr.end) {
                list.add(curr);
            } else {
                toAddInterval.start = Math.min(toAddInterval.start, curr.start);
                toAddInterval.end = Math.max(toAddInterval.end, curr.end);
            }
        }

        list.add(toAddInterval);

        return list;
    }

    public void run() {
        List<List<Interval>> schedule = List.of(
                List.of(new Interval(1, 2), new Interval(6, 7)),
                List.of(new Interval(2, 4)),
                List.of(new Interval(2, 5), new Interval(9, 12)));

        System.out.println(employeeFreeTime(schedule));
    }
}
