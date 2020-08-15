package quorapi;

import java.util.*;

public class RandomizedSet {

    private Map<Integer, Integer> map;

    private List<Integer> list;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(map.containsKey(val) && map.get(val) != -1){
            return false;
        }
        list.add(val);
        map.put(val, list.size() - 1);

        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!map.containsKey(val) ||  map.get(val) == -1){
            return false;
        }

        swap(list, map.get(val), list.size() - 1, map);
        map.put(val, -1);
        list.remove(list.size() - 1);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        Random rand = new Random();
        int idx =  rand.nextInt(list.size());
        return list.get(idx);

    }

    private void swap(List<Integer> list, int i, int j, Map<Integer, Integer> map) {
        int tmp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, tmp);
        map.put(list.get(i), i);
    }


    public static void main(String[] args) {

        // Init an empty set.
        RandomizedSet randomSet = new RandomizedSet();

        // Inserts 1 to the set. Returns true as 1 was inserted successfully.
        randomSet.insert(1);

        // Returns false as 2 does not exist in the set.
        randomSet.remove(2);

        // Inserts 2 to the set, returns true. Set now contains [1,2].
        randomSet.insert(2);

        // getRandom should return either 1 or 2 randomly.
        randomSet.getRandom();

        // Removes 1 from the set, returns true. Set now contains [2].
        randomSet.remove(1);

        // 2 was already in the set, so return false.
        randomSet.insert(2);

        // Since 2 is the only number in the set, getRandom always return 2.
        randomSet.getRandom();
    }
}
