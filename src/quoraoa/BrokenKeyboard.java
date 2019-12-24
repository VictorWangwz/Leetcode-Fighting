package quoraoa;

import java.util.HashSet;
import java.util.Set;

public class BrokenKeyboard {

    public int numOfWords(String s, char[] keys){
        if(keys == null || keys.length == 0 || s == null || s.length() == 0){
            return 0;
        }
        Set<Character> set = new HashSet<>();
        for(char c: keys){
            set.add(c);
        }
        String[] words = s.split(" ");
        int rst = 0;
        search: for(String word: words){
            for(char c: word.toCharArray()){
                if(Character.isLetter(c) && !set.contains(c)){
                    continue search;
                }
            }
            rst++;
        }
        return rst;
    }

    public static void main(String[] args) {
//        String s = "5 + 3 = 8";
        String s = "hello, world";
        char[] keys = {'i','e','o','l','h'};
        BrokenKeyboard brokenKeyboard = new BrokenKeyboard();
        int rst = brokenKeyboard.numOfWords(s, keys);
        System.out.println(rst);
    }
}
