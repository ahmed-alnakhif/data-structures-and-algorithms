package Problems.LinkedLists;

/**
 * Given the head of a linked list, reverse the nodes of the list k at a time,
 * and return the modified list.
 * 
 * k is a positive integer and is less than or equal to the length of the linked
 * list. If the number of nodes is not a multiple of k then left-out nodes, in
 * the end, should remain as it is.
 * 
 * You may not alter the values in the list's nodes, only nodes themselves may
 * be changed.
 * 
 * Input: head = [1,2,3,4,5], k = 2
 * Output: [2,1,4,3,5]
 */

public class ReverseNodesInKGroup {

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

    public ListNode reverseKGroup(ListNode head, int k) {
        int length = 0;
        ListNode curr = head;
        while (curr != null) {
            length++;
            curr = curr.next;
        }

        for (int left = 1, right = k; right <= length; left += k, right += k) {
            head = reverseBetween(head, left, right);
        }

        return head;
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode start = head, end = head;
        ListNode startPrev = null, endNext = null;

        // get start and end nodes
        int i = 1;
        while (i < right) {
            if (i < left) {
                startPrev = start;
                start = start.next;
            }

            if (i < right) {
                end = end.next;
            }

            i++;
        }

        // save end next node
        endNext = end.next;
        end.next = null;

        // reverse the sub linkedlist
        ListNode reversedHead = reverse(start, end);

        // if sub is the start of the linkedlist
        if (startPrev == null) {
            head = reversedHead;
        }
        // connect start previous with the new reverse head
        else {
            startPrev.next = reversedHead;
        }

        // connect the end of the sub linkedlist to the saved end.next
        start.next = endNext;

        // return beginning of the linked list
        return head;
    }

    private ListNode reverse(ListNode start, ListNode end) {
        ListNode curr = start, prev = null;
        while (curr != null) {
            ListNode nextTmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTmp;
        }
        return prev;
    }

    public void run() {

    }
}
