package cc.ArraysAndStrings;

import java.util.HashMap;
import java.util.Map;

//266 Palindrome Permutation
public class PalindromePermutation {
    public static boolean canPermutePalindrome(String s) {
        if(s == null || s.length() == 0){
            return true;
        }
        Map<Character, Integer> map = new HashMap<>();
        for( char c: s.toCharArray() ){
            if(map.containsKey(c)){
                map.put(c, map.get(c) + 1);
            }
            else{
                map.put(c, 1);
            }
        }
        int oddNum = 0;
        for( Map.Entry<Character, Integer> entry: map.entrySet()){
            if(entry.getValue() % 2 == 1){
                oddNum ++;
            }
            if(oddNum > 1){
                return false;
            }
        }
        return true;

    }

    public static void main(String[] args) {
        String s = "carerac";
        boolean rst = canPermutePalindrome(s);
        System.out.println(rst);
    }
}
