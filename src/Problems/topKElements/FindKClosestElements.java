package Problems.topKElements;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class FindKClosestElements {

    // T: O(Log(N - k) + k), S: O(1)
    // Review
    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0, right = arr.length - k;
        int mid = 0;
        while (left < right) {
            mid = left + ((right - left) / 2);

            if (x - arr[mid] > arr[mid + k] - x) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = left; i < left + k; i++) {
            result.add(arr[i]);
        }

        return result;

    }

    // T: O(log(N) + k), S: O(1)
    // Review
    public static List<Integer> findClosestElements2(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<Integer>();

        // Base case
        if (arr.length == k) {
            for (int i = 0; i < k; i++) {
                result.add(arr[i]);
            }
            return result;
        }

        // Binary search to find the closest element
        int left = 0, right = arr.length;
        int mid = 0;
        while (left < right) {
            mid = (left + right) / 2;
            if (arr[mid] >= x) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        // Initialize our sliding window's bounds
        left -= 1;
        right = left + 1;

        // While the window size is less than k
        while (right - left - 1 < k) {
            // Be careful to not go out of bounds
            if (left == -1) {
                right += 1;
                continue;
            }

            // Expand the window towards the side with the closer number
            // Be careful to not go out of bounds with the pointers
            if (right == arr.length || Math.abs(arr[left] - x) <= Math.abs(arr[right] - x)) {
                left -= 1;
            } else {
                right += 1;
            }
        }

        // Build and return the window
        for (int i = left + 1; i < right; i++) {
            result.add(arr[i]);
        }

        return result;
    }

    // T: O(N*log(N) + k*log(k)), S: O(N)
    public static List<Integer> findClosestElements3(int[] nums, int k, int x) {
        List<Integer> points = new ArrayList<>();

        for (int num : nums) {
            points.add(num);
        }

        Collections.sort(points, (a, b) -> Math.abs(a - x) - Math.abs(b - x));

        List<Integer> result = points.subList(0, k);
        Collections.sort(result);

        return result;

    }

    public static List<Integer> findClosestElements4(int[] nums, int k, int x) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> Math.abs(a - x) - Math.abs(b - x));

        for (int num : nums) {
            maxHeap.add(num);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        List<Integer> result = new ArrayList<>();
        while (!maxHeap.isEmpty()) {
            result.add(maxHeap.poll());
        }

        Collections.sort(result);

        return result;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 5 };
        int k = 4;
        int x = 5;

        System.out.println(findClosestElements(nums, k, x));
    }
}
