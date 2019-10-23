package cc.ArraysAndStrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//39. Combination Sum
public class CombinationSum {

    private void helper(int[] candidates, int idx, int target, List<Integer> list){
        List<Integer> tmp = new ArrayList<>(list);
        tmp.add(candidates[idx]);
        target -= candidates[idx];
        if(target == 0){
            rst.add(tmp);
            return;
        }
        if(target < 0){
            return ;
        }
        for(int i = idx; i < candidates.length; i ++){
            if(candidates[i] <= target){
                helper(candidates, i, target, tmp);
            }

        }
    }

    List<List<Integer>> rst = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        for(int i = 0 ; i < candidates.length; i++){
            if(candidates[i] <= target){
                helper(candidates, i, target, new ArrayList<>());
            }
        }
        return rst;
    }
}
