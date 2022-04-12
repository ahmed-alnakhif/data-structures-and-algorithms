package Problems.combination;

import java.util.LinkedList;
import java.util.List;

/**
 * Given two integers n and k, return all possible combinations of k numbers out
 * of the range [1, n].
 * 
 * You may return the answer in any order.
 * 
 * 
 * Example 1:
 * 
 * Input: n = 4, k = 2
 * Output:
 * [ [2,4], [3,4], [2,3], [1,2], [1,3], [1,4] ]
 */

public class Combinations {
    List<List<Integer>> result = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        combination(1, n, k, new LinkedList<>());
        return result;
    }

    private void combination(int start, int n, int k, LinkedList<Integer> comb) {
        if (comb.size() == k) {
            result.add(new LinkedList<>(comb));
            return;
        }

        // optimization -> return if there aren't enough numbers left to fill the
        // partial comb list up to k
        if (k - comb.size() > n - start + 1) {
            return;
        }

        for (int i = start; i < n + 1; i++) {
            comb.add(i);
            combination(i + 1, n, k, comb);
            comb.removeLast();
        }
    }

    public static void main(String[] args) {
        Combinations c = new Combinations();
        System.out.println(c.combine(4, 2));
    }
}
