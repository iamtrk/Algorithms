class LRUCache {

    static class Node {
        Node prev;
        Node next;
        int key;
        int val;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    private Map<Integer, Node> map;
    private Node head;
    private Node tail;
    private int CACHE_SIZE;

    public LRUCache(int capacity) {
        this.map = new HashMap<>();
        this.CACHE_SIZE = capacity;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            remove(node);
            addFist(node);
            return node.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) { // update
            Node node = map.get(key);
            node.val = value;
            remove(node);
            addFist(node);
        } else { // add new
            if (map.size() == CACHE_SIZE) {
                map.remove(tail.key);
                remove(tail);
            }
            Node node = new Node(key, value);
            map.put(key, node);
            addFist(node);
        }
    }

    private void addFist(Node node) {
        node.prev = null;
        node.next = head;
        if (head != null) {
            head.prev = node;
        }
        head = node;
        if (tail == null) {
            tail = head;
        }
    }

    private void remove(Node node) {
        if (node.prev != null) {
            node.prev.next = node.next;
        } else {
            head = node.next;
        }
        
        if (node.next != null) {
            node.next.prev = node.prev;
        } else {
            tail = node.prev;
        }
    }
}
