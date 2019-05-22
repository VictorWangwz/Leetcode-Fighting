package oa2preparation0519;

public class LongestPalindromicSubstring {

    // 2-for
    public static String longestPalindrome(String s) {
        int rst = 1, start = 0, end = 0;
        int len = s.length();
        if(len <= 1) return s;
        boolean[][] matrix = new boolean[s.length()][s.length()];
        for(int i = 0; i < len; i++) matrix[i][i] = true;
        for(int i = len - 2; i >= 0 ; i--){
            for(int j = i + 1; j < len; j++){
                if(j == i + 1){
                    matrix[i][j] = s.charAt(i) == s.charAt(j);
                    if(matrix[i][j] && j - i + 1 > rst){
                        rst = j - i + 1;
                        start = i;
                        end = j;
                    }
                }
                else{
                    if(matrix[i + 1][j - 1] && s.charAt(i) == s.charAt(j)){
                        matrix[i][j] = true;
                        if(j - i + 1 > rst){
                            rst = j - i + 1;
                            start = i;
                            end = j;
                        }
                    }
                }
            }
        }
        return s.substring(start, end + 1);
    }

    // recursion
    public static int findSubstring(String s, int i, int j){
        while(i >=0 && j < s.length() && s.charAt(i) ==  s.charAt(j)){
            i--;
            j++;
        }
        return j - i + 1 -2;
    }


    public static String longestPalindrome2(String s) {
        if(s.length() <= 1) return s;
        String rst = "";
        int start =0, end = 0;
        for(int i = 0; i < s.length(); i++){
            int l1 = findSubstring(s, i, i);
            int l2 = findSubstring(s, i, i+1);
            int len = l1>l2?l1:l2;
            if (len>end-start){
                start = i -(len-1)/2;
                end = i + len/2;
            }
        }
        return s.substring(start, end + 1);
    }

    public static void main(String[] args) {
        String input = "cbbd";
        String rst = longestPalindrome2(input);
        System.out.println(rst);
    }
}
