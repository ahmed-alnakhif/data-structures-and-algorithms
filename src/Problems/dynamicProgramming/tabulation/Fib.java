package Problems.dynamicProgramming.tabulation;

import java.util.HashMap;
import java.util.Map;

public class Fib {

    Map<Integer, Long> memoMap = new HashMap<>();

    public static long fibSequence(int n) {
        int[] table = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            table[i + 1] = table[i];
            table[i + 2] = table[i];
        }

        return table[n];
    }

    public static void main(String[] args) {
        System.out.println(fibSequence(6)); // 8
        System.out.println(fibSequence(7)); // 13
        System.out.println(fibSequence(8)); // 21
        System.out.println(fibSequence(50)); // 12586269025
    }
}
