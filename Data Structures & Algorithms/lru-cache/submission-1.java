class Node {
    int key;
    int val;
    Node prev;
    Node next;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

class LRUCache {
    int capacity;
    Map<Integer, Node> map;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) return -1;

        Node curr = map.get(key);
        remove(curr);
        insertAtLast(curr);

        return curr.val;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node curr = map.get(key);
            curr.val = value;
            remove(curr);
            insertAtLast(curr);

            return;
        }

        if (this.capacity == map.size()) {
            Node curr = head.next;
            remove(curr);

            map.remove(curr.key);
        }

        Node curr = new Node(key, value);
        insertAtLast(curr);
        map.put(key, curr);
    }

    private void remove(Node curr) {
        Node prev = curr.prev;
        prev.next = curr.next;
        prev.next.prev = prev;
    }

    private void insertAtLast(Node curr) {
        Node tailPrev = tail.prev;
        tailPrev.next = curr;
        curr.prev = tailPrev;
        curr.next = tail;
        tail.prev = curr;
    }
}
