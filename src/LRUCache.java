import java.util.*;

//146
class LRUCache {

    private int capacity;
    private Map<Integer, Integer> storage;
    private LinkedList<Integer> seq;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        storage = new HashMap<>();
        seq = new LinkedList<Integer>();
    }

    public int get(int key) {
        if(!storage.containsKey(key)){
            return -1;
        }
        else{
            int idx = seq.indexOf(key);
            seq.remove(idx);
            seq.addLast(key);
            return storage.get(key);
        }
    }

    public void put(int key, int value) {
        if(this.get(key) != -1){
            storage.put(key, value);
            return;
        }
        if(storage.size() == capacity){
            int removedKey = seq.getFirst();
            seq.removeFirst();
            storage.remove(removedKey);
        }
        storage.put(key, value);
        seq.addLast(key);
    }

    public static void main(String[] args) {

        LRUCache cache = new LRUCache( 2 /* capacity */ );
        System.out.println(cache.get(2));
        cache.put(2, 6);
        System.out.println(cache.get(1));
        cache.put(1, 5);
            // returns 1
        cache.put(1, 2);    // evicts key 2
              // returns -1 (not found)

        System.out.println(cache.get(1));       // returns -1 (not found)
        System.out.println(cache.get(2));       // returns 3System.out.println(cache.get(4));       // returns 4
    }
}