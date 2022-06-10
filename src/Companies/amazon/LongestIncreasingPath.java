package Companies.amazon;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestIncreasingPath {

    boolean[] visited;
    int max;
    public int longestIncreasingPath(Map<Integer, List<Integer>> graph) {
        visited = new boolean[graph.size()+1];
        max = 0;
        
        for(int source : graph.keySet()) {
            dfs(graph, source, 1);
            visited = new boolean[graph.size()+1];
        }

        return max;
    }

    private void dfs(Map<Integer, List<Integer>> graph, int source, int count) {
        if (visited[source]) return;

        visited[source] = true;
        
        
        for (int adj : graph.get(source)) {
            if(source < adj){
                dfs(graph, adj, count + 1);
            }
        }

        max = Math.max(max, count);
    }

    public static void main(String[] args) {
        LongestIncreasingPath l = new LongestIncreasingPath();
        Map<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(0, List.of(3, 5));
        graph.put(2, List.of(4));
        graph.put(3, List.of(0, 4));
        graph.put(4, List.of(2, 3, 6));
        graph.put(5, List.of(0, 6));
        graph.put(6, List.of(4, 5));

        System.out.println(l.longestIncreasingPath(graph));
    }
}