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

public class CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 1. init graph and inDegree map
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        HashMap<Integer, Integer> inDegree = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            graph.put(i, new ArrayList<>());
            inDegree.put(i, 0);
        }

        // 2. build graph and inDegree map
        for (int i = 0; i < prerequisites.length; i++) {
            int parent = prerequisites[i][0];
            int child = prerequisites[i][1];

            graph.get(parent).add(child);
            inDegree.put(child, inDegree.get(child) + 1);
        }

        // 3. get all sources (0 in-degree nodes) to a queue
        Queue<Integer> sourcesQueue = new LinkedList<>();
        inDegree.forEach((key, val) -> {
            if (val == 0) {
                sourcesQueue.add(key);
            }
        });

        // 4. iterate through the queue and decrease the degrees
        int coursesCount = 0;
        while (!sourcesQueue.isEmpty()) {
            int course = sourcesQueue.poll();
            coursesCount++;
            for (int child : graph.get(course)) {
                inDegree.put(child, inDegree.get(child) - 1);
                if (inDegree.get(child) == 0) {
                    sourcesQueue.add(child);
                }
            }
        }

        // 5. check if there's a cycle
        return coursesCount == numCourses;
    }

    public static void main(String[] args) {
        CourseSchedule courseSchedule = new CourseSchedule();
        System.out.println(courseSchedule.canFinish(2, new int[][] { { 0, 1 } }));
        System.out.println(courseSchedule.canFinish(2, new int[][] { { 1, 0 }, { 0, 1 } }));
    }
}
