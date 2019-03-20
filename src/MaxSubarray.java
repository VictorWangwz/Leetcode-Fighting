public class MaxSubarray {
    public int maxSubArray(int[] nums) {
        if(nums==null || nums.length==0)
            return 0;
        int t1 = nums[0];
        int t2 = nums[0];
        for(int i=1;i<nums.length;i++)
        {
            t1 = Math.max(nums[i],t1+nums[i]);
            t2 = Math.max(t1,t2);
        }
        return t2;
    }

    public static void main(String[] args) {
        MaxSubarray m = new MaxSubarray();
        int[] nums = {
                -2,1,-3,4,-1,2,1,-5,4
        };

        System.out.print(m.maxSubArray(nums));
    }
}
