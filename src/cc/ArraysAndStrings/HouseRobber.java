package cc.ArraysAndStrings;
//198. House Robber
public class HouseRobber {

    public int rob(int[] nums) {
        int pre = 0;
        int cur = 0;
        for(int num: nums){
            int tmp = cur;
            cur = Math.max(pre + num, cur);
            pre = tmp;
        }
        return cur;
//        if(nums == null || nums.length == 0){
//            return 0;
//        }
//        int n = nums.length;
//        if(nums.length == 1){
//            return nums[0];
//        }
//        if(nums.length == 2){
//            return Math.max(nums[0], nums[1]);
//        }
//        int[] dp = new int[nums.length];
//        dp[0] = nums[0];
//        dp[1] = nums[1];
//        for(int i = 2; i < nums.length; i++){
//            dp[i] = nums[i];
//            int tmp = Integer.MIN_VALUE;
//            for(int j = 0; j < i - 1; j++){
//                if(tmp < dp[j]){
//                    tmp = dp[j];
//                }
//            }
//            dp[i] += tmp;
//        }
//
//        int rst = Integer.MIN_VALUE;
//        for(int i = 0 ; i < dp.length; i++){
//            if(rst < dp[i]){
//                rst = dp[i];
//            }
//        }
//        return rst;
    }

    public static void main(String[] args) {
        int[] nums = {2,7,9,3,1};
        HouseRobber houseRobber = new HouseRobber();
        int rst = houseRobber.rob(nums);
        System.out.println(rst);
    }
}
