package Problems.hashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Q2) Given a table "FollowerRelationship" with two columns - Follower Followee
 * 1 ->2
 * 2 ->3
 * 1 -> 4
 * 3 -> 2
 * 
 * Identify all the pairs such that A follows B and B also follows A.
 * 
 * Followup: If this data is not huge and can fit in memory, what approach would
 * you take to identify these pairs ?
 */

public class FollowerRelationship {

    public List<int[]> getFollowersPair(int[][] relationships) {
        List<int[]> pairs = new ArrayList<>();
        Map<Integer, Set<Integer>> map = new HashMap<>();

        for (int[] relationship : relationships) {
            int follower = relationship[0], followee = relationship[1];

            if (!map.containsKey(follower)) {
                map.put(follower, new HashSet<>());
            }
            map.get(follower).add(followee);

            if (map.containsKey(followee) && map.get(followee).contains(follower)) {
                pairs.add(new int[] { follower, followee });
            }
        }

        return pairs;
    }

    public static void main(String[] args) {
        FollowerRelationship fr = new FollowerRelationship();
        int[][] relationships = new int[][] { { 1, 2 }, { 2, 3 }, { 1, 4 }, { 3, 2 } };
        List<int[]> pairs = fr.getFollowersPair(relationships);
        for (int[] pair : pairs) {
            System.out.println(pair[0] + "," + pair[1]);
        }
    }
}
