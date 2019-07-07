//91
public class DecodeWays {
    public static int count2(String s){
        int val = (s.charAt(0) - '0') * 10 + (s.charAt(1) - '0');
        if(val % 10 == 0){
            if(val == 10 || val == 20){
                return 1;
            }
            else return 0;
        }
        if( val > 10 && val <=26 ) return 2;
        return 1;
    }
    public static int numDecodings(String s) {
       int[] dp = new int[s.length()];
       if(s.length() == 0 ){
           return 0;
       }
        if(s.charAt(0) == '0'){
            return 0;
        }
        if(s.length() == 1) return 1;
        int rst = 0;
        if(s.length() == 2){
           return count2(s);
        }
        dp[0] = 1;
        dp[1] = count2(s.substring(0, 2));
        for(int i = 2; i < s.length(); i++){
            if(s.charAt(i) == '0'){
                char temp = s.charAt(i - 1);
                if(temp == '1' || temp == '2')
                    dp[i] = dp[i - 2];
                else
                    return 0;
            }else{
                String temp = s.substring(i - 1, i + 1);
                int count = count2(temp);
                if(count == 0 ){
                    dp[i] = dp[i - 2];
                }else if(count == 1) {
                    dp[i] = dp[i - 1];
                }else{
                    dp[i] = dp[i - 1 ] + dp[i - 2];
                }
            }
        }
        return dp[s.length() - 1];
    }

    public static void main(String[] args) {
        String s = "301";
        int rst = numDecodings(s);
        System.out.println(rst);
    }
}
