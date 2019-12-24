package cc.ArraysAndStrings;

import java.util.HashMap;
import java.util.Map;

//1. Two Sum
public class TwoSum {
//    public int[] twoSum(int[] nums, int target){
//        Arrays.sort(nums);
//        int l = 0, r = nums.length - 1;
//        while(l < r){
//            if(nums[l] + nums[r] == target){
//                return new int[]{l, r};
//            }
//            else if(nums[l] + nums[r] > target){
//                r--;
//            }
//            else{
//                l++;
//            }
//        }
//        return new int[]{-1,-1};
//    }
public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for(int i=0; i< nums.length; i++){
        if(map.containsKey(nums[i])){
            return new int[]{map.get(nums[i]), i};
        }
        int res = target - nums[i];
        map.put(res, i);
    }
    return new int[]{-1,-1};
}

    public static void main(String[] args) {
        int[] nums = {3,2,4};
        int target = 6;
        TwoSum twoSum = new TwoSum();
        int[] rst = twoSum.twoSum(nums, target);
        System.out.println(rst);
    }
}
