package Problems.dynamicProgramming.tabulation;

public class Fib {

    public static long fibSequence(int n) {
        long[] table = new long[n + 1];
        table[0] = 0;
        table[1] = 1;

        for (int i = 2; i <= n; i++) {
            table[i] = table[i - 1] + table[i - 2];
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
