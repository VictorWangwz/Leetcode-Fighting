package cc.ArraysAndStrings;
//209. Minimum Size Subarray Sum
public class MinimumSizeSubarraySum {

    public int minSubArrayLen(int s, int[] nums) {
        int st = 0, e = 1;
        int rst = Integer.MAX_VALUE;
        int sum = 0;
        for(; e <= nums.length; e++){
            if(sum >= s){
                rst = e-1 - st < rst? e-1 - st : rst;

                while(st < e-1 && sum - nums[st] >= s ){
                    sum -= nums[st];
                    st++;
                    rst = e-1 - st < rst? e-1 - st : rst;
                }
            }
            sum += nums[e - 1];
        }
        if(sum >= s){
            rst = e-1 - st < rst? e-1 - st : rst;

            while(st < e-1 && sum - nums[st] >= s ){
                sum -= nums[st];
                st++;
                rst = e-1 - st < rst? e-1 - st : rst;
            }
        }
        if(rst == Integer.MAX_VALUE){
            return 0;
        }
        return rst;
    }

    public static void main(String[] args) {
        int s = 7;
        int[] nums = {2,3,1,2,4,3};
        MinimumSizeSubarraySum minimumSizeSubarraySum = new MinimumSizeSubarraySum();
        int rst = minimumSizeSubarraySum.minSubArrayLen(s, nums);
        System.out.println(rst);
    }
}
