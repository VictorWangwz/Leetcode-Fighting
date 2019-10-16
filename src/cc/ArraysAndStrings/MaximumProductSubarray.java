package cc.ArraysAndStrings;
//152. Maximum Product Subarray
public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int rst = Integer.MIN_VALUE;
        int[] maxDp = new int[nums.length];
        int[] minDp = new int[nums.length];
        maxDp[0] = nums[0];
        minDp[0] = nums[0];
        for( int i = 1; i < nums.length; i++){
            maxDp[i] = Math.max(Math.max(maxDp[i - 1] * nums[i], nums[i] ), minDp[i - 1] * nums[i] );
            minDp[i] = Math.min(Math.min(maxDp[i - 1] * nums[i], nums[i] ), minDp[i - 1] * nums[i] );
        }
        for(int i = 0; i < nums.length; i++){
            if(maxDp[i] > rst){
                rst = maxDp[i];
            }
        }
        return rst;

    }
}
