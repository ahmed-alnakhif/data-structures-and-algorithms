package Companies.facebook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a list of n integers arr[0..(n-1)], determine the number of different
 * pairs of elements within it which sum to k.
 * If an integer appears in the list multiple times, each copy is considered to
 * be different; that is, two pairs are considered different if one pair
 * includes at least one array index which the other doesn't, even if they
 * include the same values.
 */

public class PairSums {
    //{ 1, 2, 3, 4, 3 };  6
    //{ 1, 5, 3, 3, 3 };  6
    
    int count;
    List<List<Integer>> result;
    List<Integer> currComb;
    int numberOfWays3(int[] nums, int target) {
        result = new ArrayList<>();
        currComb = new ArrayList<>();
        count = 0;
        comb(nums, target, 0);
        return count;
    }

    void comb(int[] nums, int target, int index) {
        if (target < 0 ) {
            return;
        }

        if (target == 0 && currComb.size() == 2) { //it has to be a pair (only 2 elements)
            result.add(new ArrayList<>(currComb));
            count++;
            return;
        }

        for (int i = index; i < nums.length; i++) {
            currComb.add(nums[i]);
            comb(nums, target - nums[i], i + 1);
            currComb.remove(currComb.size() - 1);
        }
    }

    int numberOfWays(int[] nums, int targetSum) {
        int count = 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int comp = targetSum - entry.getKey();
            if (map.containsKey(comp)) {
                // if the key is the same number, we need to decrement by one
                if (comp == entry.getKey()) {
                    count += entry.getValue() * (map.get(comp) - 1);
                } else {
                    count += entry.getValue() * map.get(comp);
                }
            }
        }

        // divide by 2 since found complements will be counted twice
        return count / 2;
    }

    int numberOfWays2(int[] nums, int targetSum) {
        Arrays.sort(nums);
        int count = 0;

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int num = nums[left] + nums[right];
            if (num == targetSum) {
                count++;
                left++;
            } else if (num > targetSum) {
                right--;
            } else {
                left++;
            }
        }

        return count;
    }

    int test_case_number = 1;

    void check(int expected, int output) {
        boolean result = (expected == output);
        char rightTick = '\u2713';
        char wrongTick = '\u2717';
        if (result) {
            System.out.println(rightTick + " Test #" + test_case_number);
        } else {
            System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
            printInteger(expected);
            System.out.print(" Your output: ");
            printInteger(output);
            System.out.println();
        }
        test_case_number++;
    }

    void printInteger(int n) {
        System.out.print("[" + n + "]");
    }

    public void run() {
        int k_1 = 6;
        int[] arr_1 = { 1, 2, 3, 4, 3 };
        int expected_1 = 2;
        int output_1 = numberOfWays3(arr_1, k_1);
        check(expected_1, output_1);

        int k_2 = 6;
        int[] arr_2 = { 1, 5, 3, 3, 3 };
        int expected_2 = 4;
        int output_2 = numberOfWays3(arr_2, k_2);
        check(expected_2, output_2);
    }

    public static void main(String[] args) {
        new PairSums().run();
    }
}
