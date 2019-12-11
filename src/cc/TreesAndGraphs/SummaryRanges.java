package cc.TreesAndGraphs;

import java.util.ArrayList;
import java.util.List;

//228. Summary Ranges
public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> rst = new ArrayList<>();
        if(nums == null || nums.length == 0){
            return rst;
        }

        int min = nums[0], max = nums[0], prev = nums[0];
        if(nums.length == 1){
            rst.add(String.valueOf(min));
            return rst;
        }

        for(int i = 1; i < nums.length; i++){
            if(nums[i] == prev + 1){
                max = nums[i];
                prev = nums[i];
                if(i == nums.length - 1){
                    rst.add(String.valueOf(min) + "->" + String.valueOf(max));
                }
                continue;
            }
            else{
                if(min == max){
                    rst.add(String.valueOf(max));
                }else{
                    rst.add(String.valueOf(min) + "->" + String.valueOf(max));
                }

                min = nums[i];
                max = nums[i];
                prev = nums[i];
                if(i == nums.length - 1){
                    rst.add( String.valueOf(max));
                }
            }
        }
        return rst;
    }
}