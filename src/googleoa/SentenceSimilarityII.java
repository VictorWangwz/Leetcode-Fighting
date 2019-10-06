package googleoa;

import java.util.*;
//737. Sentence Similarity II
public class SentenceSimilarityII {
    private boolean search(Map<String, List<String>> map, String key, String target){
        Stack<String> stack = new Stack<>();
        Set<String> visited = new HashSet<>();
        stack.push(key);
        while(!stack.isEmpty()){
            String tmp = stack.pop();
            visited.add(tmp);
            if(!map.containsKey(tmp)){
                return false;
            }
            List<String> l = map.get(tmp);
            for(String s: l){
                if(s.equals(target)){
                    return true;
                }
                if(!visited.contains(s)){
                    stack.push(s);
                }
            }

        }
        return false;
    }

    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, List<List<String>> pairs) {
        if(words1 == null && words2 == null){
            return true;
        }
        if((words1 == null && words2 != null) || (words2 == null && words1 != null)){
            return false;
        }
        if(words1.length != words2.length){
            return false;
        }
        Map< String, List<String>> map = new HashMap<>();
        for(int i = 0; i < pairs.size(); i++){
            List<String> pair = pairs.get(i);
            for(String s: pair){
                if(!map.containsKey(s)){
                    map.put(s, new ArrayList<>());
                }
            }
            map.get(pair.get(0)).add(pair.get(1));
            map.get(pair.get(1)).add(pair.get(0));
        }

        for(int i = 0; i < words1.length; i++){
            String word1 = words1[i];
            String word2 = words2[i];
            if(word1.equals(word2) || search(map, word1, word2)){
                continue;
            }
            return false;
        }
        return true;



    }
}
