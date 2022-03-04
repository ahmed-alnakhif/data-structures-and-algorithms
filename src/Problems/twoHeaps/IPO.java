package Problems.twoHeaps;

import java.util.PriorityQueue;

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

        int availCaptial = w;

        for (int i = 0; i < profit.length; i++) {
            minHeapCap.add(new Project(capital[i], profit[i]));
        }

        for (int i = 0; i < k; i++) {
            while (!minHeapCap.isEmpty() && minHeapCap.peek().cap <= availCaptial) {
                maxHeapPro.add(minHeapCap.poll());
            }

            if (maxHeapPro.isEmpty()) {
                break;
            }

            availCaptial += maxHeapPro.poll().pro;
        }

        return availCaptial;
    }

    public static void main(String[] args) {
        int k = 3;
        int w = 0;
        int[] profit = { 1, 2, 3 };
        int[] capital = { 0, 1, 2 };
        System.out.println(findMaximizedCapital(k, w, profit, capital));
    }
}
