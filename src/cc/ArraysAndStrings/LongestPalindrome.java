package cc.ArraysAndStrings;
//409. Longest Palindrome
public class LongestPalindrome {
    public int longestPalindrome(String s) {
        int[] freq = new int[52];
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) >= 'a'){
                freq[s.charAt(i) - 'a'] ++;
            }
            else{
                freq[26 + s.charAt(i) - 'A'] ++;
            }

        }
        boolean hasEven = false;
        int rst = 0;
        for(int i = 0; i < 52; i++){
            rst += freq[i] /2 * 2;
            if(freq[i] %2 == 1){
                hasEven = true;
            }
        }
        return hasEven? rst + 1: rst;
    }
}
