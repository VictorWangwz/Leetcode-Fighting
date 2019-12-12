package cc.ArraysAndStrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//18. 4Sum
public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> rst = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                int tmp = target - nums[i] - nums[j];
                int l = j + 1, h = nums.length - 1 ;
                while(l < h){
                    List<Integer> tempL = new ArrayList<>();
                    if(nums[l] + nums[h] == tmp){
                        tempL = Arrays.asList( nums[i],nums[j],nums[l++],nums[h--]);
                        if(!rst.contains(tempL)){
                            rst.add(tempL);
                        }
                    }else if(nums[l] + nums[h] < tmp){
                        l++;
                    }
                    else{
                        h--;
                    }
                }
            }

        }
        return rst;
    }
}
