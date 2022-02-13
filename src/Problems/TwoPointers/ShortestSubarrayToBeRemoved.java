package Problems.TwoPointers;

/**
 * Given an integer array arr, remove a subarray (can be empty) from arr such
 * that the remaining elements in arr are non-decreasing.
 * 
 * Return the length of the shortest subarray to remove.
 * 
 * A subarray is a contiguous subsequence of the array.
 * 
 * 
 * Example 1:
 * 
 * Input: arr = [1,2,3,10,4,2,3,5]
 * Output: 3
 * Explanation: The shortest subarray we can remove is [10,4,2] of length 3. The
 * remaining elements after that will be [1,2,3,3,5] which are sorted.
 * Another correct solution is to remove the subarray [3,10,4].
 */

public class ShortestSubarrayToBeRemoved {
    public int findLengthOfShortestSubarray(int[] arr) {
        int left = 0, right = arr.length - 1;

        int maxSeen = 0;
        while (left < arr.length && arr[left] >= maxSeen) {
            maxSeen = arr[left];
            left++;
        }

        int minSeen = Integer.MAX_VALUE;
        while (right >= 0 && arr[right] <= minSeen) {
            minSeen = arr[right];
            right--;
        }

        // [-------left [possible unsorted subarray] --------arr.length]
        int shortestSubarry = Math.min(arr.length - left, right + 1);

        // ptrs reached the end of the arrary, so all elements are sorted properly
        if (left == arr.length || right == -1) {
            return shortestSubarry;
        }

        int lo = 0, hi = right + 1;
        while (lo < left && hi < arr.length) {
            if (arr[hi] >= arr[lo]) {
                int currWindowSize = hi - lo - 1;
                shortestSubarry = Math.min(shortestSubarry, currWindowSize);
                lo++;
            } else {
                hi++;
            }
        }
        return shortestSubarry;
    }

    public void run() {
        int[] arr = { 1, 2, 3, 10, 4, 2, 3, 5 };
        System.out.println(findLengthOfShortestSubarray(arr));
    }
}
