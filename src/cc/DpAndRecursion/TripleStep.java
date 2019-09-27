package cc.DpAndRecursion;
//Triple Step: A child is running up a staircase with n steps and can hop either 1 step, 2 steps, or 3
//steps at a time. Implement a method to count how many possible ways the child can run up the
//stairs.
public class TripleStep {

    public static int tripleStep(int n){
        if(n <= 0 ){
            return 0;
        }
        int dp1 = 1, dp2 = 2, dp3 = 4;
        switch (n){
            case 1:
                return dp1;
            case 2:
                return dp2;
            case 3:
                return dp3;
            default: {
                for( int i = 4; i <= n; i++){
                    int dp = dp3 + dp2 + dp1;
                    dp1 = dp2;
                    dp2 = dp3;
                    dp3 = dp;
                }
                return dp3;
            }

        }
    }

    public static void main(String[] args) {
        int i = 4;
        int rst = tripleStep(4);
        System.out.println(rst);
    }
}
