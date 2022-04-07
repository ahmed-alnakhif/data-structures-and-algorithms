package Problems.LinkedLists;


class ListNode {
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

public class MergeLinkedLists {
    
    public ListNode mergeTwoLists(ListNode head1, ListNode head2) {
        ListNode l1  = head1, l2 = head2;

        while(l2 != null){
            ListNode temp = l1.next;
            l1.next = l2;
            l1 = temp;

            temp = l2.next;
            l2.next = l1;
            l2 = temp;
        }

        return head1;
    }

    public static void main(String[] args) {
        MergeLinkedLists mll = new MergeLinkedLists();
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(4);
        l2.next = new ListNode(5);
        l2.next.next = new ListNode(6);

        ListNode merged = mll.mergeTwoLists(l1, l2);
        while (merged != null) {
            System.out.print(merged.val + " -> ");
            merged = merged.next;
        }
        System.out.println();
    }
}
