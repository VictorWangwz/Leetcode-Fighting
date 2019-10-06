package cc.ArraysAndStrings;

import java.lang.reflect.Array;
import java.util.Arrays;

//300. Longest Increasing Subsequence
public class LongestIncreasingSubsequence {

    public static int lengthOfLIS(int[] nums) {

        if(nums == null || nums.length == 0){
            return 0;
        }

        int n = nums.length;
        int[] help = new int[n];
        for(int i = 0; i < n; i++ ){
            help[i] = 1;
        }
        int rst = 1;
        for( int i = n - 1; i >=0 ; i--){
            int max = 0;
            for( int j = i + 1; j < n; j++){
                if(nums[i] < nums[j] && help[j] > max){
                    max = help[j];
                }
                if( j  == n - 1){
                    help[i] += max;
                    break;
                }
            }
            if(rst < help[i]){
                rst = help[i];
            }

        }
        return rst;

    }

    public static void main(String[] args) {
        int[] nums = {-2, -1};
        int rst = lengthOfLIS(nums);
        System.out.println(rst);
    }
}
