package cc.ArraysAndStrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//713. Subarray Product Less Than K
public class SubarrayProductLessThanK {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        if( k <= 1){
            return 0;
        }
        int prod = 1, rst = 0, l = 0, r = 0;
        for(; r < nums.length; r++){
            prod *= nums[r];
            while(prod >= k){
                prod /= nums[l++];
            }
            rst += r - l + 1;
        }
        return rst;
    }

    public static void main(String[] args) {
        int[] nums = {10, 5, 2, 6};
        int k  = 100;
        SubarrayProductLessThanK  subarrayProductLessThanK = new SubarrayProductLessThanK();
        int rst = subarrayProductLessThanK.numSubarrayProductLessThanK(nums, k);
        System.out.println(rst);
    }
}
