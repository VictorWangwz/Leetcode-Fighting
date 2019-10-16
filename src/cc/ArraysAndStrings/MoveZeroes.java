package cc.ArraysAndStrings;
//283. Move Zeroes
public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int j = 0, i = 0;
        for(; i < nums.length; i++){
            if(nums[i] != 0){
                nums[j++] = nums[i];
            }
        }
        for(; j < nums.length; j++){
            nums[j] = 0;
        }
        return ;
    }
}
