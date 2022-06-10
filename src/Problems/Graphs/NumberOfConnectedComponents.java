package Problems.Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * return the number of connected component in a graph
 */

public class NumberOfConnectedComponents {

    boolean[] visited;
    
    public int countComponents(int n, int[][] edges) {
        visited = new boolean[n+1];
        Map<Integer, List<Integer>> graph = generateGraph(n, edges);
        int count = 0;
        
        for(int node : graph.keySet()){
            if(dfs(1, node, graph)) count++;
        }
        
        return count;
    }
    
    private boolean dfs(int count, int node, Map<Integer, List<Integer>> graph){
        if(visited[node]) return false;
        
        visited[node] = true;
        
        for(int adj : graph.get(node)){
            dfs(count, adj, graph);
        }
        
        return true;
    }
    
    private Map<Integer, List<Integer>> generateGraph(int n, int[][] edges){
        Map<Integer, List<Integer>> graph = new HashMap<>();
        
        for(int i = 0; i < n; i++){
            graph.put(i, new ArrayList<>());
        }
        
        for(int[] edge : edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        
        return graph;
    }

    public static void main(String[] args) {
        NumberOfConnectedComponents obj = new NumberOfConnectedComponents();
        System.out.println(obj.countComponents(3, new int[][] { { 0, 1 }, { 1, 2 }, { 2, 0 } }));
    }

}
