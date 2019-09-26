package cc.ArraysAndStrings;

import java.util.Arrays;

//567. Permutation in String
public class PermutationInString {

    public static boolean checkPermutation(char[] c1, String s2){

        char[] c2 = s2.toCharArray();
        Arrays.sort(c2);
        for( int i = 0; i < c1.length; i++){
            if(c1[i] != c2[i]){
                return false;
            }
        }
        return true;
    }

    public static boolean checkInclusion(String s1, String s2) {
        if(s1 == null || s1.length() == 0 ){
            return true;
        }
        if(s2 == null || s1.length() > s2.length()){
            return false;
        }

        char[] c1 = s1.toCharArray();
        Arrays.sort(c1);

        for( int i  = 0; i < s2.length(); i ++){
            if(i + s1.length() <= s2.length() && checkPermutation(c1, s2.substring(i, i + s1.length()))){

                return true;
            }
        }
        return  false;
    }



    public static boolean checkInclusion2(String s1, String s2) {

        if(s2 == null || s1.length() > s2.length()){
            return false;
        }
        int[] c1 = new int[26];
        int[] c2 = new int[26];
        for( int i = 0; i < s1.length(); i++){
            c1[s1.charAt(i) - 'a']++;
            c2[s2.charAt(i) - 'a']++;
        }

        int count = 0;
        for( int i = 0; i < 26; i++){
            if( c1[i] == c2[i]){
                count ++;
            }
        }

        for( int i = 0; i < s2.length() -  s1.length(); i++){
            int l = s2.charAt(i) - 'a', r = s2.charAt(i + s1.length()) - 'a';
            if( count  == 26){
                return true;
            }
            c2[r] ++;
            if(c2[r] ==  c1[r]){
                count ++;
            }else if(c2[r] - 1 == c1[r]){
                count --;
            }
            c2[l] -- ;
            if(c2[l] == c1[l]){
                count ++;
            }
            else if(c2[l] + 1 == c1[l]){
                count --;
            }

        }
        return count == 26;
    }


    public static void main(String[] args) {
        String s1 = "acd", s2 = "dcda";
        boolean rst = checkInclusion2(s1, s2);
        System.out.println(rst);
    }
}