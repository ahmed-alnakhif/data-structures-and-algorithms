package Problems.twoHeaps;

import java.util.PriorityQueue;

/**
 * Suppose LeetCode will start its IPO soon. In order to sell a good price of
 * its shares to Venture Capital, LeetCode would like to work on some projects
 * to increase its capital before the IPO. Since it has limited resources, it
 * can only finish at most k distinct projects before the IPO. Help LeetCode
 * design the best way to maximize its total capital after finishing at most k
 * distinct projects.
 * 
 * You are given n projects where the ith project has a pure profit profits[i]
 * and a minimum capital of capital[i] is needed to start it.
 * 
 * Initially, you have w capital. When you finish a project, you will obtain its
 * pure profit and the profit will be added to your total capital.
 * 
 * Pick a list of at most k distinct projects from given projects to maximize
 * your final capital, and return the final maximized capital.
 * 
 * The answer is guaranteed to fit in a 32-bit signed integer.
 * 
 * 
 * Example:
 * Input: k = 3, w = 0, profits = [1,2,3], capital = [0,1,2]
 * Output: 6
 */

class Project {
    int cap;
    int pro;

    public Project(int cap, int pro) {
        this.cap = cap;
        this.pro = pro;
    }
}

public class IPO {

    public static int findMaximizedCapital(int k, int w, int[] profit, int[] capital) {
        PriorityQueue<Project> maxHeapPro = new PriorityQueue<>((a, b) -> b.pro - a.pro);
        PriorityQueue<Project> minHeapCap = new PriorityQueue<>((a, b) -> a.cap - b.cap);

        int availCapital = w;

        for (int i = 0; i < profit.length; i++) {
            minHeapCap.add(new Project(capital[i], profit[i]));
        }

        for (int i = 0; i < k; i++) {
            while (!minHeapCap.isEmpty() && minHeapCap.peek().cap <= availCapital) {
                maxHeapPro.add(minHeapCap.poll());
            }

            if (maxHeapPro.isEmpty()) {
                break;
            }

            availCapital += maxHeapPro.poll().pro;
        }

        return availCapital;
    }

    public static void main(String[] args) {
        int k = 3;
        int w = 0;
        int[] profit = { 1, 2, 3 };
        int[] capital = { 0, 1, 2 };
        System.out.println(findMaximizedCapital(k, w, profit, capital));
    }
}
