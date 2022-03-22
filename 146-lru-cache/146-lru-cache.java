class LRUCache {

    class Node {
        
        int key;
        int val;
        Node next;
        Node prev;
        
        Node(int key, int value) {
            this.key = key;
            this.val = value;
        }
        
    }
    
    Node head = null;
    Node tail =  null;
    Map<Integer, Node> map;
    int capacity = 0;
    
    public LRUCache(int capacity) {
        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);
        this.map = new HashMap<>();
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        Node node = map.get(key);
        if(node == null) {
            return -1;
        }
        delete(node);
        insert(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)) {
            delete(map.get(key));
        }
        if(capacity == map.size()) {
            delete(tail.prev);
        }
        insert(new Node(key, value));
    }
    
    public void insert(Node node) {
        map.put(node.key, node);
        node.next = head.next;
        head.next.prev = node;
        node.prev = head;
        head.next = node;
    }
    
    public void delete(Node node) {
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */