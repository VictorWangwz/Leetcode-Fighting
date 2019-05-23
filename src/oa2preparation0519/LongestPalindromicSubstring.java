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
    public static int findPalindrome(String inputStream, int s, int e){
        while(s >=0 && e <inputStream.length()&&inputStream.charAt(s) ==  inputStream.charAt(e)){
            s --;
            e ++;
        }
        return (e - 1) - (s + 1) + 1;
    }

    public static String longestPalindrome2(String inputStream) {
        if(inputStream == null || inputStream.length() <= 1) return inputStream;
        int s = 0, e = 0;
        int maxLen =  Integer.MIN_VALUE;
        for(int i = 0; i < inputStream.length(); i++){
            int l1 = findPalindrome(inputStream, i, i);
            int l2 = findPalindrome(inputStream, i, i + 1);
            int maxLenTemp = l1 > l2 ? l1: l2;
            if(maxLenTemp > maxLen){
                s = i - (maxLenTemp-1) / 2;
                e = s + maxLenTemp - 1;
                maxLen = maxLenTemp;
            }
        }
        return inputStream.substring(s, e + 1);
    }

    public static void main(String[] args) {
        String input = "abcdcbaxyx";
        String rst = longestPalindrome(input);
        System.out.println(rst);
    }
}
