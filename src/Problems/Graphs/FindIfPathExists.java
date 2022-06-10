package Problems.Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * There is a bi-directional graph with n vertices, where each vertex is labeled
 * from 0 to n - 1 (inclusive). The edges in the graph are represented as a 2D
 * integer array edges, where each edges[i] = [ui, vi] denotes a bi-directional
 * edge between vertex ui and vertex vi. Every vertex pair is connected by at
 * most one edge, and no vertex has an edge to itself.
 * 
 * You want to determine if there is a valid path that exists from vertex source
 * to vertex destination.
 * 
 * Given edges and the integers n, source, and destination, return true if there
 * is a valid path from source to destination, or false otherwise.
 * 
 * 
 * Input: n = 3, edges = [[0,1],[1,2],[2,0]], source = 0, destination = 2
 * Output: true
 * Explanation: There are two paths from vertex 0 to vertex 2:
 * - 0 → 1 → 2
 * - 0 → 2
 */

public class FindIfPathExists {
    
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if(edges.length == 0) return true;
        
        Map<Integer, List<Integer>> graph = generateGraph(n, edges);
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> seen = new HashSet<>();
        
        queue.offer(source);
        
        while(!queue.isEmpty()){
            int node = queue.poll();
            seen.add(node);
            
            for(int adj : graph.get(node)){
                if(adj == destination) return true;
                if(!seen.contains(adj)){
                    queue.offer(adj);
                }
            }
        }
        
        return false;
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
        FindIfPathExists obj = new FindIfPathExists();
        System.out.println(obj.validPath(3, new int[][]{{0,1},{1,2},{2,0}}, 0, 2));
    }
}
