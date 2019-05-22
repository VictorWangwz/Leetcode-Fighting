package oa2preparation0519;

import java.util.*;


//length K substring with k-1 distinct characters
public class SubStringLessKDist {
//    //Use duplicate flag
//    public static List<String> subStringLessKDist2(String inputString, int num){
//        List<String> rst = new ArrayList<>();
//        for(int i = 0; i < inputString.length(); i++){
//            int[] counter = new int[26];
//            int dist = 0;
//            int dup_counter = 1;
//            for(int j = i; j < inputString.length();j++){
//
//                if(counter[inputString.charAt(j) - 'a'] > 0){
//                    dup_counter--;
//                    if(dup_counter < 0){
//                        break;
//                    }
//                }
//                counter[inputString.charAt(j) - 'a'] ++;
//                dist++;
//                if(dist == num){
//                    rst.add(inputString.substring(i, j + 1));
//                }
//            }
//        }
//        return rst;
//    }

    public static List<String> subStringLessKDist2(String inputString, int num){
        List<String> rst = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();

        for(int i = 0; i + num <= inputString.length(); i++){
            boolean isDuplicated = false;
            for(int j = 0; j < num; j++){
                if(map.containsKey(inputString.charAt(i + j))){
                    if(isDuplicated){
                        break;
                    }
                    else{
                        map.put(inputString.charAt(j), map.get(inputString.charAt(i + j)) + 1);
                    }
                    isDuplicated = true;
                }
                else{
                    map.put(inputString.charAt(i + j), 1);
                }
            }

            if(isDuplicated)
                rst.add(inputString.substring(i, i + num));
            map.clear();
        }
        return rst;
    }

    //Use HashSet
    public static List<String> subStringLessKDist(String inputString, int num){
        List<String> rst = new ArrayList<>();
        Set<String> rst_set = new HashSet<>();
        if(inputString == null || inputString.length() <= num || num <= 1) return rst;
        for(int i = 0; i < inputString.length() - num + 1; i++){
            Set<Character> set = new HashSet<>();
            char[] temp = inputString.substring(i, i + num).toCharArray();
            for(char c: temp) set.add(c);
            if(set.size() == num - 1){
                rst_set.add(inputString.substring(i, i + num ));
            }
        }
        Iterator itr = rst_set.iterator();
        while(itr.hasNext()){
            rst.add((String)itr.next());
        }
        return rst;
    }

    public static void main(String[] args) {
        String inputString = "bbb";
        int num = 2;
        List<String> rst = subStringLessKDist2(inputString, num);
        System.out.println(rst);
    }
}
