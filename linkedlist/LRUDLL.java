class LRUDLL {
    int capacity;
    dll doublyll;
    Map<Integer, Node> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        doublyll = new dll();
        map = new HashMap<>();
        
    }
    
    public int get(int key) {
        
        if(map.keySet().contains(key)) {
            Node n = map.get(key);
            doublyll.moveToEnd(n);
            return n.data;
        }

        return -1;
        
    }
    
    public void put(int key, int value) {
        
        if(map.keySet().contains(key)) {
            Node n = map.get(key);
            doublyll.removeNode(n);
            map.remove(key);
        }
        
         if(map.size()>=capacity) {
            Node tmp = doublyll.head;
            doublyll.removeNode(doublyll.head);
            map.remove(tmp.key);
        }
         
        Node node = new Node(value, key);
        map.put(key, node);
        doublyll.add(node);
        
    }
    
    public static void main(String[] args) {

        LRU cache = new LRU(3);
        cache.put(1, 1);    // evicts key 2
        cache.printelems();
        cache.put(2, 2);    // evicts key 2
        cache.printelems();
        cache.put(3, 3);    // evicts key 2
        cache.printelems();
        cache.put(4, 4);    // evicts key 2
        cache.printelems();
        System.out.println(cache.get(4));       // returns -1 (not found)
        cache.printelems();
        System.out.println(cache.get(3));       // returns -1 (not found)
        cache.printelems();
        System.out.println(cache.get(2));       // returns -1 (not found)
        cache.printelems();
        System.out.println(cache.get(1));       // returns -1 (not found)
        cache.printelems();
        cache.put(5, 5);    // evicts key 2
        cache.printelems();
        System.out.println(cache.get(1));       // returns -1 (not found)
        cache.printelems();
        System.out.println(cache.get(2));       // returns -1 (not found)
        cache.printelems();
        System.out.println(cache.get(3));       // returns -1 (not found)
        cache.printelems();
        System.out.println(cache.get(4));       // returns -1 (not found)
        cache.printelems();
        System.out.println(cache.get(5));       // returns -1 (not found)
        cache.printelems();
    }
}

class Node {
    int data;
    Node next, prev;
    int key;
    public Node(int data, int key) {
        this.data = data;
        this.key  = key;
    }
}

class dll {
    Node head;
    Node tail;

    public void add(Node node) {
        if(head == null && tail==null) {
            head = tail = node;
        } else if(head==tail){
            tail = node;
            head.next=tail;
            tail.prev=head;

        }
        else {

            tail.next = node;
            node.prev = tail;
            tail = node;
        }
    }

    public void moveToEnd(Node node) {
        if(node.equals(tail)) return;
        else if(node.equals(head)) {
            head = head.next;
            head.prev = null;
        } else {
            if (node.prev != null) node.prev.next = node.next;
            if (node.next != null) node.next.prev = node.prev;
        }
        addNodeToEnd(node);
    }

    public void addNodeToEnd(Node node) {

        tail.next=node;
        node.prev = tail;
        node.next = null;
        tail = node;
    }
    
    public void removeNode(Node n) {

        if(head==tail) {
            head = null;
            tail = null;
        } else
        if(n==head) {
            head = head.next;
            head.prev = null;
            n.next=null;
        } else if(n==tail) {
            tail = tail.prev;
            tail.next = null;
            n.prev = null;
        } else {
            n.prev.next = n.next;
            n.next.prev = n.prev;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
