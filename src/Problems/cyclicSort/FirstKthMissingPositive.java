package Problems.cyclicSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given an array arr of positive integers sorted in a strictly increasing
 * order, and an integer k.
 * 
 * Find the kth positive integer that is missing from this array.
 * 
 * Example 1:
 * 
 * Input: arr = [2,3,4,7,11], k = 5
 * Output: 9
 * Explanation: The missing positive integers are [1,5,6,8,9,10,12,13,...]. The
 * 5th missing positive integer is 9.
 */

public class FirstKthMissingPositive {

    // Using Binary Search,  T: O(log(N)), S: O(1)
    public int findKthPositive(int[] arr, int k) {
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int pivot = left + (right - left) / 2;
            if (arr[pivot] - pivot - 1 < k) {
                left = pivot + 1;
            } else {
                right = pivot - 1;
            }
        }

        return left + k;
    }

    // Using Cyclic Sort,  T: O(N+K), S:(K) 
    public int findKthPositive2(int[] arr, int k) {
        int i = 0;
        while (i < arr.length) {
            int index = arr[i] - 1;
            if (arr[i] > 0 && arr[i] <= arr.length && arr[i] != arr[index]) {
                swap(arr, i, index);
            } else {
                i++;
            }
        }

        List<Integer> missingNumbers = new ArrayList<>();
        Set<Integer> extraNumbers = new HashSet<>();
        for (i = 0; i < arr.length && missingNumbers.size() < k; i++)
            if (arr[i] != i + 1) {
                missingNumbers.add(i + 1);
                extraNumbers.add(arr[i]);
            }

        // add the remaining missing numbers
        for (i = 1; missingNumbers.size() < k; i++) {
            int candidateNumber = i + arr.length;
            if (!extraNumbers.contains(candidateNumber)) {
                missingNumbers.add(candidateNumber);
            }
        }

        return missingNumbers.get(k - 1);
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public void run() {
        int[] arr = { 7, 8, 9, 11, 12 };
        int k = 3;
        findKthPositive(arr, k);
        System.out.println(Arrays.toString(arr));

    }
}
