package cc.DpAndRecursion;

import java.util.*;

//47. Permutations II
public class PermutationsII {

    private static Set<List<Integer>> helper(int num, List<Integer> src){

        Set<List<Integer>> set = new HashSet<>();
        for(int i = 0; i <= src.size(); i++){
            List<Integer> temp = new LinkedList<>();
            temp.addAll(src);
            temp.add(i, num);
            set.add(temp);
        }

        return set;
    }


    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> rst = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();

        List<Integer> first = new ArrayList<>();
        if(nums == null || nums.length == 0){
            return rst;
        }

        first.add(nums[0]);
        set.add(first);



        for(int i = 1; i < nums.length; i++){
            Set<List<Integer>> temp = new HashSet<>();
            for(List<Integer> l: set){

                temp.addAll(helper(nums[i], l));
            }
            set = temp;
        }

        rst.addAll(set);
        return rst;
    }
    public static void main(String[] args) {
        int[] nums = {1,1,3};
        List<List<Integer>> rst = permuteUnique(nums);
        System.out.println(rst);
    }


}
