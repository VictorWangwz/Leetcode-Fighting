package cc.ArraysAndStrings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//1048. Longest String Chain
public class LongestStringChain {

    private boolean check(String s1, String s2){
        int val = 1;
        if(s1.length() > s2.length()){
            return check(s2, s1);
        }
        if(s2.length() - s1.length() != 1){
            return false;
        }
        int i = 0, j = 0;
        for(;i < s1.length(); ){
            if(s1.charAt(i) != s2.charAt(j)){
                val --;
                j++;
                if(val < 0){
                    return false;
                }
            }
            else{
                i++;
                j++;
            }

        }
        return true;
    }

    public int longestStrChain(String[] words) {
        if (words == null || words.length == 0) {
            return 0;
        }
        List<String> list = new ArrayList<>();
        for(String s: words){
            list.add(s);
        }
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });

        int[] dp = new int[words.length];
        for(int i = 0; i < words.length; i++){
            for(int j = 0; j < i; j++){
                if(check(list.get(i), list.get(j))){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int rst = 0;

        for(int i = 0; i < words.length; i++){
            if(dp[i] > rst){
                rst = dp[i];
            }
        }
        return  rst + 1;
    }


    public static void main(String[] args) {
        String[] words = {"qyssedya","pabouk","mjwdrbqwp","vylodpmwp","nfyqeowa","pu","paboukc","qssedya","lopmw","nfyqowa","vlodpmw","mwdrqwp","opmw","qsda","neo","qyssedhyac","pmw","lodpmw","mjwdrqwp","eo","nfqwa","pabuk","nfyqwa","qssdya","qsdya","qyssedhya","pabu","nqwa","pabqoukc","pbu","mw","vlodpmwp","x","xr"};
        LongestStringChain longestStringChain = new LongestStringChain();
        int rst = longestStringChain.longestStrChain(words);
        System.out.println(rst);
    }

}
