package cc.DpAndRecursion;

import java.util.ArrayList;
import java.util.List;

//46. Permutations
public class Permutations {

    private static List<List<Integer>> helper(int num, List<Integer> src){

        List<List<Integer>> rst = new ArrayList<>();
        for(int i = 0; i <= src.size(); i++){
            List<Integer> temp = new ArrayList<>();
            temp.addAll(src);
            temp.add(i, num);
            rst.add(temp);
        }

        return rst;
    }


    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> rst = new ArrayList<>();
        List<Integer> first = new ArrayList<>();
        if(nums == null || nums.length == 0){
            return rst;
        }
        first.add(nums[0]);
        rst.add(first);

        for(int i = 1; i < nums.length; i++){
            List<List<Integer>> temp = new ArrayList<>();
            for(List<Integer> l: rst){

                 temp.addAll(helper(nums[i], l));
            }
            rst = temp;
        }
        return rst;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> rst = permute(nums);
        System.out.println(rst);
    }
}
