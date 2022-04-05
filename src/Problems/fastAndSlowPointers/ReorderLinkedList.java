package Problems.fastAndSlowPointers;

import java.util.Stack;

/**
 * You are given the head of a singly linked-list. The list can be represented
 * as: L0 → L1 → … → Ln - 1 → Ln
 * 
 * Reorder the list to be on the following form:
 * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 * 
 * You may not modify the values in the list's nodes. Only nodes themselves may
 * be changed
 */

public class ReorderLinkedList {

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

    // T: O(N), S: O(N)
    public void reorderList(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode curr = head;
        while (curr != null) {
            stack.add(curr);
            curr = curr.next;
        }

        curr = head;
        while (curr != null) {
            ListNode tmp = curr.next;
            ListNode lastNode = stack.pop();
            curr.next = lastNode;
            lastNode.next = tmp;
            curr = tmp;
            if (curr != null && curr.next == lastNode) {
                curr.next = null;
                break;
            }
        }
    }

    // Better Space complexity => T: O(N), S: O(1)
    public void reorderList2(ListNode head) {
        ListNode lastOfFirstHalf = getLastOfFirstHalf(head);
        ListNode firstOfSecondHalf = getReversedLinkedList(lastOfFirstHalf);
        mergeTwoLists(head, firstOfSecondHalf);
    }

    private ListNode getLastOfFirstHalf(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode getReversedLinkedList(ListNode head) {
        ListNode curr = head, prev = null;
        while (curr != null) {
            ListNode tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
        }
        return prev;
    }

    private void mergeTwoLists(ListNode first, ListNode second) {
        while (second.next != null) {
            ListNode tmp = first.next;
            first.next = second;
            first = tmp;

            tmp = second.next;
            second.next = first;
            second = tmp;
        }
    }

    public static void main(String[] args) {
                
    }
}
