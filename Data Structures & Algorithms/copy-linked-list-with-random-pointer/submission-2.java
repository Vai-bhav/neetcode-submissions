/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;

        Node curr = head;
        while(curr != null) {
            Node newNode = new Node(curr.val);
            newNode.next = curr.next;
            curr.next = newNode;
            curr = newNode.next;
        }

        curr = head;

        while(curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }

            curr = (curr.next != null) ? curr.next.next : null;
        }

        Node oldHead = head;
        Node newHead = head.next;
        Node currOld = oldHead;
        Node currNew = newHead;

        while(currOld != null) {
            currOld.next = currOld.next.next;
            currNew.next = (currNew.next != null) ? currNew.next.next : null;
            currOld = currOld.next;
            currNew = currNew.next;
        }

        return newHead;
    }
}
