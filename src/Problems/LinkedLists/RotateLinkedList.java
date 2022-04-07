package Problems.LinkedLists;

/**
 * Given the head of a linked list, rotate the list to the right by k places.
 * 
 * Input: head = [1,2,3,4,5], k = 2
 * Output: [4,5,1,2,3]
 */

 
public class RotateLinkedList {

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

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;

        // 1) get tail and length
        ListNode oldTail = head;
        int length;
        for (length = 1; oldTail.next != null; length++) {
            oldTail = oldTail.next;
        }

        // 2) calculate next new tail
        k = k % length;
        if (k == 0) {
            return head;
        }

        // 3) link tail to head
        oldTail.next = head;

        // 4) get new tail
        ListNode newTail = head;
        for (int i = 1; i < length - k; i++) {
            newTail = newTail.next;
        }

        // 5) set new head and set new tail next to null
        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }

    public static void main(String[] args) {
        
    }
}
