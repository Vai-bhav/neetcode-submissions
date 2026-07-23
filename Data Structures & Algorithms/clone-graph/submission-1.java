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
        Map<Integer, Node> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();

        while(!queue.isEmpty()) {
            Node curr = queue.poll();
            if (set.contains(curr.val)) continue;

            if (map.get(curr.val) == null) {
                map.put(curr.val, new Node(curr.val));
            }

            for (Node neigh:curr.neighbors) {
                if (map.get(neigh.val) == null) {
                    map.put(neigh.val, new Node(neigh.val));
                }
                map.get(curr.val).neighbors.add(map.get(neigh.val));
                queue.add(neigh);
            }
            set.add(curr.val);
        }

        return map.get(node.val);
    }
}