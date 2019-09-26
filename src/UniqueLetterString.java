//828. Unique Letter String

//todo time complexity
public class UniqueLetterString {
    public static int uniqueNum(String s){
        int[] charNums = new int[26];
        for(char c: s.toCharArray()){
            int idx = (c - 'A');
            charNums[idx] += 1;
        }
        int rst = 0;
        for( int num: charNums){
            if(num == 1){
                rst += 1;
            }
        }
        return rst;
    }


    public static int uniqueLetterString(String S) {
        if(S == null || S.length() == 0){
            return 0;
        }
        int[] dp = new int[S.length()];
        dp[0] = 1;
        for( int i = 1; i < S.length(); i ++){
            dp[i] = dp[i - 1] + 1;
            for(int j = 0; j < i; j++){
                dp[i] += uniqueNum(S.substring(j, i + 1));
            }
        }
        return dp[dp.length - 1];

    }

    public static void main(String[] args) {
        String S = "ABA";
        int rst = uniqueLetterString(S);
        System.out.println(rst);
    }
}
