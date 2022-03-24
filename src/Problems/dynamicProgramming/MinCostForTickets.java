package Problems.dynamicProgramming;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * You have planned some train traveling one year in advance. The days of the
 * year in which you will travel are given as an integer array days. Each day is
 * an integer from 1 to 365.
 * 
 * Train tickets are sold in three different ways:
 * 
 * a 1-day pass is sold for costs[0] dollars,
 * a 7-day pass is sold for costs[1] dollars, and
 * a 30-day pass is sold for costs[2] dollars.
 * The passes allow that many days of consecutive travel.
 * 
 * For example, if we get a 7-day pass on day 2, then we can travel for 7 days:
 * 2, 3, 4, 5, 6, 7, and 8.
 * Return the minimum number of dollars you need to travel every day in the
 * given list of days.
 * 
 * 
 * Example 1:
 * 
 * Input: days = [1,4,6,7,8,20], costs = [2,7,15]
 * Output: 11
 * Explanation: For example, here is one way to buy passes that lets you travel
 * your travel plan:
 * On day 1, you bought a 1-day pass for costs[0] = $2, which covered day 1.
 * On day 3, you bought a 7-day pass for costs[1] = $7, which covered days 3, 4,
 * ..., 9.
 * On day 20, you bought a 1-day pass for costs[0] = $2, which covered day 20.
 * In total, you spent $11 and covered all the days of your travel.
 */

public class MinCostForTickets {

    class Ticket {
        int expireDate;
        int cost;

        Ticket(int expireDate, int cost) {
            this.expireDate = expireDate;
            this.cost = cost;
        }
    }

    // Queue
    //T: O(N), S:O()
    public int minCostTickets(int[] days, int[] costs) {
        Queue<Ticket> last1 = new LinkedList<>();
        Queue<Ticket> last7 = new LinkedList<>();
        Queue<Ticket> last30 = new LinkedList<>();

        int minCost = 0;

        for (int day : days) {
            while (!last1.isEmpty() && last1.peek().expireDate + 1 <= day) {
                last1.poll();
            }

            while (!last7.isEmpty() && last7.peek().expireDate + 7 <= day) {
                last7.poll();
            }

            while (!last30.isEmpty() && last30.peek().expireDate + 30 <= day) {
                last30.poll();
            }

            last1.add(new Ticket(day, minCost + costs[0]));
            last7.add(new Ticket(day, minCost + costs[1]));
            last30.add(new Ticket(day, minCost + costs[2]));

            minCost = Math.min(last1.peek().cost, Math.min(last7.peek().cost, last30.peek().cost));
        }

        return minCost;
    }

    // Memoization
    HashMap<Integer, Integer> cache;

    public int minCostTickets2(int[] days, int[] costs) {
        cache = new HashMap<>();
        return minCost(days, costs, 0);
    }

    private int minCost(int[] days, int[] costs, int dayIndex) {
        if (dayIndex >= days.length) {
            return 0;
        }

        if (cache.containsKey(dayIndex)) {
            return cache.get(dayIndex);
        }

        int totalCostTicket1 = costs[0] + minCost(days, costs, getNextDayToBuy(days, dayIndex, 1));
        int totalCostTicket2 = costs[1] + minCost(days, costs, getNextDayToBuy(days, dayIndex, 7));
        int totalCostTicket3 = costs[2] + minCost(days, costs, getNextDayToBuy(days, dayIndex, 30));

        cache.put(dayIndex, Math.min(totalCostTicket1, Math.min(totalCostTicket2, totalCostTicket3)));
        return cache.get(dayIndex);
    }

    private int getNextDayToBuy(int[] days, int dayIndex, int duration) {
        int expireDay = days[dayIndex] + duration - 1;
        int nextDayToBuy = dayIndex;
        while (nextDayToBuy < days.length && days[nextDayToBuy] <= expireDay) {
            nextDayToBuy++;
        }
        return nextDayToBuy;
    }

    public static void main(String[] args) {
        MinCostForTickets mTickets = new MinCostForTickets();
        int[] days = { 1, 4, 6, 7, 8, 20 };
        int[] costs = { 2, 7, 15 };
        System.out.println(mTickets.minCostTickets(days, costs));
    }
}
