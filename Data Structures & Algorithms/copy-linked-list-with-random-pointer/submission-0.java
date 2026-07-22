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

        Map<Node, Node> map = new HashMap<>();
        Node newHead = new Node(0);
        Node temp = newHead;

        while(head != null) {
            Node copyNode = map.get(head);

            if (copyNode == null) {
                copyNode = new Node(head.val);
                map.put(head, copyNode);
            }

            temp.next = copyNode;

            if (head.random != null) {
                Node randomCopy = map.get(head.random);
                if (randomCopy == null) {
                    randomCopy = new Node(head.random.val);
                    map.put(head.random, randomCopy);
                }

                copyNode.random = randomCopy;
            }

            head = head.next;
            temp = temp.next;
        }

        return newHead.next;
    }
}
