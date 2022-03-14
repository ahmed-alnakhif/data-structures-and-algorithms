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

public class CourseScheduleII {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        HashMap<Integer, Integer> inDegree = new HashMap<>(); 
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        for (int course = 0; course < numCourses; course++) {
            inDegree.put(course, 0);
            graph.put(course, new ArrayList<Integer>());
        }

        for (int i = 0; i < prerequisites.length; i++) {
            int parent = prerequisites[i][1];
            int child = prerequisites[i][0];

            graph.get(parent).add(child);
            inDegree.put(child, inDegree.get(child) + 1); 
        }

        Queue<Integer> sourcesQueue = new LinkedList<>();
        inDegree.forEach((key, val) -> {
            if (val == 0) {
                sourcesQueue.add(key);
            }
        });

        int[] sortedResult = new int[numCourses];

        int i = 0;
        while (!sourcesQueue.isEmpty()) {
            int course = sourcesQueue.poll();
            sortedResult[i++] = course;
            for (int child : graph.get(course)) {
                inDegree.put(child, inDegree.get(child) - 1);
                if (inDegree.get(child) == 0) {
                    sourcesQueue.add(child);
                }
            }
        }

        if (i != numCourses) {
            return new int[0];
        }

        return sortedResult;
    }

    public static void main(String[] args) {
        CourseSchedule courseSchedule = new CourseSchedule();
        System.out.println(courseSchedule.canFinish(2, new int[][] { { 0, 1 } }));
        System.out.println(courseSchedule.canFinish(2, new int[][] { { 1, 0 }, { 0, 1 } }));
    }
}
