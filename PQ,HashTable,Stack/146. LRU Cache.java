class LRUCache {

    class ListNode {
        int key, val;
        ListNode next;
        ListNode(int key, int val) {
            this.key = key;
            this.val = val;
            this.next = null;
        }
    }
    int size, capacity;
    ListNode dummy, tail;
    Map<Integer, ListNode> keyToPrev;
    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        dummy = new ListNode(0, 0);
        tail = dummy;
        keyToPrev = new HashMap<>();
    }
    
    public ListNode moveToTail(int key) {
        ListNode prev = keyToPrev.get(key);
        ListNode curt = prev.next;
        if (curt == tail) {
            return tail;
        }
        
        prev.next = prev.next.next;
        tail.next = curt;
        keyToPrev.put(prev.next.key, prev);
        keyToPrev.put(key, tail);
        tail = curt;
        return tail;
    }
    
    public int get(int key) {
        if (!keyToPrev.containsKey(key)) {
            return -1;
        }
        ListNode cur = moveToTail(key);
        return cur.val;
    }
    
    public void put(int key, int value) {
        if (get(key) != -1) {
            tail.val = value;
            return;
        }
        if (size < capacity) {
            ListNode node = new ListNode(key, value);
            keyToPrev.put(key, tail);
            tail.next = node;
            size++;
            tail = node;
            return;
        }
        ListNode first = dummy.next;
        keyToPrev.remove(first.key);
        first.key = key;
        first.val = value;
        keyToPrev.put(key, dummy);
        
        moveToTail(key);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
