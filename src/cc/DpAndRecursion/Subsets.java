package cc.DpAndRecursion;

import java.util.ArrayList;
import java.util.List;

//78. Subsets
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> rst = new ArrayList<>();
        rst.add(new ArrayList<>());
        if(nums == null || nums.length == 0){
            return rst;
        }
        for(int num: nums){
            List<List<Integer>> temps = new ArrayList<>();
            for(List<Integer> l: rst){
                List<Integer> temp = new ArrayList<>();
                temp.addAll(l);
                temp.add(num);
                temps.add(temp);
            }
            rst.addAll(temps);
        }
        return rst;
    }
}
