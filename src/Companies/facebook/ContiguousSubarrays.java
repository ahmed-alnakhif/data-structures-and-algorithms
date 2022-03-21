package Companies.facebook;

import java.util.Stack;

public class ContiguousSubarrays {

    int[] countSubarrays(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[] output = new int[arr.length];

        // Train's moving from L to R, picking up indices and carrying as max on left
        for (int i = 0; i < arr.length; i++) {
            // Drop off everyone that is too small
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                output[i] += output[stack.pop()];
            }
            stack.push(i);

            // increment by one since each cell returns 1
            output[i]++;
        }
        stack.clear();

        //we use a temp array so we can count fresh values for left move
        int[] temp = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                int idx = stack.pop();
                output[i] += temp[idx];
                temp[i] += temp[idx];
            }
            stack.push(i);
            temp[i]++;
        }

        return output;
    }

    // T: O(N^2), S: O(1)
    int[] countSubarrays2(int[] arr) {
        int[] output = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            int count = 1;

            // explore left
            for (int j = i; j >= 0; j--) {
                if (j - 1 >= 0 && arr[i] > arr[j - 1]) {
                    count++;
                } else {
                    break;
                }
            }

            // explore right
            for (int j = i; j < arr.length; j++) {
                if (j + 1 < arr.length && arr[i] > arr[j + 1]) {
                    count++;
                } else {
                    break;
                }
            }

            output[i] = count;
        }

        return output;
    }

    int test_case_number = 1;

    void check(int[] expected, int[] output) {
        int expected_size = expected.length;
        int output_size = output.length;
        boolean result = true;
        if (expected_size != output_size) {
            result = false;
        }
        for (int i = 0; i < Math.min(expected_size, output_size); i++) {
            result &= (output[i] == expected[i]);
        }
        char rightTick = '\u2713';
        char wrongTick = '\u2717';
        if (result) {
            System.out.println(rightTick + " Test #" + test_case_number);
        } else {
            System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
            printIntegerArray(expected);
            System.out.print(" Your output: ");
            printIntegerArray(output);
            System.out.println();
        }
        test_case_number++;
    }

    void printIntegerArray(int[] arr) {
        int len = arr.length;
        System.out.print("[");
        for (int i = 0; i < len; i++) {
            if (i != 0) {
                System.out.print(", ");
            }
            System.out.print(arr[i]);
        }
        System.out.print("]");
    }

    public void run() {
        int[] test_1 = { 3, 4, 1, 6, 2 };
        int[] expected_1 = { 1, 3, 1, 5, 1 };
        int[] output_1 = countSubarrays(test_1);
        check(expected_1, output_1);

        int[] test_2 = { 2, 4, 7, 1, 5, 3 };
        int[] expected_2 = { 1, 2, 6, 1, 3, 1 };
        int[] output_2 = countSubarrays(test_2);
        check(expected_2, output_2);

        // Add your own test cases here

    }

    public static void main(String[] args) {
        new ContiguousSubarrays().run();
    }
}
