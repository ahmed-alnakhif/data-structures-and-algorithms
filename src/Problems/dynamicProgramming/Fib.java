package Problems.dynamicProgramming;

import java.util.HashMap;
import java.util.Map;

public class Fib {

    Map<Integer, Long> memoMap;

    public long fibSequenceMemo(int n) {
        memoMap = new HashMap<>();
        return fib(n);
    }

    public long fib(int n) {
        if (memoMap.containsKey(n)) return memoMap.get(n);
        if(n==0) return 0;
        if(n==1) return 1;

        memoMap.put(n, fib(n - 1) + fib(n - 2));

        return memoMap.get(n);
    }

    public long fibSequenceTab(int n) {
        long[] table = new long[n + 1];
        table[0] = 0;
        table[1] = 1;

        for (int i = 2; i <= n; i++) {
            table[i] = table[i - 1] + table[i - 2];
        }

        return table[n];
    }

    public void run() {
        System.out.println(fibSequenceMemo(6)); // 8
        System.out.println(fibSequenceMemo(7)); // 13
        System.out.println(fibSequenceMemo(8)); // 21
        System.out.println(fibSequenceMemo(50)); // 12586269025
    }
}
