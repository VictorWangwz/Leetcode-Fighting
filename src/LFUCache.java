//460. LFU Cache

public class LFUCache {

//    DLinkedNode head, tail;
//    int capacity;
//    int size;
//    Map<Integer, DLinkedNode> cache;
//
//    class DLinkedNode{
//       int key;
//       int val;
//       int freq;
//       DLinkedNode pre;
//       DLinkedNode next;
//       public DLinkedNode(){
//           freq = 0;
//       }
//    }
//
//    public LFUCache(int capacity){
//        this.capacity = capacity;
//        size = 0;
//        cache = new HashMap<>();
//        head = new DLinkedNode();
//        tail = new DLinkedNode();
//    }
//
//    private void addNode(DLinkedNode node){
//        node.pre = this.head;
//        node.next = this.head.next;
//
//        node.next.pre = node;
//        head.next = node;
//
//    }
//
//    private void removeNode(DLinkedNode node){
//        DLinkedNode pre = node.pre;
//        DLinkedNode next = node.next;
//        pre.next = next;
//        next.pre = pre;
//    }
//
//    private void moveToHead(DLinkedNode node){
//        removeNode(node);
//        addNode(node);
//    }
//
//    private DLinkedNode popTail(){
//        DLinkedNode last = tail.pre;
//        removeNode(last);
//        return last;
//    }
//
//    public int get(int key) {
//        DLinkedNode node = cache.get(key);
//        if(node == null){
//            return -1;
//        }
//        moveToHead(node);
//        node.freq ++;
//        return node.val;
//    }
//
//    public void put(int key, int value) {
//        DLinkedNode node = cache.get(key);
//
//        if(node == null) {
//            DLinkedNode newNode = new DLinkedNode();
//            newNode.key = key;
//            newNode.val = value;
//
//            cache.put(key, newNode);
//            addNode(newNode);
//
//            ++size;
//
//            if(size > capacity) {
//                // pop the tail
//                DLinkedNode tail = popTail();
//                cache.remove(tail.key);
//                --size;
//            }
//        } else {
//            // update the value.
//            node.val = value;
//            moveToHead(node);
//        }
//

}
