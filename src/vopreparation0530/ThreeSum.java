package vopreparation0530;

import java.util.*;

// 15
public class ThreeSum {

    public static List<Integer> twoSum(int[] nums, int idx){
        int l = 0, r = nums.length - 1;
        int expected = 0 - nums[idx];
        List<Integer> s = new ArrayList<>();

        while(l < r){
            if(l == idx){
                l ++;
                continue;
            }
            if(r == idx){
                r--;
                continue;
            }
            int sum  = nums[l] + nums[r];
            if( sum == expected){
                s.add(nums[l]);
                s.add(nums[r]);
                s.add(nums[idx]);
                break;
            }
            else if(sum > expected){
                r--;
            }
            else l++;
        }
        return s;
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> rst = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++){
            List<Integer> temp = twoSum( nums, i);
            if(!temp.isEmpty()){
                set.add(temp);
            }
        }
        for(List s: set){
            rst.add(s);
        }

        return rst;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> rst = threeSum(nums);
        System.out.println(rst);
    }
}
