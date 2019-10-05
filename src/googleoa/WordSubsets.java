package googleoa;

import java.util.ArrayList;
import java.util.List;

//916. Word Subsets
public class WordSubsets {

    //Time limit exceeded
//    private static void add(Map<String, Map<Character, Integer>> map, String a){
//        if(!map.containsKey(a)) map.put(a, new HashMap<>());
//        Map<Character, Integer> tmp = new HashMap<>();
//        for(char c: a.toCharArray()){
//            if(!tmp.containsKey(c)) tmp.put(c, 1);
//            else{
//                tmp.put(c, tmp.get(c)+1);
//            }
//        }
//        map.put(a, tmp);
//        return ;
//    }
//    public static List<String> wordSubsets(String[] A, String[] B) {
//        Map<String, Map<Character, Integer>> map = new HashMap<>();
//        for(String a: A){
//            add(map, a);
//        }
//        for(String b: B){
//            add(map, b);
//        }
//
//        List<String> rst = new ArrayList<>();
//
//        for(String a: A){
//            boolean flag = true;
//            for(String b: B){
//                flag = flag && check(map.get(a), map.get(b));
//
//            }
//            if(flag){
//                rst.add(a);
//            }
//        }
//        return rst;
//    }
//
//    private static boolean check(Map<Character, Integer> a, Map<Character, Integer> b ){
//        for(Map.Entry<Character, Integer> e: b.entrySet()){
//            char key = e.getKey();
//            if(a.containsKey(key) && (a.get(key) >= b.get(key))){
//                continue;
//            }
//            return false;
//        }
//        return true;
//    }


    //use int[26] to count
    public static List<String> wordSubsets(String[] A, String[] B) {
        int[] count = count("");
        List<String > rst = new ArrayList<>();

        for(String b: B){
            int[] countB = count(b);
            for( int i  = 0; i < 26; i++){
                if(countB[i] > count[i]){
                    count[i]  = countB[i];
                }
            }
        }


        search: for(String a: A){
            int[] countA = count(a);
            for(int i = 0; i < 26; i++){
                if(countA[i] < count[i]) {
                    continue search;
                }
            }
            rst.add(a);

        }
        return rst;


    }

    private static int[] count(String s){
        int[] count = new int[26];
        for(char c: s.toCharArray()){
            count[c - 'a'] ++;
        }
        return count;
    }

    public static void main(String[] args) {
        String[] A = {
                "amazon","apple","facebook","google","leetcode"
        };
        String[] B = {
                "ec","oc","ceo"
        };
        List<String> rst = wordSubsets(A, B);
        System.out.println(rst);

    }
}
