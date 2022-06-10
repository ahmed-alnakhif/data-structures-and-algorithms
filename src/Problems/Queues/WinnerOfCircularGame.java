package Problems.Queues;

import java.util.LinkedList;
import java.util.Queue;

public class WinnerOfCircularGame {

    //T: O(N*K), S: O(k)
    public int findTheWinner(int n, int k) {
        Queue<Integer> participantsQueue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            participantsQueue.add(i);
        }

        while (participantsQueue.size() > 1) {
            int turns = k;

            while (turns > 1) {
                participantsQueue.add(participantsQueue.poll());
                turns--;
            }

            participantsQueue.poll();
        }

        return participantsQueue.peek();
    }

    //T: O(N), S: O(1)
    public int findTheWinner2(int n, int k) {
        int result = 0;
        for(int i=1; i<=n; i++) {
            result = (result + k) % i;
        }
        return result + 1;
    }

    public static void main(String[] args) {
        WinnerOfCircularGame w = new WinnerOfCircularGame();
        System.out.println(w.findTheWinner(3, 2));
    }
}
