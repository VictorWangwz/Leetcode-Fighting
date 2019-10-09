package googleoa;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

//792. Number of Matching Subsequences
public class NumberofMatchingSubsequences {

    private boolean check(Map<Character, LinkedList<Integer>> map, String word){

        char[] charArray = word.toCharArray();
        char firstChar = charArray[0];
        if(!map.containsKey(firstChar)|| map.get(firstChar) == null || map.get(firstChar).size() == 0){
            return false;
        }
        int preIdx = map.get(firstChar).get(0);
        search:for(int i = 1; i < charArray.length; i++){
            char c = charArray[i];
            if(!map.containsKey(c) || map.get(c) == null || map.get(c).size() == 0){
                return false;
            }
            else{
                for(int integer: map.get(c))
                {
                    if(integer > preIdx){
                        preIdx = integer;
                        continue search;
                    }

                }
                return false;
            }

        }
        return true;
    }

    public int numMatchingSubseq(String S, String[] words) {
        Map<Character, LinkedList<Integer>> map = new HashMap<>();
        for(int i = 0; i < S.length(); i++){
            LinkedList<Integer> list = map.getOrDefault(S.charAt(i), new LinkedList<>());
            list.add(i);
            map.put(S.charAt(i), list);
        }

        int rst = 0;
        for(String word: words){

            if(check(map, word)){
                rst++;
            }
        }
        return rst;

    }

    public static void main(String[] args) {
        String S = "dsahjpjauf";
        String[] words = {"ahjpjau","ja","ahbwzgqnuk","tnmlanowax"};
        NumberofMatchingSubsequences numberofMatchingSubsequences = new NumberofMatchingSubsequences();
        int rst = numberofMatchingSubsequences.numMatchingSubseq(S, words);
        System.out.println(rst);
    }


}
