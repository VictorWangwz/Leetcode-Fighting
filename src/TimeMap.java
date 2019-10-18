//981. Time Based Key-Value Store

import java.util.*;

public class TimeMap {
    Map<String, PriorityQueue<List<String>>> map;

    /** Initialize your data structure here. */
    public TimeMap() {
        map = new HashMap<>();

    }

    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)){
            map.put(key, new PriorityQueue<List<String>>(new Comparator<List<String>>() {
                @Override
                public int compare(List<String> o1, List<String> o2) {
                    return Integer.valueOf(o1.get(1)) - Integer.valueOf(o2.get(1));
                }
            }));
        }
        List<String> list = new ArrayList<>();
        list.add(value);
        list.add(String.valueOf(timestamp));
        map.get(key).add(list);
        return;
    }

    public String get(String key, int timestamp) {
        if(!map.containsKey(key)){
            return "";
        }
        PriorityQueue<List<String>> pq = map.get(key);
        for(List<String> list: pq){
            if(Integer.valueOf(list.get(1)) <= timestamp){
                return list.get(0);
            }
        }
        return "";
    }


}
