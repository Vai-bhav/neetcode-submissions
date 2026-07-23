/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        Map<Node, Node> map = new HashMap<>();

        while(!queue.isEmpty()) {
            Node curr = queue.poll();

            if (map.get(curr) == null) {
                map.put(curr, new Node(curr.val));
            }

            for (Node neigh:curr.neighbors) {
                if (map.get(neigh) == null) {
                    map.put(neigh, new Node(neigh.val));
                    queue.add(neigh);
                }
                map.get(curr).neighbors.add(map.get(neigh));
            }
        }

        return map.get(node);
    }
}