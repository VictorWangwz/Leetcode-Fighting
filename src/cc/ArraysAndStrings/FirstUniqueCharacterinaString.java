package cc.ArraysAndStrings;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

//387. First Unique Character in a String
public class FirstUniqueCharacterinaString {
    public int firstUniqChar(String s) {
        List<Character> q = new LinkedList<>();
        Set<Character> set = new HashSet<>();
        for(int i = 0; i < s.length(); i++){
            if(set.contains(s.charAt(i))){
                if(q.contains(s.charAt(i))){
                    q.remove(new Character(s.charAt(i)));
                }
            }
            else{
                q.add(s.charAt(i));
                set.add(s.charAt(i));
            }
        }
        if(q.isEmpty()){
            return -1;
        }
        else{
            return s.indexOf(q.get(0));
        }
    }
}
