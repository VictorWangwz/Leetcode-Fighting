package vopreparation0530;

import java.util.*;

//692. Top K Frequent Words
public class TopKFrequentWord {

    public static List<String> topKFrequent(String[] words, int k) {
        List<String> rst = new ArrayList<>();
        Map<String, Integer> m =  new HashMap<>();
        for(String word: words){
            if(!m.containsKey(word)){
                m.put(word, 1);
                continue;
            }
            m.put(word, m.get(word) + 1);
        }
        PriorityQueue<String> pq = new PriorityQueue<String>((s1, s2) -> {
            if(m.getOrDefault(s1, 0 ) > m.getOrDefault(s2, 0))
                return -1;
            else if(m.getOrDefault(s1, 0 ) < m.getOrDefault(s2, 0)) return 1;
            else return s1.compareTo(s2);
        });
        for(Map.Entry<String, Integer> e: m.entrySet()){
            String s = e.getKey();
            pq.offer(s);
        }
        for(; k > 0; k--){
            rst.add(pq.poll());
        }
        return rst;
    }

    public static void main(String[] args) {
        String[] words = {"i", "love", "leetcode", "i", "love", "coding"};
        int k = 2;
        String[] expected = {"i", "love"};
        List<String> rst = topKFrequent(words, k);
        System.out.println(rst);
    }

}

