package Problems.modifiedBinarySearch;

/**
 * This is an interactive problem.
 * 
 * You have a sorted array of unique elements and an unknown size. You do not
 * have an access to the array but you can use the ArrayReader interface to
 * access it. You can call ArrayReader.get(i) that:
 * 
 * returns the value at the ith index (0-indexed) of the secret array (i.e.,
 * secret[i]), or
 * returns 231 - 1 if the i is out of the boundary of the array.
 * You are also given an integer target.
 * 
 * Return the index k of the hidden array where secret[k] == target or return -1
 * otherwise.
 * 
 * You must write an algorithm with O(log n) runtime complexity.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: secret = [-1,0,3,5,9,12], target = 9
 * Output: 4
 * Explanation: 9 exists in secret and its index is 4.
 */

class ArrayReader {
    public int get(int index) {
        return index; // this is just a workaround. should return value at index
    }
}

public class SearchSortedArrayOfUnknownSize {

    public int search(ArrayReader reader, int target) {
        int left = 0, right = 1;

        while (reader.get(right) < target) {
            left = right;
            right *= 2;
        }

        while (left <= right) {
            int mid = left + ((right - left) / 2);
            if (reader.get(mid) == target) {
                return mid;
            } else if (reader.get(mid) > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

    }
}
