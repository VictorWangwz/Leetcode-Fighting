package oa2preparation0519;

import java.util.*;

public class MostCommonWord {

    // regex
    public static String mostCommonWord(String paragraph, String[] banned) {
        String[] words = paragraph.toLowerCase().split("([.,!?:;'\"-]|\\s)+");
        Set<String> banned_set = new HashSet<String>(Arrays.asList(banned));
        Map<String, Integer> m = new HashMap();
        String rst = null;
        int num = 0;
        for(String word: words){
            if(banned_set.contains(word)){
                m.put(word, 0);
                continue;
            }
            m.put(word, m.getOrDefault(word, 0) + 1);
            if(m.get(word) > num){
                num = m.get(word);
                rst = word;
            }
        }
        return rst;

    }

    // HashMap
    public static String mostCommonWord2(String paragraph, String[] banned) {
        Set<String> banned_set = new HashSet<String>(Arrays.asList(banned));
        Map<String, Integer> m = new HashMap();
        StringBuilder word = new StringBuilder();
        int count = 0;
        String rst = null;
        paragraph += " ";
        for(Character c: paragraph.toCharArray()){
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
                    rst = word.toString();
                }
                word = new StringBuilder();
            }
        }
        return rst;
    }

    public static void main(String[] args) {
        String paragraph = "Bob. hIt, baLl";
        String[] banned = {  "bob", "hit" };
        String rst = mostCommonWord2(paragraph, banned);
        System.out.println(rst);
    }
}
