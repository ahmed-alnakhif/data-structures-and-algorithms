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

    int dfs(int source, Map<Integer, List<Integer>> graph, int count) {
        if (visited.contains(source)) {
            return count;
        }

        visited.add(source);
        count++;
        for (Integer node : graph.get(source)) {
            count = dfs(node, graph, count);
        }
        return count;
    }

    int largestComponent(Map<Integer, List<Integer>> graph) {
        int max = 0;

        for (Map.Entry<Integer, List<Integer>> entry : graph.entrySet()) {
            int count = 0;
            if (!visited.contains(entry.getKey())) {
                count = dfs(entry.getKey(), graph, count);
                if(count > max){
                    max = count;
                }
            }
        }

        return max;
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

    public void run() {
        Map<Integer, List<Integer>> graph = generateGraph();
        System.out.println(largestComponent(graph));
    }
}
