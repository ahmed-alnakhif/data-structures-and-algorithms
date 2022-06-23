package Problems.priorityQueue;

import java.util.List;
import java.util.PriorityQueue;

// Typically in a cross-border payment, we first provide the customer with an estimation or quote of the FX rate, which the customer follows up optionally with a payment execution request, should the quote be acceptable.  Because we utilize a FX exchange to execute the payment, the quote must be based on the orders present in the exchange.

// In this exercise, we will be writing a quote function for purchasing XRP with USD.

// A limit order has two components –  a limit price in USD and a quantity to sell in XRP.   Given list of these sell orders, create a function that calculates the amount of XRP you can purchase with a given amount of USD.

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

// double calculateXrpQuote(LimitOrders[] orders, double usdAmount);

// sellOrders = [
//     LimitOrder(0.25, 10.00),  // limit (USD), quantity (XRP)
//     LimitOrder(0.50, 20.00),
//       LimitOrder(0.75, 5.00),
// ];
// calculateXrpQuote(sellOrders, 1.25);  // 5.0
// calculateXrpQuote(sellOrders, 2.5);    // 10.0
// calculateXrpQuote(sellOrders, 5.0);    // 15.0

class LimitOrder {
    double limitPrice;
    double quantity;

    public LimitOrder(double limitPrice, double quantity) {
        this.limitPrice = limitPrice;
        this.quantity = quantity;
    }

    public double getMaxAmount() {
        return this.limitPrice * this.quantity;
    }
}

class XrpQuote {

    PriorityQueue<LimitOrder> priceMinHeap;

    public XrpQuote() {
        priceMinHeap = new PriorityQueue<LimitOrder>((a, b) -> Double.compare(a.limitPrice, b.limitPrice));
    }

    // sellOrders = [
    // LimitOrder(0.25, 10.00), // limit (USD), quantity (XRP)
    // LimitOrder(0.50, 20.00),
    // LimitOrder(0.75, 5.00),
    // ];
    // calculateXrpQuote(sellOrders, 1.25); // 5.0
    // calculateXrpQuote(sellOrders, 2.5); // 10.0
    // calculateXrpQuote(sellOrders, 5.0); // 15.0

    public double calculateXrpQuote(List<LimitOrder> sellOrders, double amount) {
        double xrpAmount = 0.0;

        for (LimitOrder order : sellOrders) {
            priceMinHeap.add(order);
        }

        for (LimitOrder order : priceMinHeap) {
            if (amount > order.limitPrice) {
                if (order.getMaxAmount() >= amount) {
                    xrpAmount += amount / order.limitPrice;
                    return xrpAmount;
                } else {
                    xrpAmount += order.quantity;
                    amount = amount - order.getMaxAmount();
                }
            } else {
                return xrpAmount;
            }
        }

        return xrpAmount;
    }

    public static void main(String[] args) {
        XrpQuote xrpQuote = new XrpQuote();

        // limit (USD), quantity (XRP)
        List<LimitOrder> sellOrders = List.of(
                new LimitOrder(0.25, 10.00),
                new LimitOrder(0.50, 20.00),
                new LimitOrder(0.75, 5.00));

        System.out.println(xrpQuote.calculateXrpQuote(sellOrders, 1.25)); // 5.0
        System.out.println(xrpQuote.calculateXrpQuote(sellOrders, 2.5)); // 10.0
        System.out.println(xrpQuote.calculateXrpQuote(sellOrders, 5.0)); // 15.0
    }

}