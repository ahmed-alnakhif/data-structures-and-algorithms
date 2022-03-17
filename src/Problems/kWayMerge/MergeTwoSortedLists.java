package Problems.kWayMerge;

import java.util.PriorityQueue;

public class MergeTwoSortedLists {

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

    // recursive solution
    // T: O(n + m), S: O(1)
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;

        if (list1.val <= list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        }

        else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }

    // max heap solution
    // T: O(N*log(2)), S: O(2)
    public ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
        ListNode head = null, curr = null;
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((e1, e2) -> e1.val - e2.val);

        if (list1 != null) {
            minHeap.add(list1);
        }

        if (list2 != null) {
            minHeap.add(list2);
        }

        while (!minHeap.isEmpty()) {
            ListNode node = minHeap.poll();

            if (head == null) {
                head = curr = node;
            } else {
                curr.next = node;
                curr = curr.next;
            }

            if (node.next != null) {
                minHeap.add(node.next);
            }
        }

        return head;
    }

    public static void main(String[] args) {

    }
}
