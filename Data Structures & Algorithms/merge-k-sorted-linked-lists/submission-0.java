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
            while(list != null) {
                pq.offer(list);
                list = list.next;
            }
        }

        ListNode head = new ListNode(0);
        ListNode temp = head;
        while(pq.size() > 0) {
            temp.next = pq.poll();
            temp = temp.next;
        }

        return head.next;
    }
}
