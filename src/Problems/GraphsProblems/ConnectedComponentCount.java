package Problems.GraphsProblems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/**
 * return the number of connected component in a graph
 */

public class ConnectedComponentCount {
    HashSet<Integer> visited = new HashSet<>();

    void dfs(int source, Map<Integer, List<Integer>> graph) {
        if (visited.contains(source)) {
            return;
        }

        visited.add(source);

        for (Integer node : graph.get(source)) {
            dfs(node, graph);
        }
    }

    int connectedComponentCount(Map<Integer, List<Integer>> graph) {
        int count = 0;

        for (Map.Entry<Integer, List<Integer>> entry : graph.entrySet()) {
            if (!visited.contains(entry.getKey())) {
                dfs(entry.getKey(), graph);
                count++;
            }
        }

        return count;
    }

    Map<Integer, List<Integer>> generateGraph() {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(1, List.of(2));
        graph.put(2, List.of(1));
        graph.put(3, List.of());
        graph.put(4, List.of(6));
        graph.put(5, List.of(6));
        graph.put(6, List.of(4, 5, 7, 8));
        graph.put(7, List.of(6));
        graph.put(8, List.of(6));

        return graph;
    }

    public void run() {
        Map<Integer, List<Integer>> graph = generateGraph();
        System.out.println(connectedComponentCount(graph));
    }
}
