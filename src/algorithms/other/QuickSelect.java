package algorithms.other;

import java.util.Random;

/**
 * What's Quick Select?
 * - Finds the k-th element
 * - Partition around kth element (put everything smaller than Kth element on
 *   the left side, and everything larger on the right side )
 */
public class QuickSelect {

    public static int quickSelect(int[] arr, int start, int end, int k) {
        if (start == end) {
            return arr[start];
        }

        Random random = new Random();
        int pivot = start + random.nextInt(end - start);
        pivot = partition(arr, start, end, pivot);

        if (pivot == k) {
            return arr[k];
        } else if (pivot < k) {
            return quickSelect(arr, pivot + 1, end, k);
        } else {
            return quickSelect(arr, start, pivot - 1, k);
        }
    }

    public static int partition(int[] arr, int start, int end, int pivotIndex) {
        int pivot = arr[pivotIndex];
        
        // 1. move pivot to end
        swap(arr, pivotIndex, end);
        int storeIndex = start;
    
        // 2. move all smaller elements to the left
        for (int i = start; i <= end; i++) {
          if (arr[i] < pivot) {
            swap(arr, storeIndex, i);
            storeIndex++;
          }
        }
    
        // 3. move pivot to its final place
        swap(arr, storeIndex, end);
    
        return storeIndex;
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = { 2, 1, 4, 13, 14, 12, 3, 16, 5, 2, 10 };
        int kth = arr.length; // largest element
        System.out.println(quickSelect(arr, 0, arr.length - 1, kth - 1));
    }
}
