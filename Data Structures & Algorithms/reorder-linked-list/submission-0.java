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
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        Stack<ListNode> st = new Stack<>();
        ListNode curr = head;

        while(curr != null) {
            st.push(curr);
            curr = curr.next;
        }

        curr = head;
        int size = st.size();

        for (int i=0;i<size/2;i++) {
            ListNode nextNode = curr.next;
            ListNode lastNode = st.pop();

            curr.next = lastNode;
            lastNode.next = nextNode;
            curr = nextNode;
        }

        curr.next = null;
    }
}


// 2 -> 4 -> 6 -> 8 -> 9

// 2 -> 9 -> 4 -> 8 -> 6

// 5/2 = 2+1 = 3

// 9
// 8
// 6
// 4
// 2

// 2 -> 9 -> 4 -> 8 -> 6

// 2 4 6 8

// 4/2 = 2

// 8
// 6
// 4
// 2

// 2 8 6 4
