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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode tempHead = new ListNode(0);
        tempHead.next = head;

        ListNode fast = tempHead, slow = tempHead;

        for (int i=0;i<n;i++) fast = fast.next;

        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;
        return tempHead.next;
    }
}

// 1 2 3 4
// n = 2

// f = 3, s = 1
// f = 4, s = 2

// 1 2 3 4 5 6 7 8
// n = 3

// f = 4, s = 1
// f = 5, s = 2
// f = 6, s = 3
// f = 7, s = 4
// f = 8, s = 5

// 1, 2
// n = 2

// f = null, s = 1

// 5
// n = 1

// f = null, s = 1

// 0 1 2 3 4 5 6 7 8
// n = 3

// f = 3
// s = 0

// f = 4, 1
// 5, 2
// 6, 3
// 7, 4
// 8, 5

// 0 1 2 
// n = 2

// f = 2, s = 0
// 0 -> 2

// 0 1 2
// n = 1

// f = 1, s = 0
// f = 2, s = 1

// 0 5
// n=1

// f = 5, s = 0

