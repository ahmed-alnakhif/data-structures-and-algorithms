package Problems.Queues;

import java.util.LinkedList;
import java.util.Queue;

public class WinnerOfCircularGame {

    public int findTheWinner(int n, int k) {
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i <= n; i++) {
            queue.add(i);
        }

        while(queue.size() > 1) {
            int turns = k;

            while(turns > 1) {
               queue.add(queue.poll());
               turns--;
            }
            
            queue.poll();
        }

        return queue.peek();
    }
    
    public static void main(String[] args) {
        WinnerOfCircularGame w = new WinnerOfCircularGame();
        System.out.println(w.findTheWinner(3, 2));
    }
}
