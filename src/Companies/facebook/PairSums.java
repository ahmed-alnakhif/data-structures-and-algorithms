package Companies.facebook;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PairSums {

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

        //divide by 2 since found complements will be counted twice 
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
        int output_1 = numberOfWays(arr_1, k_1);
        check(expected_1, output_1);

        int k_2 = 6;
        int[] arr_2 = { 1, 5, 3, 3, 3 };
        int expected_2 = 4;
        int output_2 = numberOfWays(arr_2, k_2);
        check(expected_2, output_2);
    }

    public static void main(String[] args) {
        new PairSums().run();
    }
}
