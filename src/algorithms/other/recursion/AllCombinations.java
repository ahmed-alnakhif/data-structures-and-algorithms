package algorithms.other.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllCombinations {

    // T: O(N^2), S: O(N^2)
    public static List<List<String>> combination(List<String> elements) {
        if (elements.size() == 0) {
            List<String> list = new ArrayList<>();
            List<List<String>> res = new ArrayList<>();
            res.add(list);
            return res;
        }

        String first = elements.get(0);
        List<String> rest = elements.subList(1, elements.size());

        List<List<String>> combinationsWithoutFirst = combination(rest);
        List<List<String>> combinationsWithFirst = new ArrayList<>();

        combinationsWithoutFirst.forEach(combList -> {
            List<String> combWithFirst = new ArrayList<>(combList);
            combWithFirst.add(0, first);
            combinationsWithFirst.add(combWithFirst);
        });

        List<List<String>> result = new ArrayList<>();
        combinationsWithFirst.forEach(comb -> result.add(new ArrayList<>(comb)));
        combinationsWithoutFirst.forEach(comb -> result.add(new ArrayList<>(comb)));

        return result;
    }

    public static void main(String[] args) {
        System.out.println(combination(Arrays.asList("a", "b", "c")));
    }
}
