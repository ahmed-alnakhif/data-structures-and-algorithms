package Problems.topKElements;

import java.util.PriorityQueue;

/**
 * Given an array, find the sum of all numbers between the K1’th and K2’th
 * smallest elements of that array.
 * 
 * Input: [1, 3, 12, 5, 15, 11], and K1=3, K2=6
 * Output: 23
 * Explanation: The 3rd smallest number is 5 and 6th smallest number 15. The sum
 * of numbers coming
 * between 5 and 15 is 23 (11+12).
 */

public class SumOfElements {

    public static int findSumOfElements(int[] nums, int k1, int k2) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            minHeap.add(num);
        }

        for (int i = 0; i < k1; i++) {
            minHeap.poll();
        }

        int totalSum = 0;

        for (int i = 0; i < k2 - k1 - 1; i++) {
            totalSum += minHeap.poll();
        }

        return totalSum;
    }

    public static void main(String[] args) {
        int result = SumOfElements.findSumOfElements(new int[] { 1, 3, 12, 5, 15, 11 }, 3, 6);
        System.out.println("Sum of all numbers between k1 and k2 smallest numbers: " + result);

        result = SumOfElements.findSumOfElements(new int[] { 3, 5, 8, 7 }, 1, 4);
        System.out.println("Sum of all numbers between k1 and k2 smallest numbers: " + result);
    }
}
