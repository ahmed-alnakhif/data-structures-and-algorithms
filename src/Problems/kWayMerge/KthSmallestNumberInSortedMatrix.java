package Problems.kWayMerge;

import java.util.PriorityQueue;

/**
 * Given an n x n matrix where each of the rows and columns is sorted in
 * ascending order, return the kth smallest element in the matrix.
 * 
 * Note that it is the kth smallest element in the sorted order, not the kth
 * distinct element.
 * 
 * You must find a solution with a memory complexity better than O(n2).
 * 
 * 
 * Example 1:
 * 
 * Input: matrix = [[1,5,9],[10,11,13],[12,13,15]], k = 8
 * Output: 13
 * Explanation: The elements in the matrix are [1,5,9,10,11,12,13,13,15], and
 * the 8th smallest number is 13
 */

public class KthSmallestNumberInSortedMatrix {
    static class Node {
        int col;
        int row;

        Node(int col, int row) {
            this.col = col;
            this.row = row;
        }
    }

    static class Pair {
        int small;
        int large;

        Pair(int small, int large) {
            this.small = small;
            this.large = large;
        }
    }

    // T: O(N∗log(max−min)), S: O(1)
    public static int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int start = matrix[0][0], end = matrix[n - 1][n - 1];

        while (start < end) {
            int mid = start + (end - start) / 2;
            // first number is the smallest and the second number is the largest
            Pair pair = new Pair(start, end);

            int count = countLessEqual(matrix, mid, pair);

            if (count == k) {
                return pair.small;
            } else if (count < k) {
                start = pair.large; // search higher
            } else {
                end = pair.small; // search lower
            }
        }

        return start;
    }

    private static int countLessEqual(int[][] matrix, int mid, Pair pair) {
        int count = 0;
        int n = matrix.length, row = n - 1, col = 0;

        while (row >= 0 && col < n) {
            if (matrix[row][col] > mid) {
                // as matrix[row][col] is bigger than the mid, let's keep track of the
                // smallest number greater than the mid
                pair.large = Math.min(pair.large, matrix[row--][col]);
            } else {
                // as matrix[row][col] is less than or equal to the mid, let's keep track of the
                // biggest number less than or equal to the mid
                pair.small = Math.max(pair.small, matrix[row][col++]);
                count += row + 1;
            }
        }
        return count;
    }

    // T: O(min(K,N) + K∗log(N)), S: O(N)
    public static int kthSmallest2(int[][] matrix, int k) {
        PriorityQueue<Node> minHeap = new PriorityQueue<Node>(
                (n1, n2) -> matrix[n1.row][n1.col] - matrix[n2.row][n2.col]);

        // put the 1st element of each array in the min heap
        for (int row = 0; row < matrix.length; row++) {
            if (matrix[row].length > 0) {
                minHeap.add(new Node(0, row));
            }
        }

        int count = 0, result = 0;

        while (!minHeap.isEmpty()) {
            // take the smallest (top) element form the min heap,
            Node node = minHeap.poll();
            result = matrix[node.row][node.col++];

            count++;

            // if the running count is equal to k, return the number
            if (count == k) {
                return result;
            }

            // if the array of the top element has more elements, add the next element to
            // the heap
            if (node.col < matrix[0].length) {
                minHeap.add(node);
            }
        }

        return result;
    }

    // T: O(N*M * log(K)), S: O(K)
    // not better than O(n^2) as required in the problem
    public static int kthSmallest3(int[][] matrix, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((a, b) -> b - a);

        for (int col = 0; col < matrix[0].length; col++) {
            for (int row = 0; row < matrix.length; row++) {
                maxHeap.add(matrix[row][col]);
                if (maxHeap.size() > k) {
                    maxHeap.poll();
                }
            }
        }

        return maxHeap.peek();
    }

    public static void main(String[] args) {
        int[][] matrix1 = {
                { 1, 5, 9 }, { 10, 11, 13 }, { 12, 13, 15 }
        };
        System.out.println("Kth smallest number is: " + kthSmallest(matrix1, 8));

        int[][] matrix2 = {
                { -5 }
        };
        System.out.println("Kth smallest number is: " + kthSmallest(matrix2, 1));

    }
}
