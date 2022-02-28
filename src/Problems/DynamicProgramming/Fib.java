package Problems.DynamicProgramming;

import java.util.HashMap;
import java.util.Map;

public class Fib {

    Map<Integer, Long> memoMap = new HashMap<>();

    public long fib(int n) {

        if (memoMap.containsKey(n)) {
            return memoMap.get(n);
        }

        if (n <= 2) {
            return 1;
        }

        memoMap.put(n, fib(n - 1) + fib(n - 2));

        return memoMap.get(n);
    }

    public void run() {
        System.out.println(fib(6)); // 8
        System.out.println(fib(7)); // 13
        System.out.println(fib(8)); // 21
        System.out.println(fib(50)); // 12586269025
    }
}
