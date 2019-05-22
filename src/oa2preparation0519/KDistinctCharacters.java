package oa2preparation0519;

import java.util.ArrayList;
import java.util.List;

public class KDistinctCharacters {
    // Count in string
    //Count number of substrings with exactly k distinct characters
    public static int countkDist(String str, int k){
        int rst = 0;
        char[] char_list = str.toLowerCase().toCharArray();
        for(int i = 0; i < str.length(); i++){
            int[] counter = new int[26];
            int dist = 0;
            for(int j = i; j < str.length(); j++){
                if(counter[char_list[j] - 'a'] == 0) {
                    dist++;
                }
                counter[char_list[j] - 'a'] ++;
                if(dist == k) {
                    rst ++;
                }else if(dist > k) {
                    break;
                }
            }
        }
        return rst;
    }

    // Count in Array
    //Given an array of letters and a window size k, return subarrays
    // of size k with no duplicates.
    public static List<List<Character>> countDist2(char[] chars, int k){
        List<List<Character>> rst = new ArrayList<>();
        if(chars == null || chars.length == 0) return rst;
        for(int i = 0; i < chars.length; i++){
            int[] counter = new int[26];
            int dist = 0;
            List<Character> temp = new ArrayList<>();
            for(int j = i; j < chars.length; j++){
                if(counter[chars[j] - 'a'] != 0) break;
                counter[chars[j] - 'a'] += 1;
                dist += 1;
                temp.add(chars[j]);
                if(dist == k){
                    rst.add(temp);
                    break;
                }
            }
        }
        return rst;
    }

    public static void main(String[] args) {
//        String s = "abc";
//        int k = 2;
//        int rst = countkDist(s, k);
//        System.out.println(rst);
        char[] chars = {'a', 'd', 'f', 'g', 'k' ,'g'};
        int k =4;
        List<List<Character>> rst = countDist2(chars, k);
        System.out.println(rst);
    }
}
