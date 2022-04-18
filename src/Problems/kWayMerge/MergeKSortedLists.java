package Problems.kWayMerge;

import java.util.PriorityQueue;

/**
 * You are given an array of k linked-lists lists, each linked-list is sorted in
 * ascending order.
 * 
 * Merge all the linked-lists into one sorted linked-list and return it.
 */

public class MergeKSortedLists {

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

    ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        if (l1.val <= l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    // merge lists one by one
    // T: O(N*k), S:O(1)
    public ListNode mergeKLists1(ListNode[] lists) {
        if (lists.length == 0) return null;

        ListNode sortedList = lists[0];

        for (int i = 1; i < lists.length; i++) {
            sortedList = mergeTwoLists(sortedList, lists[i]);
        }

        return sortedList;
    }

    // Divide & Conquer approach
    // T: O(N*log(k)), S: O(1)
    public ListNode mergeKLists2(ListNode[] lists) {
        if (lists.length == 0) return null;

        int interval = 1;
        while (interval < lists.length) {
            for (int i = 0; i + interval < lists.length; i = i + interval * 2) {
                lists[i] = mergeTwoLists(lists[i], lists[i + interval]);
            }
            interval = interval * 2;
        }

        return lists[0];
    }

    // max heap approach
    // T: O(N*log(k)), S: O(k)
    public ListNode mergeKLists3(ListNode[] lists) {
        ListNode head = null, curr = null;
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((e1, e2) -> e1.val - e2.val);

        for (ListNode root : lists) {
            if (root != null) {
                minHeap.add(root);
            }
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
