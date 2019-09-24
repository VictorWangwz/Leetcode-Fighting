package oa2preparation0519;

import java.util.*;

public class MostFrequentUsedWords {
    public static List<String> findMostFrequentUsedWords(String literatureText, List<String> wordsToExclude){
        List<String> rst = new ArrayList<>();
        for(int i = 0; i < wordsToExclude.size(); i++){
            wordsToExclude.set(i, wordsToExclude.get(i).toLowerCase());
        }
        String[] ps = literatureText.toLowerCase().split("[^a-z]+");
        Map<String, Integer> m = new HashMap<>();
        for(String s: ps){
            if(wordsToExclude.contains(s)){
                m.put(s, 0);
            }
            else{
                m.put(s, m.getOrDefault(s, 0) + 1);
            }
        }
        int max = 0;
        for(Map.Entry<String, Integer> e: m.entrySet()){
            String key = e.getKey();
            int val = e.getValue();
            if(val > max){
                max = val;
                rst.clear();
                rst.add(key);
            }
            else if(val == max){
                rst.add(key);
            }
        }
        if(max == 0){
            rst.clear();
        }
        return rst;
    }

    public static List<String> findMostFrequentUsedWords2(String literatureText, List<String> wordsToExclude) {
        for(int i = 0; i < wordsToExclude.size(); i++){
            wordsToExclude.set(i, wordsToExclude.get(i).toLowerCase());
        }
        Set<String> banned_set = new HashSet<String>(wordsToExclude);
        Map<String, Integer> m = new HashMap();
        StringBuilder word = new StringBuilder();
        int count = 0;
        List<String> rst = new ArrayList<>();
        literatureText += " ";
        for(Character c: literatureText.toCharArray()){
            if(Character.isLetter(c)){
                word.append(Character.toLowerCase(c));
            }
            else if(word.length() > 0){
                String found = word.toString();
                if(banned_set.contains(found)){
                    m.put(found, 0);
                }
                else{
                    m.put(found, m.getOrDefault(found, 0) + 1);
                }
                if(m.get(found) > count ){
                    count = m.get(found);
                    rst.clear();
                    rst.add(word.toString());
                }
                else if(m.get(found) == count && count != 0){
                    rst.add(word.toString());
                }
                word = new StringBuilder();
            }
        }
        return rst;
    }
    // sensitive
    public static List<String> findMostFrequentUsedWords3(String literatureText, List<String> wordsToExclude) {
        Map<String, Integer> m = new HashMap();
        StringBuilder word = new StringBuilder();
        int count = 0;
        List<String> rst = new ArrayList<>();
        literatureText += " ";
        for(Character c: literatureText.toCharArray()){
            if(Character.isLetter(c)){
                word.append(c);
            }
            else if(word.length() > 0){
                String found = word.toString();
                if(wordsToExclude.contains(found)){
                    m.put(found, 0);
                }
                else{
                    m.put(found, m.getOrDefault(found, 0) + 1);
                }
                if(m.get(found) > count ){
                    count = m.get(found);
                    rst.clear();
                    rst.add(word.toString());
                }
                else if(m.get(found) == count){
                    rst.add(word.toString());
                }
                word = new StringBuilder();
            }
        }
        return rst;
    }

    public static void main(String[] args) {
        String literatureText = "Jack and Jill went to the market to buy some bread and cheese.Cheese is Jack's and Jill's favorite food";
        String[] ban_list = {"and", "he", "the", "to","is", "Jack", "Jill","s"};
        List<String> wordsToExclude = new ArrayList<>();
        for(String s: ban_list){
            wordsToExclude.add(s);
        }
        List<String> rst = findMostFrequentUsedWords3(literatureText, wordsToExclude);
        System.out.println(rst);
    }
}
