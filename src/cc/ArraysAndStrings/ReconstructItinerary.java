package cc.ArraysAndStrings;

import java.util.*;

//332. Reconstruct Itinerary
public class ReconstructItinerary {
    List<String> rst = new ArrayList<>();
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        for(List<String> l: tickets){
            PriorityQueue<String> pq = map.getOrDefault(l.get(0), new PriorityQueue<>());
            pq.offer(l.get(1));
            map.put(l.get(0), pq);
        }


        String begin = "JFK";
        helper(begin, map);
        return rst;
    }

    private void helper(String name,  Map<String, PriorityQueue<String>> map){
        while(map.containsKey(name)  && map.get(name).size() != 0){
            helper(map.get(name).poll(), map);
        }
        rst.add(0, name);
    }


}
