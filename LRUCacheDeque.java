class LRUCache {

    public HashMap<Integer,Integer> map;
    public Deque<Integer> deque;
    public int capacity = 0;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        deque = new ArrayDeque<>();
    }
    
    public int get(int key) {
        if(map.containsKey(key)) {
             deque.remove(key);
             deque.addFirst(key);
             return map.get(key);
        }
        return -1;
    }
    
    public void put(int key, int value) {
       
            if(map.containsKey(key)) {
                deque.remove(key);
                deque.addFirst(key);
                map.put(key,value);
                return;
            }
            if(deque.size()==capacity) {
                int k = deque.removeLast();
                map.remove(k);
            }
       
            deque.addFirst(key);
            map.put(key,value);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
