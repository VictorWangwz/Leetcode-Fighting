package quoraoa;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

//451. Sort Characters By Frequency
public class SortCharactersByFrequency {

    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });

        for(Character character: s.toCharArray()){
            if(!map.containsKey(character)){
                map.put(character, 1);
            }
            else{
                map.put(character, map.get(character) + 1);
            }
        }

        for(Map.Entry<Character, Integer> e: map.entrySet()){
            pq.offer(e);
        }
        StringBuffer sb = new StringBuffer();
        while(!pq.isEmpty()){
            Map.Entry<Character, Integer> e = pq.poll();
            for(int i = 0; i < e.getValue();i++){
                sb.append(e.getKey());
            }
        }
        return sb.toString();

    }

    public static void main(String[] args) {
        String s = "tree";
        SortCharactersByFrequency sortCharactersByFrequency = new SortCharactersByFrequency();
        String rst = sortCharactersByFrequency.frequencySort(s);
        System.out.println(rst);
    }
}
