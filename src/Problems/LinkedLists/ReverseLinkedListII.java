package Problems.LinkedLists;

/**
 * Given the head of a singly linked list and two integers left and right where
 * left <= right, reverse the nodes of the list from position left to position
 * right, and return the reversed list.
 * 
 * Input: head = [1,2,3,4,5], left = 2, right = 4
 * Output: [1,4,3,2,5]
 */

public class ReverseLinkedListII {

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

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode start = head, end = head;
        ListNode startPrev = null, endNext = null;

        //get start and end nodes
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
        
        //save end next node
        endNext = end.next;
        end.next = null;

        //reverse the sub linked list
        ListNode reversedHead = reverse(start, end);

        //if sub is the start of the linked list
        if (startPrev == null) {
            head = reversedHead;
        } 
        // connect start previous with the new reverse head
        else { 
            startPrev.next = reversedHead;
        }

        //connect the end of the sub linked list to the saved end.next
        start.next = endNext;

        //return beginning of the linked list 
        return head;
    }

    // normal reverse linked list method 
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

    public static void main(String[] args) {
        

    }
}
