package cc.BitManipulation;
//136. Single Number
public class SingleNumber {
    public int singleNumber(int[] nums) {
        int rst;
        rst = nums[0];
        for(int i = 1; i < nums.length; i++){
            rst ^= nums[i];
        }
        return rst;
    }
}
