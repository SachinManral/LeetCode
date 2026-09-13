// class LRUCache {
//     ArrayList<int[]> cache;
//     int n;
//     public LRUCache(int capacity) {
//         n = capacity;
//         cache = new ArrayList<>();
//     }
    
//     public int get(int key) {
//         for(int i=0; i<cache.size(); i++){
//             if(cache.get(i)[0]==key){
//                 int val = cache.get(i)[1];

//                 int[] temp=cache.get(i);
//                 cache.remove(i);
//                 cache.add(temp);

//                 return val;
//             }
//         }
//         return -1;
//     }
    
//     public void put(int key, int value) {
//         for(int i=0; i<cache.size(); i++){
//             if(cache.get(i)[0]==key){
//                 cache.remove(i);
//                 cache.add(new int[]{key, value});

//                 return;
//             }
//         }

//         if(cache.size()==n){
//             cache.remove(0);
//         }

//         cache.add(new int[]{key, value});
//     }
// }






 class LRUCache {
    public class Node{
        int key;
        int val;
        Node prev;
        Node next;

        Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }

    int cap;
    Map<Integer, Node> map;
    Node head, tail;

    public LRUCache(int capacity) {
        this.cap = capacity;
        this.map = new HashMap<>();

        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        Node node = map.get(key);
        if(node==null){
            return -1;
        }
        moveToHead(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        Node node = map.get(key);
        if(node!=null){
            node.val=value;
            moveToHead(node);
        }else{
            if(map.size()==cap){
                Node lru = tail.prev;
                removeNode(lru);
                map.remove(lru.key);
            }
            Node newNode = new Node(key, value);
            map.put(key, newNode);
            addToHead(newNode);
        }
    }

    public void addToHead(Node node){
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    public void removeNode(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void moveToHead(Node node){
        removeNode(node);
        addToHead(node);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */