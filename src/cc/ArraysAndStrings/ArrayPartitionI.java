package cc.ArraysAndStrings;

import java.util.Arrays;

//561. Array Partition I
public class ArrayPartitionI {

    public int arrayPairSum(int[] nums) {
        int rst = 0;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i += 2){
            rst += nums[i];
        }
        return rst;
    }
}
