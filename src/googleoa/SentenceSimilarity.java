package googleoa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//734. Sentence Similarity
public class SentenceSimilarity {


    private void add(Map<String,List<String>> map, String key, String value){
        List<String> l = map.getOrDefault(key, new ArrayList<>());
        l.add(value);
        map.put(key, l);
        return;
    }

    public boolean areSentencesSimilar(String[] words1, String[] words2, List<List<String>> pairs) {
        if(words1 == null && words2 == null){
            return true;
        }
        if((words1 == null && words2 != null) || (words2 == null && words1 != null)){
            return false;
        }
        if(words1.length != words2.length){
            return false;
        }
        Map<String, List<String>> map = new HashMap<>();
        for(int i = 0; i < pairs.size(); i++){
            List<String> pair = pairs.get(i);
            String w1 = pair.get(0);
            String w2 = pair.get(1);
            add(map, w1, w2);
            add(map, w2, w1);
        }
        for(int i = 0; i < words1.length; i++){
            String word1 = words1[i];
            String word2 = words2[i];
            if(word1.equals(word2) || ((map.containsKey(word1)&& map.get(word1).contains(word2))&&(map.containsKey(word2)&& map.get(word2).contains(word1)))){
                continue;
            }
            return false;
        }
        return true;


    }
}
