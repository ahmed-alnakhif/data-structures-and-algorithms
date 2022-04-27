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
        ListNode curr = head, prev = head;
        int length = 1;
        
        while(curr.next != null){
            length++;
            curr = curr.next;
            
            if(length > n + 1){ //to stop prev at distance of n 
                prev = prev.next;
            }
        }
        
        //remove head;
        if(length == n){
            return head.next;
        }
        
        //else
        prev.next = prev.next.next;
        
        return head;
    }
    
    public ListNode removeNthFromEnd2(ListNode head, int n) {
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
            return head.next;
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
