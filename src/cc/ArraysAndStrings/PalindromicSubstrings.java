package cc.ArraysAndStrings;
//647. Palindromic Substrings
public class PalindromicSubstrings {

    public int countSubstrings(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int rst = 0;
        for(int i = s.length() - 1; i >=0; i --){
            for(int j = i; j < s.length() ; j++ ){
                if(i == j){
                    dp[i][j] = true;

                }
                else if(i + 1 == j){
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                }
                else{
                    dp[i][j] = dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
                }
                rst += dp[i][j]? 1:0;

            }

        }
        return rst;


    }

    public static void main(String[] args) {
        String s = "abc";
        PalindromicSubstrings palindromicSubstrings = new PalindromicSubstrings();
        int rst = palindromicSubstrings.countSubstrings(s);
        System.out.println(rst);
    }
}
