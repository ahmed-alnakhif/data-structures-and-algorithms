package Problems.kWayMerge;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * You have k lists of sorted integers in non-decreasing order. Find the
 * smallest range that includes at least one number from each of the k lists.
 * 
 * We define the range [a, b] is smaller than range [c, d]
 * if b - a < d - c or a < c if b - a == d - c.
 * 
 * Example 1:
 * 
 * Input: nums = [[4,10,15,24,26],[0,9,12,20],[5,18,22,30]]
 * Output: [20,24]
 * Explanation:
 * List 1: [4, 10, 15, 24,26], 24 is in range [20,24].
 * List 2: [0, 9, 12, 20], 20 is in range [20,24].
 * List 3: [5, 18, 22, 30], 22 is in range [20,24].
 */

public class SmallestRange {
    static class Node {
        int elementIndex;
        int listIndex;

        Node(int elementIndex, int listIndex) {
            this.elementIndex = elementIndex;
            this.listIndex = listIndex;
        }
    }

    public static int[] smallestRange(List<List<Integer>> lists) {
        PriorityQueue<Node> minHeap = new PriorityQueue<Node>(
                (n1, n2) -> lists.get(n1.listIndex).get(n1.elementIndex)
                        - lists.get(n2.listIndex).get(n2.elementIndex));

        int rangeStart = 0, rangeEnd = Integer.MAX_VALUE, currentMaxNumber = Integer.MIN_VALUE;

        // put the 1st element of each list in the min heap
        for (int i = 0; i < lists.size(); i++) {
            if (lists.get(i) != null) {
                minHeap.add(new Node(0, i));
                currentMaxNumber = Math.max(currentMaxNumber, lists.get(i).get(0));
            }
        }

        while (minHeap.size() == lists.size()) {
            // take the smallest (top) element form the min heap,
            Node node = minHeap.poll();

            int currRange = currentMaxNumber - lists.get(node.listIndex).get(node.elementIndex);
            int prevRange = rangeEnd - rangeStart;

            // if it gives us smaller range, update the ranges
            if (currRange < prevRange) {
                rangeStart = lists.get(node.listIndex).get(node.elementIndex);
                rangeEnd = currentMaxNumber;
            }

            // if there're more elements in the list, insert the next element & update max
            if (lists.get(node.listIndex).size() > node.elementIndex + 1) {
                node.elementIndex++;
                minHeap.add(node);
                currentMaxNumber = Math.max(currentMaxNumber, lists.get(node.listIndex).get(node.elementIndex));
            }
        }

        return new int[] { rangeStart, rangeEnd };
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        lists.add(List.of(4, 10, 15, 24, 26));
        lists.add(List.of(0, 9, 12, 20));
        lists.add(List.of(5, 18, 22, 30));
        int[] result = smallestRange(lists);
        System.out.println("minimun range: " + result[0] + " -> " + result[1]);
    }
}
