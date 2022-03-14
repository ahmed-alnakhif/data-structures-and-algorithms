package dataStructures;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

/**
 * Graph:
 * - it's the relationship between nodes.
 * - Graph = nodes + edges
 * - e.g: nodes are courses and edges are prerequisites, nodes are cities and
 * edges are the roads
 * 
 * Edge/Vertix:
 * - it's the connection between nodes
 * 
 * Directed Graph:
 * - edges have a direction
 * 
 * Undirected Graph:
 * - no direction between nodes
 * 
 * Neighbor nodes:
 * - nodes that are connected with an edge
 * 
 * Ways to represent graphs:
 * 1) adjacency list
 * 2) adjacency matrix
 * 3) adjacency set
 * 
 * Has path complexity
 * n = # nodes
 * e = # edges
 * Time: O(e) or O(n^2)
 * Space: O(n)
 */

public class Graph {

    Map<String, List<String>> adjList = new HashMap<>();

    void addNode(String label) {
        adjList.putIfAbsent(label, new ArrayList<>());
    }

    void removeNode(String label) {
        List<String> toRemoveNodeList = adjList.get(label);
        for (String adjNode : toRemoveNodeList) {
            adjList.get(adjNode).remove(label);
        }
    }

    void addEdge(String from, String to) {
        getAdjNodes(from).add(to);
    }

    void removeEdge(String label1, String label2) {
        getAdjNodes(label1).remove(label2);
        getAdjNodes(label2).remove(label1);
    }

    List<String> getAdjNodes(String label) {
        return adjList.get(label);
    }

    Set<String> DFSWithRecursion(String root) {
        Set<String> result = new LinkedHashSet<>();
        recursiveDFS(result, root);
        return result;
    }

    void recursiveDFS(Set<String> visited, String source) {
        visited.add(source);
        for (String node : getAdjNodes(source)) {
            recursiveDFS(visited, node);
        }
    }

    Set<String> DFSWithStack(String root) {
        Set<String> visited = new LinkedHashSet<>();
        Stack<String> stack = new Stack<>();

        stack.push(root);
        while (!stack.isEmpty()) {
            String node = stack.pop();
            if (!visited.contains(node)) {
                visited.add(node);
                for (String adjNode : getAdjNodes(node)) {
                    stack.push(adjNode);
                }
            }
        }
        return visited;
    }

    Set<String> BFS(String root) {
        Set<String> visited = new LinkedHashSet<>();
        Queue<String> queue = new LinkedList<>();

        queue.add(root);
        while (!queue.isEmpty()) {
            String node = queue.poll();
            if (!visited.contains(node)) {
                visited.add(node);
                for (String adjNode : getAdjNodes(node)) {
                    queue.add(adjNode);
                }
            }
        }
        return visited;
    }

    boolean hasPath(String source, String destination) {
        if (source == destination) {
            return true;
        }

        for (String node : getAdjNodes(source)) {
            return hasPath(node, destination);
        }

        return false;
    }

    void generateGraph() {
        addNode("a");
        addNode("b");
        addNode("c");
        addNode("d");
        addNode("e");
        addNode("f");
        addEdge("a", "b");
        addEdge("a", "c");
        addEdge("b", "d");
        addEdge("c", "e");
        addEdge("d", "f");
    }

    public void run() {
        generateGraph();
        System.out.println(adjList);
        System.out.println("dfs:" + DFSWithRecursion("a"));
        System.out.println("DFS:" + DFSWithStack("a"));
        System.out.println("BFS:" + BFS("a"));
        System.out.println("has path: " + hasPath("d", "c"));
    }
}
