package algorithms.searching;

public class BinarySearch {

    public int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] == target) {
                return mid;
            }

            if (target > arr[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

    public void run() {
        int[] arr = { -5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5 };
        int target = 9;
        System.out.println(binarySearch(arr, target));
    }
}
