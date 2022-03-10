package Problems.SlidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**

 */

public class RepeatedDNASequences {

    public List<String> findRepeatedDnaSequences(String s) {
        if (s.length() < 10)
            return new ArrayList<>();

        List<String> result = new LinkedList<>();
        HashMap<String, Integer> map = new HashMap<>();

        int left = 0, right = 9;
        String window = "";

        while (right < s.length()) {
            window = s.substring(left, right + 1);
            map.put(window, map.getOrDefault(window, 0) + 1);
            if (map.get(window) == 2)
                result.add(window);
            right++;
            left++;
        }

        return result;
    }

    public void run() {
        String DNA = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";

        System.out.println(findRepeatedDnaSequences(DNA));
    }
}
