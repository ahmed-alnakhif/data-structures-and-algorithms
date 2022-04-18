package Problems.kWayMerge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Given ‘M’ sorted arrays, find the K’th smallest number among all the arrays.
 * 
 * 
 * 
 * Similar problems:
 * 
 * Problem 1: Given ‘M’ sorted arrays, find the median number among all arrays.
 * Solution 1: This problem is similar to our parent problem with K=Median.
 * So if there are ‘N’ total numbers in all the arrays we need to find the K’th
 * minimum number where K=N/2
 * 
 * 
 * Problem 2: Given a list of ‘K’ sorted arrays, merge them into one sorted
 * list.
 * Solution 2: This problem is similar to Merge K Sorted Lists except that the
 * input is a list of arrays compared to LinkedLists. To handle this, we can use
 * a similar approach as discussed in our parent problem by keeping a track of
 * the array and the element indices.
 */

class Node {
    int elementIndex;
    int arrayIndex;

    Node(int elementIndex, int arrayIndex) {
        this.elementIndex = elementIndex;
        this.arrayIndex = arrayIndex;
    }
}

public class KthSmallestNumberInSortedLists {

    // T: O(K*log(M)), S: O(M)
    public static int findKthSmallest(List<int[]> lists, int k) {
        PriorityQueue<Node> minHeap = new PriorityQueue<>(
                (n1, n2) -> lists.get(n1.arrayIndex)[n1.elementIndex] - lists.get(n2.arrayIndex)[n2.elementIndex]);

        // put the 1st element of each array in the min heap
        for (int i = 0; i < lists.size(); i++) {
            if (lists.get(i) != null) {
                minHeap.add(new Node(0, i));
            }
        }

        int count = 0, result = 0;

        while (!minHeap.isEmpty()) {
            // poll the smallest (top) element form the min heap,
            Node node = minHeap.poll();

            result = lists.get(node.arrayIndex)[node.elementIndex++];
            count++;

            // if the running count is equal to k, return the number
            if (count == k) {
                return result;
            }

            // if the array of the top element has more elements, add the next element to
            // the heap
            if (node.elementIndex < lists.get(node.arrayIndex).length) {
                minHeap.add(node);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] l1 = new int[] { 2, 6, 8 };
        int[] l2 = new int[] { 3, 6, 7 };
        int[] l3 = new int[] { 1, 3, 4 };
        List<int[]> lists = new ArrayList<>(Arrays.asList(l1, l2, l3));
        int k = 5;
        int result = findKthSmallest(lists, k);
        System.out.println(k+"th smallest number is: " + result);
    }
}
