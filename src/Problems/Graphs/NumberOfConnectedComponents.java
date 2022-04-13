package Problems.Graphs;


/**
 * return the number of connected component in a graph
 */

public class NumberOfConnectedComponents {

    public int countComponents(int n, int[][] edges) {
        int[][] graph = generateGraph(n, edges);
        boolean[] visited = new boolean[graph.length];
        int count = 0;

        for (int i = 0; i < graph.length; i++) {
            if (dfs(graph, i, visited)) {
                count++;
            }
        }

        return count;
    }

    private boolean dfs(int[][] graph, int index, boolean[] visited) {
        if (visited[index]) return false;

        visited[index] = true;

        for (int i = 0; i < graph.length; i++) {
            if (!visited[i] && graph[index][i] == 1) {
                dfs(graph, i, visited);
            }
        }

        return true;
    }

    private int[][] generateGraph(int n, int[][] edges) {
        int[][] graph = new int[n][n];

        for (int i = 0; i < n; i++) {
            graph[i][i] = 1;
        }

        for (int[] edge : edges) {
            graph[edge[0]][edge[1]] = 1;
            graph[edge[1]][edge[0]] = 1;
        }

        return graph;
    }

    public static void main(String[] args) {
        NumberOfConnectedComponents obj = new NumberOfConnectedComponents();
        System.out.println(obj.countComponents(3, new int[][] { { 0, 1 }, { 1, 2 }, { 2, 0 } }));
    }

}
