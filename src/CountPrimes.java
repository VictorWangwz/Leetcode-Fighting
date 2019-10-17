//204. Count Primes

public class CountPrimes {

    public int countPrimes(int n) {
        int rst = 0;
        if(n < 2){
            return rst;
        }
        int[] dp = new int[n];
        for( int i = 2; i < n; i++){
            if(dp[i] == 0){
                for( int j = 2; i * j < n; j++){
                    dp[j * i] = 1;
                }
            }
        }
        for(int i = 2; i < n ; i++){
            if(dp[i] == 0){
                rst ++;
            }
        }
        return rst;
    }

    public static void main(String[] args) {

        CountPrimes countPrimes = new CountPrimes();
        int n = 100;
        int rst = countPrimes.countPrimes(n);
        System.out.println(rst);
    }
}
