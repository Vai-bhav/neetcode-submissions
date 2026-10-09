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
        int n = lists.length;
        if (n==0) return null;
        
        int size = 1;
        while (size < n) {
            for (int i=0;i<n-size;i+= size*2) {
                lists[i] = mergeList(lists[i], lists[i+size]);
            }

            size *= 2;
        }

        return lists[0];
    }

    private ListNode mergeList(ListNode l1, ListNode l2) {
        if (l2 == null) return l1;
        else if (l1 == null) return l2;

        ListNode list = new ListNode(0);
        ListNode temp = list;

        while(l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                temp.next = l2;
                l2 = l2.next;
            } else {
                temp.next = l1;
                l1 = l1.next;
            }
            temp = temp.next;
        }

        if (l1 != null) temp.next = l1;
        if (l2 != null) temp.next = l2;

        return list.next;
    }
}
