package Problems.LinkedLists;

import java.util.HashSet;

/**
 * Given the heads of two singly linked-lists headA and headB, return the node
 * at which the two lists intersect. If the two linked lists have no
 * intersection at all, return null.
 */

public class IntersectionOfTwoLists {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    // T: O(N+M), S: O(1)
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode ptrA = headA, ptrB = headB;

        while (ptrA != ptrB) {
            ptrA = ptrA == null ? headB : ptrA.next;
            ptrB = ptrB == null ? headA : ptrB.next;
        }

        return ptrA;
    }

    // T: O(N+M), S: O(N)
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode current1 = headA;
        ListNode current2 = headB;
        HashSet<ListNode> set = new HashSet<>();

        while (current1 != null) {
            set.add(current1);
            current1 = current1.next;
        }

        while (current2 != null) {
            if (set.contains(current2)) {
                return current2;
            }
            current2 = current2.next;
        }
        
        return null;
    }

    public static void main(String[] args) {

    }
}
