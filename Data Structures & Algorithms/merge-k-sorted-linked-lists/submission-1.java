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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> (a.val - b.val));
        for (ListNode list: lists) {
            if (list != null) pq.offer(list);
        }

        ListNode head = new ListNode(0);
        ListNode temp = head;

        while(pq.size() > 0) {
            ListNode node = pq.poll();
            temp.next = node;
            if (node.next != null) pq.offer(node.next);

            temp = temp.next;
        }

        return head.next;
    }
}
