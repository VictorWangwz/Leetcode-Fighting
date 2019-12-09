package cc.ArraysAndStrings;

import java.util.*;

//1181. Before and After Puzzle
public class BeforeandAfterPuzzle {

    public List<String> beforeAndAfterPuzzles(String[] phrases) {
        List<String> rst = new ArrayList<>();
        Map<String, List<Integer>> map = new HashMap<>();

        for(int i = 0; i < phrases.length; i++){
            String[] phrase = phrases[i].split(" ");
            String last = phrase[phrase.length - 1];
            if(!map.containsKey(last)){
                map.put(last, new ArrayList<>());
            }
            map.get(last).add(i);
        }

        for(int i = 0; i < phrases.length; i++){
            String[] phrase = phrases[i].split(" ");
            String first = phrase[0];
            if(map.containsKey(first)){
                for(Integer j: map.get(first)){
                    if(i != j){
                        phrase[0] = "";
                        String combined = phrases[j] + String.join(" ", phrase);
                        if(!rst.contains(combined)){
                            rst.add(combined);
                        }
                    }

                }
            }

        }
        Collections.sort(rst);
        return rst;
    }

    private String check(String phrase1, String phrase2){
        StringBuffer sb = new StringBuffer(phrase2);
        String[] phrases1 = phrase1.split(" ");
        String first = phrases1[0];
        String[] phrases2 = phrase2.split(" ");
        if(first.equals(phrases2[phrases2.length - 1])){
            for(int i = 1; i < phrases1.length; i++){
                sb.append(" ");
                sb.append(phrases1[i]);
            }
            return sb.toString();
        }
        else{
            return null;
        }

    }

    public List<String> beforeAndAfterPuzzles0(String[] phrases) {
        List<String> rst = new ArrayList<>();
        for(int i = 0; i < phrases.length; i++){
            for(int j = i+1; j < phrases.length; j++){
                String check1 = check(phrases[i], phrases[j]);
                if(check1 != null){
                    if(!rst.contains(check1))
                        rst.add(check1);
                }
                String check2 = check(phrases[j], phrases[i]);
                if(check2 != null){
                    if(!rst.contains(check2))
                        rst.add(check2);
                }
            }
        }
        Collections.sort(rst);
        return rst;
    }
}
