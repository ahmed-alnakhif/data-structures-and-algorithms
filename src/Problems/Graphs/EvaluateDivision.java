package Problems.Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/**
 * You are given an array of variable pairs equations and an array of real
 * numbers values, where equations[i] = [Ai, Bi] and values[i] represent the
 * equation Ai / Bi = values[i]. Each Ai or Bi is a string that represents a single variable.
 * 
 * You are also given some queries, where queries[j] = [Cj, Dj] represents the
 * jth query where you must find the answer for Cj / Dj = ?.
 * 
 * Return the answers to all queries. If a single answer cannot be determined, return -1.0.
 * 
 * Note: The input is always valid. You may assume that evaluating the queries
 * will not result in division by zero and that there is no contradiction.
 * 
 * 
 * Example 1:
 * 
 * Input: equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
 * Output: [6.00000,0.50000,-1.00000,1.00000,-1.00000]
 * Explanation:
 * Given: a / b = 2.0, b / c = 3.0
 * queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
 * return: [6.0, 0.5, -1.0, 1.0, -1.0 ]
 */

public class EvaluateDivision {
    Map<String, Map<String, Double>> graph = new HashMap<>();

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        generateGraph(equations, values);

        double[] results = new double[queries.size()];

        for (int i = 0; i < queries.size(); i++) {
            String dividend = queries.get(i).get(0);
            String divisor = queries.get(i).get(1);

            // check if both nodes exists in our graph
            if (!graph.containsKey(dividend) || !graph.containsKey(divisor)) {
                results[i] = -1.0;
            }

            // x/x = 1
            else if (dividend == divisor) {
                results[i] = 1.0;
            }

            // perform dfs and calcuate accumulative product
            else {
                results[i] = DFS(dividend, divisor, new HashSet<>());
            }
        }

        return results;
    }

    public void generateGraph(List<List<String>> equations, double[] values) {
        for (int i = 0; i < equations.size(); i++) {
            String start = equations.get(i).get(0);
            String end = equations.get(i).get(1);
            Double ratio = values[i];
            graph.putIfAbsent(start, new HashMap<>());
            graph.get(start).put(end, ratio);
            graph.putIfAbsent(end, new HashMap<>());
            graph.get(end).put(start, 1.0 / ratio);
        }
    }

    public double DFS(String currNode, String targetNode, HashSet<String> visited) {
        // return -1; meaning that we have explored this path before
        if (visited.contains(currNode)) {
            return -1;
        }

        // check if we have the targeted node in our adjacent nodes
        if (graph.get(currNode).containsKey(targetNode)) {
            return graph.get(currNode).get(targetNode);
        }

        visited.add(currNode);

        // explore each adjacent node
        for (String adj : graph.get(currNode).keySet()) {
            double accumlitiveProduct = DFS(adj, targetNode, visited);

            // if result of DFS is not -1, then there was a path, and therefore, we calcuate
            // the accumlitive product
            if (accumlitiveProduct != -1) {
                return accumlitiveProduct * graph.get(currNode).get(adj);
            }
        }

        // if we reach this point, then there is no path to the target node, so we return -1;
        return -1;
    }

    public void run() {
        List<String> eq1 = new ArrayList<>(List.of("a", "b"));
        List<String> eq2 = new ArrayList<>(List.of("b", "c"));
        List<List<String>> equations = new ArrayList<>(List.of(eq1, eq2));
        
        double[] values = {2.0, 3.0};

        List<String> query1 = new ArrayList<>(List.of("a", "c"));
        List<String> query2 = new ArrayList<>(List.of("b", "a"));
        List<String> query3 = new ArrayList<>(List.of("a", "e"));
        List<String> query4 = new ArrayList<>(List.of("a", "a"));
        List<String> query5 = new ArrayList<>(List.of("x", "x"));
        List<List<String>> queries = new ArrayList<>(List.of(query1, query2, query3, query4, query5));

        System.out.println(calcEquation(equations, values, queries));
    }
}
