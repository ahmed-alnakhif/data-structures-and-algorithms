package Problems.topologicalSort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * There are a total of numCourses courses you have to take, labeled from 0 to
 * numCourses - 1. You are given an array prerequisites where prerequisites[i] =
 * [ai, bi] indicates that you must take course bi first if you want to take
 * course ai.
 * 
 * For example, the pair [0, 1], indicates that to take course 0 you have to
 * first take course 1.
 * Return true if you can finish all courses. Otherwise, return false.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: numCourses = 2, prerequisites = [[1,0]]
 * Output: true
 * Explanation: There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0. So it is possible.
 * Example 2:
 * 
 * Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
 * Output: false
 * Explanation: There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0, and to take course 0 you
 * should also have finished course 1. So it is impossible.
 */

public class AllTaskSchedulingOrders {

    List<List<Integer>> result;
    HashMap<Integer, Integer> inDegree;
    HashMap<Integer, List<Integer>> graph;

    public List<List<Integer>> schedulingOrders(int tasks, int[][] prerequisites) {
        inDegree = new HashMap<>();
        graph = new HashMap<>();
        result = new ArrayList<>();

        for (int i = 0; i < tasks; i++) {
            inDegree.put(i, 0);
            graph.put(i, new ArrayList<Integer>());
        }

        for (int i = 0; i < prerequisites.length; i++) {
            int parent = prerequisites[i][0], child = prerequisites[i][1];
            graph.get(parent).add(child);
            inDegree.put(child, inDegree.get(child) + 1);
        }

        Queue<Integer> sources = new LinkedList<>();
        inDegree.forEach((key, val) -> {
            if (val == 0) {
                sources.add(key);
            }
        });

        getAllPathsRecursive(sources, new ArrayList<>());

        return result;
    }

    private void getAllPathsRecursive(Queue<Integer> sources, List<Integer> sortedOrder) {
        if (!sources.isEmpty()) {
            for (Integer node : sources) {
                Queue<Integer> sourcesForNextCall = new LinkedList<>(sources); // make a deep copy

                // only remove curr source, all other sources should remain for the next call
                sourcesForNextCall.remove(node);
                sortedOrder.add(node);
                for (int child : graph.get(node)) {
                    inDegree.put(child, inDegree.get(child) - 1);
                    if (inDegree.get(child) == 0) {
                        sourcesForNextCall.add(child); // save the new source for the next call
                    }
                }

                

                // recursive call to print other orderings from the remaining (and new) sources
                getAllPathsRecursive(sourcesForNextCall, sortedOrder);

                // backtrack, remove the vertex from list and increment back in-degree value
                sortedOrder.remove(node);
                for (int child : graph.get(node)) {
                    inDegree.put(child, inDegree.get(child) + 1);
                }
            }
        }

        // if sortedOrder doesn't contain all tasks, either we've a cycle
        // or we have not processed all the tasks in this recursive call
        if (sortedOrder.size() == inDegree.size()) {
            result.add(new ArrayList<>(sortedOrder));
        }
    }

    public static void main(String[] args) {
        AllTaskSchedulingOrders allSchedulingOrders = new AllTaskSchedulingOrders();
        System.out.println(
                allSchedulingOrders.schedulingOrders(3, new int[][] { new int[] { 0, 1 }, new int[] { 1, 2 } }));

        System.out.println(allSchedulingOrders.schedulingOrders(4,
                new int[][] { new int[] { 3, 2 }, new int[] { 3, 0 }, new int[] { 2, 0 }, new int[] { 2, 1 } }));

        System.out.println(allSchedulingOrders.schedulingOrders(6,
                new int[][] { new int[] { 2, 5 }, new int[] { 0, 5 }, new int[] { 0, 4 },
                        new int[] { 1, 4 }, new int[] { 3, 2 }, new int[] { 1, 3 } }));
    }
}
