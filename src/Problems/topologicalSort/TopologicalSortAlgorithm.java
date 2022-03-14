package Problems.topologicalSort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class TopologicalSortAlgorithm {

    public List<Integer> topologicalSort(int[] nodes, int[][] edges) {

        // 1. Initialize the graph
        Map<Integer, Integer> inDegree = new HashMap<>(); // count of incoming edges for every vertex
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int node : nodes) {
            inDegree.put(node, 0);
            graph.put(node, new ArrayList<Integer>());
        }

        // 2. Build the graph
        for (int i = 0; i < edges.length; i++) {
            int parent = edges[i][0];
            int child = edges[i][1];

            graph.get(parent).add(child); // put the child into it's parent's list
            inDegree.put(child, inDegree.get(child) + 1); // increment child's inDegree
        }

        // 3. Find all sources i.e., all nodes with 0 in-degrees
        Queue<Integer> sourcesQueue = new LinkedList<>();
        inDegree.forEach((key, val)->{
            if(val == 0){
                sourcesQueue.add(key);
            }
        });

        List<Integer> sortedResult = new ArrayList<>();

        // 4. For each source, add it to the sortedOrder and subtract one from all of
        // its children's in-degrees
        // if a child's in-degree becomes zero, add it to the sources queue
        while (!sourcesQueue.isEmpty()) {
            int node = sourcesQueue.poll();
            sortedResult.add(node);
            for (int child : graph.get(node)) { // get the node's children to decrement their in-degrees
                inDegree.put(child, inDegree.get(child) - 1);
                if (inDegree.get(child) == 0) {
                    sourcesQueue.add(child);
                }
            }
        }

        // if we couldn't add all nodes, then topological sort is not possible as the
        // graph has a cycle
        if (sortedResult.size() != nodes.length) {
            return new ArrayList<>();
        }

        return sortedResult;
    }

    public static void main(String[] args) {
        TopologicalSortAlgorithm tSortAlgorithm = new TopologicalSortAlgorithm();
        int[] vertices1 = { 0, 1, 2, 3, 4, 5, 6 };
        int[][] edges1 = {
                { 6, 4 },
                { 6, 2 },
                { 5, 3 },
                { 5, 4 },
                { 4, 1 },
                { 3, 0 },
                { 3, 1 },
        };

        List<Integer> result1 = tSortAlgorithm.topologicalSort(vertices1, edges1);
        System.out.println(result1);
    }

}
