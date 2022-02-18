package Problems.LinkedLists;

/**
 * You are given the head of a linked list, and an integer k.
 * 
 * Return the head of the linked list after swapping the values of the kth node
 * from the beginning and the kth node from the end (the list is 1-indexed).
 * 
 * Input: head = [1,2,3,4,5], k = 2
 * Output: [1,4,3,2,5]
 */

public class SwapNodesInLinkedList {

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

    public ListNode swapNodes(ListNode head, int k) {
        int listLength = 0;
        ListNode curr = head, front = null, end = null;

        // get front and end nodes
        while (curr != null) {
            listLength++;

            if (end != null) {
                end = end.next;
            }

            if (listLength == k) {
                front = curr;
                end = head;
            }

            curr = curr.next;
        }

        // swap front node and end node values
        int temp = front.val;
        front.val = end.val;
        end.val = temp;
        return head;
    }

    public void run() {

    }
}
