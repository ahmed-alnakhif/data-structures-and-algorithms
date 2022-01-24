package Problems.LinkedLists;

public class RemoveNodeFromEnd {

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

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode curr = head;
        int length = 0;

        while (curr != null) {
            curr = curr.next;
            length++;
        }

        curr = head;
        int toRemoveIndex = length - n;

        // remove head
        if (toRemoveIndex == 0) {
            head = head.next;
            return head;
        }

        // else, stop before the node to delete
        for (int i = 0; i < toRemoveIndex - 1; i++) {
            curr = curr.next;
        }

        curr.next = curr.next.next;
        
        return head;
    }

    public void run() {

    }
}
