package Problems.Graphs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/**
 * return the number of nodes in the largest connected component in a graph
 */

public class LargestComponent {
    HashSet<Integer> visited = new HashSet<>();

    int largestComponent(Map<Integer, List<Integer>> graph) {
        int max = 0;

        for (Map.Entry<Integer, List<Integer>> entry : graph.entrySet()) {
            max = Math.max(max, dfs(entry.getKey(), graph, 0));
        }

        return max;
    }

    int dfs(int source, Map<Integer, List<Integer>> graph, int count) {
        if (visited.contains(source)) return count;

        visited.add(source);
        count++;
        
        for (Integer node : graph.get(source)) {
            count = dfs(node, graph, count);
        }
        
        return count;
    }

    Map<Integer, List<Integer>> generateGraph() {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(0, List.of(8, 1, 5));
        graph.put(1, List.of(0));
        graph.put(2, List.of(3, 4, 7));
        graph.put(3, List.of(2, 4));
        graph.put(4, List.of(3, 2));
        graph.put(5, List.of(0, 8));
        graph.put(6, List.of(7));
        graph.put(7, List.of(2, 6));
        graph.put(8, List.of(0, 5));

        return graph;
    }

    public static void main(String[] args) {
        LargestComponent obj = new LargestComponent();
        Map<Integer, List<Integer>> graph = obj.generateGraph();
        System.out.println(obj.largestComponent(graph));
    }
}
