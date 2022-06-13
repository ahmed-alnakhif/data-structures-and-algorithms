package Problems.Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class HasCommonAncestor {

    private Map<Integer, List<Integer>> graph;
    private Set<Integer> visited;
    private boolean found;

    public HasCommonAncestor(int[][] pairs){
      graph = generateGraph(pairs);
      visited = new HashSet<>();
      found = false;
    }

    public static Map<Integer, List<Integer>> generateGraph(int[][] pairs) {
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int[] pair : pairs) {
            int child = pair[1], parent = pair[0];

            graph.putIfAbsent(child, new ArrayList<>());
            graph.get(child).add(parent);
        }

        return graph;
    }

    public boolean hasCommonAncestor(int[][] pairs, int node1, int node2) {
        visited = new HashSet<>();
        dfs(node1);
        dfs(node2);

        return found;
    }

    private void dfs(int node) {
        if (!graph.containsKey(node)) return;
        if (graph.get(node).isEmpty()) return;
        if (visited.contains(node)) {
            found = true;
            return;
        }

        visited.add(node);

        for (int parent : graph.get(node)) {
            dfs(parent);
        }
    }

    public void printGraph() {
        System.out.println(this.graph);
    }

    public static void main(String[] argv) {
        int[][] pairs = new int[][] {
                { 1, 3 }, { 2, 3 }, { 3, 6 }, { 5, 6 }, { 5, 7 }, { 4, 5 }, { 15, 21 },
                { 4, 8 }, { 4, 9 }, { 9, 11 }, { 14, 4 }, { 13, 12 }, { 12, 9 },
                { 15, 13 }
        };

        HasCommonAncestor solution = new HasCommonAncestor(pairs);

        // System.out.println(solution.hasCommonAncestor(pairs, 3, 8)); // => false
        // System.out.println(solution.hasCommonAncestor(pairs, 5, 8)); // => true
        // System.out.println(solution.hasCommonAncestor(pairs, 6, 8)); // => true
        // System.out.println(solution.hasCommonAncestor(pairs, 6, 9)); // => true
        System.out.println(solution.hasCommonAncestor(pairs, 1, 3)); // => false
        System.out.println(solution.hasCommonAncestor(pairs, 3, 1)); // => false
        // System.out.println(solution.hasCommonAncestor(pairs, 7, 11)); // => true
        // System.out.println(solution.hasCommonAncestor(pairs, 6, 5)); // => true
        // System.out.println(solution.hasCommonAncestor(pairs, 5, 6)); // => true
        // System.out.println(solution.hasCommonAncestor(pairs, 3, 6)); // => true
        // System.out.println(solution.hasCommonAncestor(pairs, 21, 11)); // => true
    }
}
