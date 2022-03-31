package Problems.LinkedLists;

/**
 * You are given two non-empty linked lists representing two non-negative
 * integers. The digits are stored in reverse order, and each of their nodes
 * contains a single digit. Add the two numbers and return the sum as a linked
 * list.
 * 
 * You may assume the two numbers do not contain any leading zero, except the
 * number 0 itself.
 * 
 * 
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * Explanation: 342 + 465 = 807.
 * Example 2:
 * 
 * Input: l1 = [0], l2 = [0]
 * Output: [0]
 * Example 3:
 * 
 * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * Output: [8,9,9,9,0,0,0,1]
 */

public class AddTwoNumbers {

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

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null & l2 == null) return null;
        if(l1 == null) return l2;
        
        int sum = l1.val;
        if(l2 != null) sum+= l2.val;
        
        if(sum > 9){
            int carry = sum / 10;
            sum = sum % 10;

            if(l1.next != null){
                l1.next.val += carry;
            } else {
                ListNode newNode = new ListNode(carry);
                l1.next = newNode;
            }
        }

        l1.val = sum;
        l1.next = addTwoNumbers(l1.next, l2!=null ? l2.next : null);
        
        return l1;
    }

    public static void main(String[] args) {
        
    }
}
