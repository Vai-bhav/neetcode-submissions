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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode ptr = dummy;

        while(ptr != null) {
            ListNode node = ptr;
            for (int i=0;i<k;i++) {
                if (node == null) break;

                node = node.next;
            }

            if (node == null) break;

            ListNode prev = null, curr = ptr.next, next = null;
            for (int i=0;i<k;i++) {
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }

            ListNode temp = ptr.next;
            temp.next = next;
            ptr.next = prev;
            ptr = temp;
        }

        return dummy.next;
    }
}
