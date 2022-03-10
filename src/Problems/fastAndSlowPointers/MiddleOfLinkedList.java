package Problems.fastAndSlowPointers;

/**
 * Given the head of a singly linked list, return the middle node of the linked
 * list.
 * 
 * If there are two middle nodes, return the second middle node.
 */

public class MiddleOfLinkedList {

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

    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public void run() {

    }
}
