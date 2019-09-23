import java.util.Arrays;
import java.util.Comparator;

//354
public class RussianDollEnvelopes {
    public static int maxEnvelopes(int[][] envelopes) {
        if(envelopes == null || envelopes.length == 0)
            return 0;
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int[] dp = new int[envelopes.length];
        dp[0] = 1;
        for(int i = 1; i < envelopes.length; i++){
            int max = 1;
            for(int j = 0; j < i; j++){
                if(envelopes[i][0]> envelopes[j][0] &&envelopes[i][1] >  envelopes[j][1] && max < dp[j] + 1){
                    max = dp[j] + 1;
                }
            }
            dp[i] = max;
        }
        int max = 0;
        for(int i: dp){
            if(i > max){
                max = i;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[][] envelopes = {{7,8},{12,16},{12,5},{1,8},{4,19},{3,15},{4,10},{9,16}};
        int rst = maxEnvelopes(envelopes);
        System.out.println(rst);
    }
}
