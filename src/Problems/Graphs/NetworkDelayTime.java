package Problems.Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * You are given a network of n nodes, labeled from 1 to n. You are also given
 * times, a list of travel times as directed edges times[i] = (ui, vi, wi),
 * where ui is the source node, vi is the target node, and wi is the time it
 * takes for a signal to travel from source to target.
 * 
 * We will send a signal from a given node k. Return the time it takes for all
 * the n nodes to receive the signal. If it is impossible for all the n nodes to
 * receive the signal, return -1.
 * 
 * Example 1:
 * Input: times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
 * Output: 2
 * 
 * Example 2:
 * Input: times = [[1,2,1]], n = 2, k = 1
 * Output: 1
 */


public class NetworkDelayTime {
    
    public int networkDelayTime(int[][] times, int N, int source) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[1] - b[1]));
        boolean[] visited = new boolean[N + 1];
        int[] signalTimes = new int[N + 1];

        for (int[] time : times) {
            graph.putIfAbsent(time[0], new ArrayList<>());
            graph.get(time[0]).add(new int[] { time[1], time[2] });
        }

        Arrays.fill(signalTimes, Integer.MAX_VALUE);
        signalTimes[source] = 0;

        pq.offer(new int[] { source, 0 });
        int max = 0;
        int count = N;

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int currNode = curr[0], currTime = curr[1];

            if (visited[currNode]) continue;
            visited[currNode] = true;

            max = currTime;
            count--;

            if (!graph.containsKey(currNode)) continue;

            for (int[] adj : graph.get(currNode)) {
                int adjNode = adj[0], adjTime = adj[1];

                if (signalTimes[currNode] + adjTime < signalTimes[adjNode]) {
                    signalTimes[adjNode] = signalTimes[currNode] + adjTime;
                    pq.offer(new int[] { adjNode, signalTimes[adjNode] });
                }
            }
        }

        return count == 0 ? max : -1;
    }

    public static void main(String[] args) {
        NetworkDelayTime nd = new NetworkDelayTime();
        int[][] times = new int[][] { { 2, 1, 1 }, { 2, 3, 1 }, { 3, 4, 1 } };
        int n = 4, k = 2;
        System.out.println(nd.networkDelayTime(times, n, k));
    }
}
