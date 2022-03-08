package algorithms.sorting;

import java.util.Arrays;

/**
 * QuickSort is a Divide and Conquer algorithm. It picks an element as pivot and
 * partitions the given array around the picked pivot.
 * 
 * The algorithm makes sure that the pivot is sorted; meaning that all elements
 * before it are smaller, and all elements after it are greater
 * 
 * There are different versions of quickSort that pick pivot in different ways.
 * 
 * Worst case:
 *      n^2 when always choosing a wrong pivot (the largest element). To avoid that,
 *      make the first partition recursive call on which side that has fewer elements log(n)
 * 
 * Optimization: 
 *      - Pivot picking:
 *          - consider pickig 3 elements and take a median as pivot
 *          - or consider using the median of the first, middle, and last from a block   
 */

public class QuickSort {

    public static void improvedQuickSort(int[] arr, int start, int end) {
        while (start < end) { // improve worst case space stack

            int pivot = partition2(arr, start, end);

            // for better performance, always start with the smaller size side
            if (pivot - start < end - pivot) {
                quickSort(arr, start, pivot - 1);
                start = pivot + 1;
            } else {
                quickSort(arr, pivot + 1, end);
                end = pivot - 1;
            }
        }
    }

    public static void quickSort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }

        int pivot = partition2(arr, start, end);

        quickSort(arr, start, pivot - 1);
        quickSort(arr, pivot + 1, end);
    }

    public static int partition1(int[] arr, int start, int end) {
        int pivot = end;
        int i = start - 1, j = start;

        while (j < pivot) {
            if (arr[j] <= arr[pivot]) {
                i++;
                swap(arr, i, j);
            }

            j++;
        }
        swap(arr, i + 1, end);

        return i + 1;
    }

    public static int partition2(int[] arr, int start, int end) {
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
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));

        int[] arr2 = { 10, 16, 8, 12, 15, 6, 3, 9, 5 };
        quickSort(arr2, 0, arr2.length - 1);
        System.out.println(Arrays.toString(arr2));

    }
}
