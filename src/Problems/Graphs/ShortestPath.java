package Problems.Graphs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * return the shortest number of edges from x to y
 */

public class ShortestPath {
    List<Integer> result = new LinkedList<>();

    int bfs(Map<Integer, List<Integer>> graph, int source, int dest) {
        HashSet<Integer> visited = new LinkedHashSet<>();
        Queue<List<Integer>> queue = new LinkedList<>();

        queue.add(List.of(source, 0));
        while (!queue.isEmpty()) {
            List<Integer> node = queue.poll();
            Integer nodeLabel = node.get(0);
            Integer nodeWeight = node.get(1);
            visited.add(nodeLabel);

            if(nodeLabel == dest){
                return nodeWeight;
            }

            for (Integer adjNode : graph.get(nodeLabel)) {
                if (!visited.contains(adjNode)) {
                    queue.add(List.of(adjNode, nodeWeight + 1));
                }
            }
        }
        return 0;
    }

    int shortestPath(Map<Integer, List<Integer>> graph, int source, int dest) {
        return bfs(graph, source, dest);
    }

    Map<Integer, List<Integer>> generateGraph() {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(1, List.of(2, 5));
        graph.put(2, List.of(1, 3));
        graph.put(3, List.of(2, 6));
        graph.put(4, List.of(5, 7));
        graph.put(5, List.of(4, 1));
        graph.put(6, List.of(3, 4));
        graph.put(7, List.of(4, 8));
        graph.put(8, List.of(7, 6));

        return graph;
    }

    public void run() {
        Map<Integer, List<Integer>> graph = generateGraph();
        System.out.println(graph);
        System.out.println(shortestPath(graph, 1, 6));
    }
}
