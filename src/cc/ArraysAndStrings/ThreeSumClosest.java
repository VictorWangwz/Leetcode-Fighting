package cc.ArraysAndStrings;

import java.util.Arrays;

//16. 3Sum Closest
public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closest = Integer.MAX_VALUE;
        int rst = 0;
        for(int i = 0; i < nums.length; i++){
            int l = i, r = nums.length - 1;
            while(l < r){
                if(l == i){
                    l++;
                    continue;
                }
                if(r == i){
                    r--;
                    continue;
                }
                int sum = nums[i] + nums[l] + nums[r];
                if(Math.abs(target - sum) < closest){
                    closest = Math.abs(target - sum);
                    rst = sum;
                }
                if( sum > target){
                    r--;
                }
                else if(sum < target){
                    l++;
                }
                else{
                    return rst;
                }

            }
        }
        return rst;
    }
}
