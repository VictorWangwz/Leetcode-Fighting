import java.util.HashMap;
import java.util.Map;

//146
public class LRUCache2 {

    private class DLinkedNode{
        int key;
        int val;
        DLinkedNode pre;
        DLinkedNode next;
    }

    private Map<Integer, DLinkedNode> cache;
    private DLinkedNode head, tail;
    private int capacity;
    private int size;

    public LRUCache2(int capacity){
        this.cache = new HashMap<>();
        this.head = new DLinkedNode();
        this.tail = new DLinkedNode();
        this.head.next = this.tail;
        this.tail.pre = this.head;
        this.capacity = capacity;
        this.size = 0;
    }

    private void addNode(DLinkedNode node){
        node.pre = this.head;
        node.next = this.head.next;

        node.next.pre = node;
        head.next = node;

    }

    private void removeNode(DLinkedNode node){
        DLinkedNode pre = node.pre;
        DLinkedNode next = node.next;
        pre.next = next;
        next.pre = pre;
    }

    private void moveToHead(DLinkedNode node){
        removeNode(node);
        addNode(node);
    }

    private DLinkedNode popTail(){
        DLinkedNode last = tail.pre;
        removeNode(last);
        return last;
    }

    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if(node == null){
            return -1;
        }
        moveToHead(node);
        return node.val;
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);

        if(node == null) {
            DLinkedNode newNode = new DLinkedNode();
            newNode.key = key;
            newNode.val = value;

            cache.put(key, newNode);
            addNode(newNode);

            ++size;

            if(size > capacity) {
                // pop the tail
                DLinkedNode tail = popTail();
                cache.remove(tail.key);
                --size;
            }
        } else {
            // update the value.
            node.val = value;
            moveToHead(node);
        }

    }

    public static void main(String[] args) {

        LRUCache2 cache = new LRUCache2( 2 /* capacity */ );
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));       // returns 1
        cache.put(3, 3);    // evicts key 2
        System.out.println( cache.get(2));       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        System.out.println(cache.get(1));       // returns -1 (not found)
        System.out.println(cache.get(3));       // returns 3
        System.out.println(cache.get(4));       // returns 4     // returns 3System.out.println(cache.get(4));       // returns 4
    }


}
