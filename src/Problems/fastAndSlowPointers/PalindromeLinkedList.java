package Problems.fastAndSlowPointers;

/**
 * Given the head of a singly linked list, return the middle node of the linked
 * list.
 * 
 * If there are two middle nodes, return the second middle node.
 */

public class PalindromeLinkedList {

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
    public boolean isPalindrome(ListNode head) {
        ListNode ptr = head;
        StringBuilder str = new StringBuilder();

        while (ptr != null) {
            str.append(ptr.val);
            ptr = ptr.next;
        }

        int left = 0, right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left++) != str.charAt(right--)) {
                return false;
            }
        }

        return true;
    }

     //Better space complexity => T: O(N), S: O(1)
    public boolean isPalindrome2(ListNode head) {
        // 1) find end of first half
        ListNode firstHalfEnd = getFirstHalfEnd(head);

        // 2) reverse second half
        ListNode secondHalfStart = getReversedLinkedList(firstHalfEnd.next);

        // 3) check is a palindrome (compare from head and start of second half)
        ListNode ptr1 = head, ptr2 = secondHalfStart;
        while (ptr2 != null) {
            if (ptr1.val != ptr2.val) {
                return false;
            }
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }

        // 4) restore to original
        firstHalfEnd.next = getReversedLinkedList(secondHalfStart);

        return true;
    }

    private ListNode getFirstHalfEnd(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    private ListNode getReversedLinkedList(ListNode head) {
        ListNode curr = head, prev = null;
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
