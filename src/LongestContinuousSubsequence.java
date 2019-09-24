//674
public class LongestContinuousSubsequence {
    public static int findLengthOfLCIS(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return 1;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] <= nums[i - 1]){
                dp[i] = 1;
                continue;
            }
            else{
                    dp[i] = dp[i - 1] + 1;
            }
            }
        int rst = Integer.MIN_VALUE;
        for(int i: dp){
            rst = Math.max(rst, i);
        }
        return rst;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,8,0};
        int rst = findLengthOfLCIS(nums);
        System.out.println(rst);
    }
}
