// leetcode 380

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
        int idx = map.get(val);
        moveToLast(idx);
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

    private void moveToLast(int idx){
        int len = list.size();
        int val = list.get(idx);
        list.set(idx, list.get(len - 1));
        list.set(len - 1, val);
        map.put(val, len-1);
    }


    public static void main(String[] args) {
        RandomizedSet randomizedSet = new RandomizedSet();
        System.out.println(randomizedSet.insert(1));
        System.out.println(randomizedSet.remove(2));
        System.out.println(randomizedSet.insert(2));
        System.out.println(randomizedSet.getRandom());
        System.out.println(randomizedSet.remove(1));
        System.out.println(randomizedSet.insert(2));
        System.out.println(randomizedSet.getRandom());
    }
}
