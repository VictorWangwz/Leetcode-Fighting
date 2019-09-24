package oa2preparation0519;
//oa2preparation0519.KDistinctCharacters
import java.util.*;

public class KDistinctCharacters {
    // Count in string
    //Count number of substrings with exactly k distinct characters (unique substr count)
    public static int countkDist(String str, int k){
        Set<String> set = new HashSet<>();
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
                    set.add(str.substring(i, j + 1));
                }else if(dist > k) {
                    break;
                }
            }
        }
        return set.size();
    }

    // Count in string
    //Count number of substrings with exactly k distinct characters (non-unique substr count)
    public static int countkDist1(String str, int k){
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

    // Count in string
    //Count number of k-substrings with exactly k distinct characters (unique substr count count)
    public static int countkDist2(String str, int k){
        Set<String> rst = new HashSet<>();
        char[] char_list = str.toCharArray();
        for(int i = 0; i + k <= char_list.length; i++){
            String sub_str = str.substring(i, i + k);
            char[] sub_char_list = sub_str.toCharArray();
            Set<Character> set = new HashSet<>();
            for(char c: sub_char_list){
                set.add(Character.valueOf(c));
            }
            if(set.size() == k){
                rst.add(sub_str);
            }
        }
        return rst.size();
    }

    //sol 2
    public static int countkDist20(String stringIn, int K) {
        // Write your code here
        if(stringIn.length()<K)
            return 0;
        int j;
        char t;
        Set<String> resultset = new TreeSet<>();
        Set<Character> set = new TreeSet<>();
        for(int i=0;i<stringIn.length();i++){
            j=0;
            for(;i+j<stringIn.length();j++){
                t=stringIn.charAt(i+j);
                if(set.contains(t)){
                    set.clear();
                    for(int k=j-1;k>=0;k--){
                        if(stringIn.charAt(i+k)==t){
                            i=i+k;
                            break;
                        }
                    }
                    break;
                }
                else
                    set.add(t);
                if(set.size()>=K){
                    resultset.add(stringIn.substring(i+j-K+1,i+j+1));
                }
            }
        }
        return resultset.size();
    }

    // Count in string
    //Count number of k-substrings with exactly k distinct characters (non-unique substr count count)
    public static int countkDist21(String str, int k){
        int rst = 0;
        char[] char_list = str.toCharArray();
        for(int i = 0; i + k <= char_list.length; i++){
            String sub_str = str.substring(i, i + k);
            char[] sub_char_list = sub_str.toCharArray();
            Set<Character> set = new HashSet<>();
            for(char c: sub_char_list){
                set.add(Character.valueOf(c));
            }
            if(set.size() == k){
                rst++;
            }
        }
        return rst;
    }

    // Count in string
    //Count number of k-substrings with exactly k-1 distinct characters (unique substr count)
    public static List<String> countkDist3(String str, int k){
//        int rst = 0;
        Set<String> rst_set = new HashSet<>();
        List<String> rst = new ArrayList<>();
        char[] char_list = str.toCharArray();
        for(int i = 0; i + k <= char_list.length; i++){
            String sub_str = str.substring(i, i + k);
            char[] sub_char_list = sub_str.toCharArray();
            Set<Character> set = new HashSet<>();
            for(char c: sub_char_list){
                set.add(Character.valueOf(c));
            }
            if(set.size() == k - 1){
                rst_set.add(sub_str);
            }
        }
        Iterator<String> itr = rst_set.iterator();
        while(itr.hasNext()){
           rst.add(itr.next());
       }
        return rst;
    }

    // Count in string
    //Count number of k-substrings with exactly k-1 distinct characters (non-unique)
    public static List<String> countkDist31(String str, int k){
//        int rst = 0;
        List<String> rst = new ArrayList<>();
        char[] char_list = str.toCharArray();
        for(int i = 0; i + k <= char_list.length; i++){
            String sub_str = str.substring(i, i + k);
            char[] sub_char_list = sub_str.toCharArray();
            Set<Character> set = new HashSet<>();
            for(char c: sub_char_list){
                set.add(Character.valueOf(c));
            }
            if(set.size() == k - 1){
                rst.add(sub_str);
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
        String s = "abcabc";
        int k = 3;
        int rst = countkDist20(s, k);
//        List<String> rst = countkDist1(s, k);
        System.out.println(rst);
//        char[] chars = {'a', 'd', 'f', 'g', 'k' ,'g'};
//        int k = 4;
//        List<List<Character>> rst = countkDist(chars, k);
//        System.out.println(rst);
    }
}
