package algorithms.other;

import java.util.Arrays;

/**
 * What's Quick Select?
 * - Finds the k-th smallest element
 * - Partition around kth element (put everything smaller than Kth element on
 * the left side, and everything larger on the right side )
 * 
 * 
 * 
 * 
 * 
 */
public class QuickSelect {

    public static int quickSort(int[] arr, int start, int end, int k) {
        if (start == end) {
            return arr[start];
        }

        int pivot = partition(arr, start, end);

        if (pivot == k) {
            return arr[k];
        } else if (pivot < k) {
            return quickSort(arr, pivot + 1, end, k);
        } else {
            return quickSort(arr, start, pivot - 1, k);
        }
    }

    public static int partition(int[] arr, int start, int end) {
        int pivot = end;
        int i = start, j = end;

        while (i < j) {
            if (arr[i] <= arr[pivot]) {
                i++;
            }

            if (arr[j] > arr[pivot]) {
                j--;
            }

            if (i < j) {
                swap(arr, i, j);
            }
        }

        return j;
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = { 2, 1, 4, 13, 14, 12, 3, 16, 5, 2, 10 };
        int kth = arr.length; // largest element
        System.out.println(quickSort(arr, 0, arr.length - 1, kth - 1));
    }
}
