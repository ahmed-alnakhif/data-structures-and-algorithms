package algorithms.graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * find the shortest path from a source to another node in a graph
 */

class Pair {
    String node;
    int dest;

    public Pair(String node, int dest) {
        this.node = node;
        this.dest = dest;
    }
}

public class Dijkstra {

    public List<String> findShortestPath(String[] nodes, String[][] edges, String source, String target) {
        Set<String> shortestPath = new LinkedHashSet<>();
        Map<String, List<Pair>> graph = new HashMap<>();
        Map<String, Integer> destMap = new HashMap<>();
        Map<String, String> parentsMap = new HashMap<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>(
                (a, b) -> a.dest == b.dest ? a.node.compareTo(b.node) : a.dest - b.dest);
        Set<String> visited = new HashSet<>();

        for (String[] edge : edges) {
            graph.putIfAbsent(edge[0], new ArrayList<>());
            graph.get(edge[0]).add(new Pair(edge[1], Integer.parseInt(edge[2])));
        }

        for (String node : nodes) {
            destMap.put(node, Integer.MAX_VALUE);
            parentsMap.put(node, null);
        }
        destMap.put(source, 0);

        pq.offer(new Pair(source, 0));

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();

            if (visited.contains(curr.node)) continue;
            visited.add(curr.node);

            if(!graph.containsKey(curr.node)) continue;

            for (Pair adjNode : graph.get(curr.node)) {
                if (destMap.get(curr.node) + adjNode.dest < destMap.get(adjNode.node)) {
                    destMap.put(adjNode.node, adjNode.dest + destMap.get(curr.node));
                    parentsMap.put(adjNode.node, curr.node);
                }
                pq.offer(new Pair(adjNode.node, destMap.get(adjNode.node)));
            }
        }

        String curr = target;
        while(curr != null){
            shortestPath.add(curr);
            curr = parentsMap.get(curr);
        }

        List<String> result =  new ArrayList<>(shortestPath);
        Collections.reverse(result);
        return result;
    }

    public static void main(String[] args) {
        String[] nodes = { "A", "B", "C", "D", "E" };
        String[][] edges = new String[][] {
                { "A", "B", "1" },
                { "A", "C", "1" },
                { "A", "D", "3" },
                { "B", "E", "1" },
                { "B", "D", "2" },
                { "C", "D", "1" },
                { "D", "E", "2" },
        };
        Dijkstra d = new Dijkstra();
        System.out.println(d.findShortestPath(nodes, edges, "A", "E"));
    }
}
