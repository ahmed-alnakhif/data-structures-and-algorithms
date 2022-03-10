package Problems.fastAndSlowPointers;

import java.util.HashSet;

public class LinkedListCycle {

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

    public boolean hasCycle1(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();
        ListNode curr = head;

        while (curr != null) {
            if (set.contains(curr.next)) {
                return true;
            }
            set.add(curr);
            curr = curr.next;
        }

        return false;
    }

    public boolean hasCycle2(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                return true;
            }
        }

        return false;
    }

    public void run() {

    }
}
