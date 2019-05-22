package oa2preparation0519;

import java.util.Arrays;

public class MoviesInFlight {

    public static int twoSumClosest(int[] nums, int target) {
        int rst = Integer.MAX_VALUE;
        if(nums.length == 0) return rst;
        int l = 0, h = nums.length - 1;
        Arrays.sort(nums);
        while(l < h){
            int dist = target - nums[l] - nums[h];
            if(dist > 0){
                l++;
                rst = Math.min(dist, rst);
            }
            else{
                h--;
            }
        }
        return rst;
    }
}
