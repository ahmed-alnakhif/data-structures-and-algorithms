package Problems.fastAndSlowPointers;

import java.util.HashSet;

/**
 * Given the head of a linked list, return the node where the cycle begins. If
 * there is no cycle, return null.
 * 
 * There is a cycle in a linked list if there is some node in the list that can
 * be reached again by continuously following the next pointer. Internally, pos
 * is used to denote the index of the node that tail's next pointer is connected
 * to (0-indexed). It is -1 if there is no cycle. Note that pos is not passed as
 * a parameter.
 */

public class LinkedListCycleII {

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

    public ListNode detectCycle(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();
        ListNode curr = head;

        while (curr != null) {
            if (set.contains(curr)) {
                return curr;
            }
            set.add(curr);
            curr = curr.next;
        }

        return null;
    }

    //Floyd's Algorithm
    public ListNode detectCycle2(ListNode head) {
        if (head == null) return null;

        ListNode intersect = findIntersection(head);
        
        if (intersect == null) return null;

        ListNode ptr1 = intersect;
        ListNode ptr2 = head;
        while (ptr1 != ptr2) {
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }

        return ptr1;
    } 

    private ListNode findIntersection(ListNode head) {
        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                return fast;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        
    }
}
