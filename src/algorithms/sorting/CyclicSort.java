package algorithms.sorting;

import java.util.Arrays;

public class CyclicSort {

    public void cyclicSort(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            int index = arr[i] - 1;
            
            if (arr[i] > 0 && arr[i] <= arr.length && arr[i] != arr[index]) {
                swap(arr, i, index);
            } else {
                i++;
            }
        }
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        CyclicSort cs = new CyclicSort();
        int[] arr = { 2, 1, 4, 5, 3, -1, 8, 6, 7 };
        cs.cyclicSort(arr);
        System.out.println(Arrays.toString(arr));

    }
}
