package cc.ArraysAndStrings;

import java.util.ArrayList;
import java.util.List;

//438. Find All Anagrams in a String
public class FindAllAnagramsinaString {

    private boolean allZero(int[] mem){
        for(int i = 0; i < 26; i ++){
            if(mem[i] != 0){
                return false;
            }
        }
        return true;
    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> rst = new ArrayList<>();
        int[] mem = new int[26];
        for(char c: p.toCharArray()){
            mem[c - 'a']++;
        }

        for(int i = 0; i < s.length(); i++){
            mem[s.charAt(i) - 'a']--;
            if(i >= p.length()){
                mem[s.charAt(i - p.length()) - 'a']++;
            }

            if(allZero(mem)){
                rst.add(i - p.length() + 1);
            }
        }
        return rst;
    }
}
