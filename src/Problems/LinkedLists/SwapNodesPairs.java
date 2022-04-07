package Problems.LinkedLists;

/**
 * Given a linked list, swap every two adjacent nodes and return its head. You
 * must solve the problem without modifying the values in the list's nodes
 * (i.e., only nodes themselves may be changed.)
 * 
 * Input: head = [1,2,3,4]
 * Output: [2,1,4,3]
 */

public class SwapNodesPairs {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prevNode = dummy;

        while (head != null && head.next != null) {
            ListNode firstNode = head;
            ListNode secondNode = head.next;

            // swapping
            firstNode.next = secondNode.next;
            secondNode.next = firstNode;
            prevNode.next = secondNode;

            // move ahead
            prevNode = firstNode;
            head = firstNode.next;
        }

        // return new head;
        return dummy.next;
    }

    public static void main(String[] args) {

    }
}
