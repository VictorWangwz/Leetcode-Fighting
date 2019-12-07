package cc.ArraysAndStrings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//525. Contiguous Array
public class ContiguousArray {

    //time limit exceed
    public int findMaxLength0(int[] nums) {
        int numZero = 0, numOne = 0;
        for(int num : nums){
            if(num == 0){
                numZero ++;
            }
            else{
                numOne ++;
            }
        }

        return help(0, nums.length - 1, numZero, numOne, nums);
    }

    private int help(int l, int r, int numZero, int numOne, int[] nums){
        if(l >= r){
            return 0;
        }
        if(numZero == numOne){
            return 2 *numZero;
        }
        int rst = Integer.MIN_VALUE;
        if(nums[l] == 0){
            rst = Math.max(rst, help(l + 1, r, numZero - 1, numOne, nums) );
        }
        else{
            rst = Math.max(rst, help(l + 1, r, numZero, numOne - 1, nums) );
        }
        if(nums[r] == 0){
            rst = Math.max(rst, help(l, r - 1, numZero - 1, numOne, nums) );
        }else{
            rst = Math.max(rst, help(l, r - 1, numZero, numOne - 1, nums) );
        }
        return rst;

    }

    //accepted
    public int findMaxLength(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int[] dp = new int[nums.length];
        int rst = 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        if(nums[0] == 0){
            dp[0] = -1;
        }
        else{
            dp[0] = 1;
        }
        map.put(dp[0], new ArrayList<>());
        map.get(dp[0]).add(0);
        for(int i = 1; i < nums.length; i++){
            if(nums[i] == 0){
                dp[i] = dp[i - 1] - 1;
            }
            else{
                dp[i] = dp[i - 1] + 1;
            }
            if(dp[i] == 0){
                rst = i + 1;
            }
            if(!map.containsKey(dp[i])){
                map.put(dp[i], new ArrayList<>());
            }
            map.get(dp[i]).add(i);
        }
        for(Map.Entry<Integer, List<Integer>> e: map.entrySet()){
            List<Integer> l = e.getValue();
            rst = Math.max((l.get(l.size() - 1) - l.get(0) ), rst);
        }
        return rst;


    }
}
