package Problems.hashMap;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two maps in assertThat(map1, map2), write a function that can help the
 * user with the comparison.
 */

public class CompareHashMaps {

    public boolean assertThat(Map<String, String> map1, Map<String, String> map2) {
        if (map1.size() != map2.size()) {
            return false;
        }

        for (Map.Entry<String, String> e : map1.entrySet()) {
            if (!map2.containsKey(e.getKey())) {
                return false;
            }

            if (!map2.get(e.getKey()).equals(e.getValue())) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        CompareHashMaps chm = new CompareHashMaps();
        Map<String, String> map1 = new HashMap<>();
        map1.put("a", "b");
        map1.put("c", "d");
        map1.put("e", "f");

        Map<String, String> map2 = new HashMap<>();
        map2.put("a", "b");
        map2.put("c", "d");
        map2.put("e", "f");

        System.out.println(chm.assertThat(map1, map2));
    }
}
