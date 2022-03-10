package Problems.topKElements;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Given a characters array tasks, representing the tasks a CPU needs to do,
 * where each letter represents a different task. Tasks could be done in any
 * order. Each task is done in one unit of time. For each unit of time, the CPU
 * could complete either one task or just be idle.
 * 
 * However, there is a non-negative integer n that represents the cooldown
 * period between two same tasks (the same letter in the array), that is that
 * there must be at least n units of time between any two same tasks.
 * 
 * Return the least number of units of times that the CPU will take to finish
 * all the given tasks.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: tasks = ["A","A","A","B","B","B"], n = 2
 * Output: 8
 * Explanation:
 * A -> B -> idle -> A -> B -> idle -> A -> B
 * There is at least 2 units of time between any two same tasks.
 * Example 2:
 * 
 * Input: tasks = ["A","A","A","B","B","B"], n = 0
 * Output: 6
 * Explanation: On this case any permutation of size 6 would work since n = 0.
 * ["A","A","A","B","B","B"]
 * ["A","B","A","B","A","B"]
 * ["B","B","B","A","A","A"]
 * ...
 * And so on.
 */

public class TaskScheduler {

    //TO REVIEW!! 
    //T: O(N), O(1)
    public static int leastInterval(char[] tasks, int n) {
        // frequencies of the tasks
        int[] tasksFreq = new int[26];
        for (int task : tasks) {
            tasksFreq[task - 'A']++;
        }

        Arrays.sort(tasksFreq);

        // max frequency
        int f_max = tasksFreq[25];
        int idle_time = (f_max - 1) * n;

        for (int i = tasksFreq.length - 2; i >= 0 && idle_time > 0; --i) {
            idle_time -= Math.min(f_max - 1, tasksFreq[i]);
        }
        idle_time = Math.max(0, idle_time);

        return idle_time + tasks.length;
    }

    //T: O(N*log(N)) S: O(N)
    public static int leastInterval2(char[] tasks, int k) {
        int time = 0;
        Map<Character, Integer> taskFrequencyMap = new HashMap<>();
        for (char chr : tasks) {
            taskFrequencyMap.put(chr, taskFrequencyMap.getOrDefault(chr, 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<Map.Entry<Character, Integer>>(
                (e1, e2) -> e2.getValue() - e1.getValue());

        // add all tasks to the max heap
        maxHeap.addAll(taskFrequencyMap.entrySet());

        while (!maxHeap.isEmpty()) {
            Queue<Map.Entry<Character, Integer>> waitQueue = new LinkedList<>();
            int n = k + 1; // try to execute as many as 'k+1' tasks from the max-heap

            while (n > 0 && !maxHeap.isEmpty()) {
                Map.Entry<Character, Integer> currentEntry = maxHeap.poll();
                time++;

                if (currentEntry.getValue() > 1) {
                    currentEntry.setValue(currentEntry.getValue() - 1);
                    waitQueue.add(currentEntry);
                }
                n--;
            }

            maxHeap.addAll(waitQueue); // put all the waiting list back on the heap

            if (!maxHeap.isEmpty()) {
                time += n; // we'll be having 'n' idle intervals for the next iteration
            }
        }

        return time;
    }

    public static int leastInterval3(char[] tasks, int n) {
        Map<Character, Integer> taskFrequencyMap = new HashMap<>();
        for (char chr : tasks) {
            taskFrequencyMap.put(chr, taskFrequencyMap.getOrDefault(chr, 0) + 1);
        }

        PriorityQueue<Character> maxPQ = new PriorityQueue<Character>(
                (t1, t2) -> taskFrequencyMap.get(t2) - taskFrequencyMap.get(t1));

        taskFrequencyMap.forEach((e, v) -> maxPQ.add(e));

        Map<Integer, Character> coolDownTable = new HashMap<>();
        int time = 0;

        while (!maxPQ.isEmpty() || !coolDownTable.isEmpty()) {
            int releaseTime = time - n - 1;

            if (coolDownTable.containsKey(releaseTime)) {
                maxPQ.add(coolDownTable.remove(releaseTime));
            }

            if (!maxPQ.isEmpty()) {
                char task = maxPQ.poll();
                int taskCount = taskFrequencyMap.get(task) - 1;
                taskFrequencyMap.put(task, taskCount);
                if (taskCount > 0) {
                    coolDownTable.put(time, task);
                }
            }

            time++;
        }

        return time;
    }

    public static void main(String[] args) {
        System.out.println(leastInterval(new char[] { 'A', 'A', 'A', 'B', 'B', 'B' }, 2));
    }
}
