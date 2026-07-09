/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        else if (l2 == null) return l1;

        ListNode head = new ListNode(0);
        ListNode curr1 = l1, curr2 = l2, temp = head;
        int carry = 0;

        while(curr1 != null || curr2 != null) {
            int num1 = (curr1 != null) ? curr1.val : 0;
            int num2 = (curr2 != null) ? curr2.val : 0;

            int sum = carry + num1 + num2;

            temp.next = new ListNode(sum % 10);

            carry = sum / 10;

            temp = temp.next;
            if (curr1 != null) curr1 = curr1.next;
            if (curr2 != null) curr2 = curr2.next;
        }

        if (carry > 0) {
            temp.next = new ListNode(carry);
        }

        return head.next;
    }
}

// 1 2 3
// 4 5 6

// 5 7 9


// 9
// 9

// 8 1